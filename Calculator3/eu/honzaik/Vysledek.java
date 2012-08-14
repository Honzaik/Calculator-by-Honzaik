package eu.honzaik;

import java.util.regex.Pattern;

public class Vysledek {

	public Vysledek(Priklad prvniPriklad, String s) {
		this.prvniPriklad = prvniPriklad;
		this.znamenka = prvniPriklad.znamenka;
		this.cisla = prvniPriklad.cisla;
		this.s = s;
		vypocitej();
	}

	public Priklad prvniPriklad;
	public double vysledek = 0.0;
	private Znamenko[] znamenka;
	private Cislo[] cisla;
	private Znamenko[] znamenkaVys;
	private Znamenko[] znamenkaNiz;
	private String s = null;
	private String newS = "picovina";
	private String[] group = null;
	private double[] mezivysledek;
	private void vypocitej() {
		int valueZnamenek = 0;
		for (int i = 0; i < znamenka.length; i++) {
			valueZnamenek += znamenka[i].value;
		}
		if (valueZnamenek == znamenka.length) { // priklad jen + a -
			vysledek = prvniPriklad.sectiOdecti();
		} else if (valueZnamenek == znamenka.length * 2) { // priklad jen s * a
														   // /
			vysledek = prvniPriklad.nasobDel();
		} else {
			znamenkaFilter();
			znamenkaGroup();

			// nejdriv nadefinovat + - * /
			int temp = 0;
			for (int j = 0; j < group.length; j++) {
				System.out.println(group[j]);
				if (group[j].length() > 1 && test(group[j])) {
					temp++;
				}
			}
			System.out.println("Group length = " + group.length + " " + temp + " \n");

			mezivysledek = new double[temp];
			for (int j = 0; j < group.length; j++) {
				if (group[j].length() > 1 && test(group[j])) {
					Dunno dunno = new Dunno(group[j], true);
					Priklad priklad = new Priklad(dunno.nums, dunno.znamenka);
					mezivysledek[j] = priklad.nasobDel();
					System.out.println(mezivysledek[j]);
				}
			}
			for (int j = 0; j < group.length; j++) {
				if (group[j].length() > 1 && test(group[j])) {
					CharSequence temp1 = group[j];
					CharSequence temp2 = mezivysledek[j] + "";
					if (newS == "picovina") {
						String n = Pattern.quote((String) temp1);
						newS = s.replaceFirst(n, (String) temp2);
					} else {
						String n = Pattern.quote((String) temp1);
						newS = newS.replaceFirst(n, (String) temp2);
					}

					System.out.println("nahrazuju " + temp1 + " za " + temp2 + " " + newS);
				}
			}
			Dunno dunno = new Dunno(newS, true);
			Priklad priklad = new Priklad(dunno.nums, dunno.znamenka);
			vysledek = priklad.sectiOdecti();
		}
	}

	private void znamenkaFilter() {
		int pocetNizZn = 0;
		int pocetVysZn = 0;
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
				temp2++;
			}
			temp++;
		}
	}

	private void znamenkaGroup() {
		String[] temp1, temp2, temp3;
		int temp2size = 0;
		int temp2index = 0;
		if(s.contains("+")){
			temp1 = s.split("\\+");
			for(int i = 0; i < temp1.length; i++){
				if(test(temp1[i]) && !test2(temp1[i])){
					temp2size++;
				}else{
					if(temp1[i].contains("-")){
						temp3 = temp1[i].split("-");
						for(int j = 0; j < temp3.length; j++){
							if(test(temp3[j]) && !test2(temp3[j])){
								temp2size++;
							}
						}
					}
				}
			}
		}else{
			temp1 = s.split("-");
			for(int i = 0; i < temp1.length; i++){
				if(test(temp1[i]) && !test2(temp1[i])){
					temp2size++;
				}
			}
		}
		temp1 = null;
		temp3 = null;
		temp2 = new String[temp2size];
		
		if(s.contains("+")){
			temp1 = s.split("\\+");
			for(int i = 0; i < temp1.length; i++){
				if(test(temp1[i]) && !test2(temp1[i])){
					temp2[temp2index] = temp1[i];
					temp2index++;
				}else{
					if(temp1[i].contains("-")){
						temp3 = temp1[i].split("-");
						for(int j = 0; j < temp3.length; j++){
							if(test(temp3[j]) && !test2(temp3[j])){
								temp2[temp2index] = temp3[j];
								temp2index++;
							}
						}
					}
				}
			}
		}else{
			System.out.println("baf");
			temp1 = s.split("-");
			for(int i = 0; i < temp1.length; i++){
				if(test(temp1[i]) && !test2(temp1[i])){
					temp2[temp2index] = temp1[i];
					temp2index++;
				}
			}
		}
		

		System.out.println("\nhey " + temp2size + temp2index + temp2.length);
		for (int i = 0; i < temp2.length; i++) {
			System.out.println(temp2[i]);
		}
		System.out.println("\n");
		group = temp2;
	}

	private boolean test(String s) {
		boolean temp = true;
		if (s.contains("+")) {
			temp = false;
		} else {
			temp = true;
		}
		if (s.contains("-")) {
			temp = false;
		} else {
			if (!temp) {
				temp = false;
			}
		}
		return temp;
	}
	
	private boolean test2(String s) {
		boolean temp = true;
		if (s.contains("*")) {
			temp = false;
		} else {
			temp = true;
		}
		if (s.contains("/")) {
			temp = false;
		} else {
			if (!temp) {
				temp = false;
			}
		}
		return temp;
	}
}

