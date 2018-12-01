package cn.edu.sdtbu.book.bean;

import java.util.List;

public class Partner extends Contract {
	private String title;
	private Company company;
	public Partner(int id,String name, String gender, String email,
			List<String> phones,String title, Company company) {
		super(id,name, gender, email, phones);
		this.setTitle(title);
		this.setCompany(company);
	}	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public void display(){
		super.display();
		System.out.println("title:"+this.getTitle());
		System.out.println("Company:\n"+this.getCompany());
	}
	public static void main(String[] args) {
		/*Partner p = new Partner("李昭","男","LiZ@163.com",
				new String[]{"123456768"},"经理",
				new Company("华阳热力","山东烟台","1111","2222"));
		p.display();*/
	}
}
