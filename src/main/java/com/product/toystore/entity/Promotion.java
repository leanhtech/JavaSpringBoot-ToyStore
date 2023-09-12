package com.product.toystore.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Promotion")
@Data
public class Promotion {
	
	@Column(name = "PromotionId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer promotionId;
    
	@Column(name = "Name")
    private String name;
    
	@Column(name = "DateStart")
    private Date dateStart;
    
	@Column(name = "DateEnd")
    private Date dateEnd;
    
	@Column(name = "StaffId")
    private String StaffId;
}