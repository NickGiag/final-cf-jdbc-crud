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


@WebServlet("/insert")
public class InsertProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IProductDAO productDAO = new ProductDAOImpl();
	IProductService productServ = new ProductServiceImpl(productDAO);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		
		// get the data
		try {
			String name = request.getParameter("name").trim();
			String description = request.getParameter("description").trim();
			int quantity = Integer.parseInt(request.getParameter("quantity").trim());
		
		
		
			// Construct DTO
			ProductDTO productDTO = new ProductDTO();
			productDTO.setName(name);
			productDTO.setDescription(description);
			productDTO.setQuantity(quantity);
			
		
		
		// call the service and return feedback/ view /data
			productServ.insertProduct(productDTO);
			request.setAttribute("insertedproduct", productDTO);
			request.getRequestDispatcher("/jsps/productinserted.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("emptyFields", true);
			request.getRequestDispatcher("/jsps/productsmenu.jsp").forward(request, response);
		} catch (SQLException e ) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/productsmenu.jsp").forward(request, response);
		} 
	}

}
