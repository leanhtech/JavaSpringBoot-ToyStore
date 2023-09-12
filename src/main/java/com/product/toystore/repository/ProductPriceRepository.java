package com.product.toystore.repository;

import org.springframework.data.repository.CrudRepository;

import com.product.toystore.entity.ProductPrice;
import com.product.toystore.entity.ProductPriceId;

public interface ProductPriceRepository extends CrudRepository<ProductPrice, ProductPriceId> {
}
