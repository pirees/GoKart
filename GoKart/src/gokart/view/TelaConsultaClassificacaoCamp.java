package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import gokart.bo.ClassificacaoCampeonatoBo;
import gokart.bo.SomaPontosCampBo;
import gokart.classes.Campeonato;
import gokart.classes.ClassificacaoCampeonato;
import gokart.classes.Piloto;
import gokart.classes.SomaPontosCamp;
import gokart.classes.AcumulaPontosCamp;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsultaClassificacaoCamp extends JFrame {

	private JPanel contentPane;
	private JTextField txtCampeonato;
	private JLabel lblCamp;
	private JScrollPane pnScroll;
	private JTable tbClass;
	private JButton btnVoltar;
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
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtCampeonato = new JTextField();
		txtCampeonato.setForeground(Color.ORANGE);
		txtCampeonato.setBackground(Color.BLACK);
		txtCampeonato.setEditable(false);
		txtCampeonato.setBounds(10, 154, 355, 20);
		contentPane.add(txtCampeonato);
		txtCampeonato.setColumns(10);

		lblCamp = new JLabel("Campeonato");
		lblCamp.setForeground(Color.ORANGE);
		lblCamp.setBackground(Color.ORANGE);
		lblCamp.setBounds(10, 131, 133, 14);
		contentPane.add(lblCamp);

		JLabel lblClass = new JLabel("CLASSIFICA\u00C7\u00C3O");
		lblClass.setForeground(Color.ORANGE);
		lblClass.setBackground(Color.ORANGE);
		lblClass.setBounds(139, 208, 122, 14);
		contentPane.add(lblClass);

		pnScroll = new JScrollPane();
		pnScroll.setBounds(10, 233, 355, 410);
		contentPane.add(pnScroll);

		tbClass = new JTable();
		tbClass.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Posi\u00E7\u00E3o", "Piloto", "Pontua\u00E7\u00E3o"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		pnScroll.setViewportView(tbClass);

		btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(Color.ORANGE);
		btnVoltar.setToolTipText("Voltar ");
		btnVoltar.setIcon(new ImageIcon(TelaKartodromoBateria.class.getResource("/img/voltar - 32.png")));
		btnVoltar.setBounds(20, 31, 30, 29);
		contentPane.add(btnVoltar);

		JLabel lblimg = new JLabel("");
		lblimg.setIcon(
				new ImageIcon(TelaConsultaClassificacaoCamp.class.getResource("/img/TrofeuCampeonatoPequeno.png")));
		lblimg.setBounds(124, 11, 115, 130);
		contentPane.add(lblimg);

		this.setVisible(true);
		this.setLocationRelativeTo(null);

		btnVoltar.addActionListener(new ActionListener() {
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

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		tbClass.setRowSorter(sorter);
		modelo.setRowCount(0);
		
		List<SomaPontosCamp> listPil = new ArrayList<SomaPontosCamp>();
		

		SomaPontosCampBo smBo = new SomaPontosCampBo();
		SomaPontosCamp spc;
		
		for (AcumulaPontosCamp pc : listResultado) {	

			try {	
				
				listPil.clear();				
				listPil = smBo.listarPiloto(camp, pc.getPil_campeonato());				
				
				if(listPil.isEmpty()) {
					spc = new SomaPontosCamp();					
				}else {
					spc = listPil.get(0);					
				}			

				spc.setPc(pc.getPil_campeonato());
				spc.setCp(pc.getPil_campeonato().getCamp());
				spc.setPontos(pc.getPontuacao());				
				
				smBo.Salvar(spc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		List<SomaPontosCamp> listaFinal = new ArrayList<SomaPontosCamp>();

		try {
			listaFinal = smBo.listar(camp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int j = 0;
		for (SomaPontosCamp spc1 : listaFinal) {
			j++;
			modelo.addRow(new Object[] {j + "º", spc1.getPc().getPil().getNome(), spc1.getPontos()});
		}

		tbClass.setModel(modelo);

	}

}
