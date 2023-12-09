package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class KorisnikForma extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_surname;
	private JTextField tf_phone;
	private JTextField tf_mail;
	
	
	JButton btnNewButton;
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
		tf_name.setBounds(140, 75, 154, 19);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		tf_surname = new JTextField();
		tf_surname.setColumns(10);
		tf_surname.setBounds(140, 113, 154, 19);
		contentPane.add(tf_surname);
		
		tf_phone = new JTextField();
		tf_phone.setColumns(10);
		tf_phone.setBounds(140, 153, 154, 19);
		contentPane.add(tf_phone);
		
		btnNewButton = new JButton("Support");
		btnNewButton.setBounds(209, 247, 85, 21);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		//btnNewButton.setEnabled(false);
		
		JLabel lblNewLabel_3 = new JLabel("Email adress:");
		lblNewLabel_3.setBounds(48, 199, 82, 13);
		contentPane.add(lblNewLabel_3);
		
		tf_mail = new JTextField();
		tf_mail.setBounds(140, 196, 154, 19);
		contentPane.add(tf_mail);
		tf_mail.setColumns(10);
		
		//JOptionPane.showMessageDialog(null, "Thank you for your kindness", "Thank you", );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
	        System.out.println("Inside actionPerformed"); // Debugging statement

	        if (tf_name.getText().isEmpty() || tf_surname.getText().isEmpty() || tf_phone.getText().isEmpty() || tf_mail.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(btnNewButton, "Please fill out all fields before submitting.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(btnNewButton, "Thank you for your kindness", "Thank you note", JOptionPane.PLAIN_MESSAGE);
	        }
	    }
		
	}
}
