package cn.edu.sdtbu.book;

public class BookTest {

	public static void main(String[] args) {
		Contract[] cons = {new Contract("��С��", new String[]{"111","222"}),
							new Contract("��С��", new String[]{"333","444"}),
							new Contract("Tommy", new String[]{"555","666"})};
		Book book = new Book(cons);
		book.displayBook();
	}

}
