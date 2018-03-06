package com.example.dto;/**
 * Created by pc05 on 2018/3/5.
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述 :
 *
 * @author : huangcy
 * @create : 2018-03-05 13:33
 * @email : huangcy01@zendaimoney.com
 **/
@Entity
@Data
@Table(name="xn_phones")
public class Phones implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="corporateId")
    private Integer corporateId;

    private String phone;
}
