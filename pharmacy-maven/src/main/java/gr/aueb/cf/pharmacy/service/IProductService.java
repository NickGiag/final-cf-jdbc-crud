package gr.aueb.cf.pharmacy.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.pharmacy.dto.ProductDTO;
import gr.aueb.cf.pharmacy.model.Product;
import gr.aueb.cf.pharmacy.service.exceptions.ProductIdAlreadyExistsException;


public interface IProductService {
	
	/**
	 * Inserts a {@link Product} based on the data carried by the {@link ProductDTO}.
	 * 
	 * @param productDTO
	 * 			DTO object that contains the data
	 * 
	 * @throws ProductIdAlreadyExistsException
	 * 			if any product, identified by their id, needed to be inserted
	 * 			has already been inserted 
	 * @throws SQLException
	 * 			if any error happens during SQL insert 
	 */
	void insertProduct(ProductDTO productDTO) 
			throws SQLException;
	
	
	
	/**
	 * Removes a {@link Product} based on the data carried by the {@link ProductDTO}.
	 *  
	 * @param productDTO
	 * 			DTO object that contains the data (mainly the id)
	 * 
	 * @throws SQLException
	 * 			if any error happens during SQL delete 
	 */
	void deleteProduct(ProductDTO productDTO) 
			throws SQLException;

	
	
	/**
	 * Updates a {@link Product} based on the data carried by the {@link ProductDTO}.
	 * 
	 * @param oldProductDTO
	 * 			DTO object hat contains the data -mainly the id- of the product
	 * 			that will be updated.
	 * @param newProductDTO
	 * 			updateProduct
	 * 
	 * @throws SQLException
	 * 			if any error happens during SQL update 
	 */			
	void updateProduct(ProductDTO oldProductDTO, ProductDTO newProductDTO) 
			throws SQLException;  
	
	
	/**
	 * Gets back to the caller a list of the {@link Product} objects identified
	 * by their name or name's initial characters
	 * 
	 * @param name
	 * 			a string object that contains the name or the initial letters
	 * 			that name starts with. 
	 * @return
	 * 			a list that contains the results of the search, or null if no
	 * 			results are found
	 * @throws SQLException
	 * 			if any error happens during SQL search 
	 */
	List<Product> getProductsByName(String name) throws SQLException;
	
}
