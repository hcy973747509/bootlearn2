package com.example.repository;

import com.example.dto.Phones;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by pc05 on 2018/3/5.
 */
public interface PhonesRepository extends JpaRepository<Phones,Integer> {

    @Query("select corporateId from Phones  where mail is  null OR mail = '' ")
    public List<Integer> findUsedId(Pageable page);
}
