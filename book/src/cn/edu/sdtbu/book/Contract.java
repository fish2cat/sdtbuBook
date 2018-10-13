package cn.edu.sdtbu.book;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contract extends Object{
	private String name;
	private String gender;
	private String email;
	private String[] phones;	
	public int compareTo(Contract c){
		//unicode编码
		//return this.getName().compareTo(c.getName());
		Collator instance = Collator.getInstance(java.util.Locale.CHINA);
		return  instance.compare(this.getName(),c.getName());
	}
	public void mergeContract(Contract c){
		
	}
	public Contract(){		
	}	
	public Contract(String name, String[] phones){
		this(name,"","",phones);
	}
	public Contract(String name, String gender, String email, String[] phones) {
		super();
		this.setName(name);
		this.setGender(gender);
		this.setEmail(email);
		this.setPhones(phones);
	}
	public void display(){
		System.out.println("name:"+getName()
				+"\tgender:"+this.getGender()
				+"\temail:"+this.getEmail());
		System.out.println("电话号码：");
		for(String p:this.getPhones())
			System.out.print(p+"\t");
		System.out.println();
	}
	public static void main(String[] args) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("1999-12-02");
		Contract c = new Family("李明","男","Li@163.com",
				new String[]{"13212341111"},d,"山东烟台");
		c.display();		
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.equals(""))
			return;
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getPhones() {
		return phones;
	}
	public void setPhones(String[] phones) {
		this.phones = phones;
	}
	
	
}
