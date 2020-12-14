package nesti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

public class Profil {

	private JFrame frame;

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
		frame.getContentPane().setBackground(new Color(102, 255, 204));

		frame.setVisible(true);

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
