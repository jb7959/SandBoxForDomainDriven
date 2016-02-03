package kr.domaindriven.dailybook.record;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created by tony on 2016. 1. 22..
 * Changed by jerry on 2016.1. 26.. 엔티티로 수정
 */

@EnableWebMvc
@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime date;

    @Enumerated(value = EnumType.STRING)
    private RecordType revenueOrExpense;

    private Won amount;

    private Won balance;

    private String summary;

    @Enumerated(value = EnumType.STRING)
    private RecordCategory category;

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setRevenueOrExpense(RecordType revenueOrExpense) { this.revenueOrExpense = revenueOrExpense; }

    public void setAmount(Won amount) {
        this.amount = amount;
    }

    public void setBalance(Won balance) {
        this.balance = balance;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setCategory(RecordCategory category) {
        this.category = category;
    }

    public Record(LocalDateTime date, boolean isRevenue, Won amount, Won balance, String summary, RecordCategory category) {
        this.date = date;
        if(isRevenue){
            revenueOrExpense = RecordType.수입;
        }else {

            revenueOrExpense = RecordType.지출;
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

    public Won getBalance() {
        return balance;
    }

    public String getSummary() {
        return summary;
    }

    public RecordType getRevenueOrExpense() {
        return revenueOrExpense;
    }

    public RecordCategory getCategory() {
        return category;
    }
}
