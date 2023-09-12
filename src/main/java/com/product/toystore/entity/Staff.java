package com.product.toystore.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Staff")
@Data
public class Staff {
	
	@Column(name = "StaffId")
    @Id
    private String staffId;
	
	@Column(name = "FristName")
    private String firstName;
	
	@Column(name = "LastName")
    private String lastName;
	
	@Column(name = "Email")
    private String email;
	
	@Column(name = "Phone")
    private String phone;
	
	@Column(name = "Gender")
    private String gender;
	
	@Column(name = "Address")
    private String address;
	
	@Column(name = "UserName")
    private String userName;
	
	@Column(name = "Password")
    private String password;
	
	@Column(name = "Birthday")
    private Date birthday;
}
