/*

3-2 폼으로 데이터 받기
폼으로 전송되는 데이터를 받기위한 컨트롤러 생성하기
1.뷰 페이지를 보여줄 url 정의하기 @GetMapping으로 폼이 있는 뷰 페이지 연결하기
*/



package com.example.CojadanProject.controller;

import com.example.CojadanProject.dto.ArticleForm;
import com.example.CojadanProject.entity.Article;
import com.example.CojadanProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //println문을 대체하기 위한 롬복
public class ArticleController {
    @Autowired //스프링부트가 몰래 만들어둔 객체를 연결 시켜줌 따라서 ArticleRepository를 따로 객체를 생성하지 않아도됨
    private ArticleRepository articleRepository; //Autowired에 의해 바로 사용할 수 있음

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString()); //로깅 코드
        //현재 println은 로깅으로 대체 중
        //System.out.println(form.toString());
//        1. DTO를 엔티티로 변환하기(form 객체에서 메서드를 호출해 article 엔티티에 저장)
        Article article = form.toEntity();
        log.info(article.toString()); //로깅 코드
        //현재 println은 로깅으로 대체 중
        //System.out.println(article.toString()); //엔티티로 잘 변환되었는지 확인

//        2. 리파지터리로 엔티티를 db에 저장하기
        Article saved = articleRepository.save(article);
        log.info(saved.toString()); //로깅 코드
        //현재 println은 로깅으로 대체 중
        //System.out.println(saved.toString()); // 잘 저장되었는지 확인


        return "";
    }
}