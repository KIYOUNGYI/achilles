package com.component;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서비스에 자주 쓰이는 config, util, repository 공통화...
 */
@Component
public class ServiceComponent
{

    @PersistenceContext
    protected EntityManager entityManager;
//    @Autowired
//    protected JPAQueryFactory jpaQueryFactory;
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;


}
