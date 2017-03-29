package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class Users {
	private int id;
	private String fname;
	private String lname;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String phone;
	private String bday;
	private int type;
	private int status;
	private int visit;
	private String userName;
	private String password;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public int getType() {
		return this.type;
	}
	
	public void setType(int val) {
		this.type=val;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Users(String userName, String password, String type) {
		super();

		this.userName = userName;
		this.password = password;

		if (type.equals("cust"))
			this.type = 0;

		else
			this.type = 1;
	}

	public void registerUser(Users aUser) {

		Email em=new Email();
		em.sendEmail(aUser.getEmail());
		
		Database db = new Database();
		String query = "insert into Users ( Username, Password, Type)"
				+ " values ( ?, ?, ?)";
		
		
		String[] param = { aUser.getUserName(),
				aUser.getPassword(), String.valueOf(aUser.getType()) };
		db.insert(query, param);
		
	}

	private String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}

	public Users validateUser(Users aUser) throws SQLException {
		
		System.out.println("in validate users");

		Database db = new Database();
		String query = "Select Id, Username, Password, Type from Users where Username="
				+ "'"
				+ aUser.getUserName()
				+ "'"
				+ " and Type="
				+ aUser.getType() + ";";

		System.out.println(query);

		ResultSet val = db.select(query);
		if (val.next()) {
			if (aUser.getPassword().equals(val.getString(3))) {
				aUser.setId(val.getInt(1));
				db.closeConnection();

			}

			return aUser;
		} else
		{	db.closeConnection();
			aUser.setType(-1);
			return aUser;
		}

	}

	public void setEmail(String email2) {
		// TODO Auto-generated method stub
		this.email=email2;
		
	}

}
