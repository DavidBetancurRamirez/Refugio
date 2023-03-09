import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelAddAnimal extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAddAnimal() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1200, 720);
		setLayout(null);
		
		JPanel panelBorrar = new JPanel();
		panelBorrar.setBounds(0, 0, 1200, 80);
		add(panelBorrar);
		panelBorrar.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Formulario Animal");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 100, 1200, 50);
		add(lblNewLabel);
	}
}
