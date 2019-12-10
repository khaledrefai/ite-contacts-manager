package com.ite.contacts.controller;



import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ite.contacts.entity.Contact;
import com.ite.contacts.entity.User;
import com.ite.contacts.repository.ContactRepository;
import com.ite.contacts.repository.UserRepository;

@Controller
public class ContactsController {

	@Autowired
	ContactRepository contactrep;

	@Autowired
	UserRepository userrep;
	
	
	 @GetMapping("/newcontact")
	    public String showSignUpForm(Contact contact) {
	        return "add-contact";
	    }
	 
		@GetMapping("/contacts")
	    public String user(Model model,Principal principal) {
			 String username = principal.getName();
		       User user = userrep.findByUsername(username).get();
		        model.addAttribute("contacts", contactrep.getContacts(user.getDepartment(), user.getRole()));

	       return  "contacts";
	    }
	 
	  @PostMapping("/addcontact")
	    public String addUser(@Valid Contact contact, BindingResult result, Model model,Principal principal) {
	        if (result.hasErrors()) {
	            return "add-contact";
	        }
	        String username = principal.getName();
	        User user = userrep.findByUsername(username).get();
	        contact.setDepartment(user.getDepartment());
	        contactrep.save(contact);
	    	        model.addAttribute("contacts", contactrep.getContacts(user.getDepartment(), user.getRole()));
	        return "contacts";
	    }
	 
	  @GetMapping("/edit/{id}")
	  public String showUpdateForm(@PathVariable("id") long id, Model model) {
		  Contact contact = contactrep.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	       
	      model.addAttribute("contact", contact);
	      return "update-contact";
	  }
	  
	  @PostMapping("/update/{id}")
	  public String updateUser(@PathVariable("id") long id, @Valid Contact contact , 
	    BindingResult result, Model model,Principal principal) {
		  
	      if (result.hasErrors()) {
	    	  contact.setId(id);
	          return "update-contact";
	      }
	           
	      contactrep.save(contact);
	      String username = principal.getName();
	        User user = userrep.findByUsername(username).get();
	        contact.setDepartment(user.getDepartment());
	        contactrep.save(contact);
	   
	        model.addAttribute("contacts",  contactrep.getContacts(user.getDepartment(), user.getRole()));
	      return "contacts";
	  }

	  @GetMapping("/delete/{id}")
	  public String deleteUser(@PathVariable("id") long id, Model model,Principal principal) {
		  Contact contact = contactrep.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		  contactrep.delete(contact);
		  String username = principal.getName();
	        User user = userrep.findByUsername(username).get();
	      model.addAttribute("contacts", contactrep.getContacts(user.getDepartment(), user.getRole()));
	      return "contacts";
	  }
	  
	   

	  
	  
}
