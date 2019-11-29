package com.ite.contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ite.contacts.service.MyUserDetailsService;
import com.ite.contacts.util.CookieUtil;
import com.ite.contacts.util.JwtUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	   private static final String jwtTokenCookieName = "JWT-TOKEN";
	    private static final String signingKey = "signingKey";
	    private static final Map<String, String> credentials = new HashMap<>();

	  



	    @RequestMapping(value = "loginauth", method = RequestMethod.POST)
	    public String login(HttpServletResponse httpServletResponse, @RequestParam String username, @RequestParam  String password) throws Exception{

			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(username, password)
				);
			}
			catch (BadCredentialsException e) {
				throw new Exception("Incorrect username or password", e);
			}


			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(username);

			final String jwt = jwtTokenUtil.generateToken(userDetails);
			
	        CookieUtil.create(httpServletResponse, jwtTokenCookieName, jwt, false, -1, "localhost");

	        return "home" ; //redirect:home
	    }
	    
}
