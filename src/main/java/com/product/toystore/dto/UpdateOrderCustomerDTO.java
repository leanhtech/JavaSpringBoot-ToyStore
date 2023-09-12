package com.product.toystore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderCustomerDTO {
	
	private Integer orderId;
	private String staffId;
	private String staffIdDeliver;
	private String status;

}
