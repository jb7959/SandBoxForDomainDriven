package com.domaindriven.hello;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
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
    public String recordAdded(@ModelAttribute Record record, BindingResult result, Model model) {

        System.out.println(record);
        System.out.println("BEFORE :" + record.getAmount());
        System.out.println("BEFORE :" + record.getRevenueOrExpense());

        if(record.getDate() == null){
            record.setDate(LocalDateTime.now());
        }

        // TODO 날짜를 입력 받아 처리하는 방법 구현
        // TODO 시간까지 입력 받아 처리하는 방법 구현

        if(record.getAmount() == null){
            record.setAmount(Money.of(CurrencyUnit.of("KRW"), new BigDecimal(30000)));
        }
        System.out.println("AFTER " + record.getAmount());

        recordRepository.save(record);
        model.addAttribute("record", record);

        if(result.hasErrors())
            return "add";
        else
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

