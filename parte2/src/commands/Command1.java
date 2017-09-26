package commands;

import cart.Cart;
import store.Store;
import main.MainMethods;
import maps.MappingCategoryValue;

public class Command1 implements Command {
	MappingCategoryValue mappingCategoryValue = new MappingCategoryValue();

	public void action(Cart cart, Store store) {

		MainMethods mainMethods = new MainMethods();
		mainMethods.insertProduct(store);
	}
	
}
