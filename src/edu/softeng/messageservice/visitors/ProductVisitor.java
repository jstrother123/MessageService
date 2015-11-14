package edu.softeng.messageservice.visitors;

import edu.softeng.messageservice.messages.dto.Product;
import edu.softeng.messageservice.messages.product.ProductRemoved;
import edu.softeng.messageservice.messages.product.ProductSaved;

public class ProductVisitor extends Visitor {
	public void Visit(ProductSaved productSaved) {
		Product product = productSaved.getProduct();

		System.out.printf("Saving product with lookupcode %s", product.getLookupCode());
		System.out.println();
	}

	public void Visit(ProductRemoved productRemoved) {
		System.out.printf("Removing product with ID %s", productRemoved.getId().toString());
		System.out.println();
	}
	
	@Override
	public ProductVisitor createOne() {
		return new ProductVisitor();
	}
	
	static {
		VisitorFactory.register(VisitorType.PRODUCT, new ProductVisitor());
	}
}
