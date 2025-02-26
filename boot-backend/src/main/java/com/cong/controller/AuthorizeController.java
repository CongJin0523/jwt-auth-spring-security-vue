package com.cong.controller;

import com.cong.entity.RestBean;
import com.cong.entity.VO.request.EmailRegisterVO;
import com.cong.service.AccountService;
import com.cong.utils.Const;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

@RestController
@Slf4j
@RequestMapping("/api/auth")
@Validated
public class AuthorizeController {

  @Resource
  AccountService accountService;

  @GetMapping("/verify-code")
  public RestBean<?> verifyCode(@RequestParam("email") @Email @NotEmpty String email,
                                @RequestParam("type") @Pattern(regexp = "(" + Const.REGISTER_EMAIL + "|" + Const.RESET_EMAIL + ")") String type,
                                HttpServletRequest request) {
    log.info("Get verify code with email:{},type:{}", email, type);
    return this.resultHandle(() -> accountService.verifyCode(type, email, request.getRemoteAddr()));
  }

  @PostMapping("/register")
  public RestBean<?> register(@RequestBody @Valid EmailRegisterVO emailRegisterVO) {
    return this.resultHandle(() -> accountService.registerEmailAccount(emailRegisterVO));
  }

  private RestBean<?> resultHandle(Supplier<String> action) {
    String result = action.get();
    return result == null ? RestBean.success() : RestBean.fail(400, result);

  }
}

