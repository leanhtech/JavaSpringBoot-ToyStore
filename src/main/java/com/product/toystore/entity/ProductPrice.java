package com.product.toystore.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPrice {

	@EmbeddedId
	private ProductPriceId productPriceId;
	
	@Column(name = "Price")
	private Double price;
    
	
}
