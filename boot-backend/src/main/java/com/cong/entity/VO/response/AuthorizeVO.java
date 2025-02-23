package com.cong.entity.VO.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AuthorizeVO {
  String username;
  String role;
  String token;
  Date expire;
}
