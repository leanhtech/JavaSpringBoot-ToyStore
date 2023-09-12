package com.product.toystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.toystore.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
