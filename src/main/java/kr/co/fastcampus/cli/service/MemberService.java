package kr.co.fastcampus.cli.service;

import kr.co.fastcampus.cli.dao.MemberDao;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class MemberService {
    private MemberDao memberDao;
    public void insert(String username, String password) throws SQLException {
        //비지니스로직들//
        //비지니스로직들////비지니스로직들//
        //비지니스로직들//
        //비지니스로직들//
        memberDao.insert(username, password);
        //rollback//
        //비지니스로직들//
        //비지니스로직들//
    }
    public void print() throws SQLException {
        memberDao.print();
    }
}
