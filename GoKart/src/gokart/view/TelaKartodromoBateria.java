package gokart.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import gokart.bo.BateriaBo;
import gokart.classes.Bateria;
import gokart.classes.Kartodromo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class TelaKartodromoBateria extends JFrame {

	private JPanel contentPane;
	private JTextField txtNrMaxPilotos;
	private JTextField txtHorario;
	private JTextField txtTracado;
	private JTextField txtData;
	private JTextField txtData_1;
	private JLabel C;
	private JLabel lblData;
	private JLabel lblHorario;
	private JLabel lblNmeroDePilotos;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private JLabel lblTracado;

	/**
	 * Create the frame.
	 */
	public TelaKartodromoBateria(Kartodromo k) {
		
		setTitle("GoKart - Cadastro Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 718);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    C = new JLabel("Cadastro de Baterias");
	    C.setForeground(Color.ORANGE);
	    C.setBackground(Color.ORANGE);
		C.setFont(new Font("Tahoma", Font.PLAIN, 18));
		C.setBounds(102, 75, 186, 20);
		contentPane.add(C);
		
		lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setForeground(Color.ORANGE);
		lblData.setBackground(Color.ORANGE);
		lblData.setBounds(31, 145, 37, 14);
		contentPane.add(lblData);
		
		lblHorario = new JLabel("Hor\u00E1rio");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorario.setForeground(Color.ORANGE);
		lblHorario.setBackground(Color.ORANGE);
		lblHorario.setBounds(29, 179, 64, 14);
		contentPane.add(lblHorario);
		
		lblNmeroDePilotos = new JLabel("N\u00FAmero de Pilotos");
		lblNmeroDePilotos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmeroDePilotos.setForeground(Color.ORANGE);
		lblNmeroDePilotos.setBackground(Color.ORANGE);
		lblNmeroDePilotos.setBounds(29, 214, 120, 14);
		contentPane.add(lblNmeroDePilotos);
		
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
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setBounds(132, 337, 89, 23);
		contentPane.add(btnSalvar);
		
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
		btnVoltar.setIcon(new ImageIcon(TelaKartodromoBateria.class.getResource("/img/voltar - 32.png")));
		btnVoltar.setBounds(20, 31, 30, 29);
		contentPane.add(btnVoltar);
		
		txtNrMaxPilotos = new JTextField();
		txtNrMaxPilotos.setForeground(Color.ORANGE);
		txtNrMaxPilotos.setBackground(Color.BLACK);
		txtNrMaxPilotos.setColumns(10);
		txtNrMaxPilotos.setBounds(187, 213, 120, 20);
		contentPane.add(txtNrMaxPilotos);
		
		txtHorario = new JTextField();
		txtHorario.setForeground(Color.ORANGE);
		txtHorario.setBackground(Color.BLACK);
		txtHorario.setColumns(10);
		txtHorario.setBounds(187, 178, 120, 20);
		contentPane.add(txtHorario);


		lblTracado = new JLabel("Tra\u00E7ado");
		lblTracado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTracado.setForeground(Color.ORANGE);
		lblTracado.setBackground(Color.ORANGE);
		lblTracado.setBounds(29, 253, 64, 23);
		contentPane.add(lblTracado);
		
		txtTracado = new JTextField();
		txtTracado.setForeground(Color.ORANGE);
		txtTracado.setBackground(Color.BLACK);
		txtTracado.setColumns(10);
		txtTracado.setBounds(187, 256, 120, 20);
		contentPane.add(txtTracado);
		
		txtData = new JTextField();
		try {
			txtData_1 = new JFormattedTextField(new MaskFormatter("##/##/####"));
			txtData_1.setForeground(Color.ORANGE);
			txtData_1.setBackground(Color.BLACK);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtData_1.setColumns(10);
		txtData_1.setBounds(187, 144, 120, 20);
		contentPane.add(txtData_1);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuKartodromo tmk = new TelaMenuKartodromo(k);
				dispose();
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarBateria(k);
				TelaMenuKartodromo tmk = new TelaMenuKartodromo(k);
				dispose();
			}
		});
	}
	
	public void salvarBateria(Kartodromo k) {
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dataFinal = LocalDate.parse(txtData_1.getText().replaceAll("/", "-"), formatador);

		LocalTime horaFormatada = LocalTime.parse(txtHorario.getText());
	
		Bateria bateria = new Bateria();
		bateria.setData(dataFinal);
		bateria.setHoraBateria(horaFormatada);
		bateria.setNrMaxPiloto(Integer.parseInt(txtNrMaxPilotos.getText()));
		bateria.setTracado(txtTracado.getText());
		bateria.setKartodromo(k);
		
		BateriaBo bateriaBo = new BateriaBo();
		try {
			bateriaBo.Salvar(bateria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			JOptionPane.showMessageDialog(null, "Bateria cadastrada com sucesso");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERRO:" + e1.getMessage());
			e1.printStackTrace();
		}
		
	}
}
