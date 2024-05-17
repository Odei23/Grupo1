package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.ImplementacionBaseDeDatos;
import modelo.Objeto;
import modelo.Pokeball;
import java.awt.Font;

public class VModificarPokeball extends JDialog {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboBoxCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtRatio;
    private JButton btnSeleccionarImagen;
    private String dni;
    private String rutaImagenSeleccionada;
    private JButton btnSalir;

    /*
     * @Erik. Lo que se hace en esta ventana es que mediante el codigo que eligas te muestra la 
     * informacion de esa pokeball y te da la opcion de cambiar todos los datos menos el codigo
     */
    
    public VModificarPokeball(String dni) {
        this.dni = dni;
        setBounds(100, 100, 820, 573);
        getContentPane().setLayout(null);
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(33, 11, 721, 475);
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);

        comboBoxCodigo = new JComboBox<>();
        comboBoxCodigo.setBounds(243, 105, 200, 25);
        contentPanel.add(comboBoxCodigo);

        txtNombre = new JTextField();
        txtNombre.setBounds(243, 141, 200, 25);
        contentPanel.add(txtNombre);
        txtNombre.setColumns(10);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(243, 177, 200, 25);
        contentPanel.add(txtPrecio);
        txtPrecio.setColumns(10);

        txtStock = new JTextField();
        txtStock.setBounds(243, 213, 200, 25);
        contentPanel.add(txtStock);
        txtStock.setColumns(10);

        txtRatio = new JTextField();
        txtRatio.setBounds(243, 249, 200, 25);
        contentPanel.add(txtRatio);
        txtRatio.setColumns(10);

        btnSeleccionarImagen = new JButton("Seleccionar Imagen PNG");
        btnSeleccionarImagen.setBounds(243, 285, 200, 25);
        btnSeleccionarImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen();
            }
        });
        contentPanel.add(btnSeleccionarImagen);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(297, 321, 100, 25);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCambios(dni);
            }
        });
        contentPanel.add(btnGuardar);
        
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		salir(dni);
        	}
        });
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSalir.setBounds(23, 31, 125, 42);
        contentPanel.add(btnSalir);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNombre.setBounds(150, 141, 82, 22);
        contentPanel.add(lblNombre);
        
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPrecio.setBounds(150, 177, 82, 22);
        contentPanel.add(lblPrecio);
        
        JLabel lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblStock.setBounds(150, 213, 82, 22);
        contentPanel.add(lblStock);
        
        JLabel lblRattio = new JLabel("Ratio:");
        lblRattio.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblRattio.setBounds(150, 249, 82, 22);
        contentPanel.add(lblRattio);
        cargarCodigosPokeball();

        comboBoxCodigo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarDatosPokeball();
            }
        });
    }

	protected void salir(String dni) {
		
		this.setVisible(false);
		VentanaMenuAdmin vma = new VentanaMenuAdmin(dni);
		vma.setVisible(true);
		
	}

	protected void seleccionarImagen() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de imagen PNG", "png");
        fc.setFileFilter(filtro);
        int res = fc.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file != null) {
                try {
                    String nombreArchivo = file.getName();
                    if (nombreArchivo != null) {
                        rutaImagenSeleccionada = "..\\reto\\imagenes\\" + nombreArchivo;
                        Files.copy(file.toPath(), Paths.get(rutaImagenSeleccionada), StandardCopyOption.REPLACE_EXISTING);
                        btnSeleccionarImagen.setText(nombreArchivo);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    private void cargarCodigosPokeball() {
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        List<String> codigos = db.obtenerCodigosPokeball(dni);
        db.closeConnection();

        if (codigos != null && !codigos.isEmpty()) {
            Collections.sort(codigos);
            comboBoxCodigo.removeAllItems();
            for (String codigo : codigos) {
                comboBoxCodigo.addItem(codigo);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron códigos de cura.");
        }
    }

    private void cargarDatosPokeball() {
        String codigo = (String) comboBoxCodigo.getSelectedItem();
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        Objeto obj =  db.obtenerObjetoPorCodigo(codigo);
        Pokeball pokeball = db.obtenerPokeballPorCodigo(codigo);
        db.closeConnection();

        if (pokeball != null) {
            txtNombre.setText(obj.getNombre_objeto());
            txtPrecio.setText(String.valueOf(obj.getPrecio_objeto()));
            txtStock.setText(String.valueOf(obj.getStock_objeto()));
            txtRatio.setText(String.valueOf(pokeball.getRatio()));
            rutaImagenSeleccionada = obj.getImagen_objeto();
            btnSeleccionarImagen.setText(new File(rutaImagenSeleccionada).getName());
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron datos para el código de cura seleccionado.");
        }
    }

    private void guardarCambios(String dni) {
        String codigo = (String) comboBoxCodigo.getSelectedItem();
        String nombre = txtNombre.getText();
        int precio = Integer.parseInt(txtPrecio.getText());
        int stock = Integer.parseInt(txtStock.getText());
        int ratio = Integer.parseInt(txtRatio.getText());
        Pokeball pokeball = new Pokeball();
        pokeball.setCodigo_Objeto(codigo);
        pokeball.setNombre_objeto(nombre);
        pokeball.setPrecio_objeto(precio);

        pokeball.setStock_objeto(stock);
        pokeball.setRatio(ratio);
        pokeball.setImagen_objeto(rutaImagenSeleccionada);
        
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        // Actualizar datos en la tabla objeto
        db.actualizarPokeball(ratio, codigo);
        db.actualizarObjeto(nombre,precio,stock,rutaImagenSeleccionada,codigo);// Actualizar datos en la tabla pokeball
        db.closeConnection();
        
        limpiarCampos();
        JOptionPane.showMessageDialog(this, "Los cambios se guardaron correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        this.setVisible(false);
        VentanaMenuAdmin menuAdmin = new VentanaMenuAdmin(dni);
        menuAdmin.setVisible(true);
        dispose();
    }



    private void limpiarCampos() {
        txtNombre.setText("");
        txtStock.setText("");
        txtPrecio.setText("");
        txtRatio.setText("");
        btnSeleccionarImagen.setText("Seleccionar Imagen PNG");
        rutaImagenSeleccionada = null;
    }
}
