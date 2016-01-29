package kr.domaindriven.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tony on 2016. 1. 19..
 * Changed by jerry on 2016.1. 26.. index 시작시 fakeData 사전데이터 준비기능 추가.
 */
@RestController
@SpringBootApplication
public class Application {

    private static FakeRecords fakeRecords = new FakeRecords();

    @Autowired
    private RecordRepository recordRepository;

    public static void main(String... args){
        System.setProperty("spring.h2.console.enabled","true");
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public String index(){
        if(recordRepository.count() == 0){
            for(int i = 1; i < 14; i++){
                recordRepository.save(fakeRecords.getRecord(i));
            }
        }
        return "Hello, World!";
    }
}
