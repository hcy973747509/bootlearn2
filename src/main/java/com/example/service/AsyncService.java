package com.example.service;/**
 * Created by pc05 on 2018/3/7.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 描述 :
 *
 * @author : huangcy
 * @create : 2018-03-07 14:48
 * @email : huangcy01@zendaimoney.com
 **/
@Service
public class AsyncService {

    @Autowired
    private XnService xnService;

    @Async
    public void test(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>异步调用开始!!!");
        xnService.getQxbPhone();
    }
}
