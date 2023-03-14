import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelBloqueado extends JPanel {
	private static final long serialVersionUID = -1507725910040779619L;
	
	/**
	 * Create the panel.
	 */
	JButton btnIngresar;
	JPasswordField passwordField;
	JLabel error;
	
	public PanelBloqueado() {
		setBackground(new Color(242, 242, 242));
		setBounds(0, 0, 1200, 720);
		setLayout(null);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresar.setBackground(new Color(61, 170, 190));
				btnIngresar.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresar.setBackground(new Color(136, 218, 232));
				btnIngresar.setForeground(new Color(0, 0, 0));
			}
		});
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setFont(new Font("Verdana", Font.ITALIC, 16));
		btnIngresar.setForeground(new Color(0, 0, 0));
		btnIngresar.setBackground(new Color(136, 218, 232));
		btnIngresar.setBounds(91, 300, 346, 28);
		add(btnIngresar);
		
		JPanel panelsitoDecoration = new JPanel();
		panelsitoDecoration.setBackground(new Color(136, 218, 232));
		panelsitoDecoration.setBounds(600, 0, 600, 720);
		add(panelsitoDecoration);
		panelsitoDecoration.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(0, 134, 617, 600);
		panelsitoDecoration.add(logo);
		logo.setForeground(new Color(255, 255, 255));
		logo.setBackground(new Color(255, 255, 255));
		logo.setIcon(new ImageIcon(PanelBloqueado.class.getResource("/Imagenes/logo.png")));
		
		JLabel titulo = new JLabel("Refugio");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 30));
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setBounds(0, 62, 617, 64);
		panelsitoDecoration.add(titulo);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(234, 224, 203, 41);
		add(passwordField);
		
		JLabel labelCodigo = new JLabel("Contraseña:");
		labelCodigo.setFont(new Font("Verdana", Font.BOLD, 18));
		labelCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		labelCodigo.setBounds(91, 226, 133, 28);
		add(labelCodigo);
		
		JLabel fecha = new JLabel("");
		fecha.setHorizontalAlignment(SwingConstants.CENTER);
		Date fechaActual = new Date();
		fecha.setText(""+fechaActual);
		fecha.setFont(new Font("Verdana", Font.PLAIN, 15));
		fecha.setBounds(95, 451, 342, 46);
		add(fecha);
		
		error = new JLabel("");
		error.setFont(new Font("Verdana", Font.BOLD, 12));
		error.setForeground(new Color(255, 0, 0));
		error.setBounds(91, 350, 203, 18);
		add(error);

	}
}
