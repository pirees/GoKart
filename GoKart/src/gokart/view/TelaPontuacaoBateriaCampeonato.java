package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gokart.bo.BateriaCampeonatoBo;
import gokart.bo.PilotoCampeonatoBo;
import gokart.classes.BateriaCampeonato;
import gokart.classes.Campeonato;
import gokart.classes.PilotoCampeonato;

import javax.swing.JButton;
import java.awt.Cursor;

public class TelaPontuacaoBateriaCampeonato extends JFrame {

	private JPanel contentPane;
	private JLabel lblBateria;
	private JComboBox cbBateriaCampeonato;
	private JLabel lblData;
	private JTextField txtKartodromo;
	private JTextField txtData;
	private JTable tbPontuacao;

	private List<BateriaCampeonato> listaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPontuacaoBateriaCampeonato frame = new TelaPontuacaoBateriaCampeonato(null);
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
	public TelaPontuacaoBateriaCampeonato(Campeonato cp) {
		setTitle("GoKart - Cadastro Pontua\u00E7\u00E3o Campeonato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblBateria = new JLabel("Bateria:");
		lblBateria.setBounds(10, 37, 72, 14);
		contentPane.add(lblBateria);

		cbBateriaCampeonato = new JComboBox();
		cbBateriaCampeonato.setBounds(10, 62, 355, 22);
		contentPane.add(cbBateriaCampeonato);

		lblData = new JLabel("Data Corrida:");
		lblData.setBounds(10, 95, 87, 14);
		contentPane.add(lblData);

		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBounds(10, 115, 101, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);

		JLabel lblKartodromo = new JLabel("Kart\u00F3dromo:");
		lblKartodromo.setBounds(144, 95, 79, 14);
		contentPane.add(lblKartodromo);

		txtKartodromo = new JTextField();
		txtKartodromo.setEditable(false);
		txtKartodromo.setBounds(144, 115, 221, 20);
		contentPane.add(txtKartodromo);
		txtKartodromo.setColumns(10);

		JScrollPane pnScroll = new JScrollPane();
		pnScroll.setBounds(10, 204, 355, 272);
		contentPane.add(pnScroll);

		tbPontuacao = new JTable();
		tbPontuacao.setModel(new DefaultTableModel(
				new Object[][] { { "Gerson", "1", "10:20:20" }, { null, null, null }, { null, null, null }, },
				new String[] { "Piloto", "Posi\u00E7\u00E3o", "Tempo Melhor Volta" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbPontuacao.getColumnModel().getColumn(2).setPreferredWidth(122);
		pnScroll.setViewportView(tbPontuacao);

		JLabel lblCadastroPt = new JLabel("Cadastrar Pontua\u00E7\u00E3o:");
		lblCadastroPt.setBounds(10, 179, 178, 14);
		contentPane.add(lblCadastroPt);

		JButton btSalvar = new JButton("Salvar");
		btSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSalvar.setBounds(10, 645, 89, 23);
		contentPane.add(btSalvar);

		JButton btVoltar = new JButton("Voltar");
		btVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btVoltar.setBounds(109, 645, 89, 23);
		contentPane.add(btVoltar);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		if(!(cp  == null)) {
			CarregaDados(cp);		
		}
		
		
	}

	private void CarregaDados(Campeonato cp) {

		BateriaCampeonatoBo bcpBo = new BateriaCampeonatoBo();	
		
		try {

			listaResultado = bcpBo.listaBateriaCampeonato(cp);				

			if (!listaResultado.isEmpty()) {
				for (BateriaCampeonato bcp : listaResultado) {					
					cbBateriaCampeonato.addItem(bcp);
				}
			}
			
			
			PilotoCampeonatoBo pcBo = new PilotoCampeonatoBo();
			
			
			DefaultTableModel modelo = (DefaultTableModel) this.tbPontuacao.getModel();
			
			modelo.setRowCount(0);			
			for(PilotoCampeonato pc: pcBo.ListarCampeonatoPiloto(cp)) {
				
				modelo.addRow(new Object[] {pc, null, null});
							
			}	
			
			tbPontuacao.setModel(modelo);					

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
