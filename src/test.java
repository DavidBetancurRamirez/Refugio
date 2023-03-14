import java.io.File;

import Clases.*;

public class test {

	public static void main(String[] args) {
		Refugio r = new Refugio(5);
		File ruta = new File("src\\Ficheros");
		
		/*
		try {
			// Agregando por primer vez a los ficheros
			Enfermedad[] enfermedades = {Enfermedad.ALERGIA, Enfermedad.INFECCION};
			
			r.addAnimal("pastor aleman", "no dejar que se coma al gato", 2, 10, false, enfermedades, true);
			r.addAnimal("bulldog", "", 1, 5, true, enfermedades, true);
			r.addAnimal("persa", "no dejarlo solo con el perro", 5, 7, true, enfermedades, false);
			r.addAnimal("siames", "", 7, 3, false, enfermedades, false);
			r.addAnimal("pastor aleman", "no dejar que se coma al gato", 2, 10, false, enfermedades, true);

			
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
		*/
		
		/*
		try {
			// Lectura de ficheros
			r.cargarAdopciones(ruta);
			r.cargarAnimales(ruta);
			r.cargarClientes(ruta);
						
			
			// Metodos varios
			Adopcion[] adopciones = r.getAdopciones();
			
			r.reingresoAnimal(adopciones[0]);
			r.adoptarAnimal("1038262298", "animal_1");
			
			boolean[] respuestas = {true,false,true,false,true,false,true,false,true};
			r.addCliente("4165", "David Betancur", "3046290058", respuestas);
			
			adopciones = r.getAdopciones();
			
			Cliente[] clientes = r.buscarCliente(true, "David Betancur", "nombre", false);
			for (Cliente cliente : clientes) {
				System.out.println(cliente);
			}
			
			
			/*
			boolean[] respuestas = {true,false,true,false,true,false,true,false,true};
			r.addCliente("1038262298", "alguien doble", "2185618", respuestas);
			*/
			/*
			Adopcion[] adopciones = r.getAdopciones();
			
			System.out.println("animal:" + r.getAnimales()[0]);
			
			r.reingresoAnimal(adopciones[0]);
			
			System.out.println("\n\nanimal:" + r.getAnimales()[0]);

			r.adoptarAnimal("1038262298", "animal_1");

			System.out.println("\n\nanimal:" + r.getAnimales()[0]);
			System.out.println("");
			adopciones = r.getAdopciones();
			for (Adopcion adopcion : adopciones) {
				System.out.println(adopcion);
			}

			r.reingresoAnimal(adopciones[3]);
			System.out.println("");
			adopciones = r.getAdopciones();

			System.out.println("animal:" + r.getAnimales()[0]);
			*/
			
			/*
			adopcion = r.buscarAdopcion(true, "adopcion_2", "idAdopcion", true)[0];
			System.out.println(adopcion);
			
			Cliente cliente = r.buscarCliente(true, "1038262298", "cc", true)[0];
			System.out.println(cliente);
			cliente = r.buscarCliente(true, "Simon Giraldo", "nombre", true)[0];
			
			// Animal por id
			Animal[] animal = r.buscarAnimales(false, "animal_4", "id", "todos", false);
			for (Animal animal2 : animal) {
				System.out.println(animal2);
			}
			
			// Animal por raza
			animal = r.buscarAnimales(true, "PASTOR ALEMAN", "raza", "Perro", false);
			for (Animal animal2 : animal) {
				System.out.println(animal2);
			}
			
			// Animal por edad
			animal = r.buscarAnimales(false, "2", "edad", "todos", true);
			for (Animal animal2 : animal) {
				System.out.println(animal2);
			}
			*//*
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
	}
}
