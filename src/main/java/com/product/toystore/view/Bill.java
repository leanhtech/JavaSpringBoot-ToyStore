package com.product.toystore.view;

import java.sql.Date;

public interface Bill {
	
	Integer getBillId();
	Date getCreateDate();
	String getTax();
	String getCustomerFirstName();
	String getCustomerLastName();
	Integer getCustomerOrderId();
	String getStatus();
	Date getOrderDate();
	String getOrderFirstName();
	String getOrderLastName();
	String getOrderPhone();
	String getOrderAddress();
	String getStaffFirstName();
	String getStaffLastName();
	String getStaffId();

}
