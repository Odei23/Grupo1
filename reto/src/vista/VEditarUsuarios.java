package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Usuario;

public class VEditarUsuarios extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JComboBox<String> comboBoxDNIs;
    private JCheckBox checkBoxMostrarNoAdmin;

    public VEditarUsuarios(String dni) {
        setBounds(100, 100, 909, 607);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 166, 128));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel logo = new JLabel("");
        logo.setBounds(368, 11, 155, 134);
        ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.PNG"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(),
                Image.SCALE_SMOOTH));
        logo.setIcon(img2);
        contentPanel.add(logo);

        JButton btnSalir = new JButton("<---- Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salir(dni);
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

        comboBoxDNIs = new JComboBox<>();
        comboBoxDNIs.setBounds(340, 194, 162, 34);
        contentPanel.add(comboBoxDNIs);

        comboBoxDNIs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedDNI = (String) comboBoxDNIs.getSelectedItem();
                mostrarDatosUsuario(selectedDNI);
            }
        });

        checkBoxMostrarNoAdmin = new JCheckBox("Mostrar solo no administradores");
        checkBoxMostrarNoAdmin.setBounds(520, 194, 200, 34);
        checkBoxMostrarNoAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDNIs();
            }
        });
        contentPanel.add(checkBoxMostrarNoAdmin);

        mostrarDNIs();
    }

    protected void mostrarDNIs() {
        comboBoxDNIs.removeAllItems();
        if (checkBoxMostrarNoAdmin.isSelected()) {
            List<String> dnisNoAdmin = Controlador.obtenerDNIsNoAdministradores();
            for (String dni : dnisNoAdmin) {
                comboBoxDNIs.addItem(dni);
            }
        } else {
            List<String> todosDNIs = Controlador.obtenerTodosDNIs();
            for (String dni : todosDNIs) {
                comboBoxDNIs.addItem(dni);
            }
        }
    }

    protected void mostrarDatosUsuario(String dni) {
        Usuario usuario = Controlador.obtenerUsuarioPorDNI(dni);
        if (usuario != null) {
            textField_1.setText(usuario.getNombre());
            textField_2.setText(usuario.getApellido());
            textField_3.setText(usuario.getFechaNac().toString());
            textField_4.setText(usuario.getContrasena());
        }
    }

    protected void salir(String dni) {
        this.setVisible(false);
        VentanaMenuAdmin vAD = new VentanaMenuAdmin(dni);
        vAD.setVisible(true);
    }

    protected void cerrarSesion() {
        this.setVisible(false);
        VentanaPrincipal venPrin = new VentanaPrincipal();
        venPrin.setVisible(true);
    }

    protected void guardarDatos() {
        String dni = (String) comboBoxDNIs.getSelectedItem();
        String nombre = textField_1.getText();
        String apellido = textField_2.getText();
        String fechaNac = textField_3.getText();
        LocalDate fechaNacimiento = null;
        try {
            fechaNacimiento = LocalDate.parse(fechaNac, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            System.out.println("La fecha no está en el formato correcto: " + fechaNac);
            e.printStackTrace();
            return;
        }
        String contrasena = textField_4.getText();

        Usuario usuarioModificado = new Usuario();
        usuarioModificado.setDni(dni);
        usuarioModificado.setNombre(nombre);
        usuarioModificado.setApellido(apellido);
        usuarioModificado.setFechaNac(fechaNacimiento);
        usuarioModificado.setContrasena(contrasena);

        Controlador.actualizarUsuario(usuarioModificado);

        this.dispose();
        VentanaMenuUsuario vUS = new VentanaMenuUsuario(dni);
        vUS.setVisible(true);
    }
}
