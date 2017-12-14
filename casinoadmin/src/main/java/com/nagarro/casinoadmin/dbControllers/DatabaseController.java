package com.nagarro.casinoadmin.dbControllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.casinoadmin.models.Customer;
import com.nagarro.casinoadmin.services.CustomerService;

@Controller
public class DatabaseController {
	@Autowired
	private CustomerService customerservice;
	
	/**
	 * 
	 * @param customer
	 * @return register user page
	 */
	@RequestMapping(value="/save",method = RequestMethod.POST)
	   public String saveCustomer(Customer customer) {
		   customerservice.addCustomer(customer);
		   return ("redirect:/registeruser");
	   }
	/**
	 * 
	 * @param allUserModel
	 * @return
	 */
	@RequestMapping("/getAllUser")
	   public String getAllUser(Model allUserModel) {		   
		   List<Customer> customerlist=customerservice.getAllUser();	   
		   allUserModel.addAttribute("customer", customerlist);	   	   
		   return "userlist";
	   }
	/**
	 * 
	 * @param allUserModel
	 * @param customer
	 * @return
	 */
	@RequestMapping(value="/getSearchedUser",method = RequestMethod.POST)
	   public String getSearchedUser(Model allUserModel,@ModelAttribute("Customer") Customer customer) {				
			final String nameSequence=(customer.getName()!=null)? customer.getName() : "";
			final String emailSequence=(customer.getEmail()!=null)? customer.getEmail() : "";
			final String contactSequence=(customer.getContact()!=null)? customer.getContact() : "";

		   List<Customer> customerlist=customerservice.getSearchedUser(nameSequence,emailSequence,contactSequence);	   
		   allUserModel.addAttribute("customer", customerlist);	   
		   return "userlist";
	   }
	/**
	 * 
	 * @param allUserModel
	 * @param customer
	 * @return
	 */
	@RequestMapping(value="/recharge",method = RequestMethod.POST)
		public String recharge(Model allUserModel,@ModelAttribute("Customer") Customer customer) {				
			final int rechargeamount=customer.getBalance();
			final Long id=customer.getId();
			customerservice.recharge(id,rechargeamount); 
			
			List<Customer> customerlist=customerservice.getAllUser();   
			allUserModel.addAttribute("customer", customerlist);	   
			return "userlist";
		
	}
	
	/* ------------------------------Rest API code called by client server ------------------------------------------- */
	
	/**
	 * to check uuid exists
	 * @param uuid
	 * @return
	 */
	@CrossOrigin("*")
	@RequestMapping("/checkClientUuid/{uuid}")
	    public @ResponseBody Customer checkClientUuid(@PathVariable("uuid") String uuid) {	
			return customerservice.checkClientUuid(uuid);	   	   		   
	   }
	
	/**
	 * to block the amount
	 * @param id
	 * @param blockedAmount
	 */
	
	//block the amount
	@CrossOrigin("*")
	@RequestMapping("/blockAmount/{id}/{blockedAmount}")
	public @ResponseBody Customer blockThisAmount(@PathVariable("id") Long id,@PathVariable("blockedAmount") int blockedAmount) {		
		return customerservice.blockThisAmountbyId(id,blockedAmount);	   	   		   
	}
	
	//update final amount
	@CrossOrigin("*")
	@RequestMapping("updateBalance/{id}/{netAmount}")
	public @ResponseBody Customer updateBalance(@PathVariable("id") Long id,@PathVariable("netAmount") int netAmount){
		return customerservice.updateBalancebyId(id,netAmount);
	}
		   
}
