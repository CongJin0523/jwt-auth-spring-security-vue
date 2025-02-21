package com.cong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cong.entity.DTO.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends IService<Account>, UserDetailsService {
  Account findAccountByUsernameOrEmail(String content);
}
