package model.bean;

public class CartItem {
	private ProdottoBean productBean;
	private int quantita;

	public CartItem(ProdottoBean productBean, int quantita) {
		this.productBean = productBean;
		this.quantita = quantita;
	}

	public ProdottoBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProdottoBean pb) {
		this.productBean = pb;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
}