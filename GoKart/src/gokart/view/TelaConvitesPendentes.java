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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

public class TelaConvitesPendentes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private JLabel lblInfo;
	private JScrollPane scrollPane;
	private JButton btnAceitar;
	private JButton btnVoltar;
	private JButton btnCancelar;


	public TelaConvitesPendentes(Piloto piloto) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 146, 355, 218);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Campeonato", "Aceito", "N\u00E3o Aceito"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Boolean.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
				
		btnAceitar = new JButton("Aceitar");
		btnAceitar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceitar.setBounds(10, 422, 89, 23);
		contentPane.add(btnAceitar);
		
		btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setToolTipText("Voltar ");
		btnVoltar.setBounds(20, 31, 30, 29);
		btnVoltar.setIcon(new ImageIcon(TelaConvitesPendentes.class.getResource("/img/voltar - 32.png")));
		contentPane.add(btnVoltar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(276, 422, 89, 23);
		contentPane.add(btnCancelar);
		
		lblInfo = new JLabel("Aqui voc\u00EA pode ver seus convites pendentes");
		lblInfo.setBounds(77, 73, 260, 14);
		contentPane.add(lblInfo);
		
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
		
		if((boolean) table.getModel().getValueAt(table.getSelectedRow(), 1)) {
			try {
				ccBo.Salvar(cc);
				JOptionPane.showMessageDialog(null, "Convite aceito com sucesso");		
			} catch (Exception e) {			
				e.printStackTrace();
			}
		}else {
			try {
				ccBo.deletar(cc);
				JOptionPane.showMessageDialog(null, "Convite recusado");	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	} 
}
