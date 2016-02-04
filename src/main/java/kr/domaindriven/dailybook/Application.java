package kr.domaindriven.dailybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

/**
 * Created by tony on 2016. 1. 19..
 * Changed by jerry on 2016.1. 26.. index 시작시 fakeData 사전데이터 준비기능 추가.
 */
@RestController
@SpringBootApplication
public class Application {

    public static void main(String... args){
        System.setProperty("spring.jpa.show-sql", "true");
        System.setProperty("spring.jpa.hibernate.ddl-auto", "validate");
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }

    @RequestMapping("/")
    public String index(){
        return "Hello, World!";
    }

}
