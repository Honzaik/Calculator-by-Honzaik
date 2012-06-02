package eu.honzaik;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Ciselnik {
	public Ciselnik() {
	}

	Font fontCisla = new Font("Arial", Font.BOLD, 20);
	public JButton[] cislo = new JButton[12];
	public JPanel cislaP = new JPanel();
	public void init() {
		GridLayout cislaLayout = new GridLayout(4, 3, 5, 5);
		cislaP.setLayout(cislaLayout);
		cislaP.setBounds(5, 200, 400, 280 - 50);

		for (int i = 0; i < 12; i++) {
			cislo[i] = new JButton();
			cislo[i].setFont(fontCisla);
			cislo[i].setFocusPainted(false);
			switch (i) {
				case 0 :						// cislo with index 0 is "Ans"
					cislo[i].setText("Ans");
					break;
				case 1 :
					cislo[i].setText("\u002E");	// cislo with index 1 is "." 
					break;
				default :
					cislo[i].setText(Integer.toString(i - 2)); // cislo with index for example 7 is 7 - 2 -> 5... its little bit edited cause of render.
			}
		}

		for (int i = 11; i >= 0; i--) {
			cislaP.add(cislo[i]);
		}
	}
}
