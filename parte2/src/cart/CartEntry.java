package cart;

import product.Product;

public class CartEntry {

	private int quantityOfProduct;
	private float subPrice;
	private Product product;

	public int getQuantityOfProduct() {
		return quantityOfProduct;
	}

	public void setQuantityOfProduct(int quantityOfProduct) {
		this.quantityOfProduct = quantityOfProduct;
	}

	public float getSubPrice() {
		return subPrice;
	}

	public void setSubPrice(float subPrice) {
		this.subPrice = subPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
