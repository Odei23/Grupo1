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
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controlador.Controlador;
import controlador.Dao;
import modelo.Usuarios;
import utilidades.Utilidades;

public class VentanaCrear extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblDNI;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


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
				iniciar();
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
		
		textField = new JTextField();
		textField.setBounds(398, 133, 155, 32);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(398, 190, 155, 32);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(398, 248, 155, 32);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(447, 307, 155, 32);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(312, 351, 155, 32);
		contentPanel.add(textField_4);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		lblContrasena.setBounds(248, 394, 114, 30);
		contentPanel.add(lblContrasena);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(368, 394, 155, 32);
		contentPanel.add(textField_5);
			
		
		
	}

	
	private static void altaUsuarios() {
		Usuarios nuevo;
		
		nuevo = new Usuarios(); 
		System.out.println("Introduce los datos del usuario");
		nuevo.setDni(Utilidades.introducirCadena("Introduce tu dni"));
		nuevo.setNombre(Utilidades.introducirCadena("Introduce tu nombre"));
		nuevo.setApellido(Utilidades.introducirCadena("Introduce tu apellido"));
		nuevo.setFechaNac(Utilidades.pidoFechaDMA("Introduce tu fecha de nacimiento"));
		nuevo.setSaldo(Utilidades.leerFloat("Introduce tu saldo"));
		nuevo.setContrasena(Utilidades.introducirCadena("Introduce tu contraseña"));

		Controlador.altaUsuario(nuevo);
		
	}
	protected void iniciar() {
		this.setVisible(false);
        VentanaPrincipal venPrin = new VentanaPrincipal();
        venPrin.setVisible(true);
		
	}
}
