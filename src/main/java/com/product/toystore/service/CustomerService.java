package com.product.toystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.toystore.entity.Customer;
import com.product.toystore.repository.UserRepository;
import com.product.toystore.view.InforStaff;

@Service
public class CustomerService {
	@Autowired
	private UserRepository userRepository;
	
	public Customer login(String userName, String password) {
		Customer cus = userRepository.findById(1).orElse(null);
		if(cus == null || !cus.getPassword().equals(password))
			return null;
		return cus;
	}
	
	public InforStaff loginAdmin(String userName, String password) {
		InforStaff staff = userRepository.getStaff(userName);
		if(staff == null || !staff.getPassword().equals(password))
			return null;
		return staff;
	}
	
	public List<InforStaff> getAllStatff () {
		List<InforStaff> list = userRepository.getAllStaff();
		return list;
	}

}
