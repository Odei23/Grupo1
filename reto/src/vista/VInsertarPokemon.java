package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtImagen;

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

        txtImagen = new JTextField();
        txtImagen.setBounds(243, 372, 200, 25);
        contentPanel.add(txtImagen);
        txtImagen.setColumns(10);

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

        txtNombre.setText(pokemon.getNombre());
        txtTipo.setText(pokemon.getTipo());
        txtColor.setText(pokemon.getColor());
        txtNumEvo.setText(String.valueOf(pokemon.getNum_evo()));
        txtPrecio.setText(String.valueOf(pokemon.getPrecioPokemon()));
        txtStock.setText(String.valueOf(pokemon.getStock_pokemon()));
        txtImagen.setText(pokemon.getImagen_pokemon());
        }


       

    private void guardarCambios(String dni) {
        int codigo = (int) comboBoxCodigo.getSelectedItem();
        String nombre = txtNombre.getText();
        String tipo = txtTipo.getText();
        String color = txtColor.getText();
        int numEvo = Integer.parseInt(txtNumEvo.getText());
        int precio = Integer.parseInt(txtPrecio.getText());
        int stock = Integer.parseInt(txtStock.getText());
        String imagen = txtImagen.getText();

        Pokemon pokemon = new Pokemon();
        pokemon.setCodigo_pokemon(codigo);
        pokemon.setNombre(nombre);
        pokemon.setTipo(tipo);
        pokemon.setColor(color);
        pokemon.setNum_evo(numEvo);
        pokemon.setPrecioPokemon(precio);
        pokemon.setStock_pokemon(stock);
        pokemon.setImagen_pokemon(imagen);

        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
        db.actualizarPokemon(pokemon);

        this.setVisible(false);
        VentanaMenuAdmin menuAdmin = new VentanaMenuAdmin(dni); 
        menuAdmin.setVisible(true);

        // Close the current dialog
        dispose();
    }

}
