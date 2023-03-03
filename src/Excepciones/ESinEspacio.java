package Excepciones;

public class ESinEspacio extends Exception {
	private static final long serialVersionUID = 11L;

	public ESinEspacio() {
		super("En el momento no hay espacio en el refugio");
	}
}
