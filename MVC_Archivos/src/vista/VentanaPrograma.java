package vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrograma;
import modelo.Producto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class VentanaPrograma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// TEXT FIELD
	private JTextField tfNombre;
	private JTextField tfPrecio;
	private JTextField taDescripcion;
	// BOTONES
	JButton btnGuardar = new JButton("Guardar");
	JButton btnLimpiar = new JButton("Limpiar");
	JButton btnEscribirArchivo = new JButton("Escribir En Archivo");
	JButton btnLimpiarLista = new JButton("Limpiar Lista");
	JButton btnAbrirArchivo = new JButton("Abrir Archivo");
	JButton btnBorrarContenidoArchivo = new JButton("Eliminar Conenido");
	JButton btnAbrirOpciones = new JButton("Opciones");
	// TEXT AREA
	JTextArea taLista = new JTextArea();
	JTextArea taContenidoArchivo = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrograma frame = new VentanaPrograma();
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
	public VentanaPrograma() {
		setTitle("MVC PRODUCTOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 448);
		contentPane = new JPanel();
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.PINK);
		panel.setBounds(0, 0, 808, 409);
		contentPane.add(panel);
		panel.setLayout(null);

		tfNombre = new JTextField();
		tfNombre.setBounds(10, 37, 188, 20);
		panel.add(tfNombre);
		tfNombre.setColumns(10);

		tfPrecio = new JTextField();
		tfPrecio.setBounds(10, 89, 188, 20);
		panel.add(tfPrecio);
		tfPrecio.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(10, 68, 46, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(10, 120, 77, 14);
		panel.add(lblNewLabel_2);

		taContenidoArchivo.setBounds(520, 35, 236, 308);
		panel.add(taContenidoArchivo);

		JLabel lblNewLabel_3 = new JLabel("Lista Productos");
		lblNewLabel_3.setBounds(232, 11, 128, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Contenido Archivo");
		lblNewLabel_3_1.setBounds(520, 11, 128, 14);
		panel.add(lblNewLabel_3_1);
		btnGuardar.setBackground(new Color(70, 130, 180));

		btnGuardar.setBounds(10, 250, 89, 23);
		panel.add(btnGuardar);
		btnGuardar.setActionCommand("Guardar");
		btnLimpiar.setBackground(new Color(70, 130, 180));

		btnLimpiar.setBounds(109, 250, 89, 23);
		panel.add(btnLimpiar);
		btnLimpiar.setActionCommand("Limpiar");

		btnEscribirArchivo.setBounds(232, 354, 128, 23);
		panel.add(btnEscribirArchivo);
		btnEscribirArchivo.setActionCommand("EscribitArchivo");

		btnLimpiarLista.setBounds(369, 354, 117, 23);
		panel.add(btnLimpiarLista);
		btnLimpiarLista.setActionCommand("LimpiarLista");

		btnAbrirArchivo.setBounds(520, 354, 117, 23);
		panel.add(btnAbrirArchivo);
		btnAbrirArchivo.setActionCommand("AbrirArchivo");

		btnBorrarContenidoArchivo.setBounds(647, 354, 151, 23);
		panel.add(btnBorrarContenidoArchivo);
		btnBorrarContenidoArchivo.setActionCommand("borrarContenidoArchivo");
		btnAbrirOpciones.setBackground(new Color(255, 250, 205));

		btnAbrirOpciones.setBounds(709, 7, 89, 23);
		panel.add(btnAbrirOpciones);
		btnAbrirOpciones.setActionCommand("Opciones");

		taDescripcion = new JTextField();
		taDescripcion.setColumns(10);
		taDescripcion.setBounds(10, 145, 188, 94);
		panel.add(taDescripcion);

		taLista.setBounds(229, 35, 209, 308);
		panel.add(taLista);

	}

	public void setActionListener(ControladorPrograma listener) {
		btnGuardar.addActionListener(listener);
		btnLimpiar.addActionListener(listener);
		btnEscribirArchivo.addActionListener(listener);
		btnLimpiarLista.addActionListener(listener);
		btnAbrirArchivo.addActionListener(listener);
		btnBorrarContenidoArchivo.addActionListener(listener);
		btnAbrirOpciones.addActionListener(listener);
	}

	public Producto obtenerProducto() {
		String nombre = tfNombre.getText();
		String precioTexto = tfPrecio.getText();
		String descripcion = taDescripcion.getText();

		int precio = 0;
		if (!precioTexto.isEmpty()) {
			precio = Integer.parseInt(precioTexto);
		}
		return new Producto(nombre, precio, descripcion);
	}

	public void limpiarCampos() {
		tfPrecio.setText("");
		tfNombre.setText("");
		taDescripcion.setText("");
	}

	public void mostrarListaProductos(ArrayList<Producto> lista) {
		if (lista != null && !lista.isEmpty()) {
			for (Producto producto : lista) {
				taLista.append(producto.toString()+ "\n");
			}
		}
	}
	
	public void limpiarAreaText() {
		taLista.setText("");
	}
	
	public void mostrarListaProductosEnArchivo(ArrayList<Producto> lista) {
		if (lista != null && !lista.isEmpty()) {
			for (Producto producto : lista) {
				taContenidoArchivo.append(producto.toString()+ "\n");
			}
		}
		
	}
	
	
	public void limpiarAreaTextArchivo() {
		taContenidoArchivo.setText("");
	}
	
}
