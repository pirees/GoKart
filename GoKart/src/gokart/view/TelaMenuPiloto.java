package gokart.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import gokart.bo.BateriaBo;
import gokart.bo.PilotoBateriaBo;
import gokart.classes.Bateria;
import gokart.classes.Piloto;
import gokart.classes.PilotoBateria;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Cursor;


public class TelaMenuPiloto extends JFrame {

	private JPanel contentPane;
	private JTextField txtKartodromo;
	private JTable table;
	private JLabel lblNomePiloto;
	private JLabel lblNivelPiloto;
	private JButton btnReserva;
	private JButton btnCampeonato;
	private JTextField txtNrPiloto;
	private JTextField txtHorario;
	private JTextField txtData;
	private JTextField txtKartodromoSalvar;
	private LocalDate localDate;
	private JLabel lblHey;
	private JTextField txtDataConsulta;
	private JTextField txtIdBateria;
	private JLabel lblSeuNvel;
	private JButton btnConfirmar; 
	private JLabel lblDataConsulta;
	private JLabel lblKartdromo;
	private JLabel lblData;
	private JLabel lblHorario;
	private JButton btnBuscar;
	private JLabel lblBoasVindas;
	private JLabel lblNumeroDePilotos;
	private JButton btnConvite;
	private JLabel lblKartodromo;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JTextField txtNrPilotoBateria;
	private DefaultTableCellRenderer centralizado;
	
	
	public TelaMenuPiloto(Piloto piloto){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    lblNomePiloto = new JLabel("");
	    lblNomePiloto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomePiloto.setBounds(56, 23, 160, 29);
		contentPane.add(lblNomePiloto);
		lblNomePiloto.setText(piloto.getNome());
			
		lblNivelPiloto = new JLabel("");
		lblNivelPiloto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNivelPiloto.setBounds(116, 51, 107, 29);
		contentPane.add(lblNivelPiloto);
		lblNivelPiloto.setText(piloto.getNivel().toString());
		
		lblKartodromo = new JLabel("Kart\u00F3dromo");
		lblKartodromo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKartodromo.setBounds(10, 137, 82, 16);
		contentPane.add(lblKartodromo);
		
		txtKartodromo = new JTextField();
		txtKartodromo.setBounds(102, 137, 168, 20);
		contentPane.add(txtKartodromo);
		txtKartodromo.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIdBateria.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				txtKartodromoSalvar.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				txtNrPilotoBateria.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				txtData.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				txtHorario.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
			}
		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "Kart\u00F3dromo", "Pilotos", "Tra\u00E7ado", "Data", "Hora"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.setBounds(32, 266, 333, 236);
		//contentPane.add(table);
		
		//CENTRALIZANDO OS ITENS DA TABELA
		centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(1).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(2).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(3).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(4).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(5).setCellRenderer(centralizado);
		
		btnConvite = new JButton("");
		btnConvite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConvite.setToolTipText("Convites Pendentes");
		btnConvite.setBackground(Color.WHITE);
		btnConvite.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/convite-32.png")));
		btnConvite.setBounds(325, 23, 40, 35);
		contentPane.add(btnConvite);
		
		btnReserva = new JButton("");
		btnReserva.setToolTipText("Baterias");
		btnReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReserva.setBackground(Color.WHITE);
		btnReserva.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/bateria-32.png")));
		btnReserva.setBounds(325, 63, 40, 35);
		contentPane.add(btnReserva);
		
		btnCampeonato = new JButton("");
		btnCampeonato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnCampeonato.setToolTipText("Novo Campeonato");
		btnCampeonato.setBackground(Color.WHITE);
		btnCampeonato.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/campeonato-32.png")));
		btnCampeonato.setBounds(325, 101, 40, 35);
		contentPane.add(btnCampeonato);
		
		lblHey = new JLabel("Olá,");
		lblHey.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHey.setBounds(22, 25, 40, 24);
		contentPane.add(lblHey);
		
		lblSeuNvel = new JLabel("Seu n\u00EDvel \u00E9:");
		lblSeuNvel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeuNvel.setBounds(22, 58, 107, 14);
		contentPane.add(lblSeuNvel);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setBounds(127, 639, 108, 29);
		contentPane.add(btnConfirmar);
		
		lblNumeroDePilotos = new JLabel("N\u00FAmero de pilotos");
		lblNumeroDePilotos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDePilotos.setBounds(10, 595, 130, 16);
		contentPane.add(lblNumeroDePilotos);
		
		lblBoasVindas = new JLabel("Fa\u00E7a agora a sua reserva");
		lblBoasVindas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBoasVindas.setBounds(92, 106, 180, 30);
		contentPane.add(lblBoasVindas);
		
