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

	public void checkAvalability(InventoryDTO item) {
		String sql="select *from INVENTORY  where PRODUCT_ID = ? ";
		InventoryDTO singleItem=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(InventoryDTO.class),item.getProductId());
	}

}
