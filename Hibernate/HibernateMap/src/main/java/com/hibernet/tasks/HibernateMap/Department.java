package com.hibernet.tasks.HibernateMap;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Department {
@Id	
int dCode;
	
	String dName;
	@OneToMany(targetEntity = Employee.class,cascade =CascadeType.ALL,fetch=FetchType.EAGER)
	
	 List <Employee>emplist;
	
	
	Department()
	{
		
	}
	
 
	public Department(int dCode, String dName, List<Employee> emplist) {
		super();
		this.dCode = dCode;
		this.dName = dName;
		this.emplist = emplist;
	}
 
 
	public int getdCode() {
		return dCode;
	}
 
 
	public void setdCode(int dCode) {
		this.dCode = dCode;
	}
 
 
	public String getdName() {
		return dName;
	}
 
 
	public void setdName(String dName) {
		this.dName = dName;
	}
 
 
	public List<Employee> getEmplist() {
		return emplist;
	}
 
 
	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
 
 
	@Override
	public String toString() {
		return "Department [dCode=" + dCode + ", dName=" + dName + ", emplist=" + emplist + "]";
	}
	
	
}
 	


