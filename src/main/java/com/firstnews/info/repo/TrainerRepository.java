package com.firstnews.info.repo;

import com.firstnews.info.entity.News;
import com.firstnews.info.entity.SportMen;
import com.firstnews.info.entity.Trainer;
import com.firstnews.info.model.TrainerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TrainerRepository extends JpaRepository<Trainer,Long> {
    Collection<? extends Trainer> getByNameStartsWith(String name);
    Collection<? extends Trainer> getById(Long id);
}
