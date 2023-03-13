import java.awt.Color;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Animal;
import Clases.Cliente;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Shape;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelPrincipal extends JPanel {
	private JSeparator separator2;
	JPanel panelAnimales;
	JPanel panelClientes;
	JPanel panelInfoAdopcion;
	JLabel labelAddAnimal;
	JLabel labelAddCliente;
	JLabel lblBtnAdoptar;
	private JTextField textFieldIdAnimal;
	private JTextField textFieldIdCliente;

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
//		JPanel panellsito = new JPanel();
//		panellsito.setBackground(new Color(255, 0, 0));
//		panellsito.setBounds(0, 0, 50, 50);
//		panelClientes.add(panellsito);
		
//		JScrollPane scrollPaneClientes = new JScrollPane(panelClientes);
//		panelClientes.setLayout(null);
//		scrollPaneClientes.setBounds(650, 188, 525, 260);
//		scrollPaneClientes.setLayout(null);
//		add(scrollPaneClientes);
		
		
		JPanel panelFiltrosAnimales = new JPanel();
		panelFiltrosAnimales.setBackground(new Color(136, 218, 232));
		panelFiltrosAnimales.setBounds(25, 148, 525, 40);
		add(panelFiltrosAnimales);
		panelFiltrosAnimales.setLayout(null);
		
		JPanel panelFiltrosClientes = new JPanel();
		panelFiltrosClientes.setLayout(null);
		panelFiltrosClientes.setBackground(new Color(136, 218, 232));
		panelFiltrosClientes.setBounds(650, 148, 525, 40);
		add(panelFiltrosClientes);
		
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
		
		JLabel lblIdCliente = new JLabel("IdCliente");
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
		
		//ACA
//		JSeparator separatorA1;
//		separatorA1 = new JSeparator();
//		separatorA1.setForeground(new Color(255, 255, 255));
//		separatorA1.setBounds(0, 31+30, 675, 1);
//		panelInfoAdopcion.add(separatorA1);
//		
//		String circuloRoute = "/Imagenes/circuloVerde.png";
//		JLabel labelCirculo;
//		labelCirculo = new JLabel("");
//		labelCirculo.setIcon(new ImageIcon(PanelPrincipal.class.getResource(circuloRoute)));
//		labelCirculo.setHorizontalAlignment(SwingConstants.CENTER);
//		labelCirculo.setBounds(0, 31, 39, 30);
//		panelInfoAdopcion.add(labelCirculo);
//		
//		Label labelTipo1;
//		Label labelRaza1;
//		Label labelEdad1;
//		Label labelInfo1;
//		
//		labelTipo1 = new Label("IdAdopcion");
//		labelTipo1.setAlignment(Label.CENTER);
//		labelTipo1.setForeground(new Color(255, 255, 255));
//		labelTipo1.setFont(new Font("Verdana", Font.PLAIN, 12));
//		labelTipo1.setBounds(41, 31, 194, 30);
//		panelInfoAdopcion.add(labelTipo1);
//		
//		labelRaza1 = new Label("IdAnimal");
//		labelRaza1.setAlignment(Label.CENTER);
//		labelRaza1.setForeground(Color.WHITE);
//		labelRaza1.setFont(new Font("Verdana", Font.PLAIN, 12));
//		labelRaza1.setBounds(236, 31, 194, 30);
//		panelInfoAdopcion.add(labelRaza1);
//		
//		labelEdad1 = new Label("CCcliente");
//		labelEdad1.setAlignment(Label.CENTER);
//		labelEdad1.setForeground(Color.WHITE);
//		labelEdad1.setFont(new Font("Verdana", Font.PLAIN, 12));
//		labelEdad1.setBounds(431, 31, 194, 30);
//		panelInfoAdopcion.add(labelEdad1);
//		
//		labelInfo1 = new Label("+");
//		labelInfo1.setForeground(Color.WHITE);
//		labelInfo1.setFont(new Font("Verdana", Font.PLAIN, 18));
//		labelInfo1.setAlignment(Label.CENTER);
//		labelInfo1.setBounds(626, 31, 49, 30);
//		labelInfo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		panelInfoAdopcion.add(labelInfo1);
//		
////		labelInfo1.addMouseListener(new MouseAdapter() {
////			@Override
////			public void mouseClicked(MouseEvent e) {
////				panel3.setVisible(true);
////				panel3.modifyAnimal(i);
////				panel2.setVisible(false);
////				contentPane.add(panel3);
////			}
////		});
		
		//Termina
		JPanel panelFiltrosAdopciones = new JPanel();
		panelFiltrosAdopciones.setLayout(null);
		panelFiltrosAdopciones.setBackground(new Color(136, 218, 232));
		panelFiltrosAdopciones.setBounds(500, 495, 675, 40);
		add(panelFiltrosAdopciones);
	

	}
	public Animal getAnimal(Refugio r){
		return r.getAnimales()[r.buscarAnimalId(textFieldIdAnimal.getText())];
	}
	public Cliente getCliente(Refugio r) {
		return r.getClientes()[r.buscarClienteCc(textFieldIdCliente.getText())];
	}
	
	public void limpiarAdopcion() {
		textFieldIdAnimal.setText("");
		textFieldIdCliente.setText("");
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
