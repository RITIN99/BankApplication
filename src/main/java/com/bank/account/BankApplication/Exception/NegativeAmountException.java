package com.bank.account.BankApplication.Exception;

public class NegativeAmountException extends RuntimeException{
    private String msg;
    public NegativeAmountException(String msg){
        super(msg);
    }
}
