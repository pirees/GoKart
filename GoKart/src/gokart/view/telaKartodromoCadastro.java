package gokart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class telaKartodromoCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaKartodromoCadastro frame = new telaKartodromoCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public telaKartodromoCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTraado = new JLabel("Tra\u00E7ado");
		lblTraado.setBounds(69, 114, 48, 14);
		contentPane.add(lblTraado);
		
		JLabel lblNmeroDePilotos = new JLabel("N\u00FAmero m\u00EDnimo de pilotos");
		lblNmeroDePilotos.setBounds(69, 139, 138, 14);
		contentPane.add(lblNmeroDePilotos);
		
		JLabel lblNmeroMximoDe = new JLabel("N\u00FAmero m\u00E1ximo de pilotos");
		lblNmeroMximoDe.setBounds(69, 164, 138, 14);
		contentPane.add(lblNmeroMximoDe);
		
		textField = new JTextField();
		textField.setBounds(238, 111, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(238, 136, 96, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(238, 161, 96, 20);
		contentPane.add(textField_2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(414, 324, 89, 23);
		contentPane.add(btnSalvar);
	}
}
