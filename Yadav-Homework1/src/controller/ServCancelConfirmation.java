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

import model.OrderItems;
import model.Orders;
import model.Products;

/**
 * Servlet implementation class ServCancelConfirmation
 */
@WebServlet("/ServCancelConfirmation")
public class ServCancelConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServCancelConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		 HttpSession session = request.getSession();	
	      int val=  (int) session.getAttribute("Index");
	      
	      ArrayList<OrderItems> items =(ArrayList<OrderItems>) session.getAttribute("Items");
	      Orders or= (Orders) session.getAttribute("Ord");
	      
	      items.get(val).UpdateShippingStatus();
	      Products pd=new Products();
	      pd.updateQnty(items.get(val).getPrd_id(), items.get(val).getQnt(),"return");
	      
	  //    Banking bk =new Banking();
	   //   bk.updateBalance(or.getCardNo(), items.get(val).getPrd_price()*items.get(val).getQnt(),"return");
	      
	      Double tot=items.get(val).getPrd_price()*items.get(val).getQnt();
	      request.setAttribute("total", tot);
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher("CustCancellationConfirmation.jsp");
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
