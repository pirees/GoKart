package gokart.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import gokart.bo.KartodromoBo;
import gokart.classes.Kartodromo;
import gokart.viacep.WebServiceCep;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.SystemColor;

public class TelaCadastroKartodromo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCNPJ;
	private JTextField txtCNPJ_1;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JPasswordField txtReptSenha;
	private JTextField txtCidade;
	private JComboBox cbEstado;
	private JTextField txtCEP;
	private JTextField txtCEP_1;
	private JLabel lblNome;
	private JLabel lblCadastro;
	private JLabel lblCnpj;
	private JLabel lblEndereo;
	private JButton btnBuscar;
	private JLabel lblCep;
	private JLabel lblCidade;
	private JButton btnVoltar;
	private JButton btnSalvar;
	private JLabel lblRepetirSenha;
	private JLabel lblSenha;
	private JLabel lblEmail;
	private JLabel lblEstado;
	
	/**
	 * Create the frame.
	 */
	public TelaCadastroKartodromo() {
		setBackground(Color.BLACK);
		
		setTitle("GoKart - Cadastro Kart\u00F3dromo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.ORANGE);
		lblNome.setBackground(Color.ORANGE);
		lblNome.setBounds(10, 96, 36, 14);
		contentPane.add(lblNome);
		
		lblCadastro = new JLabel("Cadastro de Kart\u00F3dromo");
		lblCadastro.setForeground(Color.ORANGE);
		lblCadastro.setBackground(Color.ORANGE);
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastro.setBounds(97, 45, 177, 20);
		contentPane.add(lblCadastro);
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.ORANGE);
		txtNome.setBackground(Color.BLACK);
		txtNome.setBounds(10, 121, 296, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setForeground(Color.ORANGE);
		lblCnpj.setBackground(Color.ORANGE);
		lblCnpj.setBounds(10, 163, 36, 14);
		contentPane.add(lblCnpj);
		
		txtCNPJ = new JTextField();
		try {
			txtCNPJ_1 = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
			txtCNPJ_1.setForeground(Color.ORANGE);
			txtCNPJ_1.setBackground(Color.BLACK);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCNPJ_1.setColumns(10);
		txtCNPJ_1.setBounds(10, 188, 296, 20);
		contentPane.add(txtCNPJ_1);
		
		lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setForeground(Color.ORANGE);
		lblEndereo.setBackground(Color.ORANGE);
		lblEndereo.setBounds(10, 264, 56, 14);
		contentPane.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setBackground(Color.BLACK);
		txtEndereco.setForeground(Color.ORANGE);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 279, 296, 20);
		contentPane.add(txtEndereco);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.ORANGE);
		lblEstado.setBackground(Color.ORANGE);
		lblEstado.setBounds(10, 366, 56, 14);
		contentPane.add(lblEstado);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.ORANGE);
		lblEmail.setBackground(Color.ORANGE);
		lblEmail.setBounds(10, 424, 56, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.ORANGE);
		txtEmail.setBackground(Color.BLACK);
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 449, 296, 20);
		contentPane.add(txtEmail);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.ORANGE);
		lblSenha.setBackground(Color.ORANGE);
		lblSenha.setBounds(10, 484, 56, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setForeground(Color.ORANGE);
		txtSenha.setBackground(Color.BLACK);
		txtSenha.setBounds(10, 509, 296, 20);
		contentPane.add(txtSenha);
		
		lblRepetirSenha = new JLabel("Repetir Senha");
		lblRepetirSenha.setForeground(Color.ORANGE);
		lblRepetirSenha.setBackground(Color.ORANGE);
		lblRepetirSenha.setBounds(10, 553, 81, 14);
		contentPane.add(lblRepetirSenha);
		
		txtReptSenha = new JPasswordField();
		txtReptSenha.setForeground(Color.ORANGE);
		txtReptSenha.setBackground(Color.BLACK);
		txtReptSenha.setBounds(10, 578, 296, 20);
		contentPane.add(txtReptSenha);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalvar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalvar.setBackground(Color.BLACK);
			}
		});
		btnSalvar.setForeground(Color.ORANGE);
		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.setBounds(10, 645, 89, 23);
		contentPane.add(btnSalvar);
		
		btnVoltar = new JButton("");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVoltar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVoltar.setBackground(Color.ORANGE);
			}
		});
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(Color.ORANGE);
		btnVoltar.setToolTipText("Voltar ");
		btnVoltar.setIcon(new ImageIcon(TelaKartodromoBateria.class.getResource("/img/voltar - 32.png")));
		btnVoltar.setBounds(20, 31, 30, 29);
		contentPane.add(btnVoltar);
		
		cbEstado = new JComboBox();
		cbEstado.setForeground(Color.ORANGE);
		cbEstado.setBackground(Color.BLACK);
		cbEstado.setBounds(10, 391, 56, 22);
		contentPane.add(cbEstado);
		
		txtCidade = new JTextField();
		txtCidade.setForeground(Color.ORANGE);
		txtCidade.setBackground(Color.BLACK);
		txtCidade.setColumns(10);
		txtCidade.setBounds(10, 335, 296, 20);
		contentPane.add(txtCidade);
		
		lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(Color.ORANGE);
		lblCidade.setBackground(Color.ORANGE);
		lblCidade.setBounds(10, 310, 56, 14);
		contentPane.add(lblCidade);
		
		lblCep = new JLabel("CEP");
		lblCep.setForeground(Color.ORANGE);
		lblCep.setBackground(Color.ORANGE);
		lblCep.setBounds(10, 219, 56, 14);
		contentPane.add(lblCep);
		
		txtCEP = new JTextField();
		try {
			txtCEP_1 = new JFormattedTextField(new MaskFormatter("##.###-###"));
			txtCEP_1.setForeground(Color.ORANGE);
			txtCEP_1.setBackground(Color.BLACK);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCEP_1.setColumns(10);
		txtCEP_1.setBounds(10, 233, 128, 20);
		contentPane.add(txtCEP_1);
		
		
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setBackground(Color.BLACK);
			}
		});
		btnBuscar.setForeground(Color.ORANGE);
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();				
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
				salvarKartodromo();
				
				
			}
		});
	}
	
	public void buscarCep() {
		
		String cep = txtCEP_1.getText();
		WebServiceCep wsc = WebServiceCep.searchCep(cep);

		if(wsc.wasSuccessful()) {
			txtCidade.setText(wsc.getCidade());
			txtEndereco.setText(wsc.getLogradouro());
			cbEstado.addItem(wsc.getUf());

		} else {
			JOptionPane.showMessageDialog(null, wsc.getResultText());
		}
	}
	
	public void salvarKartodromo() {
		
		Kartodromo kartodromo = new Kartodromo();

		kartodromo.setNome(txtNome.getText());
		kartodromo.setCnpj(txtCNPJ_1.getText());
		kartodromo.setEndereco(txtEndereco.getText());
		kartodromo.setEmail(txtEmail.getText());
		kartodromo.setSenha(txtSenha.getText());
		kartodromo.setEstado(cbEstado.getSelectedItem().toString());

		KartodromoBo kartodromoBo = new KartodromoBo();
		
		

		try {
			JOptionPane.showMessageDialog(null, "Kartodromo " + kartodromoBo.Salvar(kartodromo));
			TelaLogin tl = new TelaLogin();
			dispose();
			

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERRO:" + e1.getMessage());
			e1.printStackTrace();
		}
	}
}
