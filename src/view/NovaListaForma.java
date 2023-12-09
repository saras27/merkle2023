package view;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovaListaForma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_item;
	private String wishlist = "";
	private JTextArea textArea;


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
		lblNewLabel.setBounds(40, 119, 45, 13);
		contentPane.add(lblNewLabel);
		
		tf_item = new JTextField();
		tf_item.setBounds(40, 142, 130, 19);
		contentPane.add(tf_item);
		tf_item.setColumns(10);
		
		JButton btnAddItem = new JButton("Add");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wishlist=wishlist+"\n"+tf_item.getText();
				textArea.append(tf_item.getText());
			}
		});
		btnAddItem.setBounds(197, 141, 85, 21);
		contentPane.add(btnAddItem);
		
		textArea = new JTextArea();
		textArea.setBounds(300, 34, 221, 265);
		contentPane.add(textArea);
		
		JComboBox comboBox_Child = new JComboBox();
		comboBox_Child.setBounds(40, 63, 242, 21);
		contentPane.add(comboBox_Child);
		
		JLabel lblNewLabel_1 = new JLabel("Select a child");
		lblNewLabel_1.setBounds(40, 40, 90, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(197, 184, 85, 21);
		contentPane.add(btnNewButton);
	}
}
