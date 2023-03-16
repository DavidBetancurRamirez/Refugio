import java.awt.Color;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;

import Clases.Animal;
import Clases.Cliente;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelPrincipal extends JPanel {
	private static final long serialVersionUID = -6266014414518571702L;
	
	private JSeparator separator2;
	JPanel panelAnimales;
	JPanel panelClientes;
	JPanel panelInfoAdopcion;
	JLabel labelAddAnimal;
	JLabel labelAddCliente;
	JLabel lblBtnAdoptar;
	private JTextField textFieldIdAnimal;
	private JTextField textFieldIdCliente;
	
	JLabel lblCirculoA;
	private JTextField textFieldFiltroA;
	JComboBox comboBoxTipoFiltroA;
	JComboBox comboBoxTipoA;
	JLabel lblBtnBuscarA;
	
	JLabel lblCirculoC;
	private JTextField textFieldFiltroC;
	JComboBox comboBoxTipoFiltroC;
	JLabel lblBtnBuscarC;
	
	JLabel lblCirculoAd;
	private JTextField textFieldFiltroAd;
	JComboBox comboBoxTipoFiltroAd;
	JLabel lblBtnBuscarAd;

	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		setBackground(new Color(242, 242, 242));
		setBounds(0, 0, 1200, 720);
		setLayout(null);
		
		JSeparator separator1 = new JSeparator();
		separator1.setOrientation(SwingConstants.VERTICAL);
		separator1.setBackground(new Color(0, 0, 0));
		separator1.setForeground(new Color(0, 0, 0));
		separator1.setBounds(598, 110, 2, 338);
		add(separator1);
		
		separator2 = new JSeparator();
		separator2.setForeground(new Color(0, 0, 0));
		separator2.setBackground(new Color(0, 0, 0));
		separator2.setBounds(50, 475, 1100, 2);
		add(separator2);
		
		JScrollPane scrollPaneAnimales = new JScrollPane();
		scrollPaneAnimales.setPreferredSize(new Dimension(525, 260));
		scrollPaneAnimales.setBounds(25, 188, 544, 260);
		add(scrollPaneAnimales);
		
//		JScrollPane scrollPaneAnimales = new JScrollPane();
//		scrollPaneAnimales.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPaneAnimales.setBounds(0, 0, 2, 2);
//		add(scrollPaneAnimales);
		
		panelAnimales = new JPanel();
		scrollPaneAnimales.setViewportView(panelAnimales);
		panelAnimales.setPreferredSize(new Dimension(525, 930));
		panelAnimales.setBackground(new Color(61, 170, 190));
//		add(panelAnimales);
		panelAnimales.setLayout(null);
//		add(scrollAnimal);
//		panelAnimales.setPreferredSize(new Dimension(800, 800));
	
		

		JSeparator separatorV1 = new JSeparator();
		separatorV1.setPreferredSize(new Dimension(1, 900));
		separatorV1.setForeground(new Color(255, 255, 255));
		separatorV1.setOrientation(SwingConstants.VERTICAL);
		separatorV1.setBounds(40, 0, 1, 930);
		panelAnimales.add(separatorV1);
		
		JSeparator separatorV2 = new JSeparator();
		separatorV2.setOrientation(SwingConstants.VERTICAL);
		separatorV2.setForeground(Color.WHITE);
		separatorV2.setBounds(140, 0, 1, 930);
		panelAnimales.add(separatorV2);
		
		JSeparator separatorV3 = new JSeparator();
		separatorV3.setOrientation(SwingConstants.VERTICAL);
		separatorV3.setForeground(Color.WHITE);
		separatorV3.setBounds(220, 0, 1, 930);
		panelAnimales.add(separatorV3);
		
		JSeparator separatorV4 = new JSeparator();
		separatorV4.setOrientation(SwingConstants.VERTICAL);
		separatorV4.setForeground(Color.WHITE);
		separatorV4.setBounds(410, 0, 1, 930);
		panelAnimales.add(separatorV4);
		
		JSeparator separatorV5 = new JSeparator();
		separatorV5.setOrientation(SwingConstants.VERTICAL);
		separatorV5.setForeground(Color.WHITE);
		separatorV5.setBounds(474, 0, 1, 930);
		panelAnimales.add(separatorV5);
		
		JSeparator separatorH1 = new JSeparator();
		separatorH1.setForeground(new Color(255, 255, 255));
		separatorH1.setBounds(0, 30, 525, 1);
		panelAnimales.add(separatorH1);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Verdana", Font.BOLD, 13));
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(40, 0, 100, 30);
		panelAnimales.add(lblId);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Verdana", Font.BOLD, 13));
		lblTipo.setBounds(140, 0, 80, 30);
		panelAnimales.add(lblTipo);
		
		JLabel lbllRaza = new JLabel("Raza");
		lbllRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lbllRaza.setForeground(Color.WHITE);
		lbllRaza.setFont(new Font("Verdana", Font.BOLD, 13));
		lbllRaza.setBounds(220, 0, 190, 30);
		panelAnimales.add(lbllRaza);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setFont(new Font("Verdana", Font.BOLD, 13));
		lblEdad.setBounds(410, 0, 64, 30);
		panelAnimales.add(lblEdad);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("Verdana", Font.BOLD, 13));
		lblInfo.setBounds(474, 0, 51, 30);
		panelAnimales.add(lblInfo);
		
		JScrollPane scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setPreferredSize(new Dimension(525, 260));
		scrollPaneClientes.setBounds(650, 188, 544, 260);
		add(scrollPaneClientes);
		

		panelClientes = new JPanel();
		scrollPaneClientes.setViewportView(panelClientes);
		panelClientes.setPreferredSize(new Dimension(525, 930));
		panelClientes.setBackground(new Color(61, 170, 190));
		panelClientes.setLayout(null);
		panelClientes.setLayout(null);
		
		JSeparator separatorv1 = new JSeparator();
		separatorv1.setForeground(new Color(255, 255, 255));
		separatorv1.setOrientation(SwingConstants.VERTICAL);
		separatorv1.setBounds(40, 0, 1, 930);
		panelClientes.add(separatorv1);
		
		JSeparator separatorv2 = new JSeparator();
		separatorv2.setOrientation(SwingConstants.VERTICAL);
		separatorv2.setForeground(Color.WHITE);
		separatorv2.setBounds(160, 0, 1, 930);
		panelClientes.add(separatorv2);
		
		JSeparator separatorv3 = new JSeparator();
		separatorv3.setOrientation(SwingConstants.VERTICAL);
		separatorv3.setForeground(Color.WHITE);
		separatorv3.setBounds(474, 0, 1, 930);
		panelClientes.add(separatorv3);
		
		JSeparator separatorh1 = new JSeparator();
		separatorh1.setForeground(Color.WHITE);
		separatorh1.setBounds(0, 30, 525, 1);
		panelClientes.add(separatorh1);
		
		JLabel lblCc = new JLabel("CC");
		lblCc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCc.setForeground(Color.WHITE);
		lblCc.setFont(new Font("Verdana", Font.BOLD, 13));
		lblCc.setBounds(40, 0, 120, 30);
		panelClientes.add(lblCc);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNombre.setBounds(160, 0, 314, 30);
		panelClientes.add(lblNombre);
		
		JLabel labelInfoCliente = new JLabel("Info");
		labelInfoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfoCliente.setForeground(Color.WHITE);
		labelInfoCliente.setFont(new Font("Verdana", Font.BOLD, 13));
		labelInfoCliente.setBounds(474, 0, 51, 30);
		panelClientes.add(labelInfoCliente);		
		
		JPanel panelFiltrosAnimales = new JPanel();
		panelFiltrosAnimales.setBackground(new Color(136, 218, 232));
		panelFiltrosAnimales.setBounds(25, 148, 525, 40);
		add(panelFiltrosAnimales);
		panelFiltrosAnimales.setLayout(null);
		
		//Empieza
		lblCirculoA = new JLabel("");
		lblCirculoA.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/circuloBlanco.png")));
		lblCirculoA.setHorizontalAlignment(SwingConstants.CENTER);
		lblCirculoA.setBounds(5, 6, 35, 28);
		panelFiltrosAnimales.add(lblCirculoA);
		
		textFieldFiltroA = new JTextField();
		textFieldFiltroA.setBounds(47, 6, 220, 28);
		panelFiltrosAnimales.add(textFieldFiltroA);
		textFieldFiltroA.setColumns(10);
		
		comboBoxTipoFiltroA = new JComboBox();
		comboBoxTipoFiltroA.setModel(new DefaultComboBoxModel(new String[] {"Id", "Raza", "Edad"}));
		comboBoxTipoFiltroA.setFont(new Font("Verdana", Font.PLAIN, 12));
		comboBoxTipoFiltroA.setBounds(274, 6, 60, 28);
		panelFiltrosAnimales.add(comboBoxTipoFiltroA);
		
		comboBoxTipoA = new JComboBox();
		comboBoxTipoA.setModel(new DefaultComboBoxModel(new String[] {"Perro", "Gato", "todos"}));
		comboBoxTipoA.setFont(new Font("Verdana", Font.PLAIN, 12));
		comboBoxTipoA.setBounds(341, 6, 60, 28);
		panelFiltrosAnimales.add(comboBoxTipoA);
		
		lblBtnBuscarA = new JLabel("");
		lblBtnBuscarA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBtnBuscarA.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/btnBuscar.png")));
		lblBtnBuscarA.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnBuscarA.setBounds(408, 6, 110, 28);
		panelFiltrosAnimales.add(lblBtnBuscarA);
		//Termina
		
		//Empieza Cliente Filtros
		JPanel panelFiltrosClientes = new JPanel();
		panelFiltrosClientes.setLayout(null);
		panelFiltrosClientes.setBackground(new Color(136, 218, 232));
		panelFiltrosClientes.setBounds(650, 148, 525, 40);
		add(panelFiltrosClientes);
		
		lblCirculoC = new JLabel("");
		lblCirculoC.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/circuloBlanco.png")));
		lblCirculoC.setHorizontalAlignment(SwingConstants.CENTER);
		lblCirculoC.setBounds(5, 6, 35, 28);
		panelFiltrosClientes.add(lblCirculoC);
		
		textFieldFiltroC = new JTextField();
		textFieldFiltroC.setColumns(10);
		textFieldFiltroC.setBounds(50, 6, 260, 28);
		panelFiltrosClientes.add(textFieldFiltroC);
		
		comboBoxTipoFiltroC = new JComboBox();
		comboBoxTipoFiltroC.setModel(new DefaultComboBoxModel(new String[] {"CC", "Nombre"}));
		comboBoxTipoFiltroC.setBounds(320, 6, 65, 28);
		panelFiltrosClientes.add(comboBoxTipoFiltroC);
		
		lblBtnBuscarC = new JLabel("");
		lblBtnBuscarC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBtnBuscarC.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/btnBuscar.png")));
		lblBtnBuscarC.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnBuscarC.setBounds(400, 6, 110, 28);
		panelFiltrosClientes.add(lblBtnBuscarC);
		//Termina filtros clientes
		
		JLabel tituloCllientes = new JLabel("Clientes");
		tituloCllientes.setFont(new Font("Verdana", Font.BOLD, 25));
		tituloCllientes.setHorizontalAlignment(SwingConstants.CENTER);
		tituloCllientes.setBounds(650, 110, 450, 40);
		add(tituloCllientes);
		
		JLabel tituloAnimales = new JLabel("Animales");
		tituloAnimales.setHorizontalAlignment(SwingConstants.CENTER);
		tituloAnimales.setFont(new Font("Verdana", Font.BOLD, 25));
		tituloAnimales.setBounds(25, 110, 450, 40);
		add(tituloAnimales);
		
		labelAddAnimal = new JLabel("");
		labelAddAnimal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelAddAnimal.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/add.png")));
		labelAddAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddAnimal.setForeground(new Color(0, 255, 0));
		labelAddAnimal.setBounds(430, 120, 115, 25);
		add(labelAddAnimal);
		
		labelAddCliente = new JLabel("");
		labelAddCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelAddCliente.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/add.png")));
		labelAddCliente.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddCliente.setForeground(Color.GREEN);
		labelAddCliente.setBounds(1056, 120, 115, 25);
		add(labelAddCliente);
		
		JLabel lblAdopciones = new JLabel("Adopciones");
		lblAdopciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdopciones.setFont(new Font("Verdana", Font.BOLD, 25));
		lblAdopciones.setBounds(25, 520, 450, 40);
		add(lblAdopciones);
		
		JPanel panelAdopcion = new JPanel();
		panelAdopcion.setBackground(new Color(61, 170, 190));
		panelAdopcion.setBounds(100, 580, 300, 110);
		add(panelAdopcion);
		panelAdopcion.setLayout(null);
		
		JLabel lblIdAnimal = new JLabel("IdAnimal");
		lblIdAnimal.setForeground(new Color(255, 255, 255));
		lblIdAnimal.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblIdAnimal.setBounds(30, 20, 77, 15);
		panelAdopcion.add(lblIdAnimal);
		
		JLabel lblIdCliente = new JLabel("CcCliente");
		lblIdCliente.setForeground(Color.WHITE);
		lblIdCliente.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblIdCliente.setBounds(30, 50, 77, 15);
		panelAdopcion.add(lblIdCliente);
		
		textFieldIdAnimal = new JTextField();
		textFieldIdAnimal.setBounds(120, 20, 150, 20);
		panelAdopcion.add(textFieldIdAnimal);
		textFieldIdAnimal.setColumns(10);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setColumns(10);
		textFieldIdCliente.setBounds(120, 50, 150, 20);
		panelAdopcion.add(textFieldIdCliente);
		
		lblBtnAdoptar = new JLabel("");
		lblBtnAdoptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBtnAdoptar.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/adoptar.png")));
		lblBtnAdoptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnAdoptar.setBounds(93, 78, 115, 25);
		panelAdopcion.add(lblBtnAdoptar);
		
		JScrollPane scrollPaneAdopcion = new JScrollPane();
		scrollPaneAdopcion.setPreferredSize(new Dimension(600, 175));
		scrollPaneAdopcion.setBounds(500, 535, 694, 175);
		add(scrollPaneAdopcion);
		
		
		panelInfoAdopcion = new JPanel();
		panelInfoAdopcion.setPreferredSize(new Dimension(675, 930));
		scrollPaneAdopcion.setViewportView(panelInfoAdopcion);
		panelInfoAdopcion.setBackground(new Color(61, 170, 190));
		panelInfoAdopcion.setLayout(null);
		
		JSeparator separatorV1_1 = new JSeparator();
		separatorV1_1.setPreferredSize(new Dimension(1, 900));
		separatorV1_1.setOrientation(SwingConstants.VERTICAL);
		separatorV1_1.setForeground(Color.WHITE);
		separatorV1_1.setBounds(40, 0, 1, 930);
		panelInfoAdopcion.add(separatorV1_1);
		
		JSeparator separatorH1_1 = new JSeparator();
		separatorH1_1.setForeground(Color.WHITE);
		separatorH1_1.setBounds(0, 30, 675, 1);
		panelInfoAdopcion.add(separatorH1_1);
		
		JSeparator separatorV2_1 = new JSeparator();
		separatorV2_1.setOrientation(SwingConstants.VERTICAL);
		separatorV2_1.setForeground(Color.WHITE);
		separatorV2_1.setBounds(235, 0, 1, 930);
		panelInfoAdopcion.add(separatorV2_1);
		
		JLabel lblId_1 = new JLabel("Id");
		lblId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_1.setForeground(Color.WHITE);
		lblId_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblId_1.setBounds(40, 0, 195, 30);
		panelInfoAdopcion.add(lblId_1);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnimal.setForeground(Color.WHITE);
		lblAnimal.setFont(new Font("Verdana", Font.BOLD, 13));
		lblAnimal.setBounds(235, 0, 195, 30);
		panelInfoAdopcion.add(lblAnimal);
		
		JSeparator separatorV4_1 = new JSeparator();
		separatorV4_1.setOrientation(SwingConstants.VERTICAL);
		separatorV4_1.setForeground(Color.WHITE);
		separatorV4_1.setBounds(625, 0, 1, 930);
		panelInfoAdopcion.add(separatorV4_1);
		
		JSeparator separatorV3_1 = new JSeparator();
		separatorV3_1.setOrientation(SwingConstants.VERTICAL);
		separatorV3_1.setForeground(Color.WHITE);
		separatorV3_1.setBounds(430, 0, 1, 930);
		panelInfoAdopcion.add(separatorV3_1);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setForeground(Color.WHITE);
		lblCliente.setFont(new Font("Verdana", Font.BOLD, 13));
		lblCliente.setBounds(430, 0, 195, 30);
		panelInfoAdopcion.add(lblCliente);
		
		JLabel lblId_1_1 = new JLabel("Info");
		lblId_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_1_1.setForeground(Color.WHITE);
		lblId_1_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblId_1_1.setBounds(625, 0, 50, 30);
		panelInfoAdopcion.add(lblId_1_1);
		
		//Termina
		
		JPanel panelFiltrosAdopciones = new JPanel();
		panelFiltrosAdopciones.setLayout(null);
		panelFiltrosAdopciones.setBackground(new Color(136, 218, 232));
		panelFiltrosAdopciones.setBounds(500, 495, 675, 40);
		add(panelFiltrosAdopciones);
		
		//Empieza filtros Adopcion
		lblCirculoAd = new JLabel("");
		lblCirculoAd.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/circuloBlanco.png")));
		lblCirculoAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCirculoAd.setBounds(5, 6, 35, 28);
		panelFiltrosAdopciones.add(lblCirculoAd);
		
		textFieldFiltroAd = new JTextField();
		textFieldFiltroAd.setColumns(10);
		textFieldFiltroAd.setBounds(50, 6, 340, 28);
		panelFiltrosAdopciones.add(textFieldFiltroAd);
		
		comboBoxTipoFiltroAd = new JComboBox();
		comboBoxTipoFiltroAd.setModel(new DefaultComboBoxModel(new String[] {"idAdopcion", "idAnimal", "ccCliente"}));
		comboBoxTipoFiltroAd.setBounds(405, 6, 100, 28);
		panelFiltrosAdopciones.add(comboBoxTipoFiltroAd);
		
		lblBtnBuscarAd = new JLabel("");
		lblBtnBuscarAd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBtnBuscarAd.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/btnBuscar.png")));
		lblBtnBuscarAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnBuscarAd.setBounds(530, 6, 110, 28);
		panelFiltrosAdopciones.add(lblBtnBuscarAd);
	

	}
	public Animal getAnimal(Refugio r){
		return r.getAnimales()[r.buscarAnimalId(textFieldIdAnimal.getText())];
	}
	public Cliente getCliente(Refugio r) {
		return r.getClientes()[r.buscarClienteCc(textFieldIdCliente.getText())];
	}
	
	public void changeColorCirculoA(String c) {
		lblCirculoA.setIcon(new ImageIcon(PanelPrincipal.class.getResource(c)));
	}
	public void changeColorCirculoC(String c) {
		lblCirculoC.setIcon(new ImageIcon(PanelPrincipal.class.getResource(c)));
	}
	public void changeColorCirculoAd(String c) {
		lblCirculoAd.setIcon(new ImageIcon(PanelPrincipal.class.getResource(c)));
	}
	
	public String getBusquedaA1() {
		return textFieldFiltroA.getText();
	}
	public String getBusquedaA2() {
		return String.valueOf(comboBoxTipoFiltroA.getSelectedItem());
	}
	public String getBusquedaA3() {
		return String.valueOf(comboBoxTipoA.getSelectedItem());
	}
	public boolean getBoolean2() {
		return !(String.valueOf(lblCirculoA.getIcon()).indexOf("circuloBlanco.png") != -1);
	}
	public boolean getBoolean1() {
		return (String.valueOf(lblCirculoA.getIcon()).indexOf("circuloBlancoVerde.png") != -1);
	}
	
	public String getAnimalAdopt() {
		return String.valueOf(lblCirculoA.getIcon());
	}
	
	public boolean getBoolean1C() {
		return (String.valueOf(lblCirculoC.getIcon()).indexOf("circuloBlancoVerde.png") != -1);
	}
	public boolean getBoolean2C() {
		return !(String.valueOf(lblCirculoC.getIcon()).indexOf("circuloBlanco.png") != -1);
	}
	public String getBusquedaC1() {
		return textFieldFiltroC.getText();
	}
	public String getBusquedaC2() {
		return String.valueOf(comboBoxTipoFiltroC.getSelectedItem()).toLowerCase();
	}
	
	public boolean getBoolean1Ad() {
		return (String.valueOf(lblCirculoAd.getIcon()).indexOf("circuloBlancoVerde.png") != -1);
	}
	public boolean getBoolean2Ad() {
		return !(String.valueOf(lblCirculoAd.getIcon()).indexOf("circuloBlanco.png") != -1);
	}
	public String getBusquedaAd1() {
		return textFieldFiltroAd.getText();
	}
	public String getBusquedaAd2() {
		return String.valueOf(comboBoxTipoFiltroAd.getSelectedItem());
	}
	
	public void limpiarAdopcion() {
		textFieldIdAnimal.setText("");
		textFieldIdCliente.setText("");
	}
	
	public void limpiarFiltrosBsuqueda() {
		//Limpiando filtros Animal
		lblCirculoA.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/circuloBlanco.png")));
		textFieldFiltroA.setText("");
		comboBoxTipoFiltroA.setSelectedIndex(0);
		comboBoxTipoA.setSelectedIndex(0);
		
		//Limpiando filtros Cliente
		lblCirculoC.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/circuloBlanco.png")));
		textFieldFiltroC.setText("");
		comboBoxTipoFiltroC.setSelectedIndex(0);
		
		//Limpiando filtros adopcion
		lblCirculoAd.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/circuloBlanco.png")));
		textFieldFiltroAd.setText("");
		comboBoxTipoFiltroAd.setSelectedIndex(0);
		
	}
	
	public void generateTablaAdopciones() {
		JSeparator separatorV1_1 = new JSeparator();
		separatorV1_1.setPreferredSize(new Dimension(1, 900));
		separatorV1_1.setOrientation(SwingConstants.VERTICAL);
		separatorV1_1.setForeground(Color.WHITE);
		separatorV1_1.setBounds(40, 0, 1, 930);
		panelInfoAdopcion.add(separatorV1_1);
		
		JSeparator separatorH1_1 = new JSeparator();
		separatorH1_1.setForeground(Color.WHITE);
		separatorH1_1.setBounds(0, 30, 675, 1);
		panelInfoAdopcion.add(separatorH1_1);
		
		JSeparator separatorV2_1 = new JSeparator();
		separatorV2_1.setOrientation(SwingConstants.VERTICAL);
		separatorV2_1.setForeground(Color.WHITE);
		separatorV2_1.setBounds(235, 0, 1, 930);
		panelInfoAdopcion.add(separatorV2_1);
		
		JLabel lblId_1 = new JLabel("Id");
		lblId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_1.setForeground(Color.WHITE);
		lblId_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblId_1.setBounds(40, 0, 195, 30);
		panelInfoAdopcion.add(lblId_1);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnimal.setForeground(Color.WHITE);
		lblAnimal.setFont(new Font("Verdana", Font.BOLD, 13));
		lblAnimal.setBounds(235, 0, 195, 30);
		panelInfoAdopcion.add(lblAnimal);
		
		JSeparator separatorV4_1 = new JSeparator();
		separatorV4_1.setOrientation(SwingConstants.VERTICAL);
		separatorV4_1.setForeground(Color.WHITE);
		separatorV4_1.setBounds(625, 0, 1, 930);
		panelInfoAdopcion.add(separatorV4_1);
		
		JSeparator separatorV3_1 = new JSeparator();
		separatorV3_1.setOrientation(SwingConstants.VERTICAL);
		separatorV3_1.setForeground(Color.WHITE);
		separatorV3_1.setBounds(430, 0, 1, 930);
		panelInfoAdopcion.add(separatorV3_1);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setForeground(Color.WHITE);
		lblCliente.setFont(new Font("Verdana", Font.BOLD, 13));
		lblCliente.setBounds(430, 0, 195, 30);
		panelInfoAdopcion.add(lblCliente);
		
		JLabel lblId_1_1 = new JLabel("Info");
		lblId_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_1_1.setForeground(Color.WHITE);
		lblId_1_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblId_1_1.setBounds(625, 0, 50, 30);
		panelInfoAdopcion.add(lblId_1_1);
	}
	
	
	
	public void generateTablaAnimal() {
		JSeparator separatorV1 = new JSeparator();
		separatorV1.setPreferredSize(new Dimension(1, 900));
		separatorV1.setForeground(new Color(255, 255, 255));
		separatorV1.setOrientation(SwingConstants.VERTICAL);
		separatorV1.setBounds(40, 0, 1, 930);
		panelAnimales.add(separatorV1);
		
		JSeparator separatorV2 = new JSeparator();
		separatorV2.setOrientation(SwingConstants.VERTICAL);
		separatorV2.setForeground(Color.WHITE);
		separatorV2.setBounds(140, 0, 1, 930);
		panelAnimales.add(separatorV2);
		
		JSeparator separatorV3 = new JSeparator();
		separatorV3.setOrientation(SwingConstants.VERTICAL);
		separatorV3.setForeground(Color.WHITE);
		separatorV3.setBounds(220, 0, 1, 930);
		panelAnimales.add(separatorV3);
		
		JSeparator separatorV4 = new JSeparator();
		separatorV4.setOrientation(SwingConstants.VERTICAL);
		separatorV4.setForeground(Color.WHITE);
		separatorV4.setBounds(410, 0, 1, 930);
		panelAnimales.add(separatorV4);
		
		JSeparator separatorV5 = new JSeparator();
		separatorV5.setOrientation(SwingConstants.VERTICAL);
		separatorV5.setForeground(Color.WHITE);
		separatorV5.setBounds(474, 0, 1, 930);
		panelAnimales.add(separatorV5);
		
		JSeparator separatorH1 = new JSeparator();
		separatorH1.setForeground(new Color(255, 255, 255));
		separatorH1.setBounds(0, 30, 525, 1);
		panelAnimales.add(separatorH1);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Verdana", Font.BOLD, 13));
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(40, 0, 100, 30);
		panelAnimales.add(lblId);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Verdana", Font.BOLD, 13));
		lblTipo.setBounds(140, 0, 80, 30);
		panelAnimales.add(lblTipo);
		
		JLabel lbllRaza = new JLabel("Raza");
		lbllRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lbllRaza.setForeground(Color.WHITE);
		lbllRaza.setFont(new Font("Verdana", Font.BOLD, 13));
		lbllRaza.setBounds(220, 0, 190, 30);
		panelAnimales.add(lbllRaza);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setFont(new Font("Verdana", Font.BOLD, 13));
		lblEdad.setBounds(410, 0, 64, 30);
		panelAnimales.add(lblEdad);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("Verdana", Font.BOLD, 13));
		lblInfo.setBounds(474, 0, 51, 30);
		panelAnimales.add(lblInfo);
	}

	public void generateTablaCliente() {
		JSeparator separatorv1 = new JSeparator();
		separatorv1.setForeground(new Color(255, 255, 255));
		separatorv1.setOrientation(SwingConstants.VERTICAL);
		separatorv1.setBounds(40, 0, 1, 930);
		panelClientes.add(separatorv1);
		
		JSeparator separatorv2 = new JSeparator();
		separatorv2.setOrientation(SwingConstants.VERTICAL);
		separatorv2.setForeground(Color.WHITE);
		separatorv2.setBounds(160, 0, 1, 930);
		panelClientes.add(separatorv2);
		
		JSeparator separatorv3 = new JSeparator();
		separatorv3.setOrientation(SwingConstants.VERTICAL);
		separatorv3.setForeground(Color.WHITE);
		separatorv3.setBounds(474, 0, 1, 930);
		panelClientes.add(separatorv3);
		
		JSeparator separatorh1 = new JSeparator();
		separatorh1.setForeground(Color.WHITE);
		separatorh1.setBounds(0, 30, 525, 1);
		panelClientes.add(separatorh1);
		
		JLabel lblCc = new JLabel("CC");
		lblCc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCc.setForeground(Color.WHITE);
		lblCc.setFont(new Font("Verdana", Font.BOLD, 13));
		lblCc.setBounds(40, 0, 120, 30);
		panelClientes.add(lblCc);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNombre.setBounds(160, 0, 314, 30);
		panelClientes.add(lblNombre);
		
		JLabel labelInfoCliente = new JLabel("Info");
		labelInfoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfoCliente.setForeground(Color.WHITE);
		labelInfoCliente.setFont(new Font("Verdana", Font.BOLD, 13));
		labelInfoCliente.setBounds(474, 0, 51, 30);
		panelClientes.add(labelInfoCliente);
	}
}
