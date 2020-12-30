package nesti;

/**
 *  @author stephane cadeck.
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.getContentPane().setBackground(new Color(102, 102, 0));

		frame.setVisible(true);

		frame.setBounds(100, 100, 622, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("INSCRIPTION NESTI");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 28, 222, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Vous pouvez vous inscrire via ce formulaire :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 52, 293, 14);
		frame.getContentPane().add(lblNewLabel_1);

		/**
		 * information to be filled in for a first connection to the site nesti.
		 */
		JLabel lblNewLabel_2 = new JLabel("Votre nom :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(27, 86, 89, 14);
		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Votre pr\u00E9nom :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(31, 128, 100, 14);
		frame.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Ville :");
		lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(27, 172, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("* E-mail : ");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(22, 221, 71, 14);
		frame.getContentPane().add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("* Pseudo : ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(16, 273, 89, 14);
		frame.getContentPane().add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("* Mot De Passe : ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(20, 325, 114, 14);
		frame.getContentPane().add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("* Champs obligatoires");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(10, 350, 158, 86);
		frame.getContentPane().add(lblNewLabel_8);

		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(170, 83, 409, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(170, 125, 409, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setBounds(170, 170, 409, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setBounds(170, 219, 409, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setBounds(170, 271, 409, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBackground(Color.LIGHT_GRAY);
		textField_5.setBounds(170, 320, 409, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		/**
		 * Button registration new user.
		 */
		JButton btnNewButton = new JButton("INSCRIPTION");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textField_3.getText().equals("")) {

					if (addressEmailValid(textField_3.getText())) {

						if (forceMdp(textField_5.getText()) >= 83) {

							Users user = new Users(textField.getText(), textField_1.getText(), textField_2.getText(),
									textField_3.getText(), textField_4.getText(), textField_5.getText());
							Query.create(user);
							frame.dispose();
							Profil viewProfil = new Profil();

						} else {

							JOptionPane.showMessageDialog(frame, "Le mot de passe n'est pas assez fort!");
						}

					} else {

						JOptionPane.showMessageDialog(frame, "Le format d'email est incorrect, il est obligatoire!");
					}
				}
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(285, 369, 160, 46);
		frame.getContentPane().add(btnNewButton);
	}

	/**
	 * email function.
	 * 
	 * @param userMail.
	 * @return
	 */
	public boolean addressEmailValid(String userMail) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(userMail);
		boolean IsMatch = m.matches();
		System.out.println(IsMatch);
		if (IsMatch == false) {
			textField_3.setText("E-mail invalide");
			textField_3.setBackground(Color.RED);
			System.out.println(IsMatch);
			IsMatch = false;
		} else {
			IsMatch = m.matches();
		}

		return IsMatch;
	}

	/**
	 * Password strength function.
	 * 
	 * @param userPassword.
	 * @return
	 */
	public long forceMdp(String userPassword) {
		// La Longueur
		int l = userPassword.length();
		// Le nombre de caractères
		int n = alphabet(userPassword);

		// Appliquer la formule
		double force = l * (Math.log(n) / Math.log(2));
		long forceRest;
		if (force <= 82) {
			textField_5.setText("Mot de passe invalide");
			textField_5.setBackground(Color.RED);
			forceRest = 0;
		} else {
			forceRest = Math.round(force);
		}
		return forceRest;
	}

	public int alphabet(String userPassword) {
		int n = 0;
		Pattern regex1 = Pattern.compile("[0-9]");
		Matcher matcher1 = regex1.matcher(userPassword);
		if (matcher1.find()) {
			// if (mdp.matches("")) {
			n += 10;
		}
		Pattern regex2 = Pattern.compile("[a-z]");
		Matcher matcher2 = regex2.matcher(userPassword);
		if (matcher2.find()) {
			// if (mdp.matches("a-z")) {
			n += 26;
		}
		Pattern regex3 = Pattern.compile("[A-Z]");
		Matcher matcher3 = regex3.matcher(userPassword);
		if (matcher3.find()) {
			// if (mdp.matches("A-Z")) {
			n += 26;
		}
		Pattern regex = Pattern.compile("[$&+,:;=?@#|]");
		Matcher matcher = regex.matcher(userPassword);
		if (matcher.find()) {
			n += 8;
		}

		return n;
	}
}