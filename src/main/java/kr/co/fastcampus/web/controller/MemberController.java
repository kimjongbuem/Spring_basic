package kr.co.fastcampus.web.controller;

import kr.co.fastcampus.web.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    private MemberService memberService;

    @RequestMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello world");
    }
}
