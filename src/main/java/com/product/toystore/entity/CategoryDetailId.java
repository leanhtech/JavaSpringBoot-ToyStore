package com.product.toystore.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@SuppressWarnings("serial")
@Embeddable
@Data
public class CategoryDetailId implements Serializable {
	
	@ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;
	
	@ManyToOne
    @JoinColumn(name = "SKU")
    private Toy toy;

}
