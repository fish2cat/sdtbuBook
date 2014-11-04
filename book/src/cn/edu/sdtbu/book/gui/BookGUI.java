package cn.edu.sdtbu.book.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import cn.edu.sdtbu.book.bean.*;
import cn.edu.sdtbu.book.gui.customStyle.*;
import cn.edu.sdtbu.book.service.Book;

public class BookGUI extends JFrame {
	private ListFont phoneList;
	private TextFieldFont tfdSearch;
	private DefaultListModel<Contract> listModel;
	private Book bookService;
	private Contract currentContract;
	{
		Vector<Contract> c = new Vector<Contract>();

		List<String> list1 = new ArrayList<String>();
		list1.add("13602344578");
		list1.add("13506334789");
		list1.add("010-34567913");
		c.add(new Contract("������", list1));

		List<String> list2 = new ArrayList<String>();
		list2.add("13612344578");
		list2.add("13507894789");
		list2.add("0535-3456793");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			c.add(new Family("�Ÿ�ɽ", "��", "", list2, sdf.parse("1980-4-25"),
					"ɽ����̨��ɽ��"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<String> list3 = new ArrayList<String>();
		list3.add("13602344578");
		list3.add("13206334789");
		list3.add("0535-34544913");
		try {
			c.add(new Family("����", "��", "qqq@163.com", list3, sdf
					.parse("1966-4-25"), "ɽ����̨��ɽ��"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<String> list4 = new ArrayList<String>();
		list4.add("13612344234");
		list4.add("13507894555");
		list4.add("0531-3456993");
		c.add(new Partner("������", "��", "www@163.com", list4, "����", new Company(
				"α��ѶQQ", "�й�����", "010-12345678", "010-23456789")));

		List<String> list5 = new ArrayList<String>();
		list5.add("13612344234");
		list5.add("13507894555");
		list5.add("0531-3456993");
		c.add(new Contract("Tommy", list5));

		List<String> list6 = new ArrayList<String>();
		list6.add("13612344234");
		list6.add("13507894555");
		list6.add("0531-3456993");
		c.add(new Contract("Jackson", list6));

		List<String> list7 = new ArrayList<String>();
		list7.add("13602344578");
		list7.add("13506334789");
		list7.add("010-34567913");
		c.add(new Contract("����", list7));

		List<String> list8 = new ArrayList<String>();
		list8.add("13602344578");
		c.add(new Contract("������", list8));

		List<String> list9 = new ArrayList<String>();
		list9.add("13602344578");
		c.add(new Contract("�μѳ�", list9));

		List<String> list10 = new ArrayList<String>();
		list10.add("13602344578");
		c.add(new Contract("������", list10));

		bookService = new Book(c);
	}

	public BookGUI() {
		super("ͨѶ¼");
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		Container c = this.getContentPane();
		JPanel top = new JPanel();
		Font f = new Font(StyleArgument.FONTNAME, StyleArgument.FONTSTYLE,
				StyleArgument.FONTSIZE);
		tfdSearch = new TextFieldFont("����", 20, f);
		ButtonFont btnAdd = new ButtonFont("+", f);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setCurrentContract(null);
				new ContractDetailGUI(BookGUI.this);
				Contract c = getCurrentContract();
				if (c != null) {
					try {
						bookService.add(c);
					} catch (GenderException e) {
						e.printStackTrace();
					}
					// Ҫ�����������򣬲���ֱ��listModel.addElement()����
					freshListModel(bookService.getContracts());
				}
			}
		});
		ButtonFont btnDel = new ButtonFont("-", f);
		tfdSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tfdSearch.getText().equals("")) {
					List<Contract> founded = bookService
							.findContractsByName(tfdSearch.getText());
					freshListModel(founded);
				} else
					freshListModel(bookService.getContracts());
			}
		});
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Contract delContract = phoneList.getSelectedValue();
				if (null == delContract) {
					JOptionPane.showMessageDialog(BookGUI.this, "��ѡ�д�ɾ����ϵ��",
							"ɾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
						BookGUI.this, "ȷ��ɾ����ϵ����?")) {
					bookService.delete(delContract);					
					if (tfdSearch.getText().equals("����"))
						freshListModel(bookService.getContracts());
					else

						freshListModel(bookService
								.findContractsByName(tfdSearch.getText()));
				}
			}
		});
		top.add(tfdSearch);
		top.add(btnAdd);
		top.add(btnDel);
		listModel = new DefaultListModel<Contract>();
		// ˢ���б�
		freshListModel(bookService.getContracts());
		phoneList = new ListFont(listModel, f);
		phoneList.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() == 2) {					
					setCurrentContract(phoneList.getSelectedValue());
					new ContractDetailGUI(BookGUI.this);
					Contract updatedContract = getCurrentContract();
					try {
						bookService.updateContract(updatedContract.getName(),
								updatedContract.getGender(),updatedContract.getEmail(),
								updatedContract.getPhones());
					} catch (GenderException e) {						
						e.printStackTrace();
					}
					//ˢ��
					if (tfdSearch.getText().equals("����"))
						freshListModel(bookService.getContracts());
					else

						freshListModel(bookService
								.findContractsByName(tfdSearch.getText()));
			 }
			}
			
		});
		c.add(top, BorderLayout.NORTH);
		c.add(new JScrollPane(phoneList));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void freshListModel(List<Contract> contracts) {
		listModel.removeAllElements();
		for (Contract p : contracts) {
			listModel.addElement(p);
		}
	}

	public Contract getCurrentContract() {
		return currentContract;
	}

	public void setCurrentContract(Contract c) {
		currentContract = c;
	}

	public static void main(String[] args) {
		new BookGUI();

	}

}
