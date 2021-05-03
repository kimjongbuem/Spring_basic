package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Slf4j
@Component
public class A {
    A(B b){
        this.b = b;
    }

//    @Qualifier("b1")
   private B b; //@Inject
    //@Resource private B b;
    @Value("${catalog.name}") String cName; // #{systemProperties['java.home']}
    //    @Autowired
//    public A(B b){
//        this.b = b;
//    }
    @PostConstruct
    public void init(){
        log.info("postconstructor init");
    }

    @PreDestroy
    public void destroy(){
        log.info("postconstructor destroy");
    }



}
