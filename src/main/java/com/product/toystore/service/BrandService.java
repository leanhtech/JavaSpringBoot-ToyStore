package com.product.toystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.toystore.entity.Brand;
import com.product.toystore.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

	@Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Optional<Brand> getBrandById(Integer brandId) {
        return brandRepository.findById(brandId);
    }

    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public void deleteBrand(Integer brandId) {
        brandRepository.deleteById(brandId);
    }

    public Brand updateBrand(Brand brand) {
        return brandRepository.save(brand);
    }
}