package com.firstnews.info.repo;

import com.firstnews.info.entity.SportMen;
import com.firstnews.info.entity.TedbirImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TedbirImagesRepository extends JpaRepository<TedbirImages,Long> {




    Collection<? extends TedbirImages> getById(Long id);
    Collection<? extends TedbirImages> getByTedbirId(Long id);
}
