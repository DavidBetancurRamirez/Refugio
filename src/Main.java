import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

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
//		contentPane.add(header);
		header.setLayout(null);
		
		JLabel titulo = new JLabel("Refugio");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 30));
		titulo.setBounds(0, 0, 1184, 80);
//		header.add(titulo);
		
		panel1.btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(String.valueOf(panel1.passwordField.getPassword()).equals("1234")) {
					panel2.setVisible(true);
					panel1.setVisible(false);
					contentPane.add(header);
					header.add(titulo);
					contentPane.add(panel2);
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
		
		contentPane.add(panel1);
	}
}
