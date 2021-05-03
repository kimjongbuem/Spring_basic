package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Component
public class Dao {

    private final Connection connection;
    public Dao(Connection connection){
        this.connection = connection;
    }

    public void run() throws SQLException {

        try (var statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
            try {
                statement.executeUpdate("insert into member(username, password) values('boojongmin', '1234')");
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

            var resultSet = statement.executeQuery("select id, username, password from member");
            while (resultSet.next()) {
//				var member = new Member(resultSet);
                var member = new Member("boojongmin", "1234");
                log.info(member.toString());
            }
        }
    }
}
