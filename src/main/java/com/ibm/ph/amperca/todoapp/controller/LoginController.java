package com.ibm.ph.amperca.todoapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(method=RequestMethod.GET,value="/login")
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(method=RequestMethod.GET,value="/")
	public String home() {
		return "redirect:/login";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/logout")
	public String logOut(HttpServletRequest req, HttpServletResponse res) {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		
		if(au != null) {
			au.setAuthenticated(false);
			new SecurityContextLogoutHandler().logout(req, res, au);
		}
		
		return "redirect:/login?logout";
	}
}
