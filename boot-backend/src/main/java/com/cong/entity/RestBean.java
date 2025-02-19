package com.cong.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public record RestBean<T>(int code, T data, String msg) {
  public static <T> RestBean<T> success(T data) {
    return new RestBean<>(200, data, "request success");
  }
  public static <T> RestBean<T> success() {
    return success(null);
  }

  public static <T> RestBean<T> fail(int code, String msg) {
    return new RestBean<>(code, null, msg);
  }

  public String toJsonString() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(this);
  }

}
