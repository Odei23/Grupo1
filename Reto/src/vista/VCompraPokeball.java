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
	private Usuario usu;
	
	
	public VCompraPokeball() {
		setBounds(100, 100, 913, 1012);
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
					salir();
				}
			});
		}
		{
			JButton btnCerrarSesion = new JButton("Cerrar Sesion");
			btnCerrarSesion.setBounds(747, 11, 140, 48);
			contentPanel.add(btnCerrarSesion);
			btnCerrarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrarSesion();
				}
			});
		}
		{
			JLabel lblLogo = new JLabel("");
			lblLogo.setBounds(347, 11, 155, 134);
			ImageIcon poke = new ImageIcon(getClass().getResource("logo.png"));
	        ImageIcon img2 = new ImageIcon(poke.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
	        lblLogo.setIcon (img2);
			contentPanel.add(lblLogo);
		}
		{
			PokeBall = new JButton("");
			PokeBall.setBounds(148, 169, 95, 62);
			ImageIcon pokeball = new ImageIcon(getClass().getResource("pokeball.png"));
	        ImageIcon imgPokeBall = new ImageIcon(pokeball.getImage().getScaledInstance(PokeBall.getWidth(), PokeBall.getHeight(), Image.SCALE_SMOOTH));
	        PokeBall.setIcon (imgPokeBall);
			contentPanel.add(PokeBall);
		}
		{
			SuperBall = new JButton("");
			SuperBall.setBounds(328, 169, 95, 62);
			ImageIcon superball = new ImageIcon(getClass().getResource("superball.png"));
	        ImageIcon imgSuperBall = new ImageIcon(superball.getImage().getScaledInstance(SuperBall.getWidth(), SuperBall.getHeight(), Image.SCALE_SMOOTH));
	        SuperBall.setIcon (imgSuperBall);
			contentPanel.add(SuperBall);
		}
		{
			UltraBall = new JButton("");
			UltraBall.setBounds(495, 169, 95, 62);
			ImageIcon ultraball = new ImageIcon(getClass().getResource("ultraball.png"));
	        ImageIcon imgUltraBall = new ImageIcon(ultraball.getImage().getScaledInstance(UltraBall.getWidth(), UltraBall.getHeight(), Image.SCALE_SMOOTH));
	        UltraBall.setIcon (imgUltraBall);
			contentPanel.add(UltraBall);
		}
		{
			MasterBall = new JButton("");
			MasterBall.setBounds(148, 261, 95, 62);
			ImageIcon masterball = new ImageIcon(getClass().getResource("masterball.png"));
	        ImageIcon imgMasterBall = new ImageIcon(masterball.getImage().getScaledInstance(MasterBall.getWidth(), MasterBall.getHeight(), Image.SCALE_SMOOTH));
	        MasterBall.setIcon (imgMasterBall);
			contentPanel.add(MasterBall);
		}
		{
			MallaBall = new JButton("");
			MallaBall.setBounds(328, 261, 95, 62);
			ImageIcon mallaball = new ImageIcon(getClass().getResource("malla.png"));
	        ImageIcon imgMallaBall = new ImageIcon(mallaball.getImage().getScaledInstance(MallaBall.getWidth(), MallaBall.getHeight(), Image.SCALE_SMOOTH));
	        MallaBall.setIcon (imgMallaBall);
			contentPanel.add(MallaBall);
		}
		{
			HonorBall = new JButton("");
			HonorBall.setBounds(495, 261, 95, 62);
			ImageIcon honorball = new ImageIcon(getClass().getResource("honor.png"));
	        ImageIcon imgHonorBall = new ImageIcon(honorball.getImage().getScaledInstance(HonorBall.getWidth(), HonorBall.getHeight(), Image.SCALE_SMOOTH));
	        HonorBall.setIcon (imgHonorBall);
			contentPanel.add(HonorBall);
		}
		{
			RapidBall = new JButton("");
			RapidBall.setBounds(148, 348, 95, 62);
			ImageIcon rapidball = new ImageIcon(getClass().getResource("rapid.png"));
	        ImageIcon imgRapidBall = new ImageIcon(rapidball.getImage().getScaledInstance(RapidBall.getWidth(), RapidBall.getHeight(), Image.SCALE_SMOOTH));
	        RapidBall.setIcon (imgRapidBall);
			contentPanel.add(RapidBall);
		}
		{
			SafariBall = new JButton("");
			SafariBall.setBounds(328, 348, 95, 62);
			ImageIcon safariball = new ImageIcon(getClass().getResource("safari.png"));
	        ImageIcon imgSafariBall = new ImageIcon(safariball.getImage().getScaledInstance(SafariBall.getWidth(), SafariBall.getHeight(), Image.SCALE_SMOOTH));
	        SafariBall.setIcon (imgSafariBall);
			contentPanel.add(SafariBall);
		}
		{
			OcasoBall = new JButton("");
			OcasoBall.setBounds(495, 348, 95, 62);
			ImageIcon ocasoball = new ImageIcon(getClass().getResource("ocaso.png"));
	        ImageIcon imgOcasoBall = new ImageIcon(ocasoball.getImage().getScaledInstance(OcasoBall.getWidth(), OcasoBall.getHeight(), Image.SCALE_SMOOTH));
	        OcasoBall.setIcon (imgOcasoBall);
			contentPanel.add(OcasoBall);
		}
		{
			SanaBall = new JButton("");
			SanaBall.setBounds(495, 442, 95, 62);
			ImageIcon sanaball = new ImageIcon(getClass().getResource("sana.png"));
	        ImageIcon imgSanaBall = new ImageIcon(sanaball.getImage().getScaledInstance(SanaBall.getWidth(), SanaBall.getHeight(), Image.SCALE_SMOOTH));
	        SanaBall.setIcon (imgSanaBall);
			contentPanel.add(SanaBall);
		}
		{
			TurnoBall = new JButton("");
			TurnoBall.setBounds(328, 442, 95, 62);
			ImageIcon turnoball = new ImageIcon(getClass().getResource("turno.png"));
	        ImageIcon imgTurnoBall = new ImageIcon(turnoball.getImage().getScaledInstance(TurnoBall.getWidth(), TurnoBall.getHeight(), Image.SCALE_SMOOTH));
	        TurnoBall.setIcon (imgTurnoBall);
			contentPanel.add(TurnoBall);
		}
		{
			LujoBall = new JButton("");
			LujoBall.setBounds(148, 442, 95, 62);
			ImageIcon lujoball = new ImageIcon(getClass().getResource("lujo.png"));
	        ImageIcon imgLujoBall = new ImageIcon(lujoball.getImage().getScaledInstance(LujoBall.getWidth(), LujoBall.getHeight(), Image.SCALE_SMOOTH));
	        LujoBall.setIcon (imgLujoBall);
			contentPanel.add(LujoBall);
		}
		{
			NivelBall = new JButton("");
			NivelBall.setBounds(148, 534, 95, 62);
			ImageIcon nivelball = new ImageIcon(getClass().getResource("nivel.png"));
	        ImageIcon imgNivelBall = new ImageIcon(nivelball.getImage().getScaledInstance(NivelBall.getWidth(), NivelBall.getHeight(), Image.SCALE_SMOOTH));
	        NivelBall.setIcon (imgNivelBall);
			contentPanel.add(NivelBall);
		}
		{
			PesoBall = new JButton("");
			PesoBall.setBounds(328, 534, 95, 62);
			ImageIcon pesoball = new ImageIcon(getClass().getResource("peso.png"));
	        ImageIcon imgPesoBall = new ImageIcon(pesoball.getImage().getScaledInstance(PesoBall.getWidth(), PesoBall.getHeight(), Image.SCALE_SMOOTH));
	        PesoBall.setIcon (imgPesoBall);
			contentPanel.add(PesoBall);
		}
		{
			CompetiBall = new JButton("");
			CompetiBall.setBounds(495, 534, 95, 62);
			ImageIcon competiball = new ImageIcon(getClass().getResource("competi.png"));
	        ImageIcon imgCompetiBall = new ImageIcon(competiball.getImage().getScaledInstance(CompetiBall.getWidth(), CompetiBall.getHeight(), Image.SCALE_SMOOTH));
	        CompetiBall.setIcon (imgCompetiBall);
			contentPanel.add(CompetiBall);
		}
		{
			NidoBall = new JButton("");
			NidoBall.setBounds(495, 622, 95, 62);
			ImageIcon nidoball = new ImageIcon(getClass().getResource("nido.png"));
	        ImageIcon imgNidoBall = new ImageIcon(nidoball.getImage().getScaledInstance(NidoBall.getWidth(), NidoBall.getHeight(), Image.SCALE_SMOOTH));
	        NidoBall.setIcon (imgNidoBall);
			contentPanel.add(NidoBall);
		}
		{
			AcopioBall = new JButton("");
			AcopioBall.setBounds(328, 622, 95, 62);
			ImageIcon acopioball = new ImageIcon(getClass().getResource("acopio.png"));
	        ImageIcon imgAcopioBall = new ImageIcon(acopioball.getImage().getScaledInstance(AcopioBall.getWidth(), AcopioBall.getHeight(), Image.SCALE_SMOOTH));
	        AcopioBall.setIcon (imgAcopioBall);
			contentPanel.add(AcopioBall);
		}
		{
			BuceoBall = new JButton("");
			BuceoBall.setBounds(148, 622, 95, 62);
			ImageIcon buceoball = new ImageIcon(getClass().getResource("buceo.png"));
	        ImageIcon imgBuceoBall = new ImageIcon(buceoball.getImage().getScaledInstance(BuceoBall.getWidth(), BuceoBall.getHeight(), Image.SCALE_SMOOTH));
	        BuceoBall.setIcon (imgBuceoBall);
			contentPanel.add(BuceoBall);
		}
		{
			VelozBall = new JButton("");
			VelozBall.setBounds(148, 717, 95, 62);
			ImageIcon velozball = new ImageIcon(getClass().getResource("veloz.png"));
	        ImageIcon imgVelozBall = new ImageIcon(velozball.getImage().getScaledInstance(VelozBall.getWidth(), VelozBall.getHeight(), Image.SCALE_SMOOTH));
	        VelozBall.setIcon (imgVelozBall);
			contentPanel.add(VelozBall);
		}
		{
			AmorBall = new JButton("");
			AmorBall.setBounds(328, 717, 95, 62);
			ImageIcon amorball = new ImageIcon(getClass().getResource("amor.png"));
	        ImageIcon imgAmorBall = new ImageIcon(amorball.getImage().getScaledInstance(AmorBall.getWidth(), AmorBall.getHeight(), Image.SCALE_SMOOTH));
	        AmorBall.setIcon (imgAmorBall);
			contentPanel.add(AmorBall);
		}
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
