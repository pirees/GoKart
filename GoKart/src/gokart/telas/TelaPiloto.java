package gokart.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPiloto extends JFrame {

	private JPanel PainelPrincipal;

	public TelaPiloto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PainelPrincipal = new JPanel();
		PainelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		PainelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(PainelPrincipal);
	}

}
