package com.product.toystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.toystore.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
