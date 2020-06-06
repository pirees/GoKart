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

import gokart.classes.Bateria;
import gokart.classes.Piloto;
import gokart.classes.TableDataMover;
import gokart.dao.BateriaDao;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class TelaAddBateriaCampeonato extends JFrame {

	private JPanel contentPane;
	private JTable tbBateriaCampeonato;
	private JTable tbBateria;
	private List<Object[]> listaResultado = new ArrayList<>();

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
				{null},
			},
			new String[] {
				"Vagas Dispon\u00EDveis"
			}
		));
		tbBateria.getColumnModel().getColumn(0).setPreferredWidth(100);
		pnBateria.setViewportView(tbBateria);

		JScrollPane pnBateriaCampeonato = new JScrollPane();
		pnBateriaCampeonato.setBounds(437, 61, 318, 192);
		contentPane.add(pnBateriaCampeonato);

		tbBateriaCampeonato = new JTable();
		tbBateriaCampeonato.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, },
						new String[] { "Kart\u00F3dromo", "Data Corrida", "Hora Corrida", "Vagas Dispon\u00EDveis" }));
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

		/* Eventos */

		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCampeonato tc = new TelaCampeonato(piloto);
				dispose();

			}
		});

		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tbBateria.getSelectedRow();

				TableDataMover mover = new TableDataMover(tbBateria, tbBateriaCampeonato);
				mover.copy_row();

			}
		});

		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TableDataMover mover = new TableDataMover(tbBateria, tbBateriaCampeonato);
				mover.remove_row();

			}
		});
		
		CarregaDados();

	}

	public void CarregaDados() {

		BateriaDao bDao = new BateriaDao();

		try {
			for (Bateria b : bDao.ListaBateria()) {				
				listaResultado.add(new Object[] {b});
				
				System.out.println(b.getData());
			}
			
			tbBateria.setModel(new DefaultTableModel(
					listaResultado.toArray(new Object[listaResultado.size()][]),					
					new String[] {
						"Vagas Dispon\u00EDveis"
					}
				));
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
