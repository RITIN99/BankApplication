package com.bank.account.BankApplication.Service;

import com.bank.account.BankApplication.BankAccount.Amount;
import com.bank.account.BankApplication.BankAccount.BankAccount;
import com.bank.account.BankApplication.Exception.InvalidIdException;
import com.bank.account.BankApplication.Exception.MobileNumberInvalidException;
import com.bank.account.BankApplication.Exception.NegativeAmountException;
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

    public BankAccount depositAmount(int id, Amount amount) {
        BankAccount bankAccount;
        for(int j=1;j<=i && a.get(j)!=null;j++){
            if(id == j){
                bankAccount = a.get(j);
                bankAccount.setId(j);
                if(amount.getAmount()>0){
                    bankAccount.setBalance(bankAccount.getBalance()+amount.getAmount());
                }
                else{
                    try{
                        throw new NegativeAmountException("Invalid Amount");
                    }catch(NegativeAmountException e){
                        throw new RuntimeException(e.getMessage());
                    }
                }
                a.put(j,bankAccount);
                return a.get(j);
            }
        }
        try{
            throw new InvalidIdException("Invalid Id");
        }catch(InvalidIdException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
