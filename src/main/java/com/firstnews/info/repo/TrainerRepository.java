package com.firstnews.info.repo;

import com.firstnews.info.entity.News;
import com.firstnews.info.entity.Trainer;
import com.firstnews.info.model.TrainerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer,Long> {
}
