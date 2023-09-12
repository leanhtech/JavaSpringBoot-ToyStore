package com.product.toystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.toystore.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, String> {

}
