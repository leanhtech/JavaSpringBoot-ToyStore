package com.product.toystore.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class PromotionDetail {
	
	@EmbeddedId
	private PromotionDetailId promotionDetailId;
	
	private Double percentDiscount;

}
