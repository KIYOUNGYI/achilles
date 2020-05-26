영속성 컨텍스트의 이점
    1차 캐시
    동일성 보장(identity)
    트랜잭션을 지원하는 쓰기 지연(transactional write-behind)
    변경 감지(Dirty Checking)
    지연 로딩(Lazy Loading)
    
    
1차 캐시 예(1)
    db에 저장하고
    같은 키로 조회하면 selct 안하고 그대로 캐시에 저장된 데이터 가지고 옴.
    
1차 캐시 예(2)
    select 같은거 2번하면 첫번째는 엔티티매니저에 올리고 그다음엔 캐시에서 가져옴
    
    
현업에서 주는 이점 -> 성능 글쎄? 근데 
컨셉이 주는 이점이 있음 (나중에 설명)

동일성 보장
같은 트랜잭션 안에서 비교하는거 == 나온다. (이정도로 이해해도 무방)


쓰기지연

실전에서는 한꺼번에 인서트 하는경우가 별로 없긴 한데
배치 사이즈 설정해서


엔티티 수정 변경감지 (영어로는 dirty checking)

memberA.setUsername("hi);
memberA.setAge(10);

값만 바꾸는게 정답 (커밋전에 내부적으로 엔티티와 스냅샷 비교하는 일종의 dirty checking 해서 반영함)

플러시
영속성 컨텍스트의 변경내용을 데이터베이스에 반영

PersistenceContext를 플러시하는 방법
    em.flush() - 직접 호출
    트랜잭션 커밋 - 플러시 자동 호출
    JPQL 쿼리 실행 - 플러시 자동 호출

JPQL 쿼리 실행시 플러시가 자동으로 호출되는 이유

em.persist(memberA);
em.persist(memberB);
em.persist(memberC);

//중간에 JPQL 실행
query = em.createQuery("select m from Member m", Member.class);
List<Member> members = query.getResultList();

FlushModeType.AUTO
커밋이나 쿼리를 실행할 때 플러시(기본값)

FlushModeType.COMMIT
커밋할 때만 플러시
위의 옵션은 언제 도움이 될까? 가끔 있다는데 난 이거 그냥 안 쓸란다. 그냥 기본값 쓸래

플러시는!
영속성 컨텍스트를 비우지 않음
영속성 컨텍스의 변경내용을 데이터베이스에 동기화
트랜잭션이라는 작업 단위가 중요 -> 커밋 직전에만 동기화 하면 됨


준영속 상태
영속 -> 준영속
영속 상태의 엔티티가 영속성 컨텍스트에서 분리(detached)
영속 컨텍스트가 제공하는 기능을 사용 못함

데이터베이스 스키마 자동생성 주의 
운영, 개발 서버(여러 명 사용하는) 장비에는 절대 절대 create, create-drop, update 사용하면 진짜 큰일난다.
이기능 쓰지마 그냥, 니가 직접 스크립트로 만들어. 아니면 그 팀에서 사용하는 db 마이그레이션 서비스를 사용하든가.

개발 초기 단계는 create 또는 update (nope)
테스트 서버는 update 또는 validate (하지마)
스테이징과 운영서버는 validate 또는 none (validate 도 쓰지마 제발)

hibernate.hbm2ddl.auto 옵션 
none - 사용하지 않음 (*****)
validate - 엔티티와 테이블이 정상 매핑되었는지만 확인 (*****)
create(기존테이블 삭제 후 다시 생성 (drop+create))
create-drop(create와 같으나 종료시점에 테이블 drop)
update - 변경분만 반영(운영db에는 사용하면 안됨)


@column옵션
nullable = false <- 이건 좀 쓰는 옵션임

columndefinition 안쓸꺼야

@Enumerated(EnumType.STRING)
오디널은 절대 쓰지말자. 왜냐하면
이넘에 데이터 추가하는순간 엿되므로.
원래 user,admin 이면 0,1 로 저장되는데
guest 를 0번으로 추가하면 
0,1,0 이런식으로 저장됨. 진짜 진짜 엿되는거임.


기본 키 제약 조건: null 아님, 유일, 변하면 안딘다.
변하면 안된다 <- 이건 정말 어려움
미래까지 이 조건을 만족하는 자연키는 찾기 어렵다. 대리키(대체키)를 사용하자.

예를 들어 주민등록번호도 기본 키로 적절하지 않다.

권장: Long형 + 대체키 + 키 생성전략 사용

generated value 값이 짱인듯?
auto_increment 값


