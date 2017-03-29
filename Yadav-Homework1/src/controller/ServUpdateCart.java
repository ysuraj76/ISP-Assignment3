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
 * Servlet implementation class ServUpdateCart
 */
@WebServlet("/ServUpdateCart")
public class ServUpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServUpdateCart() {
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
		String qnty = request.getParameter("qnty");
		

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60);

		Products pd = (Products) session.getAttribute("Prdts");
		pd.setReqQnty(qnty);
		pd.calculateTotalAmount();
		
		ArrayList<Products> cart =(ArrayList<Products>) session.getAttribute("Cart");
		if(cart==null){
			ArrayList<Products> newCart =new ArrayList<Products>();
			newCart.add(pd);
			session.setAttribute("Cart", newCart);
			
		}
		else
		{
			cart.add(pd);
		}
		
		String link;
		cart =(ArrayList<Products>) session.getAttribute("Cart");
		if (Integer.parseInt(qnty) < (pd.getQuantity()+1)) {
			pd.setReqQnty(qnty);
			pd.calculateTotalAmount();
			link = "CustCheckoutCart.jsp";
			
			double SumCart=0;
			for(int i=0; i<cart.size(); i++)
				SumCart+=Double.parseDouble(cart.get(i).getTotalAmount());
			
			
							
			session.setAttribute("SumCart", SumCart);
			
		} else {
			link = "CustViewProductDetails.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(link);
		dispatcher.forward(request, response);

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
