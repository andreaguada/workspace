package cart;

//import database.DatabaseMethods;
import store.Store;

public interface CartMethods {

	public void addProductsToCart(Cart cart, Store store);

	public void showCartPrice(Cart cart);

	public void cleanCart(Cart cart, Store store);

	public void removeProductFromCart(Cart cart, Store store);

	public void calculateCartPrice(Cart cart);

}
