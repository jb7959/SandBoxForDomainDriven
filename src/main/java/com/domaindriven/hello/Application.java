package com.domaindriven.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tony on 2016. 1. 19..
 */
@RestController
@SpringBootApplication
public class Application {


    public static void main(String... args){
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public String index(){
        return "Hello, World!";
    }
}
