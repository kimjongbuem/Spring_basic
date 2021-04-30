package kr.co.fastcampus.testing_autowired;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

// 생성자, 일반 메서드, 필드에서도 가능
@Slf4j
public class A {
    @Autowired @Qualifier("b1")
    private B b; //@Inject
    @Value("${catalog.name}") String cName;
//    @Autowired
//    public A(B b){
//        this.b = b;
//    }
    @PostConstruct
    public void init(){
        log.info("hello");
    }
}
