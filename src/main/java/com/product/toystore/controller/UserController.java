package com.product.toystore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.toystore.entity.Customer;
import com.product.toystore.service.CustomerService;
import com.product.toystore.view.InforStaff;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/user/login")
	public ResponseEntity<Customer> login(@RequestParam String userName, @RequestParam String password){
		Customer cus = customerService.login(userName, password);
		return ResponseEntity.ok(cus);
	}
	
	@GetMapping("/admin/login")
	public ResponseEntity<InforStaff> loginAdmin(@RequestParam String userName, @RequestParam String password){
		InforStaff staff = customerService.loginAdmin(userName, password);
		return ResponseEntity.ok(staff);
	}
	
	@GetMapping("/admin/getallstaff")
	public ResponseEntity<List<InforStaff>> getAllStaff (){
		List<InforStaff> list = customerService.getAllStatff();
		return ResponseEntity.ok(list);
	}
}
