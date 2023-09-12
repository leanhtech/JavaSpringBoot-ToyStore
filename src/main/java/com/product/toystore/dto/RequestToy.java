package com.product.toystore.dto;

import java.io.File;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestToy {

    private String sku;
	
    private String name;
	
    private String status;
	
    private String description;

    private Integer inventoryNumber;

    private MultipartFile image;

    private Boolean isNew;

    private Integer brandId;

    private Integer supplierId;
    
    private String categoriesId;
    
    private Double price;
    
    private String staffId;
    
    private Date updatedDate;
}
