package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

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
	private JLabel lblPokecubo;
	private JLabel lblPokochoAm;
	private JLabel lblPokochoVer;
	private JLabel lblPokochoRosa;
	private JLabel lblPokochoAz;
	private JLabel lblPokochoRojo;
	private JLabel lblPokelito;
	private JLabel lblCurri;
	private JLabel lblBonguriRoj;
	private JLabel lblBonguriAzul;
	private JLabel lblBonguriAmar;
	private JLabel lblBonguriNegro;
	private JLabel lblBonguriVerde;
	private JLabel lblBonguriRosa;
	private JLabel lblBayaMeloc;
	private JLabel lblBayaPinia;
	private JLabel lblFrambu;
	private JLabel lblBayaAranja;
	private JLabel lblBayaZidra;
	private JLabel lblBayaZreza;
	private Usuario usu;

	public VCompraComida() {
		setBounds(100, 100, 917, 650);
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
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(738, 11, 140, 48);
		contentPanel_1.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarSesion();
			}
		});
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(342, 11, 155, 134);
		contentPanel_1.add(lblLogo);
		ImageIcon poke = new ImageIcon(getClass().getResource("logo.png"));
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
		PokochoDulce.setBounds(566, 155, 95, 62);
		ImageIcon pokdulce = new ImageIcon(getClass().getResource("dulce.png"));
        ImageIcon imgPokDulce = new ImageIcon(pokdulce.getImage().getScaledInstance(PokochoDulce.getWidth(), PokochoDulce.getHeight(), Image.SCALE_SMOOTH));
        PokochoDulce.setIcon (imgPokDulce);
		contentPanel_1.add(PokochoDulce);
		
		PokochoSeco = new JButton("");
		PokochoSeco.setBounds(700, 155, 95, 62);
		ImageIcon pokseco = new ImageIcon(getClass().getResource("seco.png"));
        ImageIcon imgPokSeco = new ImageIcon(pokseco.getImage().getScaledInstance(PokochoSeco.getWidth(), PokochoSeco.getHeight(), Image.SCALE_SMOOTH));
        PokochoSeco.setIcon (imgPokSeco);
		contentPanel_1.add(PokochoSeco);
		
		PokochoPicante = new JButton("");
		PokochoPicante.setBounds(138, 257, 95, 62);
		ImageIcon pokpicante = new ImageIcon(getClass().getResource("picante.png"));
        ImageIcon imgPokPicante = new ImageIcon(pokpicante.getImage().getScaledInstance(PokochoPicante.getWidth(), PokochoPicante.getHeight(), Image.SCALE_SMOOTH));
        PokochoPicante.setIcon (imgPokPicante);
		contentPanel_1.add(PokochoPicante);
		
		BonguriAz = new JButton("");
		BonguriAz.setBounds(700, 257, 95, 62);
		ImageIcon bongurAzul = new ImageIcon(getClass().getResource("azul.png"));
        ImageIcon imgBongurAzul = new ImageIcon(bongurAzul.getImage().getScaledInstance(BonguriAz.getWidth(), BonguriAz.getHeight(), Image.SCALE_SMOOTH));
        BonguriAz.setIcon (imgBongurAzul);
		contentPanel_1.add(BonguriAz);
		
		Pokelito = new JButton("");
		Pokelito.setBounds(283, 257, 95, 62);
		ImageIcon pokelito = new ImageIcon(getClass().getResource("pokelito.png"));
        ImageIcon imgPokelito = new ImageIcon(pokelito.getImage().getScaledInstance(Pokelito.getWidth(), Pokelito.getHeight(), Image.SCALE_SMOOTH));
        Pokelito.setIcon (imgPokelito);
		contentPanel_1.add(Pokelito);
		
		Curri = new JButton("");
		Curri.setBounds(423, 257, 95, 62);
		ImageIcon curri = new ImageIcon(getClass().getResource("curri.png"));
        ImageIcon imgCurri = new ImageIcon(curri.getImage().getScaledInstance(Curri.getWidth(), Curri.getHeight(), Image.SCALE_SMOOTH));
        Curri.setIcon (imgCurri);
		contentPanel_1.add(Curri);
		
		BonguriRoj = new JButton("");
		BonguriRoj.setBounds(566, 257, 95, 62);
		ImageIcon bongurRoja = new ImageIcon(getClass().getResource("rojo.png"));
        ImageIcon imgBongurRoja = new ImageIcon(bongurRoja.getImage().getScaledInstance(BonguriRoj.getWidth(), BonguriRoj.getHeight(), Image.SCALE_SMOOTH));
        BonguriRoj.setIcon (imgBongurRoja);
		contentPanel_1.add(BonguriRoj);
		
		BonguriAmarilla = new JButton("");
		BonguriAmarilla.setBounds(138, 377, 95, 62);
		ImageIcon bongurAmarilla = new ImageIcon(getClass().getResource("amarillo.png"));
        ImageIcon imgBongurAmarilla = new ImageIcon(bongurAmarilla.getImage().getScaledInstance(BonguriAmarilla.getWidth(), BonguriAmarilla.getHeight(), Image.SCALE_SMOOTH));
        BonguriAmarilla.setIcon (imgBongurAmarilla);
		contentPanel_1.add(BonguriAmarilla);
		
		BonguriNegra = new JButton("");
		BonguriNegra.setBounds(283, 377, 95, 62);
		ImageIcon bongurNegro = new ImageIcon(getClass().getResource("negro.png"));
        ImageIcon imgBongurNegra = new ImageIcon(bongurNegro.getImage().getScaledInstance(BonguriNegra.getWidth(), BonguriNegra.getHeight(), Image.SCALE_SMOOTH));
        BonguriNegra.setIcon (imgBongurNegra);
		contentPanel_1.add(BonguriNegra);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(847, 221, 17, 349);
		contentPanel_1.add(scrollBar);
		
		BonguriVerde = new JButton("");
		BonguriVerde.setBounds(423, 377, 95, 62);
		ImageIcon bongurVerde = new ImageIcon(getClass().getResource("verde.png"));
        ImageIcon imgBongurVerde = new ImageIcon(bongurVerde.getImage().getScaledInstance(BonguriVerde.getWidth(), BonguriVerde.getHeight(), Image.SCALE_SMOOTH));
        BonguriVerde.setIcon (imgBongurVerde);
		contentPanel_1.add(BonguriVerde);
		
		BonguriRosa = new JButton("");
		BonguriRosa.setBounds(566, 377, 95, 62);
		ImageIcon bongurRosa = new ImageIcon(getClass().getResource("rosa.png"));
        ImageIcon imgBongurRosa = new ImageIcon(bongurRosa.getImage().getScaledInstance(BonguriRosa.getWidth(), BonguriRosa.getHeight(), Image.SCALE_SMOOTH));
        BonguriRosa.setIcon (imgBongurRosa);
		contentPanel_1.add(BonguriRosa);
		
		BayaMeloc = new JButton("");
		BayaMeloc.setBounds(700, 377, 95, 62);
		ImageIcon bayaMeloc = new ImageIcon(getClass().getResource("meloc.png"));
        ImageIcon imgBayaMeloc = new ImageIcon(bayaMeloc.getImage().getScaledInstance(BayaMeloc.getWidth(), BayaMeloc.getHeight(), Image.SCALE_SMOOTH));
        BayaMeloc.setIcon (imgBayaMeloc);
		contentPanel_1.add(BayaMeloc);
		
		BayaZreza = new JButton("");
		BayaZreza.setBounds(138, 490, 95, 62);
		ImageIcon bayaZreza = new ImageIcon(getClass().getResource("Zreza.png"));
	    ImageIcon imgBayaZreza = new ImageIcon(bayaZreza.getImage().getScaledInstance(BayaZreza.getWidth(), BayaZreza.getHeight(), Image.SCALE_SMOOTH));
	    BayaZreza.setIcon (imgBayaZreza);
		contentPanel_1.add(BayaZreza);
		
		BayaZidra = new JButton("");
		BayaZidra.setBounds(283, 490, 95, 62);
		ImageIcon bayaZidra = new ImageIcon(getClass().getResource("Zidra.png"));
	    ImageIcon imgBayaZidra = new ImageIcon(bayaZidra.getImage().getScaledInstance(BayaZidra.getWidth(), BayaZidra.getHeight(), Image.SCALE_SMOOTH));
	    BayaZidra.setIcon (imgBayaZidra);
		contentPanel_1.add(BayaZidra);
		
		BayaAranja = new JButton("");
		BayaAranja.setBounds(423, 490, 95, 62);
		ImageIcon bayaAranja = new ImageIcon(getClass().getResource("aranja.png"));
	    ImageIcon imgBayaAranja = new ImageIcon(bayaAranja.getImage().getScaledInstance(BayaAranja.getWidth(), BayaAranja.getHeight(), Image.SCALE_SMOOTH));
	    BayaAranja.setIcon (imgBayaAranja);
		contentPanel_1.add(BayaAranja);
		
		BayaPinia = new JButton("");
		BayaPinia.setBounds(700, 490, 95, 62);
		ImageIcon bayaPinia = new ImageIcon(getClass().getResource("pinia.png"));
	    ImageIcon imgBayaPinia = new ImageIcon(bayaPinia.getImage().getScaledInstance(BayaPinia.getWidth(), BayaPinia.getHeight(), Image.SCALE_SMOOTH));
	    BayaPinia.setIcon (imgBayaPinia);
		contentPanel_1.add(BayaPinia);
		
		BayaFrambu = new JButton("");
		BayaFrambu.setBounds(566, 490, 95, 62);
		ImageIcon bayaFrambu = new ImageIcon(getClass().getResource("Frambu.png"));
	    ImageIcon imgBayaFrambu = new ImageIcon(bayaFrambu.getImage().getScaledInstance(BayaFrambu.getWidth(), BayaFrambu.getHeight(), Image.SCALE_SMOOTH));
	    BayaFrambu.setIcon (imgBayaFrambu);
		contentPanel_1.add(BayaFrambu);
		
		lblPokecubo = new JLabel("15€");
		lblPokecubo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokecubo.setBounds(138, 221, 95, 23);
		contentPanel_1.add(lblPokecubo);
		
		lblPokochoAm = new JLabel("5€");
		lblPokochoAm.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokochoAm.setBounds(283, 221, 95, 23);
		contentPanel_1.add(lblPokochoAm);
		
		lblPokochoVer = new JLabel("5€");
		lblPokochoVer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokochoVer.setBounds(423, 221, 95, 23);
		contentPanel_1.add(lblPokochoVer);
		
		lblPokochoRosa = new JLabel("5€");
		lblPokochoRosa.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokochoRosa.setBounds(566, 221, 95, 23);
		contentPanel_1.add(lblPokochoRosa);
		
		lblPokochoAz = new JLabel("5€");
		lblPokochoAz.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokochoAz.setBounds(700, 221, 95, 23);
		contentPanel_1.add(lblPokochoAz);
		
		lblPokochoRojo = new JLabel("5€");
		lblPokochoRojo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokochoRojo.setBounds(138, 327, 95, 23);
		contentPanel_1.add(lblPokochoRojo);
		
		lblPokelito = new JLabel("10€");
		lblPokelito.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokelito.setBounds(283, 327, 95, 23);
		contentPanel_1.add(lblPokelito);
		
		lblCurri = new JLabel("20€");
		lblCurri.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurri.setBounds(423, 327, 95, 23);
		contentPanel_1.add(lblCurri);
		
		lblBonguriRoj = new JLabel("5€");
		lblBonguriRoj.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonguriRoj.setBounds(566, 327, 95, 23);
		contentPanel_1.add(lblBonguriRoj);
		
		lblBonguriAzul = new JLabel("5€");
		lblBonguriAzul.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonguriAzul.setBounds(700, 327, 95, 23);
		contentPanel_1.add(lblBonguriAzul);
		
		lblBonguriAmar = new JLabel("5€");
		lblBonguriAmar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonguriAmar.setBounds(138, 444, 95, 23);
		contentPanel_1.add(lblBonguriAmar);
		
		lblBonguriNegro = new JLabel("5€");
		lblBonguriNegro.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonguriNegro.setBounds(283, 444, 95, 23);
		contentPanel_1.add(lblBonguriNegro);
		
		lblBonguriVerde = new JLabel("5€");
		lblBonguriVerde.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonguriVerde.setBounds(423, 444, 95, 23);
		contentPanel_1.add(lblBonguriVerde);
		
		lblBonguriRosa = new JLabel("5€");
		lblBonguriRosa.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonguriRosa.setBounds(566, 444, 95, 23);
		contentPanel_1.add(lblBonguriRosa);
		
		lblBayaMeloc = new JLabel("5€");
		lblBayaMeloc.setHorizontalAlignment(SwingConstants.CENTER);
		lblBayaMeloc.setBounds(700, 444, 95, 23);
		contentPanel_1.add(lblBayaMeloc);
		
		lblBayaPinia = new JLabel("5€");
		lblBayaPinia.setHorizontalAlignment(SwingConstants.CENTER);
		lblBayaPinia.setBounds(700, 552, 95, 23);
		contentPanel_1.add(lblBayaPinia);
		
		lblFrambu = new JLabel("5€");
		lblFrambu.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrambu.setBounds(566, 552, 95, 23);
		contentPanel_1.add(lblFrambu);
		
		lblBayaAranja = new JLabel("5€");
		lblBayaAranja.setHorizontalAlignment(SwingConstants.CENTER);
		lblBayaAranja.setBounds(423, 552, 95, 23);
		contentPanel_1.add(lblBayaAranja);
		
		lblBayaZidra = new JLabel("5€");
		lblBayaZidra.setHorizontalAlignment(SwingConstants.CENTER);
		lblBayaZidra.setBounds(283, 552, 95, 23);
		contentPanel_1.add(lblBayaZidra);
		
		lblBayaZreza = new JLabel("5€");
		lblBayaZreza.setHorizontalAlignment(SwingConstants.CENTER);
		lblBayaZreza.setBounds(138, 552, 95, 23);
		contentPanel_1.add(lblBayaZreza);
	}

	protected void cerrarSesion() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		VentanaPrincipal venPrin = new VentanaPrincipal();
		venPrin.setVisible(true);
	}

	protected void salir() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		VCompraObjetos venObjeto = new VCompraObjetos(usu);
		venObjeto.setVisible(true);
	}
}
