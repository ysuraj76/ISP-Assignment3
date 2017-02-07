package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Products;

/**
 * Servlet implementation class ServProducts
 */
@WebServlet("/ServProducts")
public class ServProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pid;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServProducts() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
		pid = 0;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String type=request.getParameter("product");
		String path=request.getParameter("path");
		String description=request.getParameter("description");
		String shipping=request.getParameter("shipping");
		String items=request.getParameter("items");
		String price=request.getParameter("price");

		Products prd=new Products(pid++,name,type,path,description,shipping,items,price);
		
		PrintWriter out= response.getWriter();
		out.println("Total products in the Webite"+prd.getPid());
		
        out.println("Last Modified = " + getLastModified(request));

		
		response.setHeader("Refresh", "2; URL=SellerManageProducts.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void destroy() {
	    saveState();
	  }
	
	public void saveState() {
	    // Try to save the accumulated count
	    try {
	      FileWriter fileWriter = new FileWriter("InitDestroyCounter.initial");
	      String initial = Integer.toString(pid);
	      fileWriter.write(initial, 0, initial.length());
	      fileWriter.close();
	      return;
	    }
	    catch (IOException e) {  // problem during write
	      // Log the exception. See Chapter 5, "Sending HTML Information".
	    }
	}
}
