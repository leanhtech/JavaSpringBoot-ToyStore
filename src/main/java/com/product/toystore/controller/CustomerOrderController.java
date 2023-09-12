package com.product.toystore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.toystore.entity.CustomerOrder;
import com.product.toystore.service.CustomerOrderSevice;

@RestController
@RequestMapping("/api")
public class CustomerOrderController {
	
	@Autowired
	private CustomerOrderSevice customerOrderSevice;
	
	@GetMapping("/listorder/{id}")
	public ResponseEntity<List<CustomerOrder>> orderList (@PathVariable("id") Integer id) {
		List<CustomerOrder> list = customerOrderSevice.getOrderByUser(id);
		return ResponseEntity.ok(list);
	} 
	
	@GetMapping("/admin/listorder")
	public ResponseEntity<List<CustomerOrder>> getAll () {
		List<CustomerOrder> list = customerOrderSevice.getAllOrder();
		return ResponseEntity.ok(list);
	} 
	
	@GetMapping("/admin/listorderdeliver")
	public ResponseEntity<List<CustomerOrder>> getOrdersDeliver(@RequestParam String idDeliver) {
		List<CustomerOrder> list = customerOrderSevice.getOrderForDeliver(idDeliver);
		return ResponseEntity.ok(list);
	} 

}
