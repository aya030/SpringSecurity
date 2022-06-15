package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig{
	
	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login
				                .loginProcessingUrl("/login").loginPage("/login")
				                .defaultSuccessUrl("/")
				                .failureUrl("/login?error").permitAll()
				                .usernameParameter("username").passwordParameter("password")
			).logout(logout -> logout
						        .logoutSuccessUrl("/")
			).authorizeHttpRequests(authorize -> authorize
						        .requestMatchers(PathRequest.toStaticResources()
						        .atCommonLocations()).permitAll()
								.mvcMatchers("/").permitAll()
								.mvcMatchers("/admin").hasRole("ADMIN")
								.anyRequest()
								.authenticated()
		);
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public UserDetailsService userDetailsService() throws Exception {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(
//				User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build());
//		System.out.println(passwordEncoder().encode("password"));
//		manager.createUser(User.withUsername("user").password(passwordEncoder().encode("user")).roles("USER").build());
//		return manager;
//	}
}