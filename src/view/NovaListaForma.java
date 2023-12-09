package view;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Dete;
import kontroler.Kontroler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class NovaListaForma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_item;
	private String wishlist = "";
	private JTextArea textArea;
	private JComboBox comboBox_Child;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public NovaListaForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel.setBounds(40, 119, 45, 13);
		contentPane.add(lblNewLabel);
		
		tf_item = new JTextField();
		tf_item.setBounds(40, 142, 130, 19);
		contentPane.add(tf_item);
		tf_item.setColumns(10);
		
		JButton btnAddItem = new JButton("Add");
		btnAddItem.setBackground(new Color(221, 160, 221));
		btnAddItem.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wishlist=wishlist+"\n"+tf_item.getText();
				textArea.append(tf_item.getText()+"\n");
				tf_item.setText("");
			}
		});
		btnAddItem.setBounds(197, 141, 85, 21);
		contentPane.add(btnAddItem);
		
		textArea = new JTextArea();
		textArea.setBounds(300, 34, 221, 265);
		contentPane.add(textArea);
		
		comboBox_Child = new JComboBox();
		comboBox_Child.setBounds(40, 63, 242, 21);
		contentPane.add(comboBox_Child);
		
		JLabel lblNewLabel_1 = new JLabel("Select a child");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(40, 40, 90, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dete d = (Dete)comboBox_Child.getSelectedItem();
				Kontroler.getInstanca().dodajListu(d.getId(),wishlist);
				textArea.setText("");
				wishlist="";
			}
		});
		btnNewButton.setBounds(197, 184, 85, 21);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 570, 357);
		contentPane.add(panel);
		
		postaviPodatke();
	}


	
	private void postaviPodatke() {
		for(Dete d:Kontroler.getInstanca().ucitajDecu()) {
			comboBox_Child.addItem(d);
		}
	}
}
