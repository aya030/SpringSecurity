package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.formLogin(login -> login
        .loginProcessingUrl("/login")
        .loginPage("/login")
        .defaultSuccessUrl("/")
        .failureUrl("/login?error")
        .permitAll()
    ).logout(logout -> logout
        .logoutSuccessUrl("/")
    ).authorizeHttpRequests(authorize -> authorize
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        .mvcMatchers("/").permitAll()
        .mvcMatchers("/admin").hasRole("USER")
        .anyRequest().authenticated()
    );
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  //　インメモリ認証用
  @Bean
  public UserDetailsService userDetailsService() throws Exception {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("admin").password(passwordEncoder().encode("password1")).roles("ADMIN").build());
    manager.createUser(User.withUsername("user").password(passwordEncoder().encode("password2")).roles("USER").build());
    return manager;
  }
}

