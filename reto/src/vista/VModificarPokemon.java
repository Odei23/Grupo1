package vista;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import java.awt.Font;

public class VModificarPokemon extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JComboBox<Integer> comboBoxCodigo;
    private JTextField txtNombre;
    private JTextField txtTipo;
    private JTextField txtColor;
    private JTextField txtNumEvo;
    private String rutaImagenSeleccionada;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JButton btnSeleccionarImagen;
    private boolean imagenSeleccionada = false;
    private File file;
    private String carpetaFinal = "..\\reto\\imagenes\\";

    /*
     * @Erik. Lo que se hace en esta ventana es que mediante el codigo que eligas te muestra 
     * la informacion de ese pokemon y te da la opcion de cambiar todos los datos menos el codigo
     */
    
    public VModificarPokemon(String dni) {
        setBounds(100, 100, 820, 573);
        getContentPane().setLayout(null);
        contentPanel.setBounds(20, 11, 763, 512);
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);

        comboBoxCodigo = new JComboBox<>();
        comboBoxCodigo.setBounds(243, 105, 200, 25);
        contentPanel.add(comboBoxCodigo);

        txtNombre = new JTextField();
        txtNombre.setBounds(243, 141, 200, 25);
        contentPanel.add(txtNombre);
        txtNombre.setColumns(10);

        txtTipo = new JTextField();
        txtTipo.setBounds(243, 177, 200, 25);
        contentPanel.add(txtTipo);
        txtTipo.setColumns(10);

        txtColor = new JTextField();
        txtColor.setBounds(243, 213, 200, 25);
        contentPanel.add(txtColor);
        txtColor.setColumns(10);

        txtNumEvo = new JTextField();
        txtNumEvo.setBounds(243, 249, 200, 25);
        contentPanel.add(txtNumEvo);
        txtNumEvo.setColumns(10);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(243, 290, 200, 25);
        contentPanel.add(txtPrecio);
        txtPrecio.setColumns(10);

        txtStock = new JTextField();
        txtStock.setBounds(243, 326, 200, 25);
        contentPanel.add(txtStock);
        txtStock.setColumns(10);

        btnSeleccionarImagen = new JButton("Seleccionar Imagen PNG");
        btnSeleccionarImagen.setBounds(243, 372, 200, 25);
        contentPanel.add(btnSeleccionarImagen);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(297, 425, 100, 25);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCambios(dni);
            }
        });
        contentPanel.add(btnGuardar);
        
        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblCodigo.setBounds(119, 100, 132, 31);
        contentPanel.add(lblCodigo);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNombre.setBounds(119, 136, 132, 31);
        contentPanel.add(lblNombre);
        
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTipo.setBounds(119, 172, 132, 31);
        contentPanel.add(lblTipo);
        
        JLabel lblColor = new JLabel("Color:");
        lblColor.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblColor.setBounds(119, 213, 132, 31);
        contentPanel.add(lblColor);
        
        JLabel lblLegendario = new JLabel("Legendario:");
        lblLegendario.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblLegendario.setBounds(119, 248, 132, 31);
        contentPanel.add(lblLegendario);
        
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblPrecio.setBounds(119, 285, 132, 31);
        contentPanel.add(lblPrecio);
        
        JLabel lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblStock.setBounds(119, 321, 132, 31);
        contentPanel.add(lblStock);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		salir(dni);
        	}
        });
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnSalir.setBounds(605, 39, 117, 43);
        contentPanel.add(btnSalir);

        cargarCodigosPokemon();

        comboBoxCodigo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarDatosPokemon((int) comboBoxCodigo.getSelectedItem());
            }
        });

        btnSeleccionarImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen();
            }
        });
    }

    

	private void cargarCodigosPokemon() {
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        List<Integer> codigos = db.obtenerCodigosPokemon();
        for (Integer codigo : codigos) {
            comboBoxCodigo.addItem(codigo);
        }
        db.closeConnection();
    }

    private void cargarDatosPokemon(int codigo) {
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        Pokemon pokemon = db.obtenerPokemonPorCodigo(codigo);
        if (pokemon != null) {
            txtNombre.setText(pokemon.getNombre());
            txtTipo.setText(pokemon.getTipo());
            txtColor.setText(pokemon.getColor());
            txtNumEvo.setText(String.valueOf(pokemon.getNum_evo()));
            txtPrecio.setText(String.valueOf(pokemon.getPrecioPokemon()));
            txtStock.setText(String.valueOf(pokemon.getStock_pokemon()));
            String nombreImagen = String.format("%03d", codigo) + ".png";
            rutaImagenSeleccionada = carpetaFinal + nombreImagen;
            btnSeleccionarImagen.setText(nombreImagen);
            imagenSeleccionada = true;
            txtNombre.setEditable(false);
            txtTipo.setEditable(false);
            txtColor.setEditable(false);
            txtNumEvo.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un Pokémon con el código especificado.");
        }
    }

    private void seleccionarImagen() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de imagen PNG", "png");
        fc.setFileFilter(filtro);
        int res = fc.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            if (file != null) {
                try {
                    rutaImagenSeleccionada = file.getAbsolutePath();
                    Files.copy(Paths.get(rutaImagenSeleccionada), Paths.get(new File(carpetaFinal, file.getName()).getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
                    btnSeleccionarImagen.setText(file.getName());
                    imagenSeleccionada = true;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private void guardarCambios(String dni) {
        if (!imagenSeleccionada) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "No ha seleccionado una imagen. ¿Desea continuar sin una imagen?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }
        }

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(10, 11, 140, 48);
        contentPanel.add(btnSalir);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salir(dni);
            }
        });

        int codigo = (int) comboBoxCodigo.getSelectedItem();
        String nombre = txtNombre.getText();
        String tipo = txtTipo.getText();
        String color = txtColor.getText();
        int num_evo = Integer.parseInt(txtNumEvo.getText());
        int precio = Integer.parseInt(txtPrecio.getText());
        int stock = Integer.parseInt(txtStock.getText());
        Pokemon pokemon = new Pokemon();
        pokemon.setCodigo_pokemon(codigo);
        pokemon.setNombre(nombre);
        pokemon.setTipo(tipo);
        pokemon.setColor(color);
        pokemon.setNum_evo(num_evo);
        pokemon.setPrecioPokemon(precio);
        pokemon.setStock_pokemon(stock);
        pokemon.setImagen_pokemon(rutaImagenSeleccionada);
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.actualizarPokemon(pokemon);
        this.setVisible(false);
        VentanaMenuAdmin menuAdmin = new VentanaMenuAdmin(dni);
        menuAdmin.setVisible(true);
        dispose();
    }


    private int obtenerCodigoNuevoPokemon() {
        // Obtener el siguiente código disponible
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        List<Integer> codigos = db.obtenerCodigosPokemon();
        db.closeConnection();
        int maxCodigo = 0;
        for (Integer codigo : codigos) {
            if (codigo > maxCodigo) {
                maxCodigo = codigo;
            }
        }
        return maxCodigo + 1;
    }
    
    // Método para agregar un nuevo Pokémon al sistema con un código específico
    private void agregarNuevoPokemon(int nuevoCodigo) {
        // Establecer el código en el ComboBox
        comboBoxCodigo.setSelectedItem(nuevoCodigo);
        // Limpiar los campos de entrada
        txtNombre.setText("");
        txtTipo.setText("");
        txtColor.setText("");
        txtNumEvo.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        // Deshabilitar la edición de los campos
        txtNombre.setEditable(false);
        txtTipo.setEditable(false);
        txtColor.setEditable(false);
        txtNumEvo.setEditable(false);
        txtPrecio.setEditable(false);
        txtStock.setEditable(false);
    }
    
    protected void salir(String dni) {

    	this.setVisible(false);
    	VentanaMenuAdmin vma = new VentanaMenuAdmin(dni);
    	vma.setVisible(true);
    	
	}
}
