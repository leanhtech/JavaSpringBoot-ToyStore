package com.product.toystore.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceRequestDTO {
    private String staffId;
    private String sku;
    private Date updatedDate;
    private Double price;
}
