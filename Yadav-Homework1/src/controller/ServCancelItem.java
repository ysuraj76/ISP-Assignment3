package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderItems;
import model.Products;

/**
 * Servlet implementation class ServCancelItem
 */
@WebServlet("/ServCancelItem")
public class ServCancelItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServCancelItem() {
        super();
        // TODO Auto-generated constructor stubi
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String id= request.getParameter("index");
        
        
        HttpSession session = request.getSession();	
        session.setAttribute("Index", Integer.parseInt(id)-1);
        
        ArrayList<Products> cart =(ArrayList<Products>) session.getAttribute("Cart");
        double total = (double) session.getAttribute("SumCart");
        
        total=total-Double.parseDouble(cart.get(Integer.parseInt(id)-1).getTotalAmount());
        cart.remove(Integer.parseInt(id)-1);
        
        session.setAttribute("SumCart", total);
        session.setAttribute("Cart", cart);
//    	RequestDispatcher dispatcher = request.getRequestDispatcher("CustCancelOrder.jsp");
//		dispatcher.forward(request, response);
		
		PrintWriter out = response.getWriter(); 
		out.println(1);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
