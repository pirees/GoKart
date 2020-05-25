package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class TelaConfirmacaoBateria extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConfirmacaoBateria frame = new TelaConfirmacaoBateria();
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
	public TelaConfirmacaoBateria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoPiloto = new JLabel("Nome Pilot");
		lblNovoPiloto.setBounds(23, 32, 64, 14);
		contentPane.add(lblNovoPiloto);
		
		JLabel lblNvelPiloto = new JLabel("N\u00EDvel Piloto");
		lblNvelPiloto.setBounds(23, 49, 64, 14);
		contentPane.add(lblNvelPiloto);
		
		JLabel lblConfirmacao = new JLabel("Confirma\u00E7\u00E3o de Reserva");
		lblConfirmacao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmacao.setBounds(56, 122, 176, 25);
		contentPane.add(lblConfirmacao);
	}

}
