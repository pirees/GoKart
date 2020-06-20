package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNome = new JLabel("Nome completo:");
		lblNome.setBounds(10, 42, 125, 14);
		contentPane.add(lblNome);

		lblCadastro = new JLabel("Cadastro de Piloto");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastro.setBounds(109, 11, 134, 20);
		contentPane.add(lblCadastro);

		txtNome = new JTextField();
		txtNome.setBounds(10, 67, 271, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 98, 36, 14);
		contentPane.add(lblIdade);

		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(10, 123, 56, 20);
		contentPane.add(txtIdade);

		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 257, 89, 14);
		contentPane.add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 274, 271, 20);
		contentPane.add(txtEndereco);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 357, 56, 14);
		contentPane.add(lblEstado);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 456, 56, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 481, 271, 20);
		contentPane.add(txtEmail);

		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 512, 56, 14);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 537, 271, 20);
		contentPane.add(txtSenha);

		txtReptSenha = new JPasswordField();
		txtReptSenha.setBounds(10, 592, 271, 20);
		contentPane.add(txtReptSenha);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 645, 89, 23);
		contentPane.add(btnSalvar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(109, 645, 89, 23);
		contentPane.add(btnVoltar);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 154, 56, 14);
		contentPane.add(lblCpf);

		txtCPF = new JTextField();
		try {
			txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCPF.setColumns(10);
		txtCPF.setBounds(10, 170, 271, 20);
		contentPane.add(txtCPF);

		lblNvel = new JLabel("N\u00EDvel:");
		lblNvel.setBounds(10, 403, 56, 14);
		contentPane.add(lblNvel);

		cbNivelPiloto = new JComboBox();
		cbNivelPiloto.setBounds(10, 423, 125, 22);
		contentPane.add(cbNivelPiloto);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 305, 46, 14);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBounds(10, 326, 271, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtCEP = new JTextField();
		try {
			txtCEP = new JFormattedTextField(new MaskFormatter("##.###-###"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCEP.setBounds(10, 226, 119, 20);
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);
		
		btnBuscarCep = new JButton("BUSCAR");
		btnBuscarCep.setBounds(139, 225, 89, 23);
		contentPane.add(btnBuscarCep);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 201, 36, 14);
		contentPane.add(lblCep);
		
		cbEstado = new JComboBox();
		cbEstado.setBounds(10, 373, 57, 22);
		contentPane.add(cbEstado);
		
		lblRepetirSenha = new JLabel("Repetir Senha:");
		lblRepetirSenha.setBounds(10, 568, 89, 14);
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

		/* Bot�o Voltar */
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
			JOptionPane.showMessageDialog(null, "Aten��o:" + e1.getMessage());
			e1.printStackTrace();
		}		
	}
}
