package kr.co.fastcampus.cli;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class ConnectionFactory {

    String driverName;
    String url;
    String password;
    String user;
    @Getter
    private Connection connection = null;

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

    public void init() throws Exception {
        log.info("init");
        this.connection = createConnection();
    }

    public void destroy(){
        log.info("destroy");
    }

}
