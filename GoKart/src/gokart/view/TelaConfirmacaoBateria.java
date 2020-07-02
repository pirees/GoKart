package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

public class TelaConfirmacaoBateria extends JFrame {

	private JPanel contentPane;


	public TelaConfirmacaoBateria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoPiloto = new JLabel("Nome Piloto");
		lblNovoPiloto.setForeground(Color.ORANGE);
		lblNovoPiloto.setBackground(Color.ORANGE);
		lblNovoPiloto.setBounds(33, 67, 64, 14);
		contentPane.add(lblNovoPiloto);
		
		JLabel lblNvelPiloto = new JLabel("N\u00EDvel Piloto");
		lblNvelPiloto.setForeground(Color.ORANGE);
		lblNvelPiloto.setBackground(Color.ORANGE);
		lblNvelPiloto.setBounds(33, 85, 64, 14);
		contentPane.add(lblNvelPiloto);
		
		JLabel lblConfirmacao = new JLabel("Confirma\u00E7\u00E3o de Reserva");
		lblConfirmacao.setForeground(Color.ORANGE);
		lblConfirmacao.setBackground(Color.ORANGE);
		lblConfirmacao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmacao.setBounds(56, 122, 176, 25);
		contentPane.add(lblConfirmacao);
		
		JLabel lblKartodromoDAO = new JLabel("Kart\u00F3dromo Corrida Maluca");
		lblKartodromoDAO.setForeground(Color.ORANGE);
		lblKartodromoDAO.setBackground(Color.ORANGE);
		lblKartodromoDAO.setBounds(23, 190, 209, 14);
		contentPane.add(lblKartodromoDAO);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(Color.ORANGE);
		lblData.setBackground(Color.ORANGE);
		lblData.setBounds(23, 215, 30, 14);
		contentPane.add(lblData);
		
		JLabel lblQuantidadeDeCarros = new JLabel("Quantidade de Carros:");
		lblQuantidadeDeCarros.setForeground(Color.ORANGE);
		lblQuantidadeDeCarros.setBackground(Color.ORANGE);
		lblQuantidadeDeCarros.setBounds(23, 240, 116, 14);
		contentPane.add(lblQuantidadeDeCarros);
		
		JLabel lblQuanCarroDAO = new JLabel("02");
		lblQuanCarroDAO.setBounds(137, 240, 22, 14);
		contentPane.add(lblQuanCarroDAO);
		
		JLabel lblDataDAO = new JLabel("31/02/2020");
		lblDataDAO.setForeground(Color.ORANGE);
		lblDataDAO.setBackground(Color.ORANGE);
		lblDataDAO.setBounds(56, 215, 56, 14);
		contentPane.add(lblDataDAO);
		
		JLabel lblValor = new JLabel("Valor (R$):");
		lblValor.setForeground(Color.ORANGE);
		lblValor.setBackground(Color.ORANGE);
		lblValor.setBounds(23, 265, 56, 14);
		contentPane.add(lblValor);
		
		JLabel valorDAO = new JLabel("100,00");
		valorDAO.setForeground(Color.ORANGE);
		valorDAO.setBackground(Color.ORANGE);
		valorDAO.setBounds(80, 265, 45, 14);
		contentPane.add(valorDAO);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setForeground(Color.ORANGE);
		lblEndereo.setBackground(Color.ORANGE);
		lblEndereo.setBounds(23, 290, 56, 14);
		contentPane.add(lblEndereo);
		
		JLabel lblEnderecoDAO = new JLabel("Rio Grande do Sul");
		lblEnderecoDAO.setForeground(Color.ORANGE);
		lblEnderecoDAO.setBackground(Color.ORANGE);
		lblEnderecoDAO.setBounds(80, 290, 201, 14);
		contentPane.add(lblEnderecoDAO);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.setForeground(Color.ORANGE);
		btnConfirma.setBackground(Color.BLACK);
		btnConfirma.setBounds(23, 445, 89, 23);
		contentPane.add(btnConfirma);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(Color.ORANGE);
		btnVoltar.setToolTipText("Voltar ");
		btnVoltar.setIcon(new ImageIcon(TelaKartodromoBateria.class.getResource("/img/voltar - 32.png")));
		btnVoltar.setBounds(20, 31, 30, 29);
		contentPane.add(btnVoltar);
	}
}
