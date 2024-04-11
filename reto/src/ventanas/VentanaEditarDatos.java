package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class VentanaEditarDatos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final Action action = new SwingAction();


	public VentanaEditarDatos() {
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
		
		JButton btnSalir = new JButton("<---- Salir");
		btnSalir.setAction(action);
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
		
		textField = new JTextField();
		textField.setBounds(122, 213, 162, 45);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(170, 269, 162, 45);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(340, 325, 162, 45);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(340, 381, 162, 45);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(340, 437, 162, 45);
		contentPanel.add(textField_4);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblDNI.setBounds(50, 221, 110, 37);
		contentPanel.add(lblDNI);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNombre.setBounds(50, 269, 110, 37);
		contentPanel.add(lblNombre);
		
		JLabel lblDNI_1_1 = new JLabel("FECHA DE NACIMIENTO :");
		lblDNI_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblDNI_1_1.setBounds(50, 325, 280, 37);
		contentPanel.add(lblDNI_1_1);
		
		JLabel lblDNI_1_2 = new JLabel("NUEVA CONTRASEÑA:");
		lblDNI_1_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblDNI_1_2.setBounds(50, 381, 234, 37);
		contentPanel.add(lblDNI_1_2);
		
		JLabel lblDNI_1_3 = new JLabel("CONFIRMAR CONTRASEÑA:");
		lblDNI_1_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblDNI_1_3.setBounds(50, 437, 318, 37);
		contentPanel.add(lblDNI_1_3);
		
		
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
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
