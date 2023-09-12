package com.product.toystore.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCustomer {
	
	private Integer orderId;
	private Integer customerId;
	private String lastName;
	private String fristName;
	private String phone;
	private String address;
	private String sku;
	private Integer quantity;
	private Double price;

}
