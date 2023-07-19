package model.bean;

import java.io.Serializable;
import java.sql.Date;

public class OrdineBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int numero_ordine;
	String email;
	Date data_ordine;
	int quantita;
	double prezzo_totale;

	public OrdineBean(){
		email = "";
		numero_ordine = 0;
		quantita = 0;
		prezzo_totale = 0.0;
	}	
	
	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo_totale() {
		return prezzo_totale;
	}

	public void setPrezzo_totale(double prezzo_totale) {
		this.prezzo_totale = prezzo_totale;
	}

	public int getNumero_ordine() {
		return numero_ordine;
	}

	public void setNumero_ordine(int numero_ordine) {
		this.numero_ordine = numero_ordine;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData_ordine() {
		return data_ordine;
	}

	public void setData_ordine(Date data_ordine) {
		this.data_ordine = data_ordine;
	}

}