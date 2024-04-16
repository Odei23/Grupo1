package ventanas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VCompraObjetos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCompraObjetos frame = new VCompraObjetos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VCompraObjetos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setBounds(24, 11, 140, 48);
		contentPane.add(btnNewButton);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(725, 11, 140, 48);
		contentPane.add(btnCerrarSesion);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(352, 11, 155, 134);
	        ImageIcon poke = new ImageIcon(getClass().getResource("LogoPokemon.png"));
	        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
	        lblLogo.setIcon (img2);
		contentPane.add(lblLogo);
		
		JButton btnCompraCura = new JButton("Comprar Cura");
		btnCompraCura.setBounds(273, 195, 328, 73);
		contentPane.add(btnCompraCura);
		
		JButton btnCompraPokeball = new JButton("Comprar Pokeballs");
		btnCompraPokeball.setBounds(273, 296, 328, 73);
		contentPane.add(btnCompraPokeball);
		
		JButton btnCompraComida = new JButton("Comprar Comida");
		btnCompraComida.setBounds(273, 396, 328, 73);
		contentPane.add(btnCompraComida);
	}
}
