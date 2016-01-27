package com.domaindriven.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2016. 1. 22..
 */
@Controller
public class DailyBookPageController {

    private static FakeRecords fakeRecords = new FakeRecords();

    @RequestMapping(value="dailybook/add", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("record", new Record());
        // TODO DBMS 테이블에 추가 by 안재열
        return "add";
    }

    @RequestMapping(value="dailybook/add", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Record record, Model model) {
        model.addAttribute("record", record);
        return "result";
    }


    @RequestMapping("list")
    public String list(Model model){
        List<Record> recordList = new ArrayList<Record>();
        for(int i = 1; i < 14; i++){
            recordList.add(fakeRecords.getRecord(i));
        }
        model.addAttribute("list", recordList);
        return "list";
    }



}

