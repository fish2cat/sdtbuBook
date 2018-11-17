package cn.edu.sdtbu.book.gui.customStyle;

import java.awt.Font;

import javax.swing.JTextField;

public class TextFieldFont extends JTextField {
	public TextFieldFont(String text,Font f) {
		super(text);
		this.setFont(f);
	}
	public TextFieldFont(int column,Font f) {
		super(column);
		this.setFont(f);
	}
	public TextFieldFont(String text,int column,Font f) {
		super(text,column);
		this.setFont(f);
	}
}
