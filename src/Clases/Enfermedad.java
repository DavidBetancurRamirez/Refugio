package Clases;

import java.io.Serializable;

public enum Enfermedad implements Serializable {
	//Enfermedades de perros principalmente
	PARASITOS("Parasitos intestinales"),
	OTITIS("Otitis"),
	MOQUILLO("Moquillo"), 
	DERMATITIS("Dermatitis"), 
	
	//Enfermedad que ambos pueden tener
	RABIA("Rabia"),
	INFECCION("Infecciones en el cuerpo"),
	EXTREMIDAD("Esta mocho"),
	
	//Enfermedades de gatos principalmente
	LEUCEMIA("Leucemia felina"),
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
