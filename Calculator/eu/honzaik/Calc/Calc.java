package eu.honzaik.Calc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calc {
	public Calc(){
		start();
	}
	
	public float scitani(float x, float y){
		return (x + y);
	}
	
	public float odecitani(float x, float y){
		return (x - y);
	}
	
	public float nasobeni(float x, float y){
		return (x * y);
	}
	
	public float deleni(float x, float y){
		return (x / y);
	}
	
	public float mocneni(float x, float y){
		return (float) (Math.pow(x, y));
	}
	
	public int operace;
	public float mezivypocet;
	public float x;
	public float y;
	public boolean delX = true;
	public JLabel where = new JLabel();
	public void start(){
		/* Frame init */
		
		JFrame okno = new JFrame();
		okno.setVisible(true);
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setTitle("Calculator by Honzaik");
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		final int sW = screen.width;
		final int sH = screen.height;
		
		okno.setSize(500, 505);
		okno.setLocation(sW / 2 - 250, sH / 2 - 300);
		okno.setResizable(false);
		
		/* Font */
		
		Font font = new Font("Arial", Font.BOLD, 20);
		
		/* Number init */
	
		final JButton jedna = new JButton();
		final JButton dva = new JButton();
		final JButton tri = new JButton();
		final JButton ctyri = new JButton();
		final JButton pet = new JButton();
		final JButton sest = new JButton();
		final JButton sedm = new JButton();
		final JButton osm = new JButton();
		final JButton devet = new JButton();
		
		jedna.setText("1");
		dva.setText("2");
		tri.setText("3");
		ctyri.setText("4");
		pet.setText("5");
		sest.setText("6");
		sedm.setText("7");
		osm.setText("8");
		devet.setText("9");
		
		jedna.setBounds(5, 250, 100, 70);
		dva.setBounds(110, 250, 100, 70);
		tri.setBounds(215, 250, 100, 70);
		ctyri.setBounds(5, 325, 100, 70);
		pet.setBounds(110, 325, 100, 70);
		sest.setBounds(215, 325, 100, 70);
		sedm.setBounds(5, 400, 100, 70);
		osm.setBounds(110, 400, 100, 70);
		devet.setBounds(215, 400, 100, 70);
		
		jedna.setFont(font);
		dva.setFont(font);
		tri.setFont(font);
		ctyri.setFont(font);
		pet.setFont(font);
		sest.setFont(font);
		sedm.setFont(font);
		osm.setFont(font);
		devet.setFont(font);
		
		okno.setLayout(null);
		okno.getContentPane().add(jedna);
		okno.getContentPane().add(dva);
		okno.getContentPane().add(tri);
		okno.getContentPane().add(ctyri);
		okno.getContentPane().add(pet);
		okno.getContentPane().add(sest);
		okno.getContentPane().add(sedm);
		okno.getContentPane().add(osm);
		okno.getContentPane().add(devet);	  
		
		/* Zadani */
		
		final JLabel zadani1 = new JLabel();
		final JLabel zadani2 = new JLabel();
		final JLabel znak = new JLabel();
		
		where = zadani1;
		
		Font fontZ = new Font("Arial", Font.BOLD, 35);
		
		zadani1.setBounds(20, 20, 280, 35);
		zadani2.setBounds(20, 100, 280, 35);
		znak.setBounds(20, 60, 35, 35);
		
		zadani1.setFont(fontZ);
		zadani2.setFont(fontZ);
		znak.setFont(fontZ);
		
		zadani1.setBorder(BorderFactory.createLineBorder(Color.black));
		zadani2.setBorder(BorderFactory.createLineBorder(Color.black));
		znak.setBorder(BorderFactory.createLineBorder(Color.red));
		
		znak.setHorizontalAlignment(SwingConstants.CENTER);
		
		okno.getContentPane().add(zadani1);
		okno.getContentPane().add(zadani2);
		okno.getContentPane().add(znak);
		
		/* Vyber mezi x a y*/
		JLabel popisX = new JLabel();
		JLabel popisY = new JLabel();
		final Font fontR = new Font("Arial", Font.BOLD, 20);
		
		popisX.setText("x");
		popisY.setText("y");
		
		popisX.setFont(fontR);
		popisY.setFont(fontR);
		
		popisX.setBounds(5, 25, 20, 20);
		popisY.setBounds(5, 105, 20, 20);
		
		okno.getContentPane().add(popisX);
		okno.getContentPane().add(popisY); 
		
		final JRadioButton rX = new JRadioButton();
		final JRadioButton rY = new JRadioButton();
		 
		rX.setText("x");
		rY.setText("y");
	 
		rX.setFont(fontR);
		rY.setFont(fontR);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rX);
		group.add(rY);
		
		rX.setSelected(true);
		
		rX.setBounds(450, 110, 50, 20); 
		rY.setBounds(450, 150, 50, 20);

		rX.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
				delX = true;
				rX.setSelected(true);
				rY.setSelected(false);
				where = zadani1;
			}
		});
		
		rY.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
				if(zadani2.getText() != ""){
					delX = false;
					rX.setSelected(false);
					rY.setSelected(true);
					where = zadani2;
				}
			}
		});
		 
		okno.getContentPane().add(rX);
		okno.getContentPane().add(rY); 
		
		/* Vysledek */
		
		final JLabel vysledek = new JLabel();
		
		Font fontV = new Font("Arial", Font.BOLD, 50);
		
		vysledek.setBounds(10, 170, 300, 50);
		vysledek.setFont(fontV);
		vysledek.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		okno.getContentPane().add(vysledek);
		
		/* Delete */
		
		final JButton del = new JButton();
		
		del.setBounds(320, 110, 120, 65);
		del.setFont(font);
		del.setText("DELETE");
		okno.getContentPane().add(del);
		del.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
				if(delX == true){
					String text = zadani1.getText();
					if (text.length() > 0){
						String newText = text.substring(0, text.length() - 1);
						zadani1.setText(newText);
					}
				}
				else{
					String text = zadani2.getText();
					if (text.length() > 0){
						String newText = text.substring(0, text.length() - 1);
						zadani2.setText(newText);
					}
				}
			}
		});
		
		final JButton c = new JButton();
		c.setText("C");
		c.setFont(font);
		c.setBounds(320, 180, 170, 65);
		okno.getContentPane().add(c);
		c.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
				zadani1.setText("");
				zadani2.setText("");
				vysledek.setText("");
				delX = true;
				rX.setSelected(true);
				where = zadani1;
			}
		});
		
		/* Operace init */
		
		final JButton plus = new JButton();
		final JButton minus = new JButton();
		final JButton krat = new JButton();
		final JButton deleno = new JButton();
		final JButton nadruhou = new JButton();
		final JButton dCarka = new JButton();
		final JButton rovnase = new JButton();	
		
		plus.setBounds(320, 250, 80, 50);
		minus.setBounds(410, 250, 80, 50);
		krat.setBounds(320, 305, 80, 50);
		deleno.setBounds(410, 305, 80, 50);
		nadruhou.setBounds(320, 360, 80, 50);
		dCarka.setBounds(410, 360, 80, 50);
		rovnase.setBounds(320, 415, 170, 55);

		
		plus.setText("+");
		minus.setText("-");
		krat.setText("x");
		deleno.setText("/");
		nadruhou.setText("x2");
		dCarka.setText(".");
		rovnase.setText("=");
		
		plus.setFont(font);
		minus.setFont(font);
		krat.setFont(font);
		deleno.setFont(font);
		nadruhou.setFont(font);
		dCarka.setFont(font);
		rovnase.setFont(font);
		
		plus.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
			if(zadani1.getText() != ""){
				operace = 0;
				where = zadani2;
				rY.setSelected(true);
				delX = false;
				znak.setText(plus.getText());
			}
		}});
		
		minus.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
			if(zadani1.getText() != ""){
				operace = 1;
				where = zadani2;
				delX = false;
				rY.setSelected(true);
				znak.setText(minus.getText());
			}	
		}});
		
		krat.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
			if(zadani1.getText() != ""){
				operace = 2;
				where = zadani2;
				delX = false;
				rY.setSelected(true);
				znak.setText(krat.getText());
			}		
		}});
		
		deleno.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
			if(zadani1.getText() != ""){
				operace = 3;
				where = zadani2;
				delX = false;
				rY.setSelected(true);
				znak.setText(deleno.getText());
			}			
		}});
		
		nadruhou.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
			if(zadani1.getText() != ""){
				operace = 4;
				where = zadani2;
				delX = false;
				rY.setSelected(true);
				znak.setText(nadruhou.getText());
			}				
		}});
		
		dCarka.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
			if(where == zadani1){
				String old = zadani1.getText();
				zadani1.setText(old + ".");
			}
			else if(where == zadani2){
				String old = zadani2.getText();
				zadani2.setText(old + ".");
			}
		}});
		
		rovnase.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
			if(zadani1.getText() != "" && zadani2.getText() != ""){
				x = new Float(zadani1.getText());
				y = new Float(zadani2.getText());
				switch(operace){
				case 0: mezivypocet = scitani(x, y);
						vysledek.setText(mezivypocet + "");
						break;
				case 1: mezivypocet = odecitani(x, y);
						vysledek.setText(mezivypocet + "");
							break;
				case 2: mezivypocet = nasobeni(x, y);
						vysledek.setText(mezivypocet + "");
							break;
				case 3: mezivypocet = deleni(x, y);
						vysledek.setText(mezivypocet + "");
						break;
				case 4: mezivypocet = mocneni(x, y);
						vysledek.setText(mezivypocet + "");
						break;
				default: vysledek.setText("ERROR");
						break;
				}
			}
			else if(zadani1.getText() != ""){
				mezivypocet = new Float(zadani1.getText());
				vysledek.setText(mezivypocet + "");
			}
		}});
		
		okno.getContentPane().add(plus);
		okno.getContentPane().add(minus);
		okno.getContentPane().add(krat);
		okno.getContentPane().add(deleno);
		okno.getContentPane().add(nadruhou);
		okno.getContentPane().add(dCarka);
		okno.getContentPane().add(rovnase);

		/* Mackani */
		
		jedna.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = where.getText();where.setText(old + jedna.getText());;}});
		dva.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = where.getText();where.setText(old + dva.getText());;}});
		tri.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = where.getText();where.setText(old + tri.getText());;}});
		ctyri.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = where.getText();where.setText(old + ctyri.getText());;}});
		pet.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = where.getText();where.setText(old + pet.getText());;}});
		sest.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = where.getText();where.setText(old + sest.getText());;}});
		sedm.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = where.getText();where.setText(old + sedm.getText());;}});
		osm.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = where.getText();where.setText(old + osm.getText());;}});
		devet.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = where.getText();where.setText(old + devet.getText());;}});
		
		/* About */
		JButton about = new JButton();
		about.setFont(font);
		about.setText("About");
		about.setBounds(320, 20, 170, 70);
		about.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
			JFrame fAbout = new JFrame();
			fAbout.setVisible(true);
			fAbout.setSize(300, 200);
			fAbout.setLocation(sW / 2 - 150, sH /2 - 100);
			fAbout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel popis = new JLabel();
			popis.setText("<html><center>My 1st app in Java.<br>Made by Honzaik</center></html>");
			popis.setFont(fontR);
			popis.setBounds(0, 50, 300, 50);
			popis.setHorizontalAlignment(SwingConstants.CENTER);
			
			fAbout.setLayout(null);
			fAbout.getContentPane().add(popis);
			}
		});

		okno.getContentPane().add(about);
	}
}
