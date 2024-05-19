package com.bank.account.BankApplication.Service;

import com.bank.account.BankApplication.BankAccount.BankAccount;
import com.bank.account.BankApplication.Exception.MobileNumberInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankAccountService {
    private static Map<Integer,BankAccount> a = new HashMap<>();
    private static int i =1;

    public static BankAccount addAccount(BankAccount bankAccount) {
       try{
        bankAccount.setId(i);
           if (bankAccount.getMobile_no().length() > 10) {
               throw new MobileNumberInvalidException("Invalid Mobile Number");
           }
           a.put(bankAccount.getId(), bankAccount);
           ++i;
           return bankAccount;
       }catch(MobileNumberInvalidException e){
           throw new RuntimeException(e.getMessage());
       }
    }
}
