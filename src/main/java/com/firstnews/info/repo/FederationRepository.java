package com.firstnews.info.repo;

import com.firstnews.info.entity.Federation;
import com.firstnews.info.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FederationRepository extends JpaRepository<Federation,Long> {
    List<Federation> findAll();

}
