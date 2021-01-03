package nesti;

/**
 *  @author stephane cadeck.
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query extends MyConnection {

	/**
	 * Action to read all the users.
	 */
	public static void readAll() {

		try {

			Statement declaration = MyConnection.accessDataBase.createStatement();
			String query = "SELECT userName, userFirstName, userCity, userMail, userPseudo, userPassword";
			ResultSet resultat = declaration.executeQuery(query);

			while (resultat.next()) {

				Users x = new Users();

				x.setUserName(resultat.getString("userName"));
				x.setUserFirstName(resultat.getString("userFirstName"));
				x.setUserCity(resultat.getString("userCity"));
				x.setUserMail(resultat.getString("userMail"));
				x.setUserPseudo(resultat.getString("userPseudo"));
				x.setUserPassword(resultat.getString("userPassword"));

				System.out.println(x.toString());
			}

		} catch (Exception e) {

			System.err.println("user display error: " + e.getMessage());
		}
	}

	/**
	 * Creating a new user.
	 * 
	 * @param user
	 * @return // true if successful insertion.
	 */

	public static void create(Users user) {

		boolean flag = false;

		try {

			String query = "INSERT INTO `users`(`userName`, `userFirstName`, `userCity`, `userMail`, `userPseudo`, `userPassword`)values(?,?,?,?,?,?)";
			PreparedStatement declaration = MyConnection.accessDataBase.prepareStatement(query);

			declaration.setString(1, user.getUserName());
			declaration.setString(2, user.getUserFirstName());
			declaration.setString(3, user.getUserCity());
			declaration.setString(4, user.getUserMail());
			declaration.setString(5, user.getUserPseudo());
			declaration.setString(6, user.getUserPassword());

			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);

		} catch (Exception e) {

			System.err.println("user insertion error: " + e.getMessage());
		}

		return;

	}

	/*
	 * User registration in the database.
	 */
	public static boolean selectUser(String UserMailOrPseudo, String userPassword) {

		boolean flag = false;

		try {

			openConnection();

			testConnection();

			String query = "SELECT * FROM `users` WHERE userMail = ? OR userPseudo = ? AND userPassword = ?";
			PreparedStatement declaration = MyConnection.accessDataBase.prepareStatement(query);

			declaration.setString(1, UserMailOrPseudo);
			declaration.setString(2, UserMailOrPseudo);
			declaration.setString(3, userPassword);

			ResultSet resultat = declaration.executeQuery();

			if (resultat.next() == true) {
				flag = true;

				Profil.user = retrieveInformations(resultat);
			}

		} catch (Exception e) {

			System.err.println("user display error: " + e.getMessage());
		}

		closeConnection();

		return flag;
	}

	/*
	 * Collect user information.
	 */
	public static Users retrieveInformations(ResultSet resultat) throws SQLException {

		Users user = new Users();

		user.setUserName(resultat.getString(1));
		user.setUserFirstName(resultat.getString(2));
		user.setUserCity(resultat.getString(3));
		user.setUserMail(resultat.getString(4));
		user.setUserPseudo(resultat.getString(5));
		user.setUserPassword(resultat.getString(6));

		return user;
	}

	/*
	 * Function to modify or complete the information.
	 */
	public static boolean update(String name, String city, String pseudo, String passWord, String email) {

		boolean success = false;

		try {
			String query = "UPDATE users SET userName = ?, userCity = ? , userPseudo = ?, userPassword = ? WHERE userMail = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, name);
			declaration.setString(2, city);
			declaration.setString(3, pseudo);
			declaration.setString(4, passWord);
			declaration.setString(5, email);

			int executeUpdate = declaration.executeUpdate();
			success = (executeUpdate == 1);

		} catch (SQLException e) {

			System.err.println("error update" + e.getMessage());
		}
		return success;
	}
}