package com.bank.account.BankApplication.Controller;

import com.bank.account.BankApplication.BankAccount.BankAccount;
import com.bank.account.BankApplication.Service.BankAccountService;
import com.bank.account.BankApplication.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

   @PostMapping("/addAccount")
    public ResponseEntity<ApiResponse> addAccount(@RequestBody BankAccount bankAccount){
        try{
            BankAccount createdAccount = bankAccountService.addAccount(bankAccount);
            return ResponseEntity.ok(new ApiResponse(true, "Account created successfully",createdAccount));
        }catch(RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, ex.getMessage()));
        }
   }

   @GetMapping("/accounts")
    public List<BankAccount> allBankAccounts(){
       return bankAccountService.allBankAccounts();
   }
   @GetMapping("/account/{id}")
    public ResponseEntity<ApiResponse> getBankAccount(@PathVariable int id) {
       try {
           BankAccount getAccount = bankAccountService.getBankAccount(id);
           return ResponseEntity.ok(new ApiResponse(true, "Valid ID",getAccount));
       } catch (RuntimeException ex) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, ex.getMessage()));
       }
   }
}
