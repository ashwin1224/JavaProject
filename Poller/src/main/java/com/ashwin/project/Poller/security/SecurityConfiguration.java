package com.ashwin.project.Poller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    @Autowired
    private UserDetailsService userDetailsService;
    
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  	
	  	// enable in memory based authentication with a user named
	  	// "user" and "admin"
		
		auth.inMemoryAuthentication().withUser("Ashwin").password("{noop}password").
		roles("USER", "ADMIN");
	  }
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic()
				.and().authorizeRequests()
				.antMatchers("/login","/registration").permitAll()
				.antMatchers("/").access("hasRole('ADMIN')")
				.and().csrf().disable().formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/homepage",true).and()
				.logout().permitAll();
		}
	  
	  @Bean
	    public AuthenticationManager customAuthenticationManager() throws Exception {
	        return authenticationManager();
	    }
	  
	  @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	    }
}
