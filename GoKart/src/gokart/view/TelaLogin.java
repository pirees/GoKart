package gokart.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gokart.bo.KartodromoBo;
import gokart.bo.PilotoBo;
import gokart.classes.Kartodromo;
import gokart.classes.Piloto;
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
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtSenha;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btLogin;
	private JLabel lblCadastrar;
	private JLabel imgLogo;
	private JLabel lblCadastrarKartodromo;
	private JRadioButton rdbtnPiloto;
	private JRadioButton rdbtnKartodromo;

	public TelaLogin() {
		setTitle("GoKart - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);

		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsername = new JTextField();
		txtUsername.setBackground(Color.BLACK);
		txtUsername.setForeground(Color.ORANGE);
		txtUsername.setText("Email");
		txtUsername.setBounds(10, 335, 355, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setForeground(Color.ORANGE);
		txtSenha.setBackground(Color.BLACK);
		txtSenha.setText("Senha");
		txtSenha.setBounds(10, 357, 355, 20);
		contentPane.add(txtSenha);

		btLogin = new JButton("Entrar");		
		btLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				  btLogin.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				  btLogin.setBackground(Color.BLACK);
			}
		});
		btLogin.setBackground(Color.BLACK);
		btLogin.setForeground(Color.ORANGE);
		btLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btLogin.setBounds(276, 388, 89, 23);
		contentPane.add(btLogin);

		lblCadastrar = new JLabel("N\u00E3o tem conta? Efetue o cadastro...");
		lblCadastrar.setForeground(Color.ORANGE);
		lblCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCadastrar.setBounds(10, 435, 185, 14);
		contentPane.add(lblCadastrar);

		imgLogo = new JLabel("");
		imgLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/img/NovaLogo.png")));
		imgLogo.setBounds(50, 58, 287, 205);
		contentPane.add(imgLogo);

		lblCadastrarKartodromo = new JLabel("Gostaria de cadastrar um kart\u00F3dromo? Clique aqui");
		lblCadastrarKartodromo.setForeground(Color.ORANGE);
		lblCadastrarKartodromo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCadastrarKartodromo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCadastrarKartodromo.setBounds(10, 460, 230, 14);
		contentPane.add(lblCadastrarKartodromo);

		rdbtnPiloto = new JRadioButton("Piloto");
		rdbtnPiloto.setForeground(Color.ORANGE);
		rdbtnPiloto.setBackground(Color.BLACK);
		rdbtnPiloto.setSelected(true);
		buttonGroup.add(rdbtnPiloto);
		rdbtnPiloto.setBounds(10, 529, 109, 23);
		contentPane.add(rdbtnPiloto);

		rdbtnKartodromo = new JRadioButton("Kartódromo");
		rdbtnKartodromo.setBackground(Color.BLACK);
		rdbtnKartodromo.setForeground(Color.ORANGE);
		buttonGroup.add(rdbtnKartodromo);
		rdbtnKartodromo.setBounds(10, 555, 109, 23);
		contentPane.add(rdbtnKartodromo);

		this.setVisible(true);
		this.setLocationRelativeTo(null);

		/* Eventos */

		/* Label para cadastro de piloto */
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastroPiloto tcp = new TelaCadastroPiloto();
				dispose();
			}
		});

		/* Label para cadastro de kartodromo */
		lblCadastrarKartodromo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastroKartodromo tck = new TelaCadastroKartodromo();
				dispose();
			}
		});
		
		txtUsername.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtUsername.setText("");
            }
        });
		
		txtSenha.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtSenha.setText("");
            }
        });

		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
//		btLogin.addMouseListener(new MouseListener() {
//			   public void mouseExited(MouseEvent e) {
//			   btLogin.setBackground(Color.BLACK);
//			     }
//			   public void mouseClicked(MouseEvent e) {
//				   btLogin.setBackground(Color.WHITE);
//			     }
//		 	   public void mousePressed(MouseEvent e) {
//		 		  btLogin.setBackground(Color.WHITE);
//			    }
//			   public void mouseReleased(MouseEvent e) {
//				   btLogin.setBackground(Color.BLACK);
//			   }
//			   public void mouseEntered(MouseEvent e) {
//				   btLogin.setBackground(Color.ORANGE);
//			   }
//	    });
	}
	
	public void login() {

		try {
			
			if (rdbtnPiloto.isSelected()) {

				Piloto pi = new Piloto();
				PilotoBo pBo = new PilotoBo();

				pi = pBo.ValidaLogin(txtUsername.getText(), txtSenha.getText());

				TelaMenuPiloto tm = new TelaMenuPiloto(pi);
				dispose();
				
			} else {
				
				Kartodromo k = new Kartodromo();
				KartodromoBo kBo = new KartodromoBo();

				k = kBo.ValidaLogin(txtUsername.getText(), txtSenha.getText());

				TelaMenuKartodromo tm = new TelaMenuKartodromo(k);
				dispose();
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage(), "ERRO LOGIN", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}
}
