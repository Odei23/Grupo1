package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Importa las clases necesarias
import modelo.ImplementacionBaseDeDatos;
import modelo.Usuario;

public class VVisualizarUsuarios extends JFrame {

    private JPanel contentPanel;
    private JTable table;
    private JLabel fondo;

    /*
     * @Erik. Lo que se hace en esta ventana es plasmar todos los datos de los
     *  usuarios registrados en la base de datos mediante una tabla
     */
    
    public VVisualizarUsuarios(String dni) {
        setBounds(100, 100, 909, 607);
        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(255, 166, 128));
        
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        {
			JButton btnSalir = new JButton("Salir");
			btnSalir.setBounds(10, 11, 140, 48);
			contentPanel.add(btnSalir);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salir(dni);
				}
			});
		}
		{
			JButton btnCerrarSesion = new JButton("Cerrar Sesion");
			btnCerrarSesion.setBounds(738, 11, 140, 48);
			contentPanel.add(btnCerrarSesion);
			btnCerrarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrarSesion();
				}
			});

		}

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(62, 70, 769, 472);
        contentPanel.add(scrollPane);

        // Obtener la lista de usuarios desde la base de datos
        ArrayList<Usuario> usuarios = obtenerUsuariosDesdeBD();

        // Crear un modelo de tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DNI");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Fecha de Nacimiento");
        model.addColumn("Saldo");
        model.addColumn("Contraseña");
        model.addColumn("Es Admin");

        // Agregar filas a la tabla con los datos de los usuarios
        for (Usuario usuario : usuarios) {
            model.addRow(new Object[]{
                usuario.getDni(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getFechaNac(),
                usuario.getSaldo(),
                usuario.getContrasena(),
                usuario.isEsAdmin()
            });
        }
 
        table = new JTable(model);
        scrollPane.setViewportView(table);
        
        fondo = new JLabel("");
        
        fondo.setBounds(0, 0, 893, 568); // Establecer tamaño y ubicación adecuados para el JLabel
        ImageIcon poke1 = new ImageIcon(getClass().getResource("../imagenes/visualizar.jpg"));
        ImageIcon img1 = new ImageIcon(poke1.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(img1);
        contentPanel.add(fondo);
    }

    protected void cerrarSesion() {
		this.setVisible(false);
		VentanaPrincipal venPrin = new VentanaPrincipal();
		venPrin.setVisible(true);
	}

	protected void salir(String dni) {
		this.setVisible(false);
		VentanaMenuAdmin vAD = new VentanaMenuAdmin(dni);
		vAD.setVisible(true);
	}

	// Método para obtener los usuarios desde la base de datos
    private ArrayList<Usuario> obtenerUsuariosDesdeBD() {
        ImplementacionBaseDeDatos baseDeDatos = new ImplementacionBaseDeDatos();
        return (ArrayList<Usuario>) baseDeDatos.consultaUsuarios();
    }
    }

