import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class PanelAddAnimal extends JPanel {
	private JTextField textFieldRaza;
	private JTextField textFieldEdad;
	private JTextField textFieldCantidad;

	/**
	 * Create the panel.
	 */
	public PanelAddAnimal() {
		setBackground(new Color(242, 242, 242));
		setBounds(0, 0, 1200, 720);
		setLayout(null);
		
		JPanel panelBorrar = new JPanel();
		panelBorrar.setBackground(new Color(0, 0, 255));
		panelBorrar.setBounds(0, 0, 1200, 80);
		add(panelBorrar);
		panelBorrar.setLayout(null);
		
		JLabel subtitulo = new JLabel("Formulario Animal");
		subtitulo.setFont(new Font("Verdana", Font.BOLD, 22));
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setBounds(0, 100, 1200, 50);
		add(subtitulo);
		
		JLabel labelRaza = new JLabel("Raza:");
		labelRaza.setHorizontalAlignment(SwingConstants.CENTER);
		labelRaza.setFont(new Font("Verdana", Font.PLAIN, 16));
		labelRaza.setBounds(50, 190, 50, 20);
		add(labelRaza);
		
		textFieldRaza = new JTextField();
		textFieldRaza.setBounds(110, 193, 350, 20);
		add(textFieldRaza);
		textFieldRaza.setColumns(10);
		
		JLabel labelEdad = new JLabel("Edad:");
		labelEdad.setHorizontalAlignment(SwingConstants.CENTER);
		labelEdad.setFont(new Font("Verdana", Font.PLAIN, 16));
		labelEdad.setBounds(530, 190, 50, 20);
		add(labelEdad);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(585, 193, 70, 20);
		add(textFieldEdad);
		
		JLabel lblCantidad = new JLabel("Cantidad (gr):");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblCantidad.setBounds(980, 190, 120, 20);
		add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBounds(1105, 193, 70, 20);
		add(textFieldCantidad);
		
		JLabel lblCheckeo = new JLabel("Chequeo");
		lblCheckeo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckeo.setFont(new Font("Verdana", Font.BOLD, 22));
		lblCheckeo.setBounds(90, 350, 108, 30);
		add(lblCheckeo);
		
		JRadioButton checkboxAlimentoEspecial = new JRadioButton(" Alimentacion especial");
		checkboxAlimentoEspecial.setFont(new Font("Verdana", Font.PLAIN, 16));
		checkboxAlimentoEspecial.setBounds(722, 190, 230, 23);
		add(checkboxAlimentoEspecial);
		
		JPanel panelChequeo = new JPanel();
		panelChequeo.setBackground(new Color(61, 170, 190));
		panelChequeo.setBounds(230, 280, 880, 170);
		add(panelChequeo);
		panelChequeo.setLayout(null);
	}
}
