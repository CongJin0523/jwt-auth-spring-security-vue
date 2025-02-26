package com.cong.entity.VO.request;

import com.cong.entity.BaseData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class EmailRegisterVO implements BaseData {
  @Email
    @NotEmpty
  String email;

  @Length(max = 6, min = 6)
  String code;

  @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Length(min = 1, max = 20)
  String username;

  @Length(min = 6, max = 20)
  String password;


}
