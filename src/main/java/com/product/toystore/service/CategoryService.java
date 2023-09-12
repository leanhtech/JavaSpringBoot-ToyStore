package com.product.toystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.toystore.entity.Category;
import com.product.toystore.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

    

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
}
