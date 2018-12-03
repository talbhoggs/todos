package com.ibm.ph.amperca.todoapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		
		/* - old way of doing inMemoryAuthentication
		auth
		.inMemoryAuthentication()
			.withUser(User.withDefaultPasswordEncoder().username("charles").password("password").roles("USER"));
		*/
		
		auth
        .inMemoryAuthentication()
            .withUser("charles").password("{noop}password").roles("USER");
	}
	
	//configureGlobal
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		http.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll().defaultSuccessUrl("/all");
		*/
		
		http
        .authorizeRequests()
            .antMatchers("/bootstrap/**").permitAll() 
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/authenticateTheUser")
            //Specifies the URL used to authenticate OpenID requests. If the HttpServletRequest matches this URL the OpenIDAuthenticationFilter will attempt to authenticate the request. The default is "/login/openid".
            .defaultSuccessUrl("/all")
            //Specifies where users will go after authenticating successfully if they have not visited a secured page prior to authenticating.
            .permitAll()
            .and()
            .logout().permitAll();


	}

	
	
	
}
