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
				{null, null},
			},
			new String[] {
				"Campeonato", "Aceito"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});		
				
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
				aceitarConvite(piloto);										
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				TelaMenuPiloto tmp = new TelaMenuPiloto(piloto);
				dispose();
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
						cc,
						cc.isAceito()						
				});
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,  e.getMessage());
		}	
	}
	
	private void aceitarConvite(Piloto piloto){
		
		ConviteCampeonato cc = (ConviteCampeonato) table.getModel().getValueAt(table.getSelectedRow(), 0);		
		cc.setAceito((boolean) table.getModel().getValueAt(table.getSelectedRow(), 1));	
		
		
		ConviteCampeonatoBo ccBo = new ConviteCampeonatoBo();		
		
		try {
			ccBo.Salvar(cc);
			JOptionPane.showMessageDialog(null, "Convite aceito com sucesso");		
		} catch (Exception e) {			
			e.printStackTrace();
		}

		
		
		
		System.out.println("Étrue?" + cc.isAceito());		
		System.out.println("Qual é o ID?" + cc.getId());
			
		
		/*System.out.println("É true?" + cc.isAceito());*/			
		
		
	} 
}
