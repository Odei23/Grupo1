package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;

import javax.management.loading.PrivateClassLoader;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controlador.Controlador;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaObtenerPokemon extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblLogo;
	private JButton P001, P002, P003, P004, P005, P006, P007, P008, P009, P010, P011, P012, P013, P014, P015, P016, P017, P018, P019, P020;
	private JCheckBox C001, C002, C003, C004, C005, C006, C007, C008, C009, C010, C011, C012, C013, C014, C015, C016, C017, C018, C019, C020;
	private JSpinner S001, S002, S003, S004, S005, S006, S007, S008, S009, S010, S011, S012, S013, S014, S015, S016,
			S017, S018, S019, S020;
	private JLabel lblSaldo;
	private JTextField textField,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8,textField_9, textField_10,
	textField_11,textField_12,textField_13,textField_14,textField_15,textField_16,textField_17,textField_18,textField_19,textField_20;
	
	private int precioFinal = 0;

	public VentanaObtenerPokemon(String dni) {
		setBounds(100, 100, 981, 775);
		getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 166, 128));

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblSaldo = new JLabel();
		lblSaldo.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblSaldo.setBounds(750, 80, 150, 30);
		contentPanel.add(lblSaldo);

		 float saldo = Controlador.obtenerSaldoUsuario(dni); // Suponiendo que haya un método en Controlador para obtener el saldo del usuario
		    lblSaldo.setText("Saldo: " + saldo + "€");
		{
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salir(dni);				}
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
			ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
	        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
	        lblLogo.setIcon (img2);
	        contentPanel.add(lblLogo);
		}
		
		P001 = new JButton("");
		P001.setBounds(138, 122, 113, 95);
		ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/001.png"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(P001.getWidth(), P001.getHeight(), Image.SCALE_SMOOTH));
        P001.setIcon (img2);
        contentPanel.add(P001, BorderLayout.NORTH);
		contentPanel.add(P001);
		
		
		
	    P002 = new JButton("");
		P002.setBounds(283, 122, 113, 95);
		ImageIcon superPoc = new ImageIcon(getClass().getResource("../imagenes/002.png"));
        ImageIcon imgSuper = new ImageIcon(superPoc.getImage().getScaledInstance(P002.getWidth(), P002.getHeight(), Image.SCALE_SMOOTH));
        P002.setIcon (imgSuper);
		contentPanel.add(P002);
		
		P003 = new JButton("");
		P003.setBounds(423, 122,113, 95);
		ImageIcon hiperPoc = new ImageIcon(getClass().getResource("../imagenes/003.png"));
        ImageIcon imgHiper = new ImageIcon(hiperPoc.getImage().getScaledInstance(P003.getWidth(), P003.getHeight(), Image.SCALE_SMOOTH));
        P003.setIcon (imgHiper);
		contentPanel.add(P003);
		
		P004 = new JButton("");
		P004.setBounds(557, 122, 113, 95);
		ImageIcon maxPoc = new ImageIcon(getClass().getResource("../imagenes/004.png"));
        ImageIcon imgMax = new ImageIcon(maxPoc.getImage().getScaledInstance(P004.getWidth(), P004.getHeight(), Image.SCALE_SMOOTH));
        P004.setIcon (imgMax);
		contentPanel.add(P004);
		
		P005 = new JButton("");
		P005.setBounds(699, 122, 113, 95);
		ImageIcon restTodo = new ImageIcon(getClass().getResource("../imagenes/005.png"));
        ImageIcon imgRest = new ImageIcon(restTodo.getImage().getScaledInstance(P005.getWidth(), P005.getHeight(), Image.SCALE_SMOOTH));
        P005.setIcon (imgRest);
		contentPanel.add(P005);
		ImageIcon curaTotal = new ImageIcon(getClass().getResource("../imagenes/006.png"));
		ImageIcon antiQuemar = new ImageIcon(getClass().getResource("../imagenes/007.png"));
		ImageIcon antiParaliz = new ImageIcon(getClass().getResource("../imagenes/008.png"));
		ImageIcon antidoto = new ImageIcon(getClass().getResource("../imagenes/009.png"));
		
		P010 = new JButton("");
		P010.setBounds(699, 259, 113, 95);
		ImageIcon antiHielo = new ImageIcon(getClass().getResource("../imagenes/010.png"));
        ImageIcon imgAntiHielo = new ImageIcon(antiHielo.getImage().getScaledInstance(P010.getWidth(), P010.getHeight(), Image.SCALE_SMOOTH));
        P010.setIcon (imgAntiHielo);
		contentPanel.add(P010);
		
		P011 = new JButton("");
		P011.setBounds(138, 395, 113, 95);
		ImageIcon despertar = new ImageIcon(getClass().getResource("../imagenes/011.png"));
        ImageIcon imgDespertar = new ImageIcon(despertar.getImage().getScaledInstance(P011.getWidth(), P011.getHeight(), Image.SCALE_SMOOTH));
        P011.setIcon (imgDespertar);
		contentPanel.add(P011);
		
		P012 = new JButton("");
		P012.setBounds(283, 395,113, 95);
		ImageIcon aguaFresca = new ImageIcon(getClass().getResource("../imagenes/012.png"));
        ImageIcon imgAguaFresca = new ImageIcon(aguaFresca.getImage().getScaledInstance(P012.getWidth(), P012.getHeight(), Image.SCALE_SMOOTH));
        P012.setIcon (imgAguaFresca);
		contentPanel.add(P012);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(874, 122, 17, 549);
		contentPanel.add(scrollBar);

		
		P013 = new JButton("");
		P013.setBounds(423, 395, 113, 95);
		ImageIcon refresco = new ImageIcon(getClass().getResource("../imagenes/013.png"));
        ImageIcon imgRefresco = new ImageIcon(refresco.getImage().getScaledInstance(P013.getWidth(), P013.getHeight(), Image.SCALE_SMOOTH));
        P013.setIcon (imgRefresco);
		contentPanel.add(P013);
		
		P014 = new JButton("");
		P014.setBounds(557, 395, 113, 95);
		ImageIcon limonada = new ImageIcon(getClass().getResource("../imagenes/014.png"));
        ImageIcon imgLimonada = new ImageIcon(limonada.getImage().getScaledInstance(P014.getWidth(), P014.getHeight(), Image.SCALE_SMOOTH));
        P014.setIcon (imgLimonada);
		contentPanel.add(P014);
		
		P015 = new JButton("");
		P015.setBounds(699, 395, 113, 95);
		ImageIcon revivir = new ImageIcon(getClass().getResource("../imagenes/015.png"));
        ImageIcon imgRevivir = new ImageIcon(revivir.getImage().getScaledInstance(P015.getWidth(), P015.getHeight(), Image.SCALE_SMOOTH));
        P015.setIcon (imgRevivir);
		contentPanel.add(P015);
		
		P016 = new JButton("");
		P016.setBounds(138, 544, 113, 95);
		ImageIcon maxRevivir = new ImageIcon(getClass().getResource("../imagenes/016.png"));
        ImageIcon imgMaxRevivir = new ImageIcon(maxRevivir.getImage().getScaledInstance(P016.getWidth(), P016.getHeight(), Image.SCALE_SMOOTH));
        P016.setIcon (imgMaxRevivir);
		contentPanel.add(P016);
		
		P017 = new JButton("");
		P017.setBounds(283, 544, 113, 95);
		ImageIcon restos = new ImageIcon(getClass().getResource("../imagenes/017.png"));
        ImageIcon imgRestos = new ImageIcon(restos.getImage().getScaledInstance(P017.getWidth(), P017.getHeight(), Image.SCALE_SMOOTH));
        P017.setIcon (imgRestos);
		contentPanel.add(P017);
		
		P018 = new JButton("");
		P018.setBounds(423, 544, 113, 95);
		ImageIcon polvoCura = new ImageIcon(getClass().getResource("../imagenes/018.png"));
        ImageIcon imgPolvoCura = new ImageIcon(polvoCura.getImage().getScaledInstance(P018.getWidth(), P018.getHeight(), Image.SCALE_SMOOTH));
        P018.setIcon (imgPolvoCura);
		contentPanel.add(P018);
		
		P020 = new JButton("");
		P020.setBounds(699, 544, 113, 95);
		ImageIcon HierbaRevivir = new ImageIcon(getClass().getResource("../imagenes/019.png"));
        ImageIcon imgHierbaRevivir = new ImageIcon(HierbaRevivir.getImage().getScaledInstance(P020.getWidth(), P020.getHeight(), Image.SCALE_SMOOTH));
        P020.setIcon (imgHierbaRevivir);
		contentPanel.add(P020);
		
		P019 = new JButton("");
		P019.setBounds(557, 544, 113, 95);
		ImageIcon leche = new ImageIcon(getClass().getResource("../imagenes/020.png"));
        ImageIcon imgLeche = new ImageIcon(leche.getImage().getScaledInstance(P019.getWidth(), P019.getHeight(), Image.SCALE_SMOOTH));
        P019.setIcon (imgLeche);
		contentPanel.add(P019);
		
		C001 = new JCheckBox("");
		C001.setBounds(148, 219, 21, 23);
		contentPanel.add(C001);
		
		C001.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S001.setVisible(true);
	            } else {
	            	S001.setVisible(false);
	            }
	        }
	    });	
		C002 = new JCheckBox("");
		C002.setBounds(293, 219, 21, 23);
		contentPanel.add(C002);
		
		C002.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S002.setVisible(true);
	            } else {
	            	S002.setVisible(false);
	            }
	        }
	    });
		
		C003 = new JCheckBox("");
		C003.setBounds(433, 219, 21, 23);
		contentPanel.add(C003);
		
		C003.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S003.setVisible(true);
	            } else {
	            	S003.setVisible(false);
	            }
	        }
	    });
		
		C004 = new JCheckBox("");
		C004.setBounds(567, 219, 21, 23);
		contentPanel.add(C004);	
		C004.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S004.setVisible(true);
	            } else {
	            	S004.setVisible(false);
	            }
	        }
	    });
		
		C005 = new JCheckBox("");
		C005.setBounds(709, 219, 21, 23);
		contentPanel.add(C005);
		C005.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S005.setVisible(true);
	            } else {
	            	S005.setVisible(false);
	            }
	        }
	    });
		
		C006 = new JCheckBox("");
		C006.setBounds(148, 361, 21, 23);
		contentPanel.add(C006);
		C006.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S006.setVisible(true);
	            } else {
	            	S006.setVisible(false);
	            }
	        }
	    });
		
		C007 = new JCheckBox("");
		C007.setBounds(293, 361, 21, 23);
		contentPanel.add(C007);
		C007.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S007.setVisible(true);
	            } else {
	            	S007.setVisible(false);
	            }
	        }
	    });
		
		C008 = new JCheckBox("");
		C008.setBounds(433, 361, 21, 23);
		contentPanel.add(C008);	
		C008.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S008.setVisible(true);
	            } else {
	            	S008.setVisible(false);
	            }
	        }
	    });
		
		C009 = new JCheckBox("");
		C009.setBounds(567, 361, 21, 23);
		contentPanel.add(C009);	
		C009.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S009.setVisible(true);
	            } else {
	            	S009.setVisible(false);
	            }
	        }
	    });
		
		C010 = new JCheckBox("");
		C010.setBounds(709, 361, 21, 23);
		contentPanel.add(C010);
		C010.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S010.setVisible(true);
	            } else {
	            	S010.setVisible(false);
	            }
	        }
	    });
		
		C011 = new JCheckBox("");
		C011.setBounds(148, 500, 21, 23);
		contentPanel.add(C011);		
		C011.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S011.setVisible(true);
	            } else {
	            	S011.setVisible(false);
	            }
	        }
	    });
		
		C012 = new JCheckBox("");
		C012.setBounds(293, 500, 21, 23);
		contentPanel.add(C012);	
		C012.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S012.setVisible(true);
	            } else {
	            	S012.setVisible(false);
	            }
	        }
	    });
		
		C013 = new JCheckBox("");
		C013.setBounds(433, 500, 21, 23);
		contentPanel.add(C013);
		C013.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S013.setVisible(true);
	            } else {
	            	S013.setVisible(false);
	            }
	        }
	    });
		
		C014 = new JCheckBox("");
		C014.setBounds(567, 500, 21, 23);
		contentPanel.add(C014);
		C014.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S014.setVisible(true);
	            } else {
	            	S014.setVisible(false);
	            }
	        }
	    });
		
		C015 = new JCheckBox("");
		C015.setBounds(709, 500, 21, 23);
		contentPanel.add(C015);	
		C015.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S015.setVisible(true);
	            } else {
	            	S015.setVisible(false);
	            }
	        }
	    });
		
		C016 = new JCheckBox("");
		C016.setBounds(138, 646, 21, 23);
		contentPanel.add(C016);
		C016.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S016.setVisible(true);
	            } else {
	            	S016.setVisible(false);
	            }
	        }
	    });
		
		C017 = new JCheckBox("");
		C017.setBounds(283, 646, 21, 23);
		contentPanel.add(C017);
		C017.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S017.setVisible(true);
	            } else {
	            	S017.setVisible(false);
	            }
	        }
	    });
		
		C018 = new JCheckBox("");
		C018.setBounds(423, 648, 21, 23);
		contentPanel.add(C018);
		C018.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S018.setVisible(true);
	            } else {
	            	S018.setVisible(false);
	            }
	        }
	    });
		
		C019 = new JCheckBox("");
		C019.setBounds(557, 646, 21, 23);
		contentPanel.add(C019);
		C019.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S019.setVisible(true);
	            } else {
	            	S019.setVisible(false);
	            }
	        }
	    });
		
		C020 = new JCheckBox("");
		C020.setBounds(699, 646, 21, 23);
		contentPanel.add(C020);
		C020.addItemListener((ItemListener) new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	S020.setVisible(true);
	            } else {
	            	S020.setVisible(false);
	            }
	        }
	    });
		
		S001 = new JSpinner();
		S001.setBounds(203, 220, 48, 20);
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        S001.setModel(spinnerModel);
        S001.setVisible(false);
		contentPanel.add(S001);
		
		S001.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S001.getValue();
		        int precio = obtenerPrecioEstablecido_1();
		        int precioTotal = cantidad * precio;
		        textField.setText(precioTotal + "€");
		    }});
		
		SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		S002 = new JSpinner();
		S002.setBounds(352, 220, 48, 20);
        S002.setModel(spinnerModel1);
        S002.setVisible(false);
		contentPanel.add(S002);
		
		
		S002.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S002.getValue();
		        int precio = obtenerPrecioEstablecido_2();
		        int precioTotal = cantidad * precio;
		        textField_2.setText(precioTotal + "€");
		    }});
		
		
		SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		S003 = new JSpinner();
		S003.setBounds(488, 220, 48, 20);
		S003.setModel(spinnerModel2);
        S003.setVisible(false);
		contentPanel.add(S003);
		
		S003.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S003.getValue();
		        int precio = obtenerPrecioEstablecido_3();
		        int precioTotal = cantidad * precio;
		        textField_3.setText(precioTotal + "€");
		    }});
		
		
		SpinnerNumberModel spinnerModel3 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		S004 = new JSpinner();
		S004.setBounds(628, 220, 48, 20);
		S004.setModel(spinnerModel3);
        S004.setVisible(false);

		contentPanel.add(S004);

		// Configurar el ChangeListener para el JSpinner S004
		S004.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S004.getValue();
		        int precio = obtenerPrecioEstablecido_4();
		        int precioTotal = cantidad * precio;
		        textField_4.setText(precioTotal + "€");
		    }
		});

		
		SpinnerNumberModel spinnerModel4 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		S005 = new JSpinner();
		S005.setBounds(769, 220, 48, 20);
		S005.setModel(spinnerModel4);
		S005.setVisible(false);
		contentPanel.add(S005);
		
		S005.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S005.getValue();
		        int precio = obtenerPrecioEstablecido_5();
		        int precioTotal = cantidad * precio;
		        textField_5.setText(precioTotal + "€");
		        precioFinal += precioTotal;

		    }
		});

		
		SpinnerNumberModel spinnerModel5 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		
		S010 = new JSpinner();
		S010.setBounds(769, 362, 48, 20);
		S010.setModel(spinnerModel5);
		S010.setVisible(false);
		contentPanel.add(S010);
		
		
		S010.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S010.getValue();
		        int precio = obtenerPrecioEstablecido_10();
		        int precioTotal = cantidad * precio;
		        textField_10.setText(precioTotal + "€");
		    }
		});

		
		
		SpinnerNumberModel spinnerModel6 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);	
		S009 = new JSpinner();
		S009.setBounds(628, 362, 48, 20);
		S009.setModel(spinnerModel6);
		S009.setVisible(false);
		contentPanel.add(S009);
		
		S009.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S009.getValue();
		        int precio = obtenerPrecioEstablecido_9();
		        int precioTotal = cantidad * precio;
		        textField_9.setText(precioTotal + "€");
		    }});
		
		SpinnerNumberModel spinnerModel7 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		S008 = new JSpinner();
		S008.setBounds(488, 362, 48, 20);
		S008.setModel(spinnerModel7);
		S008.setVisible(false);
		contentPanel.add(S008);
			
		
		S008.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S008.getValue();
		        int precio = obtenerPrecioEstablecido_8();
		        int precioTotal = cantidad * precio;
		        textField_8.setText(precioTotal + "€");
		    }});
		
		SpinnerNumberModel spinnerModel8 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		S007 = new JSpinner();
		S007.setBounds(352, 362, 48, 20);
		S007.setModel(spinnerModel8);
		S007.setVisible(false);
		contentPanel.add(S007);
		
		S007.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S007.getValue();
		        int precio = obtenerPrecioEstablecido_7();
		        int precioTotal = cantidad * precio;
		        textField_7.setText(precioTotal + "€");
		    }});
		
		SpinnerNumberModel spinnerModel9 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		S006 = new JSpinner();
		S006.setBounds(203, 362, 48, 20);
		S006.setModel(spinnerModel9);
		S006.setVisible(false);
		contentPanel.add(S006);
		
		S006.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S006.getValue();
		        int precio = obtenerPrecioEstablecido_6();
		        int precioTotal = cantidad * precio;
		        textField_6.setText(precioTotal + "€");
		    }});
		
		SpinnerNumberModel spinnerModel10 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);		
		S011 = new JSpinner();
		S011.setBounds(203, 501, 48, 20);
		S011.setModel(spinnerModel10);
		S011.setVisible(false);
		contentPanel.add(S011);
		
		S011.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int)S011.getValue();
		        int precio = obtenerPrecioEstablecido_11();
		        int precioTotal = cantidad * precio;
		        textField_11.setText(precioTotal + "€");
		    }});
		
		SpinnerNumberModel spinnerModel11 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);		
		S012 = new JSpinner();
		S012.setBounds(352, 501, 48, 20);
		S012.setModel(spinnerModel11);
		S012.setVisible(false);
		contentPanel.add(S012);
		
		S012.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S012.getValue();
		        int precio = obtenerPrecioEstablecido_12();
		        int precioTotal = cantidad * precio;
		        textField_12.setText(precioTotal + "€");
		    }});
		
		
		SpinnerNumberModel spinnerModel12 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);		
		S013 = new JSpinner();
		S013.setBounds(488, 501, 48, 20);
		S013.setModel(spinnerModel12);
		S013.setVisible(false);
		contentPanel.add(S013);
				
		
		S013.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S013.getValue();
		        int precio = obtenerPrecioEstablecido_13();
		        int precioTotal = cantidad * precio;
		        textField_13.setText(precioTotal + "€");
		    }});
		
		SpinnerNumberModel spinnerModel13 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		S014 = new JSpinner();
		S014.setBounds(628, 503, 48, 20);
		S014.setModel(spinnerModel13);
		S014.setVisible(false);
		contentPanel.add(S014);
		
		S014.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S014.getValue();
		        int precio = obtenerPrecioEstablecido_14();
		        int precioTotal = cantidad * precio;
		        textField_14.setText(precioTotal + "€");
		    }});
		
		
		SpinnerNumberModel spinnerModel14 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		S015 = new JSpinner();
		S015.setBounds(769, 501, 48, 20);
		S015.setModel(spinnerModel14);
		S015.setVisible(false);
		contentPanel.add(S015);
		
		S015.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S015.getValue();
		        int precio = obtenerPrecioEstablecido_15();
		        int precioTotal = cantidad * precio;
		        textField_15.setText(precioTotal + "€");
		    }});
		
		
		SpinnerNumberModel spinnerModel15 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);	
		S020 = new JSpinner();
		S020.setBounds(759, 647, 48, 20);
		S020.setModel(spinnerModel15);
		S020.setVisible(false);
		contentPanel.add(S020);
		
		S020.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S020.getValue();
		        int precio = obtenerPrecioEstablecido_20();
		        int precioTotal = cantidad * precio;
		        textField_20.setText(precioTotal + "€");
		    }});
		
		
		SpinnerNumberModel spinnerModel16 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);	
		S019 = new JSpinner();
		S019.setBounds(618, 647, 48, 20);
		S019.setModel(spinnerModel16);
		S019.setVisible(false);
		contentPanel.add(S019);
		
		S019.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S019.getValue();
		        int precio = obtenerPrecioEstablecido_19();
		        int precioTotal = cantidad * precio;
		        textField_19.setText(precioTotal + "€");
		    }});
		
		
		SpinnerNumberModel spinnerModel17 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		S018 = new JSpinner();
		S018.setBounds(478, 647, 48, 20);
		S018.setModel(spinnerModel17);
		S018.setVisible(false);
		contentPanel.add(S018);
		
		S018.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S018.getValue();
		        int precio = obtenerPrecioEstablecido_18();
		        int precioTotal = cantidad * precio;
		        textField_18.setText(precioTotal + "€");
		    }});
		
		
		SpinnerNumberModel spinnerModel18 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);	
		S017 = new JSpinner();
		S017.setBounds(342, 647, 48, 20);
		S017.setModel(spinnerModel18);
		S017.setVisible(false);
		contentPanel.add(S017);
		
		S017.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S017.getValue();
		        int precio = obtenerPrecioEstablecido_17();
		        int precioTotal = cantidad * precio;
		        textField_17.setText(precioTotal + "€");
		    }});
		
		
		SpinnerNumberModel spinnerModel19 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		S016 = new JSpinner();
		S016.setBounds(193, 647, 48, 20);
		S016.setModel(spinnerModel19);
		S016.setVisible(false);
		contentPanel.add(S016);
		
		S016.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        int cantidad = (int) S016.getValue();
		        int precio = obtenerPrecioEstablecido_16();
		        int precioTotal = cantidad * precio;
		        textField_16.setText(precioTotal + "€");
		    }});
		
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 166, 128));
		textField.setEditable(false);
		textField.setText("0€");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(BorderFactory.createEmptyBorder());
		textField.setBounds(169, 220, 35, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setText("750€");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(BorderFactory.createEmptyBorder());
		textField_4.setBackground(new Color(255, 166, 128));
		textField_4.setBounds(594, 220, 35, 20);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("20€");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBorder(BorderFactory.createEmptyBorder());
		textField_5.setBackground(new Color(255, 166, 128));
		textField_5.setBounds(735, 219, 35, 20);
		contentPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("15€");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(BorderFactory.createEmptyBorder());
		textField_6.setBackground(new Color(255, 166, 128));
		textField_6.setBounds(169, 360, 35, 20);
		contentPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("150€");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBorder(BorderFactory.createEmptyBorder());
		textField_7.setBackground(new Color(255, 166, 128));
		textField_7.setBounds(320, 362, 35, 20);
		contentPanel.add(textField_7);
		
		textField_8= new JTextField();
		textField_8.setText("40€");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBorder(BorderFactory.createEmptyBorder());
		textField_8.setBackground(new Color(255, 166, 128));
		textField_8.setBounds(460, 361, 35, 20);
		contentPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("20€");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBorder(BorderFactory.createEmptyBorder());
		textField_9.setBackground(new Color(255, 166, 128));
		textField_9.setBounds(594, 362, 35, 20);
		contentPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("50€");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBorder(BorderFactory.createEmptyBorder());
		textField_10.setBackground(new Color(255, 166, 128));
		textField_10.setBounds(735, 364, 35, 20);
		contentPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("80€");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBorder(BorderFactory.createEmptyBorder());
		textField_11.setBackground(new Color(255, 166, 128));
		textField_11.setBounds(169, 503, 35, 20);
		contentPanel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("250€");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBorder(BorderFactory.createEmptyBorder());
		textField_12.setBackground(new Color(255, 166, 128));
		textField_12.setBounds(320, 501, 35, 20);
		contentPanel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("70€");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBorder(BorderFactory.createEmptyBorder());
		textField_13.setBackground(new Color(255, 166, 128));
		textField_13.setBounds(460, 501, 35, 20);
		contentPanel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setText("20€");
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBorder(BorderFactory.createEmptyBorder());
		textField_14.setBackground(new Color(255, 166, 128));
		textField_14.setBounds(594, 503, 35, 20);
		contentPanel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setText("1250€");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBorder(BorderFactory.createEmptyBorder());
		textField_15.setBackground(new Color(255, 166, 128));
		textField_15.setBounds(736, 501, 35, 20);
		contentPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setText("7.99€");
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBorder(BorderFactory.createEmptyBorder());
		textField_16.setBackground(new Color(255, 166, 128));
		textField_16.setBounds(159, 647, 35, 20);
		contentPanel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setText("1500€");
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBorder(BorderFactory.createEmptyBorder());
		textField_17.setBackground(new Color(255, 166, 128));
		textField_17.setBounds(309, 646, 35, 20);
		contentPanel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setText("500€");
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBorder(BorderFactory.createEmptyBorder());
		textField_18.setBackground(new Color(255, 166, 128));
		textField_18.setBounds(446, 649, 35, 20);
		contentPanel.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setText("2000€");
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBorder(BorderFactory.createEmptyBorder());
		textField_19.setBackground(new Color(255, 166, 128));
		textField_19.setBounds(584, 647, 35, 20);
		contentPanel.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setText("5€");
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBorder(BorderFactory.createEmptyBorder());
		textField_20.setBackground(new Color(255, 166, 128));
		textField_20.setBounds(725, 646, 35, 20);
		contentPanel.add(textField_20);
		
		P006 = new JButton("");
		P006.setBounds(138, 256, 113, 95);
		ImageIcon imgCuraTot = new ImageIcon(curaTotal.getImage().getScaledInstance(P006.getWidth(), P006.getHeight(), Image.SCALE_SMOOTH));
		P006.setIcon (imgCuraTot);
		contentPanel.add(P006);
		
		P007 = new JButton("");
		P007.setBounds(283, 256, 113, 95);
		ImageIcon imgAntidoto = new ImageIcon(antidoto.getImage().getScaledInstance(P007.getWidth(), P007.getHeight(), Image.SCALE_SMOOTH));
		P007.setIcon (imgAntidoto);
		contentPanel.add(P007);
		
		P008 = new JButton("");
		P008.setBounds(423, 256, 113, 95);
		ImageIcon imgAntiParaliz = new ImageIcon(antiParaliz.getImage().getScaledInstance(P008.getWidth(), P008.getHeight(), Image.SCALE_SMOOTH));
		P008.setIcon (imgAntiParaliz);
		contentPanel.add(P008);
		
		P009 = new JButton("");
		P009.setBounds(557, 256, 113, 95);
		ImageIcon imgAntiQuemar = new ImageIcon(antiQuemar.getImage().getScaledInstance(P009.getWidth(), P009.getHeight(), Image.SCALE_SMOOTH));
		P009.setIcon (imgAntiQuemar);
		contentPanel.add(P009);
		
		textField_2 = new JTextField();
		textField_2.setText("0€");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(BorderFactory.createEmptyBorder());
		textField_2.setBackground(new Color(255, 166, 128));
		textField_2.setBounds(320, 222, 35, 20);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("0€");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(BorderFactory.createEmptyBorder());
		textField_3.setBackground(new Color(255, 166, 128));
		textField_3.setBounds(460, 222, 35, 20);
		contentPanel.add(textField_3);
		
		textField_20 = new JTextField();
		textField_20.setText("5€");
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBorder(BorderFactory.createEmptyBorder());
		textField_20.setBackground(new Color(255, 166, 128));
		textField_20.setBounds(726, 646, 35, 20);
		contentPanel.add(textField_20);
		
		JButton btnNewButton = new JButton("Comprar");
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprar(dni);
            }
        });
		btnNewButton.setBounds(402, 692, 134, 33);
		
		contentPanel.add(btnNewButton);

        // Cargar y mostrar el gif
        ImageIcon poke1 = new ImageIcon(getClass().getResource("../imagenes/fondo.gif"));
	}

	
	 protected void comprar(String dni) {
		 this.setVisible(false);
	        VentanaMenuUsuario venUs = new VentanaMenuUsuario(dni);
	        venUs.setVisible(true);		
	}


	protected int obtenerPrecioEstablecido_11() {
			// TODO Auto-generated method stub
			return 80;
		}
	 protected int obtenerPrecioEstablecido_12() {
			// TODO Auto-generated method stub
			return 250;
		}
	 protected int obtenerPrecioEstablecido_13() {
			// TODO Auto-generated method stub
			return 70;
		}
	 protected int obtenerPrecioEstablecido_14() {
			// TODO Auto-generated method stub
			return 20;
		}
	 protected int obtenerPrecioEstablecido_15() {
			// TODO Auto-generated method stub
			return 1250;
		}
	 protected int obtenerPrecioEstablecido_16() {
			// TODO Auto-generated method stub
			return 8;
		}
	 protected int obtenerPrecioEstablecido_17() {
			// TODO Auto-generated method stub
			return 1500;
		}

	
	 protected int obtenerPrecioEstablecido_18() {
			// TODO Auto-generated method stub
			return 500;
		}
	 protected int obtenerPrecioEstablecido_19() {
			// TODO Auto-generated method stub
			return 2000;
		}
	 protected int obtenerPrecioEstablecido_20() {
			// TODO Auto-generated method stub
			return 5;
		}

	 
    protected int obtenerPrecioEstablecido_10() {
		// TODO Auto-generated method stub
		return 50;
	}

	protected int obtenerPrecioEstablecido_9() {
		// TODO Auto-generated method stub
		return 20;
	}

	protected int obtenerPrecioEstablecido_8() {
		return 40;
	}

	protected int obtenerPrecioEstablecido_7() {
		// TODO Auto-generated method stub
		return 150;
	}

	protected int obtenerPrecioEstablecido_6() {
		// TODO Auto-generated method stub
		return 15;
	}

	protected int obtenerPrecioEstablecido_3() {
		// TODO Auto-generated method stub
		return 0;
	}

	protected int obtenerPrecioEstablecido_2() {
		return 0;
	}

	protected int obtenerPrecioEstablecido_1() {
		return 0;
	}

	protected int obtenerPrecioEstablecido_5() {
		return 20;
	}

	protected int obtenerPrecioEstablecido_4() {

    	return 750;
	}

	
	
	protected void salir(String dni) {
        this.setVisible(false);
        VentanaMenuUsuario venUs = new VentanaMenuUsuario(dni);
        venUs.setVisible(true);
    }

    protected void cerrarSesion() {
        this.setVisible(false);
        VentanaPrincipal venPrin = new VentanaPrincipal();
        venPrin.setVisible(true);
    }
}