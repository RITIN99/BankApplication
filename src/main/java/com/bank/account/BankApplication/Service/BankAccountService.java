package com.bank.account.BankApplication.Service;

import com.bank.account.BankApplication.BankAccount.BankAccount;
import com.bank.account.BankApplication.Exception.MobileNumberInvalidException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public List<BankAccount> allbankAccounts() {
        List<BankAccount> l = new ArrayList<>();
        for(int j =1;j<=i;j++){
            l.add(a.get(j));
        }
        return l;
    }
}
