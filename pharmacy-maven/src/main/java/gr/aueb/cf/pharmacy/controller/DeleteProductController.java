package gr.aueb.cf.pharmacy.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.pharmacy.dao.IProductDAO;
import gr.aueb.cf.pharmacy.dao.ProductDAOImpl;
import gr.aueb.cf.pharmacy.dto.ProductDTO;
import gr.aueb.cf.pharmacy.service.IProductService;
import gr.aueb.cf.pharmacy.service.ProductServiceImpl;

@WebServlet("/delete")
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IProductDAO productDAO = new ProductDAOImpl();
	IProductService productServ = new ProductServiceImpl(productDAO);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		// Get the data
		int id = Integer.parseInt(request.getParameter("id").trim());
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int quantity = Integer.parseInt(request.getParameter("quantity").trim());
		
		// Construct DTO
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(id);
		productDTO.setName(name);
		productDTO.setDescription(description);
		productDTO.setQuantity(quantity);
		
		// Call the service
		try {
			productServ.deleteProduct(productDTO);
			request.setAttribute("product", productDTO);
			request.getRequestDispatcher("/jsps/productdeleted.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/products.jsp").forward(request, response);	
		}	
	}
}
