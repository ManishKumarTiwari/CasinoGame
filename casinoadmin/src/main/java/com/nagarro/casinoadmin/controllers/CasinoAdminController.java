package com.nagarro.casinoadmin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CasinoAdminController {
	
	// Home page for admin
	   @RequestMapping("/adminpage")
	   public String home() {	              
	       return "admin";
	   }
	   
	   //serving register page to the admin   
	   @RequestMapping("/registeruser")
	   public String register() {		  
		   return "register";
	   }

}


