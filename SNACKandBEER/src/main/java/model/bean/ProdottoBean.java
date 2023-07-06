package model.bean;

import java.io.Serializable;

public class ProdottoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	int ID_Prodotto;
	String titolo;
	String produttore;
	String descrizione;
	double prezzo;
	String categoria;
	String png;

	public ProdottoBean() 
	{
		ID_Prodotto = -1;
		titolo = "";
		produttore = "";
		descrizione = "";
		prezzo = 0;
		categoria = "";
		png = "";
	}

	public int getID_Prodotto() {
		return ID_Prodotto;
	}

	public void setID_Prodotto(int ID_Prodotto) {
		this.ID_Prodotto = ID_Prodotto;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getProduttore() {
		return produttore;
	}

	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPng() {
		return png;
	}

	public void setPng(String png) {
		this.png = png;
	}

	
	
}
