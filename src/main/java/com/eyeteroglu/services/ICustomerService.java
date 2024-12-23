package com.eyeteroglu.services;

import com.eyeteroglu.dto.DtoCustomer;

public interface ICustomerService {
	public DtoCustomer findCustomerById(Long id);
}
