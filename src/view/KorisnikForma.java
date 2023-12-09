package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KorisnikForma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_surname;
	private JTextField tf_phone;
	private int id_dete;
	private JLabel lblNewLabel_3;
	private JTextField tf_mail;

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroler.getInstanca().upisiKorisnika(tf_name.getText(),tf_surname.getText(),tf_mail.getText(),tf_phone.getText(),id_dete);
		        Kontroler.getInstanca().updateStatusDeteta(id_dete);
			}
		});
		btnNewButton.setBounds(209, 224, 85, 21);
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(48, 195, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		tf_mail = new JTextField();
		tf_mail.setBounds(143, 195, 151, 19);
		contentPane.add(tf_mail);
		tf_mail.setColumns(10);
	}

}