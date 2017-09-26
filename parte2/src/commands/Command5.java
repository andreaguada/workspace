package commands;

import cart.Cart;
import store.Store;
import main.MainMethods;

public class Command5 implements Command {

	public void action(Cart cart, Store store) {
		MainMethods mainMethods = new MainMethods();
		mainMethods.showCartPrice(cart);
	}
}
