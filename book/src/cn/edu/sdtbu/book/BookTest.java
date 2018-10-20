package cn.edu.sdtbu.book;

public class BookTest {

	public static void main(String[] args) {
		Contract[] cons = {new Contract("王小二", new String[]{"111","222"}),
							new Contract("李小二", new String[]{"333","444"}),
							new Contract("Tommy", new String[]{"555","666"})};
		Book book = new Book(cons);
		/*book.displayBook();
		
		book.add(new Contract("王小二","男","wangxiaoer@163.com", 
				new String[]{"111","222","333"}));
		book.displayBook();
		
		for(Contract c:book.findContractsByName("小"))
			c.display();
		
		book.updateContract("王小二","女","wangxiaoer@163.com", 
				new String[]{"555","666"});
		book.displayBook();*/		
		if(book.deleteVal(new Contract("李小二", new String[]{"333","444"})))
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
