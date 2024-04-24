package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// Importa las clases necesarias
import modelo.ImplementacionBaseDeDatos;
import modelo.Usuarios;

public class VVisualizarUsuarios extends JFrame {

    private JPanel contentPanel;
    private JTable table;
    private JLabel gif;

    public VVisualizarUsuarios() {
        setBounds(100, 100, 909, 607);
        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(255, 166, 128));
        
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(89, 52, 720, 440);
        contentPanel.add(scrollPane);

        // Obtener la lista de usuarios desde la base de datos
        ArrayList<Usuarios> usuarios = obtenerUsuariosDesdeBD();

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
        for (Usuarios usuario : usuarios) {
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
        
        gif = new JLabel("");
        
        gif.setBounds(0, 0, 893, 568); // Establecer tamaño y ubicación adecuados para el JLabel
        ImageIcon poke1 = new ImageIcon(getClass().getResource("../imagenes/fondo.gif"));
        ImageIcon img1 = new ImageIcon(poke1.getImage().getScaledInstance(gif.getWidth(), gif.getHeight(), Image.SCALE_DEFAULT));
        gif.setIcon(img1);
        contentPanel.add(gif);
    }

    // Método para obtener los usuarios desde la base de datos
    private ArrayList<Usuarios> obtenerUsuariosDesdeBD() {
        ImplementacionBaseDeDatos baseDeDatos = new ImplementacionBaseDeDatos();
        return (ArrayList<Usuarios>) baseDeDatos.consultaUsuarios();
    }
    }
