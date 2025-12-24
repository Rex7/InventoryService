package com.example.inventory.service;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.inventory.DTO.InventoryDTO;

@Repository
public class InventoryRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	public InventoryRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}

	public InventoryDTO checkAvalability(InventoryDTO item) {
		String sql = """
			    SELECT 
			        product_id    AS productId,
			        available_qty AS availableQty,
			        reserved_qty  AS reservedQty
			    FROM inventory_saga_demo
			    WHERE product_id = ?
			""";	
		InventoryDTO singleItem=jdbcTemplate.queryForObject(sql, 
				new BeanPropertyRowMapper<>(InventoryDTO.class),new Object[] {item.getProductId()});
	return singleItem;
	}

	public Integer reserveItem(InventoryDTO item) {
		Integer avaiableItem=item.getAvailableQty()-item.getQty();
		Integer reserveStocks=item.getReservedQty()+item.getQty();
		String sql="""
				update inventory_saga_demo
				set available_qty =? , reserved_qty =  ?
				where product_id =?
				""";
		
		Integer count=jdbcTemplate.update(sql, avaiableItem,reserveStocks,item.getProductId());
		return count;
		
		
	}

}
