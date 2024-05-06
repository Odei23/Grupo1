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

 // Dentro del constructor de la clase VentanaMostrarImagen
    public VentanaMostrarImagen(String dni) {
        setBounds(100, 100, 500, 400); // Cambié las dimensiones de la ventana
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 166, 128));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(new GridLayout(20, 10, 10, 10));

        // Mostrar saldo del usuario
        float saldo = Controlador.obtenerSaldoUsuario(dni);
        lblSaldo = new JLabel("Saldo: " + saldo + "€");
        lblSaldo.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        contentPanel.add(lblSaldo);

        // Botón para salir a otra ventana
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salir(dni);
            }
        });
        contentPanel.add(btnSalir);

        // Obtener la lista de Pokémon de la base de datos
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        List<Pokemon> pokemonList = db.obtenerListaPokemon();

        // Iterar sobre la lista de Pokémon y agregar las imágenes al panel
        for (Pokemon pokemon : pokemonList) {
            JPanel pokemonPanel = new JPanel(new BorderLayout());
            
            try {
                ImageIcon icon = new ImageIcon(pokemon.getRutaImagen());
                JLabel imageLabel = new JLabel(icon);
                pokemonPanel.add(imageLabel, BorderLayout.CENTER);
            } catch (Exception ex) {
                JLabel errorLabel = new JLabel("Error al cargar la imagen: " + ex.getMessage());
                pokemonPanel.add(errorLabel, BorderLayout.CENTER);
                ex.printStackTrace();
            }


            // Agregar la imagen del Pokémon al panel personalizado
            JLabel imageLabel = new JLabel();
            ImageIcon icon = new ImageIcon(pokemon.getImagen_pokemon());
            Image image = icon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen
            imageLabel.setIcon(new ImageIcon(image));
            // Centrar la imagen horizontal y verticalmente en el panel
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
            pokemonPanel.add(imageLabel, BorderLayout.CENTER);

            // Agregar la cantidad y el precio del Pokémon al panel personalizado
            JLabel infoLabel = new JLabel("<html><center>Cantidad: " + pokemon.getStock_pokemon() + "<br>Precio: " + pokemon.getPrecioPokemon() + "€</center></html>");
            infoLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14)); // Ajusta el tamaño de la fuente
            infoLabel.setHorizontalAlignment(JLabel.CENTER);
            pokemonPanel.add(infoLabel, BorderLayout.SOUTH);

            // Agregar JSpinner para seleccionar la cantidad deseada
            int stockPokemon = pokemon.getStock_pokemon();
            if (stockPokemon <= 0) {
                stockPokemon = 1; // Default to 1 if stock is not valid
            }
            SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, stockPokemon, 1);
            JSpinner spinner = new JSpinner(spinnerModel);
            pokemonPanel.add(spinner, BorderLayout.WEST);

            // Agregar botón de compra
            JButton buyButton = new JButton("Comprar");
            buyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int cantidadDeseada = (int) spinner.getValue();
                    if (cantidadDeseada > 0 && cantidadDeseada <= pokemon.getStock_pokemon()) {
                        Controlador.realizarCompraPokemon(dni, pokemon.getCodigo_pokemon(), cantidadDeseada);
                        lblSaldo.setText("Saldo: " + Controlador.obtenerSaldoUsuario(dni) + "€");
                        infoLabel.setText("<html><center>Cantidad: " + (pokemon.getStock_pokemon() - cantidadDeseada) + "<br>Precio: " + pokemon.getPrecioPokemon() + "€</center></html>");
                    } else {
                        mostrarMensajeError("Cantidad no válida o stock insuficiente");
                    }
                }
            });
            pokemonPanel.add(buyButton, BorderLayout.NORTH);

            contentPanel.add(pokemonPanel);
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setPreferredSize(new Dimension(450, 300)); // Establece el tamaño preferido del JScrollPane
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
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
