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
import java.util.List;
import modelo.ImplementacionBaseDeDatos;
import modelo.Pokemon;

public class VInsertarPokemon extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombre;
    private JTextField txtTipo;
    private JTextField txtColor;
    private JTextField txtNumEvo;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private String rutaImagenSeleccionada;

    private JLabel lblImagen;
    private JLabel lblImagen_1;
    private boolean esLegendario = false;

    /*
     * @Erik. Basicamente lo que se hace en este metodo es insertar un nuevo pokemon en la base de datos.
     */
    
    public VInsertarPokemon(String dni) {
        setBounds(100, 100, 900, 645);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JLabel logo = new JLabel("");
      	logo.setBounds(368, 11, 155, 134);
      	ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.PNG"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
              
        logo.setIcon (img2);
      	contentPanel.add(logo);


        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNombre.setBounds(229, 191, 96, 19);
        contentPanel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(331, 187, 192, 30);
        contentPanel.add(txtNombre);
        txtNombre.setColumns(20);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTipo.setBounds(229, 229, 85, 16);
        contentPanel.add(lblTipo);

        txtTipo = new JTextField();
        txtTipo.setBounds(331, 224, 192, 30);
        contentPanel.add(txtTipo);
        txtTipo.setColumns(20);

        JLabel lblColor = new JLabel("Color:");
        lblColor.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblColor.setBounds(229, 272, 96, 16);
        contentPanel.add(lblColor);

        txtColor = new JTextField();
        txtColor.setBounds(331, 265, 192, 30);
        contentPanel.add(txtColor);
        txtColor.setColumns(20);

        JLabel lblNumEvo = new JLabel("Num. Evo:");
        lblNumEvo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNumEvo.setBounds(229, 308, 166, 16);
        contentPanel.add(lblNumEvo);

        txtNumEvo = new JTextField();
        txtNumEvo.setBounds(331, 303, 192, 30);
        contentPanel.add(txtNumEvo);
        txtNumEvo.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPrecio.setBounds(229, 344, 161, 16);
        contentPanel.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(331, 339, 192, 30);
        contentPanel.add(txtPrecio);
        txtPrecio.setColumns(10);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblStock.setBounds(229, 382, 161, 16);
        contentPanel.add(lblStock);

        txtStock = new JTextField();
        txtStock.setBounds(331, 377, 192, 30);
        contentPanel.add(txtStock);
        txtStock.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(355, 428, 146, 36);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarPokemon(dni);
            }
        });
        contentPanel.add(btnGuardar);

        lblImagen = new JLabel("");
        lblImagen.setBounds(567, 179, 152, 145);
        contentPanel.add(lblImagen);

        JButton btnCambiarImagen = new JButton("Cambiar Imagen");
        btnCambiarImagen.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCambiarImagen.setBounds(553, 332, 174, 43);
        btnCambiarImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	seleccionarImagen();
            }
        });
        contentPanel.add(btnCambiarImagen);
        
        lblImagen_1 = new JLabel("");
        lblImagen_1.setBounds(572, 168, 120, 120);
        contentPanel.add(lblImagen_1);

        JCheckBox chckbxLegendario = new JCheckBox("Legendario");
        chckbxLegendario.setBounds(587, 400, 120, 21);
        chckbxLegendario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                esLegendario = chckbxLegendario.isSelected(); // Actualiza el estado de esLegendario
            }
        });
        contentPanel.add(chckbxLegendario);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		salir(dni);
        	}
        });
        btnSalir.setBounds(32, 21, 112, 36);
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
     * @Erik. Este método se encarga de guardar la información sobre un nuevo pokemon en la base de datos.
     */

	private void guardarPokemon(String dni) {
        String nombre = txtNombre.getText();
        String tipo = txtTipo.getText();
        String color = txtColor.getText();
        int numEvo = Integer.parseInt(txtNumEvo.getText());
        int precio = Integer.parseInt(txtPrecio.getText());
        int stock = Integer.parseInt(txtStock.getText());

        // Obtener el siguiente código disponible
        int nuevoCodigo = obtenerCodigoNuevoPokemon();

        // Crear el objeto Pokemon con los datos ingresados
        Pokemon nuevoPokemon = new Pokemon();
        nuevoPokemon.setCodigo_pokemon(nuevoCodigo);
        nuevoPokemon.setNombre(nombre);
        nuevoPokemon.setTipo(tipo);
        nuevoPokemon.setColor(color);
        nuevoPokemon.setNum_evo(numEvo);
        nuevoPokemon.setPrecioPokemon(precio);
        nuevoPokemon.setStock_pokemon(stock);
        nuevoPokemon.setLegendario(esLegendario);
        nuevoPokemon.setImagen_pokemon(rutaImagenSeleccionada); 

        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        db.insertarPokemon(nuevoPokemon);
        db.closeConnection();

        JOptionPane.showMessageDialog(this, "Pokémon guardado con éxito.");
        
        this.setVisible(false);
        
        // Abrir la ventana InsertarObjetos
        InsertarObjetos io = new InsertarObjetos(dni); 
        io.setVisible(true);
    }

	/*
	 * @Erik. Este método obtiene el código del nuevo pokemon, para asegurar 
	 * que cada pokemon tenga un identificador único en la base de datos.
	 */
	
    private int obtenerCodigoNuevoPokemon() {
        // Obtener el último código de Pokémon en la base de datos
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        List<Integer> codigos = db.obtenerCodigosPokemon();
        db.closeConnection();

        // Encontrar el máximo y sumar 1 para el nuevo código
        int maxCodigo = 0;
        for (Integer codigo : codigos) {
            if (codigo > maxCodigo) {
                maxCodigo = codigo;
            }
        }
        return maxCodigo + 1;
    }

    
    /*
     * @Erik. Este método se utiliza para permitir al usuario 
     * seleccionar una imagen para asociarla con el nuevo pokemon.
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
                    // Obtener el código del Pokémon
                    int codigoPokemon = obtenerCodigoNuevoPokemon();
                    // Establecer la ruta de la imagen con el formato deseado
                    rutaImagenSeleccionada = "..\\reto\\imagenes\\" + String.format("%03d", codigoPokemon) + ".png";
                    // Copiar la imagen seleccionada a la carpeta destino
                    Files.copy(Paths.get(file.getAbsolutePath()), Paths.get(rutaImagenSeleccionada), StandardCopyOption.REPLACE_EXISTING);
                    // Mostrar la imagen en el JLabel
                    ImageIcon imagen = new ImageIcon(rutaImagenSeleccionada);
                    Image img = imagen.getImage().getScaledInstance(lblImagen_1.getWidth(), lblImagen_1.getHeight(), Image.SCALE_SMOOTH);
                    lblImagen_1.setIcon(new ImageIcon(img));
                } catch (IOException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}