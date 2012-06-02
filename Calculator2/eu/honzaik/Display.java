package eu.honzaik;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


public class Display{

	public Display(){
		
	}
	private Font vysledekF = new Font("Arial", Font.BOLD, 30);
	private Font actionF = new Font("Arial", Font.BOLD, 40);
	private Font zadaniF = new Font("Arial", Font.BOLD, 20);
	private Font errorF = new Font("Arial", Font.PLAIN, 15);
	
	
	public JFormattedTextField createVysledekF(){
		JFormattedTextField vysledek = new JFormattedTextField();
		vysledek.setEditable(false);
		vysledek.setFont(vysledekF);
		vysledek.setSelectionColor(Color.CYAN);
		vysledek.setSelectedTextColor(Color.BLACK);
		vysledek.setHorizontalAlignment(JFormattedTextField.RIGHT);
		vysledek.setBounds(10, 160, 695, 30);
		return vysledek;
	}
	
	public JFormattedTextField createX(){
		JFormattedTextField x = new JFormattedTextField();
		x.setEditable(false);
		x.setFont(zadaniF);
		x.setSelectionColor(Color.RED);
		x.setSelectedTextColor(Color.BLACK);
		x.setHorizontalAlignment(JFormattedTextField.LEFT);
		x.setBounds(10, 10, 695, 30);
		return x;
	}
	
	public JFormattedTextField createY(){
		JFormattedTextField y = new JFormattedTextField();
		y.setEditable(false);	
		y.setText(null);
		y.setFont(zadaniF);
		y.setSelectionColor(Color.RED);
		y.setSelectedTextColor(Color.BLACK);
		y.setHorizontalAlignment(JFormattedTextField.LEFT);
		y.setBounds(10, 100, 695, 30);
		return y;
	}
	
	public JLabel createActionField(){
		JLabel jl = new JLabel();
		jl.setFont(actionF);
		jl.setBounds(720 / 2 - 25, 45, 50, 50);
		return (jl);
	}
	
	public JTextPane createErrorField(){
		SimpleAttributeSet attribs = new SimpleAttributeSet();  
		StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_RIGHT); 
		
		JTextPane eF = new JTextPane();
		eF.setEditable(false);
		eF.setFont(errorF);
		eF.setBounds(400, 35, 300, 60);
		eF.setForeground(Color.RED);
		eF.setOpaque(false);
		eF.setParagraphAttributes(attribs,false);  
		return (eF);
	}
	
	
}
