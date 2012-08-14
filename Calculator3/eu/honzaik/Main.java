package eu.honzaik;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main implements KeyListener{

	public Main(){
		baf();	
	}
	
	public Window window;
	public JTextField zadani;
	public JTextField vysledek;
	public String s;
	public String vysl = null;
	
	public void baf(){
		Font fontCisla = new Font("Consolas", Font.PLAIN, 20);
		Font fontAuthor = new Font("Consolas", Font.PLAIN, 15);
		Font fontVysledek = new Font("Consolas", Font.PLAIN, 40);
		window = new Window(600, 200, "Calculator 3");
		window.addKeyListener(this);
		
		zadani = new JTextField();
		vysledek = new JTextField();
		JLabel author = new JLabel("by @Honzaik :*");
		JButton doIt = new JButton("Count!.. you cunt");
		
		zadani.setEditable(true);
		zadani.setFocusable(true);
		zadani.addKeyListener(this);
		zadani.setBounds(10, 10, 580, 30);
		zadani.setFont(fontCisla);
		
		vysledek.setEditable(false);
		vysledek.setBounds(20, 100, 560, 60);
		vysledek.setFont(fontVysledek);
		vysledek.setHorizontalAlignment(JTextField.RIGHT);
		
		author.setBounds(40, 60, 300, 20);
		author.setFont(fontAuthor);
		author.setForeground(Color.pink);
		
		doIt.setFocusable(true);
		doIt.addKeyListener(this);
		doIt.setBounds(440, 50, 140, 30);
		doIt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = zadani.getText();
				lol();
				vysledek.setText(vysl);
			}
		});
		
		window.setLayout(null);
		window.getContentPane().add(zadani);
		window.getContentPane().add(vysledek);
		window.getContentPane().add(author);
		window.getContentPane().add(doIt);         
	}
	
	public void lol(){
		Dunno dunno = new Dunno(s);
		vysl = dunno.vysledek + "";
	    System.out.println(vysl);
	}
	
	public static void main(String[] args) {
		Main hlavni = new Main();
		hlavni.window.setVisible(true);
	}

	@Override
    public void keyPressed(KeyEvent arg0) { 
    }

	@Override
    public void keyReleased(KeyEvent arg0) {
	    if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
	    	s = zadani.getText();
	    	lol();
	    	vysledek.setText(vysl);
	    }
    }

	@Override
    public void keyTyped(KeyEvent arg0) {
    }
	
}
