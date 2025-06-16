package vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel lblimagen;
	 JButton btnGestionPersona;
	 JButton btnGestionMascota;
	
	 private Coordinador coordinador;
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		lblimagen = new JLabel("");
		lblimagen.setBounds(0, -14, 482, 500);
		lblimagen.setIcon(new ImageIcon(getClass().getResource("/imagen/fondoVet.png")));
		
		
		
		btnGestionPersona = new JButton("Gestionar persona");
		btnGestionPersona.setForeground(new Color(153, 0, 153));
		btnGestionPersona.setBackground(new Color(255, 255, 255));
		btnGestionPersona.setBounds(68, 428, 156, 23);
		contentPane.add(btnGestionPersona);
		btnGestionPersona.addActionListener(this);
		
		btnGestionMascota = new JButton("Gestionar mascota");
		btnGestionMascota.setForeground(new Color(153, 0, 153));
		btnGestionMascota.setBackground(new Color(255, 255, 255));
		btnGestionMascota.setBounds(253, 428, 156, 23);
		contentPane.add(btnGestionMascota);
		btnGestionMascota.addActionListener(this);
		
		contentPane.add(lblimagen);		
	}
	//coordinador
	  public void setCoordinador(Coordinador coordinador) {
	        this.coordinador = coordinador;
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnGestionPersona) {
			coordinador.mostrarVentanaPersonas();
		}else {
			coordinador.mostrarVentanaMascotas();
		}
	}
}