package com.nagarro.casinoadmin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	// unique user id
	private String uuid; 
	
    private String name;

    private String email;
    
    private String dateOfBirth;
     
    private String contact;
    
    private int balance;
    
    private int blockedAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getBlockedAmount() {
		return blockedAmount;
	}

	public void setBlockedAmount(int blockedAmount) {
		this.blockedAmount = blockedAmount;
	}
    
}
