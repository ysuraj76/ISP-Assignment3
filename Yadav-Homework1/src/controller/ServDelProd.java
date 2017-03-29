package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Products;

/**
 * Servlet implementation class ServDelProd
 */
@WebServlet("/ServDelProd")
public class ServDelProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServDelProd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String del=request.getParameter("DelProdId");
		System.out.println(" delte "+del);
		
		HttpSession session = request.getSession();
		ArrayList<Products> cart =(ArrayList<Products>) session.getAttribute("Cart");
		
		double sum=(double) session.getAttribute("SumCart");
		sum=sum-Double.valueOf(cart.get(Integer.parseInt(del)-1).getTotalAmount());

		
		session.setAttribute("SumCart", sum);
		cart.remove(Integer.parseInt(del)-1);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustCheckoutCart.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
