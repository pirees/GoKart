package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gokart.bo.KartodromoBateriaBo;
import gokart.bo.KartodromoBo;
import gokart.classes.Estado;
import gokart.classes.Kartodromo;
import gokart.classes.KartodromoBateria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class TelaKartodromoBateria extends JFrame {

	private JPanel contentPane;
	private JTextField txtNrMaxPilotos;
	private JTextField txtHorario;
	private JTextField txtTracado;
	private JTextField txtData;


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
		
		JLabel C = new JLabel("Cadastro de Baterias");
		C.setFont(new Font("Tahoma", Font.PLAIN, 16));
		C.setBounds(73, 48, 154, 20);
		contentPane.add(C);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(31, 145, 37, 14);
		contentPane.add(lblData);
		
		JLabel lblHorario = new JLabel("Hor\u00E1rio");
		lblHorario.setBounds(29, 179, 64, 14);
		contentPane.add(lblHorario);
		
		JLabel lblNmeroDePilotos = new JLabel("N\u00FAmero de Pilotos");
		lblNmeroDePilotos.setBounds(29, 214, 120, 14);
		contentPane.add(lblNmeroDePilotos);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(60, 331, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(207, 331, 89, 23);
		contentPane.add(btnCancelar);
		
		txtNrMaxPilotos = new JTextField();
		txtNrMaxPilotos.setColumns(10);
		txtNrMaxPilotos.setBounds(125, 211, 120, 20);
		contentPane.add(txtNrMaxPilotos);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(125, 176, 120, 20);
		contentPane.add(txtHorario);


		JLabel lblTracado = new JLabel("Tra\u00E7ado");
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
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate dataFinal = LocalDate.parse(txtData.getText().replaceAll("/", "-"), formatador);
				
				KartodromoBateria kartodromo = new KartodromoBateria();
				kartodromo.setData(dataFinal);
				kartodromo.setHoraBateria(txtHorario.getText());
				kartodromo.setNrMaxPiloto(Integer.parseInt(txtNrMaxPilotos.getText()));
				kartodromo.setTracado(txtTracado.getText());
				kartodromo.setKartodromo(k);
			
				try {
					
					KartodromoBateriaBo kartodromobateriaBo = new KartodromoBateriaBo();

					JOptionPane.showMessageDialog(null, "Reservas configuradas com sucesso " + kartodromobateriaBo.Salvar(kartodromo));

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO:" + e1.getMessage());
					e1.printStackTrace();
				}

			}
		});
	}
}
