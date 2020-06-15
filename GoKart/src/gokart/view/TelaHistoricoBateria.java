package gokart.view;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import gokart.bo.PilotoBateriaBo;
import gokart.classes.Piloto;
import gokart.classes.PilotoBateria;
import javax.swing.JLabel;

public class TelaHistoricoBateria extends JFrame {

	private JPanel contentPane;
	private JButton btnVoltar;
	private JTable table;
	private DefaultTableCellRenderer centralizado;
	private JScrollPane scrollPane;


	public TelaHistoricoBateria(Piloto piloto) {
		setTitle("GoKart  - Hist\u00F3rico de Baterias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setToolTipText("Voltar ");
		btnVoltar.setBounds(20, 31, 30, 29);
		btnVoltar.setIcon(new ImageIcon(TelaConvitesPendentes.class.getResource("/img/voltar - 32.png")));
		contentPane.add(btnVoltar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 104, 329, 381);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Kart\u00F3dromo", "Data", "Hor\u00E1rio", "Pilotos"
			}
		));
		
		//CENTRALIZANDO OS ITENS DA TABELA
		centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(1).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(2).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(3).setCellRenderer(centralizado);
		
		carregarReserva();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Aqui voc\u00EA pode verificar suas reservas j\u00E1 realizadas");
		lblNewLabel.setBounds(41, 79, 324, 14);
		contentPane.add(lblNewLabel);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				TelaMenuPiloto tmp = new TelaMenuPiloto(piloto);
				dispose();
			}
		});
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
	private void carregarReserva() {
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data;

		
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo); 

		try {
			List<PilotoBateria> lista = new PilotoBateriaBo().carregarReserva();
			for (PilotoBateria pb : lista) {
				data = pb.getBat().getData().format(formatador);
				modelo.addRow(new Object[] {
						pb.getBat().getKartodromo().getNome(),
						data,
						pb.getBat().getHoraBateria(),
						pb.getBat().getNrMaxPiloto(),
				});

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,  e.getMessage());
		}	

	}
}
