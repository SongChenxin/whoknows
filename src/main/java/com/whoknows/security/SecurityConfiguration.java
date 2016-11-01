package com.whoknows.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	private final Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);
    
	@Autowired 
	private AuthProvider authProvider;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Bean
	public AuthFilter authFilter() {
		AuthFilter authFilter = new AuthFilter(authProvider);
		authFilter.setAuthenticationSuccessHandler(new AuthSuccessHandler());
		authFilter.setAuthenticationFailureHandler(new AuthFailedHandler());
		return authFilter;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/login*").permitAll()
				.antMatchers("/images/**").permitAll()
				.antMatchers("index.html", "/app/**", "/p/**", "login*").permitAll()
				.antMatchers("/styles/**").permitAll()
				.antMatchers("/fronts/**").permitAll()
				.antMatchers("/components/**").permitAll()
				.antMatchers("/bower_components/**").permitAll()
                .antMatchers("/search/**").permitAll()
                .antMatchers("/tag/**").permitAll()
                .antMatchers("/topic/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/user/current").permitAll()
				.antMatchers("/hot/**").permitAll()
				.antMatchers("/user/**").permitAll()
				.antMatchers("/reply/**").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
			.and()
				.logout().permitAll()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
			.and()
				.addFilterBefore(authFilter(),UsernamePasswordAuthenticationFilter.class).csrf().disable()
				.exceptionHandling().authenticationEntryPoint(authEntryPoint());
			
	}
	
	@Bean
	public AuthenticationEntryPoint authEntryPoint() {
		return new Http403ForbiddenEntryPoint();
	}

	
}
