
package com.hibernet.tasks.HibernateMap;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Courses {
	@Id
	int courseid;
	String Coursename;
	
	//@OneToOne(targetEntity =Fees.class )
	@OneToMany(targetEntity = Fees.class,cascade =CascadeType.ALL)
	
	List <Fees>feelist;
	
	
	Courses(){}

	public Courses(int courseid, String coursename) {
		super();
		this.courseid = courseid;
		Coursename = coursename;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return Coursename;
	}

	public void setCoursename(String coursename) {
		Coursename = coursename;
	}

	@Override
	public String toString() {
		return "Courses [courseid=" + courseid + ", Coursename=" + Coursename + "]";
	}
	

}
