package com.bank.account.BankApplication.Exception;

public class CustomException extends RuntimeException{
    private String msg;
    public CustomException(String msg){
        super(msg);
    }
}
