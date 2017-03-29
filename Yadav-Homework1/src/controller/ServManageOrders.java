package controller;

import java.io.IOException;
import java.sql.SQLException;
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
import model.Users;

/**
 * Servlet implementation class ServManageOrders
 */
@WebServlet("/ServManageOrders")
public class ServManageOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServManageOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ordId = request.getParameter("OrderId");
		String ordIndex = request.getParameter("OrderIndex");
		System.out.println("index "+ordIndex);
		
		request.setAttribute("SelOrder", ordId);
		HttpSession session = request.getSession();	
		ArrayList<OrderItems> items=(ArrayList<OrderItems>) session.getAttribute("Items");
		
		OrderItems it=new OrderItems();
		
		try {
			items =it.getOrderItems(ordId);
			session.setAttribute("Items", items);
			
			ArrayList<Orders> ord=(ArrayList<Orders>) session.getAttribute("Orders");
			Orders order=ord.get(Integer.valueOf(ordIndex)-1);
			
			session.setAttribute("Ord", order);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher ("CustManageOrder.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
