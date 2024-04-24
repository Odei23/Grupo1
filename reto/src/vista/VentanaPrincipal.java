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
import com.toedter.calendar.JDateChooser;

import controlador.Controlador;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JEditorPane;

public class VentanaPrincipal extends JFrame {

    private final JPanel contentPanel = new JPanel();
    private JLabel Pokemon;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnMostrarContraseña;
    private JLabel logo;
    private JLabel gif;

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

        JButton iniciar = new JButton("Cliente");
        iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarMenu();
            }
        });
        iniciar.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        iniciar.setBounds(409, 405, 183, 53);
        contentPanel.add(iniciar);

        textField = new JTextField();
        textField.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        textField.setBounds(415, 219, 343, 53);
        contentPanel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("INTRODUCE TU DNI");
        lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        lblNewLabel.setBounds(478, 182, 213, 26);
        contentPanel.add(lblNewLabel);

        JLabel lblIntroduceTuContrasea = new JLabel("INTRODUCE TU CONTRASEÑA");
        lblIntroduceTuContrasea.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        lblIntroduceTuContrasea.setBounds(438, 283, 320, 26);
        contentPanel.add(lblIntroduceTuContrasea);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        passwordField.setBounds(415, 320, 343, 53);
        contentPanel.add(passwordField);

        // Botón para mostrar/ocultar contraseña
        btnMostrarContraseña = new JButton("Mostrar");
        btnMostrarContraseña.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarOcultarContraseña();
            }
        });
        btnMostrarContraseña.setBounds(783, 322, 100, 53);
        contentPanel.add(btnMostrarContraseña);

        JButton olvidado = new JButton("¿Has olvidado la contraseña?");
        olvidado.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
        olvidado.setBounds(29, 351, 249, 53);
        olvidado.setBackground(new Color(255, 255, 255));
        olvidado.setOpaque(false);
        olvidado.setBorderPainted(false);
        olvidado.setFocusPainted(false);
        contentPanel.add(olvidado);

        logo = new JLabel("");
        logo.setBounds(29, 11, 244, 210);
        ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.PNG"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
        logo.setIcon(img2);
        contentPanel.add(logo);

        JButton crear = new JButton("Crear cuenta");
        crear.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
        crear.setBackground(new Color(255, 255, 255));
        crear.setOpaque(false);
        crear.setBorderPainted(false);
        crear.setFocusPainted(false);
        crear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crear();
            }
        });
        crear.setBounds(47, 305, 217, 56);
        contentPanel.add(crear);
        
        JButton Admin = new JButton("Administrador");
        Admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuAdmin();
            }
        });
        Admin.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        Admin.setBounds(602, 405, 183, 53);
        contentPanel.add(Admin);
        ImageIcon poke3 = new ImageIcon(getClass().getResource("../imagenes/logo.PNG"));
        ImageIcon img3 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
        logo.setIcon(img3);
        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);
        editorPane.setBackground(new Color(202, 146, 239));
        editorPane.setBounds(0, 0, 298, 568);
        contentPanel.add(editorPane);
        
        gif = new JLabel("");
        
        gif.setBounds(288, 0, 605, 568); // Establecer tamaño y ubicación adecuados para el JLabel
        ImageIcon poke1 = new ImageIcon(getClass().getResource("../imagenes/fondo.gif"));
        ImageIcon img1 = new ImageIcon(poke1.getImage().getScaledInstance(gif.getWidth(), gif.getHeight(), Image.SCALE_DEFAULT));
        gif.setIcon(img1);
        contentPanel.add(gif);

        // Cargar y mostrar el gif
        

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
            JOptionPane.showMessageDialog(null, "No tienes permiso para acceder al menú de administrador", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    protected void iniciarMenu() {
        String dni = textField.getText();
        String password = new String(passwordField.getPassword());

        boolean userExists = Controlador.usuarioExiste(dni, password);
        boolean userIsAdmin = Controlador.usuarioEsAdmin(dni, password);

        if (userExists && !userIsAdmin) {
            // El usuario existe y no es administrador, proceder al menú de usuario normal
            this.setVisible(false);
            // Pasar el DNI a la ventana de edición de datos
            VentanaEditarDatos ventanaEditarDatos = new VentanaEditarDatos(dni);
            ventanaEditarDatos.setVisible(true);
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
