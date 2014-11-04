package cn.edu.sdtbu.book.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import cn.edu.sdtbu.book.bean.*;
import cn.edu.sdtbu.book.gui.customStyle.*;


public class ContractDetailGUI extends JDialog {
	private BookGUI owner;
	private TextFieldFont tfdName;
	private TextFieldFont tfdGender;
	private TextFieldFont tfdEmail;
	private List<TextFieldFont> tfdPhones;
	private Contract contract;
	private ButtonFont btnAdd;
	private CheckBoxFont chkFamily;
	private TextFieldFont tfdAddr;
	private TextFieldFont tfdBirth;
	private CheckBoxFont chkPartner;
	private TextFieldFont title;
	private TextFieldFont companyName;
	private TextFieldFont companyAddr;
	private TextFieldFont companyPhone;
	private TextFieldFont companyFax;
	private Font f;
	private Box palPhone;
	public ContractDetailGUI(BookGUI father) {
		super(father,"",true);
		this.owner = father;
		this.contract = father.getCurrentContract();	
		initComponent();			
		Box base = new Box(BoxLayout.Y_AXIS);
		TitledBorder border = BorderFactory.createTitledBorder("基本信息");
		border.setTitleFont(f);
		base.setBorder(border);		
		base.add(tfdName);
		base.add(tfdGender);
		base.add(tfdEmail);
		base.add(btnAdd);
		base.add(palPhone);		
		Box family = new Box(BoxLayout.Y_AXIS);
		family.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));		
		family.add(chkFamily);
		family.add(new LabelFont("地址",f));
		family.add(tfdAddr);
		family.add(new LabelFont("出生年月日",f));
		family.add(tfdBirth);		
		Box partner = new Box(BoxLayout.Y_AXIS);		
		partner.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		partner.add(chkPartner);
		partner.add(new LabelFont("职务/职称",f));
		partner.add(title);
		partner.add(new LabelFont("所在公司信息：",f));
		partner.add(new LabelFont("名称",f));
		partner.add(companyName);
		partner.add(new LabelFont("地址",f));
		partner.add(companyAddr);
		partner.add(new LabelFont("电话",f));
		partner.add(companyPhone);	
		partner.add(new LabelFont("传真",f));
		partner.add(companyFax);
		JPanel palCmd = new JPanel();
		palCmd.setBorder(BorderFactory.createRaisedBevelBorder());
		ButtonFont btnSave = new ButtonFont("保存",f);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> phones =  new ArrayList<String>();
				for(TextFieldFont p:tfdPhones) {
					if(!p.getText().equals(""))
						phones.add(p.getText());
				}
				if(chkFamily.isSelected()) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date birthday = null;
					try {
						birthday = sdf.parse(tfdBirth.getText());
					} catch (ParseException e1) {						
						e1.printStackTrace();
					}
					Family f = new Family(tfdName.getText(),tfdGender.getText(),tfdEmail.getText(),
							phones,birthday,tfdAddr.getText());					
					owner.setCurrentContract(f);					
					return;
				}
				if(chkPartner.isSelected()) {
					Partner p = new Partner(tfdName.getText(),tfdGender.getText(),tfdEmail.getText(),phones,title.getText(),
							new Company(companyName.getText(),companyAddr.getText(),companyPhone.getText(),companyFax.getText()));
					owner.setCurrentContract(p);
					return;
				}
				Contract c = new Contract(tfdName.getText(),tfdGender.getText(),tfdEmail.getText(),phones);
				owner.setCurrentContract(c);
				return;
			}			
		});
		ButtonFont btnClear = new ButtonFont("清空",f);
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfdName.setText("");
				tfdGender.setText("");
				tfdEmail.setText("");
				tfdPhones = new ArrayList<TextFieldFont>();
				tfdPhones.add(new TextFieldFont(12,f));
				palPhone.removeAll();
				palPhone.add(tfdPhones.get(0));
				ContractDetailGUI.this.validate();
				ContractDetailGUI.this.repaint();
				chkFamily.setSelected(false);
				chkPartner.setSelected(false);
			}			
		});
		ButtonFont btnRtn = new ButtonFont("返回",f);
		btnRtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(ContractDetailGUI.this, "确认返回操作吗？");	
				if(JOptionPane.YES_OPTION == choice)
					ContractDetailGUI.this.dispose();				
			}			
		});
		palCmd.add(btnSave);
		palCmd.add(btnClear);
		palCmd.add(btnRtn);
		Container c = this.getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		c.add(base);
		c.add(family);
		c.add(partner);
		c.add(palCmd);
		this.setSize(300, 850);		
		this.setVisible(true);
		
		
	}
	private void setFamilyEnable(boolean isEnable) {
		tfdAddr.setEnabled(isEnable);
		tfdBirth.setEnabled(isEnable);
	}
	private void setPartnerEnable(boolean isEnable) {
		title.setEnabled(isEnable);
		companyName.setEnabled(isEnable);
		companyAddr.setEnabled(isEnable);
		companyPhone.setEnabled(isEnable);
		companyFax.setEnabled(isEnable);
	}
	private void initComponent() {
		f = new Font(StyleArgument.FONTNAME,StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		btnAdd = new ButtonFont("添加电话",f);			
		tfdName = new TextFieldFont("姓名",10,f);		
		tfdGender = new TextFieldFont("性别",10,f);
		tfdEmail = new TextFieldFont("电子邮件",15,f);
		tfdPhones = new ArrayList<TextFieldFont>();			
		chkFamily = new CheckBoxFont("家人",false,f);
		chkFamily.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if(chkFamily.isSelected()) {
					chkPartner.setSelected(false);
					setFamilyEnable(true);					
				}else {
					tfdAddr.setText("");
					tfdBirth.setText("");
					setFamilyEnable(false);
				}
			}
			
		});
		chkPartner = new CheckBoxFont("工作伙伴",false,f);
		chkPartner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if(chkPartner.isSelected()) {
					chkFamily.setSelected(false);
					setPartnerEnable(true);					
				}else {
					title.setText("");
					companyName.setText("");
					companyPhone.setText("");
					companyAddr.setText("");
					companyFax.setText("");
					setPartnerEnable(false);
				}					
			}			
		});
		tfdAddr = new TextFieldFont(20,f);		
		tfdBirth = new TextFieldFont(10,f);
		setFamilyEnable(false);
		title = new TextFieldFont(5,f);
		companyName = new TextFieldFont(10,f);
		companyPhone = new TextFieldFont(12,f);
		companyAddr = new TextFieldFont(20,f);
		companyFax = new TextFieldFont(12,f);
		setPartnerEnable(false);
		if(contract != null) {					
			tfdName.setText(contract.getName());
			if(contract.getGender()!=null || !contract.getGender().equals(""))
				tfdGender.setText(contract.getGender());
			if(contract.getEmail()!=null || !contract.getEmail().equals(""))
				tfdEmail.setText(contract.getEmail());
			for(String p:contract.getPhones())
				tfdPhones.add(new TextFieldFont(p,12,f));	
			if(contract instanceof Family) {
				chkFamily.setSelected(true);
				if(((Family) contract).getAddress()!=null || !((Family) contract).getAddress().equals(""))
					tfdAddr.setText(((Family) contract).getAddress());
				if(((Family) contract).getBirthday()!=null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tfdBirth.setText(sdf.format(((Family) contract).getBirthday()));
				}
				setFamilyEnable(true);
			}
			if(contract instanceof Partner) {
				chkPartner.setSelected(true);
				if(((Partner) contract).getTitle()!= null || ((Partner) contract).getTitle().equals(""))
					title.setText(((Partner) contract).getTitle());
				if(((Partner) contract).getCompany().getName()!= null || ((Partner) contract).getCompany().getName().equals(""))
					companyName.setText(((Partner) contract).getCompany().getName());
				if(((Partner) contract).getCompany().getPhone()!= null || ((Partner) contract).getCompany().getPhone().equals(""))
					companyPhone.setText(((Partner) contract).getCompany().getPhone());
				if(((Partner) contract).getCompany().getAddress()!= null || ((Partner) contract).getCompany().getAddress().equals(""))
					companyAddr.setText(((Partner) contract).getCompany().getAddress()); 
				if(((Partner) contract).getCompany().getFax()!= null || ((Partner) contract).getCompany().getFax().equals(""))
					companyFax.setText(((Partner) contract).getCompany().getFax()); 
				setPartnerEnable(true);
			}
		}else
			tfdPhones.add(new TextFieldFont(12,f));		
		palPhone = new Box(BoxLayout.Y_AXIS);
		for(TextFieldFont phone:tfdPhones)
			palPhone.add(phone);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TextFieldFont newPhone = new TextFieldFont(12,f);
				tfdPhones.add(newPhone);
				palPhone.add(newPhone);
				ContractDetailGUI.this.validate();
				ContractDetailGUI.this.repaint();
			}			
		});
	}
}
