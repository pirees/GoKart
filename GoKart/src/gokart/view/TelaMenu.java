package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import gokart.bo.PilotoBo;
import gokart.classes.Piloto;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;

public class TelaMenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtKartodromo;
	private JTextField txtData;
	private JTable table;
	private JLabel lblNomePiloto;
	
	
	public TelaMenu() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(127, 622, 48, 14);
		contentPane.add(label);
		
	    lblNomePiloto = new JLabel("");
		lblNomePiloto.setBounds(22, 23, 123, 29);
		contentPane.add(lblNomePiloto);
		ListarNomePiloto();
		
		
		JLabel lblNivelPiloto = new JLabel("");
		lblNivelPiloto.setBounds(22, 63, 107, 29);
		contentPane.add(lblNivelPiloto);
		//lblNivelPiloto.setText(String.valueOf(pb.listarNivel()));
		
		JLabel lblKartodromo = new JLabel("Kart\u00F3dromo");
		lblKartodromo.setBounds(22, 136, 77, 14);
		contentPane.add(lblKartodromo);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(217, 136, 77, 14);
		contentPane.add(lblData);
		
		txtKartodromo = new JTextField();
		txtKartodromo.setBounds(22, 153, 96, 20);
		contentPane.add(txtKartodromo);
		txtKartodromo.setColumns(10);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(217, 153, 96, 20);
		contentPane.add(txtData);
		
		table = new JTable();
		table.setBounds(22, 205, 325, 302);
		contentPane.add(table);
	}
	public void ListarNomePiloto() {
		
		PilotoBo pb = new PilotoBo();
		try {		
			lblNomePiloto.setText(String.valueOf(pb.listarPiloto()));		
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
		
	}
}
