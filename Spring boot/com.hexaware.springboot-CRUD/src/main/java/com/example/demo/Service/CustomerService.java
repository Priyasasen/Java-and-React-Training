package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.JpaRespo.CustomerRepo;

@Service
public class CustomerService {
	@Autowired CustomerRepo Respo;
	public Customer dsaveD(Customer c) {
		
		Customer c1 = Respo.save(c);
		return c1;
	}

	
	public List<Customer> getData1()
	{
		
		 List l=Respo.findAll();
		
		 return l;
	}
	public Customer getSearch(int ac)
	{
		 return Respo.findById(ac).orElse(null);
		
	}
	

	public Customer findbyac(int ac) {
		return Respo.findById(ac).orElse(null);
		
	}


	public String deleteById(int ac) {
	    if (Respo.existsById(ac)) {
	        Respo.deleteById(ac);
	        return "Customer with account number " + ac + " has been deleted.";
	    } else {
	        return "Customer with account number " + ac + " not found.";
	    }
	}
	
	public void depositToAccount(int ac, double amount) {
	    Customer customer = Respo.findById(ac).orElse(null);

	    if (customer != null) {
	        customer.setBalance(customer.getBalance() + amount);
	        Respo.save(customer);
	    } else {
	        System.out.println("Account not found: " + ac);
	    }
	}

}
