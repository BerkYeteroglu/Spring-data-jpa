package com.eyeteroglu.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyeteroglu.dto.DtoAddress;
import com.eyeteroglu.dto.DtoCustomer;
import com.eyeteroglu.entites.Address;
import com.eyeteroglu.entites.Customer;
import com.eyeteroglu.repository.CustomerRepository;
import com.eyeteroglu.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public DtoCustomer findCustomerById(Long id) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		
		Optional<Customer> optional = customerRepository.findById(id);
		
		if(optional.isPresent()) {
			Customer customer = optional.get();
			Address address = optional.get().getAddress();
			
			BeanUtils.copyProperties(customer, dtoCustomer);
			BeanUtils.copyProperties(address, dtoAddress);
			
			dtoCustomer.setAddress(dtoAddress);
		}
		return dtoCustomer;
	}

}
