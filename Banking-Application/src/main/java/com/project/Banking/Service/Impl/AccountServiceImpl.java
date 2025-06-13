package com.project.Banking.Service.Impl;

import com.project.Banking.Dto.AccountDto;
import com.project.Banking.Entity.Account;
import com.project.Banking.Exception.AccountException;
import com.project.Banking.Mapper.AccountMapper;
import com.project.Banking.Repository.AccountRepository;
import com.project.Banking.Service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository ;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto addAccount(AccountDto accountDto) {
        Account account = AccountMapper.maptoAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccount(long id) {
        Account account = accountRepository.findById(id).orElseThrow(()->
                new AccountException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto Deposit(long id, double depBal) {
        Account account = accountRepository.findById(id).orElseThrow(()->
                new AccountException(" not possible "));
        account.setBalance(depBal+account.getBalance());
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto Withdrawal(long id, double withBal) {
        Account account = accountRepository.findById(id).orElseThrow(()->
                new AccountException("not possible"));
        if(account.getBalance() < withBal ){
            throw new RuntimeException("Not enough Balance");
        }
        else{
            account.setBalance(account.getBalance() - withBal);
        }
        Account savedAccount = accountRepository.save(account) ;
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> accountDtos = accounts.stream()
                .map((account)->
                        AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
        return accountDtos ;
    }

    @Override
    public void deleteAccount(long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->
                new AccountException("Account does not exist"));
        accountRepository.deleteById(id);


    }

}
