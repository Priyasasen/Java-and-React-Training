package MavenJdbcExample.Employee.Spring;

public class Contactinfo {
	
	String phno;
	String email;
	String LinkedIn;
	
	Contactinfo(){
		
	}

	public Contactinfo(String phno, String email, String linkedIn) {
		super();
		this.phno = phno;
		this.email = email;
		LinkedIn = linkedIn;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkedIn() {
		return LinkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		LinkedIn = linkedIn;
	}

	@Override
	public String toString() {
		return "Contactinfo [phno=" + phno + ", email=" + email + ", LinkedIn=" + LinkedIn + "]";
	}
	
	
	

}
