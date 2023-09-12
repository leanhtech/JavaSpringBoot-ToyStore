package com.product.toystore.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customerorder")
@Data
public class CustomerOrder {

	@Column(name ="CustomerOrderId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerOrderId;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name="OrderDate")
	private Date orderDate;
	
	@Column(name="FristName")
	private String fristName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="StaffId")
	private String staffId;
	
	@Column(name="StaffIdDeliver")
	private String staffIdDeliver;
	
	@Column(name="CustomerId")
	private Integer customerId;
}
