package kr.domaindriven.hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


/**
 * Created by tony on 2016. 1. 22..
 * Changed by jerry on 2016.1. 26.. 엔티티로 수정
 */

@Entity
public class Record {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDateTime date; // TODO #8
    private String revenueOrExpense; // TODO #13
    private Won amount; // TODO #14
    private String balance; // TODO #15
    private String summary;
    private String category; // TODO #16

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setRevenueOrExpense(String revenueOrExpense) { this.revenueOrExpense = revenueOrExpense; }

    public void setAmount(Won amount) {
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

    public Record(LocalDateTime date, boolean isRevenue, Won amount, String balance, String summary, String category) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public Won getAmount() {
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
