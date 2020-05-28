package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gokart.bo.PilotoBo;
import gokart.classes.Piloto;
import gokart.dao.PilotoDao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtSenha;

	
	public TelaLogin() {
		setTitle("Login - GOKART");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(10, 335, 355, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Email:");
		lblUsername.setBounds(10, 310, 46, 14);
		contentPane.add(lblUsername);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 383, 46, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 408, 355, 20);
		contentPane.add(txtSenha);
		
		JButton btLogin = new JButton("Entrar");
		
		btLogin.setBounds(276, 432, 89, 23);
		contentPane.add(btLogin);
		
		JLabel lblCadastrar = new JLabel("N\u00E3o tem conta? Efetue o cadastro...");
		
		lblCadastrar.setForeground(Color.BLUE);
		lblCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCadastrar.setBounds(10, 436, 185, 14);
		contentPane.add(lblCadastrar);
		
		JLabel imgLogo = new JLabel("");
		imgLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/img/logo_pequena.png")));
		imgLogo.setBounds(22, 11, 326, 278);
		contentPane.add(imgLogo);
		
		JLabel lblCadastrarKartodromo = new JLabel("Gostaria de cadastrar um kart\u00F3dromo? Clique aqui");
		
		lblCadastrarKartodromo.setForeground(Color.BLUE);
		lblCadastrarKartodromo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCadastrarKartodromo.setBounds(10, 490, 230, 14);
		contentPane.add(lblCadastrarKartodromo);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		/*Eventos*/
		
		/*Label para cadastro de piloto*/
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaCadastroPiloto tcp = new TelaCadastroPiloto();
				dispose();
				
			}
		});
		
		/*Label para cadastro de kartodromo*/
		lblCadastrarKartodromo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				TelaCadastroKartodromo tck = new TelaCadastroKartodromo();
				dispose();				
			}
		});
		
		btLogin.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				Piloto pi = new Piloto();								
				PilotoBo pBo = new PilotoBo();	
				
				try {					
					pi = pBo.ValidaLogin(txtUsername.getText(), txtSenha.getText());
					
					TelaMenu tm = new TelaMenu(pi);
					dispose();			
					
					
				} catch (Exception e2) {					
					JOptionPane.showMessageDialog(null, e2.getMessage(), "ERRO LOGIN", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}				
								
			}
		});
		
	}
}
