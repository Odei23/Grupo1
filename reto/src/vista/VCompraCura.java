package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Cura;
import modelo.ImplementacionBaseDeDatos;
import modelo.Pokemon;

public class VCompraCura extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    private JLabel lblSaldo;

	public VCompraCura(String dni) {
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
        List<Cura> curaList = db.obtenerListaCura();
        // Iterar sobre la lista de Pokémon y agregar las imágenes al panel
        for (Cura cura : curaList) {
            // Crear un panel personalizado para cada Pokémon
            JPanel curaPanel = new JPanel(new BorderLayout());

            // Agregar la imagen del Pokémon al panel personalizado
            JLabel imageLabel = new JLabel();
            ImageIcon icon = new ImageIcon(cura.getImagen_cura());
            Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centra horizontalmente
            imageLabel.setVerticalAlignment(SwingConstants.CENTER); // Centra verticalmente
            curaPanel.add(imageLabel, BorderLayout.CENTER);

            // Agregar la cantidad y el precio del Pokémon al panel personalizado
            JLabel infoLabel = new JLabel("<html><center>Cantidad: " + cura.getStock_cura() + "<br>Precio: " + cura.getPrecio_cura() + "€</center></html>");
            infoLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
            infoLabel.setHorizontalAlignment(JLabel.CENTER);
            curaPanel.add(infoLabel, BorderLayout.SOUTH);

            // Agregar JSpinner para seleccionar la cantidad deseada
            int stock_cura = cura.getStock_cura();
            if (stock_cura <= 0) {
            	stock_cura = 1; 
            }
            SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, stock_cura, 1);
            JSpinner spinner = new JSpinner(spinnerModel);
            curaPanel.add(spinner, BorderLayout.WEST);

            // Agregar botón de compra
            JButton buyButton = new JButton("Comprar");
            buyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Obtener la cantidad que el usuario quiere comprar
                    int cantidadDeseada = (int) spinner.getValue();

                    // Verificar si hay suficiente stock para la compra
                    if (cantidadDeseada > 0 && cantidadDeseada <= cura.getStock_cura()) {
                        // Realizar la compra y actualizar el stock en la base de datos
                        Controlador.realizarCompraCura(dni, cura.getCodigo_objeto(), cantidadDeseada); // Implementa este método en tu Controlador

                        // Actualizar la etiqueta de saldo y la cantidad de stock mostrada
                        lblSaldo.setText("Saldo: " + Controlador.obtenerSaldoUsuario(dni) + "€");
                        infoLabel.setText("<html><center>Cantidad: " + (cura.getStock_cura() - cantidadDeseada) + "<br>Precio: " + cura.getPrecio_cura() + "€</center></html>");
                    } else {
                        // Mostrar un mensaje de error si no hay suficiente stock
                        mostrarMensajeError("Cantidad no válida o stock insuficiente");
                    }
                }
            });
            curaPanel.add(buyButton, BorderLayout.NORTH);

            contentPanel.add(curaPanel);
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
