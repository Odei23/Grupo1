package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

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
	private JTextField textField;
	private JCheckBox chckbxPokekubos;
	private JCheckBox chckbxPokochoAm;
	private JCheckBox chckbxPokochoVe;
	private JCheckBox chckbxPokochoRs;
	private JCheckBox chckbxPokochoAz;
	private JCheckBox chckbxPokochoRj;
	private JCheckBox chckbxCurri;
	private JCheckBox chckbxPokelito;
	private JCheckBox chckbxBonguriAz;
	private JCheckBox chckbxBonguriRj;
	private JCheckBox chckbxBonguriAm;
	private JCheckBox chckbxBonguriNg;
	private JCheckBox chckbxBonguriVr;
	private JCheckBox chckbxBonguriRs;
	private JCheckBox chckbxBayameloc;
	private JCheckBox chckbxBayaaranja;
	private JCheckBox chckbxBayazreza;
	private JCheckBox chckbxBayazidra;
	private JCheckBox chckbxBayapinia;
	private JCheckBox chckbxBayaframbu;
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
	private JSpinner spinnerPokekubos;
	private JSpinner spinnerPokochoAm;
	private JSpinner spinnerPokochoVe;
	private JSpinner spinnerPokochoRs;
	private JSpinner spinnerPokochoAz;
	private JSpinner spinnerPokochoRj;
	private JSpinner spinnerCurri;
	private JSpinner spinnerPokelito;
	private JSpinner spinnerBonguriAz;
	private JSpinner spinnerBonguriRj;
	private JSpinner spinnerBonguriAm;
	private JSpinner spinnerBonguriNg;
	private JSpinner spinnerBonguriVr;
	private JSpinner spinnerBonguriRs;
	private JSpinner spinnerBayameloc;
	private JSpinner spinnerBayaaranja;
	private JSpinner spinnerBayazreza;
	private JSpinner spinnerBayazidra;
	private JSpinner spinnerBayapinia;
	private JSpinner spinnerBayaframbu;


	public VCompraComida() {
		setBounds(100, 100, 747, 811);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel contentPanel_1 = new JPanel();
		contentPanel_1.setLayout(null);
		contentPanel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel_1.setBounds(0, 0, 736, 775);
		contentPanel.add(contentPanel_1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 11, 140, 48);
		contentPanel_1.add(btnSalir);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(592, 11, 140, 48);
		contentPanel_1.add(btnCerrarSesion);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(302, 11, 155, 134);
		contentPanel_1.add(lblLogo);
		ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
        lblLogo.setIcon (img2);
        
		PokeCubos = new JButton("");
		PokeCubos.setBounds(119, 155, 95, 62);
		ImageIcon pokecubo = new ImageIcon(getClass().getResource("../imagenes/pokecubos.png"));
        ImageIcon imgPokecubo = new ImageIcon(pokecubo.getImage().getScaledInstance(PokeCubos.getWidth(), PokeCubos.getHeight(), Image.SCALE_SMOOTH));
        PokeCubos.setIcon (imgPokecubo);
		contentPanel_1.add(PokeCubos);
		
		PokochoAc = new JButton("");
		PokochoAc.setBounds(260, 155, 95, 62);
		ImageIcon pokacido = new ImageIcon(getClass().getResource("../imagenes/acido.png"));
        ImageIcon imgPokAcido = new ImageIcon(pokacido.getImage().getScaledInstance(PokochoAc.getWidth(), PokochoAc.getHeight(), Image.SCALE_SMOOTH));
        PokochoAc.setIcon (imgPokAcido);
		contentPanel_1.add(PokochoAc);
		
		PokochoAmargo = new JButton("");
		PokochoAmargo.setBounds(402, 155, 95, 62);
		ImageIcon pokamargo = new ImageIcon(getClass().getResource("../imagenes/amargo.png"));
        ImageIcon imgPokAmargo = new ImageIcon(pokamargo.getImage().getScaledInstance(PokochoAmargo.getWidth(), PokochoAmargo.getHeight(), Image.SCALE_SMOOTH));
        PokochoAmargo.setIcon (imgPokAmargo);
		contentPanel_1.add(PokochoAmargo);
		
		PokochoDulce = new JButton("");
		PokochoDulce.setBounds(538, 155, 95, 62);
		ImageIcon pokdulce = new ImageIcon(getClass().getResource("../imagenes/dulce.png"));
        ImageIcon imgPokDulce = new ImageIcon(pokdulce.getImage().getScaledInstance(PokochoDulce.getWidth(), PokochoDulce.getHeight(), Image.SCALE_SMOOTH));
        PokochoDulce.setIcon (imgPokDulce);
		contentPanel_1.add(PokochoDulce);
		
		PokochoSeco = new JButton("");
		PokochoSeco.setBounds(119, 275, 95, 62);
		ImageIcon pokseco = new ImageIcon(getClass().getResource("../imagenes/seco.png"));
        ImageIcon imgPokSeco = new ImageIcon(pokseco.getImage().getScaledInstance(PokochoSeco.getWidth(), PokochoSeco.getHeight(), Image.SCALE_SMOOTH));
        PokochoSeco.setIcon (imgPokSeco);
		contentPanel_1.add(PokochoSeco);
		
		PokochoPicante = new JButton("");
		PokochoPicante.setBounds(260, 275, 95, 62);
		ImageIcon pokpicante = new ImageIcon(getClass().getResource("../imagenes/picante.png"));
        ImageIcon imgPokPicante = new ImageIcon(pokpicante.getImage().getScaledInstance(PokochoPicante.getWidth(), PokochoPicante.getHeight(), Image.SCALE_SMOOTH));
        PokochoPicante.setIcon (imgPokPicante);
		contentPanel_1.add(PokochoPicante);
		
		BonguriAz = new JButton("");
		BonguriAz.setBounds(119, 386, 95, 62);
		ImageIcon bongurAzul = new ImageIcon(getClass().getResource("../imagenes/azul.png"));
        ImageIcon imgBongurAzul = new ImageIcon(bongurAzul.getImage().getScaledInstance(BonguriAz.getWidth(), BonguriAz.getHeight(), Image.SCALE_SMOOTH));
        BonguriAz.setIcon (imgBongurAzul);
		contentPanel_1.add(BonguriAz);
		
		Pokelito = new JButton("");
		Pokelito.setBounds(538, 275, 95, 62);
		ImageIcon pokelito = new ImageIcon(getClass().getResource("../imagenes/pokelito.png"));
        ImageIcon imgPokelito = new ImageIcon(pokelito.getImage().getScaledInstance(Pokelito.getWidth(), Pokelito.getHeight(), Image.SCALE_SMOOTH));
        Pokelito.setIcon (imgPokelito);
		contentPanel_1.add(Pokelito);
		
		Curri = new JButton("");
		Curri.setBounds(402, 275, 95, 62);
		ImageIcon curri = new ImageIcon(getClass().getResource("../imagenes/curri.png"));
        ImageIcon imgCurri = new ImageIcon(curri.getImage().getScaledInstance(Curri.getWidth(), Curri.getHeight(), Image.SCALE_SMOOTH));
        Curri.setIcon (imgCurri);
		contentPanel_1.add(Curri);
		
		BonguriRoj = new JButton("");
		BonguriRoj.setBounds(260, 386, 95, 62);
		ImageIcon bongurRoja = new ImageIcon(getClass().getResource("../imagenes/rojo.png"));
        ImageIcon imgBongurRoja = new ImageIcon(bongurRoja.getImage().getScaledInstance(BonguriRoj.getWidth(), BonguriRoj.getHeight(), Image.SCALE_SMOOTH));
        BonguriRoj.setIcon (imgBongurRoja);
		contentPanel_1.add(BonguriRoj);
		
		BonguriAmarilla = new JButton("");
		BonguriAmarilla.setBounds(402, 386, 95, 62);
		ImageIcon bongurAmarilla = new ImageIcon(getClass().getResource("../imagenes/amarillo.png"));
        ImageIcon imgBongurAmarilla = new ImageIcon(bongurAmarilla.getImage().getScaledInstance(BonguriAmarilla.getWidth(), BonguriAmarilla.getHeight(), Image.SCALE_SMOOTH));
        BonguriAmarilla.setIcon (imgBongurAmarilla);
		contentPanel_1.add(BonguriAmarilla);
		
		BonguriNegra = new JButton("");
		BonguriNegra.setBounds(538, 386, 95, 62);
		ImageIcon bongurNegro = new ImageIcon(getClass().getResource("../imagenes/negro.png"));
        ImageIcon imgBongurNegra = new ImageIcon(bongurNegro.getImage().getScaledInstance(BonguriNegra.getWidth(), BonguriNegra.getHeight(), Image.SCALE_SMOOTH));
        BonguriNegra.setIcon (imgBongurNegra);
		contentPanel_1.add(BonguriNegra);
		
		BonguriVerde = new JButton("");
		BonguriVerde.setBounds(119, 495, 95, 62);
		ImageIcon bongurVerde = new ImageIcon(getClass().getResource("../imagenes/verde.png"));
        ImageIcon imgBongurVerde = new ImageIcon(bongurVerde.getImage().getScaledInstance(BonguriVerde.getWidth(), BonguriVerde.getHeight(), Image.SCALE_SMOOTH));
        BonguriVerde.setIcon (imgBongurVerde);
		contentPanel_1.add(BonguriVerde);
		
		BonguriRosa = new JButton("");
		BonguriRosa.setBounds(260, 495, 95, 62);
		ImageIcon bongurRosa = new ImageIcon(getClass().getResource("../imagenes/rosa.png"));
        ImageIcon imgBongurRosa = new ImageIcon(bongurRosa.getImage().getScaledInstance(BonguriRosa.getWidth(), BonguriRosa.getHeight(), Image.SCALE_SMOOTH));
        BonguriRosa.setIcon (imgBongurRosa);
		contentPanel_1.add(BonguriRosa);
		
		BayaMeloc = new JButton("");
		BayaMeloc.setBounds(402, 495, 95, 62);
		ImageIcon bayaMeloc = new ImageIcon(getClass().getResource("../imagenes/meloc.png"));
        ImageIcon imgBayaMeloc = new ImageIcon(bayaMeloc.getImage().getScaledInstance(BayaMeloc.getWidth(), BayaMeloc.getHeight(), Image.SCALE_SMOOTH));
        BayaMeloc.setIcon (imgBayaMeloc);
		contentPanel_1.add(BayaMeloc);
		
		BayaZreza = new JButton("");
		BayaZreza.setBounds(119, 614, 95, 62);
		ImageIcon bayaZreza = new ImageIcon(getClass().getResource("../imagenes/Zreza.png"));
	    ImageIcon imgBayaZreza = new ImageIcon(bayaZreza.getImage().getScaledInstance(BayaZreza.getWidth(), BayaZreza.getHeight(), Image.SCALE_SMOOTH));
	    BayaZreza.setIcon (imgBayaZreza);
		contentPanel_1.add(BayaZreza);
		
		BayaZidra = new JButton("");
		BayaZidra.setBounds(260, 614, 95, 62);
		ImageIcon bayaZidra = new ImageIcon(getClass().getResource("../imagenes/Zidra.png"));
	    ImageIcon imgBayaZidra = new ImageIcon(bayaZidra.getImage().getScaledInstance(BayaZidra.getWidth(), BayaZidra.getHeight(), Image.SCALE_SMOOTH));
	    BayaZidra.setIcon (imgBayaZidra);
		contentPanel_1.add(BayaZidra);
		
		BayaAranja = new JButton("");
		BayaAranja.setBounds(538, 495, 95, 62);
		ImageIcon bayaAranja = new ImageIcon(getClass().getResource("../imagenes/aranja.png"));
	    ImageIcon imgBayaAranja = new ImageIcon(bayaAranja.getImage().getScaledInstance(BayaAranja.getWidth(), BayaAranja.getHeight(), Image.SCALE_SMOOTH));
	    BayaAranja.setIcon (imgBayaAranja);
		contentPanel_1.add(BayaAranja);
		
		BayaPinia = new JButton("");
		BayaPinia.setBounds(402, 614, 95, 62);
		ImageIcon bayaPinia = new ImageIcon(getClass().getResource("../imagenes/pinia.png"));
	    ImageIcon imgBayaPinia = new ImageIcon(bayaPinia.getImage().getScaledInstance(BayaPinia.getWidth(), BayaPinia.getHeight(), Image.SCALE_SMOOTH));
	    BayaPinia.setIcon (imgBayaPinia);
		contentPanel_1.add(BayaPinia);
		
		BayaFrambu = new JButton("");
		BayaFrambu.setBounds(538, 614, 95, 62);
		ImageIcon bayaFrambu = new ImageIcon(getClass().getResource("../imagenes/Frambu.png"));
	    ImageIcon imgBayaFrambu = new ImageIcon(bayaFrambu.getImage().getScaledInstance(BayaFrambu.getWidth(), BayaFrambu.getHeight(), Image.SCALE_SMOOTH));
	    BayaFrambu.setIcon (imgBayaFrambu);
		contentPanel_1.add(BayaFrambu);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setText("30€");
		textField.setBounds(144, 220, 39, 19);
		contentPanel_1.add(textField);
		textField.setColumns(10);
		
		{
			chckbxPokekubos = new JCheckBox("New check box");
			chckbxPokekubos.setBounds(119, 220, 22, 21);
			contentPanel_1.add(chckbxPokekubos);
			
			chckbxPokekubos.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerPokekubos.setVisible(true);
		            } else {
		            	spinnerPokekubos.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxPokochoAm = new JCheckBox("New check box");
			chckbxPokochoAm.setBounds(259, 220, 22, 21);
			contentPanel_1.add(chckbxPokochoAm);
			
			chckbxPokochoAm.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerPokochoAm.setVisible(true);
		            } else {
		            	spinnerPokochoAm.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxPokochoVe = new JCheckBox("New check box");
			chckbxPokochoVe.setBounds(401, 220, 22, 21);
			contentPanel_1.add(chckbxPokochoVe);
			
			chckbxPokochoVe.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerPokochoVe.setVisible(true);
		            } else {
		            	spinnerPokochoVe.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxPokochoRs = new JCheckBox("New check box");
			chckbxPokochoRs.setBounds(538, 221, 22, 21);
			contentPanel_1.add(chckbxPokochoRs);
			
			chckbxPokochoRs.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerPokochoRs.setVisible(true);
		            } else {
		            	spinnerPokochoRs.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxPokochoAz = new JCheckBox("New check box");
			chckbxPokochoAz.setBounds(119, 340, 22, 21);
			contentPanel_1.add(chckbxPokochoAz);
			
			chckbxPokochoRs.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerPokochoRs.setVisible(true);
		            } else {
		            	spinnerPokochoRs.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxPokochoRj = new JCheckBox("New check box");
			chckbxPokochoRj.setBounds(260, 340, 22, 21);
			contentPanel_1.add(chckbxPokochoRj);
			
			chckbxPokochoRj.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerPokochoRj.setVisible(true);
		            } else {
		            	spinnerPokochoRj.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxCurri = new JCheckBox("New check box");
			chckbxCurri.setBounds(402, 340, 22, 21);
			contentPanel_1.add(chckbxCurri);
			
			chckbxCurri.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerCurri.setVisible(true);
		            } else {
		            	spinnerCurri.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxPokelito = new JCheckBox("New check box");
			chckbxPokelito.setBounds(538, 340, 22, 21);
			contentPanel_1.add(chckbxPokelito);
			
			chckbxPokelito.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerPokelito.setVisible(true);
		            } else {
		            	spinnerPokelito.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBonguriAz = new JCheckBox("New check box");
			chckbxBonguriAz.setBounds(119, 452, 22, 21);
			contentPanel_1.add(chckbxBonguriAz);
			
			chckbxBonguriAz.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBonguriAz.setVisible(true);
		            } else {
		            	spinnerBonguriAz.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBonguriRj = new JCheckBox("New check box");
			chckbxBonguriRj.setBounds(260, 452, 22, 21);
			contentPanel_1.add(chckbxBonguriRj);
			
			chckbxBonguriRj.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBonguriRj.setVisible(true);
		            } else {
		            	spinnerBonguriRj.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBonguriAm = new JCheckBox("New check box");
			chckbxBonguriAm.setBounds(402, 452, 22, 21);
			contentPanel_1.add(chckbxBonguriAm);
			
			chckbxBonguriAm.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBonguriAm.setVisible(true);
		            } else {
		            	spinnerBonguriAm.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBonguriNg = new JCheckBox("New check box");
			chckbxBonguriNg.setBounds(538, 452, 22, 21);
			contentPanel_1.add(chckbxBonguriNg);
			
			chckbxBonguriNg.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBonguriNg.setVisible(true);
		            } else {
		            	spinnerBonguriNg.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBonguriVr = new JCheckBox("New check box");
			chckbxBonguriVr.setBounds(119, 560, 22, 21);
			contentPanel_1.add(chckbxBonguriVr);
			
			chckbxBonguriVr.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBonguriVr.setVisible(true);
		            } else {
		            	spinnerBonguriVr.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBonguriRs = new JCheckBox("New check box");
			chckbxBonguriRs.setBounds(260, 560, 22, 21);
			contentPanel_1.add(chckbxBonguriRs);
			
			chckbxBonguriRs.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBonguriRs.setVisible(true);
		            } else {
		            	spinnerBonguriRs.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBayameloc = new JCheckBox("New check box");
			chckbxBayameloc.setBounds(402, 560, 22, 21);
			contentPanel_1.add(chckbxBayameloc);
			
			chckbxBayameloc.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBayameloc.setVisible(true);
		            } else {
		            	spinnerBayameloc.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBayaaranja = new JCheckBox("New check box");
			chckbxBayaaranja.setBounds(538, 560, 22, 21);
			contentPanel_1.add(chckbxBayaaranja);
			
			chckbxBayaaranja.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBayaaranja.setVisible(true);
		            } else {
		            	spinnerBayaaranja.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBayazreza = new JCheckBox("New check box");
			chckbxBayazreza.setBounds(119, 680, 22, 21);
			contentPanel_1.add(chckbxBayazreza);
			
			chckbxBayazreza.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBayazreza.setVisible(true);
		            } else {
		            	spinnerBayazreza.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBayazidra = new JCheckBox("New check box");
			chckbxBayazidra.setBounds(260, 680, 22, 21);
			contentPanel_1.add(chckbxBayazidra);
			
			chckbxBayazidra.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBayazidra.setVisible(true);
		            } else {
		            	spinnerBayazidra.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBayapinia = new JCheckBox("New check box");
			chckbxBayapinia.setBounds(402, 680, 22, 21);
			contentPanel_1.add(chckbxBayapinia);
			
			chckbxBayapinia.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBayapinia.setVisible(true);
		            } else {
		            	spinnerBayapinia.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBayaframbu = new JCheckBox("New check box");
			chckbxBayaframbu.setBounds(538, 680, 22, 21);
			contentPanel_1.add(chckbxBayaframbu);
			
			chckbxBayaframbu.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerBayaframbu.setVisible(true);
		            } else {
		            	spinnerBayaframbu.setVisible(false);
		            }
		        }
		    });
		}
		
		textField_1 = new JTextField();
		textField_1.setText("5€");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(284, 222, 39, 19);
		contentPanel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("5€");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(428, 222, 39, 19);
		contentPanel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("5€");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(566, 222, 39, 19);
		contentPanel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("5€");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(144, 341, 39, 19);
		contentPanel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("5€");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(284, 341, 39, 19);
		contentPanel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("35€");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(428, 341, 39, 19);
		contentPanel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("40€");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(566, 341, 39, 19);
		contentPanel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("5€");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(144, 453, 39, 19);
		contentPanel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("5€");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_9.setColumns(10);
		textField_9.setBounds(284, 453, 39, 19);
		contentPanel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("5€");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_10.setColumns(10);
		textField_10.setBounds(428, 453, 39, 19);
		contentPanel_1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("5€");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_11.setColumns(10);
		textField_11.setBounds(566, 453, 39, 19);
		contentPanel_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("5€");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_12.setColumns(10);
		textField_12.setBounds(144, 561, 39, 19);
		contentPanel_1.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("5€");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_13.setColumns(10);
		textField_13.setBounds(284, 561, 39, 19);
		contentPanel_1.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setText("10€");
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_14.setColumns(10);
		textField_14.setBounds(428, 561, 39, 19);
		contentPanel_1.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setText("10€");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_15.setColumns(10);
		textField_15.setBounds(566, 561, 39, 19);
		contentPanel_1.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setText("10€");
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_16.setColumns(10);
		textField_16.setBounds(144, 681, 39, 19);
		contentPanel_1.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setText("10€");
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_17.setColumns(10);
		textField_17.setBounds(284, 681, 39, 19);
		contentPanel_1.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setText("10€");
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_18.setColumns(10);
		textField_18.setBounds(428, 680, 39, 19);
		contentPanel_1.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setText("10€");
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_19.setColumns(10);
		textField_19.setBounds(566, 681, 39, 19);
		contentPanel_1.add(textField_19);
		
		{
			spinnerPokekubos = new JSpinner();
			spinnerPokekubos.setBounds(193, 220, 30, 20);
			spinnerPokekubos.setVisible(false);
			contentPanel_1.add(spinnerPokekubos);
		}
		{
			spinnerPokochoAm = new JSpinner();
			spinnerPokochoAm.setBounds(336, 222, 30, 20);
			spinnerPokochoAm.setVisible(false);
			contentPanel_1.add(spinnerPokochoAm);
		}
		{
			spinnerPokochoVe = new JSpinner();
			spinnerPokochoVe.setBounds(478, 222, 30, 20);
			spinnerPokochoVe.setVisible(false);
			contentPanel_1.add(spinnerPokochoVe);
		}
		{
			spinnerPokochoRs = new JSpinner();
			spinnerPokochoRs.setBounds(615, 222, 30, 20);
			spinnerPokochoRs.setVisible(false);
			contentPanel_1.add(spinnerPokochoRs);
		}
		{
			spinnerPokochoAz = new JSpinner();
			spinnerPokochoAz.setBounds(193, 341, 30, 20);
			spinnerPokochoAz.setVisible(false);
			contentPanel_1.add(spinnerPokochoAz);
		{
			spinnerPokochoRj = new JSpinner();
			spinnerPokochoRj.setBounds(333, 341, 30, 20);
			spinnerPokochoRj.setVisible(false);
			contentPanel_1.add(spinnerPokochoRj);
		}
		{
			spinnerCurri = new JSpinner();
			spinnerCurri.setBounds(477, 341, 30, 20);
			spinnerCurri.setVisible(false);
			contentPanel_1.add(spinnerCurri);
		}
		{
			spinnerPokelito = new JSpinner();
			spinnerPokelito.setBounds(615, 341, 30, 20);
			spinnerPokelito.setVisible(false);
			contentPanel_1.add(spinnerPokelito);
		}
			spinnerBonguriAz = new JSpinner();
			spinnerBonguriAz.setBounds(193, 453, 30, 20);
			spinnerBonguriAz.setVisible(false);
			contentPanel_1.add(spinnerBonguriAz);
		{
			spinnerBonguriRj = new JSpinner();
			spinnerBonguriRj.setBounds(333, 453, 30, 20);
			spinnerBonguriRj.setVisible(false);
			contentPanel_1.add(spinnerBonguriRj);
		}
		{
			spinnerBonguriAm = new JSpinner();
			spinnerBonguriAm.setBounds(477, 453, 30, 20);
			spinnerBonguriAm.setVisible(false);
			contentPanel_1.add(spinnerBonguriAm);
		}
		{
			spinnerBonguriNg = new JSpinner();
			spinnerBonguriNg.setBounds(615, 453, 30, 20);
			spinnerBonguriNg.setVisible(false);
			contentPanel_1.add(spinnerBonguriNg);
		}
		{
			spinnerBonguriVr = new JSpinner();
			spinnerBonguriVr.setBounds(193, 561, 30, 20);
			spinnerBonguriVr.setVisible(false);
			contentPanel_1.add(spinnerBonguriVr);
		}
		{
			spinnerBonguriRs = new JSpinner();
			spinnerBonguriRs.setBounds(333, 561, 30, 20);
			spinnerBonguriRs.setVisible(false);
			contentPanel_1.add(spinnerBonguriRs);
		}
		{
			spinnerBayameloc = new JSpinner();
			spinnerBayameloc.setBounds(477, 561, 30, 20);
			spinnerBayameloc.setVisible(false);
			contentPanel_1.add(spinnerBayameloc);
		}
		{
			spinnerBayaaranja = new JSpinner();
			spinnerBayaaranja.setBounds(615, 561, 30, 20);
			spinnerBayaaranja.setVisible(false);
			contentPanel_1.add(spinnerBayaaranja);
		}
		{
			spinnerBayazreza = new JSpinner();
			spinnerBayazreza.setBounds(193, 681, 30, 20);
			spinnerBayazreza.setVisible(false);
			contentPanel_1.add(spinnerBayazreza);
		}
		{
			spinnerBayazidra = new JSpinner();
			spinnerBayazidra.setBounds(333, 681, 30, 20);
			spinnerBayazidra.setVisible(false);
			contentPanel_1.add(spinnerBayazidra);
		}
		{
			spinnerBayapinia = new JSpinner();
			spinnerBayapinia.setBounds(477, 681, 30, 20);
			spinnerBayapinia.setVisible(false);
			contentPanel_1.add(spinnerBayapinia);
		}
		{
			spinnerBayaframbu = new JSpinner();
			spinnerBayaframbu.setBounds(615, 681, 30, 20);
			spinnerBayaframbu.setVisible(false);
			contentPanel_1.add(spinnerBayaframbu);
		}
		
		}
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
}

