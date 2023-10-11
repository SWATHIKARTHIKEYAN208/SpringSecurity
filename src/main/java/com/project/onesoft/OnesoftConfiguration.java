package com.project.onesoft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class OnesoftConfiguration extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.inMemoryAuthentication()	.withUser("swathi").password("$2a$10$cqPCEmaXnv6IUpIitId9QuLLgJVvje7yxqohVZyEMmRjuhb0SmOJ.").roles("student");
//	}
//	@Bean
//	public PasswordEncoder getPass() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	@Bean
//	public PasswordEncoder getPass() {
//		return new BCryptPasswordEncoder(10);
//	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()	.withUser("swathi").password("$2a$10$zfydoiZU3R5i66CpiR/q2.kpyuoKekdD9QwEG9G5a3WHf22fU74jy").roles("student").and().withUser("prakash").password("$2a$10$1eSmkZL8ehfD/OxkmDL9zeQ8ETL.MR2BWZ7uFA1M71/N3VqrFeMwe").roles("trainer").and().withUser("anup").password("$2a$10$WkRVyShLCnImX0ska4SmcuAmFhCSYK3vUYm9XIrvgMbObRM1OYiaO").roles("manager");
	}
	@Bean
	public PasswordEncoder getPass() {
	return new BCryptPasswordEncoder(10);
	}
	@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/manager").hasRole("manager");
			http.authorizeRequests().antMatchers("/trainer").hasAnyRole("trainer","manager");
			
			http.authorizeRequests().antMatchers("/student").permitAll().and().formLogin();
			//http.authorizeRequests().antMatchers("/student").hasAnyRole("trainer","manager","student");
		}
	
	

}
