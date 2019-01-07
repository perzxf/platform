package com.jb.controller.login;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    //注入rabbitMq工具类
    @Autowired
    private AmqpTemplate amqpTemplate;
}
