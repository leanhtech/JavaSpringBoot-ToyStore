package com.product.toystore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.toystore.entity.Brand;
import com.product.toystore.service.BrandService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brands")
public class BrandController {

	@Autowired
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brands = brandService.getAllBrands();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Integer brandId) {
        Optional<Brand> brand = brandService.getBrandById(brandId);
        return brand.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        Brand createdBrand = brandService.createBrand(brand);
        return new ResponseEntity<>(createdBrand, HttpStatus.CREATED);
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Integer brandId) {
        brandService.deleteBrand(brandId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{brandId}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Integer brandId, @RequestBody Brand brand) {
        Optional<Brand> existingBrand = brandService.getBrandById(brandId);
        if (existingBrand.isPresent()) {
            brand.setBrandId(brandId);
            Brand updatedBrand = brandService.updateBrand(brand);
            return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
