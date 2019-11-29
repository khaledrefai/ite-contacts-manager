package com.ite.contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ite.contacts.models.AuthenticationRequest;
import com.ite.contacts.models.AuthenticationResponse;
import com.ite.contacts.models.LoginUser;
import com.ite.contacts.service.MyUserDetailsService;
import com.ite.contacts.util.JwtUtil;

@Controller
public class PagesController {


	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	   
	@GetMapping("/user")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String user() {
       return  "/user";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
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
