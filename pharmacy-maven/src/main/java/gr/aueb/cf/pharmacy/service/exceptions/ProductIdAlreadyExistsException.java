package gr.aueb.cf.pharmacy.service.exceptions;

import gr.aueb.cf.pharmacy.model.Product;

public class ProductIdAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ProductIdAlreadyExistsException(Product product) {
		super("Product with id = " + product.getId() + " already exists");
	}
}

