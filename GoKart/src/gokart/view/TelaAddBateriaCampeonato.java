package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gokart.classes.Piloto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class TelaAddBateriaCampeonato extends JFrame {

	private JPanel contentPane;
	private JTable tbBateria;
	private JTable tbBateriaCampeonato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAddBateriaCampeonato frame = new TelaAddBateriaCampeonato(null);
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
	public TelaAddBateriaCampeonato(Piloto piloto) {
		setTitle("GoKart - Adicionar Bateria Camepeonato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane pnBateria = new JScrollPane();
		pnBateria.setBounds(10, 61, 318, 192);
		contentPane.add(pnBateria);
		
		tbBateria = new JTable();
		tbBateria.setModel(new DefaultTableModel(
			new Object[][] {
				{"Kart do Lucas", "23/11/2020", "12:00:00", "20"},
				{null, null, null, null},
			},
			new String[] {
				"Kart\u00F3dromo", "Data Corrida", "Hora Corrida", "Vagas Dispon\u00EDveis"
			}
		));
		tbBateria.getColumnModel().getColumn(2).setPreferredWidth(73);
		tbBateria.getColumnModel().getColumn(3).setPreferredWidth(100);
		pnBateria.setViewportView(tbBateria);
		
		JScrollPane pnBateriaCampeonato = new JScrollPane();
		pnBateriaCampeonato.setBounds(437, 61, 318, 192);
		contentPane.add(pnBateriaCampeonato);
		
		tbBateriaCampeonato = new JTable();
		tbBateriaCampeonato.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Kart\u00F3dromo", "Data Corrida", "Hora Corrida", "Vagas Dispon\u00EDveis"
			}
		));
		tbBateriaCampeonato.getColumnModel().getColumn(0).setPreferredWidth(69);
		tbBateriaCampeonato.getColumnModel().getColumn(2).setPreferredWidth(72);
		tbBateriaCampeonato.getColumnModel().getColumn(3).setPreferredWidth(96);
		pnBateriaCampeonato.setViewportView(tbBateriaCampeonato);
		
		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAdicionar.setBounds(338, 110, 89, 23);
		contentPane.add(btAdicionar);
		
		JButton btRemover = new JButton("Remover");
		btRemover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btRemover.setBounds(338, 144, 89, 23);
		contentPane.add(btRemover);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btVoltar.setBounds(338, 178, 89, 23);
		contentPane.add(btVoltar);	
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		/*Eventos*/
		
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCampeonato tc = new TelaCampeonato(piloto);
				dispose();
				
				
				
			}
		});
		
	}
}
