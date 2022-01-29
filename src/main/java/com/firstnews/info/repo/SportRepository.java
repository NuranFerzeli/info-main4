package com.firstnews.info.repo;

import com.firstnews.info.entity.SportMen;
import com.firstnews.info.model.SportModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<SportMen,Long> {
}
