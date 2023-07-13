package model.bean;

import java.io.Serializable;

public class DettaglioOrdineBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int numero_ordine;
	int ID_Prodotto;
	int quantita;
	double prezzo;
	
	public DettaglioOrdineBean() 
	{
		numero_ordine = 0;
		ID_Prodotto = 0;
		quantita = 0;
		prezzo = 0.0;
	}

	public int getNumero_ordine() {
		return numero_ordine;
	}

	public void setNumero_ordine(int numero_ordine) {
		this.numero_ordine = numero_ordine;
	}

	public int getID_Prodotto() {
		return ID_Prodotto;
	}

	public void setID_Prodotto(int iD_Prodotto) {
		ID_Prodotto = iD_Prodotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
}