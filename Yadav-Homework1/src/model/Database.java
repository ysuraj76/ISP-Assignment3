package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.pool.BasePoolableObjectFactory;

import com.sun.glass.ui.Size;

public class Database {

	private String host = "cse.unl.edu";
	private String port = "3306";
	private String schema = "syadav";
	private String user = "syadav";
	private String password = "DC9gBc";
	Connection connection;

	public void getResults() {

	}

	private void makeConnection() {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://" + host + ":" + port + "/" + schema
					+ "?autoReconnectForPools=true";
			String apd="&characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			url=url+apd;
			connection = DriverManager.getConnection(url, user, password);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeConnection() throws SQLException {
		connection.close();
	}

	public void insert(String query, String param[]) {
		makeConnection();

		try {
			java.sql.Statement stmt = connection.createStatement();
			java.sql.PreparedStatement preparedStmt = connection
					.prepareStatement(query);

			for (int i = 0; i <= param.length - 1; i++) {
				System.out.println(param[i]);
				preparedStmt.setString(i + 1, param[i]);

			}
			int rowsAffected=preparedStmt.executeUpdate();
			
			if(rowsAffected>0)
	        {
	              System.out.println("success");
	        }
	              else
	        {
	             System.out.println("stuck somewhere");

	        }

			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet select(String query) throws SQLException {

		makeConnection();

		java.sql.Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		return rs;
	}

}
