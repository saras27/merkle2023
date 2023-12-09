package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel.setVisible(false);
		lblNewLabel.setBounds(121, 115, 99, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(121, 153, 82, 13);
		contentPane.add(lblNewLabel_1);
		
		tf_user = new JTextField();
		tf_user.setBounds(208, 112, 145, 19);
		tf_user.setVisible(false);
		contentPane.add(tf_user);
		tf_user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setVisible(false);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						login();
				}
				
			}
		});
		passwordField.setBounds(208, 150, 145, 19);
		
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Log As Admin");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(221, 160, 221));
		btnLogin.setVisible(false);
		btnLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBounds(121, 194, 232, 21);
		contentPane.add(btnLogin);
		
		JButton btnExploreWishlists = new JButton("Explore Wishlists");
		btnExploreWishlists.setBackground(new Color(221, 160, 221));
		btnExploreWishlists.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnExploreWishlists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExploreView ev = new ExploreView();
				ev.setVisible(true);
			}
		});
		btnExploreWishlists.setBounds(121, 225, 232, 21);
		contentPane.add(btnExploreWishlists);
		
		JLabel lblNewLabel_2 = new JLabel("KindHeartGifts");
		lblNewLabel_2.setForeground(new Color(224, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(121, 34, 232, 57);
		contentPane.add(lblNewLabel_2);
		
		JButton btnDonate = new JButton("Donate");
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonationView dv = new DonationView();
				dv.setVisible(true);
			}
		});
		btnDonate.setForeground(Color.BLACK);
		btnDonate.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnDonate.setBackground(new Color(221, 160, 221));
		btnDonate.setBounds(121, 256, 232, 21);
		contentPane.add(btnDonate);
		
		JButton btnAboutUs = new JButton("About us");
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUs.au.setVisible(true);
			}
		});
		btnAboutUs.setForeground(Color.BLACK);
		btnAboutUs.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnAboutUs.setBackground(new Color(221, 160, 221));
		btnAboutUs.setBounds(121, 287, 232, 21);
		contentPane.add(btnAboutUs);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setVisible(true);
				tf_user.setVisible(true);
				passwordField.setVisible(true);
				btnLogin.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.setBounds(21, 23, 76, 21);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 488, 342);
		contentPane.add(panel);
		
	}
	
	protected void login() {
		// TODO Auto-generated method stub
		String user=tf_user.getText();
	    String pass=String.valueOf(passwordField.getPassword());
	    
	    if(user.equals("admin") && pass.equals("admin")) {
	    	MedjuFormaAdmin mf= new MedjuFormaAdmin();
	    	mf.setVisible(true);
	    }
	}
}
