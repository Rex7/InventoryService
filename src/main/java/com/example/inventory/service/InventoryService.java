package com.example.inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.DTO.InventoryDTO;
import com.example.inventory.DTO.RequestDTO;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepo;

	public List<InventoryDTO> checkStock(List<InventoryDTO> itemsList) {
		List<InventoryDTO> tempList=new ArrayList<>();
		for (InventoryDTO item : itemsList) {
			InventoryDTO temp=(inventoryRepo.checkAvalability(item));
			if(temp.getAvailableQty()>0) {
				temp.setAvailable(true);
			}
			else {
				temp.setAvailable(false);

			}
			tempList.add(temp);
		}
		return tempList;
	}

	public List<String> reservceStock(List<RequestDTO> itemsList) {
		List<InventoryDTO> tempList=new ArrayList<>();
		List<String> responseList=new ArrayList<>();
		for (RequestDTO item : itemsList) {
			InventoryDTO dto=new InventoryDTO();
			dto.setProductId(item.getProductId());
			InventoryDTO temp=(inventoryRepo.checkAvalability(dto));
			if(temp.getAvailableQty()>=item.getQty()) {
				temp.setAvailable(true);
				temp.setQty(item.getQty());
			int count=	inventoryRepo.reserveItem(temp);
			if(count>0) {
				responseList.add("success");
			}
			else {
				responseList.add("failure");
			}
			}
			else {
				temp.setAvailable(false);
				responseList.add("failure");
			}
			tempList.add(temp);
		}
		return responseList;
	}

}
