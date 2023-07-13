package model.bean;

import java.io.Serializable;
import java.sql.Date;

public class OrdineBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int numero_ordine;
	String email;
	Date data_ordine;

	public OrdineBean(){
		email = "";
		numero_ordine = 0;
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