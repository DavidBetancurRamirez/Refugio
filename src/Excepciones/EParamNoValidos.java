package Excepciones;

public class EParamNoValidos extends Exception {
	private static final long serialVersionUID = 13L;

	public EParamNoValidos() {
		super("Los parametros proporcionados no son validos");
	}
}
