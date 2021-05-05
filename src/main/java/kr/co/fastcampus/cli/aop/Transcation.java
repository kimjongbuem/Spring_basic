package kr.co.fastcampus.cli.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Aspect
public class Transcation {


    private final Connection connection;

    public Transcation(Connection connection){
        this.connection = connection;
    }
    @Pointcut("execution(* kr.co.fastcampus.cli.Dao.insert())")
    public void transactionPointCut(){

    }

    @Around("transactionPointCut()")
    public Object aroundLog(ProceedingJoinPoint pjp) throws SQLException {
        log.info("before tran");
        var statement = connection.createStatement();
        connection.setAutoCommit(false);
        try{
            Object proceed = pjp.proceed();
            log.info("commit");
            connection.commit();
        }catch(Throwable throwable){
            log.info("rollback..");
        }
        log.info("after tran");

        return null;
    }

    public void beforeLog(){
        log.info("before....");
    }
    public void afterLog(){
        log.info("after....");
    }
    public void afterReturning(){
        log.info("returning....");
    }
    public void afterThrowing(){
        log.info("throwing....");
    }
}
