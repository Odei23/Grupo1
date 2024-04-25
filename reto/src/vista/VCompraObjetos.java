package vista;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VCompraObjetos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public VCompraObjetos(String dni) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(24, 11, 140, 48);
		contentPane.add(btnSalir);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir(dni);
			}
		});
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(725, 11, 140, 48);
		contentPane.add(btnCerrarSesion);
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
		contentPane.add(lblLogo);
		
		JButton btnCompraCura = new JButton("Comprar Cura");
		btnCompraCura.setBounds(273, 195, 328, 73);
		contentPane.add(btnCompraCura);
		btnCompraCura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCura(dni);
			}
		});
		JButton btnCompraPokeball = new JButton("Comprar Pokeballs");
		btnCompraPokeball.setBounds(273, 296, 328, 73);
		contentPane.add(btnCompraPokeball);
		btnCompraPokeball.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonPokeball( dni);
			}
		});
		JButton btnCompraComida = new JButton("Comprar Comida");
		btnCompraComida.setBounds(273, 396, 328, 73);
		contentPane.add(btnCompraComida);
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
		VCompraCura venCompraCura = new VCompraCura(dni);
		venCompraCura.setVisible(true);
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