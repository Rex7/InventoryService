package com.example.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.DTO.InventoryDTO;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepo;

	public List<InventoryDTO> checkStock(List<InventoryDTO> itemsList) {
		for (InventoryDTO item : itemsList) {
			inventoryRepo.checkAvalability(item);
		}
		return null;
	}

}
