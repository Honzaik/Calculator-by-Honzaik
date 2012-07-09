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
				case 0 : cislo[i].setText("Ans");// cislo with index 0 is "Ans"
				break;
				case 1 : cislo[i].setText("\u002E");	// cislo with index 1 is "." 
				break;
				case 2: cislo[i].setText("0");
				break;
				case 3: cislo[i].setText("3");
				break;
				case 4: cislo[i].setText("2");
				break;
				case 5: cislo[i].setText("1");
				break;
				case 6: cislo[i].setText("6");
				break;
				case 7: cislo[i].setText("5");
				break;
				case 8: cislo[i].setText("4");
				break;
				case 9: cislo[i].setText("9");
				break;
				case 10: cislo[i].setText("8");
				break;
				case 11: cislo[i].setText("7");
				break;
			}
		}

		for (int i = 11; i >= 0; i--) {
			cislaP.add(cislo[i]);
		}
	}
}
