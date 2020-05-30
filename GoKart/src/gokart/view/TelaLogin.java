package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gokart.bo.KartodromoBo;
import gokart.bo.PilotoBo;
import gokart.classes.Kartodromo;
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
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtSenha;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	
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
		
		JRadioButton rdbtnPiloto = new JRadioButton("Piloto");
		buttonGroup.add(rdbtnPiloto);
		rdbtnPiloto.setBounds(67, 527, 109, 23);
		contentPane.add(rdbtnPiloto);
		
		JRadioButton rdbtnKartodromo = new JRadioButton("Kartodromo");
		buttonGroup.add(rdbtnKartodromo);
		rdbtnKartodromo.setBounds(67, 553, 109, 23);
		contentPane.add(rdbtnKartodromo);
		
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
				
				Kartodromo k = new Kartodromo();
				KartodromoBo kBo = new KartodromoBo();
				
				if(rdbtnPiloto.isSelected()) {
									
					try {					
						pi = pBo.ValidaLogin(txtUsername.getText(), txtSenha.getText());

						TelaMenuPiloto tm = new TelaMenuPiloto(pi);
						dispose();			

					} catch (Exception e2) {					
						JOptionPane.showMessageDialog(null, e2.getMessage(), "ERRO LOGIN", JOptionPane.ERROR_MESSAGE);
						e2.printStackTrace();
					}
				}else {
					try {					
						k = kBo.ValidaLogin(txtUsername.getText(), txtSenha.getText());
						
						TelaMenuKartodromo tm = new TelaMenuKartodromo(k);
						dispose();									
						
					} catch (Exception e2) {					
						JOptionPane.showMessageDialog(null, e2.getMessage(), "ERRO LOGIN", JOptionPane.ERROR_MESSAGE);
						e2.printStackTrace();
					}				
				}
								
			}
		});
	}
}
