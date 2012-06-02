package eu.honzaik;

import java.awt.*;
import java.lang.NumberFormatException;
import java.awt.event.*;
import javax.swing.*;

public class CalcInit {
	public CalcInit() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
		CalcRun();
	}
	public Window mainWindow;
	public Image mainIcon;
	public ImageIcon exitIcon;
	public ImageIcon infoIcon;
	private boolean isX = true;
	private boolean poVysledku = false;
	private boolean canCount = true;
	private String ansVal = null;
	private String vysledek = null;
	private double cisloX;
	private double cisloY;
	private int operace; // 1 = scitani; 2 = odecitani; 3 = nasobeni; 4 =
	                     // deleni; 5 = mocneni
	private int pocetOperaci = 0;

	public void CalcRun() {
		// font cisel
		Font fontCisla = new Font("Arial", Font.BOLD, 20);

		// Frame init
		mainWindow = new Window();
		mainWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				exit(mainWindow);
			}
		});

		// text fields

		final JTextField x = new Display().createX();
		final JTextField y = new Display().createY();
		final JTextField vysledekF = new Display().createVysledekF();
		final JTextPane eF = new Display().createErrorField();

		mainWindow.getContentPane().add(eF);
		mainWindow.getContentPane().add(x);
		mainWindow.getContentPane().add(y);
		mainWindow.getContentPane().add(vysledekF);

		// action
		final JLabel jl = new Display().createActionField();
		mainWindow.getContentPane().add(jl);

		// funkce

		JPanel choice = new JPanel();
		choice.setBounds(595, 385, 115, 100);

		ButtonGroup bG = new ButtonGroup();

		final JRadioButton[] rB = new JRadioButton[2];
		for (int i = 0; i < 2; i++) {
			rB[i] = new JRadioButton();
			rB[i].setFocusPainted(false);
			rB[i].setFont(fontCisla);
			rB[i].setVerticalAlignment((int) JFrame.CENTER_ALIGNMENT);
			switch (i) {
				case 0 :
					rB[i].setText("x");
					rB[i].setSelected(true);
					break;
				case 1 :
					rB[i].setText("y");
					break;
			}
			bG.add(rB[i]);
			choice.add(rB[i]);
		}

		rB[0].addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rB[0].setSelected(true);
				isX = true;
			}
		});
		rB[1].addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rB[1].setSelected(true);
				isX = false;
			}
		});

		mainWindow.getContentPane().add(choice);

		GridLayout funkceLayout = new GridLayout(3, 2, 5, 5);

		JPanel funkceP = new JPanel();
		funkceP.setBounds(410, 200, 180, 280 - 50);
		funkceP.setLayout(funkceLayout);

		final JButton[] funkce = new JButton[6];

		for (int i = 0; i < 6; i++) {
			funkce[i] = new JButton();
			funkceP.add(funkce[i]);
			funkce[i].setFont(fontCisla);
			funkce[i].setFocusPainted(false);
		}

		funkce[0].setText("\u002B"); // plus
		funkce[1].setText("\u2212"); // minus
		funkce[2].setText("\u00D7"); // krat
		funkce[3].setText("\u00F7"); // deleno
		funkce[4].setText("x\u00B2"); // nadruhou
		funkce[5].setText("\u003D"); // rovnase

		funkce[0].addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jl.setText(funkce[0].getText());
				eF.setText(null);
				rB[1].setSelected(true);
				operace = 1;
			}
		});
		funkce[1].addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jl.setText(funkce[1].getText());
				eF.setText(null);
				rB[1].setSelected(true);
				operace = 2;
			}
		});
		funkce[2].addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jl.setText(funkce[2].getText());
				eF.setText(null);
				rB[1].setSelected(true);
				operace = 3;
			}
		});
		funkce[3].addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jl.setText(funkce[3].getText());
				eF.setText(null);
				rB[1].setSelected(true);
				operace = 4;
			}
		});
		funkce[4].addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jl.setText(funkce[4].getText());
				eF.setText(null);
				rB[1].setSelected(true);
				operace = 5;
			}
		});
		funkce[5].addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cisloX = new Double(x.getText());
				} catch (NumberFormatException ne) {
					eF.setText("První číslo není definováno! (x)\n");
					canCount = false;
				}
				try{
					cisloY = new Double(y.getText());
				} catch (NumberFormatException ne) {
					String temp = eF.getText();
					eF.setText(temp + "Druhé číslo není definováno! (y)\n");
					canCount = false;
				}	
				
				if(operace == 0){
					String temp = eF.getText();
					eF.setText(temp + "Neni zadána operace!\n");
				}
				
				if (canCount) {
					cisloY = new Double(y.getText());
					switch (operace) {
						case 1 :
							vysledek = new Priklad(cisloX, cisloY).scitani() + "";
							break;
						case 2 :
							vysledek = new Priklad(cisloX, cisloY).odecitani() + "";
							break;
						case 3 :
							vysledek = new Priklad(cisloX, cisloY).nasobeni() + "";
							break;
						case 4 :
							vysledek = new Priklad(cisloX, cisloY).deleni() + "";
							break;
						case 5 :
							vysledek = new Priklad(cisloX, cisloY).mocneni() + "";
							break;
						default :
							exit(mainWindow);
					}
					vysledekF.setText(vysledek);
					ansVal = vysledek;
					poVysledku = true;
					pocetOperaci++;
				}
			}
		});

		mainWindow.getContentPane().add(funkceP);

		// 0-9 + period + ans
		final Ciselnik cis = new Ciselnik();
		cis.init();
		mainWindow.setLayout(null);
		mainWindow.getContentPane().add(cis.cislaP);

		for (int i = 0; i < cis.cislo.length; i++) {
			final int in = i;
			cis.cislo[i].addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (poVysledku) {
						x.setText(null);
						y.setText(null);
						jl.setText(null);
						vysledekF.setText(null);
						rB[0].setSelected(true);
						poVysledku = false;
					}
					if (new Mackani().isAns(cis.cislo[in]) && pocetOperaci == 0) {
						eF.setText("Ans není definováno!\n");
					} else {
						eF.setText(null);
						new Mackani().mackat(rB[0], rB[1], cis.cislo[in], x, y, ansVal, pocetOperaci);
					}

				}
			});
		}

		// other functions
		GridLayout f2L = new GridLayout(2, 1, 5, 5);
		JPanel funkceP2 = new JPanel();
		funkceP2.setLayout(f2L);
		funkceP2.setBounds(595, 200, 115, 180);

		JButton ce = new JButton();
		ce.setText("Ce");
		ce.setFont(fontCisla);
		ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				x.setText(null);
				y.setText(null);
				jl.setText(null);
				vysledekF.setText(null);
				rB[0].setSelected(true);
				eF.setText(null);
				operace = 0;
				ansVal = null;
				pocetOperaci = 0;
			}
		});

		JButton del = new JButton();
		del.setText("DEL");
		del.setFont(fontCisla);
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isX) {
					String text = x.getText();
					String newText = null;
					if (text.length() > 0) {
						if (text.charAt(text.length() - 1) == 's') {
							newText = text.substring(0, text.length() - 3);
						} else {
							newText = text.substring(0, text.length() - 1);
						}
						x.setText(newText);
					}
				} else {
					String text = y.getText();
					String newText = null;
					if (text.length() > 0) {
						if (text.charAt(text.length() - 1) == 's') {
							newText = text.substring(0, text.length() - 3);
						} else {
							newText = text.substring(0, text.length() - 1);
						}
						y.setText(newText);
					}
				}
			}
		});

		funkceP2.add(ce);
		funkceP2.add(del);

		mainWindow.getContentPane().add(funkceP2);

		// menu
		JMenuBar menuBar = new JMenuBar();

		JMenu calc = new JMenu("Calculator");
		JMenu about = new JMenu("About");

		JMenuItem exit = new JMenuItem();
		exit.setText("Exit");

		try {
			exitIcon = new IconCreate("/res/exit.png").imageIconInit();
		} catch (Exception e) {
		}

		exit.setIcon(exitIcon);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit(mainWindow);
			}
		});
		calc.add(exit);

		JMenuItem info = new JMenuItem();
		info.setText("Info");

		try {
			infoIcon = new IconCreate("/res/info.png").imageIconInit();
		} catch (Exception e) {
		}

		info.setIcon(infoIcon);
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(mainWindow, "Code by Honzaik \nVersion 1.0");
			}
		});

		about.add(info);

		menuBar.add(calc);
		menuBar.add(about);

		mainWindow.setJMenuBar(menuBar);

	}
	private void exit(JFrame frame) {
		int choice = JOptionPane.showConfirmDialog(frame, "Do you really want to close this program?", "Exit confirmation", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
