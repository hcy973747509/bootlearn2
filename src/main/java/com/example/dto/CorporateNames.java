package com.example.dto;/**
 * Created by pc05 on 2018/3/5.
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述 :
 *
 * @author : huangcy
 * @create : 2018-03-05 9:43
 * @email : huangcy01@zendaimoney.com
 **/
@Entity
@Data
@Table(name="xn_corporate_names")
public class CorporateNames implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String jobInfo;

    @Column(name = "corporateName")
    private String corporateName;

    @Column(name = "montyPay")
    private String montyPay;

    @Column(name = "publishDate")
    private String publishDate;

    @Column(name = "createDate")
    private Date createDate;

    private String phone;

    private String source;
}
