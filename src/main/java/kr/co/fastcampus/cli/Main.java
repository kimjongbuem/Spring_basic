package kr.co.fastcampus.cli;

import kr.co.fastcampus.cli.aop.Transcation;
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
		context.register(Transcation.class);
		context.refresh();

		createTable(context.getBean(Connection.class));
		Dao dao = context.getBean(Dao.class);

		dao.insert();
		dao.print();
		context.close();

	}
	public static void createTable(Connection connection) throws SQLException {
		connection.createStatement().execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");

	}
}