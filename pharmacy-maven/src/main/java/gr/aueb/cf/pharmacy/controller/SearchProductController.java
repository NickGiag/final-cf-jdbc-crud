package gr.aueb.cf.pharmacy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.pharmacy.dao.IProductDAO;
import gr.aueb.cf.pharmacy.dao.ProductDAOImpl;
import gr.aueb.cf.pharmacy.dto.ProductDTO;
import gr.aueb.cf.pharmacy.model.Product;
import gr.aueb.cf.pharmacy.service.IProductService;
import gr.aueb.cf.pharmacy.service.ProductServiceImpl;


@WebServlet("/search")
public class SearchProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IProductDAO productDAO = new ProductDAOImpl();
	IProductService productServ = new ProductServiceImpl(productDAO);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		
		// Construct DTO
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName(name);
		
		try {
			List<Product> products = productServ.getProductsByName(name);
			if (products != null) {
				request.setAttribute("products", products);
				request.getRequestDispatcher("/jsps/products.jsp").forward(request, response);
			} else {
				request.setAttribute("productsNotFound", true);
				request.getRequestDispatcher("/jsps/productsmenu.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
