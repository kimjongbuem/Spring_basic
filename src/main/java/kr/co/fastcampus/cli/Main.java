package kr.co.fastcampus.cli;

import kr.co.fastcampus.cli.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j

//@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes = B.class))
//, excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX, pattern = "kr.co.fastcampus.cli.B")
class Main {
	public static void main(String[] args) throws SQLException {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(AppConfig.class);
		context.refresh();
		MyService myService = context.getBean(MyService.class);

		myService.check();
		context.close();

	}
}