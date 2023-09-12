package com.product.toystore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.toystore.dto.BillDTO;
import com.product.toystore.dto.OrderCustomer;
import com.product.toystore.dto.ProductPriceRequestDTO;
import com.product.toystore.dto.RequestRevenue;
import com.product.toystore.dto.RequestToy;
import com.product.toystore.dto.UpdateCategory;
import com.product.toystore.dto.UpdateOrderCustomerDTO;
import com.product.toystore.entity.ProductPrice;
import com.product.toystore.entity.ProductPriceId;
import com.product.toystore.entity.Toy;
import com.product.toystore.service.ToyService;
import com.product.toystore.view.Bill;
import com.product.toystore.view.BillId;
import com.product.toystore.view.OrderId;
import com.product.toystore.view.Revenue;
import com.product.toystore.view.ToyWithPrice;
import com.product.toystore.view.ToysOrderCustomer;
import com.product.toystore.view.UpdateOrderCusmer;

@RestController
@RequestMapping("/api")
public class ToyController {
    @Autowired
    private ToyService toyService;
    
    @GetMapping("/alltoy")
    public ResponseEntity<List<ToyWithPrice>> getAllToy() {
    	List<ToyWithPrice> bestSellingToys = toyService.getAllToy();
        return ResponseEntity.ok(bestSellingToys);
    }
    
    @GetMapping("/bestsellingtoys")
    public ResponseEntity<List<ToyWithPrice>> getBestSellingToys() {
    	List<ToyWithPrice> bestSellingToys = toyService.getBestSellingToys();
        return ResponseEntity.ok(bestSellingToys);
    }
    
    @GetMapping("/newtoys")
    public ResponseEntity<List<ToyWithPrice>> getNewToys() {
    	List<ToyWithPrice> bestSellingToys = toyService.getNewToys();
        return ResponseEntity.ok(bestSellingToys);
    }
    
    @GetMapping("/promotiontoys")
    public ResponseEntity<List<ToyWithPrice>> getPromotionToys() {
    	List<ToyWithPrice> bestSellingToys = toyService.getToysInPromotion();
        return ResponseEntity.ok(bestSellingToys);
    }
    
    @GetMapping("/category/{id}")
    public ResponseEntity<List<ToyWithPrice>> getToysByCategory(@PathVariable("id") Integer id) {
    	List<ToyWithPrice> bestSellingToys = toyService.getToysByProduct(id);
        return ResponseEntity.ok(bestSellingToys);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<ToyWithPrice>> search(@RequestParam String searchString) {
    	List<ToyWithPrice> bestSellingToys = toyService.search(searchString);
        return ResponseEntity.ok(bestSellingToys);
    }
    
    @PostMapping("/ordercustomer")
    public ResponseEntity<OrderId> orderCus (@RequestBody OrderCustomer orderCustomer) {
    	OrderId idOrder = toyService.orderCustomer(orderCustomer);
    	return ResponseEntity.ok(idOrder);
    }
    
    @PutMapping("admin/updateorder")
    public ResponseEntity<List<UpdateOrderCusmer>> updateOrder (@RequestBody UpdateOrderCustomerDTO updateOrderCustomerDTO) {
    	List<UpdateOrderCusmer> updateOrderCusmer = toyService.updateOrderCustomer(updateOrderCustomerDTO);
    	return ResponseEntity.ok(updateOrderCusmer);
    }
    
    @PostMapping("admin/createbill")
    public ResponseEntity<Bill> createBill (@RequestBody BillDTO bill) {
    	System.out.println(bill);
    	Bill billId = toyService.createBill(bill);
    	return ResponseEntity.ok(billId);
    }
    
    @GetMapping("admin/gettoysordercustomer")
    public ResponseEntity<List<ToysOrderCustomer>> getToysOrderCustomer (@RequestParam Integer idOrder) {
    	List<ToysOrderCustomer> list = toyService.getToysOrderCustomer(idOrder);
    	return ResponseEntity.ok(list);
    }
    
    @PostMapping("admin/revenue")
    public ResponseEntity<List<Revenue>> getRevenue (@RequestBody RequestRevenue requestRevenue) {
    	List<Revenue> list = toyService.getRevenue(requestRevenue);
    	return ResponseEntity.ok(list);
    }
    
    @GetMapping("admin/billbyordercustomerid")
    public ResponseEntity<Bill> getBill (@RequestParam Integer id) {
    	Bill billId = toyService.getBiillByOrderCustomerId(id);
    	return ResponseEntity.ok(billId);
    }
    
    @PostMapping("/product-prices")
    public ResponseEntity<String> addProductPrice(@RequestBody ProductPriceRequestDTO requestDTO) {
        ProductPrice productPrice = new ProductPrice();
        
        ProductPriceId productPriceId = new ProductPriceId();
        productPriceId.setStaffId(requestDTO.getStaffId());
        productPriceId.setSku(requestDTO.getSku());
        productPriceId.setUpdatedDate(requestDTO.getUpdatedDate());
        
        productPrice.setProductPriceId(productPriceId);
        productPrice.setPrice(requestDTO.getPrice());
        
        toyService.addProductPrice(productPrice);
        
        return new ResponseEntity<>("Toy price added successfully", HttpStatus.CREATED);
    }
    
    @PostMapping("/toys")
    public ResponseEntity<Toy> createToy(@RequestBody RequestToy requestToy) {
        Toy createdToy = toyService.createToy(requestToy);
        return new ResponseEntity<>(createdToy, HttpStatus.CREATED);
    }
    
    @PutMapping("/toys/{sku}")
    public ResponseEntity<Toy> updateToy(@PathVariable String sku, @RequestBody RequestToy requestToy) {
        Toy updatedToy = toyService.updateToy(sku, requestToy);
        return new ResponseEntity<>(updatedToy, HttpStatus.OK);
    }
    
    @DeleteMapping("/toys/{sku}")
    public ResponseEntity<String> deleteToy(@PathVariable String sku) {
        toyService.deleteToy(sku);
        return new ResponseEntity<>("Toy deleted successfully", HttpStatus.OK);
    }
    
    @PostMapping("/updatecategory")
    public ResponseEntity<String> updateCategory(@RequestBody UpdateCategory update) {
        String updateCategory = toyService.updateCategories(update);
        return new ResponseEntity<>(updateCategory, HttpStatus.CREATED);
    }
}
