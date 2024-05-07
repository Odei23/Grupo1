package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controlador.Controlador;
import modelo.ImplementacionBaseDeDatos;
import modelo.Pokemon;

public class VentanaMostrarImagen extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JLabel lblSaldo;

    public VentanaMostrarImagen(String dni) {
        setBounds(100, 100, 981, 775);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 166, 128));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(0, 5, 10, 10));

        // Mostrar saldo del usuario
        float saldo = Controlador.obtenerSaldoUsuario(dni);
        lblSaldo = new JLabel("Saldo: " + saldo + "€");
        lblSaldo.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        lblSaldo.setBounds(750, 80, 150, 30);
        contentPanel.add(lblSaldo);

        // Crear el botón "Salir"
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(10, 11, 140, 48);
        contentPanel.add(btnSalir);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salir(dni);
            }
        });

        // Obtener la lista de Pokémon de la base de datos
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        List<Pokemon> pokemonList = db.obtenerListaPokemon();
        // Iterar sobre la lista de Pokémon y agregar las imágenes al panel
        for (Pokemon pokemon : pokemonList) {
            // Crear un panel personalizado para cada Pokémon
            JPanel pokemonPanel = new JPanel(new BorderLayout());

            // Agregar la imagen del Pokémon al panel personalizado
            JLabel imageLabel = new JLabel();
            ImageIcon icon = new ImageIcon(pokemon.getImagen_pokemon());
            Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centra horizontalmente
            imageLabel.setVerticalAlignment(SwingConstants.CENTER); // Centra verticalmente
            pokemonPanel.add(imageLabel, BorderLayout.CENTER);

            // Agregar la cantidad y el precio del Pokémon al panel personalizado
            JLabel infoLabel = new JLabel("<html><center>Cantidad: " + pokemon.getStock_pokemon() + "<br>Precio: " + pokemon.getPrecioPokemon() + "€</center></html>");
            infoLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
            infoLabel.setHorizontalAlignment(JLabel.CENTER);
            pokemonPanel.add(infoLabel, BorderLayout.SOUTH);

            // Agregar JSpinner para seleccionar la cantidad deseada
            int stockPokemon = pokemon.getStock_pokemon();
            if (stockPokemon <= 0) {
                // Handle the case where stock is not valid, perhaps show an error message
                stockPokemon = 1; // Default to 1 if stock is not valid
            }
            SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, stockPokemon, 1);
            JSpinner spinner = new JSpinner(spinnerModel);
            pokemonPanel.add(spinner, BorderLayout.WEST);

            // Agregar botón de compra
            JButton buyButton = new JButton("Comprar");
            buyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Obtener la cantidad que el usuario quiere comprar
                    int cantidadDeseada = (int) spinner.getValue();

                    // Verificar si hay suficiente stock para la compra
                    if (cantidadDeseada > 0 && cantidadDeseada <= pokemon.getStock_pokemon()) {
                        // Realizar la compra y actualizar el stock en la base de datos
                        Controlador.realizarCompraPokemon(dni, pokemon.getCodigo_pokemon(), cantidadDeseada); // Implementa este método en tu Controlador

                        // Actualizar la etiqueta de saldo y la cantidad de stock mostrada
                        lblSaldo.setText("Saldo: " + Controlador.obtenerSaldoUsuario(dni) + "€");
                        infoLabel.setText("<html><center>Cantidad: " + (pokemon.getStock_pokemon() - cantidadDeseada) + "<br>Precio: " + pokemon.getPrecioPokemon() + "€</center></html>");
                    } else {
                        // Mostrar un mensaje de error si no hay suficiente stock
                        mostrarMensajeError("Cantidad no válida o stock insuficiente");
                    }
                }
            });
            pokemonPanel.add(buyButton, BorderLayout.NORTH);

            contentPanel.add(pokemonPanel);
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    protected void salir(String dni) {
        this.setVisible(false);
        VentanaMenuUsuario vAD = new VentanaMenuUsuario(dni);
        vAD.setVisible(true);
    }

    // Método para mostrar un mensaje de error al usuario
    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}