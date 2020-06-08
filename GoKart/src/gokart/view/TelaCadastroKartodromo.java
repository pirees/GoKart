package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import gokart.bo.KartodromoBo;
import gokart.classes.Estado;
import gokart.classes.Kartodromo;
import gokart.dao.EstadoDao;
import gokart.viacep.WebServiceCep;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.SystemColor;

public class TelaCadastroKartodromo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCNPJ;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JPasswordField txtReptSenha;
	private JTextField txtCidade;
	private JComboBox cbEstado;
	private JTextField txtCEP;

	/**
	 * Create the frame.
	 */
	public TelaCadastroKartodromo() {
		
		setTitle("GoKart - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 96, 36, 14);
		contentPane.add(lblNome);
		
		JLabel lblCadastro = new JLabel("Cadastro de Kart\u00F3dromo");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastro.setBounds(97, 45, 177, 20);
		contentPane.add(lblCadastro);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 121, 296, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(10, 163, 36, 14);
		contentPane.add(lblCnpj);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setColumns(10);
		txtCNPJ.setBounds(10, 188, 296, 20);
		contentPane.add(txtCNPJ);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 264, 56, 14);
		contentPane.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 279, 296, 20);
		contentPane.add(txtEndereco);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 366, 56, 14);
		contentPane.add(lblEstado);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 424, 56, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 449, 296, 20);
		contentPane.add(txtEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 484, 56, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 509, 296, 20);
		contentPane.add(txtSenha);
		
		JLabel lblRepetirSenha = new JLabel("Repetir Senha");
		lblRepetirSenha.setBounds(10, 553, 81, 14);
		contentPane.add(lblRepetirSenha);
		
		txtReptSenha = new JPasswordField();
		txtReptSenha.setBounds(10, 578, 296, 20);
		contentPane.add(txtReptSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 645, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(122, 645, 89, 23);
		contentPane.add(btnVoltar);
		
		cbEstado = new JComboBox();
		cbEstado.setBounds(10, 391, 56, 22);
		contentPane.add(cbEstado);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(10, 335, 296, 20);
		contentPane.add(txtCidade);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 310, 56, 14);
		contentPane.add(lblCidade);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 219, 56, 14);
		contentPane.add(lblCep);
		
		txtCEP = new JTextField();
		try {
			txtCEP = new JFormattedTextField(new MaskFormatter("##.###-###"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCEP.setColumns(10);
		txtCEP.setBounds(10, 233, 128, 20);
		contentPane.add(txtCEP);
		
		/*Carrega dados nas ComboBox*/		
		LoadCb();
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cep = txtCEP.getText();
				WebServiceCep wsc = WebServiceCep.searchCep(cep);

				if(wsc.wasSuccessful()) {
					txtCidade.setText(wsc.getCidade());
					txtEndereco.setText(wsc.getLogradouro());
					cbEstado.addItem(wsc.getUf());

				} else {
					JOptionPane.showMessageDialog(null, wsc.getResultText());
				}

			}
		});
		btnBuscar.setBounds(158, 232, 89, 23);
		contentPane.add(btnBuscar);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		/* Botão Cancelar */
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaLogin tl = new TelaLogin();
				dispose();

			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Kartodromo kartodromo = new Kartodromo();

				kartodromo.setNome(txtNome.getText());
				kartodromo.setCnpj(Integer.parseInt(txtCNPJ.getText()));
				kartodromo.setEndereco(txtEndereco.getText());
				kartodromo.setEmail(txtEmail.getText());
				kartodromo.setSenha(txtSenha.getText());
				kartodromo.setEst((Estado) cbEstado.getSelectedItem());

				KartodromoBo kartodromoBo = new KartodromoBo();

				try {

					JOptionPane.showMessageDialog(null, "Kartodromo " + kartodromoBo.Salvar(kartodromo));

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO:" + e1.getMessage());
					e1.printStackTrace();
				}

			}
		});
	}
	public void LoadCb() {		
		EstadoDao eDao = new EstadoDao();
		
		for(Estado e: eDao.LoadEstado()) {
			cbEstado.addItem(e);			
		}
	}
}
