package gokart.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaKartodromo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaKartodromo frame = new telaKartodromo();
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
	public telaKartodromo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastro");
		btnNewButton.setBounds(228, 137, 166, 72);
		contentPane.add(btnNewButton);
		
		JButton btnCampeonatos = new JButton("Campeonatos");
		btnCampeonatos.setBounds(92, 264, 166, 72);
		contentPane.add(btnCampeonatos);
		
		JButton btnAgenda = new JButton("Agenda");
		btnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgenda.setBounds(373, 264, 166, 72);
		contentPane.add(btnAgenda);
		
		JButton btnAvaliao = new JButton("Avalia\u00E7\u00E3o");
		btnAvaliao.setBounds(640, 264, 166, 72);
		contentPane.add(btnAvaliao);
		
		JButton btnConfigurao = new JButton("Configura\u00E7\u00E3o");
		btnConfigurao.setBounds(505, 137, 166, 72);
		contentPane.add(btnConfigurao);
		
		
	}
}
