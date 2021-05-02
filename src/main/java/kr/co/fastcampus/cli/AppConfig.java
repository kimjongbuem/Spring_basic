package kr.co.fastcampus.cli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "kr.co.fastcampus.cli")
public class AppConfig {
    @Bean
    public B b(){return new B();}

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public A a(B b){
        return new A(b);
    }
}
