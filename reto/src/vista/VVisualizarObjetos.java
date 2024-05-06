package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.MediaTracker;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import modelo.Pokemon;

public class VVisualizarObjetos extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();

    public VVisualizarObjetos(List<Pokemon> pokemonObtenidos) {
        setBounds(100, 100, 800, 600);
        getContentPane().setLayout(new BorderLayout());
        
        contentPanel.setLayout(new GridLayout(0, 3));
        
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        for (Pokemon pokemon : pokemonObtenidos) {
            JPanel pokemonPanel = new JPanel(new BorderLayout());
            
            try {
                ImageIcon icon = new ImageIcon(pokemon.getRutaImagen());
                JLabel imageLabel = new JLabel(icon);
                pokemonPanel.add(imageLabel, BorderLayout.CENTER);
            } catch (Exception ex) {
                JLabel errorLabel = new JLabel("Error al cargar la imagen: " + ex.getMessage());
                pokemonPanel.add(errorLabel, BorderLayout.CENTER);
                ex.printStackTrace();
            }


            JLabel nameLabel = new JLabel(pokemon.getNombre());
            nameLabel.setHorizontalAlignment(JLabel.CENTER);
            pokemonPanel.add(nameLabel, BorderLayout.SOUTH);

            contentPanel.add(pokemonPanel);
        }
    }
}
