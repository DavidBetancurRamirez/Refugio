import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.Cliente;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.util.Arrays;
import java.awt.Cursor;

public class PanelAddCliente extends JPanel {
	private static final long serialVersionUID = 3246295821068102069L;
	
	/**
	 * Create the panel.
	 */
	
	JTextField textFieldNombre;
	JTextField textFieldCc;
	JTextField textFieldTelefono;
	JLabel lblBtnVolver;
	JLabel lblBtnGuardar;
	JRadioButton[] preguntas = new JRadioButton[9];
	private boolean modificando = false;
	private boolean isAptoAdoptar;
	private Cliente anterior;
	
	public PanelAddCliente() {
		setBackground(new Color(242, 242, 242));
		setBounds(0, 0, 1200, 720);
		setLayout(null);
		
		JLabel subtitulo = new JLabel("Formulario Clientes");
		subtitulo.setFont(new Font("Verdana", Font.BOLD, 22));
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setBounds(0, 90, 1200, 50);
		add(subtitulo);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombre.setFont(new Font("Verdana", Font.PLAIN, 16));
		labelNombre.setBounds(50, 170, 70, 20);
		add(labelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(130, 170, 350, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel labelCc = new JLabel("CC:");
		labelCc.setHorizontalAlignment(SwingConstants.CENTER);
		labelCc.setFont(new Font("Verdana", Font.PLAIN, 16));
		labelCc.setBounds(530, 170, 50, 20);
		add(labelCc);
		
		textFieldCc = new JTextField();
		textFieldCc.setBounds(583, 170, 220, 20);
		add(textFieldCc);
		textFieldCc.setColumns(10);
		
		JLabel lblTelefono= new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblTelefono.setBounds(835, 170, 120, 20);
		add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(950, 170, 220, 20);
		add(textFieldTelefono);
		
		JLabel lblNewLabel = new JLabel("Preguntas para la adopcion");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 22));
		lblNewLabel.setBounds(50, 220, 400, 30);
		add(lblNewLabel);
		
		JPanel panelPreguntas = new JPanel();
		panelPreguntas.setBackground(new Color(61, 170, 190));
		panelPreguntas.setBounds(50, 260, 1120, 390);
		add(panelPreguntas);
		panelPreguntas.setLayout(null);
		
		JRadioButton pregunta1 = new JRadioButton("¿Ha adoptado algun animal en el pasado?");
		pregunta1.setFont(new Font("Verdana", Font.PLAIN, 16));
		pregunta1.setForeground(new Color(255, 255, 255));
		pregunta1.setBackground(new Color(61, 170, 190));
		pregunta1.setBounds(10, 10, 1000, 30);
		panelPreguntas.add(pregunta1);
		preguntas[0] = pregunta1;
		
		JRadioButton pregunta2 = new JRadioButton("¿Tiene otros animales en la casa?");
		pregunta2.setForeground(Color.WHITE);
		pregunta2.setFont(new Font("Verdana", Font.PLAIN, 16));
		pregunta2.setBackground(new Color(61, 170, 190));
		pregunta2.setBounds(10, 50, 1000, 30);
		panelPreguntas.add(pregunta2);
		preguntas[1] = pregunta2;
		
		JRadioButton pregunta3 = new JRadioButton("¿Estan vacunados los otros animales en su casa?");
		pregunta3.setForeground(Color.WHITE);
		pregunta3.setFont(new Font("Verdana", Font.PLAIN, 16));
		pregunta3.setBackground(new Color(61, 170, 190));
		pregunta3.setBounds(10, 90, 1000, 30);
		panelPreguntas.add(pregunta3);
		preguntas[2] = pregunta3;
		
		JRadioButton pregunta4 = new JRadioButton("¿Es su casa segura para un perro o un gato?");
		pregunta4.setForeground(Color.WHITE);
		pregunta4.setFont(new Font("Verdana", Font.PLAIN, 16));
		pregunta4.setBackground(new Color(61, 170, 190));
		pregunta4.setBounds(10, 130, 1000, 30);
		panelPreguntas.add(pregunta4);
		preguntas[3] = pregunta4;
		
		JRadioButton pregunta5 = new JRadioButton("¿Conoce los gastos y cuidados que implicará incorporar un animal y está dispuesto a asumirlos?");
		pregunta5.setForeground(Color.WHITE);
		pregunta5.setFont(new Font("Verdana", Font.PLAIN, 16));
		pregunta5.setBackground(new Color(61, 170, 190));
		pregunta5.setBounds(10, 170, 1000, 30);
		panelPreguntas.add(pregunta5);
		preguntas[4] = pregunta5;
		
		JRadioButton pregunta6 = new JRadioButton("¿Posee algún espacio al aire libre?");
		pregunta6.setForeground(Color.WHITE);
		pregunta6.setFont(new Font("Verdana", Font.PLAIN, 16));
		pregunta6.setBackground(new Color(61, 170, 190));
		pregunta6.setBounds(10, 210, 1000, 30);
		panelPreguntas.add(pregunta6);
		preguntas[5] = pregunta6;
		
		JRadioButton pregunta7 = new JRadioButton("¿Tiene certeza que permiten tener animales en su residencia?");
		pregunta7.setForeground(Color.WHITE);
		pregunta7.setFont(new Font("Verdana", Font.PLAIN, 16));
		pregunta7.setBackground(new Color(61, 170, 190));
		pregunta7.setBounds(10, 250, 1000, 30);
		panelPreguntas.add(pregunta7);
		preguntas[6] = pregunta7;
		
		JRadioButton pregunta8 = new JRadioButton("¿Todas las personas que viven en su casa están de acuerdo con esta adopción?");
		pregunta8.setForeground(Color.WHITE);
		pregunta8.setFont(new Font("Verdana", Font.PLAIN, 16));
		pregunta8.setBackground(new Color(61, 170, 190));
		pregunta8.setBounds(10, 290, 1000, 30);
		panelPreguntas.add(pregunta8);
		preguntas[7] = pregunta8;
		
		JRadioButton pregunta9 = new JRadioButton("¿Está al tanto de que el animal necesitará un período aproximado de 15 a 30 días para adaptarse a su nueva familia, ");
		pregunta9.setVerticalAlignment(SwingConstants.TOP);
		pregunta9.setForeground(Color.WHITE);
		pregunta9.setFont(new Font("Verdana", Font.PLAIN, 16));
		pregunta9.setBackground(new Color(61, 170, 190));
		pregunta9.setBounds(10, 330, 1031, 30);
		panelPreguntas.add(pregunta9);
		preguntas[8] = pregunta9;
		
		JLabel textoFaltantePreg9 = new JLabel("    horarios, lugares, etc.?");
		textoFaltantePreg9.setFont(new Font("Verdana", Font.PLAIN, 16));
		textoFaltantePreg9.setForeground(new Color(255, 255, 255));
		textoFaltantePreg9.setBounds(10, 350, 1000, 30);
		panelPreguntas.add(textoFaltantePreg9);
		
		lblBtnVolver = new JLabel("");
		lblBtnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBtnVolver.setIcon(new ImageIcon(PanelAddCliente.class.getResource("/Imagenes/volver.png")));
		lblBtnVolver.setBounds(321, 665, 200, 50);
		add(lblBtnVolver);
		
		lblBtnGuardar = new JLabel("");
		lblBtnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBtnGuardar.setIcon(new ImageIcon(PanelAddCliente.class.getResource("/Imagenes/guardar.png")));
		lblBtnGuardar.setBounds(670, 665, 200, 50);
		add(lblBtnGuardar);

	}
	
