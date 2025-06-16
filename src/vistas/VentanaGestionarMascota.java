package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class VentanaGestionarMascota extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 JTextField txxDueno;
	 JTextField txtRaza;
	 JTextField txtNombreMascota;
	JTextField txtSexo;
	JButton btnRegistrar, btnEliminar, btnConsultar, btnActualizar, btnLista;
	JTextArea textArea;

	private Coordinador coordinador;
	 public VentanaGestionarMascota(JFrame parent, boolean modal) {
	        super(parent, modal);
		
		setBounds(100, 100, 485, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(parent);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		JLabel lblTitle = new JLabel("Gestión Mascota");
		lblTitle.setForeground(new Color(102, 0, 102));
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 19));
		lblTitle.setBounds(150, 10, 187, 24);
		contentPane.add(lblTitle);
		
		JLabel lblDueno = new JLabel("ID dueño");
		lblDueno.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		lblDueno.setBounds(21, 53, 99, 24);
		contentPane.add(lblDueno);
		
		txxDueno = new JTextField();
		txxDueno.setFont(new Font("Myanmar Text", Font.PLAIN, 16));
		txxDueno.setColumns(10);
		txxDueno.setBounds(117, 48, 115, 24);
		contentPane.add(txxDueno);
		
		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		lblRaza.setBounds(258, 53, 99, 24);
		contentPane.add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setFont(new Font("Myanmar Text", Font.PLAIN, 16));
		txtRaza.setColumns(10);
		txtRaza.setBounds(335, 48, 115, 24);
		contentPane.add(txtRaza);
		
		txtNombreMascota = new JTextField();
		txtNombreMascota.setFont(new Font("Myanmar Text", Font.PLAIN, 16));
		txtNombreMascota.setColumns(10);
		txtNombreMascota.setBounds(117, 87, 115, 24);
		contentPane.add(txtNombreMascota);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		lblNombre.setBounds(21, 92, 99, 24);
		contentPane.add(lblNombre);
		
		 btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnRegistrar.setBounds(10, 139, 108, 21);
		contentPane.add(btnRegistrar);
		
		 btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnConsultar.setBounds(124, 139, 108, 21);
		contentPane.add(btnConsultar);
		
		 btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnActualizar.setBounds(242, 139, 108, 21);
		contentPane.add(btnActualizar);
		
		 btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnEliminar.setBounds(360, 139, 108, 21);
		contentPane.add(btnEliminar);
		
		 btnLista = new JButton("Consultar Lista");
		btnLista.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnLista.setBounds(134, 170, 223, 21);
		contentPane.add(btnLista);
		
		txtSexo = new JTextField();
		txtSexo.setFont(new Font("Myanmar Text", Font.PLAIN, 16));
		txtSexo.setColumns(10);
		txtSexo.setBounds(335, 82, 115, 24);
		contentPane.add(txtSexo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		lblSexo.setBounds(258, 87, 99, 24);
		contentPane.add(lblSexo);
		
		textArea = new JTextArea();
		textArea.setBounds(31, 201, 437, 112);
		contentPane.add(textArea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 127, 429, 2);
		contentPane.add(separator);		
	}
	
	//coordinador
	  public void setCoordinador(Coordinador coordinador) {
	        this.coordinador = coordinador;
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
