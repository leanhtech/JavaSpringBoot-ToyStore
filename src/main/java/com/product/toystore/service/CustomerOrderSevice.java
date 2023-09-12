package com.product.toystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.toystore.dto.UpdateOrderCustomerDTO;
import com.product.toystore.entity.CustomerOrder;
import com.product.toystore.repository.CustomerOrderRepository;
import com.product.toystore.view.UpdateOrderCusmer;

@Service
public class CustomerOrderSevice {
	
	@Autowired
	private CustomerOrderRepository customerOrderRepository;
	
	public List<CustomerOrder> getOrderByUser( int id) {
		return customerOrderRepository.findByCustomerId(id);
	}
	
	public List<CustomerOrder> getAllOrder() {
		return customerOrderRepository.findAll();
	}
	
	public List<CustomerOrder> getOrderForDeliver(String idDeliver) {
		return customerOrderRepository.findForDerliver(idDeliver);
	}

}

