import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import Clases.Adopcion;
import Clases.Animal;
import Clases.Cliente;
import Clases.Perro;

public class PanelAddAdopcion2 extends JPanel {
	private static final long serialVersionUID = -6264413841543210080L;
	
	/**
	 * Create the panel.
	 */
	JLabel lblGetNombre;
	JLabel lblGetCc;
	JLabel lblGetTelefono;
	JLabel lblGetRaza;
	JLabel lblGetId;
	JLabel lblGetTipo;
	JLabel lblBtnVolver;
	JLabel lblBtnCancelar;
	JLabel subtitulo;
	JLabel lblFechaAd;
	private String idAdopcionActual;
	private boolean modificando = false;
	private boolean vigencia = false;
	private boolean ading = false;
	
	public PanelAddAdopcion2() {
		setBackground(new Color(242, 242, 242));
		setBounds(0, 0, 1200, 720);
		setLayout(null);
		
		JPanel panelBorrar = new JPanel();
		panelBorrar.setBackground(new Color(0, 0, 255));
		panelBorrar.setBounds(0, 0, 1200, 80);
		add(panelBorrar);
		panelBorrar.setLayout(null);
		
		subtitulo = new JLabel("Adopcion");
		subtitulo.setFont(new Font("Verdana", Font.BOLD, 22));
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setBounds(0, 90, 1200, 50);
		add(subtitulo);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Verdana", Font.BOLD, 18));
		lblCliente.setBounds(100, 180, 100, 30);
		add(lblCliente);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBackground(new Color(61, 170, 190));
		panelCliente.setBounds(100, 215, 1000, 120);
		add(panelCliente);
		panelCliente.setLayout(null);
		
		JSeparator separatorv1 = new JSeparator();
		separatorv1.setForeground(new Color(255, 255, 255));
		separatorv1.setOrientation(SwingConstants.VERTICAL);
		separatorv1.setBounds(333, 0, 1, 120);
		panelCliente.add(separatorv1);
		
		JSeparator separatorv2 = new JSeparator();
		separatorv2.setOrientation(SwingConstants.VERTICAL);
		separatorv2.setForeground(Color.WHITE);
		separatorv2.setBounds(666, 0, 1, 120);
		panelCliente.add(separatorv2);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(0, 10, 333, 25);
		panelCliente.add(lblNombre);
		
		JLabel lblCc = new JLabel("CC:");
		lblCc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCc.setForeground(Color.WHITE);
		lblCc.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCc.setBounds(335, 10, 333, 25);
		panelCliente.add(lblCc);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblTelefono.setBounds(666, 10, 333, 25);
		panelCliente.add(lblTelefono);
		
		JSeparator separatorH1 = new JSeparator();
		separatorH1.setForeground(Color.WHITE);
		separatorH1.setBounds(0, 40, 1000, 1);
		panelCliente.add(separatorH1);
		
		lblGetNombre = new JLabel("");
		lblGetNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGetNombre.setForeground(new Color(255, 255, 255));
		lblGetNombre.setBounds(0, 60, 333, 30);
		panelCliente.add(lblGetNombre);
		
		lblGetCc = new JLabel("");
		lblGetCc.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetCc.setForeground(Color.WHITE);
		lblGetCc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGetCc.setBounds(333, 60, 333, 30);
		panelCliente.add(lblGetCc);
		
		lblGetTelefono = new JLabel("");
		lblGetTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetTelefono.setForeground(Color.WHITE);
		lblGetTelefono.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGetTelefono.setBounds(666, 60, 333, 30);
		panelCliente.add(lblGetTelefono);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Verdana", Font.BOLD, 18));
		lblAnimal.setBounds(100, 380, 100, 30);
		add(lblAnimal);
		
		JPanel panelAnimal = new JPanel();
		panelAnimal.setBackground(new Color(61, 170, 190));
		panelAnimal.setBounds(100, 415, 1000, 120);
		add(panelAnimal);
		panelAnimal.setLayout(null);
		
		JSeparator separatorv3 = new JSeparator();
		separatorv3.setOrientation(SwingConstants.VERTICAL);
		separatorv3.setForeground(Color.WHITE);
		separatorv3.setBounds(333, 0, 1, 120);
		panelAnimal.add(separatorv3);
		
		JSeparator separatorv4 = new JSeparator();
		separatorv4.setOrientation(SwingConstants.VERTICAL);
		separatorv4.setForeground(Color.WHITE);
		separatorv4.setBounds(666, 0, 1, 120);
		panelAnimal.add(separatorv4);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaza.setForeground(Color.WHITE);
		lblRaza.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblRaza.setBounds(0, 10, 333, 25);
		panelAnimal.add(lblRaza);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblId.setBounds(333, 10, 333, 25);
		panelAnimal.add(lblId);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblTipo.setBounds(666, 10, 333, 25);
		panelAnimal.add(lblTipo);
		
		JSeparator separatorH1_1 = new JSeparator();
		separatorH1_1.setForeground(Color.WHITE);
		separatorH1_1.setBounds(0, 40, 1000, 1);
		panelAnimal.add(separatorH1_1);
		
		lblGetRaza = new JLabel("");
		lblGetRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetRaza.setForeground(Color.WHITE);
		lblGetRaza.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGetRaza.setBounds(0, 60, 333, 30);
		panelAnimal.add(lblGetRaza);
		
		lblGetId = new JLabel("");
		lblGetId.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetId.setForeground(Color.WHITE);
		lblGetId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGetId.setBounds(333, 60, 333, 30);
		panelAnimal.add(lblGetId);
		
		lblGetTipo = new JLabel("");
		lblGetTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetTipo.setForeground(Color.WHITE);
		lblGetTipo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGetTipo.setBounds(666, 60, 333, 30);
		panelAnimal.add(lblGetTipo);
		
		lblBtnVolver = new JLabel("");
		lblBtnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBtnVolver.setIcon(new ImageIcon(PanelAddAdopcion2.class.getResource("/Imagenes/volver.png")));
		lblBtnVolver.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnVolver.setBounds(500, 660, 200, 50);
		add(lblBtnVolver);
		
		lblBtnCancelar = new JLabel("");
		lblBtnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBtnCancelar.setIcon(new ImageIcon(PanelAddAdopcion2.class.getResource("/Imagenes/cancelarAdopcion.png")));
		lblBtnCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnCancelar.setBounds(500, 580, 200, 50);
		add(lblBtnCancelar);
		
		lblFechaAd = new JLabel("");
		lblFechaAd.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblFechaAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaAd.setBounds(0, 151, 1200, 24);
		add(lblFechaAd);

	}
	
