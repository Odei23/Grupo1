package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controlador.Controlador;
import modelo.Pokemon;

public class VentanaMenuUsuario extends JDialog implements ActionListener {

    private final JPanel contentPanel = new JPanel();
    private JLabel lblSaldo;

    /*
	 * @Erik. Esta ventana sirve como conducto a otras ventanas, en las cuales 
	 * podremos comprar y editar objetos y pokemons.
	 */
    
    public VentanaMenuUsuario(String dni) {
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

        lblSaldo = new JLabel();
        lblSaldo.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        lblSaldo.setBounds(750, 80, 150, 30);
        contentPanel.add(lblSaldo);

        float saldo = Controlador.obtenerSaldoUsuario(dni);
        lblSaldo.setText("Saldo: " + saldo + "€");
        
        JLabel logo = new JLabel("");
		logo.setBounds(368, 11, 155, 134);
		ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.PNG"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
        
        logo.setIcon (img2);
		contentPanel.add(logo);

        JButton btnObtenerPokemon = new JButton("OBTENER POKEMON");
        btnObtenerPokemon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obtenerPokemon(dni);
            }
        });
        btnObtenerPokemon.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));

        btnObtenerPokemon.setBounds(205, 179, 440, 115);

        contentPanel.add(btnObtenerPokemon);

        JButton btnComprarObjeto = new JButton("COMPRAR OBJETO");
        btnComprarObjeto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarObjetos(dni);
            }
        });
        btnComprarObjeto.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        btnComprarObjeto.setBounds(205, 305, 440, 115);
        contentPanel.add(btnComprarObjeto);

        JButton btneditarDatos = new JButton("EDITAR DATOS");
        btneditarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarDatos(dni);
            }
        });
        btneditarDatos.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        btneditarDatos.setBounds(205, 431, 440, 115);
        contentPanel.add(btneditarDatos);
    }

    /*
     * @Erik. Este metodo se utiliza para llevarte a la venatana de editar datos.
     */

    protected void editarDatos(String dni) {
        this.setVisible(false);
        VentanaEditarDatos venEditar = new VentanaEditarDatos(dni);
        venEditar.setVisible(true);
    }

    /*
     * @Erik. Este metodo se utiliza para llevarte a la venatana principal.
     */
    protected void cerrarSesion() {
        this.setVisible(false);
        VentanaPrincipal venPrin = new VentanaPrincipal();
        venPrin.setVisible(true);
    }

    /*
     * @Erik. Este metodo se utiliza para llevarte a la venatana de obtener Pokemons.
     */
    
    protected void obtenerPokemon(String dni) {
        this.setVisible(false);
        ObtenerPokemon venOB = new ObtenerPokemon(dni);
        venOB.setVisible(true);
    }
    
    /*
     * @Erik. Este metodo se utiliza para llevarte a la venatana de compra objetos.
     */

    protected void comprarObjetos(String dni) {
        this.setVisible(false);
        VCompraObjetos vObjecto = new VCompraObjetos(dni);
        vObjecto.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        cerrarSesion();
    }
}
