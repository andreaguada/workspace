package product;

import org.apache.log4j.Logger;

import maps.Category;

public class Product {
	final static Logger logger = Logger.getLogger(Product.class);

	private String name;
	private String productCode;
	private float price;
	private Category category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void displayInfo(){
		logger.debug("Hello " + name);
	}

}
