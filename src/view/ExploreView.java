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

public class ExploreView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JButton btnNewButton;
	private JTextArea textArea;
	private int id_dete;
	

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
		scrollPane.setBounds(33, 41, 362, 302);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red=table.getSelectedRow();
				btnNewButton.setVisible(true);
				textArea.setText(table.getModel().getValueAt(red, 2).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		textArea = new JTextArea();
		textArea.setBounds(426, 37, 183, 307);
		contentPane.add(textArea);
		
		btnNewButton = new JButton("Choose");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(310, 353, 85, 21);
		btnNewButton.setVisible(false);
		contentPane.add(btnNewButton);
		
		Object[] kolona = {"NAME","AGE","CITY","WISHLIST"};
		dtm.addColumn(kolona[0]);
		dtm.addColumn(kolona[1]);
		dtm.addColumn(kolona[2]);
		dtm.addColumn(kolona[3]);
		
		prikaziPodatke();
	}

	private void prikaziPodatke() {
		dtm.setRowCount(0);
		for (Podatak p : Kontroler.getInstanca().ucitajPodatke()) {
			Object[] red = {p.getIme(),p.getGodine(),p.getGrad(),p.getLista()};
			dtm.addRow(red);
		}
		
	}

	

}
