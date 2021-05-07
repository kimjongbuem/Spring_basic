package kr.co.fastcampus.web.config.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("kr.co.fastcampus.web.controller")
public class MvcConfig {
}
