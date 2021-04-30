package kr.co.fastcampus.cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    String driverName;
    String url;
    String password;
    String user;

    public ConnectionFactory(String driverName, String url, String user, String password){
        this.driverName = driverName;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
