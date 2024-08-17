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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
    @GetMapping("/articles/{id}") //게시판 글이 작성될때 생성되는 id에 따라 url 받기
    public String show(@PathVariable Long id, Model model){ //생성되는 id를 변수로 받기, 뷰에 보여줄 데이터를 담을 Model 변수 추가
        log.info("id = "+id); //로그남기기
        //데이터 가져오기
        //Article articleEntity = articleRepository.findById(id); //반환형이 Article이 아닐때 null 등 오류가 생기기 때문에 빨간줄이 뜸
        Article articleEntity = articleRepository.findById(id).orElse(null); //반환형이 Article이 아닐때를 대비
        model.addAttribute("article",articleEntity); //모델에 데이터 담기
        return "articles/show"; //show라는 뷰 반환하기
    }
    @GetMapping("/articles/index")
    public String index(Model model){
        List<Article> articleEntityList = articleRepository.findAll();
        model.addAttribute("articleList", articleEntityList);
        return "articles/index";
    }
}