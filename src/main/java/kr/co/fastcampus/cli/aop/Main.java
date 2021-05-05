package kr.co.fastcampus.cli.aop;

import kr.co.fastcampus.cli.Dao;
import kr.co.fastcampus.cli.service.AopService;
import org.h2.index.PageDataOverflow;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
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
