package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import controlador.Controlador;
import modelo.Usuario;

public class VentanaPrincipal extends JFrame {

    private final JPanel contentPanel = new JPanel();
    private JLabel Pokemon;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnMostrarContraseña;

    public static void main(String[] args) {
        try {
            VentanaPrincipal dialog = new VentanaPrincipal();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public VentanaPrincipal() {
        setBounds(100, 100, 909, 607);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 166, 128));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JButton iniciar = new JButton("Iniciar sesión");
        iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarMenu();
            }
        });
        iniciar.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        iniciar.setBounds(201, 405, 183, 53);
        contentPanel.add(iniciar);

        textField = new JTextField();
        textField.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        textField.setBounds(263, 218, 343, 53);
        contentPanel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("INTRODUCE TU DNI");
        lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        lblNewLabel.setBounds(328, 181, 213, 26);
        contentPanel.add(lblNewLabel);

        JLabel lblIntroduceTuContrasea = new JLabel("INTRODUCE TU CONTRASEÑA");
        lblIntroduceTuContrasea.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        lblIntroduceTuContrasea.setBounds(286, 283, 320, 26);
        contentPanel.add(lblIntroduceTuContrasea);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        passwordField.setBounds(263, 320, 343, 53);
        contentPanel.add(passwordField);

        // Botón para mostrar/ocultar contraseña
        btnMostrarContraseña = new JButton("Mostrar");
        btnMostrarContraseña.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarOcultarContraseña();
            }
        });
        btnMostrarContraseña.setBounds(616, 320, 100, 53);
        contentPanel.add(btnMostrarContraseña);

        JButton olvidado = new JButton("¿Has olvidado la contraseña?");
        olvidado.setBounds(186, 485, 222, 23);
        contentPanel.add(olvidado);

        JLabel logo = new JLabel("");
        logo.setBounds(368, 11, 155, 134);
        ImageIcon poke = new ImageIcon(getClass().getResource("logo.PNG"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
        logo.setIcon(img2);
        contentPanel.add(logo);

        JButton crear = new JButton("Crear cuenta");
        crear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crear();
            }
        });
        crear.setBounds(467, 485, 171, 23);
        contentPanel.add(crear);
        
        JButton Admin = new JButton("Admin");
        Admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuAdmin();
            }
        });
        Admin.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        Admin.setBounds(455, 405, 183, 53);
        contentPanel.add(Admin);
    }

    protected void menuAdmin() {
        // Obtener el DNI y la contraseña ingresados
        String dni = textField.getText();
        String password = new String(passwordField.getPassword());

        // Verificar si el usuario es administrador
        boolean userIsAdmin = Controlador.usuarioEsAdmin(dni, password);

        if (userIsAdmin) {
            // El usuario es administrador, permitir acceso al menú de administrador
            this.setVisible(false);
            VentanaMenuAdmin venAD = new VentanaMenuAdmin();
            venAD.setVisible(true);
        } else {
            // El usuario no es administrador o no existe, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "No tienes permiso para acceder al menú de administrador", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    protected void iniciarMenu() {
        // Obtener el DNI y la contraseña ingresados
        String dni = textField.getText();
        String password = new String(passwordField.getPassword());
        Usuario per = new Usuario();
        per.setDni(dni);

        // Verificar si el usuario existe en la base de datos y si no es administrador
        boolean userExists = Controlador.usuarioExiste(dni, password);
        boolean userIsAdmin = Controlador.usuarioEsAdmin(dni, password);

        if (userExists && !userIsAdmin) {
            // El usuario existe y no es administrador, proceder al menú de usuario normal
            this.setVisible(false);
            VentanaMenuUsuario venMenuUsuario = new VentanaMenuUsuario(per);
            venMenuUsuario.setVisible(true);
        } else if (userExists && userIsAdmin) {
            // El usuario existe pero es administrador, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "No tienes permiso para acceder al menú de usuario", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // El usuario no existe, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "El usuario no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    




    protected void crear() {
        this.setVisible(false);
        VentanaCrear venCrear = new VentanaCrear();
        venCrear.setVisible(true);
    }

    // Método para mostrar u ocultar la contraseña
    protected void mostrarOcultarContraseña() {
        if (btnMostrarContraseña.getText().equals("Mostrar")) {
            passwordField.setEchoChar((char) 0); // Mostrar la contraseña
            btnMostrarContraseña.setText("Ocultar");
        } else {
            passwordField.setEchoChar('\u2022'); // Ocultar la contraseña
            btnMostrarContraseña.setText("Mostrar");
        }
    }
}
