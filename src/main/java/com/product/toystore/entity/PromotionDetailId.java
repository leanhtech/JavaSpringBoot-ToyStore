package com.product.toystore.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@SuppressWarnings("serial")
@Embeddable
@Data
public class PromotionDetailId implements Serializable {
	
    @Column(name = "PromotionId")
    private Integer promotionId;

    @Column(name = "SKU")
    private String sku;

}
