package com.cong.entity.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cong.entity.BaseData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@TableName("`account`")
@AllArgsConstructor
public class Account implements BaseData {
  @TableId(type = IdType.AUTO)
  Integer id;
  String username;
  String password;
  String email;
  String role;
  Date registerTime;
}
