package com.example.CojadanProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FirstController {

    @GetMapping("/hi") //Controller에서 연결한 뷰의 표시하고자하는 링크
    public String niceToMeetYou(Model model){
        model.addAttribute("username","스프링");
        return "greeting";//자동적으로 greetings.mustache의 뷰를 반환해줌
    }
    @GetMapping("/bye")
    public String goodbye(Model model){
        model.addAttribute("endname","스프링");
        return "goodbye";
    }

}
