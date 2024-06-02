package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Producto;
import modelo.Utilidades;
import vista.VentanaPrograma;

public class ControladorPrograma implements ActionListener {
	
	private VentanaPrograma ventanaPrograma;
	private ArrayList<Producto> listaProducto, listaProductoArchivo;
	private Producto producto;
	public ControladorPrograma() {
		ventanaPrograma = new VentanaPrograma();
		ventanaPrograma.setLocationRelativeTo(ventanaPrograma);
		ventanaPrograma.setVisible(true);
		ventanaPrograma.setActionListener(this);
		
		listaProducto = new ArrayList<>();
		listaProductoArchivo = new ArrayList<>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch ( e.getActionCommand()  ) {
		case "Guardar": 
			producto = ventanaPrograma.obtenerProducto();
			listaProducto = Utilidades.guardar(listaProducto, producto);
			ventanaPrograma.limpiarCampos();
			ventanaPrograma.limpiarAreaText();
			ventanaPrograma.mostrarListaProductos(listaProducto);
			break;
		case "Limpiar": 
			ventanaPrograma.limpiarCampos();

			break;
		case "EscribitArchivo": 
			Utilidades.escribirEnArchivo(listaProducto);
			break;
		case "LimpiarLista": 
			ventanaPrograma.limpiarAreaText();
			Utilidades.limpiarLista(listaProducto);
			break;
		case "AbrirArchivo": 
			ventanaPrograma.limpiarAreaText();
			listaProducto =	Utilidades.leerArchivo();
			ventanaPrograma.mostrarListaProductosEnArchivo(listaProducto);
			break;
		case "borrarContenidoArchivo": 
			Utilidades.borrarContenidoArchivo();
			ventanaPrograma.limpiarAreaTextArchivo();
			break;
		case "Opciones": 
			new ControladorOpciones();
			
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: ");
		}
	}

}
