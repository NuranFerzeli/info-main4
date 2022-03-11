package com.firstnews.info.repo;

import com.firstnews.info.entity.Tedbir;
import com.firstnews.info.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TedbirRepository extends JpaRepository<Tedbir,Long> {
    Collection<? extends Tedbir> getByAssembleName(String name);
    Collection<? extends Tedbir> getById(Long id);
}
