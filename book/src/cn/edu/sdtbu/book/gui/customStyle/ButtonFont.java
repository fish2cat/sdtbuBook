package cn.edu.sdtbu.book.gui.customStyle;

import java.awt.Font;

import javax.swing.JButton;

public class ButtonFont extends JButton {
	public ButtonFont(String text,Font f) {
		super(text);
		this.setFont(f);
	}
}
