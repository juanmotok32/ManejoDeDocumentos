package modelo;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UtilidadOpciones {

	public static void eliminarDirectorio() {
		String mensaje = "Como queres borrar el directorio?"
				+ "\n Opcion 1: Insertar ruta completa junto al nombre del directorio"
				+ "\n Opcion 2: Seleccionar un directorio ya existente";
		int opcion = JOptionPane.showOptionDialog(null, mensaje, "Opciones para eliminar Directorio", 1, 2, null,
				new Object[] { "Opcion 1", "Opcion 2" }, "Opcion 1");

		if (opcion == 0) {
			String ruta;
			String msj = "Introduci la ruta + el nombre del directorio"
					+ " Ejemplo: C:\\Users\\juan_\\Desktop\\java\\ProjectoArchivos";

			ruta = JOptionPane.showInputDialog(msj);
			if (ruta != null) {
				File directorio = new File(ruta);
				if (directorio.exists()) {
					if (directorio.isDirectory()) {
						int op = JOptionPane.showConfirmDialog(null, "Seguro que lo queres borrar?");
						if (op == 0) {
						
						if (directorio.delete()) {
							JOptionPane.showMessageDialog(null, "Se elimino el directorio");
						}
						}
					} else {
						JOptionPane.showMessageDialog(null, "No es un directorio");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "El directorio no existe");
			}
		}

		if (opcion == 1) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int opcionElegida = fileChooser.showOpenDialog(null);

			if (opcionElegida == JFileChooser.APPROVE_OPTION) {
				File directorioSelec = fileChooser.getSelectedFile();
				if (directorioSelec != null) {
					if (directorioSelec.isDirectory()) {
						if (directorioSelec.exists()) {
							int op = JOptionPane.showConfirmDialog(null, "Seguro que lo queres borrar?");
							if (op == 0) {
							if (directorioSelec.delete()) {
								JOptionPane.showMessageDialog(null, "Se elimino el directorio");
						}
						
						
						}else {
							JOptionPane.showMessageDialog(null, "No es un directorio");
					}
				} else {
					JOptionPane.showMessageDialog(null, "El directorio no existe");
				}
			}
		}
	}
		}
	}
	public static void crearDirectorio() {
		String mensaje = "Como queres crear el directorio?"
				+ "\n Opcion 1: Insertar ruta completa junto al nombre del directorio"
				+ "\n Opcion 2: Seleccionar un directorio ya existente y crear uno dentro de este";
		int opcion = JOptionPane.showOptionDialog(null, mensaje, "Opciones para crear Directorio", 1, 2, null,
				new Object[] { "Opcion 1", "Opcion 2" }, "Opcion 1");

		if (opcion == 0) {
			String ruta;
			String msj = "Introduci la ruta + el nombre del directorio"
					+ " Ejemplo: C:\\Users\\juan_\\Desktop\\java\\ProjectoArchivos";

			ruta = JOptionPane.showInputDialog(msj);
			if (ruta != null) {
				File directorio = new File(ruta);
				if (!directorio.exists()) {
					if (directorio.mkdirs()) {
						JOptionPane.showMessageDialog(null, "Directorio Creado Correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "Error al crear el directorio");
					}
				} else {
					JOptionPane.showMessageDialog(null, "El directorio ya existe");
				}
			}
		}

		if (opcion == 1) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int opcionElegida = fileChooser.showOpenDialog(null);

			if (opcionElegida == JFileChooser.APPROVE_OPTION) {
				File directorioSelec = fileChooser.getSelectedFile();
				if (directorioSelec != null) {
					String rutaDirectorio = directorioSelec.getAbsolutePath();
					String nombreDirectorio = JOptionPane.showInputDialog(null, "Introduci el nombre del directorio");
					if (nombreDirectorio != null) {
						String directorioNuevo = rutaDirectorio + "\\" + nombreDirectorio;
						File directorio = new File(directorioNuevo);
						if (!directorio.exists()) {
							if (directorio.mkdirs()) {
								JOptionPane.showMessageDialog(null, "El directorio se creo correctamente");
							} else {
								JOptionPane.showMessageDialog(null, "Error creando el directorio");
							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "El directorio ya existe");
				}
			}
		}

	}

	public static void crearArchivo() {
		String mensaje = "Como queres crear el archivo?"
				+ "\n Opcion 1: Insertar ruta completa junto al nombre del archivo"
				+ "\n Opcion 2: Seleccionar un archivo ya existente y crear uno dentro de este directorio";
		int opcion = JOptionPane.showOptionDialog(null, mensaje, "Opciones para crear Archivo", 1, 2, null,
				new Object[] { "Opcion 1", "Opcion 2" }, "Opcion 1");

		if (opcion == 0) {
			String ruta;
			String mensaje2 = "Introduci la ruta + el nombre del archivo y la extencion"
					+ " Ejemplo: C:\\Users\\juan_\\Desktop\\java\\ProjectoArchivos\\archivos.bin";

			String rutaNombreArchivo = JOptionPane.showInputDialog(mensaje2);
			if (rutaNombreArchivo != null) {
				File archivo = new File(rutaNombreArchivo);
				if (!archivo.exists()) {
					try {
						if (archivo.createNewFile()) {
							JOptionPane.showMessageDialog(null, "Archivo creado");
						} else {
							JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");

						}
					} catch (HeadlessException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "El archivo ya existe");
				}
			}

		}

		if (opcion == 1) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int opcionElegida = fileChooser.showOpenDialog(null);

			if (opcionElegida == JFileChooser.APPROVE_OPTION) {
				File directorioSeleccionado = fileChooser.getSelectedFile();
				if (directorioSeleccionado != null) {
					String rutaDirectorio = directorioSeleccionado.getAbsolutePath();
					String archivoNuevo = JOptionPane.showInputDialog(null,
							"Introduci el nombre del archivo y la extencion");
					if (archivoNuevo != null && rutaDirectorio != null) {
						String rutaArchivo = rutaDirectorio + "\\" + archivoNuevo;
						File archivo = new File(rutaArchivo);
						if (!archivo.exists()) {
							try {
								if (archivo.createNewFile()) {
									JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
								} else {
									JOptionPane.showMessageDialog(null, "Error creando el archivo");
								}
							} catch (HeadlessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "El archivo ya existe");
				}
			}
		}
	}

	public static void eliminarArchivo() {
		String mensaje = "Como queres borrar el archivo?"
				+ "\n Opcion 1: Insertar ruta completa junto al nombre del archivo"
				+ "\n Opcion 2: Seleccionar un archivo ya existente y crear uno dentro de este directorio";
		int opcion = JOptionPane.showOptionDialog(null, mensaje, "Opciones para eliminar el Archivo", 1, 2, null,
				new Object[] { "Opcion 1", "Opcion 2" }, "Opcion 1");

		if (opcion == 0) {

			String mensaje2 = "Introduci la ruta + el nombre del archivo y la extension";
			String rutaArchivo = JOptionPane.showInputDialog(mensaje2);

			if (rutaArchivo != null) {
				File archivo = new File(rutaArchivo);
				if (archivo.exists()) {
					if (archivo.isFile()) {
						int op = JOptionPane.showConfirmDialog(null, "Seguro que lo queres borrar?");
						if (op == 0) {
							if (archivo.delete()) {
								JOptionPane.showMessageDialog(null, "Se elimino el archivo");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "No es un archivo");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "El archivo no existe");
			}
		}
		if (opcion == 1) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			int opcionElegida = fileChooser.showOpenDialog(null);

			if (opcionElegida == JFileChooser.APPROVE_OPTION) {
				File archivo = fileChooser.getSelectedFile();
				if (archivo != null) {
					if (archivo.isFile()) {
						if (archivo.exists()) {
							int op = JOptionPane.showConfirmDialog(null, "Seguro que lo queres borrar?");
							if (op == 0) {

								if (archivo.delete()) {
									JOptionPane.showMessageDialog(null, "Se elimino el directorio");
								}
							} else {
								JOptionPane.showMessageDialog(null, "No se elimino");

							}
						} else {
							JOptionPane.showMessageDialog(null, "No es un directorio");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "El directorio no existe");
				}
			}
		}
	}

}