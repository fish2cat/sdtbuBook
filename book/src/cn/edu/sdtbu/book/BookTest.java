package cn.edu.sdtbu.book;

public class BookTest {

	public static void main(String[] args) {
		Contract[] cons = {new Contract("王小二", new String[]{"111","222"}),
							new Contract("李小二", new String[]{"333","444"}),
							new Contract("Tommy", new String[]{"555","666"})};
		Book book = new Book(cons);
		book.displayBook();
	}

}
