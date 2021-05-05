package kr.co.fastcampus.cli.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class Transcation {

    private Connection connection;

    public Transcation(Connection connection){
        this.connection = connection;
    }

    public void aroundLog(ProceedingJoinPoint pjp) throws SQLException {
        log.info("before tran");
        var statement = connection.createStatement();
        connection.setAutoCommit(false);
        try{
            Object proceed = pjp.proceed();
            log.info("returning..");
        }catch(Throwable throwable){
            log.info("throwable..");
        }
        log.info("after....");
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
