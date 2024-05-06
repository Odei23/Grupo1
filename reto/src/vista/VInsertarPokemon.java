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
public class VInsertarPokemon extends JDialog {
   private final JPanel contentPanel = new JPanel();
   private JComboBox<Integer> comboBoxCodigo;
   private JTextField txtNombre;
   private JTextField txtTipo;
   private JTextField txtColor;
   private JTextField txtNumEvo;
   private String rutaImagenSeleccionada;
   private JTextField txtPrecio;
   private JTextField txtStock;
   private JButton btnSeleccionarImagen; // Cambio de JTextField a JButton
   private boolean imagenSeleccionada = false;
   private File file;
   private String carpetaFinal = "..\\reto\\imagenes\\";
   public VInsertarPokemon(String dni) {
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
       txtTipo = new JTextField();
       txtTipo.setBounds(243, 177, 200, 25);
       contentPanel.add(txtTipo);
       txtTipo.setColumns(10);
       txtColor = new JTextField();
       txtColor.setBounds(243, 224, 200, 25);
       contentPanel.add(txtColor);
       txtColor.setColumns(10);
       txtNumEvo = new JTextField();
       txtNumEvo.setBounds(243, 260, 200, 25);
       contentPanel.add(txtNumEvo);
       txtNumEvo.setColumns(10);
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
       db.openConnection(); // Asegurar que la conexión esté abierta
       List<Integer> codigos = db.obtenerCodigosPokemon();
       for (Integer codigo : codigos) {
           comboBoxCodigo.addItem(codigo);
       }
       db.closeConnection(); // Cerrar la conexión después de usarla
   }
   private void cargarDatosPokemon(int codigo) {
       ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
       db.openConnection(); // Open the database connection first
       Pokemon pokemon = db.obtenerPokemonPorCodigo(codigo);
       // Mostrar los datos en los campos
       txtNombre.setText(pokemon.getNombre());
       txtTipo.setText(pokemon.getTipo());
       txtColor.setText(pokemon.getColor());
       txtNumEvo.setText(String.valueOf(pokemon.getNum_evo()));
       txtPrecio.setText(String.valueOf(pokemon.getPrecioPokemon()));
       txtStock.setText(String.valueOf(pokemon.getStock_pokemon()));
       // Cargar la imagen correspondiente
       String nombreImagen = String.format("%03d", codigo) + ".png"; // Generar el nombre de la imagen según el código
       rutaImagenSeleccionada = carpetaFinal + nombreImagen; // Obtener la ruta de la imagen
       btnSeleccionarImagen.setText(nombreImagen); // Mostrar el nombre de la imagen en el botón
       imagenSeleccionada = true; // Establecer la bandera como verdadera
       // Deshabilitar la edición de los campos que no se pueden modificar
       txtNombre.setEditable(false);
       txtTipo.setEditable(false);
       txtColor.setEditable(false);
       txtNumEvo.setEditable(false);
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
                   imagenSeleccionada = true; // Establecer la bandera como verdadera
               } catch (IOException e1) {
                   e1.printStackTrace();
               }
           }
       }
   }
   private void guardarCambios(String dni) {
   	// Verificar si 'rutaImagenSeleccionada' es nula
       if (rutaImagenSeleccionada == null) {
           // Si no se selecciona una imagen, mantener la imagen actual en la base de datos
           // sin necesidad de mostrar un mensaje de error
           rutaImagenSeleccionada = obtenerRutaImagenActual(); // Obtener la ruta de la imagen actual
       }
       // Obtener los valores de los campos editables
       int codigo = (int) comboBoxCodigo.getSelectedItem();
       String nombre = txtNombre.getText();
       String tipo = txtTipo.getText();
       String color = txtColor.getText();
       int num_evo = Integer.parseInt(txtNumEvo.getText());
       int precio = Integer.parseInt(txtPrecio.getText());
       int stock = Integer.parseInt(txtStock.getText()); // Este campo debe contener el stock numérico, no el nombre del archivo
       Pokemon pokemon = new Pokemon();
       pokemon.setCodigo_pokemon(codigo);
       pokemon.setNombre(nombre);
       pokemon.setTipo(tipo);
       pokemon.setColor(color);
       pokemon.setNum_evo(num_evo);
       pokemon.setPrecioPokemon(precio);
       pokemon.setStock_pokemon(stock);
       pokemon.setImagen_pokemon(rutaImagenSeleccionada); // Usar la ruta del archivo seleccionado o la imagen actual
       // Actualizar el Pokemon en la base de datos
       ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
       db.actualizarPokemon(pokemon);
       // Limpiar los campos después de guardar los cambios
       limpiarCampos();
       // Opcional: mostrar un mensaje de éxito
       JOptionPane.showMessageDialog(this, "Los cambios se guardaron correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
   }
   // Método para limpiar los campos después de guardar los cambios
   private void limpiarCampos() {
       txtNombre.setText("");
       txtTipo.setText("");
       txtColor.setText("");
       txtNumEvo.setText("");
       txtPrecio.setText("");
       txtStock.setText("");
       rutaImagenSeleccionada = null;
       btnSeleccionarImagen.setText("Seleccionar Imagen PNG");
   }
  
   private String obtenerRutaImagenActual() {
       // Obtener el código del Pokemon seleccionado
       int codigo = (int) comboBoxCodigo.getSelectedItem();
       // Obtener la imagen actual del Pokemon con el código dado
       ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
       db.openConnection();
       Pokemon pokemon = db.obtenerPokemonPorCodigo(codigo);
       db.closeConnection();
       // Devolver la ruta de la imagen actual
       return pokemon.getImagen_pokemon();
   }
}
