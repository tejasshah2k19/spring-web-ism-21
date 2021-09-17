package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}


	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("tejas").password(this.passwordEncoder().encode("tejas")).roles("USER");
		auth.inMemoryAuthentication().withUser("prisha").password(this.passwordEncoder().encode("prisha")).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("admin")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("royal").password(this.passwordEncoder().encode("royal")).roles("ADMIN");
		
	}

	//Bcrypt 

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
}







