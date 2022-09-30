package gr.aueb.cf.pharmacy.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.pharmacy.dao.IProductDAO;
import gr.aueb.cf.pharmacy.dto.ProductDTO;
import gr.aueb.cf.pharmacy.model.Product;

public class ProductServiceImpl implements IProductService {
	
	private final IProductDAO productDAO;
	
	public ProductServiceImpl(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public void insertProduct(ProductDTO productDTO) throws SQLException {
		
		// Extract dto 
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setQuantity(productDTO.getQuantity());
		
		try {
			productDAO.insert(product); 
		} catch (SQLException e) {
			throw e;
		}
		
	}

	@Override
	public void deleteProduct(ProductDTO productDTO) 
			throws  SQLException { 	
		Product productToDelete = new Product();
		productToDelete.setId(productDTO.getId());

		try {
			productDAO.delete(productToDelete);
		} catch (SQLException e) { 
			// Log the exception
			throw e;
		}
	}

	@Override
	public void updateProduct(ProductDTO oldProductDTO, ProductDTO newProductDTO)
			throws SQLException {  
		
		// extract DTO
		Product teacherToUpdate = new Product();
		teacherToUpdate.setId(oldProductDTO.getId());
		
		Product newTeacher = new Product();
		newTeacher.setName(newProductDTO.getName());
		newTeacher.setDescription(newProductDTO.getDescription());
		newTeacher.setQuantity(newProductDTO.getQuantity());
		
		// Forward to DAO
		try {
			productDAO.update(teacherToUpdate, newTeacher);
		} catch (SQLException e) { 
			throw e;
		}
	}

	@Override
	public List<Product> getProductsByName(String name) throws SQLException {
		try {
			return productDAO.getProductsByName(name);
		} catch (SQLException e) {
			throw e;
		}
	}

}