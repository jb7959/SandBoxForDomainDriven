package com.domaindriven.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2016. 1. 22..
 * hanged by jerry on 2016.1. 26..  DBMS 테이블에 추가
 */
@Controller
public class DailyBookPageController {

    @Autowired
    private RecordRepository recordRepository;

    @RequestMapping(value="dailybook/add", method= RequestMethod.GET)
    public String addRecord(Model model) {
        model.addAttribute("record", new Record());
        return "add";
    }

    @RequestMapping(value="dailybook/add", method=RequestMethod.POST)
    public String recordAdded(@ModelAttribute Record record, Model model) {

        if(record.getDate() == null){
            record.setDate(LocalDateTime.now());
        }

        // TODO 날짜를 입력 받아 처리하는 방법 구현
        // TODO 시간까지 입력 받아 처리하는 방법 구현

        recordRepository.save(record);
        model.addAttribute("record", record);
        return "result";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model){
        List<Record> recordList = new ArrayList<Record>();
        for (Record record:recordRepository.findAll()) {
            recordList.add(record);
        }
        model.addAttribute("list", recordList);
        return "list";
    }


    @RequestMapping("list/{id}")
    public String list(@PathVariable Long id, Model model){
        List<Record> recordList = new ArrayList<Record>();
        recordList.add(recordRepository.findById(id));
        model.addAttribute("list", recordList);
        return "list";
    }
}

