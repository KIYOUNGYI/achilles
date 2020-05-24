package com.glowpick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(Application.class);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.close();
        entityManagerFactory.close();
        app.run(args);
    }
}
