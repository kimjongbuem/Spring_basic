package kr.co.fastcampus.web.dao;

import kr.co.fastcampus.web.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    void init(){
        jdbcTemplate.update("create table member(id int auto_increment, username varchar(255) not null, password varchar(255))");
        jdbcTemplate.update("insert into member(username, password) values('kjb', '12345')");
    }


    @Transactional
    public void insert(String username, String password) {
        jdbcTemplate.update("insert into member(username, password) values(?, ?)" , username, password);
       // throw new RuntimeException("");
    }

    public List<Member> print(){
        return jdbcTemplate.query("select id, username, password from member", (resultSet, i) -> new Member(resultSet));
    }

}

