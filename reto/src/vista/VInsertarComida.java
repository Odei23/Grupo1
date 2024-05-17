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


public class VInsertarComida extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtEfecto;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtNombre;
    private String rutaImagenSeleccionada;
    private JLabel lblImagen;

    /*
     * @Erik. Basicamente lo que se hace en este metodo es insertar una nueva comida en la base de datos.
     */
    
    public VInsertarComida(String dni) {
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

        txtEfecto = new JTextField();
        txtEfecto.setBounds(338, 305, 192, 30);
        contentPanel.add(txtEfecto);
        txtEfecto.setColumns(20);

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

        JLabel lblEfecto = new JLabel("Efecto:");
        lblEfecto.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblEfecto.setBounds(244, 308, 100, 20);
        contentPanel.add(lblEfecto);

        txtNombre = new JTextField();
        txtNombre.setBounds(338, 182, 192, 30);
        contentPanel.add(txtNombre);
        txtNombre.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnGuardar.setBounds(359, 368, 150, 36);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarComida(dni);
            }
        });
        contentPanel.add(btnGuardar);

        lblImagen = new JLabel("");
        lblImagen.setBounds(572, 121, 150, 150);
        contentPanel.add(lblImagen);

        JButton btnCambiarImagen = new JButton("Cambiar Imagen");
        btnCambiarImagen.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCambiarImagen.setBounds(572, 282, 155, 45);
        btnCambiarImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen();
            }
        });
        contentPanel.add(btnCambiarImagen);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		salir(dni);
        	}
        });
        btnSalir.setBounds(30, 25, 105, 36);
        contentPanel.add(btnSalir);
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
     * @Erik. Este método se encarga de guardar la información sobre una nueva comida en la base de datos.
     */

	protected void guardarComida(String dni) {
    	 String nombre = txtEfecto.getText();
         int precio = Integer.parseInt(txtPrecio.getText());
         int stock = Integer.parseInt(txtStock.getText());
         String efecto = txtNombre.getText();

         
         String nuevoCodigo = obtenerCodigoNuevaComida();

         ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
         db.openConnection();
         db.insertarObjeto(nuevoCodigo, nombre,precio, stock, rutaImagenSeleccionada); // Insertar primero el objeto
         db.insertarComida(nuevoCodigo, efecto); // Luego insertar la pokeball
         db.closeConnection();

         // Mostrar mensaje de éxito
         JOptionPane.showMessageDialog(this, "Comida guardada con éxito.");
         this.setVisible(false);
         
         // Abrir la ventana InsertarObjetos
         InsertarObjetos io = new InsertarObjetos(dni); 
         io.setVisible(true);
    }
	
	/*
	 * @Erik. Este método obtiene el código de la nueva comida, para asegurar 
	 * que cada comida tenga un identificador único en la base de datos.
	 */
	
    private String obtenerCodigoNuevaComida() {
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();      
        String cod;
        cod = db.obtenerCodigosComida();
        return cod;
	}
    
    /*
     * @Erik. Este método se utiliza para permitir al usuario seleccionar una imagen para asociarla con la comida.
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
                    // Obtener el código de la Pokeball
                    String codigoComida = obtenerCodigoNuevaComida();
                    // Establecer la ruta de la imagen con el formato deseado
                    rutaImagenSeleccionada = "..\\reto\\imagenes\\" + codigoComida + ".png";
                    // Copiar la imagen seleccionada a la carpeta destino
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

}