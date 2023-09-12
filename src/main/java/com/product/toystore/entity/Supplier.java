package com.product.toystore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Supplier")
@Data
public class Supplier {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierId")
    private Integer supplierId;
	
	@Column(name = "Name")
    private String name;
	
	@Column(name = "Address")
    private String address;
	
	@Column(name = "Email")
    private String email;
	
	@Column(name = "Phone")
    private String phone;
    
}
