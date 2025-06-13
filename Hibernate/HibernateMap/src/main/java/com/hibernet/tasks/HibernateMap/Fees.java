package com.hibernet.tasks.HibernateMap;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fees {
	@Id
	int amount;
	String status;
	
	Fees(){}
	public Fees(int amount, String status) {
		super();
		this.amount = amount;
		this.status = status;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
		
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Fees [amount=" + amount + ", status=" + status + "]";
	}

}
