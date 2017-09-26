package cart;

import java.util.ArrayList;

public class Cart {

	private ArrayList<CartEntry> entries;
	private int amount;
	private float totalPrice;

	public Cart() {
		amount = 0;
		totalPrice = 0;
		entries = new ArrayList<>();
	}

	public ArrayList<CartEntry> getEntries() {
		return entries;
	}

	public void setEntries(ArrayList<CartEntry> entries) {
		this.entries = entries;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
