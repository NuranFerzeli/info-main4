package com.firstnews.info.service;

import com.firstnews.info.entity.News;
import com.firstnews.info.model.NewsModel;

public interface NewsService {
    NewsModel save(NewsModel news);
    NewsModel getById(Long id);

}

