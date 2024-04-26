package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VCambioContrasena extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textCambioDni;
	private JTextField textCambioCont;

	/**
	 * Create the dialog.
	 */
	public VCambioContrasena() {
		setBounds(100, 100, 736, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCambioDni = new JLabel("Introduce tu DNI");
		lblCambioDni.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCambioDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambioDni.setBounds(254, 113, 197, 29);
		contentPanel.add(lblCambioDni);
		
		textCambioDni = new JTextField();
		textCambioDni.setBounds(193, 146, 323, 29);
		contentPanel.add(textCambioDni);
		textCambioDni.setColumns(10);
		
		JLabel lblCambioCont = new JLabel("Introduce tu nueva contraseña");
		lblCambioCont.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambioCont.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCambioCont.setBounds(203, 186, 323, 29);
		contentPanel.add(lblCambioCont);
		
		textCambioCont = new JTextField();
		textCambioCont.setColumns(10);
		textCambioCont.setBounds(193, 217, 323, 29);
		contentPanel.add(textCambioCont);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irVentanaPrincipal();
			}

			
		});
		btnNewButton.setBounds(283, 257, 151, 29);
		contentPanel.add(btnNewButton);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(10, 11, 140, 48);
		contentPanel.add(btnSalir);
		
	}

	protected void salir() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		VentanaPrincipal venPrin = new VentanaPrincipal();
		venPrin.setVisible(true);
	}

	 protected void irVentanaPrincipal() {
	        String dni = textCambioDni.getText();
	        String nuevaContrasena = textCambioCont.getText();
	        
	        // Llamar al método que cambia la contraseña en la base de datos
	        boolean cambioExitoso = cambiarContrasenaEnBaseDeDatos(dni, nuevaContrasena);
	        
	        if (cambioExitoso) {
	            JOptionPane.showMessageDialog(this, "Contraseña cambiada exitosamente.");
	        } else {
	            JOptionPane.showMessageDialog(this, "Error al cambiar la contraseña. Por favor, verifica tu DNI.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        
	        this.setVisible(false);
	        VentanaPrincipal venPrin = new VentanaPrincipal();
	        venPrin.setVisible(true);
	    }

	    private boolean cambiarContrasenaEnBaseDeDatos(String dni, String nuevaContrasena) {
	       
	        return false; 
}
}