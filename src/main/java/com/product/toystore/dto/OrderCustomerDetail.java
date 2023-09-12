package com.product.toystore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCustomerDetail {
	
	private String sku;
	private Integer quantity;
	private Double price;

}
