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
		lblNewLabel.setBounds(121, 137, 99, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(121, 175, 82, 13);
		contentPane.add(lblNewLabel_1);
		
		tf_user = new JTextField();
		tf_user.setBounds(208, 134, 145, 19);
		contentPane.add(tf_user);
		tf_user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						login();
				}
				
			}
		});
		passwordField.setBounds(208, 172, 145, 19);
		
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Log As Admin");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(221, 160, 221));
		btnLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBounds(121, 229, 232, 21);
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
		btnExploreWishlists.setBounds(121, 260, 232, 21);
		contentPane.add(btnExploreWishlists);
		
		JLabel lblNewLabel_2 = new JLabel("KindHeartGifts");
		lblNewLabel_2.setForeground(new Color(224, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(121, 34, 232, 57);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setForeground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 487, 336);
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
