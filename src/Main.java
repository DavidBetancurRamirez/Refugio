import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import Clases.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main extends JFrame {
	private static final long serialVersionUID = -1409088358716355451L;
	
	private JPanel contentPane;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	PanelBloqueado panel1 = new PanelBloqueado();
	PanelPrincipal panel2 = new PanelPrincipal();
	PanelAddAnimal panel3 = new PanelAddAnimal();
	PanelAddCliente panel4 = new PanelAddCliente();
//	PanelAddAdopcion panel5 = new PanelAddAdopcion();
	PanelAddAdopcion2 panel6 = new PanelAddAdopcion2();
	
	private String[] circuloColorFiltroA = {"/Imagenes/circuloBlanco.png", "/Imagenes/circuloBlancoVerde.png", "/Imagenes/circuloBlancoRojo.png"};
	int indexColorBuquedaA = 0;
	
	private String[] circuloColorFiltroB = {"/Imagenes/circuloBlanco.png", "/Imagenes/circuloBlancoVerde.png", "/Imagenes/circuloBlancoRojo.png"};
	int indexColorBuquedaB = 0;
	
	private String[] circuloColorFiltroAd = {"/Imagenes/circuloBlanco.png", "/Imagenes/circuloBlancoVerde.png", "/Imagenes/circuloBlancoRojo.png"};
	int indexColorBusquedaAd = 0;
	
	
	
	Refugio refugio = new Refugio(30);
	File ruta = new File("src\\Ficheros");
	
	public Main() {
		setLocationByPlatform(true);
		setUndecorated(true);
		setTitle("Refugio patitas perdidas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(136, 218, 232));
		header.setBounds(0, 0, 1200, 80);
		header.setLayout(null);
		
		JLabel titulo = new JLabel("Refugio");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 30));
		titulo.setBounds(0, 0, 1184, 80);
		
		panel1.btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(String.valueOf(panel1.passwordField.getPassword()).equals("sistemaslomejor")) {
					contentPane.add(header);
					header.add(titulo);
					panelPrincipal(panel1);
				}
				else {
					panel1.error.setText("Codigo incorrecto");
				}
			}
		});
		
		
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		panelHeader.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});
		panelHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panelHeader.setBounds(0, 0, 1200, 42);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		
		JPanel panelClose = new JPanel();
		panelClose.setBackground(new Color(136, 218, 232));
		panelClose.setBounds(0, 0, 42, 42);
		panelHeader.add(panelClose);
		panelClose.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 42, 42);
		panelClose.add(lblNewLabel);
		
		panelClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panelClose.setBackground(new Color(255, 0, 0));
				lblNewLabel.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelClose.setBackground(new Color(136, 218, 232));
				lblNewLabel.setForeground(new Color(0, 0, 0));
			}
		});
		
		panel2.lblCirculoA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel2.changeColorCirculoA(circuloColorFiltroA[++indexColorBuquedaA]);
				if(indexColorBuquedaA == 2) {
					indexColorBuquedaA = -1;
				}
			}
		});
		
		panel2.lblCirculoC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel2.changeColorCirculoC(circuloColorFiltroB[++indexColorBuquedaB]);
				if(indexColorBuquedaB == 2) {
					indexColorBuquedaB = -1;
				}
			}
		});
		
		panel2.lblCirculoAd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel2.changeColorCirculoAd(circuloColorFiltroAd[++indexColorBusquedaAd]);
				if(indexColorBusquedaAd == 2) {
					indexColorBusquedaAd = -1;
				}
			}
		});
		
		panel2.lblBtnBuscarA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					boolean primerBool = true;
					if(panel2.getBoolean2()) {
						primerBool = panel2.getBoolean1();
					}
					Animal[] animalitos = refugio.buscarAnimales(primerBool, panel2.getBusquedaA1(), panel2.getBusquedaA2().toLowerCase(), panel2.getBusquedaA3(), panel2.getBoolean2());
					pintarAnimalesFiltro(animalitos);
				}
				catch(EParamNoValidos error) {
					JOptionPane.showMessageDialog(panel2, error.getMessage());
				}
				catch(ENoEncontrado error) {
					JOptionPane.showMessageDialog(panel2, error.getMessage());
				}
				
			}
		});
		
		panel2.lblBtnBuscarC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					boolean primerBool = true;
					if(panel2.getBoolean2C()) {
						primerBool = panel2.getBoolean1C();
					}
					Cliente[] clientitos = refugio.buscarCliente(primerBool,panel2.getBusquedaC1(),panel2.getBusquedaC2(), panel2.getBoolean2C());
					pintarClientesFiltro(clientitos);
				}
				catch(ENoEncontrado error) {
					JOptionPane.showMessageDialog(panel2, error.getMessage());
				}
			}
		});
		
		panel2.lblBtnBuscarAd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					boolean primerBool = true;
					if(panel2.getBoolean2Ad()) {
						primerBool = panel2.getBoolean1Ad();
					}
					Adopcion[] adopcionsitas = refugio.buscarAdopcion(primerBool, panel2.getBusquedaAd1(), panel2.getBusquedaAd2(), panel2.getBoolean2Ad());
					pintarAdopcionesFiltro(adopcionsitas);
				}
				catch(ENoEncontrado error) {
					JOptionPane.showMessageDialog(panel2, error.getMessage());
				}
			}
		});
		
		panel2.labelAddAnimal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel3.setVisible(true);
				panel2.setVisible(false);
				contentPane.add(panel3);
			}
		});
		
		panel2.labelAddCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel4.setVisible(true);
				panel2.setVisible(false);
				contentPane.add(panel4);
			}
		});
		
		panel2.lblBtnAdoptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Adopcion a = refugio.adoptarAnimal(panel2.getCliente(refugio).getCc(), panel2.getAnimal(refugio).getId());
					panel6.getInfo(panel2.getCliente(refugio), panel2.getAnimal(refugio), refugio, a);
					refugio.subirAnimales(ruta);
					refugio.subirAdopciones(ruta);
					panel6.setVisible(true);
					panel2.setVisible(false);
					panel6.setAdding(true);
					contentPane.add(panel6);
				}
				catch(EParamNoValidos error) {
					JOptionPane.showMessageDialog(panel2, error.getMessage());
				}
				catch(ENoEncontrado error) {
					JOptionPane.showMessageDialog(panel2, error.getMessage());
				}
				catch(EAdopcion error) {
					JOptionPane.showMessageDialog(panel2, error.getMessage());
				}
				catch(IOException error) {
					JOptionPane.showMessageDialog(panel2, "Datos incompletos al cargar la informacion, vuelva a intentar");
				} 
				
			}
		});
		
		panel6.lblBtnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try	{
					refugio.subirAdopciones(ruta);
					panelPrincipal(panel6);		
					panel6.setModificando(false);
					panel6.setVigencia(false);
					panel6.setAdding(false);
					panel6.setBotonVolver(true);
				}
				catch(EParamNoValidos error) {
					JOptionPane.showMessageDialog(panel6, error.getMessage());
				}
				catch(IOException error) {
					JOptionPane.showMessageDialog(panel6, "Datos incompletos al cargar la informacion, vuelva a intentar");
				} 
			}
		});
		
		panel6.lblBtnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if((panel6.getModificando() && panel6.getVigencia()) || panel6.wasAding()) {
						refugio.reingresoAnimal(refugio.getAdopciones()[refugio.buscarAdopcionId(panel6.getIdAdopcion())]);
					}
					refugio.subirAdopciones(ruta);
					refugio.subirAnimales(ruta);
					panelPrincipal(panel6);
					panel6.setModificando(false);
					panel6.setVigencia(false);
					panel6.setAdding(false);
				} 
				catch(EParamNoValidos error) {
					JOptionPane.showMessageDialog(panel3, error.getMessage());
				}
				catch(ENoEncontrado error) {
					JOptionPane.showMessageDialog(panel3, error.getMessage());
				}
				catch(ESinEspacio error) {
					JOptionPane.showMessageDialog(panel3, error.getMessage());
				}
				catch(IOException error) {
					JOptionPane.showMessageDialog(panel2, "Datos incompletos al cargar la informacion, vuelva a intentar");
				} 
			}
		});
		
		panel3.lblBtnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelPrincipal(panel3);
				panel3.limpiarCasillas();
			}
		});
		
		panel4.lblBtnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelPrincipal(panel4);
				panel4.limpiarCasillas();
			}
		});
		
		panel3.lblBtnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(panel3.modificando) {
						refugio.modAnimal(refugio.getAnimales()[refugio.buscarAnimalId(panel3.id)], panel3.getRaza(), panel3.getRecomendaciones(), panel3.getEdad(), panel3.getCantComida(), panel3.alim, panel3.getEnfermedades());
					}
					else {						
						refugio.addAnimal(panel3.getRaza(), panel3.getRecomendaciones(), panel3.getEdad(), panel3.getCantComida(), panel3.getEspecial(), panel3.getEnfermedades(), panel3.isPerro());
					}
					refugio.subirAnimales(ruta);
					panelPrincipal(panel3);
					panel3.limpiarCasillas();
				}
				catch(NumberFormatException error) {
					JOptionPane.showMessageDialog(panel3, "La cantidad no es valida");
				}
				catch(ENoEncontrado error) {
					JOptionPane.showMessageDialog(panel3, error.getMessage());
				}
				catch(EParamNoValidos error) {
					JOptionPane.showMessageDialog(panel3, error.getMessage());
				}
				catch(ESinEspacio error) {
					JOptionPane.showMessageDialog(panel3, error.getMessage());
				}
				catch(IOException error) {
					//Aca hay una alerta
					JOptionPane.showMessageDialog(panel2, "Datos incompletos al cargar la informacion, vuelva a intentar");
				}
			}
		});
		
		panel4.lblBtnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(panel4.getModificando()) {
						refugio.modCliente(panel4.getAnteriorCliente(), panel4.getCc(), panel4.getNombre(), panel4.getTelefono(), panel4.getPreguntas());
					}
					else {						
						refugio.addCliente(panel4.getCc(), panel4.getNombre(), panel4.getTelefono(), panel4.getPreguntas());
					}
					refugio.subirClientes(ruta);
					panelPrincipal(panel4);
					panel4.limpiarCasillas();
				}
				catch(EParamNoValidos error) {
					JOptionPane.showMessageDialog(panel4, error.getMessage());
				}
				catch(ENoEncontrado error) {
					JOptionPane.showMessageDialog(panel3, error.getMessage());
				}
				catch(IOException error) {
					//Aca hay una alerta
					JOptionPane.showMessageDialog(panel2, "Datos incompletos al cargar la informacion, vuelva a intentar");
				}
			}
		});
		
		contentPane.add(panel1);
	}
	
	private void panelPrincipal(JPanel panelAnterior) {
		try {			
			refugio.cargarAnimales(ruta);
			refugio.cargarClientes(ruta);
			refugio.cargarAdopciones(ruta);
		}
		catch(ClassNotFoundException e) {
			//Aca hay una alerta
			JOptionPane.showMessageDialog(panel2, "Ha ocurrido un error en el programa \n Vuelva a intentar \n \n "
					+ "Error: ClassPath missing");
		}
		catch(IOException e) {
			//Aca hay una alerta
			JOptionPane.showMessageDialog(panel2, "Datos incompletos al cargar la informacion, vuelva a intentar");
		}
		
		//Null = blanco , true = rojo, false = verde
		
		limpiarPanelPrincipal();
		pintarAnimalesClientes();
		indexColorBuquedaA = 0;
		indexColorBuquedaB = 0;
		indexColorBusquedaAd = 0;
		
		panel2.setVisible(true);
		panelAnterior.setVisible(false);
		contentPane.add(panel2);
	}
	
	public void pintarAnimalesClientes() {
		JSeparator separatorA1;
		Label labelId1;
		Label labelTipo1;
		Label labelRaza1;
		Label labelEdad1;
		Label labelInfo1;
		JLabel labelCirculo;
		
		Animal[] siAdoptados = new Animal[0];
		Animal[] noAdoptados = new Animal[0];
		for(Animal i : refugio.getAnimales()) {
			if(!i.isAdoptado()) {
				noAdoptados = Arrays.copyOf(noAdoptados, noAdoptados.length+1);
				noAdoptados[noAdoptados.length-1] = i;
				continue;
			}
			siAdoptados = Arrays.copyOf(siAdoptados, siAdoptados.length+1);
			siAdoptados[siAdoptados.length-1] = i;
			
		}
		Animal[] animalitos = new Animal[refugio.getAnimales().length];
		System.arraycopy(noAdoptados, 0, animalitos, 0, noAdoptados.length);
		System.arraycopy(siAdoptados, 0, animalitos, noAdoptados.length, siAdoptados.length);
		
		Cliente[] siAptos = new Cliente[0];
		Cliente[] noAptos = new Cliente[0];
		for(Cliente i : refugio.getClientes()) {
			if(i.isAptoAdoptar()) {
				siAptos = Arrays.copyOf(siAptos, siAptos.length+1);
				siAptos[siAptos.length-1] = i;
				continue;
			}
			noAptos = Arrays.copyOf(noAptos, noAptos.length+1);
			noAptos[noAptos.length-1] = i;
		}
		Cliente[] clientitos = new Cliente[refugio.getClientes().length];
		System.arraycopy(siAptos, 0, clientitos, 0, siAptos.length);
		System.arraycopy(noAptos, 0, clientitos, siAptos.length, noAptos.length);
		
		Adopcion[] adopVig = new Adopcion[0];
		Adopcion[] adopNoVig = new Adopcion[0];
		for(Adopcion i : refugio.getAdopciones()) {
			if(i.isVigencia()) {
				adopVig = Arrays.copyOf(adopVig, adopVig.length + 1);
				adopVig[adopVig.length-1] = i;
				continue;
			}
			adopNoVig = Arrays.copyOf(adopNoVig, adopNoVig.length+1);
			adopNoVig[adopNoVig.length-1] = i;
		}
		Adopcion[] adopcionsitas = new Adopcion[refugio.getAdopciones().length];
		System.arraycopy(adopVig, 0, adopcionsitas, 0, adopVig.length);
		System.arraycopy(adopNoVig, 0, adopcionsitas, adopVig.length, adopNoVig.length);
	
		
		int coordenada = 31;
		for(Animal i : animalitos) {
			separatorA1 = new JSeparator();
			separatorA1.setForeground(new Color(255, 255, 255));
			separatorA1.setBounds(0, coordenada+30, 525, 1);
			panel2.panelAnimales.add(separatorA1);
			
			labelId1 = new Label(i.getId());
			labelId1.setForeground(new Color(255, 255, 255));
			labelId1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelId1.setBounds(41, coordenada, 99, 30);
			panel2.panelAnimales.add(labelId1);
			
			String tipoAnimal = i instanceof Perro ? "Perro" : "Gato";
			labelTipo1 = new Label(tipoAnimal);
			labelTipo1.setForeground(new Color(255, 255, 255));
			labelTipo1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelTipo1.setBounds(141, coordenada, 79, 30);
			panel2.panelAnimales.add(labelTipo1);
			
			labelRaza1 = new Label(i.getRaza());
			labelRaza1.setForeground(Color.WHITE);
			labelRaza1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelRaza1.setBounds(221, coordenada, 189, 30);
			panel2.panelAnimales.add(labelRaza1);
			
			labelEdad1 = new Label(String.valueOf(i.getEdad()));
			labelEdad1.setAlignment(Label.CENTER);
			labelEdad1.setForeground(Color.WHITE);
			labelEdad1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelEdad1.setBounds(411, coordenada, 63, 30);
			panel2.panelAnimales.add(labelEdad1);
			
			labelInfo1 = new Label("+");
			labelInfo1.setForeground(Color.WHITE);
			labelInfo1.setFont(new Font("Verdana", Font.PLAIN, 18));
			labelInfo1.setAlignment(Label.CENTER);
			labelInfo1.setBounds(475, coordenada, 50, 30);
			labelInfo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panel2.panelAnimales.add(labelInfo1);
			
			labelInfo1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel3.setVisible(true);
					panel3.modifyAnimal(i);
					panel2.setVisible(false);
					contentPane.add(panel3);
				}
			});
			
			String circuloRoute = i.isAdoptado() ? "/Imagenes/circuloRojo.png": "/Imagenes/circuloVerde.png";
			labelCirculo = new JLabel("");
			labelCirculo.setIcon(new ImageIcon(PanelPrincipal.class.getResource(circuloRoute)));
			labelCirculo.setHorizontalAlignment(SwingConstants.CENTER);
			labelCirculo.setBounds(0, coordenada, 39, 30);
			panel2.panelAnimales.add(labelCirculo);
			
			coordenada += 30;
		}
		
		coordenada = 31;
		for(Cliente i : clientitos) {
			separatorA1 = new JSeparator();
			separatorA1.setForeground(new Color(255, 255, 255));
			separatorA1.setBounds(0, coordenada+30, 525, 1);
			panel2.panelClientes.add(separatorA1);
			
			labelId1 = new Label(i.getCc());
			labelId1.setForeground(new Color(255, 255, 255));
			labelId1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelId1.setBounds(41, coordenada, 119, 30);
			panel2.panelClientes.add(labelId1);
			
			labelRaza1 = new Label(i.getName());
			labelRaza1.setForeground(Color.WHITE);
			labelRaza1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelRaza1.setBounds(161, coordenada, 313, 30);
			panel2.panelClientes.add(labelRaza1);
			
			labelInfo1 = new Label("+");
			labelInfo1.setForeground(Color.WHITE);
			labelInfo1.setFont(new Font("Verdana", Font.PLAIN, 18));
			labelInfo1.setAlignment(Label.CENTER);
			labelInfo1.setBounds(475, coordenada, 50, 30);
			labelInfo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panel2.panelClientes.add(labelInfo1);
			
			labelInfo1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel4.setVisible(true);
					panel4.modifyClient(i);
					panel2.setVisible(false);
					contentPane.add(panel4);
				}
			});
			
			String circuloRoute = i.isAptoAdoptar() ? "/Imagenes/circuloVerde.png" : "/Imagenes/circuloRojo.png";
			labelCirculo = new JLabel("");
			labelCirculo.setIcon(new ImageIcon(PanelPrincipal.class.getResource(circuloRoute)));
			labelCirculo.setHorizontalAlignment(SwingConstants.CENTER);
			labelCirculo.setBounds(0, coordenada, 39, 30);
			panel2.panelClientes.add(labelCirculo);
			
			coordenada += 30;
		}
		
		coordenada = 31;
		for(Adopcion i : adopcionsitas) {
			
			separatorA1 = new JSeparator();
			separatorA1.setForeground(new Color(255, 255, 255));
			separatorA1.setBounds(0, coordenada+30, 675, 1);
			panel2.panelInfoAdopcion.add(separatorA1);
			
			String circuloRoute = i.isVigencia() ? "/Imagenes/circuloVerde.png" : "/Imagenes/circuloRojo.png";
			labelCirculo = new JLabel("");
			labelCirculo.setIcon(new ImageIcon(PanelPrincipal.class.getResource(circuloRoute)));
			labelCirculo.setHorizontalAlignment(SwingConstants.CENTER);
			labelCirculo.setBounds(0, coordenada, 39, 30);
			panel2.panelInfoAdopcion.add(labelCirculo);
			
			labelTipo1 = new Label(i.getId());
			labelTipo1.setAlignment(Label.CENTER);
			labelTipo1.setForeground(new Color(255, 255, 255));
			labelTipo1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelTipo1.setBounds(41, coordenada, 194, 30);
			panel2.panelInfoAdopcion.add(labelTipo1);
			
			labelRaza1 = new Label(i.getAnimal().getId());
			labelRaza1.setAlignment(Label.CENTER);
			labelRaza1.setForeground(Color.WHITE);
			labelRaza1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelRaza1.setBounds(236, coordenada, 194, 30);
			panel2.panelInfoAdopcion.add(labelRaza1);
			
			labelEdad1 = new Label(i.getCliente().getCc());
			labelEdad1.setAlignment(Label.CENTER);
			labelEdad1.setForeground(Color.WHITE);
			labelEdad1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelEdad1.setBounds(431, coordenada, 194, 30);
			panel2.panelInfoAdopcion.add(labelEdad1);
			
			labelInfo1 = new Label("+");
			labelInfo1.setForeground(Color.WHITE);
			labelInfo1.setFont(new Font("Verdana", Font.PLAIN, 18));
			labelInfo1.setAlignment(Label.CENTER);
			labelInfo1.setBounds(626, coordenada, 49, 30);
			labelInfo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panel2.panelInfoAdopcion.add(labelInfo1);
			
			labelInfo1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel6.setVisible(true);
					panel6.modifyAdopcion(i);
					panel2.setVisible(false);
					contentPane.add(panel6);
				}
			});
			coordenada += 30;
		}
	}
	
	public void limpiarPanelPrincipal() {
		//Limpiar solo los componentes de la tabla de animal y clientes
		//Limpiar todo y desp afregar los componenetes staticos de las tablas
		panel2.panelAnimales.removeAll();
		panel2.panelClientes.removeAll();
		panel2.panelInfoAdopcion.removeAll();
		panel2.generateTablaAnimal();
		panel2.generateTablaCliente();
		panel2.generateTablaAdopciones();
		panel2.limpiarAdopcion();
		panel2.limpiarFiltrosBsuqueda();
	}
	
	
	public void pintarAnimalesFiltro(Animal[] animales) {
		panel2.panelAnimales.removeAll();
		panel2.generateTablaAnimal();
		
		JSeparator separatorA1;
		Label labelId1;
		Label labelTipo1;
		Label labelRaza1;
		Label labelEdad1;
		Label labelInfo1;
		JLabel labelCirculo;
		
		int coordenada = 31;
		for(Animal i : animales) {
			separatorA1 = new JSeparator();
			separatorA1.setForeground(new Color(255, 255, 255));
			separatorA1.setBounds(0, coordenada+30, 525, 1);
			panel2.panelAnimales.add(separatorA1);
			
			labelId1 = new Label(i.getId());
			labelId1.setForeground(new Color(255, 255, 255));
			labelId1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelId1.setBounds(41, coordenada, 99, 30);
			panel2.panelAnimales.add(labelId1);
			
			String tipoAnimal = i instanceof Perro ? "Perro" : "Gato";
			labelTipo1 = new Label(tipoAnimal);
			labelTipo1.setForeground(new Color(255, 255, 255));
			labelTipo1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelTipo1.setBounds(141, coordenada, 79, 30);
			panel2.panelAnimales.add(labelTipo1);
			
			labelRaza1 = new Label(i.getRaza());
			labelRaza1.setForeground(Color.WHITE);
			labelRaza1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelRaza1.setBounds(221, coordenada, 189, 30);
			panel2.panelAnimales.add(labelRaza1);
			
			labelEdad1 = new Label(String.valueOf(i.getEdad()));
			labelEdad1.setAlignment(Label.CENTER);
			labelEdad1.setForeground(Color.WHITE);
			labelEdad1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelEdad1.setBounds(411, coordenada, 63, 30);
			panel2.panelAnimales.add(labelEdad1);
			
			labelInfo1 = new Label("+");
			labelInfo1.setForeground(Color.WHITE);
			labelInfo1.setFont(new Font("Verdana", Font.PLAIN, 18));
			labelInfo1.setAlignment(Label.CENTER);
			labelInfo1.setBounds(475, coordenada, 50, 30);
			labelInfo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panel2.panelAnimales.add(labelInfo1);
			
			labelInfo1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel3.setVisible(true);
					panel3.modifyAnimal(i);
					panel2.setVisible(false);
					contentPane.add(panel3);
				}
			});
			
			String circuloRoute = i.isAdoptado() ? "/Imagenes/circuloRojo.png": "/Imagenes/circuloVerde.png";
			labelCirculo = new JLabel("");
			labelCirculo.setIcon(new ImageIcon(PanelPrincipal.class.getResource(circuloRoute)));
			labelCirculo.setHorizontalAlignment(SwingConstants.CENTER);
			labelCirculo.setBounds(0, coordenada, 39, 30);
			panel2.panelAnimales.add(labelCirculo);
			
			coordenada += 30;
		}
	}
	
	public void pintarClientesFiltro(Cliente[] clientes) {
		panel2.panelClientes.removeAll();
		panel2.generateTablaCliente();
		
		JSeparator separatorA1;
		Label labelId1;
		Label labelTipo1;
		Label labelRaza1;
		Label labelEdad1;
		Label labelInfo1;
		JLabel labelCirculo;
		
		int coordenada = 31;
		for(Cliente i : clientes) {
			separatorA1 = new JSeparator();
			separatorA1.setForeground(new Color(255, 255, 255));
			separatorA1.setBounds(0, coordenada+30, 525, 1);
			panel2.panelClientes.add(separatorA1);
			
			labelId1 = new Label(i.getCc());
			labelId1.setForeground(new Color(255, 255, 255));
			labelId1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelId1.setBounds(41, coordenada, 119, 30);
			panel2.panelClientes.add(labelId1);
			
			labelRaza1 = new Label(i.getName());
			labelRaza1.setForeground(Color.WHITE);
			labelRaza1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelRaza1.setBounds(161, coordenada, 313, 30);
			panel2.panelClientes.add(labelRaza1);
			
			labelInfo1 = new Label("+");
			labelInfo1.setForeground(Color.WHITE);
			labelInfo1.setFont(new Font("Verdana", Font.PLAIN, 18));
			labelInfo1.setAlignment(Label.CENTER);
			labelInfo1.setBounds(475, coordenada, 50, 30);
			labelInfo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panel2.panelClientes.add(labelInfo1);
			
			labelInfo1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel4.setVisible(true);
					panel4.modifyClient(i);
					panel2.setVisible(false);
					contentPane.add(panel4);
				}
			});
			
			String circuloRoute = i.isAptoAdoptar() ? "/Imagenes/circuloVerde.png" : "/Imagenes/circuloRojo.png";
			labelCirculo = new JLabel("");
			labelCirculo.setIcon(new ImageIcon(PanelPrincipal.class.getResource(circuloRoute)));
			labelCirculo.setHorizontalAlignment(SwingConstants.CENTER);
			labelCirculo.setBounds(0, coordenada, 39, 30);
			panel2.panelClientes.add(labelCirculo);
			
			coordenada += 30;
		}
	}
	
	public void pintarAdopcionesFiltro(Adopcion[] adopciones) {
		panel2.panelInfoAdopcion.removeAll();
		panel2.generateTablaAdopciones();
		
		JSeparator separatorA1;
		Label labelId1;
		Label labelTipo1;
		Label labelRaza1;
		Label labelEdad1;
		Label labelInfo1;
		JLabel labelCirculo;
		
		int coordenada = 31;
		for(Adopcion i : adopciones) {
			
			separatorA1 = new JSeparator();
			separatorA1.setForeground(new Color(255, 255, 255));
			separatorA1.setBounds(0, coordenada+30, 675, 1);
			panel2.panelInfoAdopcion.add(separatorA1);
			
			String circuloRoute = i.isVigencia() ? "/Imagenes/circuloVerde.png" : "/Imagenes/circuloRojo.png";
			labelCirculo = new JLabel("");
			labelCirculo.setIcon(new ImageIcon(PanelPrincipal.class.getResource(circuloRoute)));
			labelCirculo.setHorizontalAlignment(SwingConstants.CENTER);
			labelCirculo.setBounds(0, coordenada, 39, 30);
			panel2.panelInfoAdopcion.add(labelCirculo);
			
			labelTipo1 = new Label(i.getId());
			labelTipo1.setAlignment(Label.CENTER);
			labelTipo1.setForeground(new Color(255, 255, 255));
			labelTipo1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelTipo1.setBounds(41, coordenada, 194, 30);
			panel2.panelInfoAdopcion.add(labelTipo1);
			
			labelRaza1 = new Label(i.getAnimal().getId());
			labelRaza1.setAlignment(Label.CENTER);
			labelRaza1.setForeground(Color.WHITE);
			labelRaza1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelRaza1.setBounds(236, coordenada, 194, 30);
			panel2.panelInfoAdopcion.add(labelRaza1);
			
			labelEdad1 = new Label(i.getCliente().getCc());
			labelEdad1.setAlignment(Label.CENTER);
			labelEdad1.setForeground(Color.WHITE);
			labelEdad1.setFont(new Font("Verdana", Font.PLAIN, 12));
			labelEdad1.setBounds(431, coordenada, 194, 30);
			panel2.panelInfoAdopcion.add(labelEdad1);
			
			labelInfo1 = new Label("+");
			labelInfo1.setForeground(Color.WHITE);
			labelInfo1.setFont(new Font("Verdana", Font.PLAIN, 18));
			labelInfo1.setAlignment(Label.CENTER);
			labelInfo1.setBounds(626, coordenada, 49, 30);
			labelInfo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panel2.panelInfoAdopcion.add(labelInfo1);
			
			labelInfo1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel6.setVisible(true);
					panel6.modifyAdopcion(i);
					panel2.setVisible(false);
					contentPane.add(panel6);
				}
			});
			coordenada += 30;
		}
	}
}
