package cn.edu.sdtbu.book;
import java.text.*;
import java.util.*;
class NameException extends Exception{
	public NameException(){
		super("姓名为空");
	}
}
class GenderException extends Exception{
	public GenderException(){
		super("性别错误");
	}
}
public class Contract extends Object implements Comparable<Contract>{
	private String name;
	private String gender;
	private String email;
	private List<String> phones;	
	
	public int compareTo(Contract c){
		//unicode编码
		//return this.getName().compareTo(c.getName());
		Collator instance = Collator.getInstance(java.util.Locale.CHINA);
		return  instance.compare(this.getName(),c.getName());
	}
	public void mergeContract(Contract c) throws GenderException{
		if(this.getName().equals(c.getName())) {
			if(this.getGender().equals(""))
				this.setGender(c.getGender());
			if(this.getEmail().equals(""))
				this.setEmail(c.getEmail());
			//合并phone
			List<String> src = this.getPhones();
			src.removeAll(c.getPhones());
			src.addAll(c.getPhones());
			this.setPhones(src);		
		}
	}
	public Contract(){		
	}	
	public Contract(String name, List<String> phones){
		this(name,"","",phones);
	}
	public Contract(String name, String gender, String email, List<String> phones){
		super();
		try {
			this.setName(name);
			this.setGender(gender);
		} catch (NameException e) {
			e.printStackTrace();
		} catch (GenderException e) {
			System.out.println(e.getMessage());
		}
		
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
		List<String> phones = new ArrayList<String>();
		phones.add("13212341111");
		phones.add("12345678901");		
		Contract c = new Contract("李明","","Li@163.com",phones);
		c.display();
		List<String> p = new ArrayList<String>();
		p.add("13212341111");
		p.add("13212341112");
		Contract c1 = new Contract("李明","男","Li@163.com",p);
		c.mergeContract(c1);
		c.display();
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) throws NameException {
		if(name == null || name.equals(""))
			throw new NameException();
		this.name = name;
	}	
	public void setGender(String gender) throws GenderException {
		if(gender == null || 
				!(gender.equals("男") || gender.equals("女")
						|| gender.equals("")))
			throw new GenderException();
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	
	
}
