package nesti;

/**
 *  @author stephane cadeck.
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Connection {

	private JFrame frame;
	
	/**
	 * Create the application.
	 */
	public Connection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 102, 0));

		frame.setVisible(true);

		frame.setBounds(100, 100, 571, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("CONNEXION NESTI");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 22, 201, 14);
		frame.getContentPane().add(lblNewLabel);

		/**
		 * Connection to the nesti site with filling in the required information.
		 */
		JLabel lblNewLabel_1 = new JLabel("* E-mail ou Pseudo :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(45, 70, 130, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("* Mot De Passe :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(45, 129, 113, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("* Champs obligatoires");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 195, 166, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JTextField textUserMailOrPseudo = new JTextField();
		textUserMailOrPseudo.setBackground(Color.LIGHT_GRAY);
		textUserMailOrPseudo.setBounds(210, 68, 323, 20);
		frame.getContentPane().add(textUserMailOrPseudo);
		textUserMailOrPseudo.setColumns(10);

		JTextField textUserPassword = new JTextField();
		textUserPassword.setBackground(Color.LIGHT_GRAY);
		textUserPassword.setBounds(210, 127, 323, 20);
		frame.getContentPane().add(textUserPassword);
		textUserPassword.setColumns(10);

		/**
		 * Nesti website login button for already registered users.
		 */
		JButton btnNewButton = new JButton("CONNEXION\r\n");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userId = textUserMailOrPseudo.getText();
				String userPassword = textUserPassword.getText();

				if (Query.selectUser(userId, userPassword) == true) {

					frame.dispose();
					Profil viewProfil = new Profil();

				} else {

					JOptionPane.showMessageDialog(frame, "Connexion impossible");
				}

			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(169, 179, 130, 44);
		frame.getContentPane().add(btnNewButton);

		/**
		 * Nesti site registration button (new users).
		 */
		JButton btnNewButton_1 = new JButton("INSCRIPTION\r\n(nouvel utilisateur)");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Registration viewRegistration = new Registration();
			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBounds(309, 179, 224, 44);
		frame.getContentPane().add(btnNewButton_1);
	}
}