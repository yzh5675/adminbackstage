package com.cs.adminbackstage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法级别的权限认证--@PreAuthorize("hasAuthority('xx')") 有xx该权限才能访问此方法
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	@Qualifier("UserDetailsService")
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login","/css/**","/fonts/**","/images/**","/js/**").permitAll()
		.anyRequest().authenticated();
		
		http.formLogin().usernameParameter("name")
		.passwordParameter("password").loginPage("/login").defaultSuccessUrl("/list/1");
		
		//http.logout().logoutSuccessUrl("/logout");
		http.csrf().disable();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encode=new BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(encode);
	}
}
