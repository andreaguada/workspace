package store;

import product.Product;

public class StoreEntry {

	private int quantityForProduct;
	private Product product;

	public int getQuantityForProduct() {
		return quantityForProduct;
	}

	public void setQuantityForProduct(int quantityForProduct) {
		this.quantityForProduct = quantityForProduct;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
