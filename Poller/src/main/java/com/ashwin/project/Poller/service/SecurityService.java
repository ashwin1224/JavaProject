package com.ashwin.project.Poller.service;

public interface SecurityService {
	String findLoggedInUsername();
	void autoLogin(String username,String password);
}