	public void limpiarCasillas() {
		textFieldNombre.setText("");
		textFieldCc.setText("");
		textFieldTelefono.setText("");
		for(JRadioButton i: preguntas) {
			i.setSelected(false);
		}
		modificando = false;
	}
	
	public void modifyClient(Cliente c) {
		modificando = true;
		textFieldNombre.setText(c.getName());
		textFieldCc.setText(c.getCc());
		textFieldTelefono.setText(c.getTelefono());
		boolean[] answers = c.getRespuestasAdopcion();
		for(int i = 0; i < answers.length;i++) {
			if(answers[i]) {
				preguntas[i].setSelected(true);
			}
		}
		setisAptoAdoptar(c.isAptoAdoptar());
		anterior = c;
	}
	
	public boolean getModificando() {
		return modificando;
	}
	
	public String getNombre() {
		return textFieldNombre.getText();
	}
	
	public String getCc() {
		return textFieldCc.getText();
	}
	public String getTelefono() {
		return textFieldTelefono.getText();
	}
	
	public boolean[] getPreguntas() {
		boolean[] newPreguntas = new boolean[0];
		for(JRadioButton i : preguntas) {
			newPreguntas = Arrays.copyOf(newPreguntas, newPreguntas.length+1);
			if(i.isSelected()) {
				newPreguntas[newPreguntas.length-1] = true;
			}
			else {
				newPreguntas[newPreguntas.length-1] = false;
				
			}
		}
		return newPreguntas;
	}
	
	private void setisAptoAdoptar(boolean a) {
		isAptoAdoptar = a;
	}
	
	public boolean getIsAptoAdoptar() {
		return isAptoAdoptar;
	}
	
	public Cliente getAnteriorCliente() {
		return anterior;
	}
}
