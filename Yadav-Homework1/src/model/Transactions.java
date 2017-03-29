package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Transactions {

	String name;
	int usrId;
	String type;
	String cardNo;
	String cvv;
	String expDate;
	double bal;
	boolean sucess;
	String message;
	

	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public Transactions(String name, int usrId, String type, String cardNo,
			String cvv, String expDate, double bal) {
		super();
		this.name = name;
		this.usrId = usrId;
		this.type = type;
		this.cardNo = cardNo;
		this.cvv = cvv;
		this.expDate = expDate;
		this.bal = bal;
	}
	
	public void updateBalance(double val){
		this.bal=this.bal-val;
	}
	
	public boolean checkTransaction(String name, String type, String cardno, String cvv, String exp, double price){
		
		if(this.name.equals(name) && this.type.equals(type) && this.cardNo.equals(cardno)
				&& this.cvv.equals(cvv) && this.expDate.equals(exp)){
			this.sucess=true;
			this.message="correct details";
		}
		else{
			this.sucess=false;
			this.message="Invalid details. Please RE-Enter ......";
			return this.sucess;
		}
		if(this.bal>price){
			this.sucess=true;
			this.message="good balance";
		}else{
			this.sucess=false;
			this.message="Insufficient balance.....";
		
			return this.sucess;
		}
		
		this.message="Successful transaction";
		this.sucess=true;
		return this.sucess;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUsrId() {
		return usrId;
	}

	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCvv() {
		return cvv;
	}
	
	public boolean isSucess() {
		return sucess;
	}

	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	
	public Transactions getTransaction(Users usr) {

		Database db = new Database();
		
		System.out.println("usr id"+usr);
		String query = "select * from CreditCards " + " where UserId ="
				+ usr.getId() + ";";

		System.out.println(query);

		ResultSet rs;
		Transactions tr;
		tr = null;
		try {
			rs = db.select(query);
			rs.next();

			System.out.println(" rs " + rs.getString(1));
			tr = new Transactions(rs.getString(2), Integer.parseInt(rs
					.getString(6)), rs.getString(5), rs.getString(3),
					rs.getString(7), rs.getString(8), Double.parseDouble(rs
							.getString(4)));

			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tr;

	}

}
