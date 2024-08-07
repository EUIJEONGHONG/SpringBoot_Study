/*

3-2 폼으로 데이터 받기
폼으로 전송되는 데이터를 받기위한 컨트롤러 생성하기
1.뷰 페이지를 보여줄 url 정의하기 @GetMapping으로 폼이 있는 뷰 페이지 연결하기
*/



package com.example.CojadanProject.controller;

import com.example.CojadanProject.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());
        return "";
    }
}
