package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.dto.PersonaDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

public class VentanaGestionarPersona extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField txtDocumento;
	JTextField txtTelefono;
	JTextField txtNombre;
	JButton btnRegistrar, btnEliminar, btnConsultar, btnActualizar, btnLista;
	JTextArea textArea;

	
	private Coordinador coordinador;
	
	 public VentanaGestionarPersona(JFrame parent, boolean modal) {
	        super(parent, modal);

		setBounds(100, 100, 495, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(parent);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		JLabel lblTitle = new JLabel("Gestión Dueño");
		lblTitle.setForeground(new Color(102, 0, 102));
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 19));
		lblTitle.setBounds(150, 10, 187, 24);
		contentPane.add(lblTitle);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		lblDocumento.setBounds(21, 53, 99, 24);
		contentPane.add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Myanmar Text", Font.PLAIN, 16));
		txtDocumento.setBounds(117, 48, 115, 24);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		lblTelefono.setBounds(258, 53, 99, 24);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Myanmar Text", Font.PLAIN, 16));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(335, 48, 115, 24);
		contentPane.add(txtTelefono);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		lblNombre.setBounds(21, 92, 99, 24);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Myanmar Text", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(117, 87, 333, 24);
		contentPane.add(txtNombre);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 126, 403, 3);
		contentPane.add(separator);
		
		 btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnRegistrar.setBounds(10, 139, 108, 21);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		
		 btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnConsultar.setBounds(124, 139, 108, 21);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(this);
		
		 btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnActualizar.setBounds(242, 139, 108, 21);
		contentPane.add(btnActualizar);
		btnActualizar.addActionListener(this);
		
		 btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnEliminar.setBounds(360, 139, 108, 21);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		 btnLista = new JButton("Consultar Lista");
		btnLista.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnLista.setBounds(134, 170, 223, 21);
		contentPane.add(btnLista);
		btnLista.addActionListener(this);
		
		 textArea = new JTextArea();
		textArea.setLineWrap(true); // slto de linea
		textArea.setWrapStyleWord(true); // rompe en palabras
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 209, 458, 120);
		contentPane.add(scrollPane);
	}
	//coordinador
	  public void setCoordinador(Coordinador coordinador) {
	        this.coordinador = coordinador;
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRegistrar) {
			try {
				registrarPersona();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getSource()==btnConsultar) {
			try {
				consultarPersona();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getSource()==btnActualizar) {
			try {
				actualizarPersona();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getSource()==btnEliminar) {
			try {
				eliminarPersona();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getSource()== btnLista) {
			try {
				listaPersonas();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	


	//metodos segun boton 
	private void registrarPersona() throws SQLException{
		String documento = txtDocumento.getText();
		String nombre = txtNombre.getText();
		String telefono = txtTelefono.getText();
		
		//validation
		if (!coordinador.validarTextoPersona(documento)) {
			JOptionPane.showMessageDialog(this, "Campo de documento obligatorio");
			return;
		}
		if (!coordinador.validarTextoPersona(nombre)) {
			JOptionPane.showMessageDialog(this, "Campo de nombre obligatorio");
			return;
		}
		if (!coordinador.validarNumPersona(telefono)) {
			JOptionPane.showMessageDialog(this, "campo de telefono obligatorio");
			return;
		}
		
		
		PersonaDTO persona = new PersonaDTO();
		persona.setDocumento(documento);
		persona.setNombre(nombre);
		persona.setTelefono(Integer.parseInt(telefono));
		
		String res= coordinador.guardarPersona(persona);
		System.out.println("Documento: " + persona.getDocumento());
	    System.out.println("Nombre: " + persona.getNombre());
	    System.out.println("Tel: " + persona.getTelefono());
	    
	    if (res.equals("ok")) {
			JOptionPane.showMessageDialog(this, "Registro exitoso");
			limpiarDatos();
			
			String resumen = "Documento: "+documento+"\n"+
							 "Nombre: "+nombre+"\n"+
							 "Telefono: "+telefono;
			textArea.setText(resumen);
		}else {
			textArea.setText("Error al registrar");
		}
	}
	private void consultarPersona() throws SQLException{
		String documento = txtDocumento.getText();
		String resumen;
		if (!coordinador.validarTextoPersona(documento)) {
			String validacion= "Ingrese un documento para consultar";
			textArea.setText(validacion);
			return;
		}
		PersonaDTO persona = coordinador.buscarPorDocumento(documento);
		if (persona!=null) {
			 resumen =  "Documento: "+persona.getDocumento()+"\n"+
					 "Nombre: "+persona.getNombre()+"\n"+
					 "Telefono: "+persona.getTelefono();
			textArea.setText(resumen);
			limpiarDatos();
		}else {
			resumen ="Persona no encontrada, intentalo de nuevo";
			textArea.setText(resumen);
			limpiarDatos();
		}
		
	}
	private void actualizarPersona() throws SQLException {
		String documento = txtDocumento.getText();
		String nombre = txtNombre.getText();
		String telefono = txtTelefono.getText();
		String resumen;
		if (!coordinador.validarTextoPersona(documento)) {
			JOptionPane.showMessageDialog(this, "Recuerda ingresar un documento para actualizar");
			return;
		}
		PersonaDTO persona = new PersonaDTO();
		persona.setDocumento(documento);
		persona.setNombre(nombre);
		persona.setTelefono(Integer.parseInt(telefono));
		
		String confirmar=coordinador.actualizarPersona(persona);
		if (confirmar.equals("ok")) {
			resumen = "Documento: "+persona.getDocumento() +"\n"
						+"Nombre: "+persona.getNombre()+"\n"
						+"Telefono: "+persona.getTelefono();
			
			textArea.setText(resumen);
			limpiarDatos();
		}else if (confirmar.equals("error")) {
			resumen = "Error al actualizar,documento inexistente, intentalo nuevamente";
			textArea.setText(resumen);
			limpiarDatos();
		}else {
			resumen = "Error inesperado, intentalo nuevamente";
			textArea.setText(resumen);
			limpiarDatos();
		}
		
	}
	private void eliminarPersona() throws SQLException {
		String documento = txtDocumento.getText();
		String confirm;
		String resumen;
		if (!coordinador.validarTextoPersona(documento)) {
			JOptionPane.showMessageDialog(this, "Recuerda ingresar un documento para eliminar");
			return;
		}
		PersonaDTO persona = new PersonaDTO();
		persona.setDocumento(documento);
		confirm = coordinador.eliminarPersona(persona);
		if (confirm.equals("ok")) {
			resumen = "Persona con documento "+ persona.getDocumento()+" eliminada";
			textArea.setText(resumen);
			limpiarDatos();
		}else if (confirm.equals("error")) {
			resumen = "Documento"+persona.getDocumento()+" inexistente\nIntentalo nuevamente";
			textArea.setText(resumen);
			limpiarDatos();
		}else {
			resumen ="error inesperado";
			textArea.setText(resumen);
			limpiarDatos();
		}
	}
	
	private void listaPersonas() throws SQLException {
		ArrayList<PersonaDTO> listaRegistros = coordinador.listaPersonas();
		String resumen;
		if (listaRegistros==null) {
			resumen ="lista vacia";
			return;
		}
	
		resumen = "Lista personas: \n\n";
		
		for(PersonaDTO persona : listaRegistros) {
			resumen+="Documento: "+persona.getDocumento()
					+"\nNombre: "+persona.getNombre()
					+"\nTelefono: "+persona.getTelefono()
					+"\n-------------------------------\n";
		}
		textArea.setText(resumen);
		
		
		
	}
	
	//otros metodos
	private void limpiarDatos() {
		txtDocumento.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
	}
}
