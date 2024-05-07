package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.Cura;
import modelo.ImplementacionBaseDeDatos;

public class VInsertarCura extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBoxCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtImagen;
    private String dni;
    private JButton btnSeleccionarImagen;
    private boolean imagenSeleccionada = false;
    private File file;
    private String carpetaFinal = "..\\reto\\imagenes\\";
    private String rutaImagenSeleccionada;

    public VInsertarCura(String dni) {
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

        btnSeleccionarImagen = new JButton("Seleccionar Imagen PNG");
        btnSeleccionarImagen.setBounds(243, 249, 200, 25); // Cambio de coordenadas y tamaño
        btnSeleccionarImagen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		seleccionarImagen();
        	}
        });
        
        contentPanel.add(btnSeleccionarImagen);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(297, 285, 100, 25);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCambios(dni);
            }
        });
        contentPanel.add(btnGuardar);

        cargarCodigosCura();

        comboBoxCodigo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarDatosCura();
            }
        });
        
        
    }

    protected void seleccionarImagen() {
    	JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de imagen PNG", "png");
        fc.setFileFilter(filtro);
        int res = fc.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile(); // Inicializar correctamente 'file'
            if (file != null) {
                try {
                    // Guardar la ruta del archivo seleccionado
                    rutaImagenSeleccionada = file.getAbsolutePath();
                    Files.copy(Paths.get(rutaImagenSeleccionada), Paths.get(new File(carpetaFinal, file.getName()).getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
                    btnSeleccionarImagen.setText(file.getName()); // Mostrar el nombre del archivo en el botón
                    imagenSeleccionada = true; // Establecer la bandera como verdadera
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
            // Ordenar los códigos alfanuméricamente
            Collections.sort(codigos, new AlphanumericComparator());

            comboBoxCodigo.removeAllItems(); // Limpiar el comboBox antes de agregar los nuevos elementos
            for (String codigo : codigos) {
                comboBoxCodigo.addItem(codigo);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron codigos de cura.");
        }
    }

    private static class AlphanumericComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }


    private void cargarDatosCura() {
        String codigo = (String) comboBoxCodigo.getSelectedItem();
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        Cura cura = db.obtenerCuraPorCodigo(codigo); // Llamada al método correcto para obtener el objeto Cura
        if (cura != null) {
            txtNombre.setText(cura.getNombre_cura());
            txtPrecio.setText(String.valueOf(cura.getPrecio_cura()));
            txtStock.setText(String.valueOf(cura.getStock_cura()));
            String nombreImagen = codigo + ".png"; // Generar el nombre de la imagen según el código
            rutaImagenSeleccionada = carpetaFinal + nombreImagen; // Obtener la ruta de la imagen
            btnSeleccionarImagen.setText(nombreImagen); // Mostrar el nombre de la imagen en el botón
            imagenSeleccionada = true; // Establecer la bandera como verdadera
            txtNombre.setEditable(false);
            txtStock.setEditable(false);
            txtPrecio.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron datos para el código de cura seleccionado.");
        }
        db.closeConnection();
    }

    private void guardarCambios(String dni) {
        String codigo = (String) comboBoxCodigo.getSelectedItem();
        String nombre = txtNombre.getText();
        int precio = Integer.parseInt(txtPrecio.getText());
        int stock = Integer.parseInt(txtStock.getText());


        Cura cura = new Cura();
        cura.setCodigo_objeto(codigo);
        cura.setNombre_cura(nombre);
        cura.setStock_cura(stock);
        cura.setPrecio_cura(precio);
        cura.setImagen_cura(rutaImagenSeleccionada); // Usar la ruta del archivo seleccionado o la imagen actual
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection();
        db.actualizarCura(cura);
        db.closeConnection();
        limpiarCampos();
        JOptionPane.showMessageDialog(this, "Los cambios se guardaron correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        this.setVisible(false);
        VentanaMenuAdmin menuAdmin = new VentanaMenuAdmin(dni);
        menuAdmin.setVisible(true);
        dispose();
    }

	private void limpiarCampos() {
		// TODO Auto-generated method stub
		       txtNombre.setText("");
		       txtStock.setText("");
		       txtPrecio.setText("");
		       rutaImagenSeleccionada = null;
		       btnSeleccionarImagen.setText("Seleccionar Imagen PNG");
	}
    
}