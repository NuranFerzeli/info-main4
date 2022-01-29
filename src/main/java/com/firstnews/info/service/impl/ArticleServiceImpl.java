package com.firstnews.info.service.impl;

import com.firstnews.info.entity.Article;
import com.firstnews.info.repo.ArticleRepository;
import com.firstnews.info.service.ArticleService;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository=articleRepository;
    }
    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article getById(Long id) {
        return articleRepository.getOne(id);
    }
}
