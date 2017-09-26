package commands;

import cart.Cart;
import store.Store;

public interface Command {
	void action(Cart cart, Store store);
}
