package listatYm;

import java.util.ArrayList;
import java.util.Scanner;

public class HenkiloListaSovellus {
	private Scanner input = new Scanner(System.in);
	private Scanner inputLine = new Scanner(System.in);
	private ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
	
	public HenkiloListaSovellus() {
		naytaValikko();
		
	}
	
	

	private void naytaValikko() {
		System.out.println("\n1. Lisää henkilö");
		System.out.println("2. Näytä henkilön tiedot");
		System.out.println("3. Muuta henkilön nimi ja osoite");
		System.out.println("4. Muuta henkilön koko");
		System.out.println("5. Näytä kaikki henkilöt");
		System.out.println("0. Lopetus");
		System.out.print("Anna valintasi (0-5): ");
		int valinta=input.nextInt();
		switch(valinta) {
		case 1:
			lisaaHenkilo();
			break;
		case 2:
			naytaTiedot();
			break;
		case 3:
			muutaTiedot();
			break;
		case 4:
			muutaKoko();
			break;
		case 5:
			naytaKaikki();
			break;
		case 0:
			System.out.println("LOPETETTU");
			System.exit(0);
			break;
			default:
				System.out.println("Numero ei kelpaa.");
				break;
				}
		naytaValikko();
		}

		
	
		
	private void lisaaHenkilo() {
		System.out.print("Anna nimi: "); 
		String nimi= inputLine.nextLine();
		System.out.print("Anna osoite: ");
		String osoite=inputLine.nextLine();
		System.out.print("Anna pituus: ");
		double pituus=input.nextDouble();
		System.out.print("Anna paino: ");
		int paino=input.nextInt();
		henkilot.add(new Henkilo(nimi, osoite, new Koko(pituus, paino)));
	}



	private void naytaTiedot() {
		int i=0;
		boolean loytynyt=false;
		Henkilo henkilo=null;
		System.out.print("Anna näytettävän henkilön nimi: ");
		String nimiHaku = inputLine.nextLine();
		while (! loytynyt && i < henkilot.size()) {
			henkilo=henkilot.get(i);
			String nimi=henkilo.getNimi();
			if (nimi.equalsIgnoreCase(nimiHaku)) {
				loytynyt=true;}
			else {
				i++;}
	}
			if (loytynyt) {
				System.out.println("Nimi: " + (henkilo.getNimi()));
				System.out.println("Osoite: " + (henkilo.getOsoite()));
				System.out.println("Pituus: " + (henkilo.getKoko().getPituus()));
				System.out.println("Painoindeksi: " + (henkilo.getKoko().getPainoindeksi()));
				}
			else {System.out.println("Henkilöä ei löytynyt.");
			}
		}



	private void muutaTiedot() {
		int i=0;
		boolean loytynyt=false;
		Henkilo henkilo=null;
		System.out.print("Anna sen henkilön nimi, jonka tietoja haluat muuttaa: ");
		String nimiHaku = inputLine.nextLine();
		while (! loytynyt && i < henkilot.size()) {
			henkilo=henkilot.get(i);
			String nimi=henkilo.getNimi();
			if (nimi.equals(nimiHaku)) {
				loytynyt=true;}
			else {
				i++;}
	}
			if (loytynyt) {
				System.out.print(nimiHaku + " löytyi. \nAnna uusi nimi: "); 
				henkilo.setNimi(inputLine.nextLine());
				System.out.print("Anna uusi osoite: "); 
				henkilo.setOsoite(inputLine.nextLine());
			}
			else {System.out.println("Henkilöä ei löytynyt.");
			}
		}	



	private void muutaKoko() {
		/* int i=0;
		boolean loytynyt=false;
		Henkilo henkilo=null;
		System.out.print("Anna sen henkilön nimi, jonka kokoa haluat muuttaa: "); 
		String nimiHaku = inputLine.nextLine();
		while (! loytynyt && i < henkilot.size()) {
			henkilo=henkilot.get(i);
			String nimi=henkilo.getNimi();
			if (nimi.equals(nimiHaku)) {
				loytynyt=true;}
			else {
				i++;}
	}
			if (loytynyt) {
				System.out.print(nimiHaku + " löytyi. \nAnna uusi pituus: "); 
				double uusiPituus=input.nextDouble();
				System.out.print("Anna uusi paino: "); 
				int uusiPaino=input.nextInt();
				Koko uusiKoko= new Koko(uusiPituus, uusiPaino);
				henkilo.setKoko(uusiKoko);
			}
			else {System.out.println("Henkilöä ei löytynyt.");
			}
		}	*/
		
		
		int hlonsijainti= etsija("Anna sen henkilön nimi, jonka kokoa haluat muuttaa: ");
		if (hlonsijainti==-1) {
			System.out.println("Henkilöä ei ole.");
		}
	else {
		System.out.print("\nAnna uusi pituus: "); 
		double uusiPituus=input.nextDouble();
		System.out.print("Anna uusi paino: "); 
		int uusiPaino=input.nextInt();
		Koko uusiKoko= new Koko(uusiPituus, uusiPaino);
		henkilot.get(hlonsijainti).setKoko(uusiKoko);
	}}



	private void naytaKaikki() {
		for (int i=0; i<henkilot.size();i++) {
		System.out.println("Nimi: " + (henkilot.get(i).getNimi()));
		System.out.println("Osoite: " + (henkilot.get(i).getOsoite()));
		System.out.println("Pituus: " + (henkilot.get(i).getKoko().getPituus()));
		System.out.println("Painoindeksi: " + (henkilot.get(i).getKoko().getPainoindeksi()));
		}
	}

// ETSIJÄMETODI
	private  int etsija(String ilmoitus) {
		int paluu=-1;
		String nimiHaku="";
		nimiHaku=input.nextLine();
		for(int i=0; i<henkilot.size(); i++) {
			if (henkilot.get(i).getNimi().equalsIgnoreCase(nimiHaku)) {
				paluu=i;
				break;
			}
		}
		return paluu;
	}

	public static void main(String[] args) {
		new HenkiloListaSovellus();	
	}

}
