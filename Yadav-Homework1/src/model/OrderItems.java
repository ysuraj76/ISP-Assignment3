package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class OrderItems {
	private int item_id;
	private int prd_id;
	private String name;
	private String seller_name;
	private String shipping;

	private int ord_id;
	private int seller_id;
	private double prd_price;
	private int qnt;
	private int ship_sta;
	private int ship_ref;
	private int status;
	private Date ord_date;

	public OrderItems(int sell_id, int order_id, Date date, int status) {
		// TODO Auto-generated constructor stub
		this.seller_id = sell_id;
		this.ord_id = order_id;
		this.ord_date = date;
		this.ship_sta = status;
	}

	public OrderItems(int ord_id, int seller_id, int prd_id, double prd_price,
			int qnt, int ship_sta, int ship_ref, int status) {
		super();
		this.prd_id = prd_id;
		this.seller_id = seller_id;
		this.ord_id = ord_id;
		this.prd_price = prd_price;
		this.qnt = qnt;
		this.ship_sta = ship_sta;
		this.ship_ref = ship_ref;
		this.status = status;
	}
	
	public void setShipping(int val){
		
		switch(val) {
		   case 1 :
		      this.shipping="Dispatched";
		      break; // optional
		   
		   case 2 :
			      this.shipping="In Transit";
		      break; // optional
		      
		   case 3 :
			      this.shipping="Cancelled";
		      break; // optional
		   
		   // You can have any number of case statements.
		   default : // Optional
			      this.shipping="Shipped";
		}
	}
	
		public String getShipping(){
			return this.shipping;
		}
		
	

	public OrderItems() {
		// TODO Auto-generated constructor stub
	}
	public void setOrdId(int val) {
		this.ord_id = val;
	}

	public void setOrdDate(Date val) {
		this.ord_date = val;
	}

	public void shipStatus(int val) {
		this.ship_sta = val;
	}
	
	
	public int getPrd_id() {
		return prd_id;
	}

	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public double getPrd_price() {
		return prd_price;
	}

	public void setPrd_price(double prd_price) {
		this.prd_price = prd_price;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
	
	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getShip_sta() {
		return ship_sta;
	}

	public void setShip_sta(int ship_sta) {
		this.ship_sta = ship_sta;
	}

	public ArrayList<OrderItems> getSellerItems(Users usr) throws SQLException {
		ArrayList<OrderItems> items = new ArrayList<OrderItems>();

		Database db = new Database();

		String query = "Select it.OrderId, od.OrderDate,it.ShipingStatus from orderitems it, orders od "
				+ "join on it.OrderId = od.Id where it.SellerId="
				+ usr.getId()
				+ ";";

		ResultSet rs = db.select(query);

		// Iterate through the data in the result set and display it.

		while (rs.next()) {

			int id = rs.getInt(1);
			Date date = rs.getDate(2);
			int status = rs.getInt(3);

			items.add(new OrderItems(usr.getId(), id, date, status));

		}

		return items;

	}

	public void insertItems() {

		// this.seller_id =1;
		Database db = new Database();

		String query = "insert into OrderItems(OrderId, SellerId, ProductId, ProductPrice, Quantity, ShippingStatus, ShippingRefNo, Status)"
				+ " values  (?,?,?,?,?,?,?,?);";

		String[] param = { String.valueOf(this.ord_id),
				String.valueOf(this.seller_id), String.valueOf(this.prd_id), String.valueOf(this.prd_price),String.valueOf(this.qnt),
				String.valueOf(this.ship_sta),String.valueOf(this.ship_ref),String.valueOf(this.status), };

		db.insert(query, param);

	}
	
	public void selectSellerName(){
		Database db = new Database();

		String query = "Select Username from Users where Id="
				+ this.seller_id+";";

		ResultSet rs;
		try {
			rs = db.select(query);
			rs.next();
			this.seller_name=rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Iterate through the data in the result set and display it.

		

	}
	
	public void selectItemName(){
		Database db = new Database();

		String query = "Select ProductName from Products where Id="
				+ this.prd_id+";";

		ResultSet rs;
		try {
			rs = db.select(query);
			rs.next();
			this.name=rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Iterate through the data in the result set and display it.


	}
	
	public ArrayList<OrderItems> getOrderItems(String orId)
			throws SQLException {

		System.out.println("In serach method");
		Database db = new Database();
		ArrayList<OrderItems> itms = new ArrayList<OrderItems>();

		String query = "Select * from OrderItems where OrderId ="
				+ Integer.valueOf(orId)+ ";";

		System.out.println(query);

		ResultSet rs = db.select(query);

		while (rs.next()) {

			System.out.println(" rs " + rs.getString(1));
		
			OrderItems it=new OrderItems();
			it.setItem_id(rs.getInt(1));
			it.setOrdId(rs.getInt(2));
			it.setSeller_id(rs.getInt(3));
			it.setPrd_id(rs.getInt(4));
			it.setPrd_price(rs.getInt(5));
			it.setQnt(rs.getInt(6));
			it.setShip_sta(rs.getInt(7));
			it.setShipping(it.getShip_sta());
			itms.add(it);
		}

		db.closeConnection();
		
		for(int i=0; i<itms.size(); i++){
			itms.get(i).selectItemName();
			itms.get(i).selectSellerName();
		}
		
		return itms;
	}
	
	public void getItemDetails(String orId, String itId){
		Database db = new Database();

		String query = "Select * from OrderItems where OrderId ="
				+ Integer.valueOf(orId)+ ";";

		System.out.println(query);

		ResultSet rs;
		try {
			rs = db.select(query);
			

			rs.next();

		
				this.setItem_id(rs.getInt(1));
				this.setOrdId(rs.getInt(2));
				this.setSeller_id(rs.getInt(3));
				this.setPrd_id(rs.getInt(4));
				this.setPrd_price(rs.getInt(5));
				this.setQnt(rs.getInt(6));
				this.setShip_sta(rs.getInt(7));
			
			db.closeConnection();
			
			
				this.selectItemName();
				this.selectSellerName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
	}
	
	public void UpdateShippingStatus() {

		// this.seller_id =1;
		Database db = new Database();

		String query = "UPDATE OrderItems SET ShippingStatus=3 WHERE"
				+ " id =?;";

		String[] param = {String.valueOf(this.item_id) };

		db.insert(query, param);
		this.setShip_sta(3);

	}
	

}
