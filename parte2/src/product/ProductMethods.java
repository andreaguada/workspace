package product;

import store.Store;

public interface ProductMethods {

	public void insertProductCode(Product product, Store store);

	public void insertProductCategory(Product product, Store store);

	public void insertProductPrice(Product product, Store store) throws Exception;

	public void searchProduct(Store store);

	public void showProductList(Store store);

	public void showStock(Store store);

}
