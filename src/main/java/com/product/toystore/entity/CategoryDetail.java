package com.product.toystore.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class CategoryDetail {
	
	@EmbeddedId
	private CategoryDetailId categoryDetailId;

}
