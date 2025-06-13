package MavenJdbcExample.SpringExample;

import java.util.List;
import java.util.Map;

public class Address {

    int hno;
    String city;
    String pcode;
    List<String> stateList; 
    Map<String, String> zone;
    public Address() {
       
    }

	public Address(int hno, String city, String pcode, List<String> stateList, Map<String, String> zone) {
		super();
		this.hno = hno;
		this.city = city;
		this.pcode = pcode;
		this.stateList = stateList;
		this.zone = zone;
	}
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public List<String> getStateList() {
		return stateList;
	}
	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}
	public Map<String, String> getZone() {
		return zone;
	}
	public void setZone(Map<String, String> zone) {
		this.zone = zone;
	}
	@Override
	public String toString() {
		return "Address [hno=" + hno + ", city=" + city + ", pcode=" + pcode + ", stateList=" + stateList + ", zone="
				+ zone + "]";
	}
	

}