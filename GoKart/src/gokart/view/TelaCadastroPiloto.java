package gokart.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import gokart.bo.PilotoBo;
import gokart.classes.Nivel;
import gokart.classes.Piloto;
import gokart.dao.NivelDao;
import gokart.viacep.WebServiceCep;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaCadastroPiloto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JPasswordField txtReptSenha;
	private JTextField txtCPF;
	private JTextField txtCidade;
	private JComboBox cbNivelPiloto;
	private JComboBox cbEstado;
	private JTextField txtCEP;
	private JLabel lblIdade;
	private JLabel lblEndereo;
	private JLabel lblEstado;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JLabel lblNome;
	private JLabel lblCadastro;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private JLabel lblCpf;
	private JLabel lblNvel;
	private JLabel lblCidade;
	private JButton btnBuscarCep;
	private JLabel lblCep;
	private JLabel lblRepetirSenha;

	public TelaCadastroPiloto() {
		setTitle("GoKart - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNome = new JLabel("Nome completo");
		lblNome.setForeground(Color.ORANGE);
		lblNome.setBackground(Color.ORANGE);
		lblNome.setBounds(10, 68, 125, 14);
		contentPane.add(lblNome);

		lblCadastro = new JLabel("Cadastro de Piloto");
		lblCadastro.setForeground(Color.ORANGE);
		lblCadastro.setBackground(Color.ORANGE);
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastro.setBounds(125, 37, 134, 20);
		contentPane.add(lblCadastro);

		txtNome = new JTextField();
		txtNome.setBounds(10, 93, 271, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		lblIdade = new JLabel("Idade");
		lblIdade.setBackground(Color.ORANGE);
		lblIdade.setForeground(Color.ORANGE);
		lblIdade.setBounds(10, 124, 36, 14);
		contentPane.add(lblIdade);

		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(10, 149, 56, 20);
		contentPane.add(txtIdade);

		lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBackground(Color.ORANGE);
		lblEndereo.setForeground(Color.ORANGE);
		lblEndereo.setBounds(10, 285, 89, 14);
		contentPane.add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 302, 271, 20);
		contentPane.add(txtEndereco);

		lblEstado = new JLabel("Estado");
		lblEstado.setBackground(Color.ORANGE);
		lblEstado.setForeground(Color.ORANGE);
		lblEstado.setBounds(10, 385, 56, 14);
		contentPane.add(lblEstado);

		lblEmail = new JLabel("E-mail");
		lblEmail.setBackground(Color.ORANGE);
		lblEmail.setForeground(Color.ORANGE);
		lblEmail.setBounds(10, 492, 56, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 509, 271, 20);
		contentPane.add(txtEmail);

		lblSenha = new JLabel("Senha");
		lblSenha.setBackground(Color.ORANGE);
		lblSenha.setForeground(Color.ORANGE);
		lblSenha.setBounds(10, 540, 56, 14);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 555, 271, 20);
		contentPane.add(txtSenha);

		txtReptSenha = new JPasswordField();
		txtReptSenha.setBounds(10, 600, 271, 20);
		contentPane.add(txtReptSenha);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.ORANGE);
		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setBounds(10, 645, 89, 23);
		contentPane.add(btnSalvar);

		btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(Color.ORANGE);
		btnVoltar.setToolTipText("Voltar ");
		btnVoltar.setIcon(new ImageIcon(TelaKartodromoBateria.class.getResource("/img/voltar - 32.png")));
		btnVoltar.setBounds(20, 31, 30, 29);
		contentPane.add(btnVoltar);

		lblCpf = new JLabel("CPF");
		lblCpf.setBackground(Color.ORANGE);
		lblCpf.setForeground(Color.ORANGE);
		lblCpf.setBounds(10, 180, 56, 14);
		contentPane.add(lblCpf);

		txtCPF = new JTextField();
		try {
			txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCPF.setColumns(10);
		txtCPF.setBounds(10, 196, 271, 20);
		contentPane.add(txtCPF);

		lblNvel = new JLabel("N\u00EDvel");
		lblNvel.setBackground(Color.ORANGE);
		lblNvel.setForeground(Color.ORANGE);
		lblNvel.setBounds(10, 434, 56, 14);
		contentPane.add(lblNvel);

		cbNivelPiloto = new JComboBox();
		cbNivelPiloto.setBounds(10, 459, 125, 22);
		contentPane.add(cbNivelPiloto);

		lblCidade = new JLabel("Cidade");
		lblCidade.setBackground(Color.ORANGE);
		lblCidade.setForeground(Color.ORANGE);
		lblCidade.setBounds(10, 333, 46, 14);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBounds(10, 354, 271, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtCEP = new JTextField();
		try {
			txtCEP = new JFormattedTextField(new MaskFormatter("##.###-###"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCEP.setBounds(10, 252, 119, 20);
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);
		
		btnBuscarCep = new JButton("BUSCAR");
		btnBuscarCep.setForeground(Color.ORANGE);
		btnBuscarCep.setBackground(Color.BLACK);
		btnBuscarCep.setBounds(139, 251, 89, 23);
		contentPane.add(btnBuscarCep);
		
		lblCep = new JLabel("CEP");
		lblCep.setForeground(Color.ORANGE);
		lblCep.setBackground(Color.ORANGE);
		lblCep.setBounds(10, 227, 36, 14);
		contentPane.add(lblCep);
		
		cbEstado = new JComboBox();
		cbEstado.setBounds(10, 401, 57, 22);
		contentPane.add(cbEstado);
		
		lblRepetirSenha = new JLabel("Repetir Senha");
		lblRepetirSenha.setForeground(Color.ORANGE);
		lblRepetirSenha.setBackground(Color.ORANGE);
		lblRepetirSenha.setBounds(10, 586, 89, 14);
		contentPane.add(lblRepetirSenha);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		/*Carrega dados nas ComboBox*/		
		LoadCb();

		/* Eventos */

		/* Salvar dados via BO */
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validaCPF();
				salvarPiloto();
			}
		});

		/* Botão Voltar */
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				TelaLogin tl = new TelaLogin();
				dispose();
			}
		});
		
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			    buscarCep();
			}
		});

	}
	
	
	public void LoadCb() {			
		NivelDao nDao = new NivelDao();
		
		for(Nivel n: nDao.LoadNivel()) {
			cbNivelPiloto.addItem(n);		
		}		
		
	}
	
	public void buscarCep() {
		
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
	
	public void salvarPiloto() {		
		
		Piloto piloto = new Piloto();

		piloto.setNome(txtNome.getText());
		piloto.setEndereco(txtEndereco.getText());
		piloto.setCpf(txtCPF.getText());
		piloto.setCidade(txtCidade.getText());
		piloto.setIdade(Integer.parseInt(txtIdade.getText()));
		piloto.setNivel((Nivel) cbNivelPiloto.getSelectedItem());
		piloto.setEmail(txtEmail.getText());
		piloto.setSenha(txtSenha.getText());
		piloto.setReSenha(txtReptSenha.getText());
		piloto.setEstado(cbEstado.getSelectedItem().toString());

		PilotoBo pBo = new PilotoBo();
		
		try {
			JOptionPane.showMessageDialog(null, "Piloto " + pBo.Salvar(piloto));

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Atenção:" + e1.getMessage());
			e1.printStackTrace();
		}		
	}
}
