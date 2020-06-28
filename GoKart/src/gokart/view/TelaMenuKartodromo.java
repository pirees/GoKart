package gokart.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JTextField txtDataConsulta_1;
	private JButton btnBuscar;
	private JTable table;
	private LocalDate localDate;
	private JScrollPane scrollPane;
	private JButton btDesligar;

	public TelaMenuKartodromo(Kartodromo k) {
		
		setTitle("GoKart  - Menu - Kartodromo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHey = new JLabel("Olá,");
		lblHey.setForeground(Color.ORANGE);
		lblHey.setBackground(Color.ORANGE);
		lblHey.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHey.setBounds(22, 33, 40, 24);
		contentPane.add(lblHey);
		
		lblNomeKartodromo = new JLabel("");
		lblNomeKartodromo.setForeground(Color.ORANGE);
		lblNomeKartodromo.setBackground(Color.ORANGE);
	    lblNomeKartodromo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeKartodromo.setBounds(56, 31, 160, 29);
		contentPane.add(lblNomeKartodromo);
		lblNomeKartodromo.setText(k.getNome());
		
		lblReservas = new JLabel("Verifique a situação de suas reservas");
		lblReservas.setForeground(Color.ORANGE);
		lblReservas.setBackground(Color.ORANGE);
		lblReservas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReservas.setBounds(56, 105, 255, 30);
		contentPane.add(lblReservas);
		
		btnReserva = new JButton("");
		btnReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReserva.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnReserva.setBackground(Color.ORANGE);
			}
		});	
		btnReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReserva.setToolTipText("Nova Reserva");
		btnReserva.setBackground(Color.ORANGE);
		btnReserva.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/bateria-32.png")));
		btnReserva.setBounds(325, 25, 40, 35);
		contentPane.add(btnReserva);
		
		lblDataConsulta = new JLabel("Data");
		lblDataConsulta.setForeground(Color.ORANGE);
		lblDataConsulta.setBackground(Color.ORANGE);
		lblDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataConsulta.setBounds(47, 164, 40, 16);
		contentPane.add(lblDataConsulta);
		
		txtDataConsulta = new JTextField();
		try {
			txtDataConsulta_1 = new JFormattedTextField(new MaskFormatter("##/##/####"));
			txtDataConsulta_1.setForeground(Color.ORANGE);
			txtDataConsulta_1.setBackground(Color.BLACK);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtDataConsulta_1.setColumns(10);
		txtDataConsulta_1.setBounds(97, 160, 79, 29);
		contentPane.add(txtDataConsulta_1);
		
		btnBuscar = new JButton("");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setBackground(Color.ORANGE);
			}
		});	
		btnBuscar.setToolTipText("Pesquisar");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBackground(Color.ORANGE);
		btnBuscar.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/pesquisar-32.png")));
		btnBuscar.setBounds(198, 158, 40, 31);
		contentPane.add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 214, 355, 271);
		contentPane.add(scrollPane);

		btDesligar = new JButton("");
		btDesligar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btDesligar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btDesligar.setBackground(Color.ORANGE);
			}
		});		
		btDesligar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btDesligar.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/iconDesligar.png")));
		btDesligar.setBackground(Color.ORANGE);
		btDesligar.setBounds(10, 11, 31, 23);
		contentPane.add(btDesligar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Piloto","Data", "Hor\u00E1rio", "Vagas", "Reserva", "Traçado"
			}
		));
		scrollPane.setViewportView(table);
		
		//CENTRALIZANDO OS ITENS DA TABELA
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
				
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
		
		btDesligar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tl = new TelaLogin();
				dispose();				
			}
		});
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	private void carregarReservas(){
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data;

		if(!txtDataConsulta_1.getText().isBlank()) {
			localDate = LocalDate.parse(txtDataConsulta_1.getText(), formatador);
		}

		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo); 

		try {
			List<PilotoBateria> lista = new PilotoBateriaBo().bsucarReservas(localDate);
			for (PilotoBateria pb : lista) {
				data = pb.getBat().getData().format(formatador);
				modelo.addRow(new Object[] {
						pb.getPil().getNome(),
						data,
						pb.getBat().getHoraBateria(),
						pb.getBat().getNrMaxPiloto(),
						pb.getNrEscolhaPiloto(),						
						pb.getBat().getTracado()
				});

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,  e.getMessage());
		}	

	}
}
