import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1200, 720);
		setLayout(null);
		
		JLabel Ejemplo = new JLabel("Pagina principal");
		Ejemplo.setFont(new Font("Verdana", Font.BOLD, 35));
		Ejemplo.setHorizontalAlignment(SwingConstants.CENTER);
		Ejemplo.setBounds(0, 300, 1200, 100);
		add(Ejemplo);

	}

}
