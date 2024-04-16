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
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

public class VCompraPokeball extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton PokeBall;
	private JButton SuperBall;
	private JButton UltraBall;
	private JButton MasterBall;
	private JButton MallaBall;
	private JButton HonorBall;
	private JButton RapidBall;
	private JButton SafariBall;
	private JButton OcasoBall;
	private JButton SanaBall;
	private JButton TurnoBall;
	private JButton LujoBall;
	private JButton NivelBall;
	private JButton PesoBall;
	private JButton CompetiBall;
	private JButton NidoBall;
	private JButton AcopioBall;
	private JButton BuceoBall;
	private JButton VelozBall;
	private JButton AmorBall;
	private JLabel lblMallaball;
	private JLabel lblHonorball;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VCompraPokeball dialog = new VCompraPokeball();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VCompraPokeball() {
		setBounds(100, 100, 870, 770);
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
			btnCerrarSesion.setBounds(706, 11, 140, 48);
			contentPanel.add(btnCerrarSesion);
		}
		{
			JLabel lblLogo = new JLabel("");
			lblLogo.setBounds(353, 11, 155, 134);
			ImageIcon poke = new ImageIcon(getClass().getResource("LogoPokemon.png"));
	        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
	        lblLogo.setIcon (img2);
			contentPanel.add(lblLogo);
		}
		{
			PokeBall = new JButton("");
			PokeBall.setBounds(127, 169, 95, 62);
			ImageIcon pokeball = new ImageIcon(getClass().getResource("pokeball.png"));
	        ImageIcon imgPokeBall = new ImageIcon(pokeball.getImage().getScaledInstance(PokeBall.getWidth(), PokeBall.getHeight(), Image.SCALE_SMOOTH));
	        PokeBall.setIcon (imgPokeBall);
			contentPanel.add(PokeBall);
		}
		{
			SuperBall = new JButton("");
			SuperBall.setBounds(288, 169, 95, 62);
			ImageIcon superball = new ImageIcon(getClass().getResource("superball.png"));
	        ImageIcon imgSuperBall = new ImageIcon(superball.getImage().getScaledInstance(SuperBall.getWidth(), SuperBall.getHeight(), Image.SCALE_SMOOTH));
	        SuperBall.setIcon (imgSuperBall);
			contentPanel.add(SuperBall);
		}
		{
			UltraBall = new JButton("");
			UltraBall.setBounds(469, 169, 95, 62);
			ImageIcon ultraball = new ImageIcon(getClass().getResource("ultraball.png"));
	        ImageIcon imgUltraBall = new ImageIcon(ultraball.getImage().getScaledInstance(UltraBall.getWidth(), UltraBall.getHeight(), Image.SCALE_SMOOTH));
	        UltraBall.setIcon (imgUltraBall);
			contentPanel.add(UltraBall);
		}
		{
			MasterBall = new JButton("");
			MasterBall.setBounds(635, 169, 95, 62);
			ImageIcon masterball = new ImageIcon(getClass().getResource("masterball.png"));
	        ImageIcon imgMasterBall = new ImageIcon(masterball.getImage().getScaledInstance(MasterBall.getWidth(), MasterBall.getHeight(), Image.SCALE_SMOOTH));
	        MasterBall.setIcon (imgMasterBall);
			contentPanel.add(MasterBall);
		}
		{
			MallaBall = new JButton("");
			MallaBall.setBounds(127, 276, 95, 62);
			ImageIcon mallaball = new ImageIcon(getClass().getResource("malla.png"));
	        ImageIcon imgMallaBall = new ImageIcon(mallaball.getImage().getScaledInstance(MallaBall.getWidth(), MallaBall.getHeight(), Image.SCALE_SMOOTH));
	        MallaBall.setIcon (imgMallaBall);
			contentPanel.add(MallaBall);
		}
		{
			HonorBall = new JButton("");
			HonorBall.setBounds(288, 276, 95, 62);
			ImageIcon honorball = new ImageIcon(getClass().getResource("honor.png"));
	        ImageIcon imgHonorBall = new ImageIcon(honorball.getImage().getScaledInstance(HonorBall.getWidth(), HonorBall.getHeight(), Image.SCALE_SMOOTH));
	        HonorBall.setIcon (imgHonorBall);
			contentPanel.add(HonorBall);
		}
		{
			RapidBall = new JButton("");
			RapidBall.setBounds(469, 276, 95, 62);
			ImageIcon rapidball = new ImageIcon(getClass().getResource("rapid.png"));
	        ImageIcon imgRapidBall = new ImageIcon(rapidball.getImage().getScaledInstance(RapidBall.getWidth(), RapidBall.getHeight(), Image.SCALE_SMOOTH));
	        RapidBall.setIcon (imgRapidBall);
			contentPanel.add(RapidBall);
		}
		{
			SafariBall = new JButton("");
			SafariBall.setBounds(635, 276, 95, 62);
			ImageIcon safariball = new ImageIcon(getClass().getResource("safari.png"));
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
			OcasoBall.setBounds(127, 382, 95, 62);
			ImageIcon ocasoball = new ImageIcon(getClass().getResource("ocaso.png"));
	        ImageIcon imgOcasoBall = new ImageIcon(ocasoball.getImage().getScaledInstance(OcasoBall.getWidth(), OcasoBall.getHeight(), Image.SCALE_SMOOTH));
	        OcasoBall.setIcon (imgOcasoBall);
			contentPanel.add(OcasoBall);
		}
		{
			SanaBall = new JButton("");
			SanaBall.setBounds(635, 382, 95, 62);
			ImageIcon sanaball = new ImageIcon(getClass().getResource("sana.png"));
	        ImageIcon imgSanaBall = new ImageIcon(sanaball.getImage().getScaledInstance(SanaBall.getWidth(), SanaBall.getHeight(), Image.SCALE_SMOOTH));
	        SanaBall.setIcon (imgSanaBall);
			contentPanel.add(SanaBall);
		}
		{
			TurnoBall = new JButton("");
			TurnoBall.setBounds(469, 382, 95, 62);
			ImageIcon turnoball = new ImageIcon(getClass().getResource("turno.png"));
	        ImageIcon imgTurnoBall = new ImageIcon(turnoball.getImage().getScaledInstance(TurnoBall.getWidth(), TurnoBall.getHeight(), Image.SCALE_SMOOTH));
	        TurnoBall.setIcon (imgTurnoBall);
			contentPanel.add(TurnoBall);
		}
		{
			LujoBall = new JButton("");
			LujoBall.setBounds(288, 382, 95, 62);
			ImageIcon lujoball = new ImageIcon(getClass().getResource("lujo.png"));
	        ImageIcon imgLujoBall = new ImageIcon(lujoball.getImage().getScaledInstance(LujoBall.getWidth(), LujoBall.getHeight(), Image.SCALE_SMOOTH));
	        LujoBall.setIcon (imgLujoBall);
			contentPanel.add(LujoBall);
		}
		{
			NivelBall = new JButton("");
			NivelBall.setBounds(127, 491, 95, 62);
			ImageIcon nivelball = new ImageIcon(getClass().getResource("nivel.png"));
	        ImageIcon imgNivelBall = new ImageIcon(nivelball.getImage().getScaledInstance(NivelBall.getWidth(), NivelBall.getHeight(), Image.SCALE_SMOOTH));
	        NivelBall.setIcon (imgNivelBall);
			contentPanel.add(NivelBall);
		}
		{
			PesoBall = new JButton("");
			PesoBall.setBounds(288, 491, 95, 62);
			ImageIcon pesoball = new ImageIcon(getClass().getResource("peso.png"));
	        ImageIcon imgPesoBall = new ImageIcon(pesoball.getImage().getScaledInstance(PesoBall.getWidth(), PesoBall.getHeight(), Image.SCALE_SMOOTH));
	        PesoBall.setIcon (imgPesoBall);
			contentPanel.add(PesoBall);
		}
		{
			CompetiBall = new JButton("");
			CompetiBall.setBounds(469, 491, 95, 62);
			ImageIcon competiball = new ImageIcon(getClass().getResource("competi.png"));
	        ImageIcon imgCompetiBall = new ImageIcon(competiball.getImage().getScaledInstance(CompetiBall.getWidth(), CompetiBall.getHeight(), Image.SCALE_SMOOTH));
	        CompetiBall.setIcon (imgCompetiBall);
			contentPanel.add(CompetiBall);
		}
		{
			NidoBall = new JButton("");
			NidoBall.setBounds(635, 491, 95, 62);
			ImageIcon nidoball = new ImageIcon(getClass().getResource("nido.png"));
	        ImageIcon imgNidoBall = new ImageIcon(nidoball.getImage().getScaledInstance(NidoBall.getWidth(), NidoBall.getHeight(), Image.SCALE_SMOOTH));
	        NidoBall.setIcon (imgNidoBall);
			contentPanel.add(NidoBall);
		}
		{
			AcopioBall = new JButton("");
			AcopioBall.setBounds(288, 595, 95, 62);
			ImageIcon acopioball = new ImageIcon(getClass().getResource("acopio.png"));
	        ImageIcon imgAcopioBall = new ImageIcon(acopioball.getImage().getScaledInstance(AcopioBall.getWidth(), AcopioBall.getHeight(), Image.SCALE_SMOOTH));
	        AcopioBall.setIcon (imgAcopioBall);
			contentPanel.add(AcopioBall);
		}
		{
			BuceoBall = new JButton("");
			BuceoBall.setBounds(127, 595, 95, 62);
			ImageIcon buceoball = new ImageIcon(getClass().getResource("buceo.png"));
	        ImageIcon imgBuceoBall = new ImageIcon(buceoball.getImage().getScaledInstance(BuceoBall.getWidth(), BuceoBall.getHeight(), Image.SCALE_SMOOTH));
	        BuceoBall.setIcon (imgBuceoBall);
			contentPanel.add(BuceoBall);
		}
		{
			VelozBall = new JButton("");
			VelozBall.setBounds(635, 595, 95, 62);
			ImageIcon velozball = new ImageIcon(getClass().getResource("veloz.png"));
	        ImageIcon imgVelozBall = new ImageIcon(velozball.getImage().getScaledInstance(VelozBall.getWidth(), VelozBall.getHeight(), Image.SCALE_SMOOTH));
	        VelozBall.setIcon (imgVelozBall);
			contentPanel.add(VelozBall);
		}
		{
			AmorBall = new JButton("");
			AmorBall.setBounds(469, 595, 95, 62);
			ImageIcon amorball = new ImageIcon(getClass().getResource("amor.png"));
	        ImageIcon imgAmorBall = new ImageIcon(amorball.getImage().getScaledInstance(AmorBall.getWidth(), AmorBall.getHeight(), Image.SCALE_SMOOTH));
	        AmorBall.setIcon (imgAmorBall);
			contentPanel.add(AmorBall);
		}
		
		JLabel lblPokeball = new JLabel("15€");
		lblPokeball.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokeball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPokeball.setBounds(127, 237, 95, 13);
		contentPanel.add(lblPokeball);
		
		JLabel lblSuperball = new JLabel("30€");
		lblSuperball.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuperball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSuperball.setBounds(288, 237, 95, 13);
		contentPanel.add(lblSuperball);
		
		JLabel lblUltraball = new JLabel("50€");
		lblUltraball.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltraball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUltraball.setBounds(469, 237, 95, 13);
		contentPanel.add(lblUltraball);
		
		JLabel lblMasterball = new JLabel("100€");
		lblMasterball.setHorizontalAlignment(SwingConstants.CENTER);
		lblMasterball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMasterball.setBounds(635, 237, 95, 13);
		contentPanel.add(lblMasterball);
		{
			lblMallaball = new JLabel("35€");
			lblMallaball.setHorizontalAlignment(SwingConstants.CENTER);
			lblMallaball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblMallaball.setBounds(127, 343, 95, 13);
			contentPanel.add(lblMallaball);
		}
		{
			lblHonorball = new JLabel("20€");
			lblHonorball.setHorizontalAlignment(SwingConstants.CENTER);
			lblHonorball.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblHonorball.setBounds(288, 343, 95, 13);
			contentPanel.add(lblHonorball);
		}
		
		JLabel lblRapidball = new JLabel("35€");
		lblRapidball.setHorizontalAlignment(SwingConstants.CENTER);
		lblRapidball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRapidball.setBounds(469, 343, 95, 13);
		contentPanel.add(lblRapidball);
		
		JLabel lblSafariball = new JLabel("30€");
		lblSafariball.setHorizontalAlignment(SwingConstants.CENTER);
		lblSafariball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSafariball.setBounds(635, 343, 95, 13);
		contentPanel.add(lblSafariball);
		
		JLabel lblOcasoball = new JLabel("40€");
		lblOcasoball.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcasoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOcasoball.setBounds(127, 449, 95, 13);
		contentPanel.add(lblOcasoball);
		
		JLabel lblLujoball = new JLabel("30€");
		lblLujoball.setHorizontalAlignment(SwingConstants.CENTER);
		lblLujoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLujoball.setBounds(288, 449, 95, 13);
		contentPanel.add(lblLujoball);
		
		JLabel lblTurnoball = new JLabel("45€");
		lblTurnoball.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurnoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTurnoball.setBounds(469, 449, 95, 13);
		contentPanel.add(lblTurnoball);
		
		JLabel lblSanaball = new JLabel("20€");
		lblSanaball.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanaball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSanaball.setBounds(635, 449, 95, 13);
		contentPanel.add(lblSanaball);
		
		JLabel lblNivelball = new JLabel("40€");
		lblNivelball.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivelball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNivelball.setBounds(127, 558, 95, 13);
		contentPanel.add(lblNivelball);
		
		JLabel lblPesoball = new JLabel("35€");
		lblPesoball.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPesoball.setBounds(288, 558, 95, 13);
		contentPanel.add(lblPesoball);
		
		JLabel lblCompetiball = new JLabel("30€");
		lblCompetiball.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompetiball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCompetiball.setBounds(469, 558, 95, 13);
		contentPanel.add(lblCompetiball);
		
		JLabel lblNidoball = new JLabel("35€");
		lblNidoball.setHorizontalAlignment(SwingConstants.CENTER);
		lblNidoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNidoball.setBounds(635, 558, 95, 13);
		contentPanel.add(lblNidoball);
		
		JLabel lblBuceoball = new JLabel("40€");
		lblBuceoball.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuceoball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBuceoball.setBounds(127, 661, 95, 13);
		contentPanel.add(lblBuceoball);
		
		JLabel lblAcopioball = new JLabel("40€");
		lblAcopioball.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcopioball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAcopioball.setBounds(288, 661, 95, 13);
		contentPanel.add(lblAcopioball);
		
		JLabel lblAmorball = new JLabel("35€");
		lblAmorball.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmorball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAmorball.setBounds(469, 661, 95, 13);
		contentPanel.add(lblAmorball);
		
		JLabel lblVelozball = new JLabel("45€");
		lblVelozball.setHorizontalAlignment(SwingConstants.CENTER);
		lblVelozball.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVelozball.setBounds(635, 661, 95, 13);
		contentPanel.add(lblVelozball);
		
		
		
		JCheckBox chckbxPokeball = new JCheckBox("");
		chckbxPokeball.setBounds(137, 233, 21, 21);
		contentPanel.add(chckbxPokeball);
		{
			chckbxSuperball = new JCheckBox("");
			chckbxSuperball.setBounds(298, 233, 21, 21);
			contentPanel.add(chckbxSuperball);
		}
		{
			chckbxUltraball = new JCheckBox("New check box");
			chckbxUltraball.setBounds(479, 233, 21, 21);
			contentPanel.add(chckbxUltraball);
		}
		{
			chckbxMasterball = new JCheckBox("New check box");
			chckbxMasterball.setBounds(645, 233, 21, 21);
			contentPanel.add(chckbxMasterball);
		}
		{
			chckbxMallaball = new JCheckBox("New check box");
			chckbxMallaball.setBounds(137, 340, 21, 21);
			contentPanel.add(chckbxMallaball);
		}
		{
			chckbxHonorball = new JCheckBox("New check box");
			chckbxHonorball.setBounds(298, 340, 21, 21);
			contentPanel.add(chckbxHonorball);
		}
		{
			chckbxRapidball = new JCheckBox("New check box");
			chckbxRapidball.setBounds(479, 340, 21, 21);
			contentPanel.add(chckbxRapidball);
		}
		{
			chckbxSafariball = new JCheckBox("New check box");
			chckbxSafariball.setBounds(645, 340, 21, 21);
			contentPanel.add(chckbxSafariball);
		}
		{
			chckbxOcasoball = new JCheckBox("New check box");
			chckbxOcasoball.setBounds(137, 446, 21, 21);
			contentPanel.add(chckbxOcasoball);
		}
		{
			chckbxLujoball = new JCheckBox("New check box");
			chckbxLujoball.setBounds(298, 446, 21, 21);
			contentPanel.add(chckbxLujoball);
		}
		{
			chckbxTurnoball = new JCheckBox("New check box");
			chckbxTurnoball.setBounds(479, 446, 21, 21);
			contentPanel.add(chckbxTurnoball);
		}
		{
			chckbxSanaball = new JCheckBox("New check box");
			chckbxSanaball.setBounds(645, 446, 21, 21);
			contentPanel.add(chckbxSanaball);
		}
		{
			chckbxNivelball = new JCheckBox("New check box");
			chckbxNivelball.setBounds(137, 554, 21, 21);
			contentPanel.add(chckbxNivelball);
		}
		{
			chckbxPesoball = new JCheckBox("New check box");
			chckbxPesoball.setBounds(298, 554, 21, 21);
			contentPanel.add(chckbxPesoball);
		}
		{
			chckbxCompetiball = new JCheckBox("New check box");
			chckbxCompetiball.setBounds(479, 554, 21, 21);
			contentPanel.add(chckbxCompetiball);
		}
		{
			chckbxNidoball = new JCheckBox("New check box");
			chckbxNidoball.setBounds(645, 554, 21, 21);
			contentPanel.add(chckbxNidoball);
		}
		{
			chckbxBuceoball = new JCheckBox("New check box");
			chckbxBuceoball.setBounds(137, 657, 21, 21);
			contentPanel.add(chckbxBuceoball);
		}
		{
			chckbxAcopioball = new JCheckBox("New check box");
			chckbxAcopioball.setBounds(298, 657, 21, 21);
			contentPanel.add(chckbxAcopioball);
		}
		{
			chckbxAmorball = new JCheckBox("New check box");
			chckbxAmorball.setBounds(479, 657, 21, 21);
			contentPanel.add(chckbxAmorball);
		}
		{
			chckbxVelozball = new JCheckBox("New check box");
			chckbxVelozball.setBounds(645, 657, 21, 21);
			contentPanel.add(chckbxVelozball);
		}
		
		JSpinner spinnerPokeball = new JSpinner();
		spinnerPokeball.setBounds(192, 233, 40, 20);
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerPokeball.setModel(spinnerModel);
		contentPanel.add(spinnerPokeball);

		JSpinner spinnerSuperball = new JSpinner();
		spinnerSuperball.setBounds(353, 233, 40, 20);
		spinnerSuperball.setModel(spinnerModel);
		contentPanel.add(spinnerSuperball);

		JSpinner spinnerUltraball = new JSpinner();
		spinnerUltraball.setBounds(533, 233, 40, 20);
		spinnerUltraball.setModel(spinnerModel);
		contentPanel.add(spinnerUltraball);
		
		JSpinner spinnerMasterball = new JSpinner();
		spinnerMasterball.setBounds(706, 233, 40, 20);
		spinnerMasterball.setModel(spinnerModel);
		contentPanel.add(spinnerMasterball);
		
		JSpinner spinnerMallaball = new JSpinner();
		spinnerMallaball.setBounds(192, 340, 40, 20);
		spinnerMallaball.setModel(spinnerModel);
		contentPanel.add(spinnerMallaball);
		
		JSpinner spinnerHonorball = new JSpinner();
		spinnerHonorball.setBounds(353, 340, 40, 20);
		spinnerHonorball.setModel(spinnerModel);
		contentPanel.add(spinnerHonorball);
		
		JSpinner spinnerRapidball = new JSpinner();
		spinnerRapidball.setBounds(533, 340, 40, 20);
		spinnerRapidball.setModel(spinnerModel);
		contentPanel.add(spinnerRapidball);
		
		JSpinner spinnerSafariball = new JSpinner();
		spinnerSafariball.setBounds(700, 340, 40, 20);
		spinnerSafariball.setModel(spinnerModel);
		contentPanel.add(spinnerSafariball);
		
		JSpinner spinnerOcasoball = new JSpinner();
		spinnerOcasoball.setBounds(192, 446, 40, 20);
		spinnerOcasoball.setModel(spinnerModel);
		contentPanel.add(spinnerOcasoball);
		
		JSpinner spinnerLujoball = new JSpinner();
		spinnerLujoball.setBounds(353, 446, 40, 20);
		spinnerLujoball.setModel(spinnerModel);
		contentPanel.add(spinnerLujoball);
		
		JSpinner spinnerTurnoball = new JSpinner();
		spinnerTurnoball.setBounds(533, 446, 40, 20);
		spinnerTurnoball.setModel(spinnerModel);
		contentPanel.add(spinnerTurnoball);
		
		JSpinner spinnerSanaball = new JSpinner();
		spinnerSanaball.setBounds(700, 446, 40, 20);
		spinnerSanaball.setModel(spinnerModel);
		contentPanel.add(spinnerSanaball);
		
		JSpinner spinnerNivelball = new JSpinner();
		spinnerNivelball.setBounds(192, 555, 40, 20);
		spinnerNivelball.setModel(spinnerModel);
		contentPanel.add(spinnerNivelball);
		
		JSpinner spinnerPesoball = new JSpinner();
		spinnerPesoball.setBounds(353, 555, 40, 20);
		spinnerPesoball.setModel(spinnerModel);
		contentPanel.add(spinnerPesoball);
		
		JSpinner spinnerCompetiball = new JSpinner();
		spinnerCompetiball.setBounds(533, 555, 40, 20);
		spinnerCompetiball.setModel(spinnerModel);
		contentPanel.add(spinnerCompetiball);
		
		JSpinner spinnerNidoball = new JSpinner();
		spinnerNidoball.setBounds(700, 555, 40, 20);
		spinnerNidoball.setModel(spinnerModel);
		contentPanel.add(spinnerNidoball);
		{
			spinnerVelozball = new JSpinner();
			spinnerVelozball.setBounds(700, 659, 40, 20);
			spinnerVelozball.setModel(spinnerModel);
			contentPanel.add(spinnerVelozball);
		}
		{
			spinnerBuceoball = new JSpinner();
			spinnerBuceoball.setBounds(192, 659, 40, 20);
			spinnerBuceoball.setModel(spinnerModel);
			contentPanel.add(spinnerBuceoball);
		}
		{
			spinnerAcopioball = new JSpinner();
			spinnerAcopioball.setBounds(353, 659, 40, 20);
			spinnerAcopioball.setModel(spinnerModel);
			contentPanel.add(spinnerAcopioball);
		}
		{
			spinnerAmorball = new JSpinner();
			spinnerAmorball.setBounds(533, 659, 40, 20);
			spinnerAmorball.setModel(spinnerModel);
			contentPanel.add(spinnerAmorball);
		}
	}
}
