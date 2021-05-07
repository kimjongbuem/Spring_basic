package kr.co.fastcampus.web.service;

import kr.co.fastcampus.web.dao.MemberDao;
import kr.co.fastcampus.web.entity.Member;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MemberService {
    private MemberDao memberDao;
    public void insert(String username, String password){
        //비지니스로직들//
        //비지니스로직들////비지니스로직들//
        //비지니스로직들//
        //비지니스로직들//
        memberDao.insert(username, password);
        //rollback//
        //비지니스로직들//
        //비지니스로직들//
    }
    public List<Member> print(){
        return memberDao.print();
    }
}
