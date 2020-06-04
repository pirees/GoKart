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
import javax.swing.table.DefaultTableModel;

import gokart.bo.BateriaCampeonatoBo;
import gokart.bo.CampeonatoBo;
import gokart.bo.PilotoBo;
import gokart.bo.PilotoCampeonatoBo;
import gokart.classes.BateriaCampeonato;
import gokart.classes.Campeonato;
import gokart.classes.ConviteCampeonato;
import gokart.classes.Piloto;
import gokart.classes.PilotoCampeonato;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCampeonato frame = new TelaCampeonato(null);
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
	public TelaCampeonato(Piloto piloto) {
		setTitle("GoKart - Campeonato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);

		JLabel lblCampeonato = new JLabel("Campeonato:");
		lblCampeonato.setBounds(10, 122, 88, 14);
		painel.add(lblCampeonato);

		cbCampeonato = new JComboBox();
		cbCampeonato.setBounds(10, 147, 301, 22);
		painel.add(cbCampeonato);

		btNovoCampeonato = new JButton("+");
		btNovoCampeonato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btNovoCampeonato.setBounds(321, 147, 41, 23);
		painel.add(btNovoCampeonato);

		btClassificacao = new JButton("Classifica\u00E7\u00E3o");
		btClassificacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btClassificacao.setBounds(10, 180, 123, 23);
		painel.add(btClassificacao);

		JLabel lblCvPiloto = new JLabel("Convidar Piloto:");
		lblCvPiloto.setBounds(10, 230, 116, 14);
		painel.add(lblCvPiloto);

		txtEmailPiloto = new JTextField();
		txtEmailPiloto.setToolTipText("Ensira o e-mail do piloto para convida-lo ao campeonato.");
		txtEmailPiloto.setText("Email Piloto");
		txtEmailPiloto.setBounds(10, 255, 301, 20);
		painel.add(txtEmailPiloto);
		txtEmailPiloto.setColumns(10);

		btEnviaConvite = new JButton("");
		btEnviaConvite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btEnviaConvite.setIcon(new ImageIcon(TelaCampeonato.class.getResource("/img/IconeEnviar.png")));

		btEnviaConvite.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btEnviaConvite.setBounds(321, 255, 41, 20);
		painel.add(btEnviaConvite);

		JLabel lblBaterias = new JLabel("Baterias:");
		lblBaterias.setBounds(10, 298, 61, 14);
		painel.add(lblBaterias);

		pnBateria = new JScrollPane();
		pnBateria.setBounds(10, 323, 355, 148);
		painel.add(pnBateria);

		CarregaDadosTela(piloto);

		tbBateria = new JTable();

		tbBateria.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null } },
						new String[] { "Kart\u00F3dromo", "Data Bateria", "Hora Bateria", "Vagas Dispon\u00EDveis" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		tbBateria.getColumnModel().getColumn(3).setPreferredWidth(103);
		pnBateria.setViewportView(tbBateria);

		btAddBateria = new JButton("Adicionar Bateria");
		btAddBateria.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAddBateria.setBounds(10, 478, 140, 23);
		painel.add(btAddBateria);

		JLabel imgCampeonato = new JLabel("");
		imgCampeonato.setIcon(new ImageIcon(TelaCampeonato.class.getResource("/img/TrofeuCampeonatoPequeno.png")));
		imgCampeonato.setBounds(249, 11, 116, 105);
		painel.add(imgCampeonato);

		JLabel lbCamp = new JLabel("GoKart - Campeonato");
		lbCamp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbCamp.setBounds(49, 48, 140, 22);
		painel.add(lbCamp);

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
				TelaAddBateriaCampeonato taddbt = new TelaAddBateriaCampeonato(piloto);
				dispose();

			}
		});

		/* Convida Pilotos para Campeonato */
		btEnviaConvite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					PilotoBo pBo = new PilotoBo();

					ConviteCampeonato cvCp = new ConviteCampeonato();

					cvCp.setId_campeonato((Campeonato) cbCampeonato.getSelectedItem());

					/* Procura Piloto com Email Cadastrado e Envia Convite */
					cvCp.setId_piloto(pBo.ProcuraEmail(txtEmailPiloto.getText()));
					cvCp.setEmail(txtEmailPiloto.getText());

					JOptionPane.showMessageDialog(null, "Convite enviado com sucessso!");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});

	}

	private void CarregaDadosTela(Piloto piloto) {

		try {

			PilotoCampeonatoBo pcpBo = new PilotoCampeonatoBo();

			for (PilotoCampeonato pc : pcpBo.ListarPilotoCampeonato(piloto)) {
				cbCampeonato.addItem(pc.getCamp());
			}

			/*
			 * listaResultado.add(new String[]{con.getNome(),
			 * String.valueOf(con.getDataCadastro()), String.valueOf(con.getValor())});
			 */

			BateriaCampeonatoBo bcBo = new BateriaCampeonatoBo();

			listaResultado.clear();
			for (BateriaCampeonato b : bcBo.listaBateriaCampeonato((Campeonato) cbCampeonato.getSelectedItem())) {

				listaResultado.add(new String[] { b.getId_bateria().getKartodromo().getNome(),
						String.valueOf(b.getId_bateria().getData()), String.valueOf(b.getId_bateria().getHoraBateria()),
						"?" });

			}

			if (!listaResultado.isEmpty()) {
				tbBateria.setModel(new DefaultTableModel(listaResultado.toArray(new String[listaResultado.size()][]),
						new String[] { "Kart\u00F3dromo", "Data Bateria", "Hora Bateria", "Vagas Dispon\u00EDveis" }));

			}

		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
			e.printStackTrace();
		}

	}
}
