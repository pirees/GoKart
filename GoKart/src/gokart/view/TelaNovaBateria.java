package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaNovaBateria extends JFrame {

	private JPanel contentPane;
	private JTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNovaBateria frame = new TelaNovaBateria();
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
	public TelaNovaBateria() {
		setTitle("Go Kart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nova Bateria");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(102, 50, 97, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblKartdromo = new JLabel("Kart\u00F3dromo");
		lblKartdromo.setBounds(29, 135, 86, 14);
		contentPane.add(lblKartdromo);
		
		JComboBox comboKartodromo = new JComboBox();
		comboKartodromo.setBounds(125, 131, 120, 22);
		contentPane.add(comboKartodromo);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(29, 192, 37, 14);
		contentPane.add(lblData);
		
		txtData = new JTextField();
		txtData.setBounds(125, 189, 120, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblHorario = new JLabel("Hor\u00E1rio");
		lblHorario.setBounds(29, 251, 64, 14);
		contentPane.add(lblHorario);
		
		JComboBox comboHorario = new JComboBox();
		comboHorario.setBounds(125, 247, 120, 22);
		contentPane.add(comboHorario);
		
		JLabel lblNmeroDePilotos = new JLabel("N\u00FAmero de Pilotos");
		lblNmeroDePilotos.setBounds(29, 310, 120, 14);
		contentPane.add(lblNmeroDePilotos);
		
		JComboBox comboNumPilotos = new JComboBox();
		comboNumPilotos.setBounds(181, 306, 64, 22);
		contentPane.add(comboNumPilotos);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(29, 414, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(172, 414, 89, 23);
		contentPane.add(btnCancelar);
	}

}
