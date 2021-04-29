package kr.co.fastcampus.cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    String url;
    String password;
    String user;

    public ConnectionFactory(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
