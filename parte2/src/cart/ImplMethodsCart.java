package cart;

import org.apache.log4j.Logger;

//import database.DatabaseMethods;
import store.Store;
import store.StoreEntry;

import java.util.*;

public class ImplMethodsCart implements CartMethods {

	Scanner scan = new Scanner(System.in);
	static final Logger logger = Logger.getLogger(ImplMethodsCart.class);

	@Override
	public void addProductsToCart(Cart cart, Store store) {
		CartEntry cartEntry = new CartEntry();
		String chooseProduct;
		String preProductAmount = null;
		int quantityForProductAfterAdd = 0;
		boolean chooseCorrectProduct = false;
		boolean correctProductAmount = false;

		if (store.getStoreEntries().size() != 0) {
			for (StoreEntry storeEntryItem : store.getStoreEntries()) {
				logger.debug("Codice: " + storeEntryItem.getProduct().getProductCode() + "\nNome: " + storeEntryItem.getProduct().getName() + "\nCategoria: " + storeEntryItem.getProduct().getCategory() + 
						"\nPrezzo: " + storeEntryItem.getProduct().getPrice() + "€\nPezzi disponibili: " + storeEntryItem.getQuantityForProduct() + "\n\n");
			}
			do {
				logger.debug("Inserire il codice prodotto dell'oggetto da aggiungere al carrello.");
				chooseProduct = scan.next();
				for (StoreEntry storeEntryItem : store.getStoreEntries()) {
					if (chooseProduct.equals(storeEntryItem.getProduct().getProductCode())) {
						chooseCorrectProduct = true;
						do {
							try {
								logger.debug("Inserire quantità prodotto da aggiunere al carrello.");
								preProductAmount = scan.next();
							} catch (IllegalStateException e) {
								logger.error("Quantità inserita non corretta.\n");
							}
							if (Integer.valueOf(preProductAmount) <= 0) {
								logger.debug("Non puoi aggiungere le unità inserite.\n");
							} else if (Integer.valueOf(preProductAmount) > storeEntryItem.getQuantityForProduct()) {
								logger.debug("Non ci sono abbastanza scorte. (Massimo pezzi disponibili " + storeEntryItem.getQuantityForProduct() + ")");
							} else {
								logger.debug("Sono state aggiunte " + preProductAmount + " unità.\n");
								correctProductAmount = true;
								boolean addEntry = true;
								for (CartEntry cartEntryItem : cart.getEntries()) {
									if (cartEntryItem.getProduct().getProductCode() == storeEntryItem.getProduct() .getProductCode()) {
										cartEntryItem.setQuantityOfProduct(cartEntryItem.getQuantityOfProduct() + Integer.valueOf(preProductAmount));
										cartEntryItem.setSubPrice(cartEntryItem.getSubPrice() + (storeEntryItem.getProduct().getPrice() * Integer.valueOf(preProductAmount)));
										addEntry = false;
//										db.dbUpdateProductIntoCart(cartEntry);
										break;
									}
								}
								if (addEntry == true) {
									cartEntry.setProduct(storeEntryItem.getProduct());
									cartEntry.setQuantityOfProduct(Integer.valueOf(preProductAmount));
									cartEntry.setSubPrice(storeEntryItem.getProduct().getPrice() * Integer.valueOf(preProductAmount));
									cart.getEntries().add(cartEntry);
//									db.dbInsertProductIntoCart(cartEntry);
								}
								quantityForProductAfterAdd = storeEntryItem.getQuantityForProduct() - Integer.valueOf(preProductAmount);
								storeEntryItem.setQuantityForProduct(quantityForProductAfterAdd);
								calculateCartPrice(cart);
							}
						} while (correctProductAmount == false);
					}
				}
			} while (chooseCorrectProduct == false);
		} else 
			logger.debug("Non ci sono prodotti disponibli. Inserirne almeno uno.\n");
	}

	@Override
	public void showCartPrice(Cart cart) {
		if (cart.getEntries().size() == 0) {
			logger.debug("Nel carrello non ci sono articoli.\n");
		} else {
			logger.debug("Il carrello contiene " + cart.getAmount() + " articoli:\n");
			for (CartEntry cartEntryItem : cart.getEntries()) {
				logger.debug(cartEntryItem.getProduct().getName() + " " + cartEntryItem.getProduct().getCategory());
				logger.debug("x" + cartEntryItem.getQuantityOfProduct() + "	" + cartEntryItem.getSubPrice() + "$\n");
			}
			logger.debug("Prezzo totale carrello: " + cart.getTotalPrice() + "$\n");
		}
	}

