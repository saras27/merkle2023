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
import javax.swing.SwingConstants;

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
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel.setBounds(40, 96, 99, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(40, 134, 82, 13);
		contentPane.add(lblNewLabel_1);
		
		tf_user = new JTextField();
		tf_user.setBackground(new Color(255, 255, 255));
		tf_user.setBounds(127, 93, 145, 19);
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
		passwordField.setBounds(127, 131, 145, 19);
		
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Log As Admin");
		btnLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBounds(40, 188, 232, 21);
		contentPane.add(btnLogin);
		
		JButton btnExploreWishlists = new JButton("Explore Wishlists");
		btnExploreWishlists.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnExploreWishlists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExploreView ev = new ExploreView();
				ev.setVisible(true);
			}
		});
		btnExploreWishlists.setBounds(40, 219, 232, 21);
		contentPane.add(btnExploreWishlists);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 473, 325);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("KIND HEART GIFTS");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel_2.setBounds(162, 24, 143, 13);
		panel.add(lblNewLabel_2);
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
