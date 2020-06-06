package gokart.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import gokart.bo.BateriaBo;
import gokart.bo.PilotoBateriaBo;
import gokart.classes.Bateria;
import gokart.classes.Kartodromo;
import gokart.classes.Piloto;
import gokart.classes.PilotoBateria;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.awt.Color;


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
	
	Bateria b = new Bateria();
	private JTextField txtDataConsulta;
	private JTextField txtIdBateria;
	
	
	public TelaMenuPiloto(Piloto piloto) throws Exception {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(127, 622, 48, 14);
		contentPane.add(label);
		
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
		
		JLabel lblKartodromo = new JLabel("Kart\u00F3dromo");
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
				txtNrPiloto.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				txtData.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				txtHorario.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
			}
		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"IdBateria", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(10, 203, 355, 275);
		contentPane.add(table);
		
		JButton btnConvite = new JButton("");
		btnConvite.setToolTipText("Convites Pendentes");
		btnConvite.setBackground(Color.WHITE);
		btnConvite.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/convite-32.png")));
		btnConvite.setBounds(325, 23, 40, 35);
		contentPane.add(btnConvite);
		
		btnReserva = new JButton("");
		btnReserva.setToolTipText("Baterias");
		btnReserva.setBackground(Color.WHITE);
		btnReserva.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/bateria-32.png")));
		btnReserva.setBounds(325, 63, 40, 35);
		contentPane.add(btnReserva);
		
		btnCampeonato = new JButton("");
		btnCampeonato.setToolTipText("Novo Campeonato");
		btnCampeonato.setBackground(Color.WHITE);
		btnCampeonato.setIcon(new ImageIcon(TelaMenuPiloto.class.getResource("/img/campeonato-32.png")));
		btnCampeonato.setBounds(325, 101, 40, 35);
		contentPane.add(btnCampeonato);
		
		JLabel lblHey = new JLabel("Olá,");
		lblHey.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHey.setBounds(22, 25, 40, 24);
		contentPane.add(lblHey);
		
		JLabel lblSeuNvel = new JLabel("Seu n\u00EDvel \u00E9:");
		lblSeuNvel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeuNvel.setBounds(22, 58, 107, 14);
		contentPane.add(lblSeuNvel);
		
		JButton btnPesquisar = new JButton("Confirmar");
		btnPesquisar.setBounds(127, 639, 108, 29);
		contentPane.add(btnPesquisar);
		
		JLabel lblNmeroDePilotos = new JLabel("N\u00FAmero de pilotos");
		lblNmeroDePilotos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmeroDePilotos.setBounds(10, 595, 130, 16);
		contentPane.add(lblNmeroDePilotos);
		
		JLabel lblNewLabel = new JLabel("Fa\u00E7a agora a sua reserva");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(92, 106, 180, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBounds(298, 157, 30, 23);
		contentPane.add(btnBuscar);
		
		txtNrPiloto = new JTextField();
		txtNrPiloto.setBounds(139, 595, 48, 20);
		contentPane.add(txtNrPiloto);
		txtNrPiloto.setEditable(false);
		txtNrPiloto.setColumns(10);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio");
		lblHorrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorrio.setBounds(10, 557, 130, 16);
		contentPane.add(lblHorrio);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 518, 130, 16);
		contentPane.add(lblData);
		
		JLabel lblKartdromo = new JLabel("Kart\u00F3dromo");
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
		txtKartodromoSalvar.setBounds(139, 489, 77, 20);
		txtKartodromoSalvar.setEditable(false);
		contentPane.add(txtKartodromoSalvar);
		
		txtDataConsulta = new JTextField();
		txtDataConsulta.setColumns(10);
		txtDataConsulta.setBounds(102, 168, 168, 20);
		contentPane.add(txtDataConsulta);
		
		JLabel lblDataConsulta = new JLabel("Data");
		lblDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataConsulta.setBounds(10, 164, 82, 16);
		contentPane.add(lblDataConsulta);
		
		txtIdBateria = new JTextField();
		txtIdBateria.setColumns(10);
		txtIdBateria.setBounds(283, 534, 48, 20);
		txtIdBateria.setVisible(false);
		contentPane.add(txtIdBateria);

		
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
		
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
				salvarBateria(piloto);				
			}
				
		});
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}

	
	private void pesquisarBateriaNome() {	

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data;

		
		//LocalDate localDate = LocalDate.parse(txtDataConsulta.getText(), formatador);

		if(!txtDataConsulta.getText().isBlank()) {
			localDate = LocalDate.parse(txtDataConsulta.getText(), formatador);
		}
		
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
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
		
		b.setId(Integer.parseInt(txtIdBateria.getText()));

		pilotobateria.setBat(b);
		pilotobateria.setPil(piloto);

		
		PilotoBateriaBo pilotobateriaBo = new PilotoBateriaBo();

		try {

			JOptionPane.showMessageDialog(null, "Bateria " + pilotobateriaBo.Salvar(pilotobateria));

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERRO:" + e1.getMessage());
			e1.printStackTrace();
		}
	}
}
