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
import gokart.bo.PilotoCampeonatoBo;
import gokart.classes.ConviteCampeonato;
import gokart.classes.Piloto;
import gokart.classes.PilotoCampeonato;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

public class TelaConvitesPendentes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private JLabel lblInfo;
	private JScrollPane scrollPane;
	private JButton btnConfirmar;
	private JButton btnVoltar;
	private JButton btnCancelar;
	private DefaultTableCellRenderer centralizado;


	public TelaConvitesPendentes(Piloto piloto) {
		setTitle("GoKart - Convites Pendentes");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
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
				
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfirmar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnConfirmar.setBackground(Color.BLACK);
			}
		});
		btnConfirmar.setForeground(Color.ORANGE);
		btnConfirmar.setBackground(Color.BLACK);
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setBounds(10, 422, 100, 23);
		contentPane.add(btnConfirmar);
		
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
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancelar.setBackground(Color.BLACK);
			}
		});
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setForeground(Color.ORANGE);
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(276, 422, 89, 23);
		contentPane.add(btnCancelar);
		
		lblInfo = new JLabel("Aqui voc\u00EA pode ver seus convites pendentes");
		lblInfo.setForeground(Color.ORANGE);
		lblInfo.setBackground(Color.ORANGE);
		lblInfo.setBounds(77, 73, 260, 14);
		contentPane.add(lblInfo);
		
		//CENTRALIZANDO OS ITENS DA TABELA
		centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		
		listarBaterias(piloto);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		btnConfirmar.addActionListener(new ActionListener() {
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
				PilotoCampeonato pc = new PilotoCampeonato();
				
				pc.setCamp(cc.getId_campeonato());
				pc.setPil(piloto);
				
				PilotoCampeonatoBo pcBo = new PilotoCampeonatoBo();
				pcBo.Salvar(pc);			
				
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
