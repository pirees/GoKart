package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gokart.bo.CampeonatoBo;
import gokart.bo.PilotoCampeonatoBo;
import gokart.classes.Piloto;
import gokart.classes.PilotoCampeonato;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCampeonato extends JFrame {

	private JPanel painel;
	private JTextField txtEmailPiloto;
	private JTable tbN;
	private JTable tbBateria;
	private JComboBox cbCampeonato;

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
		lblCampeonato.setBounds(10, 59, 88, 14);
		painel.add(lblCampeonato);
		
		cbCampeonato = new JComboBox();
		cbCampeonato.setBounds(10, 84, 301, 22);
		painel.add(cbCampeonato);
		
		JButton btNovoCampeonato = new JButton("+");
		
		btNovoCampeonato.setBounds(10, 117, 41, 23);
		painel.add(btNovoCampeonato);
		
		JButton btClassificacao = new JButton("Classifica\u00E7\u00E3o");
		btClassificacao.setBounds(61, 117, 123, 23);
		painel.add(btClassificacao);
		
		JLabel lblCvPiloto = new JLabel("Convidar Piloto:");
		lblCvPiloto.setBounds(10, 187, 116, 14);
		painel.add(lblCvPiloto);
		
		txtEmailPiloto = new JTextField();
		txtEmailPiloto.setToolTipText("Ensira o e-mail do piloto para convida-lo ao campeonato.");
		txtEmailPiloto.setText("Email Piloto");
		txtEmailPiloto.setBounds(10, 212, 301, 20);
		painel.add(txtEmailPiloto);
		txtEmailPiloto.setColumns(10);
		
		JButton btEnviaConvite = new JButton("V_");
	
		btEnviaConvite.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btEnviaConvite.setBounds(321, 212, 44, 20);
		painel.add(btEnviaConvite);
		
		JLabel lblBaterias = new JLabel("Baterias:");
		lblBaterias.setBounds(10, 298, 61, 14);
		painel.add(lblBaterias);
		
		JScrollPane pnBateria = new JScrollPane();
		pnBateria.setBounds(10, 323, 355, 148);
		painel.add(pnBateria);	
		
		
		CarregaCampeonato(piloto);
		
		tbBateria = new JTable();	
		
		tbBateria.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Kart\u00F3dromo", "Data Bateria", "Hora Bateria", "Vagas Dispon\u00EDveis"
			}
		));
		tbBateria.getColumnModel().getColumn(3).setPreferredWidth(103);
		pnBateria.setViewportView(tbBateria);
		
		JButton btAddBateria = new JButton("Adicionar Bateria");
		btAddBateria.setBounds(10, 478, 140, 23);
		painel.add(btAddBateria);
		
		this.setVisible(true);
		
		
		/*Eventos*/
		
		btNovoCampeonato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroCampeonato tcc = new TelaCadastroCampeonato(piloto);				
				dispose();
				
				
				
			}
		});
		
		
	}
	
	private void CarregaCampeonato(Piloto piloto) {
		
		PilotoCampeonatoBo pcpBo = new PilotoCampeonatoBo();
		
		try {
			
			for(PilotoCampeonato pc: pcpBo.ListarPilotoCampeonato(piloto)) {				
				cbCampeonato.addItem(pc.getCamp());					
			}	
			
			
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
