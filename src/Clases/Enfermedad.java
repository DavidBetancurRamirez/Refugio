package Clases;

import java.io.Serializable;

public enum Enfermedad implements Serializable {
	PARASITOS("Parasitos intestinales"),
	OTITIS("Otitis"),
	MOQUILLO("Moquillo"), 
<<<<<<< HEAD
	DERMATITIS("Dermatitis"),
=======
	DERMATITIS("Dermatitis"), 
>>>>>>> 5667e4b01894bbd4bb71ab6e6d406c9cd9499fee
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
