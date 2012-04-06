package eu.honzaik.Calc;

public class Priklad {
	public Priklad(float x, float y, String metoda){
		this.x = x;
		this.y = y;
		this.metoda = metoda;
	}
	
	public Priklad(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	float x;
	float y;
	String metoda;
	
	public float scitani(){
		return (x + y);
	}
	
	public float odecitani(){
		return (x - y);
	}
	
	public float nasobeni(){
		return (x * y);
	}
	
	public float deleni(){
		return (x / y);
	}
	
	public float mocneni(){
		return (float) (Math.pow(x, y));
	}
	
	public void pocitej(){
		if(metoda == "scitani"){scitani();}
		else if(metoda == "odecitani"){odecitani();}
		else if(metoda == "nasobeni"){nasobeni();}
		else if(metoda == "deleni"){deleni();}
		else if(metoda == "mocneni"){mocneni();}
	}
}