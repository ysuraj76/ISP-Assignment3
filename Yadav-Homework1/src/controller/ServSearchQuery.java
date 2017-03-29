package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Products;

/**
 * Servlet implementation class ServSearchQuery
 */
@WebServlet("/ServSearchQuery")
public class ServSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServSearchQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String val = request.getParameter("searchVal");
		String product = request.getParameter("product");

		Products pd = new Products();
		ArrayList<Products> prds;
		try {
			prds = pd.searchResults(product, val);
			
			
			HttpSession session = request.getSession();
			session.setAttribute("products", prds);
			
			System.out.println("path "+prds.get(0).getPath());
			Cookie prdt = new Cookie("AdProduct", prds.get(0).getPath());
			prdt.setMaxAge(60);
			response.addCookie(prdt);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		response.sendRedirect("CustProductSearchResults.jsp");
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
