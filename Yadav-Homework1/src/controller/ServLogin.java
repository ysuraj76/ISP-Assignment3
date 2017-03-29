package controller;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;

import com.sun.xml.internal.fastinfoset.sax.Properties;

/**
 * Servlet implementation class ServLogin
 */
@WebServlet("/ServLogin")
public class ServLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		
	
		
		if(request.getParameter("storePass") != null) {
			Cookie uName = new Cookie("uName", userName);
			uName.setMaxAge(30);
			response.addCookie(uName);
			
			
			Cookie pwd = new Cookie("pwd", password);
			pwd.setMaxAge(30);
			response.addCookie(pwd);
		}
		
		PrintWriter out= response.getWriter();

		Users user = new Users(userName, password, type);
		
		try {
			Users ret_usr = user.validateUser(user);
			System.out.println("ret_usr "+ret_usr.getId());

			if (ret_usr.getType() == -1)
				response.sendRedirect("Register.jsp");
			
			HttpSession session = request.getSession();
			session.setAttribute("user", ret_usr);
			session.setMaxInactiveInterval(60);
			
		
			if(ret_usr.getType()==0){
				response.setHeader("refresh", "5; URL=CustHomepage.jsp"); 
				
				String prdt="images/cap.jpg";
				Cookie cookieList[] = request.getCookies();
				if(cookieList != null) {
					for (int i = 0; i < cookieList.length; i++) {
						Cookie c = cookieList[i];
						if(c.getName().equals("AdProduct")) {
							prdt = c.getValue();
						}
						
					}
				}
				
					
				response.setContentType("text/html");
				    
			    String docType =
			    	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			    	      "Transitional//EN\">\n";
			    	    String title = "Discounts";
			    	    out.println
			    	      (docType +
			    	       "<HTML>\n" +
			    	       "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
			    	       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
			    	       "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n");
			    	    out.println("<h1>Welcome Huge discount on the below product</h1>"+
			    	    			"<h2>Upto 50% OFF</h2>"+
			    	    			"<img src="+prdt+" alt=\"seller\" style=\"width:600px;height:400px;\"><br>"
			    	    		);
			    	    out.println("</BODY></HTML>");
			    
			    
			    
			    out.close();
			}
			
			if(ret_usr.getType()==1)
				response.sendRedirect("SellerHomepage.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
