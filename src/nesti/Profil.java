package nesti;

/**
 *  @author stephane cadeck.
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profil {

	private JFrame frame;
	private JTextField name;
	private JTextField city;
	private JTextField mail;
	private JTextField pseudo;
	private JTextField passWord;

	public static Users user;

	/**
	 * Create the application.
	 */
	public Profil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 102, 0));
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("AUTHENTIFICATION REUSSIE !");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(23, 11, 398, 54);
		frame.getContentPane().add(lblNewLabel);

		/**
		 * Information of the users connected to the nesti website.
		 */
		JLabel lblNewLabel_1 = new JLabel("Vous \u00EAtes Mr ou Mme");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(23, 108, 149, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Habitant \u00E0");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(23, 159, 79, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("E-mail : ");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(23, 215, 66, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Pseudo : ");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(23, 270, 66, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Mot De Passe : ");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(29, 323, 95, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JTextField name = new JTextField(user.getUserName());
		name.setBackground(Color.LIGHT_GRAY);
		name.setBounds(182, 106, 333, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);

		JTextField city = new JTextField(user.getUserCity());
		city.setBackground(Color.LIGHT_GRAY);
		city.setBounds(182, 157, 333, 20);
		frame.getContentPane().add(city);
		city.setColumns(10);

		JTextField mail = new JTextField(user.getUserMail());
		mail.setBackground(Color.LIGHT_GRAY);
		mail.setBounds(182, 213, 333, 20);
		frame.getContentPane().add(mail);
		mail.setColumns(10);

		JTextField pseudo = new JTextField(user.getUserPseudo());
		pseudo.setBackground(Color.LIGHT_GRAY);
		pseudo.setBounds(182, 268, 333, 20);
		frame.getContentPane().add(pseudo);
		pseudo.setColumns(10);

		JTextField passWord = new JTextField(user.getUserPassword());
		passWord.setBackground(Color.LIGHT_GRAY);
		passWord.setBounds(182, 321, 333, 20);
		frame.getContentPane().add(passWord);
		passWord.setColumns(10);

		/**
		 * Button to modify or complete user information.
		 */
		JButton btnNewButton = new JButton("MODIFIER OU COMPLETER VOS INFORMATIONS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(182, 372, 333, 44);
		frame.getContentPane().add(btnNewButton);

		frame.setVisible(true);

		frame.setBounds(100, 100, 560, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}