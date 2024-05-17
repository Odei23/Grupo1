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

import modelo.Comida;
import modelo.Cura;
import modelo.ImplementacionBaseDeDatos;
import modelo.Objeto;
import java.awt.Font;

public class VModificarComida extends JDialog {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboBoxCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtEfecto;
    private JButton btnSeleccionarImagen;
    private String dni;
    private String rutaImagenSeleccionada;
    private JButton btnNewButton;
    private JLabel lblNombre;
    private JLabel lblPrecio;
    private JLabel lblStock;
    private JLabel lblEfecto;

    /*
     * @Erik. Lo que se hace en esta ventana es que mediante el codigo que eligas te muestra la 
     * informacion de esa comida y te da la opcion de cambiar todos los datos menos el codigo
     */
    
    public VModificarComida(String dni) {
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

        txtEfecto = new JTextField();
        txtEfecto.setBounds(243, 249, 200, 25);
        contentPanel.add(txtEfecto);
        txtEfecto.setColumns(10);

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
        
        btnNewButton = new JButton("Salir");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		salir(dni);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setBounds(10, 10, 126, 40);
        contentPanel.add(btnNewButton);
        
        lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNombre.setBounds(151, 141, 82, 22);
        contentPanel.add(lblNombre);
        
        lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPrecio.setBounds(151, 177, 82, 22);
        contentPanel.add(lblPrecio);
        
        lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblStock.setBounds(151, 213, 82, 22);
        contentPanel.add(lblStock);
        
        lblEfecto = new JLabel("Efecto:");
        lblEfecto.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEfecto.setBounds(151, 249, 82, 22);
        contentPanel.add(lblEfecto);

        cargarCodigosComida();

        comboBoxCodigo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarDatosComida();
            }
        });
    }

    protected void salir(String dni) {
		this.setVisible(false);
		VentanaMenuAdmin venCliente = new VentanaMenuAdmin(dni);
		venCliente.setVisible(true);
		
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
                    rutaImagenSeleccionada = "..\\reto\\imagenes\\" + file.getName();
                    Files.copy(file.toPath(), Paths.get(rutaImagenSeleccionada), StandardCopyOption.REPLACE_EXISTING);
                    btnSeleccionarImagen.setText(file.getName());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private void cargarCodigosComida() {
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        List<String> codigos = db.obtenerCodigosComida(dni);
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

    private void cargarDatosComida() {
        String codigo = (String) comboBoxCodigo.getSelectedItem();
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        Objeto obj =  db.obtenerObjetoPorCodigo(codigo);
        Comida comida = db.obtenerComidaPorCodigo(codigo);
        db.closeConnection();

        if (comida != null) {
            txtNombre.setText(obj.getNombre_objeto());
            txtPrecio.setText(String.valueOf(obj.getPrecio_objeto()));
            txtStock.setText(String.valueOf(obj.getStock_objeto()));
            txtEfecto.setText(comida.getEfecto());
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
        String efecto = txtEfecto.getText();

        Comida comida = new Comida();
        comida.setCodigo_Objeto(codigo);
        comida.setNombre_objeto(nombre);
        comida.setStock_objeto(stock);
        comida.setPrecio_objeto(precio);
        comida.setEfecto(efecto);
        comida.setImagen_objeto(rutaImagenSeleccionada);
        
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        db.actualizarObjeto(nombre, precio, stock, rutaImagenSeleccionada, codigo);
        db.actualizarComida(efecto, codigo);
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
        txtEfecto.setText("");
        btnSeleccionarImagen.setText("Seleccionar Imagen PNG");
        rutaImagenSeleccionada = null;
    }
}
