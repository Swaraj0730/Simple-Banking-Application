package com.project.Banking.Controller;

import com.project.Banking.Dto.AccountDto;
import com.project.Banking.Entity.Account;
import com.project.Banking.Service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService ;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto accountDto){
        AccountDto accountDto1 = accountService.addAccount(accountDto);
       return new ResponseEntity<>(accountDto1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable("id") long id){
        AccountDto accountDto = accountService.getAccount(id);
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }

//    @GetMapping("/{id}/{depBal}")
//    public ResponseEntity<AccountDto> Deposit (@PathVariable("id") long id ,
//                                               @PathVariable("depBal") double depBal){
//        AccountDto accountDto = accountService.Deposit(id,depBal);
//        return new ResponseEntity<>(accountDto,HttpStatus.OK) ;
//    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> Deposit (@PathVariable("id") long id ,
                                               @RequestBody Map<String,Double> request){

        double amount = request.get("amount");
        AccountDto accountDto = accountService.Deposit(id,amount);
        return ResponseEntity.ok(accountDto) ;

    }
    @PutMapping("/{id}/withdrawal")
    public ResponseEntity<AccountDto> Withdrawal(@PathVariable("id") long id ,
                                                 @RequestBody Map<String,Double> request){
        double amount = request.get("amount");
        AccountDto accountDto = accountService.Withdrawal(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccount () {
        List<AccountDto> accountDtos = accountService.getAllAccounts();
        return ResponseEntity.ok(accountDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
