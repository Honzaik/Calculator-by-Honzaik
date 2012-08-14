package eu.honzaik;

public class Cislo {
	
	public Cislo(String s, int startIndex, int endIndex, int index){
		this.s = s;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.index = index;
		setValue();
	}
	
	public Cislo(String s, int startIndex, int endIndex, int index, boolean prvniCisloKladne){
		this.s = s;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.index = index;
		this.prvniCisloKladne = prvniCisloKladne;
		setValue();
	}
	
	public String s;
	public int startIndex;
	public int endIndex;
	public int index;
	public double value;
	public boolean prvniCisloKladne;
	public boolean isProcessed = false;
	
	private void setValue(){
		if(startIndex == 1){
			if(prvniCisloKladne){
				value = new Double(s.substring(startIndex, endIndex + 1));
			}else{
				Double tempVal = new Double(s.substring(startIndex, endIndex + 1));
				value = 0 - tempVal;
			}
		}else{
			value = new Double(s.substring(startIndex, endIndex + 1));
		}
		
	}
	
}
