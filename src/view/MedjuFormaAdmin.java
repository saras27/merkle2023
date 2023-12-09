package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class MedjuFormaAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public MedjuFormaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDodajDete = new JButton("New child");
		btnDodajDete.setBackground(new Color(221, 160, 221));
		btnDodajDete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnDodajDete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovoDeteForma ndf = new NovoDeteForma();
				ndf.setVisible(true);
			}
		});
		btnDodajDete.setBounds(135, 105, 168, 21);
		contentPane.add(btnDodajDete);
		
		JButton btnNewWishlist = new JButton("New wishlist");
		btnNewWishlist.setBackground(new Color(221, 160, 221));
		btnNewWishlist.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewWishlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaListaForma nlf = new NovaListaForma();
				nlf.setVisible(true);
			}
		});
		btnNewWishlist.setBounds(135, 154, 168, 21);
		contentPane.add(btnNewWishlist);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 478, 311);
		contentPane.add(panel);
	}

}
