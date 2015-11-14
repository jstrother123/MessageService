package edu.softeng.messageservice.messages.product;

import edu.softeng.messageservice.messages.Message;
import edu.softeng.messageservice.messages.dto.Product;

public class ProductSaved extends Message {
	private Product product;
	public Product getProduct() {
		return this.product;
	}
	public ProductSaved setProduct(Product product) {
		this.product = product;
		return this;
	}
	
	public ProductSaved() {
		this.product = new Product();
	}
}
