package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Banking {
	int id;
	String holderName;
	String cardNo;
	double blance;
	String cardType;
	String cvv;
	int usrId;

	public void updateBalance(String val, double amt, String operation) {

		Database db = new Database();

		String query = "Select Balance from CreditCards where CreditCardNumber = "
				+ val + ";";

		System.out.println(query);

		ResultSet rs;
		try {
			rs = db.select(query);

			rs.next();

			double bal = rs.getDouble(1);
			
			if(operation.equals("order"))
			bal =bal-amt;
			
			if(operation.equals("return"))
				bal += amt;

			query = "UPDATE CreditCards SET Balance=? WHERE"
					+ " CreditCardNumber =?;";

			String[] param = { String.valueOf(bal), val };

			db.insert(query, param);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
