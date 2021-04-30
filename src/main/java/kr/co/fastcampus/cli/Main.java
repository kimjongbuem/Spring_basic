package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
class Main {
	public static void main(String[] args) throws SQLException {
		log.info("Hello world!!");
//		ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml" );
//		C a2 = context.getBean("C", C.class);
//		C a1 = context.getBean("C", C.class);
//		log.info("result = " + (a1 == a2));

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml" );

		ConnectionFactory factory = context.getBean(ConnectionFactory.class);
		Connection connection = factory.getConnection();
		if(connection!=null)
		log.info("connection not null");

//		log.info(">> 1 : " +  )
//		context.close();


	}
}