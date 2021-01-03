package nesti;

/**
 *  @author stephane cadeck.
 */

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	static java.sql.Connection accessDataBase = null;

	/**
	 * Connecting to my nesti database. Open the connection.
	 * 
	 * @throws SQLException.
	 */
	public static void openConnection() {
		/* Connection settings */
		String url = "jdbc:mysql://127.0.0.1/nesti";
		// nesti ==> name of my database
		String user = "root";
		String passWord = "";
		try {
			System.out.println("try to connect");
			// we add our parameters

			accessDataBase = DriverManager.getConnection(url, user, passWord);
		} catch (SQLException ex) {
			System.err.print(Connection.class.getName() + ex.getMessage());
		}
	}

	/**
	 * True if the connection is OK. Test the connection.
	 * 
	 * @return
	 */
	public static boolean testConnection() {
		boolean flag = false;
		try {
			if (accessDataBase != null) {
				if (!accessDataBase.isClosed()) {
					System.out.println("connection to the server ... OK");
					flag = true;
				}
			}
		} catch (SQLException ex) {
			System.err.print(Connection.class.getName() + ex.getMessage());
		}
		return flag;
	}

	/*
	 * Close the connection.
	 */
	public static void closeConnection() {
		if (accessDataBase != null) {
			try {
				accessDataBase.close();
				System.out.println("close connection");
			} catch (SQLException e) {
				System.err.println("closing error: " + e.getMessage());
			}
		}
	}

	/*
	 * User insertion.
	 */
	public static void create(String users) {
		try {
			Statement declaration = (Statement) accessDataBase.createStatement();
			String query = "INSERT INTO `users`(`nom`) " + "VALUES ('" + users + "')";

			int executeUpdate = ((java.sql.Statement) declaration).executeUpdate(query);
			if (executeUpdate == 1) {
				System.out.println("user insertion carried out");
			} else {
				System.out.println("user insertion not carried out !");
			}

		} catch (Exception e) {
			System.err.println("user insertion error: " + e.getMessage());
		}
	}
}