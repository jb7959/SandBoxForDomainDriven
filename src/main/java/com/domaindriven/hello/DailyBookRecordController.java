package com.domaindriven.hello;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tony on 2016. 1. 22..
 */
@RestController
public class DailyBookRecordController {

    private static FakeRecords fakeRecords = new FakeRecords();


    @RequestMapping("dailybook/list")
    public List<Record> list(){
        List<Record> recordList = new ArrayList<Record>();
        for(int i = 1; i < 14; i++){
            recordList.add(fakeRecords.getRecord(i));
        }
        return recordList;
    }

}
