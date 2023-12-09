package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;

public class AboutUs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public AboutUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("About us");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(32, 10, 161, 53);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrWelcomeToKindheartgifts = new JTextArea();
		txtrWelcomeToKindheartgifts.setEditable(false);
		txtrWelcomeToKindheartgifts.setWrapStyleWord(true);
		txtrWelcomeToKindheartgifts.setBackground(new Color(255, 240, 245));
		txtrWelcomeToKindheartgifts.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		txtrWelcomeToKindheartgifts.setLineWrap(true);
		txtrWelcomeToKindheartgifts.setText("Welcome to KindHeartGifts, where compassion meets generosity to brighten the lives of children in need. Our firm is dedicated to creating joyous moments for unfortunate children by connecting them with individuals who have a heart for giving.\r\n\r\nAt KindHeartGifts, we believe that every child deserves to experience the warmth of kindness and the joy of receiving a thoughtful gift. We understand that circumstances may vary, but the desire to make a positive impact is universal. That's why we've made it our mission to bridge the gap between those willing to give and those who could use a little extra love.");
		txtrWelcomeToKindheartgifts.setBounds(32, 61, 560, 142);
		contentPane.add(txtrWelcomeToKindheartgifts);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblContact.setBounds(32, 213, 161, 53);
		contentPane.add(lblContact);
		
		JTextArea txtrForAnyAdditional = new JTextArea();
		txtrForAnyAdditional.setText("For any additional information you can contact us here:\r\n\r\nPhone number: 064 145 324\r\nE-mail: kindheartgifts@email.com\r\n\r\nThanks for the support! Stay kind!");
		txtrForAnyAdditional.setWrapStyleWord(true);
		txtrForAnyAdditional.setLineWrap(true);
		txtrForAnyAdditional.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		txtrForAnyAdditional.setEditable(false);
		txtrForAnyAdditional.setBackground(new Color(255, 240, 245));
		txtrForAnyAdditional.setBounds(32, 254, 560, 105);
		contentPane.add(txtrForAnyAdditional);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 680, 410);
		contentPane.add(panel);
	}

}
