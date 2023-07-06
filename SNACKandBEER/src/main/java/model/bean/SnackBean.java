package model.bean;

import java.io.Serializable;

public class SnackBean implements Serializable {

	private static final long serialVersionUID = 1L;

	int ID_Prodotto;
	int quantita;

	public SnackBean() 
	{
		ID_Prodotto = -1;
		int quantita = -1;
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
	
}