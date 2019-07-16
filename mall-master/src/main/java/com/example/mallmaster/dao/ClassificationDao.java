package com.example.mallmaster.dao;

import com.example.mallmaster.entity.Classification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ClassificationDao extends JpaRepository<Classification, Integer> {

    List<Classification> findByType(int type);

    Page<Classification> findByType(int type, Pageable pageable);

    List<Classification> findByParentId(int cid);


}
