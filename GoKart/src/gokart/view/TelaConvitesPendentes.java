package gokart.view;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import gokart.bo.ConviteCampeonatoBo;
import gokart.classes.Campeonato;
import gokart.classes.ConviteCampeonato;
import gokart.classes.Piloto;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaConvitesPendentes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;


	public TelaConvitesPendentes(Piloto piloto) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 342, 218);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
					"ID", "Piloto", "Campeonato", "Etapas"
			}
		));
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
				
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.setBounds(10, 395, 89, 23);
		contentPane.add(btnAceitar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(141, 395, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(263, 395, 89, 23);
		contentPane.add(btnCancelar);
		
		//CENTRALIZANDO OS ITENS DA TABELA
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		
		listarBaterias(piloto);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					aceitarConvite(piloto);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		
	}
	
	private void listarBaterias(Piloto piloto) {	
		
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo); 

		try {
			List<ConviteCampeonato> lista = new ConviteCampeonatoBo().listarBaterias(piloto);
			for (ConviteCampeonato cc : lista) {
				modelo.addRow(new Object[] {
						cc.getId(),
						cc.getId_piloto(),
						cc.getId_campeonato().getNomeCampeonato(),
						cc.getId_campeonato().getNrBatCampeonato()					
				});
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,  e.getMessage());
		}	
	}
	
	private void aceitarConvite(Piloto piloto) {
		
		int i = 0;
		
		int a = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 0);


		ConviteCampeonato cc = new ConviteCampeonato();
		ConviteCampeonatoBo ccBo = new ConviteCampeonatoBo();
		
		cc.setId(a);

		cc.setId_campeonato((Campeonato) table.getModel().getValueAt(i, 0));
		cc.setId_piloto(piloto);
		cc.setAceito(true);
		
		try {
			ccBo.Salvar(cc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Convite aceito com sucesso");		
	} 
}
