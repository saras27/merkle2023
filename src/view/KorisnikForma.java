package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class KorisnikForma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_surname;
	private JTextField tf_phone;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public KorisnikForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(48, 78, 82, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname:");
		lblNewLabel_1.setBounds(48, 116, 82, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone number:");
		lblNewLabel_2.setBounds(48, 156, 82, 13);
		contentPane.add(lblNewLabel_2);
		
		tf_name = new JTextField();
		tf_name.setBounds(143, 75, 151, 19);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		tf_surname = new JTextField();
		tf_surname.setColumns(10);
		tf_surname.setBounds(140, 113, 154, 19);
		contentPane.add(tf_surname);
		
		tf_phone = new JTextField();
		tf_phone.setColumns(10);
		tf_phone.setBounds(143, 153, 151, 19);
		contentPane.add(tf_phone);
		
		JButton btnNewButton = new JButton("Support");
		btnNewButton.setBounds(209, 193, 85, 21);
		contentPane.add(btnNewButton);
	}

}
