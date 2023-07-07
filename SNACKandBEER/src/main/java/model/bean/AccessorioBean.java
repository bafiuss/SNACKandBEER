package model.bean;

import java.io.Serializable;

public class AccessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	int ID_Prodotto;
	String tipologia;

	public AccessorioBean() 
	{
		ID_Prodotto = -1;
		tipologia = "";
	}

	public int getID_Prodotto() {
		return ID_Prodotto;
	}

	public void setID_Prodotto(int iD_Prodotto) {
		ID_Prodotto = iD_Prodotto;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	

}