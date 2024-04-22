package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.management.loading.PrivateClassLoader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Scrollbar;
import java.awt.TextField;


import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import controlador.Controlador;
import controlador.Dao;
import modelo.Usuario;
import utilidades.Utilidades;

public class VentanaCrear extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldDNI;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JLabel lblDNI;
    private JTextField textFieldFechNac;
    private JTextField textFieldSaldo;
    private JTextField textFieldContra;
    private JTextField Admin;


    public VentanaCrear() {
        setBounds(100, 100, 909, 607);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 166, 128));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
    
    
        JLabel logo = new JLabel("");
        logo.setBounds(395, 27, 100, 97);
        ImageIcon poke = new ImageIcon(getClass().getResource("logo.PNG"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
        
        logo.setIcon (img2);
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
        
        JLabel lblContrasena = new JLabel("Quieres ser admin?");
        lblContrasena.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblContrasena.setBounds(455, 285, 178, 30);
        contentPanel.add(lblContrasena);
        
        textFieldContra = new JTextField();
        textFieldContra.setColumns(10);
        textFieldContra.setBounds(579, 231, 155, 32);
        contentPanel.add(textFieldContra);
        
        JLabel lblContrasena_1 = new JLabel("Contraseña:");
        lblContrasena_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblContrasena_1.setBounds(455, 229, 114, 30);
        contentPanel.add(lblContrasena_1);
        
        Admin = new JTextField();
        Admin.setColumns(10);
        Admin.setBounds(643, 287, 155, 32);
        contentPanel.add(Admin);
            
    }

    
    private void altaUsuarios() {
        Usuario nuevo = new Usuario(); 
        nuevo.setDni(textFieldDNI.getText());
        nuevo.setNombre(textFieldNombre.getText());
        nuevo.setApellido(textFieldApellido.getText());
        nuevo.setFechaNac(LocalDate.parse(textFieldFechNac.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        nuevo.setSaldo(Float.parseFloat(textFieldSaldo.getText()));
        nuevo.setContrasena(textFieldContra.getText());
        
        // Establecer esAdmin dependiendo de si seleccionó "SI" o "NO"
        nuevo.setEsAdmin(Admin.getText().equalsIgnoreCase("SI"));

        Controlador.altaUsuario(nuevo);
    }

    private boolean parseBoolean(String value) {
        // Convierte el texto en minúsculas y elimina espacios en blanco alrededor
        String lowerCaseValue = value.trim().toLowerCase();
        // Verifica si el texto es "si" o "sí"
        if (lowerCaseValue.equals("si") || lowerCaseValue.equals("sí")) {
            return true;
        }
        // Verifica si el texto es "no"
        else if (lowerCaseValue.equals("no")) {
            return false;
        }
        // Si el texto no es "si", "sí" ni "no", muestra un mensaje de error y devuelve false por defecto
        else {
            System.out.println("El valor proporcionado para 'esAdmin' no es válido. Se utilizará 'false' por defecto.");
            return false;
        }
    }
}