package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gokart.bo.ClassificacaoCampeonatoBo;
import gokart.classes.Campeonato;
import gokart.classes.ClassificacaoCampeonato;
import gokart.classes.Piloto;
import gokart.classes.AcumulaPontosCamp;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsultaClassificacaoCamp extends JFrame {

	private JPanel contentPane;
	private JTextField txtCampeonato;
	private JLabel lblCamp;
	private JScrollPane pnScroll;
	private JTable tbClass;
	private JButton btVoltar;
	private List<AcumulaPontosCamp> listResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaClassificacaoCamp frame = new TelaConsultaClassificacaoCamp(null, null);
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
	public TelaConsultaClassificacaoCamp(Piloto pil, Campeonato cc) {
		setTitle("GoKart - Consulta Classifica\u00E7\u00E3o Campeonato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtCampeonato = new JTextField();
		txtCampeonato.setEditable(false);
		txtCampeonato.setBounds(10, 154, 355, 20);
		contentPane.add(txtCampeonato);
		txtCampeonato.setColumns(10);

		lblCamp = new JLabel("Campeonato:");
		lblCamp.setBounds(10, 131, 133, 14);
		contentPane.add(lblCamp);

		JLabel lblClass = new JLabel("CLASSIFICA\u00C7\u00C3O");
		lblClass.setBounds(139, 208, 122, 14);
		contentPane.add(lblClass);

		pnScroll = new JScrollPane();
		pnScroll.setBounds(10, 233, 355, 410);
		contentPane.add(pnScroll);

		tbClass = new JTable();
		tbClass.setModel(new DefaultTableModel(new Object[][] { { null, null }, },
				new String[] { "Piloto", "Pontua\u00E7\u00E3o" }) {
			Class[] columnTypes = new Class[] { String.class, Long.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		pnScroll.setViewportView(tbClass);

		btVoltar = new JButton("");

		btVoltar.setIcon(new ImageIcon(TelaConsultaClassificacaoCamp.class.getResource("/img/voltar - 32.png")));
		btVoltar.setToolTipText("Voltar ");
		btVoltar.setBackground(Color.WHITE);
		btVoltar.setBounds(10, 30, 30, 29);
		contentPane.add(btVoltar);

		JLabel lblimg = new JLabel("");
		lblimg.setIcon(
				new ImageIcon(TelaConsultaClassificacaoCamp.class.getResource("/img/TrofeuCampeonatoPequeno.png")));
		lblimg.setBounds(124, 11, 115, 130);
		contentPane.add(lblimg);

		this.setVisible(true);
		this.setLocationRelativeTo(null);

		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCampeonato tc = new TelaCampeonato(pil);
				dispose();
			}
		});

		if (!(cc == null)) {
			txtCampeonato.setText(cc.getNomeCampeonato());
			ListarDados(cc);
		}

	}

	private void ListarDados(Campeonato camp) {

		boolean lista = false;
		int i = 0;
		listResultado = new ArrayList<AcumulaPontosCamp>();

		ClassificacaoCampeonatoBo ccBo = new ClassificacaoCampeonatoBo();

		/* Faz a somatória de valores no Banco da Classificação */
		for (ClassificacaoCampeonato cc : ccBo.listar(camp)) {

			lista = false;
			for (i = 0; i < listResultado.size(); i++) {

				if (listResultado.get(i).getPil_campeonato().getId() == cc.getPil().getId()) {

					listResultado.get(i).setPontuacao(listResultado.get(i).getPontuacao() + cc.getPontuacao());
					lista = true;
					break;
				}

			}

			if (lista == false) {
				AcumulaPontosCamp pc = new AcumulaPontosCamp();
				pc.setPil_campeonato(cc.getPil());
				pc.setPontuacao(cc.getPontuacao());
				listResultado.add(pc);
			}

		}

		DefaultTableModel modelo = (DefaultTableModel) this.tbClass.getModel();

		modelo.setRowCount(0);

		for (AcumulaPontosCamp pc : listResultado) {
			modelo.addRow(new Object[] { pc.getPil_campeonato().getPil().getNome(), pc.getPontuacao() });
		}

		tbClass.setModel(modelo);

	}

}
