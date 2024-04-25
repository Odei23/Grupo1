package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;

public class VCompraPokeball extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton PokeBall,SuperBall,UltraBall,MasterBall,MallaBall,HonorBall,RapidBall,SafariBall,OcasoBall,SanaBall,TurnoBall,LujoBall,NivelBall,PesoBall,CompetiBall,
	NidoBall,AcopioBall,BuceoBall,VelozBall,AmorBall	;

	private JCheckBox chckbxPokeball;
	private JCheckBox chckbxSuperball;
	private JCheckBox chckbxUltraball;
	private JCheckBox chckbxMasterball;
	private JCheckBox chckbxMallaball;
	private JCheckBox chckbxHonorball;
	private JCheckBox chckbxRapidball;
	private JCheckBox chckbxSafariball;
	private JCheckBox chckbxOcasoball;
	private JCheckBox chckbxLujoball;
	private JCheckBox chckbxTurnoball;
	private JCheckBox chckbxSanaball;
	private JCheckBox chckbxNivelball;
	private JCheckBox chckbxPesoball;
	private JCheckBox chckbxCompetiball;
	private JCheckBox chckbxNidoball;
	private JCheckBox chckbxBuceoball;
	private JCheckBox chckbxAcopioball;
	private JCheckBox chckbxAmorball;
	private JCheckBox chckbxVelozball;
	private JSpinner spinnerVelozball;
	private JSpinner spinnerBuceoball;
	private JSpinner spinnerAcopioball;
	private JSpinner spinnerAmorball;
	private JSpinner spinnerPokeball;
	private JSpinner spinnerSuperball;
	private JSpinner spinnerUltraball;
	private JSpinner spinnerMasterball;
	private JSpinner spinnerMallaball;
	private JSpinner spinnerHonorball;
	private JSpinner spinnerRapidball;
	private JSpinner spinnerSafariball;
	private JSpinner spinnerOcasoball;
	private JSpinner spinnerLujoball;
	private JSpinner spinnerTurnoball;
	private JSpinner spinnerSanaball;
	private JSpinner spinnerNivelball;
	private JSpinner spinnerPesoball;
	private JSpinner spinnerCompetiball;
	private JSpinner spinnerNidoball;
	private JTextField textPokeball;
	private JTextField textSuperball;
	private JTextField textUltraball;
	private JTextField textMasterball;
	private JTextField textMallaball;
	private JTextField textHonorball;
	private JTextField textRapidball;
	private JTextField textSafariball;
	private JTextField textOcasoball;
	private JTextField textLujoball;
	private JTextField textTurnoball;
	private JTextField textSanaball;
	private JTextField textNivelball;
	private JTextField textPesoball;
	private JTextField textCompetiball;
	private JTextField textNidoball;
	private JTextField textBuceoball;
	private JTextField textAcopioball;
	private JTextField textAmorball;
	private JTextField textVelozball;

	public VCompraPokeball(String dni) {
		setBounds(100, 100, 981, 775);
		getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 166, 128));

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
			JLabel lblLogo = new JLabel("");
			lblLogo.setBounds(423, 11, 79, 73);
			ImageIcon poke = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
	        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
	        lblLogo.setIcon (img2);
			contentPanel.add(lblLogo);
		}
		{
			PokeBall = new JButton("");
			PokeBall.setBounds(138, 122, 113, 95);
			ImageIcon pokeball = new ImageIcon(getClass().getResource("../imagenes/pokeball.png"));
	        ImageIcon imgPokeBall = new ImageIcon(pokeball.getImage().getScaledInstance(PokeBall.getWidth(), PokeBall.getHeight(), Image.SCALE_SMOOTH));
	        PokeBall.setIcon (imgPokeBall);
			contentPanel.add(PokeBall);
		}
		{
			SuperBall = new JButton("");
			SuperBall.setBounds(283, 122, 113, 95);
			ImageIcon superball = new ImageIcon(getClass().getResource("../imagenes/superball.png"));
	        ImageIcon imgSuperBall = new ImageIcon(superball.getImage().getScaledInstance(SuperBall.getWidth(), SuperBall.getHeight(), Image.SCALE_SMOOTH));
	        SuperBall.setIcon (imgSuperBall);
			contentPanel.add(SuperBall);
		}
		{
			UltraBall = new JButton("");
			UltraBall.setBounds(423, 122,113, 95);
			ImageIcon ultraball = new ImageIcon(getClass().getResource("../imagenes/ultraball.png"));
	        ImageIcon imgUltraBall = new ImageIcon(ultraball.getImage().getScaledInstance(UltraBall.getWidth(), UltraBall.getHeight(), Image.SCALE_SMOOTH));
	        UltraBall.setIcon (imgUltraBall);
			contentPanel.add(UltraBall);
		}
		{
			MasterBall = new JButton("");
			MasterBall.setBounds(557, 122, 113, 95);
			ImageIcon masterball = new ImageIcon(getClass().getResource("../imagenes/masterball.png"));
	        ImageIcon imgMasterBall = new ImageIcon(masterball.getImage().getScaledInstance(MasterBall.getWidth(), MasterBall.getHeight(), Image.SCALE_SMOOTH));
	        MasterBall.setIcon (imgMasterBall);
			contentPanel.add(MasterBall);
		}
		{
			MallaBall = new JButton("");
			MallaBall.setBounds(699, 122, 113, 95);
			ImageIcon mallaball = new ImageIcon(getClass().getResource("../imagenes/malla.png"));
	        ImageIcon imgMallaBall = new ImageIcon(mallaball.getImage().getScaledInstance(MallaBall.getWidth(), MallaBall.getHeight(), Image.SCALE_SMOOTH));
	        MallaBall.setIcon (imgMallaBall);
			contentPanel.add(MallaBall);
		}
		{
			HonorBall = new JButton("");
			HonorBall.setBounds(699, 259, 113, 95);
			ImageIcon honorball = new ImageIcon(getClass().getResource("../imagenes/honor.png"));
	        ImageIcon imgHonorBall = new ImageIcon(honorball.getImage().getScaledInstance(HonorBall.getWidth(), HonorBall.getHeight(), Image.SCALE_SMOOTH));
	        HonorBall.setIcon (imgHonorBall);
			contentPanel.add(HonorBall);
		}
		{
			RapidBall = new JButton("");
			RapidBall.setBounds(138, 395, 113, 95);
			ImageIcon rapidball = new ImageIcon(getClass().getResource("../imagenes/rapid.png"));
	        ImageIcon imgRapidBall = new ImageIcon(rapidball.getImage().getScaledInstance(RapidBall.getWidth(), RapidBall.getHeight(), Image.SCALE_SMOOTH));
	        RapidBall.setIcon (imgRapidBall);
			contentPanel.add(RapidBall);
		}
		{
			SafariBall = new JButton("");
			SafariBall.setBounds(283, 395,113, 95);
			ImageIcon safariball = new ImageIcon(getClass().getResource("../imagenes/safari.png"));
	        ImageIcon imgSafariBall = new ImageIcon(safariball.getImage().getScaledInstance(SafariBall.getWidth(), SafariBall.getHeight(), Image.SCALE_SMOOTH));
	        SafariBall.setIcon (imgSafariBall);
			contentPanel.add(SafariBall);
		}
		{
			OcasoBall = new JButton("");
			OcasoBall.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			OcasoBall.setBounds(423, 544, 113, 95);
			ImageIcon ocasoball = new ImageIcon(getClass().getResource("../imagenes/ocaso.png"));
	        ImageIcon imgOcasoBall = new ImageIcon(ocasoball.getImage().getScaledInstance(OcasoBall.getWidth(), OcasoBall.getHeight(), Image.SCALE_SMOOTH));
	        OcasoBall.setIcon (imgOcasoBall);
			contentPanel.add(OcasoBall);
		}
		{
			SanaBall = new JButton("");
			SanaBall.setBounds(423, 395, 113, 95);
			ImageIcon sanaball = new ImageIcon(getClass().getResource("../imagenes/sana.png"));
	        ImageIcon imgSanaBall = new ImageIcon(sanaball.getImage().getScaledInstance(SanaBall.getWidth(), SanaBall.getHeight(), Image.SCALE_SMOOTH));
	        SanaBall.setIcon (imgSanaBall);
			contentPanel.add(SanaBall);
		}
		{
			TurnoBall = new JButton("");
			TurnoBall.setBounds(557, 395, 113, 95);
			ImageIcon turnoball = new ImageIcon(getClass().getResource("../imagenes/turno.png"));
	        ImageIcon imgTurnoBall = new ImageIcon(turnoball.getImage().getScaledInstance(TurnoBall.getWidth(), TurnoBall.getHeight(), Image.SCALE_SMOOTH));
	        TurnoBall.setIcon (imgTurnoBall);
			contentPanel.add(TurnoBall);
		}
		{
			LujoBall = new JButton("");
			LujoBall.setBounds(557, 256, 113, 95);
			ImageIcon lujoball = new ImageIcon(getClass().getResource("../imagenes/lujo.png"));
	        ImageIcon imgLujoBall = new ImageIcon(lujoball.getImage().getScaledInstance(LujoBall.getWidth(), LujoBall.getHeight(), Image.SCALE_SMOOTH));
	        LujoBall.setIcon (imgLujoBall);
			contentPanel.add(LujoBall);
		}
		{
			NivelBall = new JButton("");
			NivelBall.setBounds(283, 544, 113, 95);
			ImageIcon nivelball = new ImageIcon(getClass().getResource("../imagenes/nivel.png"));
	        ImageIcon imgNivelBall = new ImageIcon(nivelball.getImage().getScaledInstance(NivelBall.getWidth(), NivelBall.getHeight(), Image.SCALE_SMOOTH));
	        NivelBall.setIcon (imgNivelBall);
			contentPanel.add(NivelBall);
		}
		{
			PesoBall = new JButton("");
			PesoBall.setBounds(138, 544, 113, 95);
			ImageIcon pesoball = new ImageIcon(getClass().getResource("../imagenes/peso.png"));
	        ImageIcon imgPesoBall = new ImageIcon(pesoball.getImage().getScaledInstance(PesoBall.getWidth(), PesoBall.getHeight(), Image.SCALE_SMOOTH));
	        PesoBall.setIcon (imgPesoBall);
			contentPanel.add(PesoBall);
		}
		{
			CompetiBall = new JButton("");
			CompetiBall.setBounds(283, 256, 113, 95);
			ImageIcon competiball = new ImageIcon(getClass().getResource("../imagenes/competi.png"));
	        ImageIcon imgCompetiBall = new ImageIcon(competiball.getImage().getScaledInstance(CompetiBall.getWidth(), CompetiBall.getHeight(), Image.SCALE_SMOOTH));
	        CompetiBall.setIcon (imgCompetiBall);
			contentPanel.add(CompetiBall);
		}
		{
			NidoBall = new JButton("");
			NidoBall.setBounds(699, 395, 113, 95);
			ImageIcon nidoball = new ImageIcon(getClass().getResource("../imagenes/nido.png"));
	        ImageIcon imgNidoBall = new ImageIcon(nidoball.getImage().getScaledInstance(NidoBall.getWidth(), NidoBall.getHeight(), Image.SCALE_SMOOTH));
	        NidoBall.setIcon (imgNidoBall);
			contentPanel.add(NidoBall);
		}
		{
			AcopioBall = new JButton("");
			AcopioBall.setBounds(423, 256, 113, 95);
			ImageIcon acopioball = new ImageIcon(getClass().getResource("../imagenes/acopio.png"));
	        ImageIcon imgAcopioBall = new ImageIcon(acopioball.getImage().getScaledInstance(AcopioBall.getWidth(), AcopioBall.getHeight(), Image.SCALE_SMOOTH));
	        AcopioBall.setIcon (imgAcopioBall);
			contentPanel.add(AcopioBall);
		}
		{
			BuceoBall = new JButton("");
			BuceoBall.setBounds(138, 256, 113, 95);
			ImageIcon buceoball = new ImageIcon(getClass().getResource("../imagenes/buceo.png"));
	        ImageIcon imgBuceoBall = new ImageIcon(buceoball.getImage().getScaledInstance(BuceoBall.getWidth(), BuceoBall.getHeight(), Image.SCALE_SMOOTH));
	        BuceoBall.setIcon (imgBuceoBall);
			contentPanel.add(BuceoBall);
		}
		{
			VelozBall = new JButton("");
			VelozBall.setBounds(699, 544, 113, 95);
			ImageIcon velozball = new ImageIcon(getClass().getResource("../imagenes/veloz.png"));
	        ImageIcon imgVelozBall = new ImageIcon(velozball.getImage().getScaledInstance(VelozBall.getWidth(), VelozBall.getHeight(), Image.SCALE_SMOOTH));
	        VelozBall.setIcon (imgVelozBall);
			contentPanel.add(VelozBall);
		}
		{
			AmorBall = new JButton("");
			AmorBall.setBounds(557, 544, 113, 95);
			ImageIcon amorball = new ImageIcon(getClass().getResource("../imagenes/amor.png"));
	        ImageIcon imgAmorBall = new ImageIcon(amorball.getImage().getScaledInstance(AmorBall.getWidth(), AmorBall.getHeight(), Image.SCALE_SMOOTH));
	        AmorBall.setIcon (imgAmorBall);
			contentPanel.add(AmorBall);
		}
		
		
		{
			chckbxPokeball = new JCheckBox("");
			chckbxPokeball.setBounds(148, 219, 21, 23);
			contentPanel.add(chckbxPokeball);
			
			chckbxPokeball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerPokeball.setVisible(true);
		            } else {
		            	spinnerPokeball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxSuperball = new JCheckBox("");
			chckbxSuperball.setBounds(293, 224, 21, 21);
			contentPanel.add(chckbxSuperball);
			
			chckbxSuperball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerSuperball.setVisible(true);
		            } else {
		            	spinnerSuperball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxUltraball = new JCheckBox("New check box");
			chckbxUltraball.setBounds(479, 233, 21, 21);
			contentPanel.add(chckbxUltraball);
			
			chckbxUltraball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerUltraball.setVisible(true);
		            } else {
		            	spinnerUltraball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxMasterball = new JCheckBox("New check box");
			chckbxMasterball.setBounds(645, 233, 21, 21);
			contentPanel.add(chckbxMasterball);
			
			chckbxMasterball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerMasterball.setVisible(true);
		            } else {
		            	spinnerMasterball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxMallaball = new JCheckBox("New check box");
			chckbxMallaball.setBounds(148, 358, 21, 21);
			contentPanel.add(chckbxMallaball);
			
			chckbxMallaball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerMallaball.setVisible(true);
		            } else {
		            	spinnerMallaball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxHonorball = new JCheckBox("New check box");
			chckbxHonorball.setBounds(298, 340, 21, 21);
			contentPanel.add(chckbxHonorball);
			
			chckbxHonorball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerHonorball.setVisible(true);
		            } else {
		            	spinnerHonorball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxRapidball = new JCheckBox("New check box");
			chckbxRapidball.setBounds(479, 340, 21, 21);
			contentPanel.add(chckbxRapidball);
			
			chckbxRapidball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerRapidball.setVisible(true);
		            } else {
		            	spinnerRapidball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxSafariball = new JCheckBox("New check box");
			chckbxSafariball.setBounds(645, 340, 21, 21);
			contentPanel.add(chckbxSafariball);
			
			chckbxSafariball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerSafariball.setVisible(true);
		            } else {
		            	spinnerSafariball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxOcasoball = new JCheckBox("New check box");
			chckbxOcasoball.setBounds(137, 446, 21, 21);
			contentPanel.add(chckbxOcasoball);
			
			chckbxOcasoball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerOcasoball.setVisible(true);
		            } else {
		            	spinnerOcasoball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxLujoball = new JCheckBox("New check box");
			chckbxLujoball.setBounds(298, 446, 21, 21);
			contentPanel.add(chckbxLujoball);
			
			chckbxLujoball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerLujoball.setVisible(true);
		            } else {
		            	spinnerLujoball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxTurnoball = new JCheckBox("New check box");
			chckbxTurnoball.setBounds(479, 446, 21, 21);
			contentPanel.add(chckbxTurnoball);
			
			chckbxTurnoball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerTurnoball.setVisible(true);
		            } else {
		            	spinnerTurnoball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxSanaball = new JCheckBox("New check box");
			chckbxSanaball.setBounds(645, 446, 21, 21);
			contentPanel.add(chckbxSanaball);
			
			chckbxSanaball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerSanaball.setVisible(true);
		            } else {
		            	spinnerSanaball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxNivelball = new JCheckBox("New check box");
			chckbxNivelball.setBounds(137, 554, 21, 21);
			contentPanel.add(chckbxNivelball);
			
			chckbxNivelball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerNivelball.setVisible(true);
		            } else {
		            	spinnerNivelball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxPesoball = new JCheckBox("New check box");
			chckbxPesoball.setBounds(298, 554, 21, 21);
			contentPanel.add(chckbxPesoball);
			
			chckbxPesoball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerPesoball.setVisible(true);
		            } else {
		            	spinnerPesoball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxCompetiball = new JCheckBox("New check box");
			chckbxCompetiball.setBounds(479, 554, 21, 21);
			contentPanel.add(chckbxCompetiball);
			
			chckbxCompetiball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerCompetiball.setVisible(true);
		            } else {
		            	spinnerCompetiball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxNidoball = new JCheckBox("New check box");
			chckbxNidoball.setBounds(645, 554, 21, 21);
			contentPanel.add(chckbxNidoball);
			
			chckbxNidoball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		            	spinnerNidoball.setVisible(true);
		            } else {
		            	spinnerBuceoball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxBuceoball = new JCheckBox("New check box");
			chckbxBuceoball.setBounds(137, 657, 21, 21);
			contentPanel.add(chckbxBuceoball);
			
			chckbxBuceoball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		                spinnerBuceoball.setVisible(true);
		            } else {
		            	spinnerBuceoball.setVisible(false);
		            }
		        }
		    });
		}
		{
			chckbxAcopioball = new JCheckBox("New check box");
			chckbxAcopioball.setBounds(298, 657, 21, 21);
			contentPanel.add(chckbxAcopioball);
			
			chckbxAcopioball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		                spinnerAcopioball.setVisible(true);
		            } else {
		            	spinnerAcopioball.setVisible(false);
		            }
		        }
		    });
		}
		{
		    chckbxAmorball = new JCheckBox("New check box");
		    chckbxAmorball.setBounds(479, 657, 21, 21);
		    contentPanel.add(chckbxAmorball);
		    
		    chckbxAmorball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		                spinnerAmorball.setVisible(true);
		            } else {
		                spinnerAmorball.setVisible(false);
		            }
		        }
		    });
		}

		{
		    chckbxVelozball = new JCheckBox("New check box");
		    chckbxVelozball.setBounds(645, 657, 21, 21);
		    contentPanel.add(chckbxVelozball);
		    
		    chckbxVelozball.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		                spinnerVelozball.setVisible(true);
		            } else {
		                spinnerVelozball.setVisible(false);
		            }
		        }
		    });
		}
		{
			spinnerPokeball = new JSpinner();
			spinnerPokeball.setBounds(203, 220, 48, 20);
			SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerPokeball.setModel(spinnerModel);
			spinnerPokeball.setVisible(false);
			contentPanel.add(spinnerPokeball);
		}
		{
			spinnerSuperball = new JSpinner();
			spinnerSuperball.setBounds(353, 233, 40, 20);
			SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerSuperball.setModel(spinnerModel2);
			spinnerSuperball.setVisible(false);
			contentPanel.add(spinnerSuperball);
		}
		{
			spinnerUltraball = new JSpinner();
			SpinnerNumberModel spinnerModel3 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerUltraball.setBounds(533, 233, 40, 20);
			spinnerUltraball.setModel(spinnerModel3);
			spinnerUltraball.setVisible(false);
			contentPanel.add(spinnerUltraball);
		}
		{
			spinnerMasterball = new JSpinner();
			spinnerMasterball.setBounds(706, 233, 40, 20);
			SpinnerNumberModel spinnerModel4 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerMasterball.setModel(spinnerModel4);
			spinnerMasterball.setVisible(false);
			contentPanel.add(spinnerMasterball);
		}
		{
			spinnerMallaball = new JSpinner();
			spinnerMallaball.setBounds(203, 362, 40, 20);
			SpinnerNumberModel spinnerModel5 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerMallaball.setModel(spinnerModel5);
			spinnerMallaball.setVisible(false);
			contentPanel.add(spinnerMallaball);
		}
		{
			spinnerHonorball = new JSpinner();
			spinnerHonorball.setBounds(353, 340, 40, 20);
			SpinnerNumberModel spinnerModel6 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerHonorball.setModel(spinnerModel6);
			spinnerHonorball.setVisible(false);
			contentPanel.add(spinnerHonorball);
		}
		{
			spinnerRapidball = new JSpinner();
			spinnerRapidball.setBounds(533, 340, 40, 20);
			SpinnerNumberModel spinnerModel7 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerRapidball.setModel(spinnerModel7);
			spinnerRapidball.setVisible(false);
			contentPanel.add(spinnerRapidball);
		}
		{
			spinnerSafariball = new JSpinner();
			spinnerSafariball.setBounds(700, 340, 40, 20);
			SpinnerNumberModel spinnerModel8 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerSafariball.setModel(spinnerModel8);
			spinnerSafariball.setVisible(false);
			contentPanel.add(spinnerSafariball);
		}
		{
			spinnerOcasoball = new JSpinner();
			spinnerOcasoball.setBounds(192, 446, 40, 20);
			SpinnerNumberModel spinnerModel9 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerOcasoball.setModel(spinnerModel9);
			spinnerOcasoball.setVisible(false);
			contentPanel.add(spinnerOcasoball);
		}
		{
			spinnerLujoball = new JSpinner();
			spinnerLujoball.setBounds(353, 446, 40, 20);
			SpinnerNumberModel spinnerModel10 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerLujoball.setModel(spinnerModel10);
			spinnerLujoball.setVisible(false);
			contentPanel.add(spinnerLujoball);
		}
		{
			spinnerTurnoball = new JSpinner();
			spinnerTurnoball.setBounds(533, 446, 40, 20);
			SpinnerNumberModel spinnerModel11 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerTurnoball.setModel(spinnerModel11);
			spinnerTurnoball.setVisible(false);
			contentPanel.add(spinnerTurnoball);
		}
		{
			spinnerSanaball = new JSpinner();
			spinnerSanaball.setBounds(700, 446, 40, 20);
			SpinnerNumberModel spinnerModel12 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerSanaball.setModel(spinnerModel12);
			spinnerSanaball.setVisible(false);
			contentPanel.add(spinnerSanaball);
		}
		{
			spinnerNivelball = new JSpinner();
			spinnerNivelball.setBounds(192, 555, 40, 20);
			SpinnerNumberModel spinnerModel13 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerNivelball.setModel(spinnerModel13);
			spinnerNivelball.setVisible(false);
			contentPanel.add(spinnerNivelball);
		}
		{
			spinnerPesoball = new JSpinner();
			spinnerPesoball.setBounds(353, 555, 40, 20);
			SpinnerNumberModel spinnerModel14 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerPesoball.setModel(spinnerModel14);
			spinnerPesoball.setVisible(false);
			contentPanel.add(spinnerPesoball);
		}
		{
			spinnerCompetiball = new JSpinner();
			spinnerCompetiball.setBounds(533, 555, 40, 20);
			SpinnerNumberModel spinnerModel15 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerCompetiball.setModel(spinnerModel15);
			spinnerCompetiball.setVisible(false);
			contentPanel.add(spinnerCompetiball);
		}
		{
			spinnerNidoball = new JSpinner();
			spinnerNidoball.setBounds(700, 555, 40, 20);
			SpinnerNumberModel spinnerModel16 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerNidoball.setModel(spinnerModel16);
			spinnerNidoball.setVisible(false);
			contentPanel.add(spinnerNidoball);
		}
		{
			spinnerVelozball = new JSpinner();
			spinnerVelozball.setBounds(700, 659, 40, 20);
			SpinnerNumberModel spinnerModel17 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerVelozball.setModel(spinnerModel17);
			spinnerVelozball.setVisible(false);
			contentPanel.add(spinnerVelozball);
		}
		{
			spinnerBuceoball = new JSpinner();
			spinnerBuceoball.setBounds(192, 659, 40, 20);
			SpinnerNumberModel spinnerModel18 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerBuceoball.setModel(spinnerModel18);
			spinnerBuceoball.setVisible(false);
			contentPanel.add(spinnerBuceoball);
		}
		{
			spinnerAcopioball = new JSpinner();
			spinnerAcopioball.setBounds(353, 659, 40, 20);
			SpinnerNumberModel spinnerModel19 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerAcopioball.setModel(spinnerModel19);
			spinnerAcopioball.setVisible(false);
			contentPanel.add(spinnerAcopioball);
		}
		{
			spinnerAmorball = new JSpinner();
			spinnerAmorball.setBounds(533, 659, 40, 20);
			SpinnerNumberModel spinnerModel20 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
			spinnerAmorball.setModel(spinnerModel20);
			spinnerAmorball.setVisible(false);
			contentPanel.add(spinnerAmorball);
		}
		
		textPokeball = new JTextField();
		textPokeball.setEditable(false);
		textPokeball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPokeball.setBorder(BorderFactory.createEmptyBorder());

		textPokeball.setHorizontalAlignment(SwingConstants.CENTER);
		textPokeball.setText("15€");
		
		textPokeball.setBackground(new Color(240, 240, 240));
		textPokeball.setBounds(169, 220, 35, 20);
		contentPanel.add(textPokeball);
		textPokeball.setColumns(10);
		{
			textSuperball = new JTextField();
			textSuperball.setText("30€");
			textSuperball.setHorizontalAlignment(SwingConstants.CENTER);
			textSuperball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textSuperball.setEditable(false);
			textSuperball.setColumns(10);
			textSuperball.setBorder(BorderFactory.createEmptyBorder());
			textSuperball.setBackground(UIManager.getColor("Button.background"));
			textSuperball.setBounds(320, 228, 31, 19);
			contentPanel.add(textSuperball);
		}
		{
			textUltraball = new JTextField();
			textUltraball.setText("50€");
			textUltraball.setHorizontalAlignment(SwingConstants.CENTER);
			textUltraball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textUltraball.setEditable(false);
			textUltraball.setColumns(10);
			textUltraball.setBorder(BorderFactory.createEmptyBorder());
			textUltraball.setBackground(UIManager.getColor("Button.background"));
			textUltraball.setBounds(500, 234, 30, 19);
			contentPanel.add(textUltraball);
		}
		{
			textMasterball = new JTextField();
			textMasterball.setText("100€");
			textMasterball.setHorizontalAlignment(SwingConstants.CENTER);
			textMasterball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textMasterball.setEditable(false);
			textMasterball.setColumns(10);
			textMasterball.setBorder(BorderFactory.createEmptyBorder());
			textMasterball.setBackground(UIManager.getColor("Button.background"));
			textMasterball.setBounds(664, 234, 40, 19);
			contentPanel.add(textMasterball);
		}
		{
			textMallaball = new JTextField();
			textMallaball.setText("35€");
			textMallaball.setHorizontalAlignment(SwingConstants.CENTER);
			textMallaball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textMallaball.setEditable(false);
			textMallaball.setColumns(10);
			textMallaball.setBorder(BorderFactory.createEmptyBorder());
			textMallaball.setBackground(UIManager.getColor("Button.background"));
			textMallaball.setBounds(175, 362, 30, 19);
			contentPanel.add(textMallaball);
		}
		{
			textHonorball = new JTextField();
			textHonorball.setText("20€");
			textHonorball.setHorizontalAlignment(SwingConstants.CENTER);
			textHonorball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textHonorball.setEditable(false);
			textHonorball.setColumns(10);
			textHonorball.setBorder(BorderFactory.createEmptyBorder());
			textHonorball.setBackground(UIManager.getColor("Button.background"));
			textHonorball.setBounds(319, 341, 31, 19);
			contentPanel.add(textHonorball);
		}
		{
			textRapidball = new JTextField();
			textRapidball.setText("35€");
			textRapidball.setHorizontalAlignment(SwingConstants.CENTER);
			textRapidball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textRapidball.setEditable(false);
			textRapidball.setColumns(10);
			textRapidball.setBorder(BorderFactory.createEmptyBorder());
			textRapidball.setBackground(UIManager.getColor("Button.background"));
			textRapidball.setBounds(500, 341, 30, 19);
			contentPanel.add(textRapidball);
		}
		{
			textSafariball = new JTextField();
			textSafariball.setText("25€");
			textSafariball.setHorizontalAlignment(SwingConstants.CENTER);
			textSafariball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textSafariball.setEditable(false);
			textSafariball.setColumns(10);
			textSafariball.setBorder(BorderFactory.createEmptyBorder());
			textSafariball.setBackground(UIManager.getColor("Button.background"));
			textSafariball.setBounds(666, 341, 30, 19);
			contentPanel.add(textSafariball);
		}
		{
			textOcasoball = new JTextField();
			textOcasoball.setText("40€");
			textOcasoball.setHorizontalAlignment(SwingConstants.CENTER);
			textOcasoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textOcasoball.setEditable(false);
			textOcasoball.setColumns(10);
			textOcasoball.setBorder(BorderFactory.createEmptyBorder());
			textOcasoball.setBackground(UIManager.getColor("Button.background"));
			textOcasoball.setBounds(159, 447, 30, 19);
			contentPanel.add(textOcasoball);
		}
		{
			textLujoball = new JTextField();
			textLujoball.setText("30€");
			textLujoball.setHorizontalAlignment(SwingConstants.CENTER);
			textLujoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textLujoball.setEditable(false);
			textLujoball.setColumns(10);
			textLujoball.setBorder(BorderFactory.createEmptyBorder());
			textLujoball.setBackground(UIManager.getColor("Button.background"));
			textLujoball.setBounds(320, 447, 30, 19);
			contentPanel.add(textLujoball);
		}
		{
			textTurnoball = new JTextField();
			textTurnoball.setText("45€");
			textTurnoball.setHorizontalAlignment(SwingConstants.CENTER);
			textTurnoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textTurnoball.setEditable(false);
			textTurnoball.setColumns(10);
			textTurnoball.setBorder(BorderFactory.createEmptyBorder());
			textTurnoball.setBackground(UIManager.getColor("Button.background"));
			textTurnoball.setBounds(500, 447, 30, 19);
			contentPanel.add(textTurnoball);
		}
		{
			textSanaball = new JTextField();
			textSanaball.setText("40€");
			textSanaball.setHorizontalAlignment(SwingConstants.CENTER);
			textSanaball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textSanaball.setEditable(false);
			textSanaball.setColumns(10);
			textSanaball.setBorder(BorderFactory.createEmptyBorder());
			textSanaball.setBackground(UIManager.getColor("Button.background"));
			textSanaball.setBounds(666, 447, 30, 19);
			contentPanel.add(textSanaball);
		}
		
		textNivelball = new JTextField();
		textNivelball.setText("40€");
		textNivelball.setHorizontalAlignment(SwingConstants.CENTER);
		textNivelball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNivelball.setEditable(false);
		textNivelball.setColumns(10);
		textNivelball.setBorder(BorderFactory.createEmptyBorder());
		textNivelball.setBackground(UIManager.getColor("Button.background"));
		textNivelball.setBounds(159, 556, 30, 19);
		contentPanel.add(textNivelball);
		
		textPesoball = new JTextField();
		textPesoball.setText("35€");
		textPesoball.setHorizontalAlignment(SwingConstants.CENTER);
		textPesoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPesoball.setEditable(false);
		textPesoball.setColumns(10);
		textPesoball.setBorder(BorderFactory.createEmptyBorder());
		textPesoball.setBackground(UIManager.getColor("Button.background"));
		textPesoball.setBounds(320, 556, 30, 19);
		contentPanel.add(textPesoball);
		
		textCompetiball = new JTextField();
		textCompetiball.setText("30€");
		textCompetiball.setHorizontalAlignment(SwingConstants.CENTER);
		textCompetiball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCompetiball.setEditable(false);
		textCompetiball.setColumns(10);
		textCompetiball.setBorder(BorderFactory.createEmptyBorder());
		textCompetiball.setBackground(UIManager.getColor("Button.background"));
		textCompetiball.setBounds(500, 556, 30, 19);
		contentPanel.add(textCompetiball);
		
		textNidoball = new JTextField();
		textNidoball.setText("40€");
		textNidoball.setHorizontalAlignment(SwingConstants.CENTER);
		textNidoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNidoball.setEditable(false);
		textNidoball.setColumns(10);
		textNidoball.setBorder(BorderFactory.createEmptyBorder());
		textNidoball.setBackground(UIManager.getColor("Button.background"));
		textNidoball.setBounds(667, 556, 30, 19);
		contentPanel.add(textNidoball);
		
		textBuceoball = new JTextField();
		textBuceoball.setText("35€");
		textBuceoball.setHorizontalAlignment(SwingConstants.CENTER);
		textBuceoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textBuceoball.setEditable(false);
		textBuceoball.setColumns(10);
		textBuceoball.setBorder(BorderFactory.createEmptyBorder());
		textBuceoball.setBackground(UIManager.getColor("Button.background"));
		textBuceoball.setBounds(159, 660, 30, 19);
		contentPanel.add(textBuceoball);
		
		textAcopioball = new JTextField();
		textAcopioball.setText("40€");
		textAcopioball.setHorizontalAlignment(SwingConstants.CENTER);
		textAcopioball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAcopioball.setEditable(false);
		textAcopioball.setColumns(10);
		textAcopioball.setBorder(BorderFactory.createEmptyBorder());
		textAcopioball.setBackground(UIManager.getColor("Button.background"));
		textAcopioball.setBounds(320, 660, 30, 19);
		contentPanel.add(textAcopioball);
		
		textAmorball = new JTextField();
		textAmorball.setText("35€");
		textAmorball.setHorizontalAlignment(SwingConstants.CENTER);
		textAmorball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAmorball.setEditable(false);
		textAmorball.setColumns(10);
		textAmorball.setBorder(BorderFactory.createEmptyBorder());
		textAmorball.setBackground(UIManager.getColor("Button.background"));
		textAmorball.setBounds(500, 660, 30, 19);
		contentPanel.add(textAmorball);
		
		textVelozball = new JTextField();
		textVelozball.setText("40€");
		textVelozball.setHorizontalAlignment(SwingConstants.CENTER);
		textVelozball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textVelozball.setEditable(false);
		textVelozball.setColumns(10);
		textVelozball.setBorder(BorderFactory.createEmptyBorder());
		textVelozball.setBackground(UIManager.getColor("Button.background"));
		textVelozball.setBounds(666, 660, 30, 19);
		contentPanel.add(textVelozball);
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


