package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Logovanje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_user;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logovanje frame = new Logovanje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Logovanje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(40, 96, 99, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(40, 134, 82, 13);
		contentPane.add(lblNewLabel_1);
		
		tf_user = new JTextField();
		tf_user.setBounds(127, 93, 145, 19);
		contentPane.add(tf_user);
		tf_user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 131, 145, 19);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Log As Admin");
		btnLogin.setBounds(37, 188, 114, 21);
		contentPane.add(btnLogin);
		
		JButton btnExploreWishlists = new JButton("Explore Wishlists");
		btnExploreWishlists.setBounds(158, 188, 114, 21);
		contentPane.add(btnExploreWishlists);
	}
}
