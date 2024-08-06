package com.example.CojadanProject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SecondController {

    @GetMapping("/random-quote")
    public String randomQuote(Model model){
        String[] quotes = {
                "나는 신동웅이다. "+
                        "스프링 공부중이다. ",
                "나는 홍의정이다. "+
                        "스프링 하는척한다. ",
                "나는 최경찬이다. "+
                        "나는 핫딜의신이다. "
        };
        int randInt =(int)(Math.random()*quotes.length);
        model.addAttribute("randomQuote",quotes[randInt]);
        return "quote";
    }
}
