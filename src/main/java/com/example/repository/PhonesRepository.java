package com.example.repository;

import com.example.dto.Phones;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pc05 on 2018/3/5.
 */
public interface PhonesRepository extends JpaRepository<Phones,Integer> {
}
