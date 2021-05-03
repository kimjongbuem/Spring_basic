package kr.co.fastcampus.cli;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.sql.Connection;

@Configuration
@Profile("default | dev")
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class AppConfig {
    @Bean
    public B b(){return new B();}

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public A a(B b){
        return new A(b);
    }

    @Bean
    public Connection connection(ConnectionFactory connectionFactory){
        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection){
        return new Dao(connection);
    }

    @Bean
    public ConnectionFactory connectionFactory(
            @Value("${jdbc.driver-class}") String driver,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password
    ){
        return new ConnectionFactory(driver, url, username, password);
    }




}