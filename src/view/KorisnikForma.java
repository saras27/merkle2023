package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class KorisnikForma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_surname;
	private JTextField tf_phone;
	private int id_dete;
	private JLabel lblNewLabel_3;
	private JTextField tf_mail;
	private JLabel lblNewLabel_4;
	private JPanel panel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public KorisnikForma(int id_dete) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel.setBounds(110, 77, 82, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Surname:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(110, 115, 82, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Phone number:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(110, 155, 85, 13);
		contentPane.add(lblNewLabel_2);

		tf_name = new JTextField();
		tf_name.setBounds(266, 77, 151, 19);
		contentPane.add(tf_name);
		tf_name.setColumns(10);

		tf_surname = new JTextField();
		tf_surname.setColumns(10);
		tf_surname.setBounds(266, 115, 151, 19);
		contentPane.add(tf_surname);

		tf_phone = new JTextField();
		tf_phone.setColumns(10);
		tf_phone.setBounds(266, 155, 151, 19);
		contentPane.add(tf_phone);

		JButton btnNewButton = new JButton("Support");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!tf_name.getText().trim().isEmpty() && !tf_surname.getText().trim().isEmpty()
						&& !tf_mail.getText().trim().isEmpty() && !tf_phone.getText().trim().isEmpty()) {
				
					 if (!isValidEmail(tf_mail.getText())) {  
						JOptionPane.showMessageDialog(contentPane, "Invalid email format or domain", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					 }
					 if(!isValidNumber(tf_phone.getText())){  
							JOptionPane.showMessageDialog(contentPane, "Invalid phone number format ", "Error", JOptionPane.ERROR_MESSAGE);
							return;
					 }
					 Kontroler.getInstanca().upisiKorisnika(tf_name.getText(),tf_surname.getText(),tf_mail.getText(),tf_phone.getText(),id_dete);
				        Kontroler.getInstanca().updateStatusDeteta(id_dete);
				        JOptionPane.showMessageDialog(contentPane, "Thank you for your support!", "Request Received", JOptionPane.INFORMATION_MESSAGE);
				        tf_mail.setText("");
				        tf_name.setText("");
				        tf_phone.setText("");
				        tf_surname.setText("");
				}else{
					JOptionPane.showMessageDialog(KorisnikForma.this, "You have to fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}

			private boolean isValidNumber(String text) {
				String phoneRegex = "06[0-9]{6,9}";

		        if (text.matches(phoneRegex)) {
		        	return true;
		        }
				return false;
			}

			private boolean isValidEmail(String text) {
				String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

		        if (text.matches(emailRegex)) {
		            String[] allowedDomains = {"gmail.com", "yahoo.com", "hotmail.com", "aol.com"};
		            String[] parts = text.split("@");

		            if (parts.length == 2) {
		                String domain = parts[1];
		                for (String allowedDomain : allowedDomains) {
		                    if (domain.equals(allowedDomain)) {
		                        return true;
		                    }
		                }
		            }
		        }
		        return false;

			}
		});
		btnNewButton.setBounds(332, 257, 85, 21);
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(110, 194, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		tf_mail = new JTextField();
		tf_mail.setBounds(266, 197, 151, 19);
		contentPane.add(tf_mail);
		tf_mail.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Enter your information:");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(48, 40, 137, 13);
		contentPane.add(lblNewLabel_4);
		
		panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 573, 355);
		contentPane.add(panel);
	}

}