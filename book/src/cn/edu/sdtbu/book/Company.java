package cn.edu.sdtbu.book;
public class Company {
	private String name;
	private String address;
	private String phone;
	private String fax;	
	public String toString(){
		return String.format("name:%s,address:%s", 
				this.getName(),this.getAddress());
	}
	public Company(String name, String address, String phone, String fax) {
		super();
		this.setName(name);
		this.setAddress(address);
		this.setPhone(phone);
		this.setFax(fax);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
}
