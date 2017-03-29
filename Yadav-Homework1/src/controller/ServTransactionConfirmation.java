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

import model.Banking;
import model.OrderItems;
import model.Orders;
import model.Products;
import model.Transactions;
import model.Users;

/**
 * Servlet implementation class ServTransactionConfirmation
 */
@WebServlet("/ServTransactionConfirmation")
public class ServTransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServTransactionConfirmation() {
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

		String type = request.getParameter("card-type");
		String name = request.getParameter("name");
		String cardNo = request.getParameter("card");
		String cvv = request.getParameter("cvv");
		String expDate = request.getParameter("expDate");

		String billAdd = request.getParameter("Billing");
		String shpAdd = request.getParameter("Shipping");

		HttpSession session = request.getSession();
		Users usr = (Users) session.getAttribute("user");
		double total = (double) session.getAttribute("SumCart");

		
		Transactions tr = new Transactions();
		tr = tr.getTransaction(usr);
		Banking bk=new Banking();

		boolean val = tr.checkTransaction(name, type, cardNo, cvv, expDate,
				total);
		if (val) {

			Orders ord = new Orders(tr.getUsrId(), total,
					shpAdd, billAdd, cardNo);
			bk.updateBalance(cardNo, total, "order");
			
			ord.insertOrder();
			session.setAttribute("order", ord);

			ArrayList<Products> crt = (ArrayList<Products>) session.getAttribute("Cart");
			ArrayList<OrderItems> aItems = new ArrayList<OrderItems>();
			Products pd =new Products();

			for (int i = 0; i < crt.size(); i++) {
				OrderItems itm = new OrderItems(ord.getId(),
						Integer.valueOf(crt.get(i).getSeller_id()),
						Integer.valueOf(crt.get(i).getId()), Double.valueOf(crt
								.get(i).getPrice()), Integer.valueOf(crt.get(i)
								.getReqQuantity()), 1, 1, 1);
				
				System.out.println("id "+crt.get(i).getId());
				System.out.println("quantity "+crt.get(i).getReqQuantity());
				
				pd.updateQnty(Integer.parseInt(crt.get(i).getId()), Integer.parseInt(crt.get(i).getReqQuantity()),"order");


				itm.insertItems();
				itm.selectSellerName();
				itm.selectItemName();
				aItems.add(itm);
				
			}

			session.setAttribute("Items", aItems);

			session.removeAttribute("Cart");

		}

		session.setAttribute("Trans", tr);
		System.out.println("message " + tr.getMessage());

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("CustTransactionConfirmation.jsp");
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
