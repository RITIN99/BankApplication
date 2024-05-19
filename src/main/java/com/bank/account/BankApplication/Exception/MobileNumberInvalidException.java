package com.bank.account.BankApplication.Exception;

public class MobileNumberInvalidException extends RuntimeException{
    private String msg;
    public MobileNumberInvalidException (String msg){
       super(msg);
    }
}
