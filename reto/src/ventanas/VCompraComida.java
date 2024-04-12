package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class VCompraComida extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton PokeCubos;
	private JButton PokochoAc;
	private JButton PokochoAmargo;
	private JButton PokochoDulce;
	private JButton PokochoSeco;
	private JButton PokochoPicante;
	private JButton BonguriAz;
	private JButton Pokelito;
	private JButton Curri;
	private JButton BonguriRoj;
	private JButton BonguriAmarilla;
	private JButton BonguriNegra;
	private JButton BonguriVerde;
	private JButton BonguriRosa;
	private JButton BayaMeloc;
	private JButton BayaZreza;
	private JButton BayaZidra;
	private JButton BayaAranja;
	private JButton BayaPinia;
	private JButton BayaFrambu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VCompraComida dialog = new VCompraComida();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VCompraComida() {
		setBounds(100, 100, 917, 811);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel contentPanel_1 = new JPanel();
		contentPanel_1.setLayout(null);
		contentPanel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel_1.setBounds(0, 0, 888, 775);
		contentPanel.add(contentPanel_1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 11, 140, 48);
		contentPanel_1.add(btnSalir);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(738, 11, 140, 48);
		contentPanel_1.add(btnCerrarSesion);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(342, 11, 155, 134);
		contentPanel_1.add(lblLogo);
		ImageIcon poke = new ImageIcon(getClass().getResource("LogoPokemon.png"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
        lblLogo.setIcon (img2);
        
		PokeCubos = new JButton("");
		PokeCubos.setBounds(138, 155, 95, 62);
		ImageIcon pokecubo = new ImageIcon(getClass().getResource("pokecubos.png"));
        ImageIcon imgPokecubo = new ImageIcon(pokecubo.getImage().getScaledInstance(PokeCubos.getWidth(), PokeCubos.getHeight(), Image.SCALE_SMOOTH));
        PokeCubos.setIcon (imgPokecubo);
		contentPanel_1.add(PokeCubos);
		
		PokochoAc = new JButton("");
		PokochoAc.setBounds(283, 156, 95, 62);
		ImageIcon pokacido = new ImageIcon(getClass().getResource("acido.png"));
        ImageIcon imgPokAcido = new ImageIcon(pokacido.getImage().getScaledInstance(PokochoAc.getWidth(), PokochoAc.getHeight(), Image.SCALE_SMOOTH));
        PokochoAc.setIcon (imgPokAcido);
		contentPanel_1.add(PokochoAc);
		
		PokochoAmargo = new JButton("");
		PokochoAmargo.setBounds(423, 156, 95, 62);
		ImageIcon pokamargo = new ImageIcon(getClass().getResource("amargo.png"));
        ImageIcon imgPokAmargo = new ImageIcon(pokamargo.getImage().getScaledInstance(PokochoAmargo.getWidth(), PokochoAmargo.getHeight(), Image.SCALE_SMOOTH));
        PokochoAmargo.setIcon (imgPokAmargo);
		contentPanel_1.add(PokochoAmargo);
		
		PokochoDulce = new JButton("");
		PokochoDulce.setBounds(138, 253, 95, 62);
		ImageIcon pokdulce = new ImageIcon(getClass().getResource("dulce.png"));
        ImageIcon imgPokDulce = new ImageIcon(pokdulce.getImage().getScaledInstance(PokochoDulce.getWidth(), PokochoDulce.getHeight(), Image.SCALE_SMOOTH));
        PokochoDulce.setIcon (imgPokDulce);
		contentPanel_1.add(PokochoDulce);
		
		PokochoSeco = new JButton("");
		PokochoSeco.setBounds(283, 253, 95, 62);
		ImageIcon pokseco = new ImageIcon(getClass().getResource("seco.png"));
        ImageIcon imgPokSeco = new ImageIcon(pokseco.getImage().getScaledInstance(PokochoSeco.getWidth(), PokochoSeco.getHeight(), Image.SCALE_SMOOTH));
        PokochoSeco.setIcon (imgPokSeco);
		contentPanel_1.add(PokochoSeco);
		
		PokochoPicante = new JButton("");
		PokochoPicante.setBounds(423, 253, 95, 62);
		ImageIcon pokpicante = new ImageIcon(getClass().getResource("picante.png"));
        ImageIcon imgPokPicante = new ImageIcon(pokpicante.getImage().getScaledInstance(PokochoPicante.getWidth(), PokochoPicante.getHeight(), Image.SCALE_SMOOTH));
        PokochoPicante.setIcon (imgPokPicante);
		contentPanel_1.add(PokochoPicante);
		
		BonguriAz = new JButton("");
		BonguriAz.setBounds(423, 347, 95, 62);
		ImageIcon bongurAzul = new ImageIcon(getClass().getResource("azul.png"));
        ImageIcon imgBongurAzul = new ImageIcon(bongurAzul.getImage().getScaledInstance(BonguriAz.getWidth(), BonguriAz.getHeight(), Image.SCALE_SMOOTH));
        BonguriAz.setIcon (imgBongurAzul);
		contentPanel_1.add(BonguriAz);
		
		Pokelito = new JButton("");
		Pokelito.setBounds(283, 347, 95, 62);
		ImageIcon pokelito = new ImageIcon(getClass().getResource("pokelito.png"));
        ImageIcon imgPokelito = new ImageIcon(pokelito.getImage().getScaledInstance(Pokelito.getWidth(), Pokelito.getHeight(), Image.SCALE_SMOOTH));
        Pokelito.setIcon (imgPokelito);
		contentPanel_1.add(Pokelito);
		
		Curri = new JButton("");
		Curri.setBounds(138, 347, 95, 62);
		ImageIcon curri = new ImageIcon(getClass().getResource("curri.png"));
        ImageIcon imgCurri = new ImageIcon(curri.getImage().getScaledInstance(Curri.getWidth(), Curri.getHeight(), Image.SCALE_SMOOTH));
        Curri.setIcon (imgCurri);
		contentPanel_1.add(Curri);
		
		BonguriRoj = new JButton("");
		BonguriRoj.setBounds(138, 439, 95, 62);
		ImageIcon bongurRoja = new ImageIcon(getClass().getResource("rojo.png"));
        ImageIcon imgBongurRoja = new ImageIcon(bongurRoja.getImage().getScaledInstance(BonguriRoj.getWidth(), BonguriRoj.getHeight(), Image.SCALE_SMOOTH));
        BonguriRoj.setIcon (imgBongurRoja);
		contentPanel_1.add(BonguriRoj);
		
		BonguriAmarilla = new JButton("");
		BonguriAmarilla.setBounds(283, 439, 95, 62);
		ImageIcon bongurAmarilla = new ImageIcon(getClass().getResource("rojo.png"));
        ImageIcon imgBongurAmarilla = new ImageIcon(bongurAmarilla.getImage().getScaledInstance(BonguriAmarilla.getWidth(), BonguriAmarilla.getHeight(), Image.SCALE_SMOOTH));
        BonguriAmarilla.setIcon (imgBongurAmarilla);
		contentPanel_1.add(BonguriAmarilla);
		
		BonguriNegra = new JButton("");
		BonguriNegra.setBounds(423, 439, 95, 62);
		ImageIcon bongurNegro = new ImageIcon(getClass().getResource("negro.png"));
        ImageIcon imgBongurNegra = new ImageIcon(bongurNegro.getImage().getScaledInstance(BonguriNegra.getWidth(), BonguriNegra.getHeight(), Image.SCALE_SMOOTH));
        BonguriNegra.setIcon (imgBongurNegra);
		contentPanel_1.add(BonguriNegra);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(679, 155, 17, 349);
		contentPanel_1.add(scrollBar);
		
		BonguriVerde = new JButton("");
		BonguriVerde.setBounds(138, 529, 95, 62);
		ImageIcon bongurVerde = new ImageIcon(getClass().getResource("verde.png"));
        ImageIcon imgBongurVerde = new ImageIcon(bongurVerde.getImage().getScaledInstance(BonguriVerde.getWidth(), BonguriVerde.getHeight(), Image.SCALE_SMOOTH));
        BonguriVerde.setIcon (imgBongurVerde);
		contentPanel_1.add(BonguriVerde);
		
		BonguriRosa = new JButton("");
		BonguriRosa.setBounds(283, 529, 95, 62);
		ImageIcon bongurRosa = new ImageIcon(getClass().getResource("rosa.png"));
        ImageIcon imgBongurRosa = new ImageIcon(bongurRosa.getImage().getScaledInstance(BonguriRosa.getWidth(), BonguriRosa.getHeight(), Image.SCALE_SMOOTH));
        BonguriRosa.setIcon (imgBongurRosa);
		contentPanel_1.add(BonguriRosa);
		
		BayaMeloc = new JButton("");
		BayaMeloc.setBounds(423, 529, 95, 62);
		ImageIcon bayaMeloc = new ImageIcon(getClass().getResource("meloc.png"));
        ImageIcon imgBayaMeloc = new ImageIcon(bayaMeloc.getImage().getScaledInstance(BayaMeloc.getWidth(), BayaMeloc.getHeight(), Image.SCALE_SMOOTH));
        BayaMeloc.setIcon (imgBayaMeloc);
		contentPanel_1.add(BayaMeloc);
		
		BayaZreza = new JButton("");
		BayaZreza.setBounds(138, 614, 95, 62);
		ImageIcon bayaZreza = new ImageIcon(getClass().getResource("Zreza.png"));
	    ImageIcon imgBayaZreza = new ImageIcon(bayaZreza.getImage().getScaledInstance(BayaZreza.getWidth(), BayaZreza.getHeight(), Image.SCALE_SMOOTH));
	    BayaZreza.setIcon (imgBayaZreza);
		contentPanel_1.add(BayaZreza);
		
		BayaZidra = new JButton("");
		BayaZidra.setBounds(283, 614, 95, 62);
		ImageIcon bayaZidra = new ImageIcon(getClass().getResource("Zidra.png"));
	    ImageIcon imgBayaZidra = new ImageIcon(bayaZidra.getImage().getScaledInstance(BayaZidra.getWidth(), BayaZidra.getHeight(), Image.SCALE_SMOOTH));
	    BayaZidra.setIcon (imgBayaZidra);
		contentPanel_1.add(BayaZidra);
		
		BayaAranja = new JButton("");
		BayaAranja.setBounds(423, 614, 95, 62);
		ImageIcon bayaAranja = new ImageIcon(getClass().getResource("aranja.png"));
	    ImageIcon imgBayaAranja = new ImageIcon(bayaAranja.getImage().getScaledInstance(BayaAranja.getWidth(), BayaAranja.getHeight(), Image.SCALE_SMOOTH));
	    BayaAranja.setIcon (imgBayaAranja);
		contentPanel_1.add(BayaAranja);
		
		BayaPinia = new JButton("");
		BayaPinia.setBounds(283, 702, 95, 62);
		ImageIcon bayaPinia = new ImageIcon(getClass().getResource("pinia.png"));
	    ImageIcon imgBayaPinia = new ImageIcon(bayaPinia.getImage().getScaledInstance(BayaPinia.getWidth(), BayaPinia.getHeight(), Image.SCALE_SMOOTH));
	    BayaPinia.setIcon (imgBayaPinia);
		contentPanel_1.add(BayaPinia);
		
		BayaFrambu = new JButton("");
		BayaFrambu.setBounds(138, 702, 95, 62);
		ImageIcon bayaFrambu = new ImageIcon(getClass().getResource("Frambu.png"));
	    ImageIcon imgBayaFrambu = new ImageIcon(bayaFrambu.getImage().getScaledInstance(BayaFrambu.getWidth(), BayaFrambu.getHeight(), Image.SCALE_SMOOTH));
	    BayaFrambu.setIcon (imgBayaFrambu);
		contentPanel_1.add(BayaFrambu);
	}
}
