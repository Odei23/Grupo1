package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.TextField;

import javax.swing.BorderFactory;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaInsertarPokemon extends JDialog {

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;

	public VentanaInsertarPokemon() {
		setBounds(100, 100, 985, 607);
		getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 166, 128));

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salir();				}
			});
			btnSalir.setBounds(10, 11, 140, 48);
			contentPanel.add(btnSalir);
		}
		{
			JButton btnCerrarSesion = new JButton("Cerrar Sesion");
			btnCerrarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrarSesion();
				}
			});
			btnCerrarSesion.setBounds(738, 11, 140, 48);
			contentPanel.add(btnCerrarSesion);
		}
		{
			lblLogo = new JLabel("");
			lblLogo.setBounds(423, 11, 79, 73);
			ImageIcon poke = new ImageIcon(getClass().getResource("logo.png"));
	        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
	        lblLogo.setIcon (img2);
	        contentPanel.add(lblLogo);
		}
		
		Pocion = new JButton("");
		Pocion.setBounds(138, 122, 113, 95);
		ImageIcon poke = new ImageIcon(getClass().getResource("001.png"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(Pocion.getWidth(), Pocion.getHeight(), Image.SCALE_SMOOTH));
        Pocion.setIcon (img2);
        contentPanel.add(Pocion, BorderLayout.NORTH);
		contentPanel.add(Pocion);
		
		
		
	    SuperPocion = new JButton("");
		SuperPocion.setBounds(283, 156, 95, 62);
		ImageIcon superPoc = new ImageIcon(getClass().getResource("002.png"));
        ImageIcon imgSuper = new ImageIcon(superPoc.getImage().getScaledInstance(SuperPocion.getWidth(), SuperPocion.getHeight(), Image.SCALE_SMOOTH));
        SuperPocion.setIcon (imgSuper);
		contentPanel.add(SuperPocion);
		
		HiperPocion = new JButton("");
		HiperPocion.setBounds(423, 156, 95, 62);
		ImageIcon hiperPoc = new ImageIcon(getClass().getResource("003.png"));
        ImageIcon imgHiper = new ImageIcon(hiperPoc.getImage().getScaledInstance(HiperPocion.getWidth(), HiperPocion.getHeight(), Image.SCALE_SMOOTH));
        HiperPocion.setIcon (imgHiper);
		contentPanel.add(HiperPocion);
		
		MaximaPocion = new JButton("");
		MaximaPocion.setBounds(557, 155, 95, 62);
		ImageIcon maxPoc = new ImageIcon(getClass().getResource("004.png"));
        ImageIcon imgMax = new ImageIcon(maxPoc.getImage().getScaledInstance(MaximaPocion.getWidth(), MaximaPocion.getHeight(), Image.SCALE_SMOOTH));
        MaximaPocion.setIcon (imgMax);
		contentPanel.add(MaximaPocion);
		
		RestaurarTodo = new JButton("");
		RestaurarTodo.setBounds(699, 155, 95, 62);
		ImageIcon restTodo = new ImageIcon(getClass().getResource("005.png"));
        ImageIcon imgRest = new ImageIcon(restTodo.getImage().getScaledInstance(RestaurarTodo.getWidth(), RestaurarTodo.getHeight(), Image.SCALE_SMOOTH));
        RestaurarTodo.setIcon (imgRest);
		contentPanel.add(RestaurarTodo);
		
		CuraTotal = new JButton("");
		CuraTotal.setBounds(138, 253, 113, 95);
		ImageIcon curaTotal = new ImageIcon(getClass().getResource("006.png"));
        ImageIcon imgCuraTot = new ImageIcon(curaTotal.getImage().getScaledInstance(CuraTotal.getWidth(), CuraTotal.getHeight(), Image.SCALE_SMOOTH));
        CuraTotal.setIcon (imgCuraTot);
		contentPanel.add(CuraTotal);
		
		Antiquemar = new JButton("");
		Antiquemar.setBounds(557, 253, 95, 62);
		ImageIcon antiQuemar = new ImageIcon(getClass().getResource("007.png"));
        ImageIcon imgAntiQuemar = new ImageIcon(antiQuemar.getImage().getScaledInstance(Antiquemar.getWidth(), Antiquemar.getHeight(), Image.SCALE_SMOOTH));
        Antiquemar.setIcon (imgAntiQuemar);
		contentPanel.add(Antiquemar);
		
		Antiparaliz = new JButton("");
		Antiparaliz.setBounds(423, 253, 95, 62);
		ImageIcon antiParaliz = new ImageIcon(getClass().getResource("008.png"));
        ImageIcon imgAntiParaliz = new ImageIcon(antiParaliz.getImage().getScaledInstance(Antiparaliz.getWidth(), Antiparaliz.getHeight(), Image.SCALE_SMOOTH));
        Antiparaliz.setIcon (imgAntiParaliz);
		contentPanel.add(Antiparaliz);
		
		Antidoto = new JButton("");
		Antidoto.setBounds(283, 253, 95, 62);
		ImageIcon antidoto = new ImageIcon(getClass().getResource("009.png"));
        ImageIcon imgAntidoto = new ImageIcon(antidoto.getImage().getScaledInstance(Antidoto.getWidth(), Antidoto.getHeight(), Image.SCALE_SMOOTH));
        Antidoto.setIcon (imgAntidoto);
		contentPanel.add(Antidoto);
		
		Antihielo = new JButton("");
		Antihielo.setBounds(699, 253, 95, 62);
		ImageIcon antiHielo = new ImageIcon(getClass().getResource("010.png"));
        ImageIcon imgAntiHielo = new ImageIcon(antiHielo.getImage().getScaledInstance(Antihielo.getWidth(), Antihielo.getHeight(), Image.SCALE_SMOOTH));
        Antihielo.setIcon (imgAntiHielo);
		contentPanel.add(Antihielo);
		
		Despertar = new JButton("");
		Despertar.setBounds(138, 347, 95, 62);
		ImageIcon despertar = new ImageIcon(getClass().getResource("011.png"));
        ImageIcon imgDespertar = new ImageIcon(despertar.getImage().getScaledInstance(Despertar.getWidth(), Despertar.getHeight(), Image.SCALE_SMOOTH));
        Despertar.setIcon (imgDespertar);
		contentPanel.add(Despertar);
		
		AguaFresca = new JButton("");
		AguaFresca.setBounds(283, 347, 95, 62);
		ImageIcon aguaFresca = new ImageIcon(getClass().getResource("012.png"));
        ImageIcon imgAguaFresca = new ImageIcon(aguaFresca.getImage().getScaledInstance(AguaFresca.getWidth(), AguaFresca.getHeight(), Image.SCALE_SMOOTH));
        AguaFresca.setIcon (imgAguaFresca);
		contentPanel.add(AguaFresca);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(876, 171, 17, 367);
		contentPanel.add(scrollBar);

		
		Refresco = new JButton("");
		Refresco.setBounds(423, 347, 95, 62);
		ImageIcon refresco = new ImageIcon(getClass().getResource("013.png"));
        ImageIcon imgRefresco = new ImageIcon(refresco.getImage().getScaledInstance(Refresco.getWidth(), Refresco.getHeight(), Image.SCALE_SMOOTH));
        Refresco.setIcon (imgRefresco);
		contentPanel.add(Refresco);
		
		Limonada = new JButton("");
		Limonada.setBounds(557, 347, 95, 62);
		ImageIcon limonada = new ImageIcon(getClass().getResource("014.png"));
        ImageIcon imgLimonada = new ImageIcon(limonada.getImage().getScaledInstance(Limonada.getWidth(), Limonada.getHeight(), Image.SCALE_SMOOTH));
        Limonada.setIcon (imgLimonada);
		contentPanel.add(Limonada);
		
		Revivir = new JButton("");
		Revivir.setBounds(699, 347, 95, 62);
		ImageIcon revivir = new ImageIcon(getClass().getResource("015.png"));
        ImageIcon imgRevivir = new ImageIcon(revivir.getImage().getScaledInstance(Revivir.getWidth(), Revivir.getHeight(), Image.SCALE_SMOOTH));
        Revivir.setIcon (imgRevivir);
		contentPanel.add(Revivir);
		
		MaxRevivir = new JButton("");
		MaxRevivir.setBounds(138, 444, 95, 62);
		ImageIcon maxRevivir = new ImageIcon(getClass().getResource("016.png"));
        ImageIcon imgMaxRevivir = new ImageIcon(maxRevivir.getImage().getScaledInstance(MaxRevivir.getWidth(), MaxRevivir.getHeight(), Image.SCALE_SMOOTH));
        MaxRevivir.setIcon (imgMaxRevivir);
		contentPanel.add(MaxRevivir);
		
		Restos = new JButton("");
		Restos.setBounds(283, 444, 95, 62);
		ImageIcon restos = new ImageIcon(getClass().getResource("017.png"));
        ImageIcon imgRestos = new ImageIcon(restos.getImage().getScaledInstance(Restos.getWidth(), Restos.getHeight(), Image.SCALE_SMOOTH));
        Restos.setIcon (imgRestos);
		contentPanel.add(Restos);
		
		PolvoCura = new JButton("");
		PolvoCura.setBounds(423, 444, 95, 62);
		ImageIcon polvoCura = new ImageIcon(getClass().getResource("018.png"));
        ImageIcon imgPolvoCura = new ImageIcon(polvoCura.getImage().getScaledInstance(PolvoCura.getWidth(), PolvoCura.getHeight(), Image.SCALE_SMOOTH));
        PolvoCura.setIcon (imgPolvoCura);
		contentPanel.add(PolvoCura);
		
		HierbaRev = new JButton("");
		HierbaRev.setBounds(699, 444, 95, 62);
		ImageIcon HierbaRevivir = new ImageIcon(getClass().getResource("019.png"));
        ImageIcon imgHierbaRevivir = new ImageIcon(HierbaRevivir.getImage().getScaledInstance(HierbaRev.getWidth(), HierbaRev.getHeight(), Image.SCALE_SMOOTH));
        HierbaRev.setIcon (imgHierbaRevivir);
		contentPanel.add(HierbaRev);
		
		Leche = new JButton("");
		Leche.setBounds(557, 444, 95, 62);
		ImageIcon leche = new ImageIcon(getClass().getResource("020.png"));
        ImageIcon imgLeche = new ImageIcon(leche.getImage().getScaledInstance(Leche.getWidth(), Leche.getHeight(), Image.SCALE_SMOOTH));
        Leche.setIcon (imgLeche);
		contentPanel.add(Leche);
		
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
		
		
		SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerSuper = new JSpinner();
		spinnerSuper.setBounds(352, 220, 48, 20);
        spinnerSuper.setModel(spinnerModel1);
		contentPanel.add(spinnerSuper);
		
		
		SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		spinnerHiper = new JSpinner();
		spinnerHiper.setBounds(488, 220, 48, 20);
		spinnerHiper.setModel(spinnerModel2);
		contentPanel.add(spinnerHiper);
		
		
		SpinnerNumberModel spinnerModel3 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		spinnerMax = new JSpinner();
		spinnerMax.setBounds(628, 220, 48, 20);
		spinnerMax.setModel(spinnerModel3);
		contentPanel.add(spinnerMax);
		
		SpinnerNumberModel spinnerModel4 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerRestaurarTodo = new JSpinner();
		spinnerRestaurarTodo.setBounds(769, 220, 48, 20);
		spinnerRestaurarTodo.setModel(spinnerModel4);
		contentPanel.add(spinnerRestaurarTodo);
		
		SpinnerNumberModel spinnerModel5 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		
		spinnerAntihielo = new JSpinner();
		spinnerAntihielo.setBounds(769, 318, 48, 20);
		spinnerAntihielo.setModel(spinnerModel5);
		contentPanel.add(spinnerAntihielo);
		
		
		SpinnerNumberModel spinnerModel6 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerAntiquemar = new JSpinner();
		spinnerAntiquemar.setBounds(628, 318, 48, 20);
		spinnerAntiquemar.setModel(spinnerModel6);
		contentPanel.add(spinnerAntiquemar);
		
		SpinnerNumberModel spinnerModel7 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerAntiparaliz = new JSpinner();
		spinnerAntiparaliz.setBounds(488, 318, 48, 20);
		spinnerAntiparaliz.setModel(spinnerModel7);
		contentPanel.add(spinnerAntiparaliz);
		
		
		SpinnerNumberModel spinnerModel8 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerAntidoto = new JSpinner();
		spinnerAntidoto.setBounds(352, 318, 48, 20);
		spinnerAntidoto.setModel(spinnerModel8);
		contentPanel.add(spinnerAntidoto);
		
		SpinnerNumberModel spinnerModel9 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerCuraTotal = new JSpinner();
		spinnerCuraTotal.setBounds(203, 318, 48, 20);
		spinnerCuraTotal.setModel(spinnerModel9);
		contentPanel.add(spinnerCuraTotal);
		
		SpinnerNumberModel spinnerModel10 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerDespertar = new JSpinner();
		spinnerDespertar.setBounds(203, 411, 48, 20);
		spinnerDespertar.setModel(spinnerModel10);
		contentPanel.add(spinnerDespertar);
		
		
		SpinnerNumberModel spinnerModel11 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerAguaFresca = new JSpinner();
		spinnerAguaFresca.setBounds(352, 411, 48, 20);
		spinnerAguaFresca.setModel(spinnerModel11);
		contentPanel.add(spinnerAguaFresca);
		
		SpinnerNumberModel spinnerModel12 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerRefresco = new JSpinner();
		spinnerRefresco.setBounds(488, 411, 48, 20);
		spinnerRefresco.setModel(spinnerModel12);
		contentPanel.add(spinnerRefresco);
		
		
		SpinnerNumberModel spinnerModel13 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		spinnerLimonada = new JSpinner();
		spinnerLimonada.setBounds(628, 413, 48, 20);
		spinnerLimonada.setModel(spinnerModel13);
		contentPanel.add(spinnerLimonada);
		
		
		SpinnerNumberModel spinnerModel14 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		spinnerRevivir = new JSpinner();
		spinnerRevivir.setBounds(769, 411, 48, 20);
		spinnerRevivir.setModel(spinnerModel14);
		contentPanel.add(spinnerRevivir);
		
		SpinnerNumberModel spinnerModel15 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerHierba = new JSpinner();
		spinnerHierba.setBounds(769, 509, 48, 20);
		spinnerHierba.setModel(spinnerModel15);
		contentPanel.add(spinnerHierba);
		
		SpinnerNumberModel spinnerModel16 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerLeche = new JSpinner();
		spinnerLeche.setBounds(628, 509, 48, 20);
		spinnerLeche.setModel(spinnerModel16);
		contentPanel.add(spinnerLeche);
		
		SpinnerNumberModel spinnerModel17 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerPolvo = new JSpinner();
		spinnerPolvo.setBounds(488, 509, 48, 20);
		spinnerPolvo.setModel(spinnerModel17);
		contentPanel.add(spinnerPolvo);
		
		SpinnerNumberModel spinnerModel18 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerRestos = new JSpinner();
		spinnerRestos.setBounds(352, 509, 48, 20);
		spinnerRestos.setModel(spinnerModel18);
		contentPanel.add(spinnerRestos);
		
		
		SpinnerNumberModel spinnerModel19 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		
		spinnerMaxRev = new JSpinner();
		spinnerMaxRev.setBounds(203, 509, 48, 20);
		spinnerMaxRev.setModel(spinnerModel19);
		contentPanel.add(spinnerMaxRev);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 166, 128));
		textField.setEditable(false);
		textField.setText("20€");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(BorderFactory.createEmptyBorder());
		textField.setBounds(169, 220, 35, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("20€");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(BorderFactory.createEmptyBorder());
		textField_1.setBackground(new Color(255, 166, 128));
		textField_1.setBounds(320, 220, 35, 20);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("20€");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(BorderFactory.createEmptyBorder());
		textField_2.setBackground(new Color(255, 166, 128));
		textField_2.setBounds(460, 220, 35, 20);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("20€");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(BorderFactory.createEmptyBorder());
		textField_3.setBackground(new Color(255, 166, 128));
		textField_3.setBounds(594, 220, 35, 20);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("20€");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(BorderFactory.createEmptyBorder());
		textField_4.setBackground(new Color(255, 166, 128));
		textField_4.setBounds(735, 219, 35, 20);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("20€");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBorder(BorderFactory.createEmptyBorder());
		textField_5.setBackground(new Color(255, 166, 128));
		textField_5.setBounds(169, 316, 35, 20);
		contentPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("20€");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(BorderFactory.createEmptyBorder());
		textField_6.setBackground(new Color(255, 166, 128));
		textField_6.setBounds(320, 318, 35, 20);
		contentPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("20€");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBorder(BorderFactory.createEmptyBorder());
		textField_7.setBackground(new Color(255, 166, 128));
		textField_7.setBounds(460, 318, 35, 20);
		contentPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("20€");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBorder(BorderFactory.createEmptyBorder());
		textField_8.setBackground(new Color(255, 166, 128));
		textField_8.setBounds(594, 318, 35, 20);
		contentPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("20€");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBorder(BorderFactory.createEmptyBorder());
		textField_9.setBackground(new Color(255, 166, 128));
		textField_9.setBounds(735, 320, 35, 20);
		contentPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("20€");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBorder(BorderFactory.createEmptyBorder());
		textField_10.setBackground(new Color(255, 166, 128));
		textField_10.setBounds(169, 413, 35, 20);
		contentPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("20€");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBorder(BorderFactory.createEmptyBorder());
		textField_11.setBackground(new Color(255, 166, 128));
		textField_11.setBounds(320, 411, 35, 20);
		contentPanel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("20€");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBorder(BorderFactory.createEmptyBorder());
		textField_12.setBackground(new Color(255, 166, 128));
		textField_12.setBounds(460, 411, 35, 20);
		contentPanel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("20€");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBorder(BorderFactory.createEmptyBorder());
		textField_13.setBackground(new Color(255, 166, 128));
		textField_13.setBounds(594, 413, 35, 20);
		contentPanel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setText("20€");
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBorder(BorderFactory.createEmptyBorder());
		textField_14.setBackground(new Color(255, 166, 128));
		textField_14.setBounds(736, 413, 35, 20);
		contentPanel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setText("20€");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBorder(BorderFactory.createEmptyBorder());
		textField_15.setBackground(new Color(255, 166, 128));
		textField_15.setBounds(169, 509, 35, 20);
		contentPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setText("20€");
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBorder(BorderFactory.createEmptyBorder());
		textField_16.setBackground(new Color(255, 166, 128));
		textField_16.setBounds(320, 509, 35, 20);
		contentPanel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setText("20€");
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBorder(BorderFactory.createEmptyBorder());
		textField_17.setBackground(new Color(255, 166, 128));
		textField_17.setBounds(460, 509, 35, 20);
		contentPanel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setText("20€");
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBorder(BorderFactory.createEmptyBorder());
		textField_18.setBackground(new Color(255, 166, 128));
		textField_18.setBounds(594, 509, 35, 20);
		contentPanel.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setText("20€");
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBorder(BorderFactory.createEmptyBorder());
		textField_19.setBackground(new Color(255, 166, 128));
		textField_19.setBounds(735, 508, 35, 20);
		contentPanel.add(textField_19);
		
		
	}

	
    protected void salir() {
        this.setVisible(false);
        VentanaMenuAdmin venAdmin = new VentanaMenuAdmin();
        venAdmin.setVisible(true);
    }

    protected void cerrarSesion() {
        this.setVisible(false);
        VentanaPrincipal venPrin = new VentanaPrincipal();
        venPrin.setVisible(true);
    }
}