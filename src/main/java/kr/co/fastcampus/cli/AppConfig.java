package kr.co.fastcampus.cli;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "kr.co.fastcampus.cli")
@PropertySource("classpath:application.properties")
public class AppConfig {

    //@Bean 추가!!!! -> xml에 설정값 삭제. 같은빈이 있을때 삭제하거나 @Primary를 이용하자!  //
}
