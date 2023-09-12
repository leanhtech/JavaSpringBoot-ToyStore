package com.product.toystore.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceId implements Serializable {
	
	@Column(name = "StaffId")
    private String staffId;

    @Column(name = "SKU")
    private String sku;
    
    @Column(name = "UpdatedDate")
    private Date updatedDate;

}
