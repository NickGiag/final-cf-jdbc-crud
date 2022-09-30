package gr.aueb.cf.pharmacy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.cf.pharmacy.model.Product;


import static gr.aueb.cf.pharmacy.dao.dbutil.DBUtil.openConnection;
import static gr.aueb.cf.pharmacy.dao.dbutil.DBUtil.closeConnection;

public class ProductDAOImpl implements IProductDAO {

	@Override
	public void insert(Product product) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			String sql = "INSERT INTO PRODUCTS (NAME, DESCRIPTION, QUANTITY) VALUES (?, ?, ?)";
			pst = openConnection().prepareStatement(sql);
			pst.setString(1,  product.getName());
			pst.setString(2,  product.getDescription());
			pst.setInt(3,  product.getQuantity());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}	
	}

	@Override
	public void delete(Product product) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			String sql = "DELETE FROM PRODUCTS WHERE ID =  ?";
			pst = openConnection().prepareStatement(sql);
			pst.setInt(1,  product.getId());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

	@Override
	public void update(Product oldProduct, Product newProduct) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			String sql = "UPDATE PRODUCTS SET NAME = '" + newProduct.getName() + "', " + "Description = '" 
					+ newProduct.getDescription() +"', " + "Quantity = '" + newProduct.getQuantity() + "' WHERE ID = " + oldProduct.getId();
			pst = openConnection().prepareStatement(sql);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

	@Override
	public List<Product> getProductsByName(String name) throws SQLException {
		PreparedStatement pst = null;
		List<Product> products = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT ID, NAME, DESCRIPTION, QUANTITY FROM PRODUCTS WHERE NAME LIKE '" + name + "%'";
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("ID"));
				product.setName(rs.getString("NAME"));
				product.setDescription(rs.getString("DESCRIPTION"));
				product.setQuantity(rs.getInt("QUANTITY"));
				
				products.add(product);
			}
			
			//if (teachers.size() > 0)  return teachers; else return null;
			return (products.size() > 0) ? products : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
		
	}

	@Override
	public Product getProductById(int id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Product product = null;
		
		try {
			
			String sql = "SELECT * FROM PRODUCTS WHERE ID = " + id;
			
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			if (rs.next()) {
				product = new Product();
				product.setId(rs.getInt("ID"));
				product.setName(rs.getString("NAME"));
				product.setDescription(rs.getString("DESCRIPTION"));
				product.setQuantity(rs.getInt("QUANTITY"));
			}
		
			return product;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

}
