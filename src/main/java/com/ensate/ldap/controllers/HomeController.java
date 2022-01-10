package com.ensate.ldap.controllers;

import com.ensate.ldap.dao.User;
import com.ensate.ldap.services.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	PersonService personService;
	
	@RequestMapping(value = "/home")
	public String homeController(HttpSession session) {
		String userName = (String) session.getAttribute("uname");
		String password = (String) session.getAttribute("passwd");
		if (userName == null || password == null) {
			return "redirect:/login";
		} else {
			return "home";
		}

	}
	
	@RequestMapping(value= "/ldapUserdata")
	public @ResponseBody String ldapUseailsrDet(HttpSession session) throws JsonProcessingException {
		String userName =(String) session.getAttribute("uname");
//		System.out.println(userName);
		List<User> obj = new ArrayList<>();
		obj = personService.getPersonNamesByLastName(userName);
		ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        return jsonInString;
	}
}
