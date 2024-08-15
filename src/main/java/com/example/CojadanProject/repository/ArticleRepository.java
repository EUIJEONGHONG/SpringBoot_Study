package com.example.CojadanProject.repository;

import com.example.CojadanProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
