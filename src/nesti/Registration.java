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
		 * Information to be filled in for a first connection to the site nesti.
		 */
		JLabel lblNewLabel_2 = new JLabel("Votre nom :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(27, 86, 89, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Votre pr\u00E9nom :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(31, 128, 100, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Ville :");
		lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(27, 172, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("* E-mail : ");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(22, 221, 71, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("* Pseudo : ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(16, 273, 89, 14);
		frame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("* Mot De Passe : ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(20, 325, 114, 14);
		frame.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("* Champs obligatoires");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(10, 350, 158, 86);
		frame.getContentPane().add(lblNewLabel_8);

		JTextField name = new JTextField();
		name.setBackground(Color.LIGHT_GRAY);
		name.setBounds(170, 83, 409, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);

		JTextField firstName = new JTextField();
		firstName.setBackground(Color.LIGHT_GRAY);
		firstName.setBounds(170, 125, 409, 20);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);

		JTextField city = new JTextField();
		city.setBackground(Color.LIGHT_GRAY);
		city.setBounds(170, 170, 409, 20);
		frame.getContentPane().add(city);
		city.setColumns(10);

		JTextField mail = new JTextField();
		mail.setBackground(Color.LIGHT_GRAY);
		mail.setBounds(170, 219, 409, 20);
		frame.getContentPane().add(mail);
		mail.setColumns(10);

		JTextField pseudo = new JTextField();
		pseudo.setBackground(Color.LIGHT_GRAY);
		pseudo.setBounds(170, 271, 409, 20);
		frame.getContentPane().add(pseudo);
		pseudo.setColumns(10);

		JTextField passWord = new JTextField();
		passWord.setBackground(Color.LIGHT_GRAY);
		passWord.setBounds(170, 320, 409, 20);
		frame.getContentPane().add(passWord);
		passWord.setColumns(10);

		/**
		 * Button registration new user.
		 */
		JButton btnNewButton = new JButton("INSCRIPTION");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (!mail.getText().equals("")) {

					if (addressEmailValid(mail.getText(), passWord)) {

						String enterPassword = passWord.getText();
						System.out.println(enterPassword);

						if (forceMdp(enterPassword, passWord) >= 83) {

							MyConnection.openConnection();

							Users user = new Users(name.getText(), firstName.getText(), city.getText(), mail.getText(),
									pseudo.getText(), passWord.getText());

							Query.create(user);

							MyConnection.closeConnection();

							frame.dispose();
							Connection viewConnection = new Connection();

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
	 * Email function.
	 * 
	 * @param userMail.
	 * @return
	 */
	public boolean addressEmailValid(String userMail, JTextField mail) {

		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(userMail);

		boolean IsMatch = m.matches();

		System.out.println(IsMatch);

		if (IsMatch == false) {

			mail.setText("E-mail invalide");
			mail.setBackground(Color.RED);
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
	public long forceMdp(String enterPassword, JTextField passWord) {

		// the length of the password.
		int l = enterPassword.length();

		// the number of characters.
		int n = alphabet(enterPassword);

		// Apply the formula.

		double force = l * (Math.log(n) / Math.log(2));
		long forceRest;

		if (force <= 82) {

			passWord.setText("Mot de passe invalide");
			passWord.setBackground(Color.RED);

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
			n += 10;
		}

		Pattern regex2 = Pattern.compile("[a-z]");
		Matcher matcher2 = regex2.matcher(userPassword);

		if (matcher2.find()) {
			n += 26;
		}

		Pattern regex3 = Pattern.compile("[A-Z]");
		Matcher matcher3 = regex3.matcher(userPassword);

		if (matcher3.find()) {

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