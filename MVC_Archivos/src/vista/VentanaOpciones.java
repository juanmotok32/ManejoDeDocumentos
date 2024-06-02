package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorOpciones;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaOpciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnCrearDirectorio = new JButton("Crear Directorio");
	JButton btnBorrarDirectorio = new JButton("Borrar Directorio");
	JButton btnCrearArchivo = new JButton("Crear Archivo");
	JButton btnBorrarArchivo = new JButton("Borrar Archivo");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpciones frame = new VentanaOpciones();
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
	public VentanaOpciones() {
		setTitle("OPCIONES");
		setBounds(100, 100, 552, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 536, 323);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Opciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(26, 11, 92, 43);
		panel.add(lblNewLabel);
		btnCrearDirectorio.setBackground(new Color(147, 112, 219));
		
		btnCrearDirectorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearDirectorio.setBounds(10, 65, 125, 23);
		panel.add(btnCrearDirectorio);
		btnBorrarDirectorio.setBackground(new Color(219, 112, 147));
		
		btnBorrarDirectorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrarDirectorio.setBounds(10, 99, 125, 23);
		panel.add(btnBorrarDirectorio);
		btnCrearArchivo.setBackground(new Color(147, 112, 219));
		
		btnCrearArchivo.setBounds(10, 166, 125, 23);
		panel.add(btnCrearArchivo);
		btnBorrarArchivo.setBackground(new Color(219, 112, 147));
		
		btnBorrarArchivo.setBounds(10, 200, 125, 23);
		panel.add(btnBorrarArchivo);
		
		
		btnCrearDirectorio.setActionCommand("CrearDirec");
		btnBorrarDirectorio.setActionCommand("BorrarDirec");
		btnCrearArchivo.setActionCommand("CrearArchivo");
		btnBorrarArchivo.setActionCommand("BorrarArchivo");

	}

	public void setActionListener(ControladorOpciones listener) {
		btnCrearDirectorio.addActionListener(listener);
		btnBorrarDirectorio.addActionListener(listener);
		btnCrearArchivo.addActionListener(listener);
		btnBorrarArchivo.addActionListener(listener);
	}

}
