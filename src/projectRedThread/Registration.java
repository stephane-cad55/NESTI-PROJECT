package projectRedThread;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;

public class Registration extends Connection {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;

	/**
	 * Launch the application.
	 */
	public static void main1(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 622, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("INSCRIPTION NESTI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 28, 222, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Vous pouvez vous inscrire via ce formulaire :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 52, 293, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Votre nom :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(27, 86, 89, 14);
		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Votre pr\u00E9nom :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(31, 128, 100, 14);
		frame.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Ville :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(27, 172, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("* E-mail : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(22, 221, 71, 14);
		frame.getContentPane().add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("* Pseudo : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(27, 273, 85, 14);
		frame.getContentPane().add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("* Mot De Passe : ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(27, 323, 114, 14);
		frame.getContentPane().add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("* Champs obligatoires");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(10, 350, 158, 86);
		frame.getContentPane().add(lblNewLabel_8);

		textField = new JTextField();
		textField.setBounds(170, 83, 409, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(170, 125, 409, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(170, 170, 409, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(170, 219, 409, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(170, 271, 409, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(170, 320, 409, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("INSCRIPTION");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(285, 369, 160, 46);
		frame.getContentPane().add(btnNewButton);
	}

	/**
	 * Action de lire les tous les utilisateurs
	 */
	public static void readAll() {
		try {
			Statement declaration = accessDataBase.createStatement();
			String query = "SELECT id, nom FROM users;";
			ResultSet resultat = declaration.executeQuery(query);
			/* Récupération des données */
			while (resultat.next()) {

				Users ing = new Users();
				ing.setId(resultat.getInt("id"));
				ing.setNom(resultat.getString("nom"));
				ing.setPrenom(resultat.getString("prénom"));
				ing.setVille(resultat.getString("ville"));
				ing.setMail(resultat.getString("e-mail"));
				ing.setPseudo(resultat.getString("pseudo"));
				ing.setMotDePasse(resultat.getString("mot de passe"));

				System.out.println(ing.toString());
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
	}

	/**
	 * Ici on test
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		openConnection();
		// avant
		readAll();
		// création
		create("");
		readAll();
		closeConnection();
	}

	/**
	 * Création d'un nouvel utilisateur
	 * 
	 * @param utilisateur
	 * @return // true si insertion réussite
	 */

	public static void create(String utilisateur) {
		boolean flag = false;
		try {
			Statement declaration = accessDataBase.createStatement();
			String query = "INSERT INTO `users`(`id`) " + "VALUES (\"" + utilisateur + "\")";
			String query1 = "INSERT INTO `users`(`nom`) " + "VALUES (\"" + utilisateur + "\")";
			String query2 = "INSERT INTO `users`(`prénom`) " + "VALUES (\"" + utilisateur + "\")";
			String query3 = "INSERT INTO `users`(`ville`) " + "VALUES (\"" + utilisateur + "\")";
			String query4 = "INSERT INTO `users`(`e-mail`) " + "VALUES (\"" + utilisateur + "\")";
			String query5 = "INSERT INTO `users`(`pseudo`) " + "VALUES (\"" + utilisateur + "\")";
			String query6 = "INSERT INTO `users`(`mot de passe`) " + "VALUES (\"" + utilisateur + "\")";

			int executeUpdate = declaration.executeUpdate(query);
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		return;
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