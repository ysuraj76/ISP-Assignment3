package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Products;
import model.Users;

/**
 * Servlet implementation class ServProdSearchResults
 */
@WebServlet("/ServProdSearchResults")
public class ServProdSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServProdSearchResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Id= request.getParameter("ProdId");
		
		Products pd=new Products();
		try {
			Products prdts=pd.productDetails(Id);
			prdts.getReviewDb(Id);
			prdts.getQA();
			
			
			
			System.out.println("rating "+prdts.getRating());
			System.out.println("reviews "+prdts.getReview());
			
			HttpSession session = request.getSession();
			session.setAttribute("Prdts", prdts);
			
			session.setAttribute("QA", prdts.getQa());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher ("CustViewProductDetails.jsp");
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
