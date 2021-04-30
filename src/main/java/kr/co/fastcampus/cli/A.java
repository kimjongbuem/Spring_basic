package kr.co.fastcampus.cli;

import kr.co.fastcampus.testing_autowired.B;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class A {
//    @Autowired
//    @Qualifier("b1")
//    private B b; //@Inject
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
    public void Destroy(){
        log.info("postconstructor destroy");
    }
}
