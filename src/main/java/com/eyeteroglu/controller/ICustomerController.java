package com.eyeteroglu.controller;

import com.eyeteroglu.dto.DtoCustomer;

public interface ICustomerController {
	public DtoCustomer findCustomerById(Long id);
}
