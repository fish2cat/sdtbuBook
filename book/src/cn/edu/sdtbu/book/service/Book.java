package cn.edu.sdtbu.book.service;
import java.util.*;

import cn.edu.sdtbu.book.bean.Contract;
import cn.edu.sdtbu.book.bean.GenderException;
public class Book {
	private List<Contract> contracts;
	
	public List<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(List<Contract> contracts) {
		Collections.sort(contracts);
		this.contracts = contracts;
		//this.sortContracts();
	}
	public Book(List<Contract> contracts) {
		super();
		this.setContracts(contracts);
	}
	public Book() {		
	}	
	public void displayBook(){
		for(Contract c:this.getContracts())
			c.display();
	}	
	public void add(Contract c) throws GenderException{	
		if(contracts == null){
			//空通讯录
			contracts = new ArrayList<Contract>();
			contracts.add(c);
		}else{
			int index = Collections.binarySearch(this.getContracts(), c);
			if( index < 0){
				//不存在的联系人				
				contracts.add(-index-1, c);
			}else{
				//已经存在的联系人
				contracts.get(index).mergeContract(c);
			}
		}
	}
	public List<Contract> findContractsByName(String name){
		List<Contract> result = new ArrayList<Contract>();
		Iterator<Contract> iter = contracts.iterator();		
		for(;iter.hasNext();) {	
			Contract c = iter.next();
			if(c.getName().contains(name))
				result.add(c);			
		}
		return result;
	}
	public boolean updateContract(String name, String gender, String email, List<String> phones) throws GenderException{
		int index = Collections.binarySearch(contracts, 
				new Contract(name,gender,email,phones));		
		if(index <0)
			return false;
		contracts.get(index).setGender(gender);
		contracts.get(index).setEmail(email);
		contracts.get(index).setPhones(phones);
		return true;
	}
	public void clearContracts() {
		contracts.clear();
	}
	public boolean delete(Contract c){
		return contracts.remove(c);			
	}	
}







