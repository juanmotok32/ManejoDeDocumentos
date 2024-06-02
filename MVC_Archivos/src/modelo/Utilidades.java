package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Utilidades {

	public static ArrayList<Producto> guardar(ArrayList<Producto> l, Producto p) {
		if (p != null) {
			l.add(p);
		}
		return l;
	}

	public static void limpiarLista(ArrayList<Producto> l) {
		if (!l.isEmpty()) {
			l.clear();
		}
	}

	public static void escribirEnArchivo(ArrayList<Producto> l) {

		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStram = null;

		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int opcionElegida = fileChooser.showOpenDialog(null);

		if (opcionElegida == JFileChooser.APPROVE_OPTION) {
			File archivoSeleccionado = fileChooser.getSelectedFile();
			if (archivoSeleccionado != null) {
				try {
					fileOutputStream = new FileOutputStream(archivoSeleccionado);
					objectOutputStram = new ObjectOutputStream(fileOutputStream);
					for (Producto p : l) {
						objectOutputStram.writeObject(p);
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (objectOutputStram != null) {
						try {
							objectOutputStram.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (fileOutputStream != null) {
						try {
							fileOutputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}
		}
	}

	public static ArrayList<Producto> leerArchivo() {
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		ArrayList<Producto> productos = new ArrayList<>();

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int opcionElegida = fileChooser.showOpenDialog(null);
		if (opcionElegida == JFileChooser.APPROVE_OPTION) {
			File archivoSeleccionado = fileChooser.getSelectedFile();
			if (archivoSeleccionado != null) {
				try {
					fileInputStream = new FileInputStream(archivoSeleccionado);
					objectInputStream = new ObjectInputStream(fileInputStream);

					while (true) {
						try {
							Producto p = (Producto) objectInputStream.readObject();
							productos.add(p);
						} catch (Exception e) {
							break;
						}
					}
					return productos;

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Archivo vacio");
				}finally {
					
						if (objectInputStream != null) {
							try {
								objectInputStream.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if (fileInputStream != null) {
							try {
								fileInputStream.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				}
			}

		}
		}
		return null;
	}

	public static void borrarContenidoArchivo() {
		FileOutputStream fileOutputStream = null;
		

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int opcionElegida = fileChooser.showOpenDialog(null);
		if (opcionElegida == JFileChooser.APPROVE_OPTION) {
			File archivoSeleccionado = fileChooser.getSelectedFile();
			if (archivoSeleccionado != null) {
				try {
					fileOutputStream = new FileOutputStream(archivoSeleccionado);
					JOptionPane.showMessageDialog(null, "Contenido borrado :D");
					try {
						fileOutputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}finally{
					if(fileOutputStream != null) {
						try {
							fileOutputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}