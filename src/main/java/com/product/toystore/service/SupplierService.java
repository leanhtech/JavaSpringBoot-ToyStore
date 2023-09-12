package com.product.toystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.toystore.entity.Supplier;
import com.product.toystore.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

	@Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Integer supplierId) {
        return supplierRepository.findById(supplierId);
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Integer supplierId) {
        supplierRepository.deleteById(supplierId);
    }

    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}
