package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Usuario;

public class VentanaCrear extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldDNI;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JLabel lblDNI;
    private JTextField textFieldFechNac;
    private JTextField textFieldSaldo;
    private JTextField textFieldContra;
    private ButtonGroup group;

    public VentanaCrear() {
        setBounds(100, 100, 909, 607);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 166, 128));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel logo = new JLabel("");
        logo.setBounds(395, 27, 100, 97);
        ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.PNG"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));

        logo.setIcon(img2);
        contentPanel.add(logo);

        JButton btnCrearCuenta = new JButton("Crear Cuenta");
        btnCrearCuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                altaUsuarios();
                setVisible(false);
                VentanaPrincipal venPrin = new VentanaPrincipal();
                venPrin.setVisible(true);
            }
        });
        btnCrearCuenta.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        btnCrearCuenta.setBounds(370, 440, 178, 30);
        contentPanel.add(btnCrearCuenta);

        lblDNI = new JLabel("DNI:");
        lblDNI.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblDNI.setBounds(82, 174, 114, 30);
        contentPanel.add(lblDNI);

        JLabel lblnombre = new JLabel("Nombre:");
        lblnombre.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblnombre.setBounds(44, 229, 114, 30);
        contentPanel.add(lblnombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblApellido.setBounds(44, 285, 80, 30);
        contentPanel.add(lblApellido);

        JLabel lblFechNac = new JLabel("Fecha de nacimiento:");
        lblFechNac.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblFechNac.setBounds(455, 174, 188, 30);
        contentPanel.add(lblFechNac);

        JLabel lblSaldo = new JLabel("Saldo:");
        lblSaldo.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblSaldo.setBounds(44, 342, 158, 32);
        contentPanel.add(lblSaldo);

        textFieldDNI = new JTextField();
        textFieldDNI.setBounds(150, 176, 155, 32);
        contentPanel.add(textFieldDNI);
        textFieldDNI.setColumns(10);

        textFieldNombre = new JTextField();
        textFieldNombre.setColumns(10);
        textFieldNombre.setBounds(150, 231, 155, 32);
        contentPanel.add(textFieldNombre);

        textFieldApellido = new JTextField();
        textFieldApellido.setColumns(10);
        textFieldApellido.setBounds(150, 287, 155, 32);
        contentPanel.add(textFieldApellido);

        textFieldFechNac = new JTextField();
        textFieldFechNac.setColumns(10);
        textFieldFechNac.setBounds(653, 176, 155, 32);
        contentPanel.add(textFieldFechNac);

        textFieldSaldo = new JTextField();
        textFieldSaldo.setColumns(10);
        textFieldSaldo.setBounds(150, 345, 155, 32);
        contentPanel.add(textFieldSaldo);

        textFieldContra = new JTextField();
        textFieldContra.setColumns(10);
        textFieldContra.setBounds(579, 231, 155, 32);
        contentPanel.add(textFieldContra);

        JLabel lblContrasena_1 = new JLabel("Contraseña:");
        lblContrasena_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblContrasena_1.setBounds(455, 229, 114, 30);
        contentPanel.add(lblContrasena_1);

        // Agrupar los botones de radio para que solo uno pueda ser seleccionado a la vez
        group = new ButtonGroup();

    }

    private void altaUsuarios() {
        Usuario nuevo = new Usuario();
        nuevo.setDni(textFieldDNI.getText());
        nuevo.setNombre(textFieldNombre.getText());
        nuevo.setApellido(textFieldApellido.getText());
        nuevo.setFechaNac(LocalDate.parse(textFieldFechNac.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        nuevo.setContrasena(textFieldContra.getText());
        nuevo.setSaldo(Float.parseFloat(textFieldSaldo.getText()));

        Controlador.altaUsuario(nuevo);
    }


    private String getSelectedButtonText() {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}
