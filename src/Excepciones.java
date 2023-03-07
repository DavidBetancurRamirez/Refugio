
class ENoEncontrado extends Exception {
	private static final long serialVersionUID = 10L;

	public ENoEncontrado(String s) {
		super(s);
	}
}

class ESinEspacio extends Exception {
	private static final long serialVersionUID = 11L;

	public ESinEspacio() {
		super("En el momento no hay espacio en el refugio");
	}
}

class EParamNoValidos extends Exception {
	private static final long serialVersionUID = 13L;

	public EParamNoValidos() {
		super("Los parametros proporcionados no son validos");
	}
}

class EAdopcion extends Exception {
	private static final long serialVersionUID = 15L;

	public EAdopcion(String s) {
		super(s);
	}
}