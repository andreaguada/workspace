package product;

import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;
import maps.Category;
import maps.MappingCategoryValue;
import maps.Value;
import store.Store;
import store.StoreEntry;

public class ImplMethodsProduct implements ProductMethods {
	static final Logger logger = Logger.getLogger(ImplMethodsProduct.class);
	Scanner scan = new Scanner(System.in);

	@Override
	public void insertProductCode(Product product, Store store) {
		boolean productCodeExist;
		String preSetCode;
		do {
			productCodeExist = false;
			preSetCode = scan.next();
			for (StoreEntry storeEntryItem : store.getStoreEntries()) {
				if (storeEntryItem.getProduct().getProductCode() != null
						&& storeEntryItem.getProduct().getProductCode().equals(preSetCode)) {
					logger.debug("Codice prodotto già esistente.");
					productCodeExist = true;
					break;
				}
			}
		} while (productCodeExist == true);
		product.setProductCode(preSetCode);
	}

	@Override
	public void insertProductCategory(Product product, Store store) {
		Category[] category = Category.alphabeticalOrder();
		String chooseCategory = null;
		boolean categoryExist;
		int n = 1;
		for (Category element : category) {
			logger.debug(n + " " + element);
			n++;
		}
		do {
			try {
				chooseCategory = scan.next();
				product.setCategory(category[Integer.valueOf(chooseCategory) - 1]);
				categoryExist = true;
			} catch (Exception e) {
				logger.debug("Hai inserito un tasto diverso da quelli possibili.");
				categoryExist = false;
			}
		} while (categoryExist == false);
	}

	@Override
	public void insertProductPrice(Product product, Store store) throws Exception {
		StoreEntry storeEntry = new StoreEntry();
		/*
		 * riga 1 e 2: creo un oggetto della classe dove è presente la mappatura
		 * dei prezzi associati alle categorie e vado a richiamare il metodo
		 * getMap(). riga 3: mi restituisce il valore associato alla chiave.
		 */
		MappingCategoryValue mappingCategoryValue = new MappingCategoryValue(); // 1
		Map<Category, Value> map = mappingCategoryValue.getMap(); 				// 2
		Value value = (Value) map.get(product.getCategory()); 					// 3
		boolean correctPrice;
		if (value == null) {
			logger.error("Impossibile determinare la fascia di prezzo per la categoria selezionata.\n");
			throw new Exception();
		}
		logger.debug("(Il prezzo per la categoria " + product.getCategory() + " deve essere compreso tra "
				+ value.getMin() + "€ e " + value.getMax() + "€)");
		do {
			correctPrice = true;
			try {
				product.setPrice(Float.valueOf(scan.next()));
				if (product.getPrice() < value.getMin() || product.getPrice() > value.getMax())
					throw new IllegalArgumentException();
				else {
					storeEntry.setProduct(product);
					storeEntry.setQuantityForProduct(store.randomQuatityForProduct(100, 200));
					store.getStoreEntries().add(storeEntry);
					logger.debug("Prodotto inserito!\n");
				}
			} catch (IllegalArgumentException exc) {
				logger.error("Il prezzo inserito non è valido.");
				correctPrice = false;
			}
		} while (correctPrice == false);
	}

	@Override
	public void searchProduct(Store store) {
		String searchButton;
		boolean foundProduct = false;

		if (store.getStoreEntries().size() == 0) {
			logger.debug("Impossibile trovare prodotti perchè la lista è vuota.\n");
			return;
		} else {
			logger.debug("Scrivere il codice prodotto da cercare nella lista.\n");
			searchButton = scan.next();
			for (StoreEntry storeEntryItem : store.getStoreEntries()) {
				if (searchButton.equals(storeEntryItem.getProduct().getProductCode())) {
					logger.debug(storeEntryItem.getProduct().getProductCode() + "\n"
							+ storeEntryItem.getProduct().getName() + "\n" + storeEntryItem.getProduct().getCategory());
					logger.debug(storeEntryItem.getProduct().getPrice() + "€\n\n");
					foundProduct = true;
					break;
				}
			}
		}
		if (foundProduct == false)
			logger.debug("Non ho trovato nessun prodotto che ha come codice '" + searchButton + "'.\n");
	}

	@Override
	public void showProductList(Store store) {
		if (store.getStoreEntries().size() == 1)
			logger.debug("La lista contiene un prodotto.\n");
		else
			logger.debug("La lista contiene " + store.getStoreEntries().size() + " prodotti.\n");
		for (StoreEntry storeEntryItem : store.getStoreEntries()) {
			logger.debug("Codice: " + storeEntryItem.getProduct().getProductCode() + "\nNome: "
					+ storeEntryItem.getProduct().getName() + "\nCategoria: "
					+ storeEntryItem.getProduct().getCategory() + "\nPrezzo: " + storeEntryItem.getProduct().getPrice()
					+ "€\n\n");
		}
	}

	@Override
	public void showStock(Store store){
		if (store.getStoreEntries().size() != 0) {
			for (StoreEntry storeEntryItem : store.getStoreEntries()) {
				logger.debug(storeEntryItem.getProduct().getName() + "		pezzi: " + storeEntryItem.getQuantityForProduct());
				logger.debug("\n");
			}
		} else
			logger.debug("Nel magazzino non ci sono prodotti.\nInserirne almeno uno\n\n");
	}

}
