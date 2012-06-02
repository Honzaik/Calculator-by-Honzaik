package eu.honzaik;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class IconCreate{
	public IconCreate(String path){
		this.path = path;
	}
	private String path;
	private URL url;
	private ImageIcon imageIcon;
	private Image icon;
	public ImageIcon imageIconInit(){
		url = this.getClass().getResource(path);
		imageIcon = new ImageIcon(url);
		return(imageIcon);
	}
	
	public Image iconInit(){
		icon = new ImageIcon(this.getClass().getResource(path)).getImage();
		return(icon);
	}
}
