package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entity.Podatak;
import kontroler.Kontroler;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ExploreView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JButton btnNewButton;
	private JTextArea textArea;
	private int id_dete;
	private JTextField textField;
	private JButton btnPretrazi;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnAge;
	private JLabel from;
	private JLabel lblNewLabel;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExploreView frame = new ExploreView();
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
	public ExploreView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 41, 362, 271);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red=table.getSelectedRow();
				btnNewButton.setVisible(true);
				textArea.setText(table.getModel().getValueAt(red, 4).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		textArea = new JTextArea();
		textArea.setBounds(426, 37, 183, 176);
		contentPane.add(textArea);
		
		btnNewButton = new JButton("Choose to support");
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int red=table.getSelectedRow();
				id_dete = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
				KorisnikForma kf = new KorisnikForma(id_dete);
				kf.setVisible(true);
			}
		});
		btnNewButton.setBounds(426, 235, 183, 21);
		btnNewButton.setVisible(false);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ucitajPodatkePretrage(textField.getText());
			}
		});
		textField.setBounds(33, 339, 183, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnPretrazi = new JButton("Search cities");
		btnPretrazi.setBackground(new Color(221, 160, 221));
		btnPretrazi.setForeground(new Color(0, 0, 0));
		btnPretrazi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnPretrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucitajPodatkePretrage(textField.getText());
			}

			
		});
		btnPretrazi.setBounds(243, 338, 152, 21);
		contentPane.add(btnPretrazi);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBounds(542, 280, 67, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 0, 0));
		textField_2.setBounds(542, 309, 67, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnAge = new JButton("Filter");
		btnAge.setBackground(new Color(221, 160, 221));
		btnAge.setForeground(new Color(0, 0, 0));
		btnAge.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				filtriraj(textField.getText(),textField_1.getText(),textField_2.getText());
			}

		});
		btnAge.setBounds(426, 338, 187, 21);
		contentPane.add(btnAge);
		
		from = new JLabel("age from:");
		from.setBounds(454, 283, 67, 13);
		contentPane.add(from);
		
		lblNewLabel = new JLabel("age to:");
		lblNewLabel.setBounds(454, 312, 67, 13);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 664, 412);
		contentPane.add(panel);
		
		Object[] kolona = {"ID","NAME","AGE","CITY","WISHLIST"};
		dtm.addColumn(kolona[0]);
		dtm.addColumn(kolona[1]);
		dtm.addColumn(kolona[2]);
		dtm.addColumn(kolona[3]);
		dtm.addColumn(kolona[4]);
		
		prikaziPodatke();
	}

	private void prikaziPodatke() {
		dtm.setRowCount(0);
		for (Podatak p : Kontroler.getInstanca().ucitajPodatke()) {
			Object[] red = {p.getIdDete(),p.getIme(),p.getGodine(),p.getGrad(),p.getLista()};
			dtm.addRow(red);
		}
		
	}

	

	private void ucitajPodatkePretrage(String pretraga) {
		
		dtm.setRowCount(0);
		for (Podatak p : Kontroler.getInstanca().ucitajPodatkePretrage(pretraga)) {
			Object[] red = {p.getIdDete(),p.getIme(),p.getGodine(),p.getGrad(),p.getLista()};
			dtm.addRow(red);
		}
	}
	
	private void filtriraj(String grad, String odgod, String dogod) {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		for (Podatak p : Kontroler.getInstanca().filtriraj(grad,odgod,dogod)) {
			Object[] red = {p.getIdDete(),p.getIme(),p.getGodine(),p.getGrad(),p.getLista()};
			dtm.addRow(red);
		}
	}
}
