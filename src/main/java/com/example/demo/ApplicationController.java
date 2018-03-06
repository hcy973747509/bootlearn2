package com.example.demo;/**
 * Created by pc05 on 2018/3/2.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 :
 *
 * @author : huangcy
 * @create : 2018-03-02 16:48
 * @email : huangcy01@zendaimoney.com
 **/
@RestController
public class ApplicationController {

    @RequestMapping("/")
    @ResponseBody
    public String show(){
        return ">>>>>>>>>>>>>>>>>>>>success!";
    }
}
