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

import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import controlador.Controlador;
import controlador.Dao;
import modelo.Usuarios;
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


    public VentanaCrear() {
        setBounds(100, 100, 909, 607);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 166, 128));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
    
    
        JLabel logo = new JLabel("");
        logo.setBounds(395, 11, 100, 97);
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
        btnCrearCuenta.setBounds(368, 473, 178, 30);
        contentPanel.add(btnCrearCuenta);
        
        lblDNI = new JLabel("DNI:");
        lblDNI.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblDNI.setBounds(248, 135, 114, 30);
        contentPanel.add(lblDNI);
        
        JLabel lblnombre = new JLabel("Nombre:");
        lblnombre.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblnombre.setBounds(248, 190, 114, 30);
        contentPanel.add(lblnombre);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblApellido.setBounds(248, 246, 114, 30);
        contentPanel.add(lblApellido);
        
        JLabel lblFechNac = new JLabel("Fecha de nacimiento");
        lblFechNac.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblFechNac.setBounds(248, 307, 219, 30);
        contentPanel.add(lblFechNac);
        
        JLabel lblSaldo = new JLabel("Saldo:");
        lblSaldo.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblSaldo.setBounds(248, 353, 114, 30);
        contentPanel.add(lblSaldo);
        
        textFieldDNI = new JTextField();
        textFieldDNI.setBounds(398, 133, 155, 32);
        contentPanel.add(textFieldDNI);
        textFieldDNI.setColumns(10);
        
        textFieldNombre = new JTextField();
        textFieldNombre.setColumns(10);
        textFieldNombre.setBounds(398, 190, 155, 32);
        contentPanel.add(textFieldNombre);
        
        textFieldApellido = new JTextField();
        textFieldApellido.setColumns(10);
        textFieldApellido.setBounds(398, 248, 155, 32);
        contentPanel.add(textFieldApellido);
        
        textFieldFechNac = new JTextField();
        textFieldFechNac.setColumns(10);
        textFieldFechNac.setBounds(447, 307, 155, 32);
        contentPanel.add(textFieldFechNac);
        
        textFieldSaldo = new JTextField();
        textFieldSaldo.setColumns(10);
        textFieldSaldo.setBounds(312, 351, 155, 32);
        contentPanel.add(textFieldSaldo);
        
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        lblContrasena.setBounds(248, 394, 114, 30);
        contentPanel.add(lblContrasena);
        
        textFieldContra = new JTextField();
        textFieldContra.setColumns(10);
        textFieldContra.setBounds(368, 394, 155, 32);
        contentPanel.add(textFieldContra);
            
    }

    
    private void altaUsuarios() {
        Usuarios nuevo = new Usuarios(); 
        nuevo.setDni(textFieldDNI.getText());
        nuevo.setNombre(textFieldNombre.getText());
        nuevo.setApellido(textFieldApellido.getText());
        nuevo.setFechaNac(LocalDate.parse(textFieldFechNac.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        nuevo.setSaldo(Float.parseFloat(textFieldSaldo.getText()));
        nuevo.setContrasena(textFieldContra.getText());

        Controlador.altaUsuario(nuevo);
        
    }

}
