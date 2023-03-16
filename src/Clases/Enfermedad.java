package Clases;

import java.io.Serializable;

public enum Enfermedad implements Serializable {
	PARASITOS("Parasitos intestinales"),
	OTITIS("Otitis"),
	MOQUILLO("Moquillo"), 
	DERMATITIS("Dermatitis"), 
	RABIA("Rabia"),
	INFECCION("Infecciones en el cuerpo"),
	EXTREMIDAD("Esta mocho"),
	LEUCEMIA("Leucemia"),
	CONJUNTIVITIS("Conjuntivitis"), 
	ALERGIA("Alergia"), 
	DIABETES("Diabetes mellitus");
	
	private String texto;
	
	private Enfermedad(String texto) {
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}
}
