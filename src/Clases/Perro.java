package Clases;
public class Perro extends Animal{
	private static final long serialVersionUID = 4L;

	public Perro(String raza, String recomendaciones, int edad, double cantidadComida, Alimentacion alimentacion, Enfermedad[] enfermedades) {
        super(raza, recomendaciones, edad, cantidadComida, alimentacion, enfermedades);
    }
}
