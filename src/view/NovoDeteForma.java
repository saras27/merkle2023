package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entity.Dete;
import entity.Podatak;
import kontroler.Kontroler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NovoDeteForma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_surname;
	private JTextField tf_address;
	private JTable table;
	private JTextField tf_Age;
	private int idDete;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTextField textField;

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
		lblNewLabel.setBounds(54, 38, 88, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname:");
		lblNewLabel_1.setBounds(54, 67, 70, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setBounds(54, 124, 70, 13);
		contentPane.add(lblNewLabel_2);
		
		tf_name = new JTextField();
		tf_name.setBounds(150, 35, 96, 19);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		tf_surname = new JTextField();
		tf_surname.setBounds(150, 64, 96, 19);
		contentPane.add(tf_surname);
		tf_surname.setColumns(10);
		
		tf_address = new JTextField();
		tf_address.setColumns(10);
		tf_address.setBounds(150, 121, 96, 19);
		contentPane.add(tf_address);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ime = tf_name.getText();
				String prezime = tf_surname.getText();
				String adresa = tf_address.getText();
				int godine = Integer.parseInt(tf_Age.getText());
				Kontroler.getInstanca().upisiDete(ime,prezime,godine,adresa);
				tf_name.setText("");
				tf_surname.setText("");
				tf_address.setText("");
				tf_Age.setText("");
				refresh();
			}
		});
		
//		btnCreate.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        String ime = tf_name.getText();
//		        String prezime = tf_surname.getText();
//		        String adresa = tf_address.getText();
//		        String ageText = tf_Age.getText();
//
//		        
//		        if (ime.isEmpty() || prezime.isEmpty() || adresa.isEmpty() || ageText.isEmpty()) {
//		          JOptionPane.showMessageDialog(NovoDeteForma.this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
//		          return; 
//		        }
//
//		        // All fields are filled, proceed with creating the entry
//		        int godine = Integer.parseInt(ageText);
//		        Kontroler.getInstanca().upisiDete(ime, prezime, godine, adresa);
//		        tf_name.setText("");
//		        tf_surname.setText("");
//		        tf_address.setText("");
//		        tf_Age.setText("");
//		        refresh();
//		    }
//		});
		btnCreate.setBounds(150, 225, 85, 21);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int red=table.getSelectedRow();
				idDete = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
				int godine = Integer.parseInt(tf_Age.getText());
				Kontroler.getInstanca().updateDete(idDete,tf_name.getText(),tf_surname.getText(),godine,tf_address.getText());
				refresh();
			}
		});
		btnUpdate.setBounds(54, 256, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int red=table.getSelectedRow();
				idDete = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
				Kontroler.getInstanca().deleteDete(idDete);
				refresh();
			}
		});
		btnDelete.setBounds(151, 256, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnNewWishlist = new JButton("New wishlist");
		btnNewWishlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaListaForma nlf = new NovaListaForma();
				nlf.setVisible(true);
			}
		});
		btnNewWishlist.setBounds(54, 287, 179, 21);
		contentPane.add(btnNewWishlist);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 35, 224, 243);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = table.getSelectedRow();
				tf_name.setText(table.getModel().getValueAt(red, 1).toString());
				tf_surname.setText(table.getModel().getValueAt(red, 2).toString());
				tf_Age.setText(table.getModel().getValueAt(red, 3).toString());
				tf_address.setText(table.getModel().getValueAt(red, 4).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setBounds(54, 95, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		tf_Age = new JTextField();
		tf_Age.setBounds(150, 92, 96, 19);
		contentPane.add(tf_Age);
		tf_Age.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Town:");
		lblNewLabel_4.setBounds(54, 153, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(150, 150, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Object[] kolone = {"ID","NAME","SURNAME","AGE","ADDRESS"};
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		
		refresh();
	}

	private void refresh() {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		for (Dete d : Kontroler.getInstanca().ucitajDecu()) {
			Object[] red = {d.getId(),d.getIme(),d.getPrezime(),d.getGodine(),d.getAdresa()};
			dtm.addRow(red);
		}
	}
	
	
}