	@Override
	public void cleanCart(Cart cart, Store store) {
		if (cart.getEntries().size() > 0) {
			for (CartEntry cartEntryItem : cart.getEntries()) {
				for (StoreEntry storeEntryItem : store.getStoreEntries()) {
					if (cartEntryItem.getProduct().getProductCode()
							.equals(storeEntryItem.getProduct().getProductCode())) {
						storeEntryItem.setQuantityForProduct(storeEntryItem.getQuantityForProduct() + 
								cartEntryItem.getQuantityOfProduct());
						break;
					}
				}
			}
			cart.getEntries().clear();
			cart.setAmount(0);
			cart.setTotalPrice(0);
			logger.debug("Carrello svuotato\n");
		} else
			logger.debug("Il carrello è già vuoto\n");
	}

	@Override
	public void removeProductFromCart(Cart cart, Store store) {
		String chooseProduct;
		String preProductAmount;
		float oneItemPrice = 0;
		boolean chooseCorrectProduct = false;
		boolean correctProductAmount = false;

		if (cart.getEntries().size() != 0) {
			do {
				logger.debug("Inserire il codice prodotto dell'articolo da rimuovere dal carrello.");
				chooseProduct = scan.next();
				for (CartEntry cartEntryItem : cart.getEntries()) {
					if (chooseProduct.equals(cartEntryItem.getProduct().getProductCode())) {
						chooseCorrectProduct = true;
						do {
							try {
								logger.debug("Inserire quantità prodotto da rimuovere dal carrello. (Massimo "
										+ cartEntryItem.getQuantityOfProduct() + ")");
								preProductAmount = scan.next();
								if (Integer.valueOf(preProductAmount) < 0
										|| Integer.valueOf(preProductAmount) > cartEntryItem.getQuantityOfProduct()) {
									logger.debug("Non puoi rimuovere le unità inserite.\n");
								} else {
									oneItemPrice = cartEntryItem.getSubPrice() / cartEntryItem.getQuantityOfProduct();
									logger.debug("Sono state rimosse " + preProductAmount + " unità.");
									cartEntryItem.setQuantityOfProduct(
											cartEntryItem.getQuantityOfProduct() - Integer.valueOf(preProductAmount));
									logger.debug("Unità rimanenti del prodotto: " + cartEntryItem.getQuantityOfProduct()
										+ "\n");
									cartEntryItem.setSubPrice(oneItemPrice * cartEntryItem.getQuantityOfProduct());
									if (cartEntryItem.getQuantityOfProduct() == 0) {
										cart.getEntries().remove(cartEntryItem);
										cart.setAmount(cart.getAmount() - Integer.valueOf(preProductAmount));
										cart.setTotalPrice(cart.getTotalPrice() - 
												(oneItemPrice * Integer.valueOf(preProductAmount)));
										logger.debug("Prodotto rimosso dal carrello\n");
									}
									for (StoreEntry storeEntryItem : store.getStoreEntries()) {
										if (storeEntryItem.getProduct().getProductCode().equals(chooseProduct)) {
											storeEntryItem.setQuantityForProduct(storeEntryItem.getQuantityForProduct()
													+ Integer.valueOf(preProductAmount));
										}
									}
									correctProductAmount = true;
								}
							} catch (Exception e) {
								logger.error("Quantità inserita non corretta.\n");
							}
						} while (correctProductAmount == false);
					}
				}
				calculateCartPrice(cart);
			} while (chooseCorrectProduct == false);
		} else
			logger.debug("Non ci sono prodotti nel carrello. Inserirne almeno uno.\n");
	}

	@Override
	public void calculateCartPrice(Cart cart) {
		int productInTheCart = 0;
		float subTotalPrice = 0;

		for (CartEntry cartEntryItem : cart.getEntries()) {
			productInTheCart += cartEntryItem.getQuantityOfProduct();
			subTotalPrice += cartEntryItem.getSubPrice();
		}
		cart.setAmount(productInTheCart);
		cart.setTotalPrice(subTotalPrice);
//		db.dbCartPrice(cart);
	}

}
