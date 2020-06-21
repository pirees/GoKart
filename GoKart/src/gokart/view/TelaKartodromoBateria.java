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
		
		setTitle("GoKart");
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
		C.setFont(new Font("Tahoma", Font.PLAIN, 16));
		C.setBounds(73, 48, 154, 20);
		contentPane.add(C);
		
		lblData = new JLabel("Data");
		lblData.setForeground(Color.ORANGE);
		lblData.setBackground(Color.ORANGE);
		lblData.setBounds(31, 145, 37, 14);
		contentPane.add(lblData);
		
		lblHorario = new JLabel("Hor\u00E1rio");
		lblHorario.setForeground(Color.ORANGE);
		lblHorario.setBackground(Color.ORANGE);
		lblHorario.setBounds(29, 179, 64, 14);
		contentPane.add(lblHorario);
		
		lblNmeroDePilotos = new JLabel("N\u00FAmero de Pilotos");
		lblNmeroDePilotos.setForeground(Color.ORANGE);
		lblNmeroDePilotos.setBackground(Color.ORANGE);
		lblNmeroDePilotos.setBounds(29, 214, 120, 14);
		contentPane.add(lblNmeroDePilotos);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.ORANGE);
		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setBounds(132, 327, 89, 23);
		contentPane.add(btnSalvar);
		
		btnVoltar = new JButton("");
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
		txtNrMaxPilotos.setBounds(152, 211, 120, 20);
		contentPane.add(txtNrMaxPilotos);
		
		txtHorario = new JTextField();
		txtHorario.setForeground(Color.ORANGE);
		txtHorario.setBackground(Color.BLACK);
		txtHorario.setColumns(10);
		txtHorario.setBounds(152, 176, 120, 20);
		contentPane.add(txtHorario);


		lblTracado = new JLabel("Tra\u00E7ado");
		lblTracado.setForeground(Color.ORANGE);
		lblTracado.setBackground(Color.ORANGE);
		lblTracado.setBounds(29, 259, 64, 14);
		contentPane.add(lblTracado);
		
		txtTracado = new JTextField();
		txtTracado.setForeground(Color.ORANGE);
		txtTracado.setBackground(Color.BLACK);
		txtTracado.setColumns(10);
		txtTracado.setBounds(152, 256, 120, 20);
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
		txtData_1.setBounds(152, 142, 120, 20);
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
	
		try {
			
			BateriaBo bateriaBo = new BateriaBo();

			JOptionPane.showMessageDialog(null, "Reservas configuradas com sucesso " + bateriaBo.Salvar(bateria));

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERRO:" + e1.getMessage());
			e1.printStackTrace();
		}
		
	}
}
