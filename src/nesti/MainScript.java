package nesti;

import java.awt.EventQueue;

public class MainScript {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection window = new Connection();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
