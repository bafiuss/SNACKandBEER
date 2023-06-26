package model.bean;

import java.io.Serializable;
import java.sql.Date;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	String email;
	String password;
	String nome;
	String cognome;
	String nascita;
	String indirizzo;
	String indirizzoSped;
	boolean isAdmin;

	public UserBean() 
	{
		email = "";
		password = "";
		nome = "";
		cognome = "";
		indirizzo = "";
		indirizzoSped = "";
		nascita = "";
		isAdmin = false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getNascita() {
		return nascita;
	}
	public void setNascita(String nascita) {
		this.nascita = nascita;
	}


	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getIndirizzoSped() {
		return indirizzoSped;
	}

	public void setIndirizzoSped(String indirizzoSped) {
		this.indirizzoSped = indirizzoSped;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	
	@Override
	public String toString() {
		return "UserBean [email=" + email + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome
				+ ", nascita=" + nascita + ", indirizzo=" + indirizzo + ", indirizzoSped=" + indirizzoSped
				+ ", isAdmin=" + isAdmin + "]";
	}

	public boolean passControl(String s, String m) {
		if(s.equals(m)) return true;
		
		return false;
	}	


}
