package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;

public class TelaMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(127, 622, 48, 14);
		contentPane.add(label);
		
		JLabel lblNomePiloto = new JLabel("Nome Piloto");
		lblNomePiloto.setBounds(22, 23, 107, 29);
		contentPane.add(lblNomePiloto);
		
		JLabel lblNivelPiloto = new JLabel("N\u00EDvel Piloto");
		lblNivelPiloto.setBounds(22, 63, 107, 29);
		contentPane.add(lblNivelPiloto);
		
		JLabel lblNewLabel = new JLabel("Kart\u00F3dromo");
		lblNewLabel.setBounds(22, 136, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(217, 136, 77, 14);
		contentPane.add(lblData);
		
		textField = new JTextField();
		textField.setBounds(22, 153, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(217, 153, 96, 20);
		contentPane.add(textField_1);
		
		table = new JTable();
		table.setBounds(22, 205, 325, 302);
		contentPane.add(table);
	}
}
