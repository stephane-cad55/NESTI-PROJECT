package nesti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query extends MyConnection {

	/**
	 * Action to read all the users
	 */
	public static void readAll() {
		try {
			Statement declaration = MyConnection.accessDataBase.createStatement();
			String query = "SELECT userName, userFirstName, userCity, userMail, userPseudo, userPassword";
			ResultSet resultat = declaration.executeQuery(query);

			while (resultat.next()) {

				Users ing = new Users();

				ing.setUserName(resultat.getString("userName"));
				ing.setUserFirstName(resultat.getString("userFirstName"));
				ing.setUserCity(resultat.getString("userCity"));
				ing.setUserMail(resultat.getString("userMail"));
				ing.setUserPseudo(resultat.getString("userPseudo"));
				ing.setUserPassword(resultat.getString("userPassword"));

				System.out.println(ing.toString());
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
	}

	/**
	 * Creating a new user
	 * 
	 * @param user
	 * @return // true if successful insertion
	 */

	public static void create(Users user) {
		boolean flag = false;
		try {

			openConnection();

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
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		return;

	}

	public static void selectUser(String email, String pseudo, String password) {

		try {

			openConnection();
			String query = "SELECT * FROM `users` WHERE userMail = ? OR userPseudo = ? AND userPassword = ?";
			PreparedStatement declaration = MyConnection.accessDataBase.prepareStatement(query);
			declaration.setString(1, email);
			declaration.setString(2, pseudo);
			declaration.setString(3, password);
			ResultSet resultat = declaration.executeQuery();

			while (resultat.next()) {

				/*Users user = new Users();

				user.setUserName(resultat.getString("userName"));
				user.setUserFirstName(resultat.getString("userFirstName"));
				user.setUserCity(resultat.getString("userCity"));
				user.setUserMail(resultat.getString("userMail"));
				user.setUserPseudo(resultat.getString("userPseudo"));
				user.setUserPassword(resultat.getString("userPassword"));*/

				System.out.println("Success");
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
	}

	public static boolean update(int id, String nom, String prenom, String ville, String mail, String pseudo,
			String motDePasse) {
		return false;
	}

	public static boolean delete(int id, String nom, String prenom, String ville, String mail, String pseudo,
			String motDePasse) {
		return false;
	}

}
