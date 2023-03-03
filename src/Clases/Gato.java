package Clases;

public class Gato extends Animal{
	private static final long serialVersionUID = 3L;

	public Gato(String raza, String recomendaciones, int edad, double cantidadComida, Alimentacion alimentacion, Enfermedad[] enfermedades) {
        super(raza, recomendaciones, edad, cantidadComida, alimentacion, enfermedades);
    }
}
