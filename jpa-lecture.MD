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

eㅡ.ㅇㄷㅅㅁ
