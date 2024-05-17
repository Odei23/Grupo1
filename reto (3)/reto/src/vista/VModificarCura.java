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

import modelo.Cura;
import modelo.ImplementacionBaseDeDatos;
import modelo.Objeto;
import java.awt.Font;

public class VModificarCura extends JDialog {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboBoxCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtCantidadCura;
    private JButton btnSeleccionarImagen;
    private String dni;
    private String rutaImagenSeleccionada;
    private JButton btnNewButton;
    private JLabel lblNombre;
    private JLabel lblPrecio;
    private JLabel lblStock;
    private JLabel lblCntCura;

    
    /*
     * @Erik. Lo que se hace en esta ventana es que mediante el codigo que eligas te muestra la informacion 
     * de esa cura y te da la opcion de cambiar todos los datos menos el codigo
     */
    
    public VModificarCura(String dni) {
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

        txtCantidadCura = new JTextField();
        txtCantidadCura.setBounds(243, 249, 200, 25);
        contentPanel.add(txtCantidadCura);
        txtCantidadCura.setColumns(10);

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
        btnNewButton.setBounds(10, 13, 126, 40);
        contentPanel.add(btnNewButton);
        
        lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNombre.setBounds(151, 144, 82, 22);
        contentPanel.add(lblNombre);
        
        lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPrecio.setBounds(151, 180, 82, 22);
        contentPanel.add(lblPrecio);
        
        lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblStock.setBounds(151, 216, 82, 22);
        contentPanel.add(lblStock);
        
        lblCntCura = new JLabel("Cantidad cura:");
        lblCntCura.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCntCura.setBounds(110, 249, 112, 25);
        contentPanel.add(lblCntCura);

        cargarCodigosCura();

        comboBoxCodigo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarDatosCura();
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

    private void cargarCodigosCura() {
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        List<String> codigos = db.obtenerCodigosCura(dni);
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

    private void cargarDatosCura() {
        String codigo = (String) comboBoxCodigo.getSelectedItem();
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        Objeto obj =  db.obtenerObjetoPorCodigo(codigo);
        Cura cura = db.obtenerCuraPorCodigo(codigo);
        db.closeConnection();

        if (cura != null) {
            txtNombre.setText(obj.getNombre_objeto());
            txtPrecio.setText(String.valueOf(obj.getPrecio_objeto()));
            txtStock.setText(String.valueOf(obj.getStock_objeto()));
            txtCantidadCura.setText(String.valueOf(cura.getCantidad_cura()));
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
        int cantidadCura = Integer.parseInt(txtCantidadCura.getText());

        Cura cura = new Cura();
        cura.setCodigo_Objeto(codigo);
        cura.setNombre_objeto(nombre);
        cura.setStock_objeto(stock);
        cura.setPrecio_objeto(precio);
        cura.setCantidad_cura(cantidadCura);
        cura.setImagen_objeto(rutaImagenSeleccionada);
        
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        db.actualizarObjeto(nombre, precio, stock, rutaImagenSeleccionada, codigo);
        db.actualizarCura(cantidadCura, codigo);
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
        txtCantidadCura.setText("");
        btnSeleccionarImagen.setText("Seleccionar Imagen PNG");
        rutaImagenSeleccionada = null;
    }
}
