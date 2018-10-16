package cn.edu.sdtbu.book;
import java.util.Arrays;
public class Book {
	private Contract[] contracts;
	
	public Contract[] getContracts() {
		return contracts;
	}
	public void setContracts(Contract[] contracts) {
		this.contracts = contracts;
		this.sortContracts();
	}
	public Book(Contract[] contracts) {
		super();
		this.setContracts(contracts);
	}
	public Book() {		
	}	
	private void sortContracts(){
		for(int i = 0; i < contracts.length-1; i++){
			int temp = i;
			for(int j = i+1; j< contracts.length; j++){
				if(contracts[temp].compareTo(contracts[j]) > 0)
					temp = j;
			}
			if(temp != i){
				//交换
				Contract t = contracts[temp];
				contracts[temp] = contracts[i];
				contracts[i] = t;
			}			
		}
	}
	public void displayBook(){
		for(Contract c:this.getContracts())
			c.display();
	}
	private int findContract(Contract c){
		for(int i = 0; i < contracts.length;i++){
			if(contracts[i].getName().equals(c.getName()))
				return i;
		}
		return -1;			
	}
	public void add(Contract c){	
		if(contracts == null){
			//空通讯录
			contracts = new Contract[1];
			contracts[0] = c;
		}else{
			int index = findContract(c);
			if( index == -1){
				//不存在的联系人
				Contract[] contractAdded = Arrays.copyOf(contracts, contracts.length + 1);
				contractAdded[contractAdded.length-1] = c;			
				this.setContracts(contractAdded);
			}else{
				//已经存在的联系人
				contracts[index].mergeContract(c);
			}
		}
	}
	public Contract[] findContractsByName(String name){
		Contract[] result = new Contract[contracts.length];
		int num = 0;
		for(int i = 0; i < contracts.length; i++) {
			if(contracts[i].getName().contains(name))
				result[num++] = contracts[i];			
		}
		return Arrays.copyOf(result, num);
	}
	public boolean updateContract(String name, String gender, String email, String[] phones){
		int index = findContract(new Contract(name,gender,email,phones));		
		if(index <0)
			return false;
		contracts[index].setGender(gender);
		contracts[index].setEmail(email);
		contracts[index].setPhones(phones);
		return true;
	}
	public void clearContracts() {
		contracts = null;
	}
}







