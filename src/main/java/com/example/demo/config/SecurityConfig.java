package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login
				.loginProcessingUrl("/login")
				.loginPage("/login").defaultSuccessUrl("/")
				.failureUrl("/login?error").permitAll()
				.usernameParameter("username").passwordParameter("password"))
			.logout(logout -> logout
		    	.logoutSuccessUrl("/login"))
			.authorizeHttpRequests(authorize -> authorize
		    	.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
		    	.mvcMatchers("/").permitAll()
		    	.mvcMatchers("/register").permitAll()
		    	.mvcMatchers("/admin").hasAuthority("ROLE_ADMIN")
		    	.anyRequest().authenticated());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//　インメモリ認証用
//	@Bean
//	public UserDetailsService userDetailsService() throws Exception {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(
//				User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build());
//		manager.createUser(User.withUsername("user").password(passwordEncoder().encode("user")).roles("USER").build());
//		return manager;
//	}
}

