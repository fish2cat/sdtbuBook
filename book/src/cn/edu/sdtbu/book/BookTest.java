package cn.edu.sdtbu.book;

public class BookTest {

	public static void main(String[] args) {
		Contract[] cons = {new Contract("��С��", new String[]{"111","222"}),
							new Contract("��С��", new String[]{"333","444"}),
							new Contract("Tommy", new String[]{"555","666"})};
		Book book = new Book(cons);
		/*book.displayBook();
		
		book.add(new Contract("��С��","��","wangxiaoer@163.com", 
				new String[]{"111","222","333"}));
		book.displayBook();
		
		for(Contract c:book.findContractsByName("С"))
			c.display();
		
		book.updateContract("��С��","Ů","wangxiaoer@163.com", 
				new String[]{"555","666"});
		book.displayBook();*/		
		if(book.deleteVal(new Contract("��С��", new String[]{"333","444"})))
			System.out.println("deleted.");
		else
			System.out.println("undeleted.");
		book.displayBook();
		if(book.deleteRef(book.getContracts()[1]))
			System.out.println("deleted.");
		else
			System.out.println("undeleted.");
		book.displayBook();
	}

}
