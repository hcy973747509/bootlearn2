package com.example.repository;/**
 * Created by pc05 on 2018/3/5.
 */

import com.example.dto.CorporateNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 描述 :
 *
 * @author : huangcy
 * @create : 2018-03-05 9:49
 * @email : huangcy01@zendaimoney.com
 **/
public interface  CorporateRepository extends JpaRepository<CorporateNames,Integer> {
    @Query("select u from CorporateNames u where u.id >= ?1")
    List<CorporateNames> selectCorproate(int id);
}
