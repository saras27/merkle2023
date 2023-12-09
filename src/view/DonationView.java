package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

public class DonationView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_iznos;
	private JTextField tf_email;


	/**
	 * Create the frame.
	 */
	public DonationView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Make your donation");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(37, 209, 171, 22);
		contentPane.add(lblNewLabel);
		
		tf_iznos = new JTextField();
		tf_iznos.setBounds(37, 368, 193, 19);
		contentPane.add(tf_iznos);
		tf_iznos.setColumns(10);
		
		JButton btn200 = new JButton("200");
		btn200.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btn200.setBackground(new Color(221, 160, 221));
		btn200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_iznos.setText("200");
			}
		});
		btn200.setBounds(37, 262, 85, 21);
		contentPane.add(btn200);
		
		JButton btn500 = new JButton("500");
		btn500.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btn500.setBackground(new Color(221, 160, 221));
		btn500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_iznos.setText("500");
			}
		});
		btn500.setBounds(145, 262, 85, 21);
		contentPane.add(btn500);
		
		JButton btn1000 = new JButton("1000");
		btn1000.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btn1000.setBackground(new Color(221, 160, 221));
		btn1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_iznos.setText("1000");
			}
		});
		btn1000.setBounds(260, 262, 85, 21);
		contentPane.add(btn1000);
		
		JButton btnDoniraj = new JButton("Donate");
		btnDoniraj.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnDoniraj.setBackground(new Color(221, 160, 221));
		btnDoniraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tf_iznos.getText().trim().isEmpty() && !tf_email.getText().trim().isEmpty()) {
					if (!isValidEmail(tf_email.getText())) {  
						JOptionPane.showMessageDialog(contentPane, "Invalid email format or domain", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					JOptionPane.showMessageDialog(contentPane, "Thank you for the donation of "+ tf_iznos.getText()+"RSD! \n"
						+ " You will receive an email with the payment instructions.", "Request Received", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(DonationView.this, "You have to leave your email above.", "Error", JOptionPane.ERROR_MESSAGE);
				}
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
		btnDoniraj.setBounds(260, 367, 85, 21);
		contentPane.add(btnDoniraj);
		
		tf_email = new JTextField();
		tf_email.setBounds(145, 317, 200, 19);
		contentPane.add(tf_email);
		tf_email.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("email:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(37, 320, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblWhyDonate = new JLabel("Why should I donate?");
		lblWhyDonate.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblWhyDonate.setBounds(37, 27, 193, 22);
		contentPane.add(lblWhyDonate);
		
		JTextArea txtrByDonatingTo = new JTextArea();
		txtrByDonatingTo.setBackground(new Color(255, 240, 245));
		txtrByDonatingTo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		txtrByDonatingTo.setWrapStyleWord(true);
		txtrByDonatingTo.setLineWrap(true);
		txtrByDonatingTo.setEditable(false);
		txtrByDonatingTo.setText("By donating to our organization, you become a beacon of hope for those children whose wishlists haven't been fulfilled. Your contribution empowers us to purchase thoughtful and meaningful gifts, ensuring that no child is left without a smile. Together, we can create a ripple of kindness that resonates far beyond the material gifts, fostering a sense of community, solidarity, and shared joy. Your donation becomes a tangible expression of love and care, demonstrating the magic that happens when individuals come together to make a positive impact on the lives of others. Join us in spreading warmth, compassion, and the spirit of giving, one child at a time.");
		txtrByDonatingTo.setBounds(21, 58, 518, 141);
		contentPane.add(txtrByDonatingTo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 577, 435);
		contentPane.add(panel);
	}

}
