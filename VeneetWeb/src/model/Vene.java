package model;

public class Vene {

	String nimi, merkkimalli;
	double pituus, leveys, hinta;
	
	public Vene() {
		super();
		
	}
	

	public Vene(String nimi, String merkkimalli, double pituus, double leveys, double hinta) {
		super();
		this.nimi = nimi;
		this.merkkimalli = merkkimalli;
		this.pituus = pituus;
		this.leveys = leveys;
		this.hinta = hinta;
	}


	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getMerkkimalli() {
		return merkkimalli;
	}

	public void setMerkkimalli(String merkkimalli) {
		this.merkkimalli = merkkimalli;
	}

	public double getPituus() {
		return pituus;
	}

	public void setPituus(double pituus) {
		this.pituus = pituus;
	}

	public double getLeveys() {
		return leveys;
	}

	public void setLeveys(double leveys) {
		this.leveys = leveys;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	@Override
	public String toString() {
		return "Vene [nimi=" + nimi + ", merkkimalli=" + merkkimalli + ", pituus=" + pituus + ", leveys=" + leveys
				+ ", hinta=" + hinta + "]";
	}
	
	}
	
	