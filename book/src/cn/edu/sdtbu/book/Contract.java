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
	public void mergeContract(Contract c) throws GenderException{
		if(this.getName().equals(c.getName())) {
			if(this.getGender().equals(""))
				this.setGender(c.getGender());
			if(this.getEmail().equals(""))
				this.setEmail(c.getEmail());
			//合并phone
			boolean flag;
			String[] newPhones = new String[c.getPhones().length];
			int count = 0;
			for(int j = 0; j < c.getPhones().length; j++) {
				flag = true;
				for(int i = 0; i < this.getPhones().length; i++) {
					if(c.getPhones()[j].equals(this.getPhones()[i])) {
						flag = false;
						break;
					}
				}		
				if(flag) 
				{				
					newPhones[count++] = c.getPhones()[j];
				}				
			}
			int position = phones.length;
			//扩容
			phones = Arrays.copyOf(phones, phones.length+count);			
			//newPhones追加在当前phones后面
			System.arraycopy(newPhones, 0, phones, position, count);			
		}
	}
	public Contract(){		
	}	
	public Contract(String name, String[] phones){
		this(name,"","",phones);
	}
	public Contract(String name, String gender, String email, String[] phones){
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("1999-12-02");
		Contract c = new Family("李明","","Li@163.com",
				new String[]{"13212341111"},d,"山东烟台");
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
	public String[] getPhones() {
		return phones;
	}
	public void setPhones(String[] phones) {
		this.phones = phones;
	}
	
	
}
