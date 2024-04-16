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
		setBounds(100, 100, 985, 1012);
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
		MaximaPocion.setBounds(138, 253, 95, 62);
		ImageIcon maxPoc = new ImageIcon(getClass().getResource("max.png"));
        ImageIcon imgMax = new ImageIcon(maxPoc.getImage().getScaledInstance(MaximaPocion.getWidth(), MaximaPocion.getHeight(), Image.SCALE_SMOOTH));
        MaximaPocion.setIcon (imgMax);
		contentPanel.add(MaximaPocion);
		
		RestaurarTodo = new JButton("");
		RestaurarTodo.setBounds(283, 253, 95, 62);
		ImageIcon restTodo = new ImageIcon(getClass().getResource("restaurar.png"));
        ImageIcon imgRest = new ImageIcon(restTodo.getImage().getScaledInstance(RestaurarTodo.getWidth(), RestaurarTodo.getHeight(), Image.SCALE_SMOOTH));
        RestaurarTodo.setIcon (imgRest);
		contentPanel.add(RestaurarTodo);
		
		CuraTotal = new JButton("");
		CuraTotal.setBounds(423, 253, 95, 62);
		ImageIcon curaTotal = new ImageIcon(getClass().getResource("curatotal.png"));
        ImageIcon imgCuraTot = new ImageIcon(curaTotal.getImage().getScaledInstance(CuraTotal.getWidth(), CuraTotal.getHeight(), Image.SCALE_SMOOTH));
        CuraTotal.setIcon (imgCuraTot);
		contentPanel.add(CuraTotal);
		
		Antiquemar = new JButton("");
		Antiquemar.setBounds(423, 347, 95, 62);
		ImageIcon antiQuemar = new ImageIcon(getClass().getResource("antiquemar.png"));
        ImageIcon imgAntiQuemar = new ImageIcon(antiQuemar.getImage().getScaledInstance(Antiquemar.getWidth(), Antiquemar.getHeight(), Image.SCALE_SMOOTH));
        Antiquemar.setIcon (imgAntiQuemar);
		contentPanel.add(Antiquemar);
		
		Antiparaliz = new JButton("");
		Antiparaliz.setBounds(283, 347, 95, 62);
		ImageIcon antiParaliz = new ImageIcon(getClass().getResource("antiparaliz.png"));
        ImageIcon imgAntiParaliz = new ImageIcon(antiParaliz.getImage().getScaledInstance(Antiparaliz.getWidth(), Antiparaliz.getHeight(), Image.SCALE_SMOOTH));
        Antiparaliz.setIcon (imgAntiParaliz);
		contentPanel.add(Antiparaliz);
		
		Antidoto = new JButton("");
		Antidoto.setBounds(138, 347, 95, 62);
		ImageIcon antidoto = new ImageIcon(getClass().getResource("antidoto.png"));
        ImageIcon imgAntidoto = new ImageIcon(antidoto.getImage().getScaledInstance(Antidoto.getWidth(), Antidoto.getHeight(), Image.SCALE_SMOOTH));
        Antidoto.setIcon (imgAntidoto);
		contentPanel.add(Antidoto);
		
		Antihielo = new JButton("");
		Antihielo.setBounds(138, 439, 95, 62);
		ImageIcon antiHielo = new ImageIcon(getClass().getResource("antihielo.png"));
        ImageIcon imgAntiHielo = new ImageIcon(antiHielo.getImage().getScaledInstance(Antihielo.getWidth(), Antihielo.getHeight(), Image.SCALE_SMOOTH));
        Antihielo.setIcon (imgAntiHielo);
		contentPanel.add(Antihielo);
		
		Despertar = new JButton("");
		Despertar.setBounds(283, 439, 95, 62);
		ImageIcon despertar = new ImageIcon(getClass().getResource("despertar.png"));
        ImageIcon imgDespertar = new ImageIcon(despertar.getImage().getScaledInstance(Despertar.getWidth(), Despertar.getHeight(), Image.SCALE_SMOOTH));
        Despertar.setIcon (imgDespertar);
		contentPanel.add(Despertar);
		
		AguaFresca = new JButton("");
		AguaFresca.setBounds(423, 439, 95, 62);
		ImageIcon aguaFresca = new ImageIcon(getClass().getResource("aguafresca.png"));
        ImageIcon imgAguaFresca = new ImageIcon(aguaFresca.getImage().getScaledInstance(AguaFresca.getWidth(), AguaFresca.getHeight(), Image.SCALE_SMOOTH));
        AguaFresca.setIcon (imgAguaFresca);
		contentPanel.add(AguaFresca);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(679, 155, 17, 349);
		contentPanel.add(scrollBar);

		
		Refresco = new JButton("");
		Refresco.setBounds(138, 529, 95, 62);
		ImageIcon refresco = new ImageIcon(getClass().getResource("refresco.png"));
        ImageIcon imgRefresco = new ImageIcon(refresco.getImage().getScaledInstance(Refresco.getWidth(), Refresco.getHeight(), Image.SCALE_SMOOTH));
        Refresco.setIcon (imgRefresco);
		contentPanel.add(Refresco);
		
		Limonada = new JButton("");
		Limonada.setBounds(283, 529, 95, 62);
		ImageIcon limonada = new ImageIcon(getClass().getResource("limonada.png"));
        ImageIcon imgLimonada = new ImageIcon(limonada.getImage().getScaledInstance(Limonada.getWidth(), Limonada.getHeight(), Image.SCALE_SMOOTH));
        Limonada.setIcon (imgLimonada);
		contentPanel.add(Limonada);
		
		Revivir = new JButton("");
		Revivir.setBounds(423, 529, 95, 62);
		ImageIcon revivir = new ImageIcon(getClass().getResource("revivir.png"));
        ImageIcon imgRevivir = new ImageIcon(revivir.getImage().getScaledInstance(Revivir.getWidth(), Revivir.getHeight(), Image.SCALE_SMOOTH));
        Revivir.setIcon (imgRevivir);
		contentPanel.add(Revivir);
		
		MaxRevivir = new JButton("");
		MaxRevivir.setBounds(138, 643, 95, 62);
		ImageIcon maxRevivir = new ImageIcon(getClass().getResource("revivirmaximo.png"));
        ImageIcon imgMaxRevivir = new ImageIcon(maxRevivir.getImage().getScaledInstance(MaxRevivir.getWidth(), MaxRevivir.getHeight(), Image.SCALE_SMOOTH));
        MaxRevivir.setIcon (imgMaxRevivir);
		contentPanel.add(MaxRevivir);
		
		Restos = new JButton("");
		Restos.setBounds(283, 643, 95, 62);
		ImageIcon restos = new ImageIcon(getClass().getResource("restos.png"));
        ImageIcon imgRestos = new ImageIcon(restos.getImage().getScaledInstance(Restos.getWidth(), Restos.getHeight(), Image.SCALE_SMOOTH));
        Restos.setIcon (imgRestos);
		contentPanel.add(Restos);
		
		PolvoCura = new JButton("");
		PolvoCura.setBounds(423, 643, 95, 62);
		ImageIcon polvoCura = new ImageIcon(getClass().getResource("polvo.png"));
        ImageIcon imgPolvoCura = new ImageIcon(polvoCura.getImage().getScaledInstance(PolvoCura.getWidth(), PolvoCura.getHeight(), Image.SCALE_SMOOTH));
        PolvoCura.setIcon (imgPolvoCura);
		contentPanel.add(PolvoCura);
		
		HierbaRev = new JButton("");
		HierbaRev.setBounds(283, 747, 95, 62);
		ImageIcon HierbaRevivir = new ImageIcon(getClass().getResource("hierba.png"));
        ImageIcon imgHierbaRevivir = new ImageIcon(HierbaRevivir.getImage().getScaledInstance(HierbaRev.getWidth(), HierbaRev.getHeight(), Image.SCALE_SMOOTH));
        HierbaRev.setIcon (imgHierbaRevivir);
		contentPanel.add(HierbaRev);
		
		Leche = new JButton("");
		Leche.setBounds(138, 747, 95, 62);
		ImageIcon leche = new ImageIcon(getClass().getResource("leche.png"));
        ImageIcon imgLeche = new ImageIcon(leche.getImage().getScaledInstance(Leche.getWidth(), Leche.getHeight(), Image.SCALE_SMOOTH));
        Leche.setIcon (imgLeche);
		contentPanel.add(Leche);
		
		JLabel lblPocion = new JLabel("20€");
		lblPocion.setBounds(159, 219, 59, 23);
		lblPocion.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
		contentPanel.add(lblPocion, BorderLayout.CENTER);
		contentPanel.add(lblPocion);
	
		
		lblSuper = new JLabel("30€");
		lblSuper.setBounds(293, 219, 59, 23);
		lblSuper.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
		contentPanel.add(lblSuper, BorderLayout.CENTER);
		contentPanel.add(lblSuper);
		
		
		lblHiper = new JLabel("40€");
		lblHiper.setBounds(433, 219, 59, 23);
		lblHiper.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
		contentPanel.add(lblHiper, BorderLayout.CENTER);
		contentPanel.add(lblHiper);
		
		lblMax = new JLabel("60€");
		lblMax.setBounds(159, 314, 59, 23);
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblMax, BorderLayout.CENTER);
		contentPanel.add(lblMax);
		
		lblRestaurar = new JLabel("60€");
		lblRestaurar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurar.setBounds(293, 314, 59, 23);
		contentPanel.add(lblRestaurar);
		
		lblCuraTotal = new JLabel("70€");
		lblCuraTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuraTotal.setBounds(444, 314, 59, 23);
		contentPanel.add(lblCuraTotal);
	}
}
