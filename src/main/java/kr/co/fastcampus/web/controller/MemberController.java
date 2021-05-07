package kr.co.fastcampus.web.controller;

import kr.co.fastcampus.web.dao.MemberDao;
import kr.co.fastcampus.web.entity.Member;
import kr.co.fastcampus.web.model.MemberDto;
import kr.co.fastcampus.web.service.MemberService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/index")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView("index");
        List<Member> list = memberService.print();
        modelAndView.addObject("members" , list);

        return modelAndView;
    }

    @RequestMapping("/create")
    public String create(MemberDto memberDto){
        ModelAndView modelAndView = new ModelAndView("index");
        memberService.insert(memberDto.getUsername(),memberDto.getPassword());
        return "redirect:index";
    }
}
