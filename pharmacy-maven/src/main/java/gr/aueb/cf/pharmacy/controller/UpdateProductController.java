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

@WebServlet("/update")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IProductDAO productDAO = new ProductDAOImpl();
	IProductService productServ = new ProductServiceImpl(productDAO);
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		ProductDTO oldProductDTO = new ProductDTO();
		oldProductDTO.setId(id);
		
		ProductDTO newProductDTO = new ProductDTO();
		newProductDTO.setName(name);
		newProductDTO.setDescription(description);
		newProductDTO.setQuantity(quantity);
		
		
		try {
			productServ.updateProduct(oldProductDTO, newProductDTO);
			request.setAttribute("product", newProductDTO);
			request.getRequestDispatcher("/jsps/productupdated.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
