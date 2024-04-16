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

import vista.VentanaInsertarPokemon;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMenuAdmin extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();


	public VentanaMenuAdmin() {
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
		ImageIcon poke = new ImageIcon(getClass().getResource("logo.PNG"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
        
        logo.setIcon (img2);
		contentPanel.add(logo);
		
		JButton btnInsertarObjeto = new JButton("INSERTAR OBJETO");
		btnInsertarObjeto.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnInsertarObjeto.setBounds(39, 205, 240, 115);
		contentPanel.add(btnInsertarObjeto);
		
		JButton btnComprarObjeto = new JButton("VISUALIZAR OBJETO");
		btnComprarObjeto.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnComprarObjeto.setBounds(322, 205, 240, 115);
		contentPanel.add(btnComprarObjeto);
		
		JButton btnVisualizarPokemon = new JButton("VISUALIZAR POKEMON");
		btnVisualizarPokemon.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnVisualizarPokemon.setBounds(39, 382, 240, 115);
		contentPanel.add(btnVisualizarPokemon);
		
		JButton btnEditarUsuario = new JButton("EDITAR USUARIO");
		btnEditarUsuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnEditarUsuario.setBounds(322, 382, 240, 115);
		contentPanel.add(btnEditarUsuario);
		
		JButton btnInsertarPokemon = new JButton("INSERTAR POKEMON");
		btnInsertarPokemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertarPokemon();
			}
		});
		btnInsertarPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnInsertarPokemon.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnInsertarPokemon.setBounds(601, 205, 240, 115);
		contentPanel.add(btnInsertarPokemon);
		
		JButton btnVisualizarUsuarios = new JButton("VISUALIZAR USUARIOS");
		btnVisualizarUsuarios.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnVisualizarUsuarios.setBounds(601, 382, 240, 115);
		contentPanel.add(btnVisualizarUsuarios);
	}


	protected void insertarPokemon() {
		this.setVisible(false);
        VentanaInsertarPokemon venIns = new VentanaInsertarPokemon();
        venIns.setVisible(true);		
	}


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
