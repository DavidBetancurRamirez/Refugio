import java.io.File;

import Clases.*;

public class test {

	public static void main(String[] args) {
		Refugio r = new Refugio(5);
		File ruta = new File("src\\Ficheros");

		try {
			// Agregando por primer vez a los ficheros
			Enfermedad[] enfermedades = {Enfermedad.ALERGIA, Enfermedad.INFECCION};
			
			r.addAnimal("pastor aleman", "no dejar que se coma al gato", 2, 10, false, enfermedades, true);
			r.addAnimal("bulldog", "", 1, 5, true, enfermedades, true);
			r.addAnimal("persa", "no dejarlo solo con el perro", 5, 7, true, enfermedades, false);
			r.addAnimal("siames", "", 7, 3, false, enfermedades, false);

			
			boolean[] respuestas = {true,false,true,false,true,false,true,false,true};
			
			r.addCliente("1038262298", "David Betancur", "3046290058", respuestas);
			r.addCliente("1038262297", "Eduardo Arango", "3046290058", respuestas);
			r.addCliente("1038262296", "Mateo Avalos", "3046290058", respuestas);
			r.addCliente("1038262295", "Samuel Bejarano", "3046290058", respuestas);
			r.addCliente("1038262294", "Simon Giraldo", "3046290058", respuestas);
			
			
			r.adoptarAnimal("1038262298", "animal_1");
			r.adoptarAnimal("1038262297", "animal_2");
			r.adoptarAnimal("1038262298", "animal_3");
			
			r.subirAdopciones(ruta);
			r.subirAnimales(ruta);
			r.subirClientes(ruta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			r.cargarAdopciones(ruta);
			r.cargarAnimales(ruta);
			r.cargarClientes(ruta);
			
			r.reingresoAnimal("adopcion_1");
			Adopcion adopcion = r.getAdopciones()[0];
			System.out.println(adopcion);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
