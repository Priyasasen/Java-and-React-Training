package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService service;
	@PostMapping("/saveData")
	public Customer saveData1(@RequestBody Customer c)
	
	{
		Customer c1 = service.dsaveD(c);
		return c1;
	}
	
	@GetMapping("/getUsers")
    public   List<Customer> getData()
    {
		
		List l=service.getData1();
		
		return l;
		
		
    }
	@GetMapping("/getdataAc/{ac}")
	 
	 
    public  Customer getByAct(@PathVariable int  ac)
    {
		   
		  return  service.getSearch(ac);  
		   
    }
	
	@DeleteMapping("/deletebyid/{ac}")
	public String deleteCustomer(@PathVariable int ac) {
	    return service.deleteById(ac);
	}

	@PutMapping("/deposit/{actno}/{amount}")
	public String depositToAccount(@PathVariable int actno, @PathVariable double amount) {
	    if (service.getSearch(actno) != null) { service.depositToAccount(actno, amount); return "Amount ₹" + amount + " deposited."; }
	    return "Account not found.";
	}

	
	

}
