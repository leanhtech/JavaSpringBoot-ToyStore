package com.product.toystore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Brand")
@Data
public class Brand {
	
	@Column(name = "BrandId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandId;
	
	@Column(name = "Name")
    private String name;
	
	@Column(name = "Website")
    private String website;
	
	@Column(name = "Phone")
    private String phone;
	
	@Column(name = "Address")
    private String address;
}