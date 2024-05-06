package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VVObjetos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();

	public VVObjetos(String dni) {
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // O el valor que desees
		setBounds(100, 100, 905, 615);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(24, 11, 140, 48);
		contentPanel.add(btnSalir);
		contentPanel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir(dni);
			}
		});
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(725, 11, 140, 48);
		contentPanel.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarSesion();
			}
		});
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(352, 11, 155, 134);
	        ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
	        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
	        lblLogo.setIcon (img2);
	        contentPanel.add(lblLogo);
		
		JButton btnCompraCura = new JButton("Comprar Cura");
		btnCompraCura.setBounds(273, 195, 328, 73);
		contentPanel.add(btnCompraCura);
		btnCompraCura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCura(dni);
			}
		});
		JButton btnCompraPokeball = new JButton("Comprar Pokeballs");
		btnCompraPokeball.setBounds(273, 296, 328, 73);
		contentPanel.add(btnCompraPokeball);
		btnCompraPokeball.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonPokeball( dni);
			}
		});
		JButton btnCompraComida = new JButton("Comprar Comida");
		btnCompraComida.setBounds(273, 396, 328, 73);
		contentPanel.add(btnCompraComida);
		btnCompraComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonComida(dni);
			}
		});
	}


	protected void botonComida(String dni) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		VCompraComida venCompraComida = new VCompraComida(dni);
		venCompraComida.setVisible(true);
	}


	protected void botonPokeball(String dni) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		VCompraPokeball venCompraPokeball = new VCompraPokeball(dni);
		venCompraPokeball.setVisible(true);
	}


	protected void botonCura(String dni) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		VInsertarCura vvo = new VInsertarCura(dni);
		vvo.setVisible(true);
	}


	protected void cerrarSesion() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		VentanaPrincipal venPrin = new VentanaPrincipal();
		venPrin.setVisible(true);
	}
	


	protected void salir(String dni) {
		this.setVisible(false);
		VentanaMenuUsuario venCliente = new VentanaMenuUsuario(dni);
		venCliente.setVisible(true);
		
	}
}