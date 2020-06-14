package gokart.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import gokart.bo.PilotoBateriaBo;
import gokart.classes.Kartodromo;
import gokart.classes.PilotoBateria;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;


public class TelaMenuKartodromo extends JFrame {

	private JPanel contentPane;
	private JLabel lblHey;
	private JLabel lblNomeKartodromo;
	private JLabel lblReservas;
	private JButton btnReserva;
	private JLabel lblDataConsulta;
	private JTextField txtDataConsulta;
	private JButton btnBuscar;
	private JTable table;
	private LocalDate localDate;

	public TelaMenuKartodromo(Kartodromo k) {
		
		setTitle("GoKart  - Menu - Kartodromo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHey = new JLabel("Olá,");
		lblHey.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHey.setBounds(22, 25, 40, 24);
		contentPane.add(lblHey);
		
		lblNomeKartodromo = new JLabel("");
	    lblNomeKartodromo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeKartodromo.setBounds(56, 23, 160, 29);
		contentPane.add(lblNomeKartodromo);
		lblNomeKartodromo.setText(k.getNome());
		
		lblReservas = new JLabel("Verifique a situação de suas reservas");
		lblReservas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReservas.setBounds(56, 105, 255, 30);
		contentPane.add(lblReservas);
		
		btnReserva = new JButton("");
		btnReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReserva.setToolTipText("Nova Reserva");
		btnReserva.setBackground(Color.WHITE);
		btnReserva.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/bateria-32.png")));
		btnReserva.setBounds(325, 25, 40, 35);
		contentPane.add(btnReserva);
		
		lblDataConsulta = new JLabel("Data");
		lblDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataConsulta.setBounds(47, 164, 40, 16);
		contentPane.add(lblDataConsulta);
		
		txtDataConsulta = new JTextField();
		try {
			txtDataConsulta = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtDataConsulta.setColumns(10);
		txtDataConsulta.setBounds(97, 160, 79, 29);
		contentPane.add(txtDataConsulta);
		
		btnBuscar = new JButton("");
		btnBuscar.setToolTipText("Pesquisar");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/pesquisar-32.png")));
		btnBuscar.setBounds(198, 158, 40, 31);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 214, 355, 271);
		contentPane.add(scrollPane);

		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			"Data", "Horário", "Pilotos", "Traçado"
			}
		));
		scrollPane.setViewportView(table);
		
		//CENTRALIZANDO OS ITENS DA TABELA
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);	

		table.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(1).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(2).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(3).setCellRenderer(centralizado);
				
		btnReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaKartodromoBateria tl = new TelaKartodromoBateria(k);
				dispose();
				
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				carregarReservas();
				
			}
		});
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	private void carregarReservas(){
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data;

		if(!txtDataConsulta.getText().isBlank()) {
			localDate = LocalDate.parse(txtDataConsulta.getText(), formatador);
		}

		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo); 

		try {
			List<PilotoBateria> lista = new PilotoBateriaBo().bsucarReservas(localDate);
			for (PilotoBateria pb : lista) {
				data = pb.getBat().getData().format(formatador);
				modelo.addRow(new Object[] {
						data,
						pb.getBat().getHoraBateria(),
						pb.getBat().getNrMaxPiloto(),
						pb.getBat().getTracado()
				});

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,  e.getMessage());
		}	

	}
}
