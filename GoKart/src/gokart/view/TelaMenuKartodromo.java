package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gokart.classes.Kartodromo;

import javax.swing.JButton;

public class TelaMenuKartodromo extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public TelaMenuKartodromo(Kartodromo k) {
		setTitle("GoKart  - Menu - Kartodromo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfigurarReserva = new JButton("Configurar Reserva");
		btnConfigurarReserva.setBounds(127, 194, 127, 37);
		contentPane.add(btnConfigurarReserva);
		
		btnConfigurarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaKartodromoBateria tl = new TelaKartodromoBateria(k);
				dispose();

			}
		});
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
