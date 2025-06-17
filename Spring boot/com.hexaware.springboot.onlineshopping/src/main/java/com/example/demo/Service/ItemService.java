package com.example.demo.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JpaRespo.ItemRepo;
import com.example.demo.entity.Item;

@Service
public class ItemService {
	
	@Autowired ItemRepo Respo;
	public Item additem(Item i) {
	Item i1 = Respo.save(i);
	return i1;
	}
	
	public Item getItemByCode(String code) {
	    return Respo.findById(code).orElse(null);
	}

	public Item updatePrice(String code, double price) {
	    Item item = Respo.findById(code).orElse(null);
	    if (item != null) {
	        item.setPrice(BigDecimal.valueOf(price));
	        return Respo.save(item);
	    }
	    return null;
	}
	
	public List<Object> generateBill(String name, int qty) {
	    Item item = Respo.findByName(name);

	    if (item != null && item.getQuantity() >= qty) {
	        BigDecimal total = item.getPrice().multiply(BigDecimal.valueOf(qty));
	        item.setQuantity(item.getQuantity() - qty);
	        Respo.save(item);
	        return List.of(item.getName(), item.getPrice(), qty, total);
	    }

	    return List.of("Item not found or insufficient quantity.");
	}

	
	
	
	
	
	
	
	
	
	
}