package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMenuAdmin extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();

	/*
	 * @Erik. Esta ventana sirve como conducto a otras ventanas, en las cuales 
	 * podremos insertar, modificar, editar y visualizar objetos y pokemons.
	 */

	public VentanaMenuAdmin(String dni) {
		setBounds(100, 100, 909, 607);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 166, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarSesion();
			}
		});
		cerrarSesion.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		cerrarSesion.setBounds(735, 11, 123, 54);
		contentPanel.add(cerrarSesion);
		
		JLabel logo = new JLabel("");
		logo.setBounds(368, 11, 155, 134);
		ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.PNG"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
        
        logo.setIcon (img2);
		contentPanel.add(logo);
		
		JButton btnInsertarObjeto = new JButton("MODIFICAR OBJETO");
		btnInsertarObjeto.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnInsertarObjeto.setBounds(39, 382, 240, 115);
		btnInsertarObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VModificarObjetos(dni);
			}
		});
		contentPanel.add(btnInsertarObjeto);
		
		JButton btnComprarObjeto = new JButton("INSERTAR OBJETO");
		btnComprarObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarObjetos(dni);
			}
		});
		btnComprarObjeto.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnComprarObjeto.setBounds(39, 205, 240, 115);
		contentPanel.add(btnComprarObjeto);
		
		JButton btnVisualizarPokemon = new JButton("INSERTAR POKEMON");
		btnVisualizarPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPokemon(dni);
			}
		});
		btnVisualizarPokemon.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnVisualizarPokemon.setBounds(322, 205, 240, 115);
		contentPanel.add(btnVisualizarPokemon);
		
		JButton btnEditarUsuario = new JButton("EDITAR USUARIO");
		btnEditarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VEditarUsuarios(dni);
			}
		});
		btnEditarUsuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnEditarUsuario.setBounds(601, 205, 240, 115);
		contentPanel.add(btnEditarUsuario);
		
		JButton btnIModificarPokemon = new JButton("MODIFICAR POKEMON");
		btnIModificarPokemon.addMouseListener(new MouseAdapter() {
		
		});
		btnIModificarPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPokemon(dni);
			}
		});
		btnIModificarPokemon.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnIModificarPokemon.setBounds(322, 382, 240, 115);
		contentPanel.add(btnIModificarPokemon);
		
		JButton btnVisualizarUsuarios = new JButton("VISUALIZAR USUARIOS");
		btnVisualizarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizarUsuarios(dni);
			}
		});
		btnVisualizarUsuarios.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnVisualizarUsuarios.setBounds(601, 382, 240, 115);
		contentPanel.add(btnVisualizarUsuarios);
	}

		
	/*
	 * @Erik. Este metodo sirve para llevarte a la ventana insertarObjetos
	 */
	protected void insertarObjetos(String dni) {
		this.setVisible(false);
		InsertarObjetos vio = new InsertarObjetos(dni);
		vio.setVisible(true);		
	}


	/*
	 * @Erik. Este metodo sirve para llevarte a la ventana insertarPokemon
	 */
	
	protected void insertarPokemon(String dni) {

		this.setVisible(false);
		VInsertarPokemon vip = new VInsertarPokemon(dni);
		vip.setVisible(true);
	}

	/*
	 * @Erik. Este metodo sirve para llevarte a la ventana de modificar objetos
	 */

	protected void VModificarObjetos(String dni) {

		this.setVisible(false);
		VModificarObjetos vvo = new VModificarObjetos(dni);
		vvo.setVisible(true);			
	}

	/*
	 * @Erik. Este metodo sirve para llevarte a la ventana de modificar pokemon
	 */

	protected void modificarPokemon(String dni) {
		this.setVisible(false);
        VModificarPokemon vIP = new VModificarPokemon(dni);
        vIP.setVisible(true);				
	}

	/*
	 * @Erik. Este metodo sirve para llevarte a la ventana de editar usuarios.
	 */
	
	protected void VEditarUsuarios(String dni) {
		
		this.setVisible(false);
        VEditarUsuarios vED = new VEditarUsuarios(dni);
        vED.setVisible(true);		
		
	}
	
	/*
	 * @Erik. Este metodo sirve para llevarte a la ventana de visualizar los usuarios de la base de datos
	 */

	protected void visualizarUsuarios(String dni) {
		this.setVisible(false);
        VVisualizarUsuarios venVU = new VVisualizarUsuarios(dni);
        venVU.setVisible(true);		
	}
	
	/*
	 * @Erik. Este metodo sirve para volver al menu principal
	 */

	protected void cerrarSesion() {
		this.setVisible(false);
        VentanaPrincipal venPrin = new VentanaPrincipal();
        venPrin.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		cerrarSesion();

	}
}
