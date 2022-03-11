package com.firstnews.info.repo;

import com.firstnews.info.entity.SportMen;
import com.firstnews.info.model.SportModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface SportRepository extends JpaRepository<SportMen,Long> {
    Collection<? extends SportMen> getByNameStartsWith(String name);
    Collection<? extends SportMen> getById(Long id);
    Page<SportMen> findAll(Pageable pageable);
}
