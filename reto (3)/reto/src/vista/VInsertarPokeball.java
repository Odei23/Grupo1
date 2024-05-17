package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import modelo.ImplementacionBaseDeDatos;
import modelo.Objeto;
import modelo.Pokeball;
import java.util.List;


public class VInsertarPokeball extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtRatio;
    private String rutaImagenSeleccionada;
    private JLabel lblImagen;

    /*
     * @Erik. Basicamente lo que se hace en este metodo es insertar una nueva pokeball en la base de datos.
     */
    
    public VInsertarPokeball(String dni) {
        setBounds(100, 100, 900, 645);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JLabel logo = new JLabel("");
  		logo.setBounds(354, 11, 155, 134);
  		ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.PNG"));
          ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
          
          logo.setIcon (img2);
  		contentPanel.add(logo);


        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNombre.setBounds(244, 186, 100, 20);
        contentPanel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(338, 183, 192, 30);
        contentPanel.add(txtNombre);
        txtNombre.setColumns(20);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPrecio.setBounds(244, 226, 100, 20);
        contentPanel.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(338, 223, 192, 30);
        contentPanel.add(txtPrecio);
        txtPrecio.setColumns(10);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblStock.setBounds(244, 267, 100, 20);
        contentPanel.add(lblStock);

        txtStock = new JTextField();
        txtStock.setBounds(338, 264, 192, 30);
        contentPanel.add(txtStock);
        txtStock.setColumns(10);

        JLabel lblRatio = new JLabel("Ratio:");
        lblRatio.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblRatio.setBounds(244, 308, 100, 20);
        contentPanel.add(lblRatio);

        txtRatio = new JTextField();
        txtRatio.setBounds(338, 305, 192, 30);
        contentPanel.add(txtRatio);
        txtRatio.setColumns(10);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		salir(dni);
        	}
        });
        btnSalir.setBounds(30, 25, 105, 36);
        contentPanel.add(btnSalir);
    
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnGuardar.setBounds(359, 368, 150, 36);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarPokeball(dni);
            }
        });
        contentPanel.add(btnGuardar);

        lblImagen = new JLabel("");
        lblImagen.setBounds(571, 137, 150, 150);
        contentPanel.add(lblImagen);

        JButton btnCambiarImagen = new JButton("Cambiar Imagen");
        btnCambiarImagen.setBounds(571, 298, 150, 30);
        btnCambiarImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen();
            }
        });
        contentPanel.add(btnCambiarImagen);
    }

    /*
     * @Erik. Este metodo lo que hace es que al pulsar el boton vuelva al menu de administrador
     */

	protected void salir(String dni) {
		this.setVisible(false);
		VentanaMenuAdmin vma = new VentanaMenuAdmin(dni);
		vma.setVisible(true);
		
	}

	 /*
     * @Erik. Este método se encarga de guardar la información sobre 
     * una nueva pokeball en la base de datos.
     */
	
    private void guardarPokeball(String dni) {
        String nombre = txtNombre.getText();
        int precio = Integer.parseInt(txtPrecio.getText());
        int stock = Integer.parseInt(txtStock.getText());
        int ratio = Integer.parseInt(txtRatio.getText());

        String nuevoCodigo = obtenerCodigoNuevaPokeball();

        // Insertar el nuevo Objeto (Pokeball) en la base de datos
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        db.insertarObjeto(nuevoCodigo, nombre,precio, stock, rutaImagenSeleccionada); // Insertar primero el objeto
        db.insertarPokeball(nuevoCodigo, ratio); // Luego insertar la pokeball
        db.closeConnection();

        JOptionPane.showMessageDialog(this, "Pokeball guardada con éxito.");
        this.setVisible(false);
        
        // Abrir la ventana InsertarObjetos
        InsertarObjetos io = new InsertarObjetos(dni); 
        io.setVisible(true);
    }

    /*
     * @Erik. Este método se utiliza para permitir al usuario seleccionar 
     * una imagen para asociarla con la pokeball.
     */
    
    private void seleccionarImagen() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de imagen PNG", "png");
        fc.setFileFilter(filtro);
        int res = fc.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file != null) {
                try {
                    String codigoPokeball = obtenerCodigoNuevaPokeball();
                    rutaImagenSeleccionada = "..\\reto\\imagenes\\" + codigoPokeball + ".png";
                    Files.copy(Paths.get(file.getAbsolutePath()), Paths.get(rutaImagenSeleccionada), StandardCopyOption.REPLACE_EXISTING);
                    // Mostrar la imagen en el JLabel
                    ImageIcon imagen = new ImageIcon(rutaImagenSeleccionada);
                    Image img = imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                    lblImagen.setIcon(new ImageIcon(img));
                } catch (IOException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
	/*
	 * @Erik. Este método obtiene el código de la nueva pokeball, para asegurar 
	 * que cada pokeball tenga un identificador único en la base de datos.
	 */
    
    private String obtenerCodigoNuevaPokeball() {
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();      
        String cod;
        cod = db.obtenerCodigosPokeball();
        return cod;
    }

}