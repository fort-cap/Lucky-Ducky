package com.luckyducky.luckyducky.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Transaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Value("${some.key:0}")
    private double amountInCents;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;

    @Column(nullable = false)
    @Value("${some.key:false}")
    private Boolean isIncome;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name= "category_id")
    private Category category;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "budget_id")
    private Budget budget;

    public Transaction() {
    }

    public Transaction(long id, String name, double amountInCents, boolean isIncome, Category category) {
        this.id = id;
        this.name = name;
        this.amountInCents = amountInCents;
        this.isIncome = isIncome;
        this.category = category;
    }

    public Transaction(String name, double amountInCents, boolean isIncome, Category category) {
        this.name = name;
        this.amountInCents = amountInCents;
        this.isIncome = isIncome;
        this.category = category;
    }

    public static List<Transaction> findAll() {
        return null;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getAmountInCents() {
        return amountInCents;
    }
    public void setAmountInCents(double amountInCents) {
        this.amountInCents =  amountInCents * 100;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date dateCreated) {
        this.createDate = createDate;
    }

    public Boolean getIncome() {
        return isIncome;
    }
    public void setIncome(Boolean income) {
        isIncome = income;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public Bill getBill() {
        return bill;
    }
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Budget getBudget() {
        return budget;
    }
    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public void setUser(Transaction transaction) {
    }
}



