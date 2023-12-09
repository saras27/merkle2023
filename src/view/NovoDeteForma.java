package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NovoDeteForma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_surname;
	private JTextField tf_address;
	private JTable table;
	private JTextField tf_Age;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public NovoDeteForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(54, 55, 88, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname:");
		lblNewLabel_1.setBounds(54, 95, 70, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setBounds(54, 158, 70, 13);
		contentPane.add(lblNewLabel_2);
		
		tf_name = new JTextField();
		tf_name.setBounds(140, 52, 96, 19);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		tf_surname = new JTextField();
		tf_surname.setBounds(140, 92, 96, 19);
		contentPane.add(tf_surname);
		tf_surname.setColumns(10);
		
		tf_address = new JTextField();
		tf_address.setColumns(10);
		tf_address.setBounds(140, 152, 96, 19);
		contentPane.add(tf_address);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(150, 198, 85, 21);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(57, 229, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(151, 229, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnNewWishlist = new JButton("New wishlist");
		btnNewWishlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaListaForma nlf = new NovaListaForma();
				nlf.setVisible(true);
			}
		});
		btnNewWishlist.setBounds(57, 260, 179, 21);
		contentPane.add(btnNewWishlist);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 35, 224, 243);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setBounds(54, 128, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		tf_Age = new JTextField();
		tf_Age.setBounds(140, 121, 96, 19);
		contentPane.add(tf_Age);
		tf_Age.setColumns(10);
	}
}
