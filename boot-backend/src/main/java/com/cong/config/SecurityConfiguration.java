package com.cong.config;

import com.cong.entity.RestBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;
import java.net.http.HttpRequest;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(conf -> conf
            .requestMatchers("/api/auth/**").permitAll()
            .anyRequest().authenticated())
        .formLogin(conf -> conf
            .loginProcessingUrl("/api/auth/login")
            .failureHandler(this::onAuthenticationFailure)
            .successHandler(this::onAuthenticationSuccess))
        .logout(conf -> conf
            .logoutUrl("/api/auth/logout")
            .logoutSuccessHandler(this::onLogoutSuccess))
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(conf -> conf
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();

  }

  private void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {

  }

  private void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
    httpServletResponse.setContentType("application/json;charset=utf-8");
    httpServletResponse.getWriter().write(RestBean.fail(401, e.getMessage()).toJsonString());
  }

  private void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
    httpServletResponse.setContentType("application/json;charset=utf-8");
    httpServletResponse.getWriter().write(RestBean.success().toJsonString());
  }


}
