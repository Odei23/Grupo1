package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import modelo.Usuarios;
import controlador.Controlador;

public class VentanaEditarDatos extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txta;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    public VentanaEditarDatos(String dni) {
        setBounds(100, 100, 909, 607);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 166, 128));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JLabel logo = new JLabel("");
        logo.setBounds(368, 11, 155, 134);
        ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.PNG"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
        logo.setIcon(img2);
        contentPanel.add(logo);
        
        JButton btnSalir = new JButton("<---- Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });
        btnSalir.setBounds(10, 11, 119, 45);
        contentPanel.add(btnSalir);
        
        JButton btnCerrar = new JButton("Cerrar Sesion");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
            }
        });
        btnCerrar.setBounds(764, 11, 119, 45);
        contentPanel.add(btnCerrar);
        
        txta = new JTextField();
        txta.setText("55555555A"); // Supongamos que este es el DNI del usuario actual
        txta.setBounds(340, 189, 162, 45);
        contentPanel.add(txta);
        txta.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(340, 245, 162, 45);
        contentPanel.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(340, 318, 162, 45);
        contentPanel.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(340, 374, 162, 45);
        contentPanel.add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(340, 430, 162, 45);
        contentPanel.add(textField_4);
        
        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        lblDNI.setBounds(50, 189, 110, 37);
        contentPanel.add(lblDNI);
        
        JLabel lblNombre = new JLabel("NOMBRE:");
        lblNombre.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        lblNombre.setBounds(50, 249, 110, 37);
        contentPanel.add(lblNombre);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        lblApellido.setBounds(50, 318, 110, 37);
        contentPanel.add(lblApellido);
        
        JLabel lblfech = new JLabel("FECHA DE NACIMIENTO:");
        lblfech.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        lblfech.setBounds(50, 374, 280, 37);
        contentPanel.add(lblfech);
        
        JLabel lblContra = new JLabel("NUEVA CONTRASEÑA:");
        lblContra.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        lblContra.setBounds(50, 430, 234, 37);
        contentPanel.add(lblContra);
        
        JButton btnGuardar = new JButton("Guardar Datos");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
        btnGuardar.setBounds(673, 427, 155, 23);
        contentPanel.add(btnGuardar);

        // Mostrar los datos del usuario actual
        mostrarDatosUsuario(txta.getText());
        mostrarDatosUsuario(dni);
    }

    protected void mostrarDatosUsuario(String dni) {
        Usuarios usuario = Controlador.obtenerUsuarioPorDNI(dni);
        if (usuario != null) {
            // Mostrar los datos del usuario en los JTextField correspondientes
            textField_1.setText(usuario.getNombre());
            textField_2.setText(usuario.getApellido());
            textField_3.setText(usuario.getFechaNac().toString()); // Suponiendo que la fecha se muestra como String
            // No se recomienda mostrar la contraseña actual en un campo de texto, es solo para fines demostrativos
            textField_4.setText(usuario.getContrasena());
        }
    }

    protected void salir() {
        this.setVisible(false);
        VentanaMenuUsuario venMU = new VentanaMenuUsuario();
        venMU.setVisible(true);
    }

    protected void cerrarSesion() {
        this.setVisible(false);
        VentanaPrincipal venPrin = new VentanaPrincipal();
        venPrin.setVisible(true);
    }

    protected void guardarDatos() {
        String dni = txta.getText();
        String nombre = textField_1.getText(); 
        String apellido = textField_2.getText();
        String fechaNac = textField_3.getText(); 
        LocalDate fechaNacimiento = null;
        try {
            // Intentar parsear la fecha
            fechaNacimiento = LocalDate.parse(fechaNac, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            // Manejar la excepción si la fecha no está en el formato correcto
            System.out.println("La fecha no está en el formato correcto: " + fechaNac);
            e.printStackTrace();
            return; // Salir del método si hay un error de formato de fecha
        }
        String contrasena = textField_4.getText(); 

        // Crear un objeto Usuarios con los datos modificados
        Usuarios usuarioModificado = new Usuarios();
        usuarioModificado.setDni(dni);
        usuarioModificado.setNombre(nombre);
        usuarioModificado.setApellido(apellido);
        usuarioModificado.setFechaNac(fechaNacimiento);
        usuarioModificado.setContrasena(contrasena);

        // Guardar los datos modificados del usuario en la base de datos a través del Controlador
        Controlador.actualizarUsuario(usuarioModificado);
        
        this.setVisible(false);
		VentanaMenuUsuario vUS = new VentanaMenuUsuario();
		vUS.setVisible(true);
        
    }


}