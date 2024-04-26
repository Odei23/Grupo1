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
import modelo.Usuario;

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

        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarMenu();
            }
        });
        btnIniciar.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        btnIniciar.setBounds(508, 405, 183, 53);
        contentPanel.add(btnIniciar);

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
        olvidado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                olvidado();
            }
        });
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

    protected void olvidado() {
    	this.setVisible(false);
        VCambioContrasena vOL = new VCambioContrasena();
        vOL.setVisible(true);		
	}


    protected void iniciarMenu() {
        String dni = textField.getText();
        String password = new String(passwordField.getPassword());

        Usuario user = Controlador.usuarioExiste(dni, password);

        if (user != null) {
            if (user.isEsAdmin()) {
            	this.setVisible(false);
                VentanaMenuAdmin vMA = new VentanaMenuAdmin(dni);
                vMA.setVisible(true);   
            } else {
            	 this.setVisible(false);
                 VentanaMenuUsuario vMU = new VentanaMenuUsuario(dni);
                 vMU.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
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