		btnBuscar = new JButton("");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setToolTipText("Pesquisar");
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/pesquisar-32.png")));
		btnBuscar.setBounds(280, 149, 40, 31);
		contentPane.add(btnBuscar);
		
		txtNrPiloto = new JTextField();
		txtNrPiloto.setBounds(139, 595, 48, 20);
		contentPane.add(txtNrPiloto);
		txtNrPiloto.setColumns(10);
		
		lblHorario = new JLabel("Hor\u00E1rio");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorario.setBounds(10, 557, 130, 16);
		contentPane.add(lblHorario);
		
		lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 518, 130, 16);
		contentPane.add(lblData);
		
		lblKartdromo = new JLabel("Kart\u00F3dromo");
		lblKartdromo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKartdromo.setBounds(10, 491, 130, 16);
		contentPane.add(lblKartdromo);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(139, 557, 77, 20);
		txtHorario.setEditable(false);
		contentPane.add(txtHorario);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(139, 518, 77, 20);
		txtData.setEditable(false);
		contentPane.add(txtData);
		
		txtKartodromoSalvar = new JTextField();
		txtKartodromoSalvar.setColumns(10);
		txtKartodromoSalvar.setBounds(139, 489, 131, 20);
		txtKartodromoSalvar.setEditable(false);
		contentPane.add(txtKartodromoSalvar);
		
		txtDataConsulta = new JTextField();
		try {
			txtDataConsulta = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtDataConsulta.setColumns(10);
		txtDataConsulta.setBounds(102, 168, 168, 20);
		contentPane.add(txtDataConsulta);
		
		lblDataConsulta = new JLabel("Data");
		lblDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataConsulta.setBounds(10, 164, 82, 16);
		contentPane.add(lblDataConsulta);
		
		txtIdBateria = new JTextField();
		txtIdBateria.setColumns(10);
		txtIdBateria.setBounds(283, 534, 48, 20);
		txtIdBateria.setVisible(false);
		contentPane.add(txtIdBateria);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 199, 355, 281);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		txtNrPilotoBateria = new JTextField();
		txtNrPilotoBateria.setBounds(283, 576, 48, 20);
		contentPane.add(txtNrPilotoBateria);
		txtNrPilotoBateria.setVisible(false);
		txtNrPilotoBateria.setColumns(10);
		
		btnConvite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaConvitesPendentes tcp = new TelaConvitesPendentes(piloto);
				dispose();
			}
		});


		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pesquisarBateriaNome();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
				try {
					salvarBateria(piloto);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!(table.getSelectedRow() < 0)) {
                    modelo.removeRow(table.getSelectedRow());
                }
			}

		});
		
		btnCampeonato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCampeonato cp = new TelaCampeonato(piloto);				
				dispose();
			}
		});
		
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	private void pesquisarBateriaNome() {	

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data;

		if(!txtDataConsulta.getText().isBlank()) {
			localDate = LocalDate.parse(txtDataConsulta.getText(), formatador);
		}
		
		modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo); 

		try {
			List<Bateria> lista = new BateriaBo().listarBateriasNome(txtKartodromo.getText(), localDate);
			for (Bateria b : lista) {
				data = b.getData().format(formatador);
				modelo.addRow(new Object[] {
						b.getId(),
						b.getKartodromo(),
						b.getNrMaxPiloto(),
						b.getTracado(),
						data,
						b.getHoraBateria()
				});
				
				table.getColumnModel().getColumn(0).setMinWidth(0);
				table.getColumnModel().getColumn(0).setMaxWidth(0);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,  e.getMessage());
		}	
	}
	
	private void salvarBateria(Piloto piloto) {
		PilotoBateria pilotobateria = new PilotoBateria();
		Bateria b = new Bateria();
		
		b.setId(Integer.parseInt(txtIdBateria.getText()));		
		b.setNrMaxPiloto(Integer.parseInt(txtNrPilotoBateria.getText()));


		pilotobateria.setBat(b);
		pilotobateria.setPil(piloto);
		pilotobateria.setNrEscolhaPiloto(Integer.parseInt(txtNrPiloto.getText()));
		
		PilotoBateriaBo pilotobateriaBo = new PilotoBateriaBo();		
		
		try {
			
			if(pilotobateria.getNrEscolhaPiloto() > b.getNrMaxPiloto()) {
				JOptionPane.showMessageDialog(null, "Número de vagas indisponíveis");
			}else {
				JOptionPane.showMessageDialog(null, "Bateria " + pilotobateriaBo.Salvar(pilotobateria));	
			}
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "ERRO:" + e1.getMessage());
			e1.printStackTrace();
		}
	}
}
