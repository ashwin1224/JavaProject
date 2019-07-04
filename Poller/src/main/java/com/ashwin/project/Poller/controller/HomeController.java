package com.ashwin.project.Poller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
//	@RequestMapping(value= "/login",method= RequestMethod.GET)
//	public String loginController() {
//
//		return "logintest";
//	}
	
//	@RequestMapping(value= "/login",method= RequestMethod.GET)
//	public String loginControllererror(ModelMap model,@RequestParam(required=false) String error) {
//		if(error!=null)
//		{
//			model.put("errormsg","Invalid User ID or Password");
//		}
//		
//		return "logintest";
//	}
	@RequestMapping(value= "/homepage",method= RequestMethod.GET)
	public String homepageDisplay() {
		
		return "homepage";
	}
}
