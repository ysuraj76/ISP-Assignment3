package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Products {

	int id;
	String name;
	String type;
	String path;
	String description;
	int shipDate;
	int quantity;
	double price;
	int seller_id;
	String sellName;
	int totalPurchase;
	double totalAmount;
	int delDate;
	String revDate;
	double rating;
	String review=new String("");
	int reqQuantity;
	ArrayList<String> qa=new ArrayList<>();

	public Products(String Id, String name, String type, String sel_name,
			String price, String path, String qnty, String del_date,
			String desc) {
		this.id = Integer.parseInt(Id);
		this.name = name;
		this.type = type;
		this.path = path;
		this.sellName = sel_name;
		this.delDate = Integer.parseInt(nullPossible(del_date));
		this.quantity = Integer.parseInt(nullPossible(qnty));
		this.price = Double.parseDouble(nullPossible(price));
		this.description = desc;
		
	}

	private String nullPossible(String val) {
		if (val == null)
			return String.valueOf(0);

		return val;
	}

	public String getRevDate() {
		return this.revDate;
	}

	public String getReqQuantity() {
		return String.valueOf(this.reqQuantity);
	}

	public void calculateTotalAmount() {
		this.totalAmount = this.reqQuantity * this.price;
	}

	public void setReqQnty(String val) {
		this.reqQuantity = Integer.parseInt(val);
	}

	public String getReview() {
		return this.review;
	}

	public String getRating() {
		return String.valueOf(this.rating);
	}

	public String getShipDate() {
		return String.valueOf(this.shipDate);
	}

	public String getId() {
		return String.valueOf(id);
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
	

	public ArrayList<String> getQa() {
		return qa;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public String getPath() {
		return path;
	}

	public String getDescription() {
		return description;
	}

	public String getSellName() {
		return sellName;
	}

	public int getTotalPurchase() {
		return totalPurchase;
	}

	public String getTotalAmount() {
		return String.valueOf(totalAmount);
	}

	public String getPrice() {
		return String.valueOf(price);
	}

	public int getQuantity() {
		return quantity;
	}

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public int getType(String val) {

		if (val.equals("Home"))
			return 0;

		if (val.equals("Mens"))
			return 1;

		if (val.equals("Womens"))
			return 2;

		if (val.equals("Child"))
			return 3;

		return -1;
	}

	public int getPid() {

		return id;
	}

	
	public ArrayList<Products> searchResults(String prd, String val)
			throws SQLException {

		System.out.println("In serach method");
		Database db = new Database();
		ArrayList<Products> items = new ArrayList<Products>();

		String query = "Select pd.Id, pd.ProductName, cat.ProductCategory,us.Username, pd.Price, pd.ProductPhotosLinks"
				+ " From Products pd join ProductCategories cat join Users us"
				+ " on pd.ProducCategoryIndex=cat.Id and pd.SellerId=us.Id"
				+ " where pd.ProductName LIKE '%" + val + "%';";


		System.out.println(query);

		ResultSet rs = db.select(query);

		while (rs.next()) {

			System.out.println(" rs " + rs.getString(1));
			items.add(new Products(rs.getString(1), rs.getString(2), rs
					.getString(3), rs.getString(4), rs.getString(5), rs
					.getString(6), null, null, null));

		}

		db.closeConnection();
		return items;
	}

	public Products productDetails(String id) throws SQLException {

		System.out.println("In Prd Details method");
		Database db = new Database();

		String query = "Select pd.ProductName, pd.Price, us.Username,pd.AvailableQuantity, "
				+ "pd.EstimatedDeliveryDays, pd.ProductPhotosLinks"
				+ ", pd.ProductDescription, pd.Id, pd.SellerId"
				+ " From Products pd join Users us"
				+ " on pd.SellerId=us.Id"
				+ " where pd.Id =" + Integer.parseInt(id) + ";";

		System.out.println(query);

		ResultSet rs = db.select(query);

		rs.next();

		System.out.println(" rs " + rs.getString(1));
		Products pd = new Products(id, rs.getString(1), null, rs.getString(3),
				rs.getString(2), rs.getString(6), rs.getString(4),
				rs.getString(5), rs.getString(7));
		
		pd.seller_id=rs.getInt(9);
		pd.id=rs.getInt(8);

		db.closeConnection();
		
		return pd;
	}
	
	public void getQA(){
		Database db = new Database();

		String query = " Select p.Question, p.Answer"
				+ " From  ProductQA p "
				+ " where p.ProductId =" + this.getId() + ";";

		System.out.println(query);

		ResultSet rs;
		try {
			rs = db.select(query);
			
			
			String rev=new String("");
			
			while (rs.next()) {
			
			this.qa.add(rs.getString(1));
			this.qa.add(rs.getString(2));
			
			
			}
			db.closeConnection();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}
	
	public void getReviewDb(String i) {
		Database db = new Database();

		String query = " Select cus.Review, cus.Rating"
				+ " From  CustomerReviews cus "
				+ " where cus.ProductId =" + i + ";";

		System.out.println(query);

		ResultSet rs;
		try {
			rs = db.select(query);
			double rate=0;
			
			String rev=new String("");
			int id=0;
			while (rs.next()) {
			
			rev+=rs.getString(1)+";";
			
			rate+=rs.getInt(2);
			id++;
			}
			db.closeConnection();
			
			this.setReview(rev);
			this.setRating(rate/id);
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void addReviewDb( String cusId,String rating,String review){
		Database db = new Database();
		String query = "Insert into CustomerReviews (ProductId, CustomerId, Rating, Review) values (?,?,?,?)";

		String[] param = { this.getId(), cusId, rating, review  };
		System.out.println("id "+this.getId());

		db.insert(query, param);

		
	}
	
	public void addQuestionDb( String cusId,String ques){
		Database db = new Database();
		String query = "Insert into ProductQA (ProductId, CustomerId, Question) values (?,?,?)";

		String[] param = { this.getId(), cusId, ques};

		db.insert(query, param);

		
	}
	private void setRating(double d) {
		// TODO Auto-generated method stub
		this.rating=d;
	}

	private void setReview(String rev) {
		// TODO Auto-generated method stub
		this.review+=rev;
	}

	public void updateQnty(int id, int qty, String operation) {

		Database db = new Database();

		String query = "Select AvailableQuantity from Products where Id ="
				+ id + ";";

		System.out.println(query);

		ResultSet rs;
		try {
			rs = db.select(query);

			rs.next();

			int qnty = rs.getInt(1);
			
			System.out.println("quantity "+qty);
			
			if(operation.equals("return"))
			qnty=qnty+qty;
			
			if(operation.equals("order"))
			qnty=qnty-qty;
			
			System.out.println("quantity "+qnty);


			query = "UPDATE Products SET AvailableQuantity=? WHERE"
					+ " Id =?;";

			String[] param = { String.valueOf(qnty), String.valueOf(id) };

			db.insert(query, param);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
