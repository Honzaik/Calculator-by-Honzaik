package eu.honzaik;

public class Priklad {
	public Priklad(double x, double y){
		this.x = x;
		this.y = y;
	}
	private double x;
	private double y;
	
	public double scitani(){
		return (x + y);
	}
	public double odecitani(){
		return (x - y);
	}
	public double nasobeni(){
		return (x * y);
	}
	public double deleni(){
		return (x / y);
	}
	public double mocneni(){
		return (Math.pow(x, y));
	}
}
