
public enum Alimentacion {
	PERROPEQUENO("Cuido para perros cachorros"), 
	PERROMEDIANO("Cuido para perros jovenes"), 
	PERROGRANDE("Cuido para perros adultos"), 
	PERROALERGICO("Dieta balanceada para perros alergicos al cuido, consulte con su veterinario"),
	
	GATOPEQUENO("Cuido para gatos pequeños"), 
	GATOMEDIANO("Cuido para gatos medianos"),
	GATOGRANDE("Cuido para gatos adultos"), 
	GATOALERGICO("Dieta balanceada para gatos alergicos al cuido, consulte con su veterinario");
	
	private String texto;
	
	private Alimentacion(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}
}
