package cn.edu.sdtbu.book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Family extends Contract {
	private Date birthday;
	private String address;		
	public void display(){
		super.display();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		System.out.println("Birthday:"+sdf.format(this.getBirthday()));
		System.out.println("address:"+this.getAddress());
	}	
	public static void main(String[] args) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("1999-12-02");
		Family f = new Family("李明","男","Li@163.com",
				new String[]{"13212341111"},d,"山东烟台");
		f.display();
	}
	
	public Family(String name, String gender, String email,
			String[] phones, Date birth, String addr) {
		super(name, gender, email, phones);
		this.setBirthday(birth);
		this.setAddress(addr);
	}
	public Date getBirthday() {		
		return birthday;
		
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
