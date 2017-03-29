package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Orders {
	int id;
	int cus_id;
	double totCost;
	String ordDate;
	String shpAdd;
	String billAdd;
	String cardNo;

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(int cusid, double cost, String shAdd, String billAdd,
			String card) {
		this.cus_id = cusid;
		this.totCost = cost;

		this.shpAdd = shAdd;
		this.billAdd = billAdd;
		this.cardNo = card;

		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Date dateobj = new Date();
		this.ordDate = String.valueOf(df.format(dateobj));

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public double getTotCost() {
		return totCost;
	}

	public void setTotCost(double totCost) {
		this.totCost = totCost;
	}

	public String getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}

	public String getShpAdd() {
		return shpAdd;
	}

	public void setShpAdd(String shpAdd) {
		this.shpAdd = shpAdd;
	}

	public String getBillAdd() {
		return billAdd;
	}

	public void setBillAdd(String billAdd) {
		this.billAdd = billAdd;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public void insertOrder() {

		System.out.println("in insert method of products");

		// this.seller_id =1;
		Database db = new Database();

		String query = "select MAX(Id) from Orders ;";

		try {
			ResultSet rs = db.select(query);
			rs.next();

			this.setId(Integer.parseInt(rs.getString(1)) + 1);

			db.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		query = "INSERT INTO Orders VALUES (?,?,?,?,?,?,?);";

		String[] param = { String.valueOf(this.id),
				String.valueOf(this.cus_id), String.valueOf(this.totCost),this.ordDate,
				this.shpAdd, this.billAdd, this.cardNo };

		db.insert(query, param);

	}
	
	public ArrayList<Orders> getOrders(Users us)
			throws SQLException {

		System.out.println("In serach method");
		Database db = new Database();
		ArrayList<Orders> ord = new ArrayList<Orders>();

		String query = "Select * from Orders where CustomerId ="
				+ us.getId()+ ";";

		System.out.println(query);

		ResultSet rs = db.select(query);

		while (rs.next()) {

			System.out.println(" rs " + rs.getString(1));
		
			Orders od=new Orders();
			od.setId(rs.getInt(1));
			od.setCus_id(rs.getInt(2));
			od.setTotCost(rs.getDouble(3));
			od.setOrdDate(rs.getString(4));
			od.setShpAdd(rs.getString(5));
			od.setCardNo(rs.getString(7));
			
			ord.add(od);
		}

		db.closeConnection();
		return ord;
	}

}
