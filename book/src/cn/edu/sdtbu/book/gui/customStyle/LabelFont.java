package cn.edu.sdtbu.book.gui.customStyle;

import java.awt.Font;

import javax.swing.JLabel;

public class LabelFont extends JLabel {
	public LabelFont(String text, Font f) {
		super(text);
		this.setFont(f);
	}
}
