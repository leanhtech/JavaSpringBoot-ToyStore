package com.product.toystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.toystore.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
