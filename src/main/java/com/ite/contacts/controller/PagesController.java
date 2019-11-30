package com.ite.contacts.controller;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PagesController {


	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	   
	@GetMapping("/user")
    public String user() {
       return  "/user";
    }

    @GetMapping("/admin")
    public String admin() {
    	  return "/admin";
    }
    
    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
    @GetMapping("/login")
    public String login() {
        return "/login";
    }
    
}
