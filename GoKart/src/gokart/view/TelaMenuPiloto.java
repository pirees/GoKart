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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;

public class TelaMenuPiloto extends JFrame {

	private JPanel contentPane;
	private JTextField txtKartodromo;
	private JTextField txtData;
	private JTable table;
	private JLabel lblNomePiloto;
	private JLabel lblNivelPiloto;
	private JButton btnReserva;
	private JButton btnCampeonato;
	private JTextField txtEndereco;
	
	
	public TelaMenuPiloto(Piloto piloto) throws Exception {
		
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
	    lblNomePiloto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomePiloto.setBounds(56, 23, 160, 29);
		contentPane.add(lblNomePiloto);
		lblNomePiloto.setText(piloto.getNome());
		
		
		lblNivelPiloto = new JLabel("");
		lblNivelPiloto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNivelPiloto.setBounds(116, 51, 107, 29);
		contentPane.add(lblNivelPiloto);
		lblNivelPiloto.setText(piloto.getNivel().toString());
		
		JLabel lblKartodromo = new JLabel("Kart\u00F3dromo");
		lblKartodromo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKartodromo.setBounds(10, 163, 82, 16);
		contentPane.add(lblKartodromo);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 227, 77, 14);
		contentPane.add(lblData);
		
		txtKartodromo = new JTextField();
		txtKartodromo.setBounds(150, 163, 168, 20);
		contentPane.add(txtKartodromo);
		txtKartodromo.setColumns(10);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(150, 226, 168, 20);
		contentPane.add(txtData);
		
		table = new JTable();
		table.setBounds(10, 374, 355, 275);
		contentPane.add(table);
		
		JButton btnConvite = new JButton("");
		btnConvite.setToolTipText("Convites Pendentes");
		btnConvite.setBackground(Color.WHITE);
		btnConvite.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/convite-32.png")));
		btnConvite.setBounds(325, 23, 40, 35);
		contentPane.add(btnConvite);
		
		btnReserva = new JButton("");
		btnReserva.setToolTipText("Baterias");
		btnReserva.setBackground(Color.WHITE);
		btnReserva.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/bateria-32.png")));
		btnReserva.setBounds(325, 63, 40, 35);
		contentPane.add(btnReserva);
		
		btnCampeonato = new JButton("");
		btnCampeonato.setToolTipText("Novo Campeonato");
		btnCampeonato.setBackground(Color.WHITE);
		btnCampeonato.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/campeonato-32.png")));
		btnCampeonato.setBounds(325, 101, 40, 35);
		contentPane.add(btnCampeonato);
		
		JLabel lblHey = new JLabel("Olá,");
		lblHey.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHey.setBounds(22, 25, 40, 24);
		contentPane.add(lblHey);
		
		JLabel lblSeuNvel = new JLabel("Seu n\u00EDvel \u00E9:");
		lblSeuNvel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeuNvel.setBounds(22, 58, 107, 14);
		contentPane.add(lblSeuNvel);
		
		JLabel lblCorrida = new JLabel("Hora");
		lblCorrida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCorrida.setBounds(10, 289, 63, 20);
		contentPane.add(lblCorrida);
		
		JButton btnPesquisar = new JButton("Confirmar");
		btnPesquisar.setBounds(150, 333, 108, 29);
		contentPane.add(btnPesquisar);
		
		JComboBox comboHora = new JComboBox();
		comboHora.setBounds(150, 290, 97, 22);
		contentPane.add(comboHora);
		
		JComboBox comboNrMaxPilotos = new JComboBox();
		comboNrMaxPilotos.setBounds(150, 257, 63, 22);
		contentPane.add(comboNrMaxPilotos);
		
		JLabel lblNmeroDePilotos = new JLabel("N\u00FAmero de pilotos");
		lblNmeroDePilotos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmeroDePilotos.setBounds(10, 261, 130, 16);
		contentPane.add(lblNmeroDePilotos);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereo.setBounds(10, 196, 77, 20);
		contentPane.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(150, 195, 168, 20);
		contentPane.add(txtEndereco);
		
		JLabel lblNewLabel = new JLabel("Fa\u00E7a agora a sua reserva");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(92, 106, 180, 30);
		contentPane.add(lblNewLabel);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}
