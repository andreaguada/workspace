package store;

import java.util.ArrayList;
import java.util.Random;

public class Store {

	private ArrayList<StoreEntry> storeEntries;

	public Store() {
		storeEntries = new ArrayList<>();
	}

	public ArrayList<StoreEntry> getStoreEntries() {
		return storeEntries;
	}

	public void setStoreEntries(ArrayList<StoreEntry> storeEntries) {
		this.storeEntries = storeEntries;
	}

	public int randomQuatityForProduct(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}
