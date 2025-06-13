package com.project.Banking.Mapper;

import com.project.Banking.Dto.AccountDto;
import com.project.Banking.Entity.Account;

public class AccountMapper {


    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto ;
    }

    public static Account maptoAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.id(),
                accountDto.accountHolderName(),
                accountDto.balance()
        );
        return account ;
    }
}
