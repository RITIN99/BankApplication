package com.bank.account.BankApplication.Controller;

import com.bank.account.BankApplication.BankAccount.BankAccount;
import com.bank.account.BankApplication.Service.BankAccountService;
import com.bank.account.BankApplication.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

   @PostMapping("/addAccount")
    public ResponseEntity<ApiResponse> addAccount(@RequestBody BankAccount bankAccount){
        try{
            BankAccount createdAccount = bankAccountService.addAccount(bankAccount);
            return ResponseEntity.ok(new ApiResponse(true, "Account created successfully"));
        }catch(RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, ex.getMessage()));
        }
   }

   @GetMapping("/accounts")
    public List<BankAccount> allbankAccounts(){
       return bankAccountService.allbankAccounts();
   }
}
