package eu.honzaik;

public class Priklad {

	public Priklad(Cislo[] cisla, Znamenko[] znamenka) {
		this.cisla = cisla;
		this.znamenka = znamenka;
		// makePriklad();
	}
	
	public Cislo[] cisla;
	public Znamenko[] znamenka;
	public double vysledek = 0.0;
	
	public double sectiOdecti(){
		for (int i = 0; i < cisla.length; i++) {
			double a, b;
			char c;
			a = cisla[i].value;
			if (i == 0) {
				b = cisla[i + 1].value;
				c = znamenka[i].c;
				switch (c) {
					case '+' :
						vysledek = a + b;
						break;
					case '-' :
						vysledek = a - b;
						break;
					default :
						System.err.println("error pičo +");
				}
			} else if (i != 1) {
				c = znamenka[i - 1].c;
				switch (c) {
					case '+' :
						vysledek += a;
						break;
					case '-' :
						vysledek -= a;
						break;
					default :
						System.err.println("error pičo +");
				}

			}
		}
		return vysledek;
	}
	
	public double nasobDel(){
		for (int i = 0; i < cisla.length; i++) {
			double a, b;
			char c;
			a = cisla[i].value;
			if (i == 0) {
				b = cisla[i + 1].value;
				c = znamenka[i].c;
				switch (c) {
					case '*' :
						vysledek = a * b;
						break;
					case '/' :
						vysledek = a / b;
						break;
					default :
						System.err.println("error pičo nas");
				}
			} else if (i != 1) {
				c = znamenka[i - 1].c;
				switch (c) {
					case '*' :
						vysledek *= a;
						break;
					case '/' :
						vysledek /= a;
						break;
					default :
						System.err.println("error pičo nas");
				}

			}
		}
		return vysledek;
	}
	
} 
/*	

	private Znamenko[] znamenkaVys;
	private Znamenko[] znamenkaNiz;
	public double vysledek = 0.0;
	private double[] mezivysledek;
	private double[] mezivysledekVys;
	private int pocetVysZn = 0;
	private int pocetNizZn = 0;
	
	int h = 0;

	public void makePriklad() {
		int valueZnamenek = 0;
		for (int i = 0; i < znamenka.length; i++) {
			valueZnamenek += znamenka[i].value;
		}
		if (valueZnamenek == znamenka.length) { // priklad jen + a -
			for (int i = 0; i < cisla.length; i++) {
				double a, b;
				char c;
				a = cisla[i].value;
				if (i == 0) {
					b = cisla[i + 1].value;
					c = znamenka[i].c;
					switch (c) {
						case '+' :
							vysledek = a + b;
							break;
						case '-' :
							vysledek = a - b;
							break;
						default :
							System.err.println("error pičo");
					}
				} else if (i != 1) {
					c = znamenka[i - 1].c;
					switch (c) {
						case '+' :
							vysledek += a;
							break;
						case '-' :
							vysledek -= a;
							break;
						default :
							System.err.println("error pičo");
					}

				}
			}
		} else if (valueZnamenek == znamenka.length * 2) { // jen s * a /
			for (int i = 0; i < cisla.length; i++) {
				double a, b;
				char c;
				a = cisla[i].value;
				if (i == 0) {
					b = cisla[i + 1].value;
					c = znamenka[i].c;
					switch (c) {
						case '*' :
							vysledek = a * b;
							break;
						case '/' :
							vysledek = a / b;
							break;
						default :
							System.err.println("error pičo");
					}
				} else if (i != 1) {
					c = znamenka[i - 1].c;
					switch (c) {
						case '*' :
							vysledek *= a;
							break;
						case '/' :
							vysledek /= a;
							break;
						default :
							System.err.println("error pičo");
					}

				}
			}
		} else {
			int index = 0;
			int mezivysledekTemp = 0;
			int mezivysledekVysTemp = 0;
			double a, b;
			char c;
			znamenkaFilter();
			for (int i = 0; i < znamenkaVys.length; i++) {
				index = znamenkaVys[i].indexZnamenka;
				a = cisla[index].value;
				b = cisla[index + 1].value;
				c = znamenkaVys[i].c;
				if (index == 0) {
					switch (c) {
						case '*' :
							mezivysledekVys[mezivysledekVysTemp] = a * b;
							break;
						case '/' :
							mezivysledekVys[mezivysledekVysTemp] = a / b;
					}
					cisla[index].isProcessed = true;
					cisla[index + 1].isProcessed = true;
				} else {
					if (i == 0 || znamenkaVys[i - 1].indexZnamenka != index - 1) {
						System.out.println("som tu " + index);
						switch (c) {
							case '*' :
								mezivysledekVys[mezivysledekVysTemp] = a * b;
								break;
							case '/' :
								mezivysledekVys[mezivysledekVysTemp] = a / b;
						}
						cisla[index].isProcessed = true;
						cisla[index + 1].isProcessed = true;
					} else {
						switch (c) {
							case '*' :
								mezivysledekVys[mezivysledekVysTemp] = mezivysledekVys[mezivysledekVysTemp - 1] * b;
								break;
							case '/' :
								mezivysledekVys[mezivysledekVysTemp] = mezivysledekVys[mezivysledekVysTemp - 1] / b;
						}
						cisla[index + 1].isProcessed = true;
					}
				}
				mezivysledekVysTemp++;
			}

			for (int i = 0; i < znamenkaNiz.length; i++) {
				index = znamenkaNiz[i].indexZnamenka;
				c = znamenkaNiz[i].c;
				if (!cisla[index].isProcessed) {
					a = cisla[index].value;
					if(!cisla[index + 1].isProcessed){ // 5 + 6 + 8 * 8
						b = cisla[index + 1].value;
						switch (c) {
							case '+' :
								mezivysledekVys[mezivysledekVysTemp] = a + b; 
								break;
							case '-' :
								mezivysledekVys[mezivysledekVysTemp] = a - b;
								break;
						}
						mezivysledekVysTemp++;
						cisla[index + 1].isProcessed = true;
					}else{ // 5 + 8 * 8  
						switch (c) {
							case '+' :
								mezivysledek[mezivysledekTemp] = a + mezivysledekVys[index + 1]; 
								break;
							case '-' :
								mezivysledek[mezivysledekTemp] = a - mezivysledekVys[index + 1];
								break;
						}
						mezivysledekTemp++;
					}
					cisla[index].isProcessed = true;
				}else{
					if(!cisla[index + 1].isProcessed){
						a = cisla[index + 1].value;
						switch (c) {
							case '+' :
								mezivysledek[mezivysledekTemp] = a + mezivysledekVys[index]; 
								break;
							case '-' :
								mezivysledek[mezivysledekTemp] = a - mezivysledekVys[index];
								break;
						}
						mezivysledekTemp++;
						cisla[index + 1].isProcessed = true;
					}
				}
			}	
		}	
	}
	private void znamenkaFilter() {
		for (int i = 0; i < znamenka.length; i++) {
			if (znamenka[i].value == 1) {
				pocetNizZn++;
			} else {
				pocetVysZn++;
			}
		}
		znamenkaNiz = new Znamenko[pocetNizZn];
		znamenkaVys = new Znamenko[pocetVysZn];
		int temp = 0;
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < znamenka.length; i++) {
			if (znamenka[i].value == 1) {
				znamenkaNiz[temp1] = znamenka[i];
				znamenkaNiz[temp1].indexZnamenka = temp;
				temp1++;
			} else {
				znamenkaVys[temp2] = znamenka[i];
				znamenkaVys[temp2].indexZnamenka = temp;
				System.out.println("Znamenku " + temp2 + " davam index " + temp);
				temp2++;
			}
			temp++;
		}
		mezivysledek = new double[temp];
		mezivysledekVys = new double[temp2];
	}
}
*/