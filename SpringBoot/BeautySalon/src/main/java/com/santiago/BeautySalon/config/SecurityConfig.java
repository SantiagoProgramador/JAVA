package com.santiago.BeautySalon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  private final String[] PUBLIC_RESOURCES = { "/services/public/get", "/auth/**" };

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
    return
      httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests(authRequest -> authRequest
      .requestMatchers(PUBLIC_RESOURCES).permitAll()).build();
  }
}
