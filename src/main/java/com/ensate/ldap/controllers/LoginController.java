package com.ensate.ldap.controllers;


import com.ensate.ldap.security.Authentification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
	
	@Autowired
	Authentification auth;
	
	@RequestMapping(value = "/")
	public String entryPoint() {
		return "redirect:/login";
	}
	
	/* Simple Controller display Login Page */
	@RequestMapping(value = "/login")
	public String loginController() {
		return "login";
	}
	
	
	/*User Check Controller*/
	@RequestMapping (value = "/isValid")
	@ResponseBody
	public boolean userValidation(String uname, String passwd, HttpSession session) {
		
		session.setAttribute("uname", uname);
		session.setAttribute("passwd", passwd);
		
		
		System.out.println(uname +"  " +passwd);
		boolean isvalid = false;
		if (uname != null && passwd != null) {
				if (auth.userVerify(uname, passwd) == true) {
					isvalid = true;
					return isvalid;
				}
				else
					return isvalid;
		}
		else
			return	isvalid;	
	}

	
}
