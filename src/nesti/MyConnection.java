package nesti;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	static java.sql.Connection accessDataBase = null;

	/**
	 * Connecting to my NESTI database
	 * 
	 * @throws SQLException
	 */
	public static void openConnection() {
		/* Connection settings */
		String url = "jdbc:mysql://127.0.0.1/nesti";
		// nesti ==> name of my database
		String utilisateur = "root";
		String motDePasse = "";
		try {
			System.out.println("try to connect");
			// we add our parameters

			accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException ex) {
			System.err.print(Connection.class.getName() + ex.getMessage());
		}
	}

	/**
	 * True if the connection is OK
	 * 
	 * @return
	 */
	public static boolean testConnection() {
		boolean flag = false;
		try {
			if (accessDataBase != null) {
				if (!accessDataBase.isClosed()) {
					System.out.println("Connexion au serveur... OK");
					flag = true;
				}
			}
		} catch (SQLException ex) {
			System.err.print(Connection.class.getName() + ex.getMessage());
		}
		return flag;
	}

	public static void closeConnection() {
		if (accessDataBase != null) {
			try {
				accessDataBase.close();
				System.out.println("Close connection");
			} catch (SQLException e) {
				System.err.println("Erreur fermeture: " + e.getMessage());
			}
		}
	}

	public static void create(String users) {
		try {
			Statement declaration = (Statement) accessDataBase.createStatement();
			String query = "INSERT INTO `users`(`nom`) " + "VALUES ('" + users + "')";

			int executeUpdate = ((java.sql.Statement) declaration).executeUpdate(query);
			if (executeUpdate == 1) {
				System.out.println("insertion utilisateur effectué ! ");
			} else {
				System.out.println("insertion utilisateur non effectue");
			}

		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
	}

}
