package com.product.toystore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.product.toystore.entity.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository <CustomerOrder, Integer>{

	public List<CustomerOrder> findByCustomerId(Integer CustomerId);
	
	@Query(value = "SELECT * FROM customerorder WHERE StaffIdDeliver = :idDeliver and (Status = 'Delivering' or Status = 'Done')", nativeQuery = true)
	public List<CustomerOrder> findForDerliver(@Param("idDeliver") String idDeliver);

}
