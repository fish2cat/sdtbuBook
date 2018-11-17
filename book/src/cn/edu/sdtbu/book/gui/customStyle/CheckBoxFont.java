package cn.edu.sdtbu.book.gui.customStyle;

import java.awt.Font;

import javax.swing.JCheckBox;

public class CheckBoxFont extends JCheckBox {
	public CheckBoxFont(String text,Font f) {
		super(text);
		this.setFont(f);
	}
	public CheckBoxFont(String text,boolean selected,Font f) {
		super(text,selected);
		this.setFont(f);
	}
}
