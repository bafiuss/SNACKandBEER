package model.bean;

import java.io.Serializable;

public class ProdottoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	int ID_Prodotto;
	String nome;
	String produttore;
	String descrizione;
	double prezzo;
	int quantita;
	String categoria;
	byte[] photo;

	public ProdottoBean() 
	{
		ID_Prodotto = -1;
		nome = "";
		produttore = "";
		descrizione = "";
		prezzo = 0;
		quantita = 0;
		categoria = "";
		
	}
	
	public ProdottoBean(int ID_Prodotto, String nome, String produttore, String descrizione, double prezzo, int quantita, String categoria)
	{
		this.ID_Prodotto = ID_Prodotto;
		this.nome = nome;
		this.produttore = produttore;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.categoria = categoria;
		
	}

	public int getID_Prodotto() {
		return ID_Prodotto;
	}

	public void setID_Prodotto(int ID_Prodotto) {
		this.ID_Prodotto = ID_Prodotto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}
