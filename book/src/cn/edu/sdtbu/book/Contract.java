package cn.edu.sdtbu.book;
public class Contract extends Object{
	private String name;
	private String gender;
	private String email;
	private String[] phones;	
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
		System.out.println("µç»°ºÅÂë£º");
		for(String p:this.getPhones())
			System.out.print(p+"\t");
		System.out.println();
	}
	public static void main(String[] args) throws Exception{
		Contract c = new Contract("ÀîºÆ","ÄÐ","liH@sdebu.edu.cn",
				new String[]{"13234567890","13545671234"});
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