	public String getIdAdopcion() {
		return idAdopcionActual;
	}
	
	public void modifyAdopcion(Adopcion a) {
		modificando = true;
		if(!a.isVigencia()) {
			lblBtnCancelar.setVisible(false);
		}
		lblGetNombre.setText(a.getCliente().getName());
		lblGetCc.setText(a.getCliente().getCc());
		lblGetTelefono.setText(a.getCliente().getTelefono());
		lblGetRaza.setText(a.getAnimal().getRaza());
		lblGetId.setText(a.getAnimal().getId());
		String tipo = a.getAnimal() instanceof Perro ? "Perro" : "Gato";
		lblGetTipo.setText(tipo);
		idAdopcionActual = a.getId();
		subtitulo.setText(String.valueOf(idAdopcionActual));
		vigencia = a.isVigencia();
		lblFechaAd.setText(String.valueOf(a.getFechaAdopcion()));
		
	}
	public void setBotonVolver(boolean t) {
		lblBtnCancelar.setVisible(t);
	}
	
	public boolean getModificando() {
		return modificando;
	}
	
	public void setModificando(boolean a) {
		modificando = a;
	}
	
	public boolean getVigencia() {
		return vigencia;
	}
	
	public void setVigencia(boolean a) {
		vigencia = a;
	}
	
	public void setAdding(boolean a) {
		ading = a;
	}
	public boolean wasAding() {
		return ading;
	}
	
	public void getInfo(Cliente c, Animal a, Refugio r, Adopcion b) {
		
//		if(!modificando) {
//			lblBtnCancelar.setVisible(false);
//		}
		
		//Antes de poner la info, hacer la adopcion y cambiar el titulo por el id de la adopcion
		lblGetNombre.setText(c.getName());
		lblGetCc.setText(c.getCc());
		lblGetTelefono.setText(c.getTelefono());
		
		lblGetRaza.setText(a.getRaza());
		lblGetId.setText(a.getId());
		String tipo = a instanceof Perro ? "Perro" : "Gato";
		lblGetTipo.setText(tipo);
		a.setAdoptado(true);
//		idAdopcionActual = r.getAdopciones()[r.buscarAdopcionIdAnimal(a.getId())].getId();
		idAdopcionActual = b.getId();
		subtitulo.setText(idAdopcionActual);
		lblFechaAd.setText(String.valueOf(b.getFechaAdopcion()));
		
	}

}
