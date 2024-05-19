package com.bank.account.BankApplication.Service;

import com.bank.account.BankApplication.BankAccount.BankAccount;
import com.bank.account.BankApplication.Exception.InvalidIdException;
import com.bank.account.BankApplication.Exception.MobileNumberInvalidException;
import com.bank.account.BankApplication.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.*;

@Service
public class BankAccountService {
    private static Map<Integer,BankAccount> a = new HashMap<>();
    private static int i =1;

    public static BankAccount addAccount(BankAccount bankAccount) {
       try{
           bankAccount.setId(i);
           if (bankAccount.getMobile_no().length() > 10 ) {
               throw new MobileNumberInvalidException("Invalid Mobile Number");
           }
           a.put(bankAccount.getId(), bankAccount);
           ++i;
           return bankAccount;
       }catch(MobileNumberInvalidException e){
           throw new RuntimeException(e.getMessage());
       }
    }

    public List<BankAccount> allBankAccounts() {
        List<BankAccount> l = new ArrayList<>();
        for(int j =1;j<i;j++){
            l.add(a.get(j));
        }
        return l;
    }

    public BankAccount getBankAccount(int id) throws InvalidIdException {
        int j = 1;
        while(j<=i && a.get(j)!=null){
            if(id==j){
                return a.get(j);
            }
            j++;
        }
        try{
            throw new InvalidIdException("Invalid Id");
        }catch(InvalidIdException e){
           throw new RuntimeException(e.getMessage());
        }
    }
}
