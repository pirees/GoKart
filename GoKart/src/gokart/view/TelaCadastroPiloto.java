package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gokart.bo.PilotoBo;
import gokart.classes.Estado;
import gokart.classes.Nivel;
import gokart.classes.Piloto;
import gokart.dao.EstadoDao;
import gokart.dao.NivelDao;

import java.awt.event.ActionListener;
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
	private JComboBox cbEstado;
	private JComboBox cbNivelPiloto;

	public TelaCadastroPiloto() {
		setTitle("GoKart - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome completo:");
		lblNome.setBounds(10, 42, 125, 14);
		contentPane.add(lblNome);

		JLabel lblCadastro = new JLabel("Cadastro de Piloto");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastro.setBounds(109, 11, 134, 20);
		contentPane.add(lblCadastro);

		txtNome = new JTextField();
		txtNome.setBounds(10, 67, 271, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 98, 36, 14);
		contentPane.add(lblIdade);

		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(10, 123, 56, 20);
		contentPane.add(txtIdade);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 210, 56, 14);
		contentPane.add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 235, 271, 20);
		contentPane.add(txtEndereco);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 324, 56, 14);
		contentPane.add(lblEstado);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 440, 56, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 465, 271, 20);
		contentPane.add(txtEmail);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 496, 56, 14);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 521, 271, 20);
		contentPane.add(txtSenha);

		JLabel lblRepetirSenha = new JLabel("Repetir Senha:");
<<<<<<< HEAD
		lblRepetirSenha.setBounds(10, 552, 89, 14);
=======
		lblRepetirSenha.setBounds(10, 552, 113, 14);
>>>>>>> branch 'master' of https://github.com/pirees/GoKart.git
		contentPane.add(lblRepetirSenha);

		txtReptSenha = new JPasswordField();
		txtReptSenha.setBounds(10, 577, 271, 20);
		contentPane.add(txtReptSenha);

		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.setBounds(10, 645, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(109, 645, 89, 23);
		contentPane.add(btnVoltar);

		cbEstado = new JComboBox();
		cbEstado.setBounds(10, 349, 81, 22);
		contentPane.add(cbEstado);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 154, 56, 14);
		contentPane.add(lblCpf);

		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(10, 179, 271, 20);
		contentPane.add(txtCPF);

		JLabel lblNvel = new JLabel("N\u00EDvel:");
		lblNvel.setBounds(10, 382, 56, 14);
		contentPane.add(lblNvel);

		cbNivelPiloto = new JComboBox();
		cbNivelPiloto.setBounds(10, 407, 125, 22);
		contentPane.add(cbNivelPiloto);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 266, 46, 14);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBounds(10, 291, 271, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		/*Carrega dados nas ComboBox*/		
		LoadCb();

		/* Eventos */

		/* Salvar dados via BO */
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Piloto piloto = new Piloto();

				piloto.setNome(txtNome.getText());
				piloto.setEndereco(txtEndereco.getText());
				piloto.setCidade(txtCidade.getText());
				piloto.setIdade(Integer.parseInt(txtIdade.getText()));
				piloto.setNivel((Nivel) cbNivelPiloto.getSelectedItem());
				piloto.setEmail(txtEmail.getText());
				piloto.setSenha(txtSenha.getText());
				piloto.setUf((Estado) cbEstado.getSelectedItem());

				PilotoBo pBo = new PilotoBo();

				try {

					JOptionPane.showMessageDialog(null, "Piloto " + pBo.Salvar(piloto));

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO:" + e1.getMessage());
					e1.printStackTrace();
				}

			}
		});

		/* Botão Voltar */
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaLogin tl = new TelaLogin();
				dispose();
			}
		});

	}
	
	
	public void LoadCb() {		
		EstadoDao eDao = new EstadoDao();
		
		for(Estado e: eDao.LoadEstado()) {
			cbEstado.addItem(e);			
		}	
		
		
		NivelDao nDao = new NivelDao();
		
		for(Nivel n: nDao.LoadNivel()) {
			cbNivelPiloto.addItem(n);		
		}		
		
	}
	
	
}
