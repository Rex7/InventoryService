package com.example.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.inventory.DTO.InventoryDTO;
import com.example.inventory.service.InventoryService;

@RequestMapping("/inventory-service")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	
	
	@PostMapping("/confirmAvailability")
	public InventoryDTO checkStock(List<InventoryDTO> itemsList) {
		List<InventoryDTO>  items=  inventoryService.checkStock(itemsList);
		return null;
	}

}
