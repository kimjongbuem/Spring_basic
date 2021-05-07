package kr.co.fastcampus.web.dao;

import kr.co.fastcampus.web.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Component
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insert(String username, String password) throws SQLException {
//        var statement = DataSourceUtils.getConnection(dataSource).createStatement();
//        statement.executeUpdate("insert into member(username, password) values('boojongmin', '1234')");
        jdbcTemplate.update("insert into member(username, password) values(?, ?)" , username, password);
       // throw new RuntimeException("");
    }

    public void print() throws SQLException {
//        var statement = DataSourceUtils.getConnection(dataSource).createStatement();
//
//
//            var resultSet = statement.executeQuery("select id, username, password from member");
//            while (resultSet.next()) {
////				var member = new Member(resultSet);
//                var member = new Member("boojongmin", "1234");
//                log.info(member.toString());
//            }
        List<Member> list = jdbcTemplate.query("select id, username, password from member", (resultSet, i) -> new Member(resultSet));
        list.forEach(x -> log.info(">> Member) " + "username : " + x.getUsername() + " " + "password : " + x.getPassword()));
    }

}

