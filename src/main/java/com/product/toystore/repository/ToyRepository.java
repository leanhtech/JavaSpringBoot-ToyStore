package com.product.toystore.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.product.toystore.entity.Toy;
import com.product.toystore.view.Bill;
import com.product.toystore.view.BillId;
import com.product.toystore.view.OrderId;
import com.product.toystore.view.Revenue;
import com.product.toystore.view.ToyWithPrice;
import com.product.toystore.view.ToysOrderCustomer;
import com.product.toystore.view.UpdateOrderCusmer;

public interface ToyRepository extends JpaRepository<Toy, String>{
	@Query(nativeQuery = true, value = "SELECT * FROM toy_store.productwithprice")
	List<ToyWithPrice> getView();
	
	@Query(value = "CALL get_best_selling_toys();", nativeQuery = true)
	List<ToyWithPrice> getBestSellingToys();
	
	@Query(value = "CALL get_toys_by_category(:id);", nativeQuery = true)
	List<ToyWithPrice> getToysByCategory(@Param("id") Integer id);
	
	@Query(value = "CALL search_toys(:query);", nativeQuery = true)
	List<ToyWithPrice> search_toys(@Param("query") String query);
	
	@Query(value = "CALL place_order_customer(:orderId, :customerId, :sku, "
			+ ":quantiry, :price, :lastName, :fristName, :phone, :address);", nativeQuery = true)
	OrderId orderCustomer(@Param("orderId") Integer orderId,
			@Param("customerId") Integer customerId,
			@Param("sku") String sku,
			@Param("quantiry") Integer quantiry,
			@Param("price") Double price,
			@Param("lastName") String lastName,
			@Param("fristName") String fristName,
			@Param("phone") String phone,
			@Param("address") String address);
	
	@Query(value = "CALL update_order_customer_2(:orderId, :staffId, :staffIdDeliver, :status);", nativeQuery = true)
	List<UpdateOrderCusmer> updateOrderCustomer(@Param("orderId") Integer orderId,
			@Param("staffId") String staffId,
			@Param("staffIdDeliver") String staffIdDeliver,
			@Param("status") String status);
	
	@Query(value = "CALL sp_create_bill(:staffId, :orderCustomerId, :tax, :fristName, :lastName);", nativeQuery = true)
	BillId createBill(@Param("staffId") String staffId,
			@Param("orderCustomerId") Integer orderCustomerId,
			@Param("tax") String tax,
			@Param("lastName") String lastName,
			@Param("fristName") String fristName);
	
	@Query(value = "SELECT * FROM v_bill_info WHERE BillId = :id", nativeQuery = true)
	Bill getBill(@Param("id") Integer id);
	
	@Query(value = "SELECT * FROM v_bill_info WHERE CustomerOrderId = :id", nativeQuery = true)
	Bill getBillByOrderCustomerId(@Param("id") Integer customerOrderIdid);
	
	@Query(value = "CALL sp_calculate_revenue_2(:dateStart, :dateEnd);", nativeQuery = true)
	List<Revenue> getRevenue (@Param("dateStart") Date dateStart, @Param("dateEnd") Date dateEnd);
	
	@Query(value = "CALL sp_calculate_revenue_month(:dateStart, :dateEnd);", nativeQuery = true)
	List<Revenue> getRevenueMonth (@Param("dateStart") Date dateStart, @Param("dateEnd") Date dateEnd);
	
	@Query(value = "CALL sp_get_toys_order_customer(:idOrder);", nativeQuery = true)
	List<ToysOrderCustomer> getToysOrderCustomer (@Param("idOrder") Integer idOrder);
	
	@Query(value = "CALL UpdateToyCategories(:sku, :categoryIds);", nativeQuery = true)
	String updateCatgory(@Param("sku") String sku,  @Param("categoryIds") String categories);
	
}
