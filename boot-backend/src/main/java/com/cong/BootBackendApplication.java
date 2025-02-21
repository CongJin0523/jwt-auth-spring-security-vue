package com.cong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cong.mapper")
public class BootBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(BootBackendApplication.class, args);
  }

}
