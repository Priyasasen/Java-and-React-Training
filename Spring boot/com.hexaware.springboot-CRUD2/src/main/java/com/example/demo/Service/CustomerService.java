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
	
	public int UpdateBal(int ac, double bal) {
	    return Respo.deposit1(ac, bal);
	}


	
	public List<Customer> getData1()
	{
		
		 List l=Respo.findAllCustomer();
		
		 return l;
	}
	public Customer getSearch(int ac)
	{
		 return Respo.findByActJPQL(ac);
		
	}
	public Customer getByName(String name) {
	    return Respo.findByNameJPQL(name);
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
	
	public int withdrawbyid(int ac, double bal) {
		return Respo.withdraw(ac, bal);
	}
	public String deleteByIdCustom(int ac) {
	    int result = Respo.deleteByActno(ac);
	    if (result == 1) {
	        return "Customer deleted successfully.";
	    } else {
	        return "Customer not found.";
	    }
	}


}
