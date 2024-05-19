package com.bank.account.BankApplication.BankAccount;

public class BankAccount {
    private int id;
    private String name;
    private String mobile_no;
    private int age;
    private int balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public BankAccount(int id, String name, String mobile_no, int age, int balance) {
        this.id = id;
        this.name = name;
        this.mobile_no = mobile_no;
        this.age = age;
        this.balance = balance;
    }

}
