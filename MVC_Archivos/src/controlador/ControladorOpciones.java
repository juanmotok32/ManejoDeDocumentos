package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.UtilidadOpciones;
import vista.VentanaOpciones;

public class ControladorOpciones implements ActionListener {
	
	private VentanaOpciones ventanaOpciones ;
	
	
	
	public ControladorOpciones() {
		ventanaOpciones = new VentanaOpciones();;
		ventanaOpciones.setLocationRelativeTo(ventanaOpciones);
		ventanaOpciones.setVisible(true);
		ventanaOpciones.setActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		switch ( e.getActionCommand()) {
		case "CrearDirec": 
			UtilidadOpciones.crearDirectorio();
		break;
		case "BorrarDirec":
			UtilidadOpciones.eliminarDirectorio();
			break;
		case "CrearArchivo":
			UtilidadOpciones.crearArchivo();
			break;
		case "BorrarArchivo":
			UtilidadOpciones.eliminarArchivo();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " +  e.getActionCommand());
		}
		
	}

}
