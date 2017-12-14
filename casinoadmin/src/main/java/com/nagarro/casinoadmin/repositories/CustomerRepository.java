package com.nagarro.casinoadmin.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.casinoadmin.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	public List<Customer> findByNameContainingAndEmailContainingAndContactContaining(String name,String email,String contact);

	public Customer findOneById(Long id);

	public Customer findOneByUuid(String uuid);
	

}