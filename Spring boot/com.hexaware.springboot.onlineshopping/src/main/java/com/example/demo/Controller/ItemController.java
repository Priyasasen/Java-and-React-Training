package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ItemService;
import com.example.demo.entity.Item;
@RestController
public class ItemController {
	
	   @Autowired
	    ItemService service;

	    @PostMapping("/saveitem")
	    public Item addItem(@RequestBody Item i) {
	        return service.additem(i);
	    }
	    
	    @GetMapping("/getitem/{code}")
	    public Item getItem(@PathVariable String code) {
	        return service.getItemByCode(code);
	    }
	    
	    @PutMapping("/updateprice/{code}/{price}")
	    public Item updatePrice(@PathVariable String code, @PathVariable double price) {
	        return service.updatePrice(code, price);
	    }
	   
	    @GetMapping("/generatebill/{name}/{qty}")
	    public List<Object> generateBill(@PathVariable String name, @PathVariable int qty) {
	        return service.generateBill(name, qty);
	    }


	}


