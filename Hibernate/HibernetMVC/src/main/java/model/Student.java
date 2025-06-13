package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	int rollno;
	String name;
	double marks;
	
	
	
 
	public Student(int rollno, String name, double marks) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}
 
 
 
	public Student() {
		// TODO Auto-generated constructor stub
	}



	public int getRollno() {
		return rollno;
	}
 
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public double getMarks() {
		return marks;
	}
 
	public void setMarks(double marks) {
		this.marks = marks;
	}
 
 
 
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
 
}