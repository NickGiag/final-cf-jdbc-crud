package gr.aueb.cf.pharmacy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		// get data
		String email = request.getParameter("eMail");
		String password = request.getParameter("password");
		
		// construct dto
		
		
		// call service
		if ((email.equals("user@gmail.com")) && (password.equals("user"))) {
			//return response
			request.getRequestDispatcher("jsps/productsmenu.jsp").forward(request, response);
		} else {
			//return response
			request.setAttribute("error", true);
			request.getRequestDispatcher("jsps/login.jsp").forward(request, response);
		}
		
		// return response
	}

}
