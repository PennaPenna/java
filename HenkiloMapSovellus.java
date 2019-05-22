package listatYm;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HenkiloMapSovellus {
	private Scanner input = new Scanner(System.in);
	private Scanner inputLine = new Scanner(System.in);
	private Map<String,Henkilo> henkilot = new HashMap<String,Henkilo>();
	
	public HenkiloMapSovellus() {
		naytaValikko();
		
	}
	
	private void naytaValikko() {
		System.out.println("1. Lisää henkilö");
		System.out.println("2. Näytä henkilön tiedot");
		System.out.println("3. Muuta henkilön nimi ja osoite");
		System.out.println("4. Muuta henkilön koko");
		System.out.println("5. Näytä kaikki henkilöt");
		System.out.println("0. Lopetus");
		System.out.print("Anna valintasi (0-5): ");
		int valinta=0;
		try { valinta=input.nextInt();} 
		catch (Exception e) {
			System.out.println("Valintasi ei ole kokonaisluku.");
		}
		
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
		Henkilo henkilo=new Henkilo();
		System.out.print("Anna nimi: "); 
		String nimi= inputLine.nextLine();
		henkilo.setNimi(nimi);
		System.out.print("Anna osoite: ");
		String osoite=inputLine.nextLine();
		henkilo.setOsoite(osoite);
		Koko koko=new Koko();
		System.out.print("Anna pituus: ");
		double pituus=input.nextDouble();
		koko.setPituus(pituus);
		System.out.print("Anna paino: ");
		int paino=input.nextInt();
		koko.setPaino(paino);
		henkilo.setKoko(koko);
		henkilot.put(henkilo.getNimi(),henkilo);
	}



	private void naytaTiedot() {
		System.out.print("Anna näytettävän henkilön nimi: ");
		String nimiHaku = inputLine.nextLine();
			if (henkilot.containsKey(nimiHaku)) {
				System.out.println("Nimi: " + (henkilot.get(nimiHaku).getNimi()));
				System.out.println("Osoite: " + (henkilot.get(nimiHaku).getOsoite()));
				System.out.println("Pituus: " + (henkilot.get(nimiHaku).getKoko().getPituus()));
				System.out.println("Painoindeksi: " + (henkilot.get(nimiHaku).getKoko().getPainoindeksi()));
				}
			else {System.out.println("Henkilöä ei löytynyt.");
			}
		}



	private void muutaTiedot() {
		Henkilo henkilo = new Henkilo();
		System.out.print("Anna sen henkilön nimi, jonka tietoja haluat muuttaa: ");
		String nimiHaku = inputLine.nextLine();
		if (henkilot.containsKey(nimiHaku)) {
			System.out.print(nimiHaku + " löytyi. \nAnna uusi nimi: "); 
			henkilo.setNimi(inputLine.nextLine());
			System.out.print("Anna uusi osoite: "); 
			henkilo.setOsoite(inputLine.nextLine());
			Koko vanhaKoko= henkilot.get(nimiHaku).getKoko();
			henkilo.setKoko(vanhaKoko);
			henkilot.put(henkilo.getNimi(),henkilo);
			henkilot.remove(nimiHaku);
			}
		else {System.out.println("Henkilöä ei löytynyt.");
		}
	}


	private void muutaKoko() {
		System.out.print("Anna sen henkilön nimi, jonka kokoa haluat muuttaa: "); 
		String nimiHaku = inputLine.nextLine();
		if (henkilot.containsKey(nimiHaku)) {
			System.out.print(nimiHaku + " löytyi. \nAnna uusi pituus: "); 
			double uusiPituus=input.nextDouble();
			System.out.print("Anna uusi paino: "); 
			int uusiPaino=input.nextInt();
			Koko uusiKoko= new Koko(uusiPituus, uusiPaino);
			henkilot.get(nimiHaku).setKoko(uusiKoko);
			} 
		else {System.out.println("Henkilöä ei löytynyt.");
		}
	}

	private void naytaKaikki() {
		Set<String> nimet = henkilot.keySet();
		Iterator<String> i = nimet.iterator();
		String seurNimi = null;
		Henkilo seurHlo =null;
		while (i.hasNext()) {
			seurNimi=i.next();
			seurHlo=henkilot.get(seurNimi);
		System.out.println("\nNimi: " + (seurHlo.getNimi()));
		System.out.println("Osoite: " + (seurHlo.getOsoite()));
		System.out.println("Pituus: " + (seurHlo.getKoko().getPituus()));
		System.out.println("Painoindeksi: " + (seurHlo.getKoko().getPainoindeksi()));
		}
		}


	
	
	public static void main(String[] args) {
		new HenkiloMapSovellus();

	}

}
