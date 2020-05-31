package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaCampeonato extends JFrame {

	private JPanel painel;
	private JTextField txtEmailPiloto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCampeonato frame = new TelaCampeonato();
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
	public TelaCampeonato() {
		setTitle("GoKart - Campeonato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
		
		JLabel lblCampeonato = new JLabel("Campeonato:");
		lblCampeonato.setBounds(10, 59, 88, 14);
		painel.add(lblCampeonato);
		
		JComboBox cbCampeonato = new JComboBox();
		cbCampeonato.setBounds(10, 84, 301, 22);
		painel.add(cbCampeonato);
		
		JButton btNovoCampeonato = new JButton("+");
		btNovoCampeonato.setBounds(10, 117, 41, 23);
		painel.add(btNovoCampeonato);
		
		JButton btnNewButton = new JButton("Pontua\u00E7\u00E3o");
		btnNewButton.setBounds(61, 117, 89, 23);
		painel.add(btnNewButton);
		
		JLabel lblCvPiloto = new JLabel("Convidar Piloto:");
		lblCvPiloto.setBounds(10, 151, 116, 14);
		painel.add(lblCvPiloto);
		
		txtEmailPiloto = new JTextField();
		txtEmailPiloto.setToolTipText("Ensira o e-mail do piloto para convida-lo ao campeonato.");
		txtEmailPiloto.setText("Email Piloto");
		txtEmailPiloto.setBounds(10, 176, 301, 20);
		painel.add(txtEmailPiloto);
		txtEmailPiloto.setColumns(10);
		
		JButton btEnviaConvite = new JButton("Send");
		btEnviaConvite.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btEnviaConvite.setBounds(321, 176, 44, 20);
		painel.add(btEnviaConvite);
	}
}
