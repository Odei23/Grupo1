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
import modelo.Pokemon;

public class VCompraComida extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JLabel lblSaldo;

    /*
     * @Erik. Lo que se hace en esta ventana es que muestra algunos datos de el objeto comida y 
     * nos da la opcion de comprarlos, quitandonos el saldo y stock del objeto comprado.
     */
    
    public VCompraComida(String dni) {
    	setLocationRelativeTo(null);
        setBounds(100, 100, 1154, 775);
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
        List<Objeto> objetoList = db.obtenerListaComida();
        // Iterar sobre la lista de Pokémon y agregar las imágenes al panel
        for (Objeto comida : objetoList) {
            // Crear un panel personalizado para cada Pokémon
            JPanel comidaPanel = new JPanel(new BorderLayout());

            // Agregar la imagen del Pokémon al panel personalizado
         // Agregar la imagen del Pokémon al panel personalizado
            JLabel imageLabel = new JLabel();

            ImageIcon icon = new ImageIcon(comida.getImagen_objeto()); // Intentar crear el ImageIcon
            Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centra horizontalmente
            imageLabel.setVerticalAlignment(SwingConstants.CENTER); // Centra verticalmente
            comidaPanel.add(imageLabel, BorderLayout.CENTER);        


            // Agregar la cantidad y el precio del Pokémon al panel personalizado
            JLabel infoLabel = new JLabel("<html><center>Cantidad: " + comida.getStock_objeto() + "<br>Precio: " + comida.getPrecio_objeto() + "€</center></html>");
            infoLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
            infoLabel.setHorizontalAlignment(JLabel.CENTER);
            comidaPanel.add(infoLabel, BorderLayout.SOUTH);

            // Agregar JSpinner para seleccionar la cantidad deseada
            int stockComida = comida.getStock_objeto();
            if (stockComida <= 0) {
            	stockComida = 1;
            }
            SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, stockComida, 1);
            JSpinner spinner = new JSpinner(spinnerModel);
            comidaPanel.add(spinner, BorderLayout.WEST);

            // Agregar botón de compra
            JButton buyButton = new JButton("Comprar");
            buyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Obtener la cantidad que el usuario quiere comprar
                    int cantidadDeseada = (int) spinner.getValue();

                    // Verificar si hay suficiente stock para la compra
                    if (cantidadDeseada > 0 && cantidadDeseada <= comida.getStock_objeto()) {
                        // Verificar si el usuario tiene suficiente saldo
                        float saldoUsuario = Controlador.obtenerSaldoUsuario(dni);
                        int precioTotal = comida.getPrecio_objeto() * cantidadDeseada;
                        if (saldoUsuario >= precioTotal) {
                            // Realizar la compra y actualizar el saldo y el stock en la base de datos
                            try {
								Controlador.realizarCompraComida(dni,comida.getCodigo_Objeto(), cantidadDeseada);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                            lblSaldo.setText("Saldo: " + Controlador.obtenerSaldoUsuario(dni) + "€");
                            infoLabel.setText("<html><center>Cantidad: "
                                    + (comida.getStock_objeto() - cantidadDeseada) + "<br>Precio: "
                                    + comida.getPrecio_objeto() + "€</center></html>");
                        } else {
                            mostrarMensajeError("Saldo insuficiente para realizar la compra");
                        }
                    } else {
                        // Mostrar un mensaje de error si no hay suficiente stock
                        mostrarMensajeError("Cantidad no válida o stock insuficiente");
                    }
                }
            });

            comidaPanel.add(buyButton, BorderLayout.NORTH);

            contentPanel.add(comidaPanel);
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