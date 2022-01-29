package com.firstnews.info.service.impl;

import com.firstnews.info.entity.News;
import com.firstnews.info.model.NewsModel;
import com.firstnews.info.repo.NewsRepository;
import com.firstnews.info.service.NewsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    private  final NewsRepository newsRepository;
    private final ModelMapper modelMapper;

    public NewsServiceImpl(NewsRepository newsRepository,ModelMapper modelMapper){
        this.newsRepository=newsRepository;
        this.modelMapper=modelMapper;
    }



    @Override
    public NewsModel save(NewsModel news) {
      News newsDb=  modelMapper.map(news,News.class);
        return modelMapper.map(newsRepository.save(newsDb),NewsModel.class);
    }

    @Override
    public NewsModel getById(Long id) {

        return modelMapper.map(newsRepository.getOne(id),NewsModel.class);
    }
}
