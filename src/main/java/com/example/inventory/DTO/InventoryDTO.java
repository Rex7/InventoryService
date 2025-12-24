package com.example.inventory.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class InventoryDTO {
	@JsonProperty("product_id")
	private long productId;
	private String productName;
	@JsonIgnore
	private double price;
	@JsonIgnore
	private Integer qty;
	@JsonIgnore
	private boolean isAvailable;
	@JsonProperty("available_qty")
	private Integer availableQty;
	@JsonProperty("reserved_qty")
	private Integer reservedQty;

}
