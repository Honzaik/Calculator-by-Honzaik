package eu.honzaik.Calc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calc {
	
	public Calc(){
		start();
	}
	
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
		
		Font fontZ = new Font("Arial", Font.BOLD, 35);
		
		zadani1.setBounds(20, 20, 300, 35);
		zadani2.setBounds(20, 100, 300, 35);
		znak.setBounds(20, 60, 100, 35);
		
		zadani1.setFont(fontZ);
		zadani2.setFont(fontZ);
		
		okno.getContentPane().add(zadani1);
		okno.getContentPane().add(zadani2);
		
		/* Delete */
		
		final JButton del = new JButton();
		
		del.setBounds(320, 100, 170, 140);
		del.setFont(font);
		del.setText("DELETE");
		okno.getContentPane().add(del);
		del.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
				String text = zadani1.getText();
				if (text.length() > 0){
					String newText = text.substring(0, text.length() - 1);
					zadani1.setText(newText);
				}
			}
		});
		
		/* Vysledek */
		
		final JLabel vysledek = new JLabel();
		
		Font fontV = new Font("Arial", Font.BOLD, 40);
		
		vysledek.setBounds(20, 40, 300, 300);
		vysledek.setFont(fontV);
		
		okno.getContentPane().add(vysledek);
		
		/* Operace init */
		
		final JButton plus = new JButton();
		final JButton minus = new JButton();
		final JButton krat = new JButton();
		final JButton deleno = new JButton();
		final JButton nadruhou = new JButton();
		final JButton rovnase = new JButton();
		
		plus.setBounds(320, 250, 80, 50);
		minus.setBounds(410, 250, 80, 50);
		krat.setBounds(320, 305, 80, 50);
		deleno.setBounds(410, 305, 80, 50);
		nadruhou.setBounds(320, 360, 170, 50);
		rovnase.setBounds(320, 415, 170, 55);

		
		plus.setText("+");
		minus.setText("-");
		krat.setText("x");
		deleno.setText("/");
		nadruhou.setText("x2");
		rovnase.setText("=");
		
		plus.setFont(font);
		minus.setFont(font);
		krat.setFont(font);
		deleno.setFont(font);
		nadruhou.setFont(font);
		rovnase.setFont(font);
		
		plus.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){
			// OPERACE PRO ZMENENI zadani1 na zadani2 v "Mackani"
		}});
		
		okno.getContentPane().add(plus);
		okno.getContentPane().add(minus);
		okno.getContentPane().add(krat);
		okno.getContentPane().add(deleno);
		okno.getContentPane().add(nadruhou);
		okno.getContentPane().add(rovnase);

		/* Mackani */
		jedna.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = zadani1.getText();zadani1.setText(old + jedna.getText());;}});
		dva.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = zadani1.getText();zadani1.setText(old + dva.getText());;}});
		tri.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = zadani1.getText();zadani1.setText(old + tri.getText());;}});
		ctyri.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = zadani1.getText();zadani1.setText(old + ctyri.getText());;}});
		pet.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = zadani1.getText();zadani1.setText(old + pet.getText());;}});
		sest.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = zadani1.getText();zadani1.setText(old + sest.getText());;}});
		sedm.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = zadani1.getText();zadani1.setText(old + sedm.getText());;}});
		osm.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = zadani1.getText();zadani1.setText(old + osm.getText());;}});
		devet.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(ActionEvent e){String old = zadani1.getText();zadani1.setText(old + devet.getText());;}});
		
	}
}
