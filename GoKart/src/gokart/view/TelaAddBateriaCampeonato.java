package gokart.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import gokart.bo.BateriaBo;
import gokart.bo.BateriaCampeonatoBo;
import gokart.classes.Bateria;
import gokart.classes.BateriaCampeonato;
import gokart.classes.Campeonato;
import gokart.classes.Piloto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaAddBateriaCampeonato extends JFrame {

	private JPanel contentPane;
	private JLabel lblCampeonato;
	private JTextField txtCampeonato;
	private JTextField txtKartodromo;
	private JFormattedTextField txtData;
	private JTable tbResultado;
	private LocalDate localDate;
	private JButton btAddBat;
	private JTable tbBateriaCamp;
	private JButton btRemover;

	private DefaultTableModel modeloCamp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAddBateriaCampeonato frame = new TelaAddBateriaCampeonato(null, null);
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
	public TelaAddBateriaCampeonato(Piloto piloto, Campeonato camp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCampeonato = new JLabel("Campeonato:");
		lblCampeonato.setBounds(10, 11, 94, 14);
		contentPane.add(lblCampeonato);

		txtCampeonato = new JTextField();
		txtCampeonato.setEditable(false);
		txtCampeonato.setBounds(10, 36, 355, 20);
		contentPane.add(txtCampeonato);
		txtCampeonato.setColumns(10);

		JLabel lblKartodromo = new JLabel("Kart\u00F3dromo:");
		lblKartodromo.setBounds(10, 88, 94, 14);
		contentPane.add(lblKartodromo);

		txtKartodromo = new JTextField();
		txtKartodromo.setBounds(98, 85, 267, 20);
		contentPane.add(txtKartodromo);
		txtKartodromo.setColumns(10);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 116, 94, 14);
		contentPane.add(lblData);

		txtData = new JFormattedTextField();
		txtData.setBounds(98, 113, 144, 20);
		contentPane.add(txtData);
		txtData.setColumns(20);

		MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("##/##/####");
			maskData.install(txtData);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JButton btPesquisar = new JButton("Pesquisar");

		btPesquisar.setBounds(252, 112, 113, 23);
		contentPane.add(btPesquisar);

		JScrollPane pnScroll = new JScrollPane();
		pnScroll.setBounds(10, 141, 355, 200);
		contentPane.add(pnScroll);

		tbResultado = new JTable();
		tbResultado.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "Kart\u00F3dromo", "Nr Max Piloto", "Tra\u00E7ado", "Data", "Hora" }) {
			Class[] columnTypes = new Class[] { Object.class, Integer.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		pnScroll.setViewportView(tbResultado);

		btAddBat = new JButton("Add");
		btAddBat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btAddBat.setBounds(10, 352, 89, 23);
		contentPane.add(btAddBat);

		JScrollPane pnBateria = new JScrollPane();
		pnBateria.setBounds(10, 386, 355, 127);
		contentPane.add(pnBateria);

		tbBateriaCamp = new JTable();
		tbBateriaCamp.setModel(new DefaultTableModel(
				new Object[][] { { /* null, null, null, null, null }, { null, null, null, null, null */ }, },
				new String[] { "Kart\u00F3dromo", "Nr Max Piloto", "Tra\u00E7ado", "Data", "Hora" }) {
			Class[] columnTypes = new Class[] { Object.class, Integer.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		modeloCamp = (DefaultTableModel) tbBateriaCamp.getModel();
		modeloCamp.setRowCount(0);
		tbBateriaCamp.setModel(modeloCamp);
		
		

		pnBateria.setViewportView(tbBateriaCamp);

		JButton btSalvar = new JButton("Salvar");
		btSalvar.setBounds(10, 645, 89, 23);
		contentPane.add(btSalvar);

		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(109, 645, 89, 23);
		contentPane.add(btVoltar);

		btRemover = new JButton("Remover");

		btRemover.setBounds(10, 524, 89, 23);
		contentPane.add(btRemover);
		
		btPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAddBat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btRemover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		txtCampeonato.setText(camp.getNomeCampeonato());
		
		/*Eventos*/

		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisaBateria();

			}
		});

		/* Adiciona bateria no campeonato */
		btAddBat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String data;

				modeloCamp = (DefaultTableModel) tbBateriaCamp.getModel();

				/* Se existir campo selecionado, cria Bateria */
				if (!(tbResultado.getSelectedRow() < 0)) {

					Bateria b = (Bateria) tbResultado.getModel().getValueAt(tbResultado.getSelectedRow(), 0);

					data = b.getData().format(formatador);
					modeloCamp.addRow(new Object[] { b, b.getNrMaxPiloto(), b.getTracado(), data, b.getHoraBateria() });

					tbBateriaCamp.setModel(modeloCamp);
				}

			}
		});

		/* Remove bateria do Campeonato */
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modeloCamp = (DefaultTableModel) tbBateriaCamp.getModel();

				/* Se existir campo selecionado */
				if (!(tbBateriaCamp.getSelectedRow() < 0)) {
					modeloCamp.removeRow(tbBateriaCamp.getSelectedRow());
				}

				tbBateriaCamp.setModel(modeloCamp);

			}
		});
		
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				
				int i = 0;				
				for(i = 0; i < tbBateriaCamp.getModel().getRowCount(); i++) {
						
						BateriaCampeonato bCp = new BateriaCampeonato();
						
						bCp.setId_bateria((Bateria) tbBateriaCamp.getModel().getValueAt(i, 0));
						bCp.setId_campeonato(camp);
						
						BateriaCampeonatoBo bcpBo = new BateriaCampeonatoBo();
						
						try {
							bcpBo.Salvar(bCp);
						} catch (Exception e1) {			
							JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}					
					
				}							

			}
		});
		
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCampeonato tc = new TelaCampeonato(piloto);
				dispose();
			}
		});
		

	}

	public void PesquisaBateria() {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data;

		if (!txtData.getText().isBlank()) {
			localDate = LocalDate.parse(txtData.getText(), formatador);
		}

		DefaultTableModel modelo = (DefaultTableModel) this.tbResultado.getModel();
		/* tbResultado.setModel(modelo); */

		try {

			BateriaBo bBo = new BateriaBo();

			List<Bateria> lista = bBo.listarBateriasNome(txtKartodromo.getText(), localDate);

			modelo.setRowCount(0);
			for (Bateria b : lista) {

				data = b.getData().format(formatador);
				modelo.addRow(new Object[] { b, b.getNrMaxPiloto(), b.getTracado(), data, b.getHoraBateria() });

			}

			tbResultado.setModel(modelo);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
}
