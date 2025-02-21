package com.cong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cong.context.AccountContext;
import com.cong.entity.DTO.Account;
import com.cong.mapper.AccountMapper;
import com.cong.service.AccountService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Account account = findAccountByUsernameOrEmail(username);
    if(account == null) {
      throw new UsernameNotFoundException("Username or password is incorrect");
    }
    AccountContext.set(account);
    return User
        .withUsername(username)
        .password(account.getPassword())
        .roles(account.getRole())
        .build();
  }

  public Account findAccountByUsernameOrEmail(String content) {
    return this.query()
        .eq("username", content).or()
        .eq("email", content)
        .one();
  };

}
