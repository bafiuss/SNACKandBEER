package model.bean;

import java.io.Serializable;

public class BirraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	int ID_Prodotto;
	double volume;
	double gradAlcolica;
	String colore;
	String nazione;

	public BirraBean() 
	{
		ID_Prodotto = -1;
		volume = -1;
		gradAlcolica = -1;
		colore = "";
		nazione = "";
	}

	public int getID_Prodotto() {
		return ID_Prodotto;
	}

	public void setID_Prodotto(int iD_Prodotto) {
		ID_Prodotto = iD_Prodotto;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getGradAlcolica() {
		return gradAlcolica;
	}

	public void setGradAlcolica(double gradAlcolica) {
		this.gradAlcolica = gradAlcolica;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	
}