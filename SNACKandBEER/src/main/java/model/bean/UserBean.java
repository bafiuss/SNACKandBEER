package model.bean;

import java.io.Serializable;
import java.sql.Date;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	String email;
	String password;
	String nome;
	String cognome;
	String indirizzo;
	boolean isAdmin;

	public UserBean() 
	{
		email = "";
		password = "";
		nome = "";
		cognome = "";
		indirizzo = "";
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


	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
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
				+ ", indirizzo=" + indirizzo + ", isAdmin=" + isAdmin + "]";
	}
	
	public boolean passControl(String s, String m) {
		if(s.equals(m)) return true;
		
		return false;
	}	


}
