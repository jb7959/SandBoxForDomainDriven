package com.domaindriven.hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Created by tony on 2016. 1. 22..
 * Changed by jerry on 2016.1. 26.. 엔티티로 수정
 */

@Entity
public class Record {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String date;
    private String revenueOrExpense;
    private String amount;
    private String balance;
    private String summary;
    private String category;
    public void setDate(String date) {
        this.date = date;
    }

    public void setRevenueOrExpense(String revenueOrExpense) { this.revenueOrExpense = revenueOrExpense; }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Record(String date, boolean isRevenue, String amount, String balance, String summary, String category) {
        this.date = date;
        if(isRevenue){
            revenueOrExpense = "수입";
        }else {

            revenueOrExpense = "지출";
        }
        this.amount = amount;
        this.balance = balance;
        this.summary = summary;
        this.category = category;
    }

    public Record() {

    }


    public long getId() {return id;}

    public String getDate() {
        return date;
    }

    public String getAmount() {
        return amount;
    }

    public String getBalance() {
        return balance;
    }

    public String getSummary() {
        return summary;
    }

    public String getRevenueOrExpense() {
        return revenueOrExpense;
    }

    public String getCategory() {
        return category;
    }
}
