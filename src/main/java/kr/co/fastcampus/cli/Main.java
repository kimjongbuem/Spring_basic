package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.sql.SQLException;

@Slf4j
class Main {
	public static void main(String[] args) throws SQLException {
		log.info("Hello world!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
		Dao dao = context.getBean("dao", Dao.class);
		dao.run();

	}
}