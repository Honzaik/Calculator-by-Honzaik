package eu.honzaik;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Mackani {
	public Mackani() {
	}

	public boolean isAns(JButton cislo){
		if(cislo.getText() == "Ans"){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void mackat(JRadioButton rB1, JRadioButton rB2, JButton cislo, JTextField x, JTextField y, String ansVal, int pocetOperaci, int operace) {
		boolean xIsNumber = false;
		boolean yIsNumber = false;
		String xt = null;
		String yt = null;
		String text = null;
		if (cislo.getText() == "Ans" && pocetOperaci == 0){
			text = null;
		} else if(cislo.getText() == "Ans"){
			text = ansVal;
		} else{
			text = cislo.getText();
		}

		if (x.getText().length() > 0)
			xt = x.getText();
		else
			xIsNumber = true;
		if (y.getText().length() > 0)
			yt = y.getText();
		else
			yIsNumber = true;

		if (xt != null) {
			for (int i = 0; i < xt.length(); i++) {
				char temp = xt.charAt(i);
				switch (temp) {
					case '0' :
						xIsNumber = true;
						break;
					case '1' :
						xIsNumber = true;
						break;
					case '2' :
						xIsNumber = true;
						break;
					case '3' :
						xIsNumber = true;
						break;
					case '4' :
						xIsNumber = true;
						break;
					case '5' :
						xIsNumber = true;
						break;
					case '6' :
						xIsNumber = true;
						break;
					case '7' :
						xIsNumber = true;
						break;
					case '8' :
						xIsNumber = true;
						break;
					case '9' :
						xIsNumber = true;
						break;
					case '.' :
						yIsNumber = true;
						break;
					default :
						xIsNumber = false;
				}
			}
		}

		if (yt != null) {
			for (int i = 0; i < yt.length(); i++) {
				char temp = yt.charAt(i);
				switch (temp) {
					case '0' :
						yIsNumber = true;
						break;
					case '1' :
						yIsNumber = true;
						break;
					case '2' :
						yIsNumber = true;
						break;
					case '3' :
						yIsNumber = true;
						break;
					case '4' :
						yIsNumber = true;
						break;
					case '5' :
						yIsNumber = true;
						break;
					case '6' :
						yIsNumber = true;
						break;
					case '7' :
						yIsNumber = true;
						break;
					case '8' :
						yIsNumber = true;
						break;
					case '9' :
						yIsNumber = true;
						break;
					case '.' :
						yIsNumber = true;
						break;
					default :
						yIsNumber = false;
				}
			}
		}

		if (rB1.isSelected() && xIsNumber) {
			if (xt != null && text != ansVal) {
				String temp = x.getText();
				x.setText(temp + text);
			} else if (xt == null && text != ansVal) {
				x.setText(text);
			} else if (xt == null && text == ansVal) {
				x.setText(text);
			}
		} else if (rB2.isSelected() && yIsNumber && operace != 5) {
			if (yt != null && text != ansVal) {
				String temp = y.getText();
				y.setText(temp + text);
			} else if (yt == null && text != ansVal) {
				y.setText(text);
			} else if (yt == null && text == ansVal) {
				y.setText(text);
			}
		}
	}
}
