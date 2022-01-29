package com.firstnews.info.service;

import com.firstnews.info.entity.Article;

public interface ArticleService {
    Article save(Article article);
    Article getById(Long id);
}
