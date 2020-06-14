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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    C = new JLabel("Cadastro de Baterias");
		C.setFont(new Font("Tahoma", Font.PLAIN, 16));
		C.setBounds(73, 48, 154, 20);
		contentPane.add(C);
		
		lblData = new JLabel("Data");
		lblData.setBounds(31, 145, 37, 14);
		contentPane.add(lblData);
		
		lblHorario = new JLabel("Hor\u00E1rio");
		lblHorario.setBounds(29, 179, 64, 14);
		contentPane.add(lblHorario);
		
		lblNmeroDePilotos = new JLabel("N\u00FAmero de Pilotos");
		lblNmeroDePilotos.setBounds(29, 214, 120, 14);
		contentPane.add(lblNmeroDePilotos);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(60, 331, 89, 23);
		contentPane.add(btnSalvar);
		
		btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setToolTipText("Voltar ");
		btnVoltar.setIcon(new ImageIcon(TelaKartodromoBateria.class.getResource("/img/voltar - 32.png")));
		btnVoltar.setBounds(20, 31, 30, 29);
		contentPane.add(btnVoltar);
		
		txtNrMaxPilotos = new JTextField();
		txtNrMaxPilotos.setColumns(10);
		txtNrMaxPilotos.setBounds(125, 211, 120, 20);
		contentPane.add(txtNrMaxPilotos);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(125, 176, 120, 20);
		contentPane.add(txtHorario);


		lblTracado = new JLabel("Tra\u00E7ado");
		lblTracado.setBounds(29, 259, 45, 14);
		contentPane.add(lblTracado);
		
		txtTracado = new JTextField();
		txtTracado.setColumns(10);
		txtTracado.setBounds(125, 256, 120, 20);
		contentPane.add(txtTracado);
		
		txtData = new JTextField();
		try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtData.setColumns(10);
		txtData.setBounds(125, 142, 120, 20);
		contentPane.add(txtData);
		
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
		LocalDate dataFinal = LocalDate.parse(txtData.getText().replaceAll("/", "-"), formatador);

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
