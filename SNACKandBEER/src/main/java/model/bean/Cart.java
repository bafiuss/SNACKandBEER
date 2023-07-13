package model.bean;

import java.util.ArrayList;
import java.util.List;


public class Cart {

	private List<CartItem> items;

	public Cart() {
		items = new ArrayList<>();
	}

	public void addProduct(ProdottoBean product) {
		for (CartItem item : items) {
			if (item.getProductBean().getID_Prodotto() == product.getID_Prodotto()) {
				item.setQuantita(item.getQuantita() + 1);
				return;
			}
		}
		items.add(new CartItem(product, 1));
	}

	public void deleteProduct(ProdottoBean product) {
		for (CartItem item : items) {
			if (item.getProductBean().getID_Prodotto() == product.getID_Prodotto()) {
				if (item.getQuantita() > 1) {
					item.setQuantita(item.getQuantita() - 1);
				} else {
					items.removeIf((a) -> a.getProductBean().getID_Prodotto() == product.getID_Prodotto());
				}
				return;
			}
		}
	}

	public List<CartItem> getProducts() {
		return items;
	}
	
	public int getItemsCount() {
		return items.stream().mapToInt(i->i.getQuantita()).sum();
	}
	
	public double getTotale() {
		return items.stream().mapToDouble(i->i.getProductBean().getPrezzo()*i.getQuantita()).sum();
	}
}