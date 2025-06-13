package MavenJdbcExample.Employee.Spring;

public class Employee {
	
	int empid;
	String name;
	String department;
	double salary;
	Contactinfo c1;
	
	public Contactinfo getC1() {
		return c1;
	}
	public void setC1(Contactinfo c1) {
		this.c1 = c1;
	}
	Employee()
	{
	}
	public Employee(int empid, String name, String department, double salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ "]";
	}
	
	
	
}



