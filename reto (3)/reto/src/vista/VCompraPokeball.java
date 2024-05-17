package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controlador.Controlador;
import modelo.ImplementacionBaseDeDatos;
import modelo.Objeto;

public class VCompraPokeball extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JLabel lblSaldo;

    /*
     * @Erik. Lo que se hace en esta ventana es que muestra algunos datos de el objeto pokeball y 
     * nos da la opcion de comprarlos, quitandonos el saldo y stock del objeto comprado.
     */

    public VCompraPokeball(String dni) {
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

        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        List<Objeto> objetoList = db.obtenerListaPokeball();
        // Iterar sobre la lista de Pokeballs y agregar las imágenes al panel
        for (Objeto objeto : objetoList) {
            // Crear un panel personalizado para cada Pokeball
            JPanel objetoPanel = new JPanel(new BorderLayout());

            // Agregar la imagen de la Pokeball al panel personalizado
            JLabel imageLabel = new JLabel();
            ImageIcon icon = new ImageIcon(objeto.getImagen_objeto()); 
            Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setVerticalAlignment(SwingConstants.CENTER); 
            objetoPanel.add(imageLabel, BorderLayout.CENTER);

            JLabel infoLabel = new JLabel("<html><center>Cantidad: " + objeto.getStock_objeto() + "<br>Precio: " + objeto.getPrecio_objeto() + "€</center></html>");
            infoLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
            infoLabel.setHorizontalAlignment(JLabel.CENTER);
            objetoPanel.add(infoLabel, BorderLayout.SOUTH);

            // Agregar JSpinner para seleccionar la cantidad deseada
            int stockPokemon = objeto.getStock_objeto();
            if (stockPokemon <= 0) {
                stockPokemon = 1;
            }
            SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, stockPokemon, 1);
            JSpinner spinner = new JSpinner(spinnerModel);
            objetoPanel.add(spinner, BorderLayout.WEST);

            JButton buyButton = new JButton("Comprar");
            buyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int cantidadDeseada = (int) spinner.getValue();
                    if (cantidadDeseada > 0 && cantidadDeseada <= objeto.getStock_objeto()) {
                        float saldoUsuario = Controlador.obtenerSaldoUsuario(dni);
                        int precioTotal = objeto.getPrecio_objeto() * cantidadDeseada;
                        if (saldoUsuario >= precioTotal) {
                            try {
                                // Realizar la compra y actualizar el saldo y el stock en la base de datos
                                Controlador.realizarCompraPokeball(dni, objeto.getCodigo_Objeto(), cantidadDeseada*objeto.getStock_objeto() );
                                
                                // Actualizar el texto del JLabel infoLabel con la información actualizada
                                infoLabel.setText("<html><center>Cantidad: " + (objeto.getStock_objeto() - cantidadDeseada) +
                                        "<br>Precio: " + objeto.getPrecio_objeto() + "€</center></html>");
                                
                                lblSaldo.setText("Saldo: " + Controlador.obtenerSaldoUsuario(dni) + "€");
                            } catch (Exception ex) {
                                mostrarMensajeError("Error al realizar la compra: " + ex.getMessage());
                            }
                        } else {
                            mostrarMensajeError("Saldo insuficiente para realizar la compra");
                        }
                    } else {
                        mostrarMensajeError("Cantidad no válida o stock insuficiente");
                    }
                }
            });

            objetoPanel.add(buyButton, BorderLayout.NORTH);

            contentPanel.add(objetoPanel);
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    /*
     * @Erik. Este metodo sirve para volver al menu principal.
     */
    
    
    protected void salir(String dni) {
        this.setVisible(false);
        VentanaMenuUsuario vAD = new VentanaMenuUsuario(dni);
        vAD.setVisible(true);
    }

    /*
     * @Erik. Este metodo sirve para mostrar un mensaje de error al usuario
     */ 
    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
