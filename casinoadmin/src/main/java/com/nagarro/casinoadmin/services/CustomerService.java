package com.nagarro.casinoadmin.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.casinoadmin.models.Customer;
import com.nagarro.casinoadmin.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customer_repository;

	public List<Customer> getAllUser() {
		List<Customer> mylist = new ArrayList<Customer>();
		customer_repository.findAll().forEach(mylist::add);
		return mylist;
	}

	public void addCustomer(Customer customer) {
		customer.setBalance(500);
		customer.setUuid(UUID.randomUUID().toString().replace("-", ""));
		customer_repository.save(customer);
	}

	public void recharge(Long id, int rechargeamount) {
		Customer updateCustomer = customer_repository.findOneById(id);
		updateCustomer.setBalance(updateCustomer.getBalance() + rechargeamount);
		customer_repository.save(updateCustomer);
	}

	public List<Customer> getSearchedUser(String Name, String Email, String Contact) {
		List<Customer> mylist = new ArrayList<Customer>();
		customer_repository.findByNameContainingAndEmailContainingAndContactContaining(Name, Email, Contact)
				.forEach(mylist::add);
		return mylist;
	}

	/*
	 * ------------------------------for client related operations
	 * ----------------------------------------------
	 */

	public Customer checkClientUuid(String uuid) {
		Customer customerHasAnEntry = customer_repository.findOneByUuid(uuid);
		return customerHasAnEntry;
	}

	public Customer blockThisAmountbyId(Long id, int blockedAmount) {
		Customer customer = customer_repository.findOneById(id);
		customer.setBlockedAmount(blockedAmount);
		customer.setBalance(customer.getBalance() - blockedAmount);
		customer_repository.save(customer);
		return customer;
	}

	public @ResponseBody Customer updateBalancebyId(Long id, int netAmount) {
		Customer customer = customer_repository.findOneById(id);
		int custonerNewBalance = customer.getBalance();
		customer.setBalance(custonerNewBalance + netAmount);
		customer.setBlockedAmount(0);
		customer_repository.save(customer);
		return customer;
	}

}
