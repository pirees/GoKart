package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gokart.bo.BateriaCampeonatoBo;
import gokart.bo.ClassificacaoCampeonatoBo;
import gokart.bo.PilotoCampeonatoBo;
import gokart.bo.PontuacaoCampeonatoBo;
import gokart.classes.BateriaCampeonato;
import gokart.classes.Campeonato;
import gokart.classes.ClassificacaoCampeonato;
import gokart.classes.Piloto;
import gokart.classes.PilotoCampeonato;
import gokart.classes.PontuacaoCampeonato;

import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaPontuacaoBateriaCampeonato extends JFrame {

	private JPanel contentPane;
	private JLabel lblBateria;
	private JComboBox cbBateriaCampeonato;
	private JLabel lblData;
	private JTextField txtKartodromo;
	private JTextField txtData;
	private JTable tbPontuacao;
	private JButton btnVoltar;

	private List<BateriaCampeonato> listaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPontuacaoBateriaCampeonato frame = new TelaPontuacaoBateriaCampeonato(null, null);
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
	public TelaPontuacaoBateriaCampeonato(Campeonato cp, Piloto piloto) {
		setTitle("GoKart - Cadastro Pontua\u00E7\u00E3o Campeonato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblBateria = new JLabel("Bateria");
		lblBateria.setForeground(Color.ORANGE);
		lblBateria.setBackground(Color.ORANGE);
		lblBateria.setBounds(10, 77, 72, 14);
		contentPane.add(lblBateria);

		cbBateriaCampeonato = new JComboBox();
		cbBateriaCampeonato.setForeground(Color.ORANGE);
		cbBateriaCampeonato.setBackground(Color.BLACK);

		cbBateriaCampeonato.setBounds(10, 102, 355, 22);
		contentPane.add(cbBateriaCampeonato);

		lblData = new JLabel("Data Corrida");
		lblData.setBackground(Color.ORANGE);
		lblData.setForeground(Color.ORANGE);
		lblData.setBounds(10, 135, 87, 14);
		contentPane.add(lblData);

		txtData = new JTextField();
		txtData.setForeground(Color.ORANGE);
		txtData.setBackground(Color.BLACK);
		txtData.setEditable(false);
		txtData.setBounds(10, 155, 101, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);

		JLabel lblKartodromo = new JLabel("Kart\u00F3dromo");
		lblKartodromo.setBackground(Color.ORANGE);
		lblKartodromo.setForeground(Color.ORANGE);
		lblKartodromo.setBounds(144, 135, 79, 14);
		contentPane.add(lblKartodromo);

		txtKartodromo = new JTextField();
		txtKartodromo.setForeground(Color.ORANGE);
		txtKartodromo.setBackground(Color.BLACK);
		txtKartodromo.setEditable(false);
		txtKartodromo.setBounds(144, 155, 221, 20);
		contentPane.add(txtKartodromo);
		txtKartodromo.setColumns(10);

		JScrollPane pnScroll = new JScrollPane();
		pnScroll.setBounds(10, 244, 355, 272);
		contentPane.add(pnScroll);

		tbPontuacao = new JTable();
		tbPontuacao.setModel(new DefaultTableModel(
				new Object[][] { { "Gerson", null, "10:20:20" }, { null, null, null }, { null, null, null }, },
				new String[] { "Piloto", "Posi\u00E7\u00E3o", "Tempo Melhor Volta" }) {
			Class[] columnTypes = new Class[] { Object.class, Integer.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbPontuacao.getColumnModel().getColumn(2).setPreferredWidth(122);
		pnScroll.setViewportView(tbPontuacao);

		JLabel lblCadastroPt = new JLabel("Cadastrar Pontua\u00E7\u00E3o");
		lblCadastroPt.setForeground(Color.ORANGE);
		lblCadastroPt.setBackground(Color.ORANGE);
		lblCadastroPt.setBounds(10, 219, 178, 14);
		contentPane.add(lblCadastroPt);

		JButton btSalvar = new JButton("Salvar");
		btSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btSalvar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btSalvar.setBackground(Color.BLACK);
			}
		});	
		btSalvar.setForeground(Color.ORANGE);
		btSalvar.setBackground(Color.BLACK);
		btSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSalvar.setBounds(10, 645, 89, 23);
		contentPane.add(btSalvar);

		this.setVisible(true);
		this.setLocationRelativeTo(null);

		if (!(cp == null)) {
			CarregaDados(cp);
		}

		cbBateriaCampeonato.setSelectedItem(null);

		btnVoltar = new JButton("");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVoltar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVoltar.setBackground(Color.ORANGE);
			}
		});	
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(Color.ORANGE);
		btnVoltar.setToolTipText("Voltar ");
		btnVoltar.setBounds(20, 31, 30, 29);
		btnVoltar.setIcon(new ImageIcon(TelaConvitesPendentes.class.getResource("/img/voltar - 32.png")));
		contentPane.add(btnVoltar);

		cbBateriaCampeonato.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == 1) {

					DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String data;

					BateriaCampeonato bc = (BateriaCampeonato) cbBateriaCampeonato.getSelectedItem();

					data = bc.getId_bateria().getData().format(formatador);

					txtKartodromo.setText(bc.getId_bateria().getKartodromo().getNome());
					txtData.setText(data);

					/* Caso Existir, carrega classifacação já salva para a bateria */
					try {
						CarregaBatSalva((BateriaCampeonato) cbBateriaCampeonato.getSelectedItem(), cp);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}

			}
		});

		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null,
						"Tem certeza que deseja atualizar a Classificação para: "
								+ cbBateriaCampeonato.getSelectedItem().toString());

				if (resposta == 0) {
					SalvarPontuacao(cp);
					TelaCampeonato tc = new TelaCampeonato(piloto);
					dispose();
				}

			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCampeonato tc = new TelaCampeonato(piloto);
				dispose();
			}
		});

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

			/*
			 * PilotoCampeonatoBo pcBo = new PilotoCampeonatoBo();
			 * 
			 * DefaultTableModel modelo = (DefaultTableModel) this.tbPontuacao.getModel();
			 * 
			 * modelo.setRowCount(0); for (PilotoCampeonato pc :
			 * pcBo.ListarCampeonatoPiloto(cp)) { modelo.addRow(new Object[] { pc, 0, null
			 * }); }
			 * 
			 * tbPontuacao.setModel(modelo);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void SalvarPontuacao(Campeonato cp) {

		List<ClassificacaoCampeonato> lista;
		ClassificacaoCampeonato cc = null;

		PontuacaoCampeonatoBo ptCp = new PontuacaoCampeonatoBo();

		int i = 0;

		try {

			/* Percorre a table em tela */
			for (i = 0; i < tbPontuacao.getModel().getRowCount(); i++) {

				ClassificacaoCampeonatoBo ccBo = new ClassificacaoCampeonatoBo();

				/*
				 * Procura registro de Pontuação Cadastrada, caso exista sobrescreve, caso
				 * contrario cria uma nova
				 */
				lista = ccBo.listarCC((BateriaCampeonato) cbBateriaCampeonato.getSelectedItem(),
						(PilotoCampeonato) tbPontuacao.getModel().getValueAt(i, 0));

				if (lista.isEmpty()) {
					cc = new ClassificacaoCampeonato();
				} else {
					cc = lista.get(0);
				}

				cc.setBat((BateriaCampeonato) cbBateriaCampeonato.getSelectedItem());
				cc.setCamp(cp);
				cc.setPil((PilotoCampeonato) tbPontuacao.getModel().getValueAt(i, 0));
				cc.setPosicao((Integer) tbPontuacao.getModel().getValueAt(i, 1));

				/*
				 * Percorre Tabela de Pontos, cadastradas no campeonato, cada posição recebe X
				 * pontos
				 */

				for (PontuacaoCampeonato pt : ptCp.listarPt(cp)) {
					if (pt.getPosicao() == (Integer) tbPontuacao.getModel().getValueAt(i, 1)) {
						cc.setPontuacao(pt.getPontuacao());
						break;
					}

				}

				ccBo.Salvar(cc);

			}

			JOptionPane.showMessageDialog(null, "Pontuação salva com sucesso!");

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	private void CarregaBatSalva(BateriaCampeonato bc, Campeonato cp) throws Exception {

		List<ClassificacaoCampeonato> listaCl = new ArrayList<ClassificacaoCampeonato>();

		ClassificacaoCampeonatoBo ccBo = new ClassificacaoCampeonatoBo();

		listaCl.clear();
		listaCl = ccBo.listarCpBt(cp, bc);

		DefaultTableModel modelo = (DefaultTableModel) this.tbPontuacao.getModel();
		modelo.setRowCount(0);

		if (listaCl.isEmpty()) {

			PilotoCampeonatoBo pcBo = new PilotoCampeonatoBo();

			for (PilotoCampeonato pc : pcBo.ListarCampeonatoPiloto(cp)) {
				modelo.addRow(new Object[] { pc, 0, null });
			}

			tbPontuacao.setModel(modelo);

		} else {

			for (ClassificacaoCampeonato cc : listaCl) {
				modelo.addRow(new Object[] { cc.getPil(), cc.getPosicao(), "" });
			}

			tbPontuacao.setModel(modelo);

		}
	}
	
	
}
