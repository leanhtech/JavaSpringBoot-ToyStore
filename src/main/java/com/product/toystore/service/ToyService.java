package com.product.toystore.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.product.toystore.dto.BillDTO;
import com.product.toystore.dto.OrderCustomer;
import com.product.toystore.dto.OrderCustomerDetail;
import com.product.toystore.dto.RequestRevenue;
import com.product.toystore.dto.RequestToy;
import com.product.toystore.dto.UpdateCategory;
import com.product.toystore.dto.UpdateOrderCustomerDTO;
import com.product.toystore.entity.ProductPrice;
import com.product.toystore.entity.ProductPriceId;
import com.product.toystore.entity.Toy;
import com.product.toystore.repository.ProductPriceRepository;
import com.product.toystore.repository.ToyRepository;
import com.product.toystore.view.Bill;
import com.product.toystore.view.BillId;
import com.product.toystore.view.OrderId;
import com.product.toystore.view.Revenue;
import com.product.toystore.view.ToyWithPrice;
import com.product.toystore.view.ToysOrderCustomer;
import com.product.toystore.view.UpdateOrderCusmer;

@Service
public class ToyService {
    @Autowired
    private ToyRepository toyRepository;
    
    @Autowired
    private Image image;
    
    @Autowired
    private ProductPriceRepository productPriceRepository;

    public List<ToyWithPrice> getAllToy() {
        return toyRepository.getView();
    }
    
    public List<ToyWithPrice> getBestSellingToys() {
    	return toyRepository.getBestSellingToys();
    }
    
    public List<ToyWithPrice> getNewToys() {
    	return getAllToy().stream()
                .filter(toy -> toy.getIsNew().equals(true))
                .collect(Collectors.toList());
    }
    
    public List<ToyWithPrice> getToysInPromotion() {
    	return getAllToy().stream()
    			.filter(toy -> toy.getPercentDiscount() != null)
    			.collect(Collectors.toList());
    }
    
    public List<ToyWithPrice> getToysByProduct(Integer id) {
    	return toyRepository.getToysByCategory(id);
    }
    
    public List<ToyWithPrice> search(String query) {
    	return toyRepository.search_toys(query);
    }
    
    public OrderId orderCustomer (OrderCustomer orderInfo) {
    	
    	OrderId id = toyRepository.orderCustomer(orderInfo.getOrderId(),
    			orderInfo.getCustomerId(), 
    			orderInfo.getSku(),
    			orderInfo.getQuantity(), 
    			orderInfo.getPrice(), 
    			orderInfo.getLastName(), 
    			orderInfo.getFristName(), 
    			orderInfo.getPhone(), 
    			orderInfo.getAddress());
    	
    	return id;
    }
    
	public List<UpdateOrderCusmer> updateOrderCustomer(UpdateOrderCustomerDTO updateOrderCustomerDTO) {
		return toyRepository.updateOrderCustomer(updateOrderCustomerDTO.getOrderId(), 
				updateOrderCustomerDTO.getStaffId(), 
				updateOrderCustomerDTO.getStaffIdDeliver(),
				updateOrderCustomerDTO.getStatus());
	}
	
	public Bill getBiillByOrderCustomerId (Integer orderCustomerId) {
		return toyRepository.getBillByOrderCustomerId(orderCustomerId);
	}
	
	public Bill createBill (BillDTO bill) {
		BillId id = toyRepository.createBill(bill.getStaffId(), 
				bill.getOrderCustomerId(), 
				bill.getTax(), 
				bill.getLastName(), 
				bill.getFristName());
		
		return toyRepository.getBill(id.getBillId());
	}
	
	public List<ToysOrderCustomer> getToysOrderCustomer(Integer idOrder) {
		return toyRepository.getToysOrderCustomer(idOrder);
	}
	
	public List<Revenue> getRevenue(RequestRevenue requestRevenue) {
		return toyRepository.getRevenue(requestRevenue.getDateStart(), requestRevenue.getDateEnd());
	}
	
	public List<Toy> getAllToys() {
        return toyRepository.findAll();
    }

    public Optional<Toy> getToyById(String sku) {
        return toyRepository.findById(sku);
    }

    public Toy createToy(RequestToy requestToy) {
    	
    	String imageUrl = null;
        MultipartFile imageFile = requestToy.getImage();
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                imageUrl = image.saveImage(imageFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    	
        Toy toy = new Toy();
        toy.setSku(requestToy.getSku());
        toy.setName(requestToy.getName());
        toy.setStatus(requestToy.getStatus());
        toy.setDescription(requestToy.getDescription());
        toy.setInventoryNumber(requestToy.getInventoryNumber());
        toy.setIsNew(requestToy.getIsNew());
        toy.setBrandId(requestToy.getBrandId());
        toy.setSupplierId(requestToy.getSupplierId());
        if(imageUrl != null)
        	toy.setImage(imageUrl);
        Toy toySaved = toyRepository.save(toy);
        toyRepository.updateCatgory(toySaved.getSku(), requestToy.getCategoriesId());
        ProductPriceId priceId = new ProductPriceId(requestToy.getStaffId(), requestToy.getSku(), requestToy.getUpdatedDate());
        ProductPrice price = new ProductPrice(priceId, requestToy.getPrice());
        addProductPrice(price);
        return toySaved;
    }

    public Toy updateToy(String sku, RequestToy requestToy) {
    	String imageUrl = null;
        MultipartFile imageFile = requestToy.getImage();
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                imageUrl = image.saveImage(imageFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    	
        Toy toy = toyRepository.findById(sku).orElse(null);
        //toy.setSku(requestToy.getSku());
        toy.setName(requestToy.getName());
        toy.setStatus(requestToy.getStatus());
        toy.setDescription(requestToy.getDescription());
        toy.setInventoryNumber(requestToy.getInventoryNumber());
        toy.setIsNew(requestToy.getIsNew());
        toy.setBrandId(requestToy.getBrandId());
        toy.setSupplierId(requestToy.getSupplierId());
        if(imageUrl != null)
        	toy.setImage(imageUrl);
        Toy toySaved = toyRepository.save(toy);
        toyRepository.updateCatgory(toySaved.getSku(), requestToy.getCategoriesId());
        ProductPriceId priceId = new ProductPriceId(requestToy.getStaffId(), requestToy.getSku(), requestToy.getUpdatedDate());
        ProductPrice price = new ProductPrice(priceId, requestToy.getPrice());
        addProductPrice(price);
        return toySaved;
    }

    public void deleteToy(String sku) {
        toyRepository.deleteById(sku);
    }
    
    public void addProductPrice(ProductPrice productPrice) {
        productPriceRepository.save(productPrice);
    }
    
    public String updateCategories(UpdateCategory updateCategory) {
    	return toyRepository.updateCatgory(updateCategory.getSku(), updateCategory.getIdCategories());
    }

}
