package cn.edu.sdtbu.book.service;

import java.util.*;

import cn.edu.sdtbu.book.bean.Contract;
import cn.edu.sdtbu.book.bean.GenderException;

public class BookTest {

	public static void main(String[] args) throws GenderException {
		List<Contract> cons = new ArrayList<Contract>();
		List<String> phones1 = new ArrayList<String>();
		phones1.add("111");
		phones1.add("222");
		cons.add(new Contract("��С��", phones1));
		List<String> phones2 = new ArrayList<String>();
		phones2.add("333");
		phones2.add("444");
		cons.add(new Contract("��С��", phones2));
		List<String> phones3 = new ArrayList<String>();
		phones3.add("555");
		phones3.add("666");	
		cons.add(new Contract("��С��", phones3));
		Book book = new Book(cons);
		book.displayBook();
		List<String> phones = new ArrayList<String>();
		phones.add("111");
		phones.add("222");
		phones.add("333");
		book.add(new Contract("��С��","��","wangxiaoer@163.com", 
				phones));
		book.displayBook();
		
		for(Contract c:book.findContractsByName("С"))
			c.display();
		List<String> phones4 = new ArrayList<String>();
		phones4.add("555");
		phones4.add("666");		
		book.updateContract("��С��","Ů","wangxiaoer@163.com", 
				phones4);
		book.displayBook();		
		if(book.delete(new Contract("��С��", phones2)))
			System.out.println("deleted.");
		else
			System.out.println("undeleted.");
		book.displayBook();
		
	}

}