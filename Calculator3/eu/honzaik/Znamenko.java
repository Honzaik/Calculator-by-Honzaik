package eu.honzaik;

public class Znamenko {
	public Znamenko (String s, int index, char c){
		this.s = s;
		this.index = index;
		this.c = c;
		setValue();
		if(value == 2) isDone = false;
	}
	
	public String s;
	public int index;
	public int value;
	public int indexZnamenka;
	public char c;
	public boolean isDone = true;
	
	private void setValue(){
		if(c == '+' || c == '-') value = 1;
		if(c == '*' || c == '/') value = 2;
	}
}
