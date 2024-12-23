package com.eyeteroglu.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eyeteroglu.controller.ICustomerController;
import com.eyeteroglu.dto.DtoCustomer;
import com.eyeteroglu.services.ICustomerService;

@RestController
@RequestMapping(path = "/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController{

	@Autowired
	private ICustomerService iCustomerService;
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoCustomer findCustomerById(@PathVariable Long id) {
		return iCustomerService.findCustomerById(id);
	}

}
