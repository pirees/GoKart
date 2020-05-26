package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

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
		
		JLabel lblNovoPiloto = new JLabel("Nome Piloto");
		lblNovoPiloto.setBounds(23, 32, 64, 14);
		contentPane.add(lblNovoPiloto);
		
		JLabel lblNvelPiloto = new JLabel("N\u00EDvel Piloto");
		lblNvelPiloto.setBounds(23, 49, 64, 14);
		contentPane.add(lblNvelPiloto);
		
		JLabel lblConfirmacao = new JLabel("Confirma\u00E7\u00E3o de Reserva");
		lblConfirmacao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmacao.setBounds(56, 122, 176, 25);
		contentPane.add(lblConfirmacao);
		
		JLabel lblKartodromoDAO = new JLabel("Kart\u00F3dromo Corrida Maluca");
		lblKartodromoDAO.setBounds(23, 190, 209, 14);
		contentPane.add(lblKartodromoDAO);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(23, 215, 30, 14);
		contentPane.add(lblData);
		
		JLabel lblQuantidadeDeCarros = new JLabel("Quantidade de Carros:");
		lblQuantidadeDeCarros.setBounds(23, 240, 116, 14);
		contentPane.add(lblQuantidadeDeCarros);
		
		JLabel lblQuanCarroDAO = new JLabel("02");
		lblQuanCarroDAO.setBounds(137, 240, 22, 14);
		contentPane.add(lblQuanCarroDAO);
		
		JLabel lblDataDAO = new JLabel("31/02/2020");
		lblDataDAO.setBounds(56, 215, 56, 14);
		contentPane.add(lblDataDAO);
		
		JLabel lblValor = new JLabel("Valor (R$):");
		lblValor.setBounds(23, 265, 56, 14);
		contentPane.add(lblValor);
		
		JLabel valorDAO = new JLabel("100,00");
		valorDAO.setBounds(80, 265, 45, 14);
		contentPane.add(valorDAO);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(23, 290, 56, 14);
		contentPane.add(lblEndereo);
		
		JLabel lblEnderecoDAO = new JLabel("Rio Grande do Sul");
		lblEnderecoDAO.setBounds(80, 290, 201, 14);
		contentPane.add(lblEnderecoDAO);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.setBounds(23, 445, 89, 23);
		contentPane.add(btnConfirma);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.setBounds(122, 445, 89, 23);
		contentPane.add(btnCancelar);
	}
}
