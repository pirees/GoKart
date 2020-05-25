package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class TelaCadastroCampeonato extends JFrame {

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
					TelaCadastroCampeonato frame = new TelaCadastroCampeonato();
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
	public TelaCadastroCampeonato() {
		setTitle("GoKart - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblCadastro = new JLabel("Cadastro de Campeonato");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastro.setBounds(54, 29, 177, 20);
		contentPane.add(lblCadastro);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 453, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelarr");
		btnCancelar.setBounds(116, 453, 89, 23);
		contentPane.add(btnCancelar);
		
		textField = new JTextField();
		textField.setBounds(21, 93, 252, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeCampeonato = new JLabel("Nome Campeonato");
		lblNomeCampeonato.setBounds(22, 73, 96, 14);
		contentPane.add(lblNomeCampeonato);
		
		JLabel lblQuantidadeDeCorrida = new JLabel("Quantidade de Corrida");
		lblQuantidadeDeCorrida.setBounds(21, 124, 116, 14);
		contentPane.add(lblQuantidadeDeCorrida);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(21, 149, 50, 23);
		contentPane.add(comboBox);
		
		JLabel lblCampeonatoPblico = new JLabel("Campeonato P\u00FAblico?");
		lblCampeonatoPblico.setBounds(21, 183, 116, 14);
		contentPane.add(lblCampeonatoPblico);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Sim");
		rdbtnNewRadioButton.setBounds(21, 204, 50, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("N\u00E3o");
		rdbtnNo.setBounds(68, 204, 50, 23);
		contentPane.add(rdbtnNo);
		
		JLabel lblKartdromoResponsvel = new JLabel("Kart\u00F3dromo Respons\u00E1vel");
		lblKartdromoResponsvel.setBounds(21, 234, 131, 14);
		contentPane.add(lblKartdromoResponsvel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(21, 253, 252, 20);
		contentPane.add(textField_1);
		
		JLabel lblBaterias = new JLabel("Baterias");
		lblBaterias.setBounds(21, 284, 50, 14);
		contentPane.add(lblBaterias);
		
		table = new JTable();
		table.setBounds(21, 309, 252, 116);
		contentPane.add(table);
	}
}
