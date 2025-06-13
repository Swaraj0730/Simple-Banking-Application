package com.project.Banking.Service;

import com.project.Banking.Dto.AccountDto;
import com.project.Banking.Entity.Account;

import java.util.List;

public interface AccountService {

    AccountDto addAccount(AccountDto accountDto);

    AccountDto getAccount(long id);

    AccountDto Deposit(long id , double depBal) ;

    AccountDto Withdrawal(long id , double withBal) ;

    List<AccountDto> getAllAccounts () ;

    void deleteAccount(long id);
}
