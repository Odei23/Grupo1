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

import modelo.Usuario;

import java.awt.Font;

public class VentanaMenuUsuario extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Usuario per;


	public VentanaMenuUsuario(Usuario per) {
		this.per = per;
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
		
		JButton btnObtenerPokemon = new JButton("OBTENER POKEMON");
		btnObtenerPokemon.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnObtenerPokemon.setBounds(170, 205, 240, 115);
		contentPanel.add(btnObtenerPokemon);
		
		JButton btnComprarObjeto = new JButton("COMPRAR OBJETO");
		btnComprarObjeto.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnComprarObjeto.setBounds(479, 205, 240, 115);
		contentPanel.add(btnComprarObjeto);
		btnComprarObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irVentanaCura();
			}
		});
		
		JButton btneditarDatos = new JButton("EDITAR DATOS");
		btneditarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarDatos();
			}
		});
		btneditarDatos.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btneditarDatos.setBounds(170, 382, 240, 115);
		contentPanel.add(btneditarDatos);
		
		JButton btnVisObjetos = new JButton("VISUALIZAR OBJETOS");
		btnVisObjetos.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnVisObjetos.setBounds(479, 382, 240, 115);
		contentPanel.add(btnVisObjetos);
	}

	protected void irVentanaCura() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		VCompraObjetos vObjecto = new VCompraObjetos(per);
		vObjecto.setVisible(true);
	}


	protected void editarDatos() {
		this.setVisible(false);
        VentanaEditarDatos venEditar = new VentanaEditarDatos(per);
        venEditar.setVisible(true);		
	}


	protected void cerrarSesion() {
		this.setVisible(false);
        VentanaPrincipal venPrin = new VentanaPrincipal();
        venPrin.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		cerrarSesion();
		editarDatos();
		
		
		
		
	}
}
