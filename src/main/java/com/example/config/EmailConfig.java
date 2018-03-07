package com.example.config;/**
 * Created by pc05 on 2018/3/7.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 描述 :
 *
 * @author : huangcy
 * @create : 2018-03-07 17:20
 * @email : huangcy01@zendaimoney.com
 **/
@Component
public class EmailConfig {
    /**
     * 发件邮箱
     */
    @Value("${spring.mail.username}")
    private String emailFrom;

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }
}
