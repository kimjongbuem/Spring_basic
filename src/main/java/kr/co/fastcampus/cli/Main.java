package kr.co.fastcampus.cli;

import kr.co.fastcampus.cli.config.AppConfig;
import kr.co.fastcampus.cli.controller.MemberController;
import kr.co.fastcampus.cli.dao.MemberDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

@Slf4j

//@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes = B.class))
//, excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX, pattern = "kr.co.fastcampus.cli.B")
class Main {
	public static void main(String[] args) throws SQLException {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(AppConfig.class);
		context.refresh();

		createTable(context.getBean(DataSource.class).getConnection());
		MemberDao dao = context.getBean(MemberDao.class);
		System.out.println("==============사용자의 username, password input ================");

		Scanner sc = new Scanner(System.in);

		System.out.println("username : ");
		String username = sc.nextLine();

		System.out.println("password : ");
		String password = sc.nextLine();

		MemberController memberController = context.getBean(MemberController.class);
		memberController.insert(username, password);
		memberController.print();
		context.close();

	}
	public static void createTable(Connection connection) throws SQLException {
		connection.createStatement().execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");

	}
}