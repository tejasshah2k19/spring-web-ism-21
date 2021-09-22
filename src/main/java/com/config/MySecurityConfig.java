package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailsService customUserDetailsService;
//
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests()
				.antMatchers("/users/**").hasRole("USER").antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/public/**").
				permitAll().anyRequest().authenticated().and()
//		.httpBasic();
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.deleteCookies("JSESSIONID").invalidateHttpSession(true)
				.and()
				.formLogin().loginPage("/public/login")
				.usernameParameter("email")
				.defaultSuccessUrl("/loginok")
				;
		
		
//				.successForwardUrl("/loginok")
//				;
	}

	

//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests()
//				.antMatchers("/users/**").hasRole("USER").antMatchers("/admin/**").hasRole("ADMIN")
//				.antMatchers("/public/**","/logout").
//				permitAll().anyRequest().authenticated().and()
////		.httpBasic();
//				.formLogin().loginPage("/public/login");
//	}
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("tejas").password(this.passwordEncoder().encode("tejas")).roles("USER");
//		auth.inMemoryAuthentication().withUser("prisha").password(this.passwordEncoder().encode("prisha")).roles("USER");
//		auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("admin")).roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("royal").password(this.passwordEncoder().encode("royal")).roles("ADMIN");
//		
//	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);

	}

	// Bcrypt

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}
