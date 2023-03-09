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
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main extends JFrame {

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
		panelClose.setBackground(new Color(61, 170, 190));
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
				panelClose.setBackground(new Color(61, 170, 190));
				lblNewLabel.setForeground(new Color(0, 0, 0));
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
		
		contentPane.add(panel1);
	}
	
	private void panelPrincipal(JPanel panelAnterior) {
		try {			
			refugio.cargarAnimales(ruta);
			refugio.cargarClientes(ruta);
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
			panel2.panelAnimales.add(labelInfo1);
			
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
			panel2.panelClientes.add(labelInfo1);
			
			String circuloRoute = i.isAptoAdoptar() ? "/Imagenes/circuloVerde.png" : "/Imagenes/circuloRojo.png";
			labelCirculo = new JLabel("");
			labelCirculo.setIcon(new ImageIcon(PanelPrincipal.class.getResource(circuloRoute)));
			labelCirculo.setHorizontalAlignment(SwingConstants.CENTER);
			labelCirculo.setBounds(0, coordenada, 39, 30);
			panel2.panelClientes.add(labelCirculo);
			
			coordenada += 30;
		}
		
		
		panel2.setVisible(true);
		panelAnterior.setVisible(false);
		contentPane.add(panel2);
	}
}
