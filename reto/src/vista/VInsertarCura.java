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
import modelo.Cura;

public class VInsertarCura extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JComboBox<Integer> comboBoxCodigo;
    private JTextField txtNombre;
    private String rutaImagenSeleccionada;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JButton btnSeleccionarImagen; // Cambio de JTextField a JButton

    private File file;
    private String carpetaFinal = "..\\reto\\imagenes\\";

    public VInsertarCura(String dni) {
        setBounds(100, 100, 820, 573);
        getContentPane().setLayout(null);
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
        txtPrecio.setBounds(243, 296, 200, 25);
        contentPanel.add(txtPrecio);
        txtPrecio.setColumns(10);

        txtStock = new JTextField();
        txtStock.setBounds(243, 336, 200, 25);
        contentPanel.add(txtStock);
        txtStock.setColumns(10);

        btnSeleccionarImagen = new JButton("Seleccionar Imagen PNG");
        btnSeleccionarImagen.setBounds(243, 372, 200, 25); // Cambio de coordenadas y tamaño
        contentPanel.add(btnSeleccionarImagen);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(297, 425, 100, 25);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCambios(dni);
            }
        });
        contentPanel.add(btnGuardar);

        cargarCodigosCuras();

        comboBoxCodigo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarDatosCuras((String) comboBoxCodigo.getSelectedItem());
            }
        });

        btnSeleccionarImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen();
            }
        });
    }

    private void cargarCodigosCuras() {
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection(); // Asegurar que la conexión esté abierta
        List<Integer> codigos = db.obtenerCodigosCuras();

        for (Integer codigo_objeto : codigos) {
            comboBoxCodigo.addItem(codigo_objeto);
        }
        db.closeConnection(); // Cerrar la conexión después de usarla
    }

    private void cargarDatosCuras(String codigo_objeto) {
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.openConnection(); // Open the database connection first
        Cura cura = db.obtenerCurasPorCodigo(codigo_objeto);

        txtNombre.setText(cura.getNombre_cura());
        txtPrecio.setText(String.valueOf(cura.getPrecio_cura()));
        txtStock.setText(String.valueOf(cura.getStock_cura()));

        // Deshabilitar la edición de los campos que no se pueden modificar
        txtNombre.setEditable(false);
      
    }

    

    private void seleccionarImagen() {
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
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private void guardarCambios(String dni) {
        // Verificar si 'rutaImagenSeleccionada' es nula
        if (rutaImagenSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen antes de guardar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener los valores de los campos editables
        String codigo_objeto = (String) comboBoxCodigo.getSelectedItem();
        String nombre = txtNombre.getText();

        int precio = Integer.parseInt(txtPrecio.getText());
        int stock = Integer.parseInt(txtStock.getText()); // Este campo debe contener el stock numérico, no el nombre del archivo

        Cura cura = new Cura();
        
        cura.setNombre_cura(nombre);
       cura.setCodigo_objeto(codigo_objeto);;
       cura.setImagen_cura(rutaImagenSeleccionada);
       cura.setStock_cura(stock);
       
        // Actualizar el Pokemon en la base de datos
        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.actualizarCura(cura);

        // Cerrar la ventana actual
        this.setVisible(false);

        // Abrir el menú administrativo
        VentanaMenuAdmin menuAdmin = new VentanaMenuAdmin(dni);
        menuAdmin.setVisible(true);

        // Cerrar el diálogo
        dispose();
    }

}
