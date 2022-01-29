package com.firstnews.info.repo;

import com.firstnews.info.entity.News;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


   public interface NewsRepository extends JpaRepository<News,Long> {
   List<News> findAll();

}
