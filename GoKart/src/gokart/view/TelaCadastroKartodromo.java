package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TelaCadastroKartodromo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCNPJ;
	private JTextField txtEndereco;
	private JTextField tctEmail;
	private JPasswordField txtSenha;
	private JPasswordField txtReptSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroKartodromo frame = new TelaCadastroKartodromo();
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
	public TelaCadastroKartodromo() {
		setTitle("GoKart - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 57, 36, 14);
		contentPane.add(lblNome);
		
		JLabel lblCadastro = new JLabel("Cadastro de Kart\u00F3dromo");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastro.setBounds(58, 27, 177, 20);
		contentPane.add(lblCadastro);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 73, 271, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(10, 104, 36, 14);
		contentPane.add(lblCnpj);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setColumns(10);
		txtCNPJ.setBounds(10, 124, 271, 20);
		contentPane.add(txtCNPJ);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 155, 56, 14);
		contentPane.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 180, 271, 20);
		contentPane.add(txtEndereco);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 211, 56, 14);
		contentPane.add(lblEstado);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 267, 56, 14);
		contentPane.add(lblEmail);
		
		tctEmail = new JTextField();
		tctEmail.setColumns(10);
		tctEmail.setBounds(10, 292, 271, 20);
		contentPane.add(tctEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 323, 56, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 348, 271, 20);
		contentPane.add(txtSenha);
		
		JLabel lblRepetirSenha = new JLabel("Repetir Senha");
		lblRepetirSenha.setBounds(10, 379, 81, 14);
		contentPane.add(lblRepetirSenha);
		
		txtReptSenha = new JPasswordField();
		txtReptSenha.setBounds(10, 404, 271, 20);
		contentPane.add(txtReptSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 453, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(116, 453, 89, 23);
		contentPane.add(btnCancelar);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setBounds(10, 236, 56, 22);
		contentPane.add(comboEstado);
	}
}
