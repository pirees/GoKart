package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaCadastroPiloto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtEndereco;
	private JTextField tctEmail;
	private JPasswordField txtSenha;
	private JPasswordField txtReptSenha;
	private JTextField txtCPF;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPiloto frame = new TelaCadastroPiloto();
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
	public TelaCadastroPiloto() {
		setTitle("GoKart - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 44, 36, 14);
		contentPane.add(lblNome);
		
		JLabel lblCadastro = new JLabel("Cadastro de Piloto");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastro.setBounds(76, 11, 134, 20);
		contentPane.add(lblCadastro);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 63, 271, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(10, 84, 36, 14);
		contentPane.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(10, 99, 56, 20);
		contentPane.add(txtIdade);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 168, 56, 14);
		contentPane.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 180, 271, 20);
		contentPane.add(txtEndereco);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 204, 56, 14);
		contentPane.add(lblEstado);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 299, 56, 14);
		contentPane.add(lblEmail);
		
		tctEmail = new JTextField();
		tctEmail.setColumns(10);
		tctEmail.setBounds(10, 313, 271, 20);
		contentPane.add(tctEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 344, 56, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 359, 271, 20);
		contentPane.add(txtSenha);
		
		JLabel lblRepetirSenha = new JLabel("Repetir Senha");
		lblRepetirSenha.setBounds(10, 390, 81, 14);
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
		comboEstado.setBounds(10, 221, 81, 22);
		contentPane.add(comboEstado);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 127, 56, 14);
		contentPane.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(10, 142, 271, 20);
		contentPane.add(txtCPF);
		
		JLabel lblNvel = new JLabel("N\u00EDvel");
		lblNvel.setBounds(10, 254, 56, 14);
		contentPane.add(lblNvel);
		
		JComboBox comboNivelPiloto = new JComboBox();
		comboNivelPiloto.setBounds(10, 269, 81, 22);
		contentPane.add(comboNivelPiloto);
	}

}
