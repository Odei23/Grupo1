package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

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
	private JSpinner spinnerPocion;
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
	private JTextField textFieldPocion;
	private JTextField textFieldSuper;
	private JTextField textFieldHiper;
	private JTextField textFieldMaxPoc;
	private JTextField textFieldRestaurar;
	private JTextField textFieldCuraTotal;
	private JTextField textFieldAntidoto;
	private JTextField textFieldAntiparaliz;
	private JTextField textFieldAntiquemar;
	private JTextField textFieldAntiHielo;
	private JTextField textFieldDespertar;
	private JTextField textFieldAguaFresca;
	private JTextField textFieldRefresco;
	private JTextField textFieldLimonada;
	private JTextField textFieldRevivir;
	private JTextField textFieldMaxRev;
	private JTextField textFieldRestos;
	private JTextField textFieldPolvo;
	private JTextField textFieldLeche;
	private JTextField textFieldHierba;

	public VCompraCura(String dni) {
		setBounds(100, 100, 985, 607);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnSalir = new JButton("Salir");
			btnSalir.setBounds(10, 11, 140, 48);
			contentPanel.add(btnSalir);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salir(dni);
				}
			});
		}
		{
			JButton btnCerrarSesion = new JButton("Cerrar Sesion");
			btnCerrarSesion.setBounds(738, 11, 140, 48);
			contentPanel.add(btnCerrarSesion);
			btnCerrarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrarSesion();
				}
			});

		}
		{
			lblLogo = new JLabel("");
			lblLogo.setBounds(342, 11, 155, 134);
			ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
			ImageIcon img2 = new ImageIcon(
					poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
			lblLogo.setIcon(img2);
			contentPanel.add(lblLogo);
		}

		Pocion = new JButton("");
		Pocion.setBounds(138, 155, 95, 62);
		ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/pocion.png"));
		ImageIcon img2 = new ImageIcon(
				poke.getImage().getScaledInstance(Pocion.getWidth(), Pocion.getHeight(), Image.SCALE_SMOOTH));
		Pocion.setIcon(img2);
		contentPanel.add(Pocion, BorderLayout.NORTH);
		contentPanel.add(Pocion);

		SuperPocion = new JButton("");
		SuperPocion.setBounds(283, 156, 95, 62);
		ImageIcon superPoc = new ImageIcon(getClass().getResource("../imagenes/super.png"));
		ImageIcon imgSuper = new ImageIcon(superPoc.getImage().getScaledInstance(SuperPocion.getWidth(),
				SuperPocion.getHeight(), Image.SCALE_SMOOTH));
		SuperPocion.setIcon(imgSuper);
		contentPanel.add(SuperPocion);

		HiperPocion = new JButton("");
		HiperPocion.setBounds(423, 156, 95, 62);
		ImageIcon hiperPoc = new ImageIcon(getClass().getResource("../imagenes/hiper.png"));
		ImageIcon imgHiper = new ImageIcon(hiperPoc.getImage().getScaledInstance(HiperPocion.getWidth(),
				HiperPocion.getHeight(), Image.SCALE_SMOOTH));
		HiperPocion.setIcon(imgHiper);
		contentPanel.add(HiperPocion);

		MaximaPocion = new JButton("");
		MaximaPocion.setBounds(557, 155, 95, 62);
		ImageIcon maxPoc = new ImageIcon(getClass().getResource("../imagenes/max.png"));
		ImageIcon imgMax = new ImageIcon(maxPoc.getImage().getScaledInstance(MaximaPocion.getWidth(),
				MaximaPocion.getHeight(), Image.SCALE_SMOOTH));
		MaximaPocion.setIcon(imgMax);
		contentPanel.add(MaximaPocion);

		RestaurarTodo = new JButton("");
		RestaurarTodo.setBounds(699, 155, 95, 62);
		ImageIcon restTodo = new ImageIcon(getClass().getResource("../imagenes/restaurar.png"));
		ImageIcon imgRest = new ImageIcon(restTodo.getImage().getScaledInstance(RestaurarTodo.getWidth(),
				RestaurarTodo.getHeight(), Image.SCALE_SMOOTH));
		RestaurarTodo.setIcon(imgRest);
		contentPanel.add(RestaurarTodo);

		CuraTotal = new JButton("");
		CuraTotal.setBounds(138, 253, 95, 62);
		ImageIcon curaTotal = new ImageIcon(getClass().getResource("../imagenes/curatotal.png"));
		ImageIcon imgCuraTot = new ImageIcon(curaTotal.getImage().getScaledInstance(CuraTotal.getWidth(),
				CuraTotal.getHeight(), Image.SCALE_SMOOTH));
		CuraTotal.setIcon(imgCuraTot);
		contentPanel.add(CuraTotal);

		Antiquemar = new JButton("");
		Antiquemar.setBounds(557, 253, 95, 62);
		ImageIcon antiQuemar = new ImageIcon(getClass().getResource("../imagenes/antiquemar.png"));
		ImageIcon imgAntiQuemar = new ImageIcon(antiQuemar.getImage().getScaledInstance(Antiquemar.getWidth(),
				Antiquemar.getHeight(), Image.SCALE_SMOOTH));
		Antiquemar.setIcon(imgAntiQuemar);
		contentPanel.add(Antiquemar);

		Antiparaliz = new JButton("");
		Antiparaliz.setBounds(423, 253, 95, 62);
		ImageIcon antiParaliz = new ImageIcon(getClass().getResource("../imagenes/antiparaliz.png"));
		ImageIcon imgAntiParaliz = new ImageIcon(antiParaliz.getImage().getScaledInstance(Antiparaliz.getWidth(),
				Antiparaliz.getHeight(), Image.SCALE_SMOOTH));
		Antiparaliz.setIcon(imgAntiParaliz);
		contentPanel.add(Antiparaliz);

		Antidoto = new JButton("");
		Antidoto.setBounds(283, 253, 95, 62);
		ImageIcon antidoto = new ImageIcon(getClass().getResource("../imagenes/antidoto.png"));
		ImageIcon imgAntidoto = new ImageIcon(
				antidoto.getImage().getScaledInstance(Antidoto.getWidth(), Antidoto.getHeight(), Image.SCALE_SMOOTH));
		Antidoto.setIcon(imgAntidoto);
		contentPanel.add(Antidoto);

		Antihielo = new JButton("");
		Antihielo.setBounds(699, 253, 95, 62);
		ImageIcon antiHielo = new ImageIcon(getClass().getResource("../imagenes/antihielo.png"));
		ImageIcon imgAntiHielo = new ImageIcon(antiHielo.getImage().getScaledInstance(Antihielo.getWidth(),
				Antihielo.getHeight(), Image.SCALE_SMOOTH));
		Antihielo.setIcon(imgAntiHielo);
		contentPanel.add(Antihielo);

		Despertar = new JButton("");
		Despertar.setBounds(138, 347, 95, 62);
		ImageIcon despertar = new ImageIcon(getClass().getResource("../imagenes/despertar.png"));
		ImageIcon imgDespertar = new ImageIcon(despertar.getImage().getScaledInstance(Despertar.getWidth(),
				Despertar.getHeight(), Image.SCALE_SMOOTH));
		Despertar.setIcon(imgDespertar);
		contentPanel.add(Despertar);

		AguaFresca = new JButton("");
		AguaFresca.setBounds(283, 347, 95, 62);
		ImageIcon aguaFresca = new ImageIcon(getClass().getResource("../imagenes/aguafresca.png"));
		ImageIcon imgAguaFresca = new ImageIcon(aguaFresca.getImage().getScaledInstance(AguaFresca.getWidth(),
				AguaFresca.getHeight(), Image.SCALE_SMOOTH));
		AguaFresca.setIcon(imgAguaFresca);
		contentPanel.add(AguaFresca);

		Refresco = new JButton("");
		Refresco.setBounds(423, 347, 95, 62);
		ImageIcon refresco = new ImageIcon(getClass().getResource("../imagenes/refresco.png"));
		ImageIcon imgRefresco = new ImageIcon(
				refresco.getImage().getScaledInstance(Refresco.getWidth(), Refresco.getHeight(), Image.SCALE_SMOOTH));
		Refresco.setIcon(imgRefresco);
		contentPanel.add(Refresco);

		Limonada = new JButton("");
		Limonada.setBounds(557, 347, 95, 62);
		ImageIcon limonada = new ImageIcon(getClass().getResource("../imagenes/limonada.png"));
		ImageIcon imgLimonada = new ImageIcon(
				limonada.getImage().getScaledInstance(Limonada.getWidth(), Limonada.getHeight(), Image.SCALE_SMOOTH));
		Limonada.setIcon(imgLimonada);
		contentPanel.add(Limonada);

		Revivir = new JButton("");
		Revivir.setBounds(699, 347, 95, 62);
		ImageIcon revivir = new ImageIcon(getClass().getResource("../imagenes/revivir.png"));
		ImageIcon imgRevivir = new ImageIcon(
				revivir.getImage().getScaledInstance(Revivir.getWidth(), Revivir.getHeight(), Image.SCALE_SMOOTH));
		Revivir.setIcon(imgRevivir);
		contentPanel.add(Revivir);

		MaxRevivir = new JButton("");
		MaxRevivir.setBounds(138, 444, 95, 62);
		ImageIcon maxRevivir = new ImageIcon(getClass().getResource("../imagenes/revivirmaximo.png"));
		ImageIcon imgMaxRevivir = new ImageIcon(maxRevivir.getImage().getScaledInstance(MaxRevivir.getWidth(),
				MaxRevivir.getHeight(), Image.SCALE_SMOOTH));
		MaxRevivir.setIcon(imgMaxRevivir);
		contentPanel.add(MaxRevivir);

		Restos = new JButton("");
		Restos.setBounds(283, 444, 95, 62);
		ImageIcon restos = new ImageIcon(getClass().getResource("../imagenes/restos.png"));
		ImageIcon imgRestos = new ImageIcon(
				restos.getImage().getScaledInstance(Restos.getWidth(), Restos.getHeight(), Image.SCALE_SMOOTH));
		Restos.setIcon(imgRestos);
		contentPanel.add(Restos);

		PolvoCura = new JButton("");
		PolvoCura.setBounds(423, 444, 95, 62);
		ImageIcon polvoCura = new ImageIcon(getClass().getResource("../imagenes/polvo.png"));
		ImageIcon imgPolvoCura = new ImageIcon(polvoCura.getImage().getScaledInstance(PolvoCura.getWidth(),
				PolvoCura.getHeight(), Image.SCALE_SMOOTH));
		PolvoCura.setIcon(imgPolvoCura);
		contentPanel.add(PolvoCura);

		HierbaRev = new JButton("");
		HierbaRev.setBounds(699, 444, 95, 62);
		ImageIcon HierbaRevivir = new ImageIcon(getClass().getResource("../imagenes/hierba.png"));
		ImageIcon imgHierbaRevivir = new ImageIcon(HierbaRevivir.getImage().getScaledInstance(HierbaRev.getWidth(),
				HierbaRev.getHeight(), Image.SCALE_SMOOTH));
		HierbaRev.setIcon(imgHierbaRevivir);
		contentPanel.add(HierbaRev);

		Leche = new JButton("");
		Leche.setBounds(557, 444, 95, 62);
		ImageIcon leche = new ImageIcon(getClass().getResource("../imagenes/leche.png"));
		ImageIcon imgLeche = new ImageIcon(
				leche.getImage().getScaledInstance(Leche.getWidth(), Leche.getHeight(), Image.SCALE_SMOOTH));
		Leche.setIcon(imgLeche);
		contentPanel.add(Leche);

		JCheckBox checkPocion = new JCheckBox("");
		checkPocion.setBounds(148, 219, 21, 23);
		contentPanel.add(checkPocion);
		checkPocion.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerPocion.setVisible(true);
				} else {
					spinnerPocion.setVisible(false);
				}
			}
		});

		checkSuper = new JCheckBox("");
		checkSuper.setBounds(293, 219, 21, 23);
		contentPanel.add(checkSuper);
		checkSuper.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerSuper.setVisible(true);
				} else {
					spinnerSuper.setVisible(false);
				}
			}
		});

		checkHiper = new JCheckBox("");
		checkHiper.setBounds(433, 219, 21, 23);
		contentPanel.add(checkHiper);
		checkHiper.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerHiper.setVisible(true);
				} else {
					spinnerHiper.setVisible(false);
				}
			}
		});
		checkMax = new JCheckBox("");
		checkMax.setBounds(567, 219, 21, 23);
		contentPanel.add(checkMax);
		checkMax.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerMax.setVisible(true);
				} else {
					spinnerMax.setVisible(false);
				}
			}
		});

		checkRestTodo = new JCheckBox("");
		checkRestTodo.setBounds(709, 219, 21, 23);
		contentPanel.add(checkRestTodo);
		checkRestTodo.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerRestaurarTodo.setVisible(true);
				} else {
					spinnerRestaurarTodo.setVisible(false);
				}
			}
		});

		checkCuraTotal = new JCheckBox("");
		checkCuraTotal.setBounds(148, 317, 21, 23);
		contentPanel.add(checkCuraTotal);
		checkCuraTotal.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerCuraTotal.setVisible(true);
				} else {
					spinnerCuraTotal.setVisible(false);
				}
			}
		});

		checkAntidoto = new JCheckBox("");
		checkAntidoto.setBounds(293, 317, 21, 23);
		contentPanel.add(checkAntidoto);
		checkAntidoto.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerAntidoto.setVisible(true);
				} else {
					spinnerAntidoto.setVisible(false);
				}
			}
		});

		checkAntiparaliz = new JCheckBox("");
		checkAntiparaliz.setBounds(433, 317, 21, 23);
		contentPanel.add(checkAntiparaliz);
		checkAntiparaliz.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerAntiparaliz.setVisible(true);
				} else {
					spinnerAntiparaliz.setVisible(false);
				}
			}
		});

		checkAntiquemar = new JCheckBox("");
		checkAntiquemar.setBounds(567, 317, 21, 23);
		contentPanel.add(checkAntiquemar);
		checkAntiquemar.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerAntiquemar.setVisible(true);
				} else {
					spinnerAntiquemar.setVisible(false);
				}
			}
		});

		checkAntiHielo = new JCheckBox("");
		checkAntiHielo.setBounds(709, 317, 21, 23);
		contentPanel.add(checkAntiHielo);
		checkAntiHielo.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerAntihielo.setVisible(true);
				} else {
					spinnerAntihielo.setVisible(false);
				}
			}
		});

		checkDespertar = new JCheckBox("");
		checkDespertar.setBounds(148, 410, 21, 23);
		contentPanel.add(checkDespertar);
		checkDespertar.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerDespertar.setVisible(true);
				} else {
					spinnerDespertar.setVisible(false);
				}
			}
		});

		checkAguaFresca = new JCheckBox("");
		checkAguaFresca.setBounds(293, 410, 21, 23);
		contentPanel.add(checkAguaFresca);
		checkAguaFresca.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerAguaFresca.setVisible(true);
				} else {
					spinnerAguaFresca.setVisible(false);
				}
			}
		});
		checkRefresco = new JCheckBox("");
		checkRefresco.setBounds(433, 410, 21, 23);
		contentPanel.add(checkRefresco);
		checkRefresco.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerRefresco.setVisible(true);
				} else {
					spinnerRefresco.setVisible(false);
				}
			}
		});

		checkLimonada = new JCheckBox("");
		checkLimonada.setBounds(567, 410, 21, 23);
		contentPanel.add(checkLimonada);
		checkLimonada.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerLimonada.setVisible(true);
				} else {
					spinnerLimonada.setVisible(false);
				}
			}
		});

		checkRevivir = new JCheckBox("");
		checkRevivir.setBounds(709, 410, 21, 23);
		contentPanel.add(checkRevivir);
		checkRevivir.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerRevivir.setVisible(true);
				} else {
					spinnerRevivir.setVisible(false);
				}
			}
		});

		checkMaxRevivir = new JCheckBox("");
		checkMaxRevivir.setBounds(148, 508, 21, 23);
		contentPanel.add(checkMaxRevivir);
		checkMaxRevivir.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerMaxRev.setVisible(true);
				} else {
					spinnerMaxRev.setVisible(false);
				}
			}
		});

		checkRestos = new JCheckBox("");
		checkRestos.setBounds(293, 508, 21, 23);
		contentPanel.add(checkRestos);
		checkRestos.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerRestos.setVisible(true);
				} else {
					spinnerRestos.setVisible(false);
				}
			}
		});

		checkPolvoCura = new JCheckBox("");
		checkPolvoCura.setBounds(433, 508, 21, 23);
		contentPanel.add(checkPolvoCura);
		checkPolvoCura.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerPolvo.setVisible(true);
				} else {
					spinnerPolvo.setVisible(false);
				}
			}
		});

		checkLeche = new JCheckBox("");
		checkLeche.setBounds(567, 508, 21, 23);
		contentPanel.add(checkLeche);
		checkLeche.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerLeche.setVisible(true);
				} else {
					spinnerLeche.setVisible(false);
				}
			}
		});

		checkHierba = new JCheckBox("");
		checkHierba.setBounds(709, 508, 21, 23);
		contentPanel.add(checkHierba);
		checkHierba.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					spinnerHierba.setVisible(true);
				} else {
					spinnerHierba.setVisible(false);
				}
			}
		});

		spinnerPocion = new JSpinner();
		spinnerPocion.setBounds(203, 220, 48, 20);
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerPocion.setModel(spinnerModel);
		spinnerPocion.setVisible(false);
		contentPanel.add(spinnerPocion);

		spinnerSuper = new JSpinner();
		spinnerSuper.setBounds(352, 220, 48, 20);
		SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerSuper.setModel(spinnerModel2);
		spinnerSuper.setVisible(false);
		contentPanel.add(spinnerSuper);

		spinnerHiper = new JSpinner();
		spinnerHiper.setBounds(488, 220, 48, 20);
		SpinnerNumberModel spinnerModel3 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerHiper.setModel(spinnerModel3);
		spinnerHiper.setVisible(false);
		contentPanel.add(spinnerHiper);

		spinnerMax = new JSpinner();
		spinnerMax.setBounds(628, 220, 48, 20);
		SpinnerNumberModel spinnerModel4 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerMax.setVisible(false);
		spinnerMax.setModel(spinnerModel4);
		contentPanel.add(spinnerMax);

		spinnerRestaurarTodo = new JSpinner();
		spinnerRestaurarTodo.setBounds(769, 220, 48, 20);
		SpinnerNumberModel spinnerModel5 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerRestaurarTodo.setVisible(false);
		spinnerRestaurarTodo.setModel(spinnerModel5);
		contentPanel.add(spinnerRestaurarTodo);

		spinnerAntihielo = new JSpinner();
		spinnerAntihielo.setBounds(769, 318, 48, 20);
		SpinnerNumberModel spinnerModel6 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerAntihielo.setVisible(false);
		spinnerAntihielo.setModel(spinnerModel6);
		contentPanel.add(spinnerAntihielo);

		spinnerAntiquemar = new JSpinner();
		spinnerAntiquemar.setBounds(628, 318, 48, 20);
		SpinnerNumberModel spinnerModel7 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerAntiquemar.setVisible(false);
		spinnerAntiquemar.setModel(spinnerModel7);
		contentPanel.add(spinnerAntiquemar);

		spinnerAntiparaliz = new JSpinner();
		spinnerAntiparaliz.setBounds(488, 318, 48, 20);
		SpinnerNumberModel spinnerModel8 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerAntiparaliz.setVisible(false);
		spinnerAntiparaliz.setModel(spinnerModel8);
		contentPanel.add(spinnerAntiparaliz);

		spinnerAntidoto = new JSpinner();
		spinnerAntidoto.setBounds(352, 318, 48, 20);
		SpinnerNumberModel spinnerModel9 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerAntidoto.setVisible(false);
		spinnerAntidoto.setModel(spinnerModel9);
		contentPanel.add(spinnerAntidoto);

		spinnerCuraTotal = new JSpinner();
		spinnerCuraTotal.setBounds(203, 318, 48, 20);
		SpinnerNumberModel spinnerModel10 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerCuraTotal.setVisible(false);
		spinnerCuraTotal.setModel(spinnerModel10);
		contentPanel.add(spinnerCuraTotal);

		spinnerDespertar = new JSpinner();
		spinnerDespertar.setBounds(203, 411, 48, 20);
		SpinnerNumberModel spinnerModel11 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerDespertar.setVisible(false);
		spinnerDespertar.setModel(spinnerModel11);
		contentPanel.add(spinnerDespertar);

		spinnerAguaFresca = new JSpinner();
		spinnerAguaFresca.setBounds(352, 411, 48, 20);
		SpinnerNumberModel spinnerModel12 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerAguaFresca.setVisible(false);
		spinnerAguaFresca.setModel(spinnerModel12);
		contentPanel.add(spinnerAguaFresca);

		spinnerRefresco = new JSpinner();
		spinnerRefresco.setBounds(488, 411, 48, 20);
		SpinnerNumberModel spinnerModel13 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerRefresco.setVisible(false);
		spinnerRefresco.setModel(spinnerModel13);
		contentPanel.add(spinnerRefresco);

		spinnerLimonada = new JSpinner();
		spinnerLimonada.setBounds(628, 413, 48, 20);
		SpinnerNumberModel spinnerModel14 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerLimonada.setVisible(false);
		spinnerLimonada.setModel(spinnerModel14);
		contentPanel.add(spinnerLimonada);

		spinnerRevivir = new JSpinner();
		spinnerRevivir.setBounds(769, 411, 48, 20);
		SpinnerNumberModel spinnerModel15 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerRevivir.setVisible(false);
		spinnerRevivir.setModel(spinnerModel15);
		contentPanel.add(spinnerRevivir);

		spinnerHierba = new JSpinner();
		spinnerHierba.setBounds(769, 509, 48, 20);
		SpinnerNumberModel spinnerModel16 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerHierba.setVisible(false);
		spinnerHierba.setModel(spinnerModel16);
		contentPanel.add(spinnerHierba);

		spinnerLeche = new JSpinner();
		spinnerLeche.setBounds(628, 509, 48, 20);
		SpinnerNumberModel spinnerModel17 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerLeche.setVisible(false);
		spinnerLeche.setModel(spinnerModel17);
		contentPanel.add(spinnerLeche);

		spinnerPolvo = new JSpinner();
		spinnerPolvo.setBounds(488, 509, 48, 20);
		SpinnerNumberModel spinnerModel18 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerPolvo.setVisible(false);
		spinnerPolvo.setModel(spinnerModel18);
		contentPanel.add(spinnerPolvo);

		spinnerRestos = new JSpinner();
		spinnerRestos.setBounds(352, 509, 48, 20);
		SpinnerNumberModel spinnerModel19 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerRestos.setVisible(false);
		spinnerRestos.setModel(spinnerModel19);
		contentPanel.add(spinnerRestos);

		spinnerMaxRev = new JSpinner();
		spinnerMaxRev.setBounds(203, 509, 48, 20);
		SpinnerNumberModel spinnerModel20 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerMaxRev.setVisible(false);
		spinnerMaxRev.setModel(spinnerModel20);
		contentPanel.add(spinnerMaxRev);

		textFieldPocion = new JTextField();
		textFieldPocion.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldPocion.setEditable(false);
		textFieldPocion.setBackground(new Color(240, 240, 240));
		textFieldPocion.setBorder(BorderFactory.createEmptyBorder());
		textFieldPocion.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPocion.setText("20€");
		textFieldPocion.setBounds(138, 220, 95, 20);
		contentPanel.add(textFieldPocion);
		textFieldPocion.setColumns(10);

		textFieldSuper = new JTextField();
		textFieldSuper.setText("30€");
		textFieldSuper.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSuper.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldSuper.setEditable(false);
		textFieldSuper.setColumns(10);
		textFieldSuper.setBorder(BorderFactory.createEmptyBorder());
		textFieldSuper.setBackground(UIManager.getColor("Button.background"));
		textFieldSuper.setBounds(283, 220, 96, 20);
		contentPanel.add(textFieldSuper);

		textFieldHiper = new JTextField();
		textFieldHiper.setText("40€");
		textFieldHiper.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldHiper.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldHiper.setEditable(false);
		textFieldHiper.setColumns(10);
		textFieldHiper.setBorder(BorderFactory.createEmptyBorder());
		textFieldHiper.setBackground(UIManager.getColor("Button.background"));
		textFieldHiper.setBounds(423, 220, 96, 20);
		contentPanel.add(textFieldHiper);

		textFieldMaxPoc = new JTextField();
		textFieldMaxPoc.setText("60€");
		textFieldMaxPoc.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMaxPoc.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldMaxPoc.setEditable(false);
		textFieldMaxPoc.setColumns(10);
		textFieldMaxPoc.setBorder(BorderFactory.createEmptyBorder());
		textFieldMaxPoc.setBackground(UIManager.getColor("Button.background"));
		textFieldMaxPoc.setBounds(557, 220, 95, 20);
		contentPanel.add(textFieldMaxPoc);

		textFieldRestaurar = new JTextField();
		textFieldRestaurar.setText("60€");
		textFieldRestaurar.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRestaurar.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldRestaurar.setEditable(false);
		textFieldRestaurar.setColumns(10);
		textFieldRestaurar.setBorder(BorderFactory.createEmptyBorder());
		textFieldRestaurar.setBackground(UIManager.getColor("Button.background"));
		textFieldRestaurar.setBounds(699, 220, 95, 20);
		contentPanel.add(textFieldRestaurar);

		textFieldCuraTotal = new JTextField();
		textFieldCuraTotal.setText("70€");
		textFieldCuraTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCuraTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldCuraTotal.setEditable(false);
		textFieldCuraTotal.setColumns(10);
		textFieldCuraTotal.setBorder(BorderFactory.createEmptyBorder());
		textFieldCuraTotal.setBackground(UIManager.getColor("Button.background"));
		textFieldCuraTotal.setBounds(138, 318, 95, 20);
		contentPanel.add(textFieldCuraTotal);

		textFieldAntidoto = new JTextField();
		textFieldAntidoto.setText("15€");
		textFieldAntidoto.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAntidoto.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldAntidoto.setEditable(false);
		textFieldAntidoto.setColumns(10);
		textFieldAntidoto.setBorder(BorderFactory.createEmptyBorder());
		textFieldAntidoto.setBackground(UIManager.getColor("Button.background"));
		textFieldAntidoto.setBounds(283, 318, 95, 20);
		contentPanel.add(textFieldAntidoto);

		textFieldAntiparaliz = new JTextField();
		textFieldAntiparaliz.setText("15€");
		textFieldAntiparaliz.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAntiparaliz.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldAntiparaliz.setEditable(false);
		textFieldAntiparaliz.setColumns(10);
		textFieldAntiparaliz.setBorder(BorderFactory.createEmptyBorder());
		textFieldAntiparaliz.setBackground(UIManager.getColor("Button.background"));
		textFieldAntiparaliz.setBounds(423, 317, 95, 20);
		contentPanel.add(textFieldAntiparaliz);

		textFieldAntiquemar = new JTextField();
		textFieldAntiquemar.setText("15€");
		textFieldAntiquemar.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAntiquemar.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldAntiquemar.setEditable(false);
		textFieldAntiquemar.setColumns(10);
		textFieldAntiquemar.setBorder(BorderFactory.createEmptyBorder());
		textFieldAntiquemar.setBackground(UIManager.getColor("Button.background"));
		textFieldAntiquemar.setBounds(557, 317, 95, 20);
		contentPanel.add(textFieldAntiquemar);

		textFieldAntiHielo = new JTextField();
		textFieldAntiHielo.setText("15€");
		textFieldAntiHielo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAntiHielo.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldAntiHielo.setEditable(false);
		textFieldAntiHielo.setColumns(10);
		textFieldAntiHielo.setBorder(BorderFactory.createEmptyBorder());
		textFieldAntiHielo.setBackground(UIManager.getColor("Button.background"));
		textFieldAntiHielo.setBounds(699, 317, 95, 20);
		contentPanel.add(textFieldAntiHielo);

		textFieldDespertar = new JTextField();
		textFieldDespertar.setText("15€");
		textFieldDespertar.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDespertar.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldDespertar.setEditable(false);
		textFieldDespertar.setColumns(10);
		textFieldDespertar.setBorder(BorderFactory.createEmptyBorder());
		textFieldDespertar.setBackground(UIManager.getColor("Button.background"));
		textFieldDespertar.setBounds(138, 411, 95, 20);
		contentPanel.add(textFieldDespertar);

		textFieldAguaFresca = new JTextField();
		textFieldAguaFresca.setText("5€");
		textFieldAguaFresca.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAguaFresca.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldAguaFresca.setEditable(false);
		textFieldAguaFresca.setColumns(10);
		textFieldAguaFresca.setBorder(BorderFactory.createEmptyBorder());
		textFieldAguaFresca.setBackground(UIManager.getColor("Button.background"));
		textFieldAguaFresca.setBounds(283, 411, 95, 20);
		contentPanel.add(textFieldAguaFresca);

		textFieldRefresco = new JTextField();
		textFieldRefresco.setText("5€");
		textFieldRefresco.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRefresco.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldRefresco.setEditable(false);
		textFieldRefresco.setColumns(10);
		textFieldRefresco.setBorder(BorderFactory.createEmptyBorder());
		textFieldRefresco.setBackground(UIManager.getColor("Button.background"));
		textFieldRefresco.setBounds(423, 411, 95, 20);
		contentPanel.add(textFieldRefresco);

		textFieldLimonada = new JTextField();
		textFieldLimonada.setText("5€");
		textFieldLimonada.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimonada.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldLimonada.setEditable(false);
		textFieldLimonada.setColumns(10);
		textFieldLimonada.setBorder(BorderFactory.createEmptyBorder());
		textFieldLimonada.setBackground(UIManager.getColor("Button.background"));
		textFieldLimonada.setBounds(557, 413, 95, 20);
		contentPanel.add(textFieldLimonada);

		textFieldRevivir = new JTextField();
		textFieldRevivir.setText("40€");
		textFieldRevivir.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRevivir.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldRevivir.setEditable(false);
		textFieldRevivir.setColumns(10);
		textFieldRevivir.setBorder(BorderFactory.createEmptyBorder());
		textFieldRevivir.setBackground(UIManager.getColor("Button.background"));
		textFieldRevivir.setBounds(699, 410, 95, 20);
		contentPanel.add(textFieldRevivir);

		textFieldMaxRev = new JTextField();
		textFieldMaxRev.setText("80€");
		textFieldMaxRev.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMaxRev.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldMaxRev.setEditable(false);
		textFieldMaxRev.setColumns(10);
		textFieldMaxRev.setBorder(BorderFactory.createEmptyBorder());
		textFieldMaxRev.setBackground(UIManager.getColor("Button.background"));
		textFieldMaxRev.setBounds(138, 509, 95, 20);
		contentPanel.add(textFieldMaxRev);

		textFieldRestos = new JTextField();
		textFieldRestos.setText("90€");
		textFieldRestos.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRestos.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldRestos.setEditable(false);
		textFieldRestos.setColumns(10);
		textFieldRestos.setBorder(BorderFactory.createEmptyBorder());
		textFieldRestos.setBackground(UIManager.getColor("Button.background"));
		textFieldRestos.setBounds(283, 509, 95, 20);
		contentPanel.add(textFieldRestos);

		textFieldPolvo = new JTextField();
		textFieldPolvo.setText("20€");
		textFieldPolvo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPolvo.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldPolvo.setEditable(false);
		textFieldPolvo.setColumns(10);
		textFieldPolvo.setBorder(BorderFactory.createEmptyBorder());
		textFieldPolvo.setBackground(UIManager.getColor("Button.background"));
		textFieldPolvo.setBounds(423, 509, 95, 20);
		contentPanel.add(textFieldPolvo);

		textFieldLeche = new JTextField();
		textFieldLeche.setText("35€");
		textFieldLeche.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLeche.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldLeche.setEditable(false);
		textFieldLeche.setColumns(10);
		textFieldLeche.setBorder(BorderFactory.createEmptyBorder());
		textFieldLeche.setBackground(UIManager.getColor("Button.background"));
		textFieldLeche.setBounds(557, 509, 95, 20);
		contentPanel.add(textFieldLeche);

		textFieldHierba = new JTextField();
		textFieldHierba.setText("40€");
		textFieldHierba.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldHierba.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldHierba.setEditable(false);
		textFieldHierba.setColumns(10);
		textFieldHierba.setBorder(BorderFactory.createEmptyBorder());
		textFieldHierba.setBackground(UIManager.getColor("Button.background"));
		textFieldHierba.setBounds(699, 509, 95, 20);
		contentPanel.add(textFieldHierba);
	}

	protected void cerrarSesion() {
		this.setVisible(false);
		VentanaPrincipal venPrin = new VentanaPrincipal();
		venPrin.setVisible(true);
	}

	protected void salir(String dni) {
		this.setVisible(false);
		VCompraObjetos venObjeto = new VCompraObjetos(dni);
		venObjeto.setVisible(true);
	}
}