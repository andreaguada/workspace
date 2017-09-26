package main;

import java.util.Scanner;
import cart.Cart;
import cart.CartMethods;
import cart.ImplMethodsCart;
import product.ImplMethodsProduct;
import product.Product;
import product.ProductMethods;
import store.Store;
import main.MainMethods;
import maps.Category;
import maps.MenuButtons;
//import database.DatabaseMethods;

import org.apache.log4j.Logger;

public class MainMethods {

	final static Logger logger = Logger.getLogger(MainMethods.class);
	ProductMethods implMethodsProduct = new ImplMethodsProduct();
	CartMethods implMethodsCart = new ImplMethodsCart();
	Cart cart = new Cart();
//	DatabaseMethods db = new DatabaseMethods();
	Scanner scan = new Scanner(System.in);

	private MenuButtons menuButtons;

	public MenuButtons getMenuButtons() {
		return menuButtons;
	}

	public void setMenuButtons(MenuButtons menuButtons) {
		this.menuButtons = menuButtons;
	}

	public void showMenu() {
		logger.debug("1 - Inserire prodotto\n2 - Cercare prodotto\n3 - Visualizzare prodotti disponibili\n4 - Aggiungere"
				+ " prodotti al carrello\n5 - Costo carrello\n6 - Rimuovere prodotto\n7 - Svuotare carrello"
				+ "\n8 - Scorte in magazzino\n9 - Esci\n");
	}

	public void insertProduct(Store store) {
		Product product = new Product();
		try {
			logger.debug("Inserire il codice prodotto.\n");
			implMethodsProduct.insertProductCode(product, store);
			logger.debug("Inserire il nome del prodotto.\n");
			product.setName(scan.next().toString());
			logger.debug("Scegliere la categoria tra le seguenti:\n");
			Category.alphabeticalOrder();
			implMethodsProduct.insertProductCategory(product, store);
			logger.debug("Inserire il prezzo del prodotto.");
			implMethodsProduct.insertProductPrice(product, store);
		} catch (Exception e){
			logger.error("prodotto non inserito.\n");
		}
	}

	public void searchProduct(Store store) {
		implMethodsProduct.searchProduct(store);
	}

	public void showProductList(Store store) {
		implMethodsProduct.showProductList(store);
	}

	public void addProductsToCart(Cart cart, Store store) {
		implMethodsCart.addProductsToCart(cart, store);
	}

	public void showCartPrice(Cart cart) {
		implMethodsCart.showCartPrice(cart);
	}

	public void cleanCart(Cart cart, Store store) {
		implMethodsCart.cleanCart(cart, store);
	}

	public void exit() {
		logger.debug("\nCiao!");
	}

	public void removeProductFromCart(Cart cart, Store store) {
		implMethodsCart.removeProductFromCart(cart, store);
	}

	public void showStock(Store store) {
		implMethodsProduct.showStock(store);
	}

}
