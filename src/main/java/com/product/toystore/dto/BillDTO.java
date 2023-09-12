package com.product.toystore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {
	
	private String staffId;
	private Integer orderCustomerId;
	private String tax;
	private String fristName;
	private String lastName;
	
}
