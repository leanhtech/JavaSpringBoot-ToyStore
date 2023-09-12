package com.product.toystore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.product.toystore.entity.Customer;
import com.product.toystore.view.InforStaff;

public interface UserRepository extends JpaRepository<Customer, Integer>{

	public Optional<Customer> findByUserName(String userName);
	
	@Query(value = "SELECT * FROM v_infomation_staff WHERE UserName = :userName", nativeQuery = true)
	InforStaff getStaff(@Param("userName") String userName);
	
	@Query(value = "SELECT * FROM v_infomation_staff", nativeQuery = true)
	List<InforStaff> getAllStaff();

}
