package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;

import gokart.bo.CampeonatoBo;
import gokart.bo.PilotoBo;
import gokart.bo.PilotoCampeonatoBo;
import gokart.bo.PontuacaoCampeonatoBo;
import gokart.classes.Campeonato;
import gokart.classes.Piloto;
import gokart.classes.PilotoCampeonato;
import gokart.classes.PontuacaoCampeonato;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class TelaCadastroCampeonato extends JFrame {

	private JPanel pnPrincipal;
	private JTextField txtNomeCampeonato;
	private JTable tbPontuacao;
	private JTextField txtMelhorVolta;
	private JTextField txtEmailPilotoAdm;
	private JComboBox cbQtCorrida;

	/**
	 * Launch the application.
	 */
	
	public TelaCadastroCampeonato(Piloto piloto) {
		setResizable(false);
		setTitle("GoKart - Cadastro Campeonato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		pnPrincipal = new JPanel();
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);

		JLabel lblCadastro = new JLabel("Cadastro de Campeonato");
		lblCadastro.setBounds(167, 56, 187, 20);
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnSalvar.setBounds(10, 645, 89, 23);

		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBounds(109, 645, 89, 23);

		txtNomeCampeonato = new JTextField();
		txtNomeCampeonato.setBounds(10, 193, 252, 20);
		txtNomeCampeonato.setColumns(10);

		JLabel lblNomeCampeonato = new JLabel("Nome Campeonato:");
		lblNomeCampeonato.setBounds(10, 168, 159, 14);

		JLabel lblQuantidadeDeCorrida = new JLabel("Quantidade de Corridas:");
		lblQuantidadeDeCorrida.setBounds(10, 224, 159, 14);

		cbQtCorrida = new JComboBox();
		cbQtCorrida.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		cbQtCorrida.setBounds(10, 249, 50, 23);

		JScrollPane pnPontuacao = new JScrollPane();
		pnPontuacao.setBounds(10, 355, 355, 189);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);

		tbPontuacao = new JTable();
		tbPontuacao.setToolTipText("Cadastro de pontua\u00E7\u00E3o do campeonato!");
		tbPontuacao.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), new Long(25L)},
				{new Integer(2), new Long(18L)},
				{new Integer(3), new Long(15L)},
				{new Integer(4), new Long(12L)},
				{new Integer(5), new Long(10L)},
				{new Integer(6), new Long(8L)},
				{new Integer(7), new Long(6L)},
				{new Integer(8), new Long(4L)},
				{new Integer(9), new Long(2L)},
				{new Integer(10), new Long(1L)},
			},
			new String[] {
				"Posi\u00E7\u00E3o", "Pontua\u00E7\u00E3o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbPontuacao.getColumnModel().getColumn(0).setResizable(false);
		tbPontuacao.getColumnModel().getColumn(0).setPreferredWidth(48);
		tbPontuacao.getColumnModel().getColumn(1).setPreferredWidth(63);
		pnPontuacao.setViewportView(tbPontuacao);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(lblCadastro);
		pnPrincipal.add(btnSalvar);
		pnPrincipal.add(btnVoltar);
		pnPrincipal.add(txtNomeCampeonato);
		pnPrincipal.add(lblNomeCampeonato);
		pnPrincipal.add(lblQuantidadeDeCorrida);
		pnPrincipal.add(cbQtCorrida);
		pnPrincipal.add(pnPontuacao);

		JLabel lblPontuacao = new JLabel("Pontua\u00E7\u00E3o Classifica\u00E7\u00E3o:");
		lblPontuacao.setBounds(10, 339, 172, 14);
		pnPrincipal.add(lblPontuacao);

		JLabel lvlMelhorVolta = new JLabel("Pontua\u00E7\u00E3o Melhor Volta:");
		lvlMelhorVolta.setBounds(10, 568, 159, 14);
		pnPrincipal.add(lvlMelhorVolta);

		txtMelhorVolta = new JTextField();
		txtMelhorVolta.setToolTipText("Pontua\u00E7\u00E3o extra para a melhor volta.");
		txtMelhorVolta.setText("40");
		txtMelhorVolta.setBounds(157, 565, 37, 20);
		pnPrincipal.add(txtMelhorVolta);
		txtMelhorVolta.setColumns(10);

		JLabel lblEmailPiloto = new JLabel("Email Piloto Administrador:");
		lblEmailPiloto.setBounds(10, 283, 159, 14);
		pnPrincipal.add(lblEmailPiloto);

		txtEmailPilotoAdm = new JTextField();
		txtEmailPilotoAdm.setToolTipText("Email do piloto administrador do campeonato.");
		txtEmailPilotoAdm.setBounds(10, 308, 252, 20);
		pnPrincipal.add(txtEmailPilotoAdm);
		txtEmailPilotoAdm.setColumns(10);

		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(TelaCadastroCampeonato.class.getResource("/img/TrofeuCampeonatoPequeno.png")));
		lblImg.setBounds(10, 11, 121, 113);
		pnPrincipal.add(lblImg);

		this.setLocationRelativeTo(null);
		this.setVisible(true);

		/* Eventos */

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/* Chama metodo para salvar dados no banco */
				SalvaDados();

			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCampeonato tc = new TelaCampeonato(piloto);
				dispose();
			}
		});

	}

	public void SalvaDados() {

		/* Cria o Objeto do Campeonato */
		Campeonato cp = new Campeonato();
		cp.setNomeCampeonato(txtNomeCampeonato.getText());
		cp.setNrBatCampeonato(Integer.valueOf(cbQtCorrida.getSelectedIndex()));
		cp.setPtMelhorVolta(Integer.valueOf(txtMelhorVolta.getText()));

		PilotoBo pBo = new PilotoBo();

		try {
			
			
			/* Procura o piloto pelo e-mail em tela */
			cp.setPilotoAdm(pBo.ProcuraEmail(txtEmailPilotoAdm.getText()));			

			/* Salva o Campeonato no Banco de Dados */
			CampeonatoBo cpBo = new CampeonatoBo();
			
			
			cpBo.Salvar(cp);
			
			
			
			/*Grava Relacionamento Piloto x Campeonato*/			
			PilotoCampeonato piCamp = new PilotoCampeonato();
			piCamp.setPil(cp.getPilotoAdm());
			piCamp.setCamp(cp);			
			
			PilotoCampeonatoBo pcpBo = new PilotoCampeonatoBo();			
			pcpBo.Salvar(piCamp);			
			

			/* Salva a Pontuação do Campeonato no Banco de Dados */
			int i = 0;
			for (i = 0; i < 10; i++) {

				PontuacaoCampeonato pCp = new PontuacaoCampeonato();
				pCp.setId_campeonato(cp);
				pCp.setPontuacao(Integer.valueOf(tbPontuacao.getModel().getValueAt(i, 1).toString()));
				pCp.setPosicao(i + 1);
				
				PontuacaoCampeonatoBo pCBo = new PontuacaoCampeonatoBo();				
				pCBo.Salvar(pCp);
			}
			
			JOptionPane.showMessageDialog(null, "Campeonato cadastrado com sucesso!");
			

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}

	}

}
