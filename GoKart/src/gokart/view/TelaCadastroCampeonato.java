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

import javax.swing.table.DefaultTableCellRenderer;
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
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JLabel lblCadastro;
	private JButton btnSalvar;
	private JLabel lblNomeCampeonato;
	private JLabel lblQuantidadeDeCorrida;
	private JScrollPane pnPontuacao;
	private JLabel lblPontuacao;
	private JLabel lvlMelhorVolta;
	private JLabel lblEmailPiloto;
	private JLabel lblImg;
	private JButton btVoltar;



	public TelaCadastroCampeonato(Piloto piloto) {
		setResizable(false);
		setTitle("GoKart - Cadastro Campeonato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.BLACK);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);

		lblCadastro = new JLabel("Cadastro de Campeonato");
		lblCadastro.setForeground(Color.ORANGE);
		lblCadastro.setBackground(Color.ORANGE);
		lblCadastro.setBounds(47, 83, 187, 20);
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalvar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalvar.setBackground(Color.BLACK);
			}
		});	
		btnSalvar.setForeground(Color.ORANGE);
		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnSalvar.setBounds(10, 645, 89, 23);

		txtNomeCampeonato = new JTextField();
		txtNomeCampeonato.setForeground(Color.ORANGE);
		txtNomeCampeonato.setBackground(Color.BLACK);
		txtNomeCampeonato.setBounds(10, 193, 252, 20);
		txtNomeCampeonato.setColumns(10);

		lblNomeCampeonato = new JLabel("Nome Campeonato");
		lblNomeCampeonato.setForeground(Color.ORANGE);
		lblNomeCampeonato.setBackground(Color.ORANGE);
		lblNomeCampeonato.setBounds(10, 168, 159, 14);

		lblQuantidadeDeCorrida = new JLabel("Quantidade de Corridas");
		lblQuantidadeDeCorrida.setBackground(Color.ORANGE);
		lblQuantidadeDeCorrida.setForeground(Color.ORANGE);
		lblQuantidadeDeCorrida.setBounds(10, 224, 159, 14);

		cbQtCorrida = new JComboBox();
		cbQtCorrida.setForeground(Color.ORANGE);
		cbQtCorrida.setBackground(Color.BLACK);
		cbQtCorrida.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		cbQtCorrida.setBounds(10, 249, 50, 23);

		pnPontuacao = new JScrollPane();
		pnPontuacao.setBounds(10, 355, 355, 189);

		this.setVisible(true);
		this.setLocationRelativeTo(null);

		tbPontuacao = new JTable();
		tbPontuacao.setToolTipText("Cadastro de pontua\u00E7\u00E3o do campeonato!");
		tbPontuacao.setModel(new DefaultTableModel(
				new Object[][] { { new Integer(1), new Long(25L) }, { new Integer(2), new Long(18L) },
						{ new Integer(3), new Long(15L) }, { new Integer(4), new Long(12L) },
						{ new Integer(5), new Long(10L) }, { new Integer(6), new Long(8L) },
						{ new Integer(7), new Long(6L) }, { new Integer(8), new Long(4L) },
						{ new Integer(9), new Long(2L) }, { new Integer(10), new Long(1L) }, },
				new String[] { "Posi\u00E7\u00E3o", "Pontua\u00E7\u00E3o" }) {
			Class[] columnTypes = new Class[] { Integer.class, Long.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, true };

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
		pnPrincipal.add(txtNomeCampeonato);
		pnPrincipal.add(lblNomeCampeonato);
		pnPrincipal.add(lblQuantidadeDeCorrida);
		pnPrincipal.add(cbQtCorrida);
		pnPrincipal.add(pnPontuacao);		

		lblPontuacao = new JLabel("Pontua\u00E7\u00E3o Classifica\u00E7\u00E3o");
		lblPontuacao.setBackground(Color.ORANGE);
		lblPontuacao.setForeground(Color.ORANGE);
		lblPontuacao.setBounds(10, 339, 172, 14);
		pnPrincipal.add(lblPontuacao);

		lvlMelhorVolta = new JLabel("Pontua\u00E7\u00E3o Melhor Volta");
		lvlMelhorVolta.setBackground(Color.ORANGE);
		lvlMelhorVolta.setForeground(Color.ORANGE);
		lvlMelhorVolta.setBounds(10, 568, 159, 14);
		pnPrincipal.add(lvlMelhorVolta);

		txtMelhorVolta = new JTextField();
		txtMelhorVolta.setBackground(Color.BLACK);
		txtMelhorVolta.setForeground(Color.ORANGE);
		txtMelhorVolta.setToolTipText("Pontua\u00E7\u00E3o extra para a melhor volta.");
		txtMelhorVolta.setText("10");
		txtMelhorVolta.setBounds(157, 565, 37, 20);
		pnPrincipal.add(txtMelhorVolta);
		txtMelhorVolta.setColumns(10);

		lblEmailPiloto = new JLabel("Email Piloto Administrador");
		lblEmailPiloto.setForeground(Color.ORANGE);
		lblEmailPiloto.setBackground(Color.ORANGE);
		lblEmailPiloto.setBounds(10, 283, 159, 14);
		pnPrincipal.add(lblEmailPiloto);

		txtEmailPilotoAdm = new JTextField();
		txtEmailPilotoAdm.setForeground(Color.ORANGE);
		txtEmailPilotoAdm.setBackground(Color.BLACK);
		txtEmailPilotoAdm.setToolTipText("Email do piloto administrador do campeonato.");
		txtEmailPilotoAdm.setBounds(10, 308, 252, 20);
		pnPrincipal.add(txtEmailPilotoAdm);
		txtEmailPilotoAdm.setColumns(10);

	    lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(TelaCadastroCampeonato.class.getResource("/img/TrofeuCampeonatoPequeno.png")));
		lblImg.setBounds(244, 31, 121, 113);
		pnPrincipal.add(lblImg);
		txtEmailPilotoAdm.setText(piloto.getEmail());
		
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
		btVoltar.setIcon(new ImageIcon(TelaCadastroCampeonato.class.getResource("/img/voltar - 32.png")));
		btVoltar.setToolTipText("Voltar ");
		btVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btVoltar.setBackground(Color.ORANGE);
		btVoltar.setBounds(20, 31, 30, 29);
		pnPrincipal.add(btVoltar);

		this.setLocationRelativeTo(null);
		this.setVisible(true);

		/* Eventos */

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ValidaPontos();
					SalvaDados(piloto);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro Pontua��o!", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				/* Chama metodo para salvar dados no banco */

			}
		});
		
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				TelaCampeonato tc = new TelaCampeonato(piloto);
				dispose();
			}
		});

	}

	public void SalvaDados(Piloto pil) {

		/* Cria o Objeto do Campeonato */
		Campeonato cp = new Campeonato();
		cp.setNomeCampeonato(txtNomeCampeonato.getText());
		cp.setNrBatCampeonato(Integer.valueOf((String) cbQtCorrida.getSelectedItem()));
		cp.setPtMelhorVolta(Integer.valueOf(txtMelhorVolta.getText()));

		PilotoBo pBo = new PilotoBo();

		try {

			/* Procura o piloto pelo e-mail em tela */
			cp.setPilotoAdm(pBo.ProcuraEmail(txtEmailPilotoAdm.getText()));

			/* Salva o Campeonato no Banco de Dados */
			CampeonatoBo cpBo = new CampeonatoBo();

			cpBo.Salvar(cp);

			/* Grava Relacionamento Piloto x Campeonato */
			PilotoCampeonato piCamp = new PilotoCampeonato();
			piCamp.setPil(cp.getPilotoAdm());
			piCamp.setCamp(cp);

			PilotoCampeonatoBo pcpBo = new PilotoCampeonatoBo();
			pcpBo.Salvar(piCamp);

			/* Salva a Pontua��o do Campeonato no Banco de Dados */
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
			
			TelaCampeonato tc = new TelaCampeonato(pil);
			dispose();

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}

	}

	public void ValidaPontos() throws Exception {

		int i = 0;
		int j = 0;

		for (i = 0; i < tbPontuacao.getModel().getRowCount(); i++) {

			int pos = (int) tbPontuacao.getModel().getValueAt(i, 0);
			long pontos = (long) tbPontuacao.getModel().getValueAt(i, 1);

			for (j = 0; j < tbPontuacao.getModel().getRowCount(); j++) {

				if ((int) tbPontuacao.getModel().getValueAt(j, 0) > pos	&& (long) tbPontuacao.getModel().getValueAt(j, 1) > pontos) {
					throw new Exception("Posi��o: " + (int) tbPontuacao.getModel().getValueAt(j, 0)
							+ "� com pontua��o MAIOR que Posi��o: " + pos + "�");
				}

			}

		}

	}

}
