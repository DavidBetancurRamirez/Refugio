import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Clases.Alimentacion;
import Clases.Animal;
import Clases.Chequeo;
import Clases.Enfermedad;
import Clases.Perro;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.Cursor;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelAddAnimal extends JPanel {
	private JTextField textFieldRaza;
	private JTextField textFieldCantidad;
	private JTextArea textAreaReco;
	private JComboBox comboBoxEdad;
	private JRadioButton checkboxAlimentoEspecial;
	private JRadioButton[] chequeosEnfermedades = new JRadioButton[11];
	private JComboBox comboBoxTipo;
	JLabel lblBtnVolver;
	JLabel lblBtnGuardar;
	boolean modificando = false;
	String id;
	Alimentacion alim;
	JComboBox comboBoxHistorialMedico =  new JComboBox();
	JLabel lblHistorial = new JLabel("Historial chequeos");

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
		labelRaza.setBounds(130, 190, 50, 20);
		add(labelRaza);
		
		textFieldRaza = new JTextField();
		textFieldRaza.setBounds(190, 193, 280, 20);
		add(textFieldRaza);
		textFieldRaza.setColumns(10);
		
		JLabel labelEdad = new JLabel("Edad:");
		labelEdad.setHorizontalAlignment(SwingConstants.CENTER);
		labelEdad.setFont(new Font("Verdana", Font.PLAIN, 16));
		labelEdad.setBounds(530, 190, 50, 20);
		add(labelEdad);
		
		comboBoxEdad = new JComboBox();
		comboBoxEdad.setBackground(new Color(255, 255, 255));
		comboBoxEdad.setModel(new DefaultComboBoxModel(new String[] {"", "<1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBoxEdad.setBounds(583, 193, 70, 20);
		add(comboBoxEdad);
		
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
		
		checkboxAlimentoEspecial = new JRadioButton(" Alimentacion especial");
		checkboxAlimentoEspecial.setFont(new Font("Verdana", Font.PLAIN, 16));
		checkboxAlimentoEspecial.setBounds(722, 190, 230, 23);
		add(checkboxAlimentoEspecial);
		
		JPanel panelChequeo = new JPanel();
		panelChequeo.setBackground(new Color(61, 170, 190));
		panelChequeo.setBounds(230, 280, 880, 170);
		add(panelChequeo);
		panelChequeo.setLayout(null);
		
		JRadioButton parasitos = new JRadioButton("Parasitos");
		parasitos.setFont(new Font("Verdana", Font.PLAIN, 18));
		parasitos.setForeground(new Color(255, 255, 255));
		parasitos.setHorizontalAlignment(SwingConstants.LEFT);
		parasitos.setBackground(new Color(61, 170, 190));
		parasitos.setBounds(40, 30, 109, 23);
		panelChequeo.add(parasitos);
		chequeosEnfermedades[0] = parasitos;
		
		JRadioButton otitis = new JRadioButton("Otitis");
		otitis.setHorizontalAlignment(SwingConstants.LEFT);
		otitis.setForeground(Color.WHITE);
		otitis.setFont(new Font("Verdana", Font.PLAIN, 18));
		otitis.setBackground(new Color(61, 170, 190));
		otitis.setBounds(40, 70, 109, 23);
		panelChequeo.add(otitis);
		chequeosEnfermedades[1] = otitis;
		
		JRadioButton moquillo = new JRadioButton("Moquillo");
		moquillo.setHorizontalAlignment(SwingConstants.LEFT);
		moquillo.setForeground(Color.WHITE);
		moquillo.setFont(new Font("Verdana", Font.PLAIN, 18));
		moquillo.setBackground(new Color(61, 170, 190));
		moquillo.setBounds(40, 110, 99, 23);
		panelChequeo.add(moquillo);
		chequeosEnfermedades[2] = moquillo;
		
		JRadioButton dermatitis = new JRadioButton("Dermatitis");
		dermatitis.setHorizontalAlignment(SwingConstants.LEFT);
		dermatitis.setForeground(Color.WHITE);
		dermatitis.setFont(new Font("Verdana", Font.PLAIN, 18));
		dermatitis.setBackground(new Color(61, 170, 190));
		dermatitis.setBounds(250, 30, 130, 23);
		panelChequeo.add(dermatitis);
		chequeosEnfermedades[3] = dermatitis;
		
		JRadioButton rabia = new JRadioButton("Rabia");
		rabia.setHorizontalAlignment(SwingConstants.LEFT);
		rabia.setForeground(Color.WHITE);
		rabia.setFont(new Font("Verdana", Font.PLAIN, 18));
		rabia.setBackground(new Color(61, 170, 190));
		rabia.setBounds(250, 70, 109, 23);
		panelChequeo.add(rabia);
		chequeosEnfermedades[4] = rabia;
		
		JRadioButton infeccion = new JRadioButton("Infeccion");
		infeccion.setHorizontalAlignment(SwingConstants.LEFT);
		infeccion.setForeground(Color.WHITE);
		infeccion.setFont(new Font("Verdana", Font.PLAIN, 18));
		infeccion.setBackground(new Color(61, 170, 190));
		infeccion.setBounds(250, 110, 120, 23);
		panelChequeo.add(infeccion);
		chequeosEnfermedades[5] = infeccion;
		
		JRadioButton extremidad = new JRadioButton("Extremidad");
		extremidad.setHorizontalAlignment(SwingConstants.LEFT);
		extremidad.setForeground(Color.WHITE);
		extremidad.setFont(new Font("Verdana", Font.PLAIN, 18));
		extremidad.setBackground(new Color(61, 170, 190));
		extremidad.setBounds(460, 30, 130, 23);
		panelChequeo.add(extremidad);
		chequeosEnfermedades[6] = extremidad;
		
		JRadioButton leucemia = new JRadioButton("Leucemia");
		leucemia.setHorizontalAlignment(SwingConstants.LEFT);
		leucemia.setForeground(Color.WHITE);
		leucemia.setFont(new Font("Verdana", Font.PLAIN, 18));
		leucemia.setBackground(new Color(61, 170, 190));
		leucemia.setBounds(460, 70, 112, 23);
		panelChequeo.add(leucemia);
		chequeosEnfermedades[7] = leucemia;
		
		JRadioButton conjuntivitis = new JRadioButton("Conjuntivitis");
		conjuntivitis.setHorizontalAlignment(SwingConstants.LEFT);
		conjuntivitis.setForeground(Color.WHITE);
		conjuntivitis.setFont(new Font("Verdana", Font.PLAIN, 18));
		conjuntivitis.setBackground(new Color(61, 170, 190));
		conjuntivitis.setBounds(460, 110, 138, 23);
		panelChequeo.add(conjuntivitis);
		chequeosEnfermedades[8] = conjuntivitis;
		
		JRadioButton alergia = new JRadioButton("Alergia");
		alergia.setHorizontalAlignment(SwingConstants.LEFT);
		alergia.setForeground(Color.WHITE);
		alergia.setFont(new Font("Verdana", Font.PLAIN, 18));
		alergia.setBackground(new Color(61, 170, 190));
		alergia.setBounds(670, 30, 130, 23);
		panelChequeo.add(alergia);
		chequeosEnfermedades[9] = alergia;
		
		JRadioButton diabetes = new JRadioButton("Diabetes");
		diabetes.setHorizontalAlignment(SwingConstants.LEFT);
		diabetes.setForeground(Color.WHITE);
		diabetes.setFont(new Font("Verdana", Font.PLAIN, 18));
		diabetes.setBackground(new Color(61, 170, 190));
		diabetes.setBounds(670, 70, 112, 23);
		panelChequeo.add(diabetes);
		chequeosEnfermedades[10] = diabetes;
		
		textAreaReco = new JTextArea();
		textAreaReco.setBounds(350, 517, 760, 100);
		add(textAreaReco);
		
		JLabel lblRecomendaciones = new JLabel("Recomendaciones");
		lblRecomendaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecomendaciones.setFont(new Font("Verdana", Font.BOLD, 22));
		lblRecomendaciones.setBounds(90, 552, 240, 30);
		add(lblRecomendaciones);
		
		lblBtnVolver = new JLabel("");
		lblBtnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBtnVolver.setIcon(new ImageIcon(PanelAddAnimal.class.getResource("/Imagenes/volver.png")));
		lblBtnVolver.setFont(new Font("Verdana", Font.BOLD, 20));
		lblBtnVolver.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnVolver.setForeground(new Color(255, 0, 0));
		lblBtnVolver.setBounds(321, 665, 200, 50);
		add(lblBtnVolver);
		
		lblBtnGuardar = new JLabel("");
		lblBtnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBtnGuardar.setIcon(new ImageIcon(PanelAddAnimal.class.getResource("/Imagenes/guardar.png")));
		lblBtnGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnGuardar.setForeground(new Color(0, 255, 64));
		lblBtnGuardar.setFont(new Font("Verdana", Font.BOLD, 20));
		lblBtnGuardar.setBounds(670, 665, 200, 50);
		add(lblBtnGuardar);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblTipo.setBounds(30, 165, 50, 20);
		add(lblTipo);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Perro", "Gato"}));
		comboBoxTipo.setBackground(Color.WHITE);
		comboBoxTipo.setBounds(22, 190, 70, 20);
		add(comboBoxTipo);
		comboBoxHistorialMedico.setBackground(new Color(255, 255, 255));
		
//		JComboBox comboBoxHistorialMedico = new JComboBox();
//		comboBoxHistorialMedico.setBounds(350, 473, 760, 25);
//		comboBoxHistorialMedico.setVisible(true);
//		add(comboBoxHistorialMedico);
		
//		JLabel lblHistorial = new JLabel("Historial chequeos");
//		lblHistorial.setHorizontalAlignment(SwingConstants.CENTER);
//		lblHistorial.setFont(new Font("Verdana", Font.BOLD, 22));
//		lblHistorial.setBounds(90, 473, 240, 30);
//		add(lblHistorial);
		
		
	}
	
	public void limpiarCasillas() {
		textFieldRaza.setText("");
		textAreaReco.setText("");
		comboBoxEdad.setSelectedItem("");
		textFieldCantidad.setText("");
		checkboxAlimentoEspecial.setSelected(false);
		for(JRadioButton i: chequeosEnfermedades) {
			i.setSelected(false);
		}
		modificando = false;
		id = "";
		alim = null;
		comboBoxHistorialMedico.setVisible(false);
		lblHistorial.setVisible(false);
	}
	
	public void modifyAnimal(Animal a) {
		modificando = true;
		textFieldRaza.setText(a.getRaza());
		textAreaReco.setText(a.getRecomendaciones());
		if(a.getEdad() == 0) {
			comboBoxEdad.setSelectedItem("<1");
		}
		else {			
			comboBoxEdad.setSelectedItem(String.valueOf(a.getEdad()));
		}
		textFieldCantidad.setText(String.valueOf(a.getCantidadComida()));
		checkboxAlimentoEspecial.setSelected(a.getAlimentacion().name().equals("ESPECIAL"));
		id = a.getId();
		alim = a.getAlimentacion();
		
		showHistorialMedico(a.getChequeos());
		
//		Enfermedad[] enfer = a.getChequeos()[a.getChequeos().length-1].getEnfermedades();
//		for(Enfermedad i : enfer) {
//			if(Enfermedad.valueOf(chequeosEnfermedades[i.ordinal()].getText().toUpperCase()).equals(i)) {
//				chequeosEnfermedades[i.ordinal()].setSelected(true);
//			}
//		}
		
		
	}
	
	public void showHistorialMedico(Chequeo[] checks) {
//		comboBoxHistorialMedico = new JComboBox();
		String[] historial = new String[0];
		for(Chequeo i : checks) {
			historial = Arrays.copyOf(historial, historial.length+1);
			historial[historial.length-1] = "********************";
			historial = Arrays.copyOf(historial, historial.length+1);
			historial[historial.length-1] = String.valueOf(i.getFecha());
			historial = Arrays.copyOf(historial, historial.length+1);
			historial[historial.length-1] = Arrays.toString(i.getEnfermedades());
			historial = Arrays.copyOf(historial, historial.length+1);
			historial[historial.length-1] = "";
		}
		comboBoxHistorialMedico.setModel(new DefaultComboBoxModel(historial));
		comboBoxHistorialMedico.setBounds(350, 473, 760, 25);
		comboBoxHistorialMedico.setVisible(true);
		add(comboBoxHistorialMedico);
		
		lblHistorial.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistorial.setFont(new Font("Verdana", Font.BOLD, 22));
		lblHistorial.setBounds(90, 473, 240, 30);
		lblHistorial.setVisible(true);
		add(lblHistorial);
		
	}
	
	public String getRaza() {
		return textFieldRaza.getText();
	}
	
	public String getRecomendaciones() {
		return textAreaReco.getText();
	}
	
	public boolean isPerro() {
		return  String.valueOf(comboBoxTipo.getSelectedItem()).equals("Perro");
	}
	
	public int getEdad() {
		String eleccion = (String) comboBoxEdad.getSelectedItem();
		if(eleccion.equals("") || eleccion.equals("<1")) {
			return 0;
		}
		return Integer.parseInt(eleccion);
	}
	
	public double getCantComida() {
		return Double.parseDouble(textFieldCantidad.getText());
	}
	
	public boolean getEspecial() {
		return checkboxAlimentoEspecial.isSelected();
	}
	
	public Enfermedad[] getEnfermedades() {
		Enfermedad[] enfermedades = Enfermedad.values();
		Enfermedad[] newEnfermedades = new Enfermedad[0];
		for(int i = 0; i < enfermedades.length; i++) {
			if(enfermedades[i].name().equals(chequeosEnfermedades[i].getText().toUpperCase()) && 
					chequeosEnfermedades[i].isSelected()) {
				newEnfermedades = Arrays.copyOf(newEnfermedades, newEnfermedades.length+1);
				newEnfermedades[newEnfermedades.length-1] = enfermedades[i];
			}
//			System.out.println(chequeosEnfermedades[i].isSelected());
		}
//		System.out.println(Arrays.toString(newEnfermedades));
		return newEnfermedades;
	}
}
