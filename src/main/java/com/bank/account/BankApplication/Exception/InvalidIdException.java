package com.bank.account.BankApplication.Exception;

public class InvalidIdException extends RuntimeException {
    private String msg;
    public InvalidIdException(String msg){
        super(msg);
    }
}
