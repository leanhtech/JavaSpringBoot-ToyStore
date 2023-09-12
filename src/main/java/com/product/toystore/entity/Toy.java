package com.product.toystore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Toy")
@Data
public class Toy {
	
	@Column(name = "SKU")
    @Id
    private String sku;
	
	@Column(name = "Name")
    private String name;
	
	@Column(name = "Status")
    private String status;
	
	@Column(name = "Description")
    private String description;
	
	@Column(name = "InventoryNumber")
    private Integer inventoryNumber;
	
	@Column(name = "Image")
    private String image;
	
	@Column(name = "IsNew")
    private Boolean isNew;
	
	@Column(name = "BrandId")
    private Integer brandId;
    
	@Column(name = "SupplierId")
    private Integer supplierId;
}