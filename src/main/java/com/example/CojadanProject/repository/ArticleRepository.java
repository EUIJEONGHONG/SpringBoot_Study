package com.example.CojadanProject.repository;

import com.example.CojadanProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll(); //findAll을 Arraylist를 받는 메서드로 변경
}
