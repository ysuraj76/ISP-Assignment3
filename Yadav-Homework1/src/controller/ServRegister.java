package controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;

import com.sun.xml.internal.fastinfoset.sax.Properties;

/**
 * Servlet implementation class ServRegister
 */
@WebServlet("/ServRegister")
public class ServRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		

		ServletContext sc = this.getServletContext();
		String propFilePathCust = sc.getRealPath("/WEB-INF/cust.properties");
		String propFilePathSeller = sc.getRealPath("/WEB-INF/seller.properties");
		
	
		Properties p = new Properties();
		
		FileInputStream fis = null;
		
		
		
		// Registration via the Users object
		Users aUser = new Users(userName, password);
		
		//First check whether the user already exists via methods from Users class
		
		// Register the Users object
		if(type.equals("cust"))
			aUser.registerUser(aUser, propFilePathCust);
		else
			aUser.registerUser(aUser, propFilePathSeller);
			
		response.sendRedirect("Login.jsp"); 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
