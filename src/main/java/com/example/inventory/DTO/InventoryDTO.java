package com.example.inventory.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class InventoryDTO {
	
	private long productId;
	private String productName;
	private double price;
	private Integer qty;
	private boolean isAvailable;

}
