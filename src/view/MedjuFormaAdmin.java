package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnDodajDete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovoDeteForma ndf = new NovoDeteForma();
				ndf.setVisible(true);
			}
		});
		btnDodajDete.setBounds(135, 105, 168, 21);
		contentPane.add(btnDodajDete);
		
		JButton btnNewWishlist = new JButton("New wishlist");
		btnNewWishlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaListaForma nlf = new NovaListaForma();
				nlf.setVisible(true);
			}
		});
		btnNewWishlist.setBounds(135, 154, 168, 21);
		contentPane.add(btnNewWishlist);
	}

}
