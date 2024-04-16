package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class VCompraCura extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblLogo;
	private JButton Pocion;
	private JButton SuperPocion;
	private JButton HiperPocion;
	private JButton MaximaPocion;
	private JButton RestaurarTodo;
	private JButton CuraTotal;
	private JButton Antiquemar;
	private JButton Antiparaliz;
	private JButton Antidoto;
	private JButton Antihielo;
	private JButton Despertar;
	private JButton AguaFresca;
	private JButton Refresco;
	private JButton Limonada;
	private JButton Revivir;
	private JButton MaxRevivir;
	private JButton Restos;
	private JButton PolvoCura;
	private JButton HierbaRev;
	private JButton Leche;
	private JLabel lblSuper;
	private JLabel lblHiper;
	private JLabel lblMax;
	private JLabel lblRestaurar;
	private JLabel lblCuraTotal;
	private JLabel lblAntidoto;
	private JLabel lblAntiparaliz;
	private JLabel lblAntiquemar;
	private JLabel lblAntiHielo;
	private JLabel lblDespertar;
	private JLabel lblAguaFresca;
	private JLabel lblRefresco;
	private JLabel lblLimonada;
	private JLabel lblRevivir;
	private JLabel lblMaxRevivir;
	private JLabel lblRestos;
	private JLabel lblPolvoCura;
	private JLabel lblLecheMu;
	private JLabel lblHierba;
	private JCheckBox checkSuper;
	private JCheckBox checkHiper;
	private JCheckBox checkMax;
	private JCheckBox checkRestTodo;
	private JCheckBox checkCuraTotal;
	private JCheckBox checkAntidoto;
	private JCheckBox checkAntiparaliz;
	private JCheckBox checkAntiquemar;
	private JCheckBox checkAntiHielo;
	private JCheckBox checkDespertar;
	private JCheckBox checkAguaFresca;
	private JCheckBox checkRefresco;
	private JCheckBox checkLimonada;
	private JCheckBox checkRevivir;
	private JCheckBox checkMaxRevivir;
	private JCheckBox checkRestos;
	private JCheckBox checkPolvoCura;
	private JCheckBox checkLeche;
	private JCheckBox checkHierba;
	private JSpinner spinnerSuper;
	private JSpinner spinnerHiper;
	private JSpinner spinnerMax;
	private JSpinner spinnerRestaurarTodo;
	private JSpinner spinnerAntihielo;
	private JSpinner spinnerAntiquemar;
	private JSpinner spinnerAntiparaliz;
	private JSpinner spinnerAntidoto;
	private JSpinner spinnerCuraTotal;
	private JSpinner spinnerDespertar;
	private JSpinner spinnerAguaFresca;
	private JSpinner spinnerRefresco;
	private JSpinner spinnerLimonada;
	private JSpinner spinnerRevivir;
	private JSpinner spinnerHierba;
	private JSpinner spinnerLeche;
	private JSpinner spinnerPolvo;
	private JSpinner spinnerRestos;
	private JSpinner spinnerMaxRev;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VCompraCura dialog = new VCompraCura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VCompraCura() {
		setBounds(100, 100, 985, 607);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnSalir = new JButton("Salir");
			btnSalir.setBounds(10, 11, 140, 48);
			contentPanel.add(btnSalir);
		}
		{
			JButton btnCerrarSesion = new JButton("Cerrar Sesion");
			btnCerrarSesion.setBounds(738, 11, 140, 48);
			contentPanel.add(btnCerrarSesion);
		}
		{
			lblLogo = new JLabel("");
			lblLogo.setBounds(342, 11, 155, 134);
			ImageIcon poke = new ImageIcon(getClass().getResource("LogoPokemon.png"));
	        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
	        lblLogo.setIcon (img2);
	        contentPanel.add(lblLogo);
		}
		
		Pocion = new JButton("");
		Pocion.setBounds(138, 155, 95, 62);
		ImageIcon poke = new ImageIcon(getClass().getResource("pocion.png"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(Pocion.getWidth(), Pocion.getHeight(), Image.SCALE_SMOOTH));
        Pocion.setIcon (img2);
        contentPanel.add(Pocion, BorderLayout.NORTH);
		contentPanel.add(Pocion);
		
		
		
	    SuperPocion = new JButton("");
		SuperPocion.setBounds(283, 156, 95, 62);
		ImageIcon superPoc = new ImageIcon(getClass().getResource("super.png"));
        ImageIcon imgSuper = new ImageIcon(superPoc.getImage().getScaledInstance(SuperPocion.getWidth(), SuperPocion.getHeight(), Image.SCALE_SMOOTH));
        SuperPocion.setIcon (imgSuper);
		contentPanel.add(SuperPocion);
		
		HiperPocion = new JButton("");
		HiperPocion.setBounds(423, 156, 95, 62);
		ImageIcon hiperPoc = new ImageIcon(getClass().getResource("hiper.png"));
        ImageIcon imgHiper = new ImageIcon(hiperPoc.getImage().getScaledInstance(HiperPocion.getWidth(), HiperPocion.getHeight(), Image.SCALE_SMOOTH));
        HiperPocion.setIcon (imgHiper);
		contentPanel.add(HiperPocion);
		
		MaximaPocion = new JButton("");
		MaximaPocion.setBounds(557, 155, 95, 62);
		ImageIcon maxPoc = new ImageIcon(getClass().getResource("max.png"));
        ImageIcon imgMax = new ImageIcon(maxPoc.getImage().getScaledInstance(MaximaPocion.getWidth(), MaximaPocion.getHeight(), Image.SCALE_SMOOTH));
        MaximaPocion.setIcon (imgMax);
		contentPanel.add(MaximaPocion);
		
		RestaurarTodo = new JButton("");
		RestaurarTodo.setBounds(699, 155, 95, 62);
		ImageIcon restTodo = new ImageIcon(getClass().getResource("restaurar.png"));
        ImageIcon imgRest = new ImageIcon(restTodo.getImage().getScaledInstance(RestaurarTodo.getWidth(), RestaurarTodo.getHeight(), Image.SCALE_SMOOTH));
        RestaurarTodo.setIcon (imgRest);
		contentPanel.add(RestaurarTodo);
		
		CuraTotal = new JButton("");
		CuraTotal.setBounds(138, 253, 95, 62);
		ImageIcon curaTotal = new ImageIcon(getClass().getResource("curatotal.png"));
        ImageIcon imgCuraTot = new ImageIcon(curaTotal.getImage().getScaledInstance(CuraTotal.getWidth(), CuraTotal.getHeight(), Image.SCALE_SMOOTH));
        CuraTotal.setIcon (imgCuraTot);
		contentPanel.add(CuraTotal);
		
		Antiquemar = new JButton("");
		Antiquemar.setBounds(557, 253, 95, 62);
		ImageIcon antiQuemar = new ImageIcon(getClass().getResource("antiquemar.png"));
        ImageIcon imgAntiQuemar = new ImageIcon(antiQuemar.getImage().getScaledInstance(Antiquemar.getWidth(), Antiquemar.getHeight(), Image.SCALE_SMOOTH));
        Antiquemar.setIcon (imgAntiQuemar);
		contentPanel.add(Antiquemar);
		
		Antiparaliz = new JButton("");
		Antiparaliz.setBounds(423, 253, 95, 62);
		ImageIcon antiParaliz = new ImageIcon(getClass().getResource("antiparaliz.png"));
        ImageIcon imgAntiParaliz = new ImageIcon(antiParaliz.getImage().getScaledInstance(Antiparaliz.getWidth(), Antiparaliz.getHeight(), Image.SCALE_SMOOTH));
        Antiparaliz.setIcon (imgAntiParaliz);
		contentPanel.add(Antiparaliz);
		
		Antidoto = new JButton("");
		Antidoto.setBounds(283, 253, 95, 62);
		ImageIcon antidoto = new ImageIcon(getClass().getResource("antidoto.png"));
        ImageIcon imgAntidoto = new ImageIcon(antidoto.getImage().getScaledInstance(Antidoto.getWidth(), Antidoto.getHeight(), Image.SCALE_SMOOTH));
        Antidoto.setIcon (imgAntidoto);
		contentPanel.add(Antidoto);
		
		Antihielo = new JButton("");
		Antihielo.setBounds(699, 253, 95, 62);
		ImageIcon antiHielo = new ImageIcon(getClass().getResource("antihielo.png"));
        ImageIcon imgAntiHielo = new ImageIcon(antiHielo.getImage().getScaledInstance(Antihielo.getWidth(), Antihielo.getHeight(), Image.SCALE_SMOOTH));
        Antihielo.setIcon (imgAntiHielo);
		contentPanel.add(Antihielo);
		
		Despertar = new JButton("");
		Despertar.setBounds(138, 347, 95, 62);
		ImageIcon despertar = new ImageIcon(getClass().getResource("despertar.png"));
        ImageIcon imgDespertar = new ImageIcon(despertar.getImage().getScaledInstance(Despertar.getWidth(), Despertar.getHeight(), Image.SCALE_SMOOTH));
        Despertar.setIcon (imgDespertar);
		contentPanel.add(Despertar);
		
		AguaFresca = new JButton("");
		AguaFresca.setBounds(283, 347, 95, 62);
		ImageIcon aguaFresca = new ImageIcon(getClass().getResource("aguafresca.png"));
        ImageIcon imgAguaFresca = new ImageIcon(aguaFresca.getImage().getScaledInstance(AguaFresca.getWidth(), AguaFresca.getHeight(), Image.SCALE_SMOOTH));
        AguaFresca.setIcon (imgAguaFresca);
		contentPanel.add(AguaFresca);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(877, 166, 17, 367);
		contentPanel.add(scrollBar);

		
		Refresco = new JButton("");
		Refresco.setBounds(423, 347, 95, 62);
		ImageIcon refresco = new ImageIcon(getClass().getResource("refresco.png"));
        ImageIcon imgRefresco = new ImageIcon(refresco.getImage().getScaledInstance(Refresco.getWidth(), Refresco.getHeight(), Image.SCALE_SMOOTH));
        Refresco.setIcon (imgRefresco);
		contentPanel.add(Refresco);
		
		Limonada = new JButton("");
		Limonada.setBounds(557, 347, 95, 62);
		ImageIcon limonada = new ImageIcon(getClass().getResource("limonada.png"));
        ImageIcon imgLimonada = new ImageIcon(limonada.getImage().getScaledInstance(Limonada.getWidth(), Limonada.getHeight(), Image.SCALE_SMOOTH));
        Limonada.setIcon (imgLimonada);
		contentPanel.add(Limonada);
		
		Revivir = new JButton("");
		Revivir.setBounds(699, 347, 95, 62);
		ImageIcon revivir = new ImageIcon(getClass().getResource("revivir.png"));
        ImageIcon imgRevivir = new ImageIcon(revivir.getImage().getScaledInstance(Revivir.getWidth(), Revivir.getHeight(), Image.SCALE_SMOOTH));
        Revivir.setIcon (imgRevivir);
		contentPanel.add(Revivir);
		
		MaxRevivir = new JButton("");
		MaxRevivir.setBounds(138, 444, 95, 62);
		ImageIcon maxRevivir = new ImageIcon(getClass().getResource("revivirmaximo.png"));
        ImageIcon imgMaxRevivir = new ImageIcon(maxRevivir.getImage().getScaledInstance(MaxRevivir.getWidth(), MaxRevivir.getHeight(), Image.SCALE_SMOOTH));
        MaxRevivir.setIcon (imgMaxRevivir);
		contentPanel.add(MaxRevivir);
		
		Restos = new JButton("");
		Restos.setBounds(283, 444, 95, 62);
		ImageIcon restos = new ImageIcon(getClass().getResource("restos.png"));
        ImageIcon imgRestos = new ImageIcon(restos.getImage().getScaledInstance(Restos.getWidth(), Restos.getHeight(), Image.SCALE_SMOOTH));
        Restos.setIcon (imgRestos);
		contentPanel.add(Restos);
		
		PolvoCura = new JButton("");
		PolvoCura.setBounds(423, 444, 95, 62);
		ImageIcon polvoCura = new ImageIcon(getClass().getResource("polvo.png"));
        ImageIcon imgPolvoCura = new ImageIcon(polvoCura.getImage().getScaledInstance(PolvoCura.getWidth(), PolvoCura.getHeight(), Image.SCALE_SMOOTH));
        PolvoCura.setIcon (imgPolvoCura);
		contentPanel.add(PolvoCura);
		
		HierbaRev = new JButton("");
		HierbaRev.setBounds(699, 444, 95, 62);
		ImageIcon HierbaRevivir = new ImageIcon(getClass().getResource("hierba.png"));
        ImageIcon imgHierbaRevivir = new ImageIcon(HierbaRevivir.getImage().getScaledInstance(HierbaRev.getWidth(), HierbaRev.getHeight(), Image.SCALE_SMOOTH));
        HierbaRev.setIcon (imgHierbaRevivir);
		contentPanel.add(HierbaRev);
		
		Leche = new JButton("");
		Leche.setBounds(557, 444, 95, 62);
		ImageIcon leche = new ImageIcon(getClass().getResource("leche.png"));
        ImageIcon imgLeche = new ImageIcon(leche.getImage().getScaledInstance(Leche.getWidth(), Leche.getHeight(), Image.SCALE_SMOOTH));
        Leche.setIcon (imgLeche);
		contentPanel.add(Leche);
		
		JLabel lblPocion = new JLabel("20€");
		lblPocion.setBounds(138, 219, 95, 23);
		lblPocion.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
		contentPanel.add(lblPocion, BorderLayout.CENTER);
		contentPanel.add(lblPocion);
	
		
		lblSuper = new JLabel("30€");
		lblSuper.setBounds(283, 219, 95, 23);
		lblSuper.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
		contentPanel.add(lblSuper, BorderLayout.CENTER);
		contentPanel.add(lblSuper);
		
		
		lblHiper = new JLabel("40€");
		lblHiper.setBounds(423, 219, 95, 23);
		lblHiper.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
		contentPanel.add(lblHiper, BorderLayout.CENTER);
		contentPanel.add(lblHiper);
		
		lblMax = new JLabel("60€");
		lblMax.setBounds(557, 219, 95, 23);
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblMax, BorderLayout.CENTER);
		contentPanel.add(lblMax);
		
		lblRestaurar = new JLabel("60€");
		lblRestaurar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurar.setBounds(699, 219, 95, 23);
		contentPanel.add(lblRestaurar);
		
		lblCuraTotal = new JLabel("70€");
		lblCuraTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuraTotal.setBounds(138, 317, 95, 23);
		contentPanel.add(lblCuraTotal);
		
		lblAntidoto = new JLabel("15€");
		lblAntidoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntidoto.setBounds(283, 317, 95, 23);
		contentPanel.add(lblAntidoto);
		
		lblAntiparaliz = new JLabel("15€");
		lblAntiparaliz.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntiparaliz.setBounds(423, 317, 95, 23);
		contentPanel.add(lblAntiparaliz);
		
		lblAntiquemar = new JLabel("15€");
		lblAntiquemar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntiquemar.setBounds(557, 317, 95, 23);
		contentPanel.add(lblAntiquemar);
		
		lblAntiHielo = new JLabel("15€");
		lblAntiHielo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntiHielo.setBounds(699, 317, 95, 23);
		contentPanel.add(lblAntiHielo);
		
		lblDespertar = new JLabel("15€");
		lblDespertar.setHorizontalAlignment(SwingConstants.CENTER);
		lblDespertar.setBounds(138, 410, 95, 23);
		contentPanel.add(lblDespertar);
		
		lblAguaFresca = new JLabel("5€");
		lblAguaFresca.setHorizontalAlignment(SwingConstants.CENTER);
		lblAguaFresca.setBounds(283, 410, 95, 23);
		contentPanel.add(lblAguaFresca);
		
		lblRefresco = new JLabel("5€");
		lblRefresco.setHorizontalAlignment(SwingConstants.CENTER);
		lblRefresco.setBounds(423, 410, 95, 23);
		contentPanel.add(lblRefresco);
		
		lblLimonada = new JLabel("5€");
		lblLimonada.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimonada.setBounds(557, 410, 95, 23);
		contentPanel.add(lblLimonada);
		
		lblRevivir = new JLabel("40€");
		lblRevivir.setHorizontalAlignment(SwingConstants.CENTER);
		lblRevivir.setBounds(699, 410, 95, 23);
		contentPanel.add(lblRevivir);
		
		lblMaxRevivir = new JLabel("80€");
		lblMaxRevivir.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxRevivir.setBounds(138, 508, 95, 23);
		contentPanel.add(lblMaxRevivir);
		
		lblRestos = new JLabel("90€");
		lblRestos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestos.setBounds(283, 508, 95, 23);
		contentPanel.add(lblRestos);
		
		lblPolvoCura = new JLabel("20€");
		lblPolvoCura.setHorizontalAlignment(SwingConstants.CENTER);
		lblPolvoCura.setBounds(423, 508, 95, 23);
		contentPanel.add(lblPolvoCura);
		
		lblLecheMu = new JLabel("35€");
		lblLecheMu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecheMu.setBounds(557, 508, 95, 23);
		contentPanel.add(lblLecheMu);
		
		lblHierba = new JLabel("40€");
		lblHierba.setHorizontalAlignment(SwingConstants.CENTER);
		lblHierba.setBounds(699, 508, 95, 23);
		contentPanel.add(lblHierba);
		
		JCheckBox checkPocion = new JCheckBox("");
		checkPocion.setBounds(148, 219, 21, 23);
		contentPanel.add(checkPocion);
		
		checkSuper = new JCheckBox("");
		checkSuper.setBounds(293, 219, 21, 23);
		contentPanel.add(checkSuper);
		
		checkHiper = new JCheckBox("");
		checkHiper.setBounds(433, 219, 21, 23);
		contentPanel.add(checkHiper);
		
		checkMax = new JCheckBox("");
		checkMax.setBounds(567, 219, 21, 23);
		contentPanel.add(checkMax);
		
		checkRestTodo = new JCheckBox("");
		checkRestTodo.setBounds(709, 219, 21, 23);
		contentPanel.add(checkRestTodo);
		
		checkCuraTotal = new JCheckBox("");
		checkCuraTotal.setBounds(148, 317, 21, 23);
		contentPanel.add(checkCuraTotal);
		
		checkAntidoto = new JCheckBox("");
		checkAntidoto.setBounds(293, 317, 21, 23);
		contentPanel.add(checkAntidoto);
		
		checkAntiparaliz = new JCheckBox("");
		checkAntiparaliz.setBounds(433, 317, 21, 23);
		contentPanel.add(checkAntiparaliz);
		
		checkAntiquemar = new JCheckBox("");
		checkAntiquemar.setBounds(567, 317, 21, 23);
		contentPanel.add(checkAntiquemar);
		
		checkAntiHielo = new JCheckBox("");
		checkAntiHielo.setBounds(709, 317, 21, 23);
		contentPanel.add(checkAntiHielo);
		
		checkDespertar = new JCheckBox("");
		checkDespertar.setBounds(148, 410, 21, 23);
		contentPanel.add(checkDespertar);
		
		checkAguaFresca = new JCheckBox("");
		checkAguaFresca.setBounds(293, 410, 21, 23);
		contentPanel.add(checkAguaFresca);
		
		checkRefresco = new JCheckBox("");
		checkRefresco.setBounds(433, 410, 21, 23);
		contentPanel.add(checkRefresco);
		
		checkLimonada = new JCheckBox("");
		checkLimonada.setBounds(567, 410, 21, 23);
		contentPanel.add(checkLimonada);
		
		checkRevivir = new JCheckBox("");
		checkRevivir.setBounds(709, 410, 21, 23);
		contentPanel.add(checkRevivir);
		
		checkMaxRevivir = new JCheckBox("");
		checkMaxRevivir.setBounds(148, 508, 21, 23);
		contentPanel.add(checkMaxRevivir);
		
		checkRestos = new JCheckBox("");
		checkRestos.setBounds(293, 508, 21, 23);
		contentPanel.add(checkRestos);
		
		checkPolvoCura = new JCheckBox("");
		checkPolvoCura.setBounds(433, 510, 21, 23);
		contentPanel.add(checkPolvoCura);
		
		checkLeche = new JCheckBox("");
		checkLeche.setBounds(567, 508, 21, 23);
		contentPanel.add(checkLeche);
		
		checkHierba = new JCheckBox("");
		checkHierba.setBounds(709, 508, 21, 23);
		contentPanel.add(checkHierba);
		
		JSpinner spinnerPocion = new JSpinner();
		spinnerPocion.setBounds(203, 220, 48, 20);
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        spinnerPocion.setModel(spinnerModel);
        
		contentPanel.add(spinnerPocion);
		
		spinnerSuper = new JSpinner();
		spinnerSuper.setBounds(352, 220, 48, 20);
        spinnerSuper.setModel(spinnerModel);
		contentPanel.add(spinnerSuper);
		
		spinnerHiper = new JSpinner();
		spinnerHiper.setBounds(488, 220, 48, 20);
		spinnerHiper.setModel(spinnerModel);
		contentPanel.add(spinnerHiper);
		
		spinnerMax = new JSpinner();
		spinnerMax.setBounds(628, 220, 48, 20);
		spinnerMax.setModel(spinnerModel);
		contentPanel.add(spinnerMax);
		
		spinnerRestaurarTodo = new JSpinner();
		spinnerRestaurarTodo.setBounds(769, 220, 48, 20);
		spinnerRestaurarTodo.setModel(spinnerModel);
		contentPanel.add(spinnerRestaurarTodo);
		
		spinnerAntihielo = new JSpinner();
		spinnerAntihielo.setBounds(769, 318, 48, 20);
		spinnerAntihielo.setModel(spinnerModel);
		contentPanel.add(spinnerAntihielo);
		
		spinnerAntiquemar = new JSpinner();
		spinnerAntiquemar.setBounds(628, 318, 48, 20);
		spinnerAntiquemar.setModel(spinnerModel);
		contentPanel.add(spinnerAntiquemar);
		
		spinnerAntiparaliz = new JSpinner();
		spinnerAntiparaliz.setBounds(488, 318, 48, 20);
		spinnerAntiparaliz.setModel(spinnerModel);
		contentPanel.add(spinnerAntiparaliz);
		
		spinnerAntidoto = new JSpinner();
		spinnerAntidoto.setBounds(352, 318, 48, 20);
		spinnerAntidoto.setModel(spinnerModel);
		contentPanel.add(spinnerAntidoto);
		
		spinnerCuraTotal = new JSpinner();
		spinnerCuraTotal.setBounds(203, 318, 48, 20);
		spinnerCuraTotal.setModel(spinnerModel);
		contentPanel.add(spinnerCuraTotal);
		
		spinnerDespertar = new JSpinner();
		spinnerDespertar.setBounds(203, 411, 48, 20);
		spinnerDespertar.setModel(spinnerModel);
		contentPanel.add(spinnerDespertar);
		
		spinnerAguaFresca = new JSpinner();
		spinnerAguaFresca.setBounds(352, 411, 48, 20);
		spinnerAguaFresca.setModel(spinnerModel);
		contentPanel.add(spinnerAguaFresca);
		
		spinnerRefresco = new JSpinner();
		spinnerRefresco.setBounds(488, 411, 48, 20);
		spinnerRefresco.setModel(spinnerModel);
		contentPanel.add(spinnerRefresco);
		
		spinnerLimonada = new JSpinner();
		spinnerLimonada.setBounds(628, 413, 48, 20);
		spinnerLimonada.setModel(spinnerModel);
		contentPanel.add(spinnerLimonada);
		
		spinnerRevivir = new JSpinner();
		spinnerRevivir.setBounds(769, 411, 48, 20);
		spinnerRevivir.setModel(spinnerModel);
		contentPanel.add(spinnerRevivir);
		
		spinnerHierba = new JSpinner();
		spinnerHierba.setBounds(769, 509, 48, 20);
		spinnerHierba.setModel(spinnerModel);
		contentPanel.add(spinnerHierba);
		
		spinnerLeche = new JSpinner();
		spinnerLeche.setBounds(628, 509, 48, 20);
		spinnerLeche.setModel(spinnerModel);
		contentPanel.add(spinnerLeche);
		
		spinnerPolvo = new JSpinner();
		spinnerPolvo.setBounds(488, 509, 48, 20);
		spinnerPolvo.setModel(spinnerModel);
		contentPanel.add(spinnerPolvo);
		
		spinnerRestos = new JSpinner();
		spinnerRestos.setBounds(352, 509, 48, 20);
		spinnerRestos.setModel(spinnerModel);
		contentPanel.add(spinnerRestos);
		
		spinnerMaxRev = new JSpinner();
		spinnerMaxRev.setBounds(203, 509, 48, 20);
		spinnerMaxRev.setModel(spinnerModel);
		contentPanel.add(spinnerMaxRev);
		
		
	}
}
