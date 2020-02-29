package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class telaPilotoCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaPilotoCadastro frame = new telaPilotoCadastro();
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
	public telaPilotoCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(64, 84, 48, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(64, 158, 48, 14);
		contentPane.add(lblSenha);
		
		JLabel lblApelido = new JLabel("Apelido");
		lblApelido.setBounds(64, 122, 48, 14);
		contentPane.add(lblApelido);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(64, 183, 48, 14);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(64, 220, 48, 14);
		contentPane.add(lblEstado);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(64, 255, 48, 14);
		contentPane.add(lblIdade);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(95, 342, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(229, 342, 89, 23);
		contentPane.add(btnVoltar);
		
		textField = new JTextField();
		textField.setBounds(120, 81, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 119, 96, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 155, 96, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(120, 180, 96, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(120, 217, 96, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(120, 252, 96, 20);
		contentPane.add(textField_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Piloto");
		rdbtnNewRadioButton.setBounds(448, 80, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnKartdromo = new JRadioButton("Kart\u00F3dromo");
		rdbtnKartdromo.setBounds(448, 106, 109, 23);
		contentPane.add(rdbtnKartdromo);
		
		JLabel lblNewLabel_1 = new JLabel("Eu sou:");
		lblNewLabel_1.setBounds(448, 59, 48, 14);
		contentPane.add(lblNewLabel_1);
	}
}
