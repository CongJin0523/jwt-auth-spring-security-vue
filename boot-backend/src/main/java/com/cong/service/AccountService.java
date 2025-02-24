package com.cong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cong.entity.DTO.Account;
import com.cong.entity.VO.request.EmailRegisterVO;
import org.springframework.security.core.userdetails.UserDetailsService;

//UserDetailService is used to get the login info from the database
public interface AccountService extends IService<Account>, UserDetailsService {
  Account findAccountByUsernameOrEmail(String content);
  String verifyCode(String type, String email, String ip);
  String registerEmailAccount(EmailRegisterVO emailRegisterVO);
}

