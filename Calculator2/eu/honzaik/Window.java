package eu.honzaik;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Window extends JFrame{
	private static final long serialVersionUID = -7674866900869634414L;
	public Window(){
		windowInit();
	}
	public Window(String name){
		this.name = name;
		windowInit();
	}
	public Window(int width, int height){
		this.width = width;
		this.height = height;
	}	
	public Window(int width, int height, String name){
		this.width = width;
		this.height = height;
		this.name = name;
		windowInit();
	}
	public Window(int width, int height, String name, Image icon){
		this.width = width;
		this.height = height;
		this.name = name;
		this.icon = icon;
		if(icon != null){
			this.withIcon = true;
		}	
		windowInit();
	}
	private boolean withIcon = false;
	private Image icon;
	private int width = 720;
	private int height = 480;
	public static final int sW = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int sH = Toolkit.getDefaultToolkit().getScreenSize().height;
	public String name = "Calculator by Honzaik";
	public void windowInit(){
		if(!withIcon){
			try{
				icon = new IconCreate("/res/kalkulacka.png").iconInit();
			}catch(Exception e){}	
			setIconImage(icon);
		}else{
			setIconImage(icon);
		}
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(width, height);
		setResizable(false);
		setLocation(sW / 2 - getWidth() / 2, sH / 2 - getHeight() / 2);
		setTitle(name);
	}
}
