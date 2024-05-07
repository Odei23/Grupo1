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

        // Dentro del constructor de la clase VentanaMenuUsuario
        lblSaldo = new JLabel();
        lblSaldo.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        lblSaldo.setBounds(750, 80, 150, 30);
        contentPanel.add(lblSaldo);

        float saldo = Controlador.obtenerSaldoUsuario(dni); // Suponiendo que haya un método en Controlador para obtener el saldo del usuario
        lblSaldo.setText("Saldo: " + saldo + "€");

        JButton btnObtenerPokemon = new JButton("OBTENER POKEMON");
        btnObtenerPokemon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obtenerPokemon(dni);
            }
        });
        btnObtenerPokemon.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));

        btnObtenerPokemon.setBounds(170, 205, 240, 115);

        contentPanel.add(btnObtenerPokemon);

        JButton btnComprarObjeto = new JButton("COMPRAR OBJETO");
        btnComprarObjeto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarObjetos(dni);
            }
        });
        btnComprarObjeto.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        btnComprarObjeto.setBounds(479, 205, 240, 115);
        contentPanel.add(btnComprarObjeto);

        JButton btneditarDatos = new JButton("EDITAR DATOS");
        btneditarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarDatos(dni);
            }
        });
        btneditarDatos.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        btneditarDatos.setBounds(170, 382, 240, 115);
        contentPanel.add(btneditarDatos);

        JButton btnVisObjetos = new JButton("VISUALIZAR OBJETOS");
        btnVisObjetos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visualizarDatos(dni);
            }
        });
        btnVisObjetos.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        btnVisObjetos.setBounds(479, 382, 240, 115);
        contentPanel.add(btnVisObjetos);
    }


    protected void visualizarDatos(String dni) {
        this.setVisible(false);
        List<Pokemon> pokemonComprados = Controlador.getPokemonComprados(); // Obtiene la lista de Pokémon comprados
        VVisualizarObjetos venPrin = new VVisualizarObjetos(pokemonComprados);
        venPrin.setVisible(true);
    }

    protected void editarDatos(String dni) {
        this.setVisible(false);
        VentanaEditarDatos venEditar = new VentanaEditarDatos(dni);
        venEditar.setVisible(true);
    }

    protected void cerrarSesion() {
        this.setVisible(false);
        VentanaPrincipal venPrin = new VentanaPrincipal();
        venPrin.setVisible(true);
    }

    protected void obtenerPokemon(String dni) {
        this.setVisible(false);
        VentanaMostrarImagen venOB = new VentanaMostrarImagen(dni);
        venOB.setVisible(true);
    }

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
