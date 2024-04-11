package ventanas;

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

public class VentanaCrear extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblDNI;
	private JTextField textField_3;
	private JTextField textField_4;


	public VentanaCrear() {
		setBounds(100, 100, 909, 607);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 166, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
	
		JLabel logo = new JLabel("");
		logo.setBounds(368, 11, 155, 134);
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
		lblDNI.setBounds(218, 190, 114, 30);
		contentPanel.add(lblDNI);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		lblnombre.setBounds(218, 245, 114, 30);
		contentPanel.add(lblnombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		lblApellido.setBounds(218, 301, 114, 30);
		contentPanel.add(lblApellido);
		
		JLabel lblFechNac = new JLabel("Fecha de nacimiento");
		lblFechNac.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		lblFechNac.setBounds(218, 362, 219, 30);
		contentPanel.add(lblFechNac);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		lblSaldo.setBounds(218, 408, 114, 30);
		contentPanel.add(lblSaldo);
		
		textField = new JTextField();
		textField.setBounds(368, 188, 155, 32);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(368, 245, 155, 32);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(368, 309, 155, 32);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(417, 362, 155, 32);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(282, 406, 155, 32);
		contentPanel.add(textField_4);
		
		
	}


	protected void iniciar() {
		this.setVisible(false);
        VentanaPrincipal venPrin = new VentanaPrincipal();
        venPrin.setVisible(true);
		
	}
}
