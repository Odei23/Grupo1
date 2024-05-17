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

public class InsertarObjetos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
	
	/*
	 * @Erik. Lo que se hace en esta pagina es crear un menu que nos llevrá a las distintas ventanas para 
	 * insertar los diferentes tipos de objetos.
	 */
	public InsertarObjetos(String dni) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
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
		
		//Esto lo utilizamos para poner nuestro logo en la parte superior de la ventana
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(352, 11, 155, 134);
	        ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
	        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
	        lblLogo.setIcon (img2);
	        contentPanel.add(lblLogo);
		
		JButton btnCompraCura = new JButton("Insertar Cura");
		btnCompraCura.setBounds(273, 195, 328, 73);
		contentPanel.add(btnCompraCura);
		btnCompraCura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCura(dni);
			}
		});
		JButton btnCompraPokeball = new JButton("Insertar Pokeballs");
		btnCompraPokeball.setBounds(273, 296, 328, 73);
		contentPanel.add(btnCompraPokeball);
		btnCompraPokeball.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPokeball( dni);
			}
		});
		JButton btnCompraComida = new JButton("Insertar Comida");
		btnCompraComida.setBounds(273, 396, 328, 73);
		contentPanel.add(btnCompraComida);
		btnCompraComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarComida(dni);
			}
		});
	}

/*
 * @Erik este metodo hace ue cuando le demos al boton de insertar comida nos lleve a la ventana de insertar comida.
 */
	protected void insertarComida(String dni) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		VInsertarComida vic = new VInsertarComida(dni);
		vic.setVisible(true);
	}

	/*
	 * @Erik este metodo hace que cuando le demos al boton de insertar pokeball nos lleve a la ventana de insertar pokeball.
	 */
	protected void insertarPokeball(String dni) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		VInsertarPokeball vip = new VInsertarPokeball(dni);
		vip.setVisible(true);
	}
	/*
	 * @Erik este metodo hace ue cuando le demos al boton de insertar cura nos lleve a la ventana de insertar cura.
	 */

	protected void insertarCura(String dni) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		VInsertarCura vic = new VInsertarCura(dni);
		vic.setVisible(true);
	}

	/*
	 * @Erik estos metodos hacen ue cuando le demos al boton de insertar cerrar sesion nos devuelva a la pagina principal,
	 * mientras ue si le damos al boton de salir nos llevará al menu del usuario
	 */


	protected void cerrarSesion() {
		this.setVisible(false);
		VentanaPrincipal venPrin = new VentanaPrincipal();
		venPrin.setVisible(true);
	}
	


	protected void salir(String dni) {
		this.setVisible(false);
		VentanaMenuAdmin venCliente = new VentanaMenuAdmin(dni);
		venCliente.setVisible(true);
		
	}

}
