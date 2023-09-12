package com.product.toystore.view;

public interface ToyWithPrice {
	
	String getSKU();
    String getName();
    String getStatus();
    String getDescription();
    Integer getInventoryNumber();
    String getImage();
    Boolean getIsNew();
    Integer getBrandId();
    Integer getSupplierId();
    Double getPrice();
    Double getPercentDiscount();

}
