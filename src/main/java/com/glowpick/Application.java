package com.glowpick;

import com.glowpick.domain.Member;
import com.glowpick.domain.RoleType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

//@SpringBootApplication
public class Application
{
    public static void main(String[] args)
    {
//        SpringApplication app = new SpringApplication(Application.class);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        // 쓰레드 안에 공유(x) => 공유하면 장애나~
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        createDummy(entityManager, entityTransaction, entityManagerFactory);
//        retrieveDummy(entityManager, entityTransaction, entityManagerFactory);
//        updateDummy(entityManager, entityTransaction, entityManagerFactory);
//        retrieveDummyByJpql(entityManager, entityTransaction, entityManagerFactory);
//        app.run(args);
    }

    private static void updateDummy(EntityManager entityManager, EntityTransaction entityTransaction, EntityManagerFactory entityManagerFactory)
    {
//        entityManager를 collection 으로 이해하면 편함.
        entityTransaction.begin();
        try
        {
            Member findMember = entityManager.find(Member.class,1l);
            findMember.setUsername("hello modified");
            System.out.println("findMember:"+findMember.toString());
            //entityManager.remove(1l); delete
            entityTransaction.commit();
        }
        catch (Exception e)
        {
            entityTransaction.rollback();
        }
        finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }


    private static void retrieveDummyByJpql(EntityManager entityManager, EntityTransaction entityTransaction, EntityManagerFactory entityManagerFactory)
    {
        entityTransaction.begin();
        try
        {
            List<Member> result = entityManager.createQuery("select m from Member as m",Member.class).getResultList();

            for(Member member:result)
            {
                System.out.println("member.name =  "+member.getUsername());
            }

        }
        catch (Exception e)
        {
            entityTransaction.rollback();
        }
        finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }

    private static void retrieveDummy(EntityManager entityManager, EntityTransaction entityTransaction, EntityManagerFactory entityManagerFactory)
    {
        entityTransaction.begin();
        try
        {
            Member findMember = entityManager.find(Member.class,1l);
            System.out.println("findMember:"+findMember.toString());
        }
        catch (Exception e)
        {
            entityTransaction.rollback();
        }
        finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }

    private static void createDummy(EntityManager entityManager,EntityTransaction entityTransaction,EntityManagerFactory entityManagerFactory)
    {
        entityTransaction.begin();
        // 정석이지만 이걸 스프링에서 해줌
        try
        {
            // 비영속
            Member member = new Member();
//            member.setId(1l);
            member.setUsername("Hello10");

            // 영속
            System.out.println("==============");
            entityManager.persist(member);
            System.out.println("==============");
            // 준영속 (엔티티매니저에서 떼어버리는 것)
//            entityManager.detach(member);
            // 삭제
//            entityManager.remove(member);
//            entityManager.flush();//db 반영
            entityTransaction.commit();
        }
        catch (Exception e)
        {
            System.out.println("createDummy exception:" + e);
            entityTransaction.rollback();
        }
        finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
