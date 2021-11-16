package com.senla;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Aspect
@Component
public class TransactionalAspect {

    private final Connection connection;

    public TransactionalAspect(Connection connection) {
        this.connection = connection;
    }

    @Around("@within(com.senla.annotation.Transactional) || @annotation(com.senla.annotation.Transactional)")
    public Object runInTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            connection.setAutoCommit(false);
            Object object = joinPoint.proceed();
            connection.commit();
            return object;
        } catch (RuntimeException e) {
            connection.rollback();
            throw e;
        } catch (Exception e) {
            connection.commit();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}




