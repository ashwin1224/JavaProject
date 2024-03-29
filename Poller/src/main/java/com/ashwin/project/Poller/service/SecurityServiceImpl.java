package com.ashwin.project.Poller.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailService;
	
	private static final Logger logger= LoggerFactory.getLogger(SecurityServiceImpl.class);
	
	@Override
	public String findLoggedInUsername()
	{
		Object userDetails=SecurityContextHolder.getContext()
				.getAuthentication()
				.getDetails();
		if(userDetails instanceof UserDetails)
		{
			return (((UserDetails) userDetails).getUsername());
		}
		return null;
		
	}

	@Override
	public void autoLogin(String username, String password) {
		// TODO Auto-generated method stub
		UserDetails userDetails = userDetailService.loadUserByUsername(username);						   // Loads userdetails from username
		UsernamePasswordAuthenticationToken usernamePasswordAuthentication = 							  // authentication token from username, pass and roles	
				new UsernamePasswordAuthenticationToken(username, password,userDetails.getAuthorities());// 
		authenticationManager.authenticate(usernamePasswordAuthentication);								//Actual authentication of user
		
		if(usernamePasswordAuthentication.isAuthenticated())								
		{
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			logger.debug(String.format("Auto login successful for %s", username));
		}
	}
	
	

}
