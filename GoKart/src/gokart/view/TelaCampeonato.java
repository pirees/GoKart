package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import gokart.bo.BateriaCampeonatoBo;
import gokart.bo.CampeonatoBo;
import gokart.bo.ConviteCampeonatoBo;
import gokart.bo.PilotoBo;
import gokart.bo.PilotoCampeonatoBo;
import gokart.classes.BateriaCampeonato;
import gokart.classes.Campeonato;
import gokart.classes.ConviteCampeonato;
import gokart.classes.Piloto;
import gokart.classes.PilotoCampeonato;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TelaCampeonato extends JFrame {

	private JPanel painel;
	private JTextField txtEmailPiloto;
	private JTable tbN;
	private JTable tbBateria;
	private JComboBox cbCampeonato;
	private JButton btNovoCampeonato;
	private JButton btClassificacao;
	private JButton btAddBateria;
	private JButton btEnviaConvite;
	private JScrollPane pnBateria;
	private List<String[]> listaResultado = new ArrayList<>();
	private JButton btConsultaClass;
	private JButton btVoltar;
	private DefaultTableCellRenderer centralizado;
	private DefaultTableModel modeloCamp;
	private JLabel lblCampeonato;
	private JLabel lblCvPiloto;
	private JLabel lblBaterias;
	private JLabel imgCampeonato;
	private JLabel lbCamp;

	public TelaCampeonato(Piloto piloto) {
		setTitle("GoKart - Campeonato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		painel = new JPanel();
		painel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		painel.setBackground(Color.BLACK);
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);

		lblCampeonato = new JLabel("Campeonato");
		lblCampeonato.setForeground(Color.ORANGE);
		lblCampeonato.setBackground(Color.ORANGE);
		lblCampeonato.setBounds(10, 138, 88, 14);
		painel.add(lblCampeonato);

		cbCampeonato = new JComboBox();
		cbCampeonato.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					AtualizaBat();

				}
			}
		});
		cbCampeonato.setForeground(Color.ORANGE);
		cbCampeonato.setBackground(Color.BLACK);
		cbCampeonato.setBounds(10, 163, 301, 22);
		painel.add(cbCampeonato);

		btNovoCampeonato = new JButton("+");
		btNovoCampeonato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btNovoCampeonato.setBackground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btNovoCampeonato.setBackground(Color.BLACK);
			}
		});
		btNovoCampeonato.setForeground(Color.ORANGE);
		btNovoCampeonato.setBackground(Color.BLACK);
		btNovoCampeonato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btNovoCampeonato.setBounds(321, 163, 41, 23);
		painel.add(btNovoCampeonato);

		btClassificacao = new JButton("+ Classifica\u00E7\u00E3o");
		btClassificacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btClassificacao.setBackground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btClassificacao.setBackground(Color.BLACK);
			}
		});
		btClassificacao.setForeground(Color.ORANGE);
		btClassificacao.setBackground(Color.BLACK);

		btClassificacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btClassificacao.setBounds(10, 196, 127, 23);
		painel.add(btClassificacao);

		lblCvPiloto = new JLabel("Convidar Piloto");
		lblCvPiloto.setForeground(Color.ORANGE);
		lblCvPiloto.setBounds(10, 246, 116, 14);
		painel.add(lblCvPiloto);

		txtEmailPiloto = new JTextField();
		txtEmailPiloto.setForeground(Color.ORANGE);
		txtEmailPiloto.setBackground(Color.BLACK);
		txtEmailPiloto.setToolTipText("Insira o e-mail do piloto para convida-lo ao campeonato.");
		txtEmailPiloto.setText("Email Piloto");
		txtEmailPiloto.setBounds(10, 271, 301, 20);
		painel.add(txtEmailPiloto);
		txtEmailPiloto.setColumns(10);

		btEnviaConvite = new JButton("");
		btEnviaConvite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btEnviaConvite.setBackground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btEnviaConvite.setBackground(Color.ORANGE);
			}
		});
		btEnviaConvite.setForeground(Color.ORANGE);
		btEnviaConvite.setBackground(Color.ORANGE);
		btEnviaConvite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btEnviaConvite.setIcon(new ImageIcon(TelaCampeonato.class.getResource("/img/IconeEnviar.png")));

		btEnviaConvite.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btEnviaConvite.setBounds(321, 271, 41, 20);
		painel.add(btEnviaConvite);

		lblBaterias = new JLabel("Baterias");
		lblBaterias.setForeground(Color.ORANGE);
		lblBaterias.setBounds(10, 314, 61, 14);
		painel.add(lblBaterias);

		pnBateria = new JScrollPane();
		pnBateria.setBounds(10, 339, 355, 148);
		painel.add(pnBateria);

		tbBateria = new JTable();
		tbBateria.setForeground(Color.ORANGE);
		tbBateria.setBackground(Color.BLACK);

		tbBateria.setModel(new DefaultTableModel(new Object[][] { { null, "", null, null }, },
				new String[] { "Kart\u00F3dromo", "Data Bateria", "Hora Bateria", "Tra\u00E7ado" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbBateria.getColumnModel().getColumn(3).setPreferredWidth(103);
		pnBateria.setViewportView(tbBateria);

		// CENTRALIZANDO OS ITENS DA TABELA
		centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		tbBateria.getColumnModel().getColumn(1).setCellRenderer(centralizado);
		tbBateria.getColumnModel().getColumn(2).setCellRenderer(centralizado);
		tbBateria.getColumnModel().getColumn(3).setCellRenderer(centralizado);

		btAddBateria = new JButton("Adicionar Bateria");
		btAddBateria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btAddBateria.setBackground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btAddBateria.setBackground(Color.BLACK);
			}
		});
		btAddBateria.setForeground(Color.ORANGE);
		btAddBateria.setBackground(Color.BLACK);
		btAddBateria.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAddBateria.setBounds(10, 494, 140, 23);
		painel.add(btAddBateria);

		imgCampeonato = new JLabel("");
		imgCampeonato.setIcon(new ImageIcon(TelaCampeonato.class.getResource("/img/TrofeuCampeonatoPequeno.png")));
		imgCampeonato.setBounds(249, 11, 116, 105);
		painel.add(imgCampeonato);

		lbCamp = new JLabel("GoKart - Campeonato");
		lbCamp.setForeground(Color.ORANGE);
		lbCamp.setBackground(Color.ORANGE);
		lbCamp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbCamp.setBounds(99, 58, 140, 22);
		painel.add(lbCamp);

		btConsultaClass = new JButton("Classifica\u00E7\u00E3o");
		btConsultaClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btConsultaClass.setBackground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btConsultaClass.setBackground(Color.BLACK);
			}
		});
		btConsultaClass.setForeground(Color.ORANGE);
		btConsultaClass.setBackground(Color.BLACK);

		btConsultaClass.setBounds(147, 196, 116, 23);
		painel.add(btConsultaClass);

		btVoltar = new JButton("");
		btVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btVoltar.setBackground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btVoltar.setBackground(Color.ORANGE);
			}
		});
		btVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btVoltar.setIcon(new ImageIcon(TelaCampeonato.class.getResource("/img/voltar - 32.png")));
		btVoltar.setToolTipText("Voltar ");
		btVoltar.setBackground(Color.ORANGE);
		btVoltar.setBounds(20, 31, 30, 29);
		painel.add(btVoltar);

		this.setVisible(true);
		this.setLocationRelativeTo(null);

		/* Eventos */

		/* Novo Campenato */
		btNovoCampeonato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastroCampeonato tcc = new TelaCadastroCampeonato(piloto);
				dispose();

			}
		});

		/* Adicionar Bateria no Campeonato */
		btAddBateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAddBateriaCampeonato taddbt = new TelaAddBateriaCampeonato(piloto,
						(Campeonato) cbCampeonato.getSelectedItem());
				dispose();
			}
		});

		/* Convida Pilotos para Campeonato */
		btEnviaConvite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnviarConvite();
			}
		});

		btClassificacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaPontuacaoBateriaCampeonato tptb = new TelaPontuacaoBateriaCampeonato(
						(Campeonato) cbCampeonato.getSelectedItem(), piloto);
				dispose();

			}
		});

		btConsultaClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaConsultaClassificacaoCamp tccc = new TelaConsultaClassificacaoCamp(piloto,
						(Campeonato) cbCampeonato.getSelectedItem());
				dispose();
			}
		});

		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPiloto tmp = new TelaMenuPiloto(piloto);
				dispose();

			}
		});

		txtEmailPiloto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEmailPiloto.setText("");
			}
		});

		CarregaDadosTela(piloto);

	}

	private void CarregaDadosTela(Piloto piloto) {

		try {

			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String data;

			PilotoCampeonatoBo pcpBo = new PilotoCampeonatoBo();

			for (PilotoCampeonato pc : pcpBo.ListarPilotoCampeonato(piloto)) {

				cbCampeonato.addItem(pc.getCamp());
			}

			BateriaCampeonatoBo bcBo = new BateriaCampeonatoBo();

			Object obj = cbCampeonato.getSelectedItem();

			listaResultado.clear();

			if (!(obj == null)) {

				for (BateriaCampeonato b : bcBo.listaBateriaCampeonato((Campeonato) cbCampeonato.getSelectedItem())) {

					data = b.getId_bateria().getData().format(formatador);

					listaResultado.add(new String[] { b.getId_bateria().getKartodromo().getNome(), data,
							String.valueOf(b.getId_bateria().getHoraBateria()), b.getId_bateria().getTracado() });

				}

				if (!listaResultado.isEmpty()) {
					tbBateria
							.setModel(new DefaultTableModel(listaResultado.toArray(new String[listaResultado.size()][]),
									new String[] { "Kart\u00F3dromo", "Data Bateria", "Hora Bateria", "Traçado" }));

				}
			}

		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
			e.printStackTrace();
		}

	}

	private void AtualizaBat() {

		BateriaCampeonatoBo bcBo = new BateriaCampeonatoBo();		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data;
		
		modeloCamp = (DefaultTableModel) tbBateria.getModel();
		modeloCamp.setRowCount(0);
		
		tbBateria.setModel(modeloCamp);
		
		Object obj = cbCampeonato.getSelectedItem();
		listaResultado.clear();

		if (!(obj == null)) {

			try {
				for (BateriaCampeonato b : bcBo.listaBateriaCampeonato((Campeonato) cbCampeonato.getSelectedItem())) {

					data = b.getId_bateria().getData().format(formatador);

					listaResultado.add(new String[] { b.getId_bateria().getKartodromo().getNome(), data,
							String.valueOf(b.getId_bateria().getHoraBateria()), b.getId_bateria().getTracado() });

				}

				if (!listaResultado.isEmpty()) {
					tbBateria.setModel(new DefaultTableModel(listaResultado.toArray(new String[listaResultado.size()][]),
									new String[] { "Kart\u00F3dromo", "Data Bateria", "Hora Bateria", "Traçado" }));
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void EnviarConvite() {

		try {

			PilotoBo pBo = new PilotoBo();

			ConviteCampeonato cvCp = new ConviteCampeonato();

			cvCp.setId_campeonato((Campeonato) cbCampeonato.getSelectedItem());
			/* Procura Piloto com Email Cadastrado e Envia Convite */
			cvCp.setId_piloto(pBo.ProcuraEmail(txtEmailPiloto.getText()));

			ConviteCampeonatoBo cvCpBo = new ConviteCampeonatoBo();
			cvCpBo.Salvar(cvCp);

			JOptionPane.showMessageDialog(null, "Convite enviado com sucessso!");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}

	}

}
