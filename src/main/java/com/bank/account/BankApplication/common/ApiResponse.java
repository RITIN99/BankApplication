package com.bank.account.BankApplication.common;

import com.bank.account.BankApplication.BankAccount.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiResponse {
    private final boolean success;
    private final String message;
    private BankAccount bankAccount;

    public ApiResponse(boolean success, String message, BankAccount bankAccount) {
        this.success = success;
        this.message = message;
        this.bankAccount = bankAccount;
    }

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isSuccess() {
        return success;
    }
    public String getMessage() {
        return message;
    }
}
