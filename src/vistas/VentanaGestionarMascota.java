package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.dto.MascotaDTO;
import modelo.dto.PersonaDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class VentanaGestionarMascota extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 JTextField txtDueno;
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
		
		txtDueno = new JTextField();
		txtDueno.setFont(new Font("Myanmar Text", Font.PLAIN, 16));
		txtDueno.setColumns(10);
		txtDueno.setBounds(117, 48, 115, 24);
		contentPane.add(txtDueno);
		
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
		if (e.getSource()==btnRegistrar) {
			try {
				registrar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()==btnConsultar) {
			try {
				consultarMascota();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()==btnLista) {
			try {
				listaMascotas();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()==btnActualizar) {
			try {
				actualizar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()==btnEliminar) {
			try {
				eliminar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private void limpiarDatos() {
		txtDueno.setText("");
		txtNombreMascota.setText("");
		txtRaza.setText("");
		txtSexo.setText("");
	}

	private void registrar() throws SQLException{
		 String docDueno = txtDueno.getText();
		 String nombre = txtNombreMascota.getText();
		 String raza = txtRaza.getText();
		 String sexo = txtSexo.getText();
		 
		 //validation
		 if (!coordinador.validarTextoMascota(sexo)) {
			JOptionPane.showMessageDialog(this, "Campo de sexo obligatorio, intentalo de nuevo");
			return;
		}
		 if (!coordinador.validarTextoMascota(raza)) {
			JOptionPane.showMessageDialog(this, "Campo de raza obligatorio, intentalo de nuevo");
			return;
		}
		 if (!coordinador.validarTextoMascota(nombre)) {
			JOptionPane.showMessageDialog(this, "Campo de nombre obligatorio, intentalo de nuevo");
			return;
		}
		 if (!coordinador.validarNumMascota(docDueno)) {
			JOptionPane.showMessageDialog(this, "Campo de dueño debe ser numerico\n intentalo de nuevo");
			return;
		}
		 PersonaDTO dueno = new PersonaDTO();
		 MascotaDTO pet = new MascotaDTO();
		 dueno.setDocumento(docDueno);
		 pet.setDueno(dueno);
		 pet.setNombre(nombre);
		 pet.setRaza(raza);
		 pet.setSexo(sexo);
		 
		 String res = coordinador.guardarMascota(pet);
		 if (res.equals("ok")) {
			JOptionPane.showMessageDialog(this, "Registro de mascota exitoso!!!");
			limpiarDatos();
			
			String resumen = "Documento Dueño: "+docDueno+"\n"+
							"Nombre mascota: "+nombre+"\n"+
							"Sexo: "+sexo+"\n"+
							"Raza: "+raza+"\n";
			
			textArea.setText(resumen);
			System.out.println("Doc dueño: "+dueno.getDocumento());
			System.out.println("Sexo: "+pet.getSexo());
			System.out.println("Raza: "+pet.getRaza());
			System.out.println("Nombre: "+pet.getNombre());
		} else {
			textArea.setText("Recuerda que solo se registran mascotas con dueño activo");
		}
		 
	}

	private void consultarMascota() throws SQLException {
		String Docdueno = txtDueno.getText();
		String resumen;
		
		if (!coordinador.validarNumMascota(Docdueno)) {
			String validacion = "ingresa un documento a consultar";
			textArea.setText(validacion);
			return;
		}
		MascotaDTO pet = coordinador.buscarMascotaPorID(Docdueno);
		if (pet!=null) {
			resumen = "Documento dueño: "+pet.getDueno()+"\n"+
					  "Nombre mascota: "+pet.getNombre()+"\n"+
					  "Sexo mascota: "+pet.getSexo()+"\n"+
					  "Raza mascota: "+pet.getRaza()+"\n";
			textArea.setText(resumen);
			limpiarDatos();
		} else {
			resumen = "Mascota sin dueño registrado, intentelo de nuevo";
			textArea.setText(resumen);
			limpiarDatos();
		}
		
	}

	private void listaMascotas() throws SQLException {
		ArrayList<MascotaDTO> registrosMascotas = coordinador.listaMascotas();
		String resumen;
		if (registrosMascotas==null) {
			resumen = "no hay registros de mascotas";
			textArea.setText(resumen);
			return;
		}
		
		resumen = "Lista mascotas\n\n";
		for(MascotaDTO pet : registrosMascotas) {
			resumen+= "Documento dueño: "+pet.getDueno()
			+"\nNombre: "+pet.getNombre()
			+"\nRaza: "+pet.getRaza()
			+"\nSexo: "+pet.getSexo()
			+"\n------------------------------------\n";
			textArea.setText(resumen);
		}
		
		
	}

	private void actualizar() throws SQLException {
		String idDueno = txtDueno.getText();
		String nombre = txtNombreMascota.getText();
		String raza = txtRaza.getText();
		String sexo = txtSexo.getText();
		String resumen;
		
		if (!coordinador.validarNumMascota(idDueno)) {
			JOptionPane.showMessageDialog(this, "Ingresa un documento para actualizar");
			return;
		}
		
		MascotaDTO pet = new MascotaDTO();
		 PersonaDTO dueno = new PersonaDTO();
		 dueno.setDocumento(idDueno);
		 pet.setDueno(dueno);
		 pet.setNombre(nombre);
		 pet.setRaza(raza);
		 pet.setSexo(sexo);
		 
		 String confirm = coordinador.actualizarMascota(pet);
		 if (confirm.equals("ok")) {
			resumen = "Datos actualizados\n\n"+
					  "Documento Dueño: "+ dueno.getDocumento()+
					  "\nNombre: "+pet.getNombre()+
					  "\nRaza: "+pet.getRaza()+
					  "\nSexo: "+pet.getSexo();
			
			textArea.setText(resumen);
			limpiarDatos();
		}else if (confirm.equals("error")) {
			resumen = "No se puede actualizar documentos inexistentes";
			textArea.setText(resumen);
			limpiarDatos();
		} else {
			resumen = "error inesperado, intentalo nuevamente";
			textArea.setText(resumen);
			limpiarDatos();
		}
		
		
	}

	private void eliminar() throws SQLException{
		String idDueno = txtDueno.getText();
		String confirm;
		String resumen;
		
		if (!coordinador.validarNumMascota(idDueno)) {
			JOptionPane.showMessageDialog(this, "No se puede eliminar un registro inexistente");
			return;
		}
		MascotaDTO pet = new MascotaDTO();
		PersonaDTO dueno = new PersonaDTO();
		dueno.setDocumento(idDueno);
		pet.setDueno(dueno);
		confirm = coordinador.eliminarMascota(pet);
		if (confirm.equals("ok")) {
			resumen = "Mascota con documento de dueno "+dueno.getDocumento()+" ha sido eliminado correctamente";
			textArea.setText(resumen);
			limpiarDatos();
		} else if(confirm.equals("error")) {
			resumen = "No se puede eliminar una mascota no registrada";
			textArea.setText(resumen);
			limpiarDatos();
		} else {
			resumen = "error inesperado, intentalo nuevamente";
			textArea.setText(resumen);
		}
		
	}

}
