import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.Arrays;
import java.util.Date;

import Clases.*;


public class Refugio {
	private int capacidad;
	private Adopcion[] adopciones;
	private Animal[] animales;
	private Cliente[] clientes;
	
	public Refugio(int capacidad) {
		this.capacidad = capacidad;
		this.adopciones = new Adopcion[0];
		this.animales = new Animal[0];
		this.clientes = new Cliente[0];
	}
	
	public Refugio(int capacidad, Adopcion[] adopciones, Animal[] animales, Cliente[] clientes) {
		this.capacidad = capacidad;
		this.adopciones = adopciones;
		this.animales = animales;
		this.clientes = clientes;
	}
	
	
	public void adoptarAnimal(String ccCliente, String idAnimal) throws EParamNoValidos, ENoEncontrado, EAdopcion {
		if (ccCliente==null || idAnimal==null) new EParamNoValidos();
		
		int ic = buscarClienteCc(ccCliente);
		if (ic==-1) throw new ENoEncontrado("No hay ningun cliente con el id "+ccCliente);
		
		int ia = buscarAnimalId(idAnimal);
		if (ia==-1) throw new ENoEncontrado("No hay ningun animal con el id "+idAnimal);
		
		
		if (!clientes[ic].isAptoAdoptar() || animales[ia].isAdoptado()) throw new EAdopcion("No se pudo realizar la adopcion");

		animales[ia].setAdoptado(true);
		
		adopciones = Arrays.copyOf(adopciones, adopciones.length+1);
		adopciones[adopciones.length-1] = new Adopcion(clientes[ic], animales[ia]);
	}
	
	public void addAnimal(String raza, String recomendaciones, int edad, double cantidadComida, boolean especial, Enfermedad[] enfermedades, boolean isPerro) throws EParamNoValidos, ESinEspacio {
		if (raza==null || recomendaciones==null || edad<0 || cantidadComida<=0 || enfermedades==null) throw new EParamNoValidos();
		if (!hayEspacio()) throw new ESinEspacio();
		
		Alimentacion alimentacion;
		animales = Arrays.copyOf(animales, animales.length+1);
		
		if (isPerro) {
			alimentacion = (especial) ? Alimentacion.ESPECIAL : Alimentacion.PERRO;
			animales[animales.length-1] = new Perro(raza, recomendaciones, edad, cantidadComida, alimentacion, enfermedades);
		} else {
			alimentacion = (especial) ? Alimentacion.ESPECIAL : Alimentacion.GATO;
			animales[animales.length-1] = new Gato(raza, recomendaciones, edad, cantidadComida, alimentacion, enfermedades);
		}
	}
	
	public void addCliente(String cc, String nombre, String telefono, boolean[] respuestas) throws EParamNoValidos {
		if (cc==null || nombre==null || telefono==null || respuestas.length!=9) throw new EParamNoValidos();
		
		clientes = Arrays.copyOf(clientes, clientes.length+1);
		clientes[clientes.length-1] = new Cliente(cc, nombre, telefono, respuestas);
	}
	
	public int buscarAnimalId(String id) {
		int i = -1;
		while (++i<animales.length && animales[i].getId().toLowerCase().compareTo(id) != 0);

		return (i<animales.length)? i : -1;		
	}
	
	public int[] buscarAnimalTipo(String tipo) {
		int[] animalesPorTipo = new int[0];
		for(int i=0; i<animales.length; i++) {
			if(String.valueOf(animales[i].getClass().getSimpleName()).equals(tipo)) {
				animalesPorTipo = Arrays.copyOf(animalesPorTipo, animalesPorTipo.length+1);
				animalesPorTipo[animalesPorTipo.length-1] = i;
			}
		}
		return animalesPorTipo;
//		if(tipo.equalsIgnoreCase("Perro")) {
//			for(int i=0; i<animales.length; i++) {
////				if(animales[i] instanceof Perro) {
////					animalesPorTipo = Arrays.copyOf(animalesPorTipo, animalesPorTipo.length+1);
////					animalesPorTipo[animalesPorTipo.length-1] = i;
////		
////				}
//				if(String.valueOf(animales[i].getClass().getSimpleName()).equals(tipo)) {
//					animalesPorTipo = Arrays.copyOf(animalesPorTipo, animalesPorTipo.length+1);
//					animalesPorTipo[animalesPorTipo.length-1] = i;
//				}
//			}
//		} else if(tipo.equalsIgnoreCase("Gato")) {
//			for(int i=0; i<animales.length; i++) {
//				if(animales[i] instanceof Gato) {
//					animalesPorTipo = Arrays.copyOf(animalesPorTipo, animalesPorTipo.length+1);
//					animalesPorTipo[animalesPorTipo.length-1] = i;
//				}
//			}
//		}
//		return animalesPorTipo;
	}
	
	public int[] buscarAnimalRaza(String raza) {
		int[] animalesPorRaza = new int[0];
		for(int i=0; i<animales.length; i++) {
			if(animales[i].getRaza().equalsIgnoreCase(raza)) {
				animalesPorRaza = Arrays.copyOf(animalesPorRaza, animalesPorRaza.length+1);
				animalesPorRaza[animalesPorRaza.length-1] = i;
			}
		}
		return animalesPorRaza;
	}
	
	public int[] buscarAnimalEdad(int edad) {
		int[] animalesPorEdad = new int[0];
		for(int i=0; i<animales.length; i++) {
			if(animales[i].getEdad() == edad) {
				animalesPorEdad = Arrays.copyOf(animalesPorEdad, animalesPorEdad.length+1);
				animalesPorEdad[animalesPorEdad.length-1] = i;
			}
		}
		return animalesPorEdad;
	}
	
	public int[] buscarAnimalAdopcion(boolean estaAdoptado) {
		int[] animalesPorAdopcion = new int[0];
		
		if(estaAdoptado) {
			for(int i=0; i<animales.length; i++) {
				if(animales[i].isAdoptado()) {
					animalesPorAdopcion = Arrays.copyOf(animalesPorAdopcion, animalesPorAdopcion.length+1);
					animalesPorAdopcion[animalesPorAdopcion.length-1] = i;
				}
			}
		} else if(!estaAdoptado) {
			for(int i=0; i<animales.length; i++) {
				if(animales[i].isAdoptado()==false) {
					animalesPorAdopcion = Arrays.copyOf(animalesPorAdopcion, animalesPorAdopcion.length+1);
					animalesPorAdopcion[animalesPorAdopcion.length-1] = i;
				}
			}
		}
		return animalesPorAdopcion;
	}
	
	public int buscarClienteCc(String cc) {
		int i = -1;
		while (++i<clientes.length && clientes[i].getCc().toLowerCase().compareTo(cc) != 0);

		return (i<clientes.length)? i : -1;		
	}
	
	public int buscarClienteNombre(String nombre) {
		int i = -1;
		while (++i<clientes.length && clientes[i].getName().toLowerCase().compareTo(nombre) != 0);

		return (i<clientes.length)? i : -1;		
	}
	
	public int[] buscarClienteAptoAdoptar(boolean esApto) {
		int[] clientesAptos = new int[0];
		
		if(esApto) {
			for(int i=0; i<clientes.length; i++) {
				if(clientes[i].isAptoAdoptar()) {
					clientesAptos = Arrays.copyOf(clientesAptos, clientesAptos.length+1);
					clientesAptos[clientesAptos.length-1] = i;
				}
			}
		} else if(!esApto) {
			for(int i=0; i<animales.length; i++) {
				if(clientes[i].isAptoAdoptar()==false) {
					clientesAptos = Arrays.copyOf(clientesAptos, clientesAptos.length+1);
					clientesAptos[clientesAptos.length-1] = i;
				}
			}
		}
		return clientesAptos;
	}
	
	public int buscarAdopcionId(String id) {
		int i = -1;
		while (++i<adopciones.length && adopciones[i].getId().toLowerCase().compareTo(id) != 0);

		return (i<adopciones.length)? i : -1;		
	}
	
	public int buscarAdopcionIdAnimal(String idAnimal) {
		int i = -1;
		while (++i<adopciones.length && adopciones[i].getAnimal().getId().toLowerCase().compareTo(idAnimal) != 0);

		return (i<adopciones.length)? i : -1;	
	}
	
	public int buscarAdopcionCcCliente(String ccCliente) {
		int i = -1;
		while (++i<adopciones.length && adopciones[i].getCliente().getCc().toLowerCase().compareTo(ccCliente) != 0);

		return (i<adopciones.length)? i : -1;	
	}
	
	public void cargarAdopciones(File ruta) throws IOException, ClassNotFoundException {
		File f = new File(ruta+"\\Adopciones\\");
		File[] listaF = f.listFiles(new Filtro(".ado"));
		adopciones = new Adopcion[listaF.length];
		
		for (int i = 0; i < listaF.length; i++) {
			FileInputStream in = new FileInputStream(listaF[i]);
			ObjectInputStream o = new ObjectInputStream(in);
			adopciones[i] = (Adopcion)o.readObject();
			o.close();
			in.close();
		}
	}
	
	public void cargarAnimales(File ruta) throws IOException, ClassNotFoundException {
		File f = new File(ruta+"\\Animales\\");
		File[] listaF = f.listFiles(new Filtro(".ani"));
		animales = new Animal[listaF.length];
		
		for (int i = 0; i < listaF.length; i++) {
			FileInputStream in = new FileInputStream(listaF[i]);
			ObjectInputStream o = new ObjectInputStream(in);
			animales[i] = (Animal)o.readObject();
			o.close();
			in.close();
		}
	}
	
	public void cargarClientes(File ruta) throws IOException, ClassNotFoundException {
		File f = new File(ruta+"\\Clientes\\");
		File[] listaF = f.listFiles(new Filtro(".cli"));
		clientes = new Cliente[listaF.length];
		
		for (int i = 0; i < listaF.length; i++) {
			FileInputStream in = new FileInputStream(listaF[i]);
			ObjectInputStream o = new ObjectInputStream(in);
			clientes[i] = (Cliente)o.readObject();
			o.close();
			in.close();
		}
	}
	
	public void eliminarAdopcion(String id) throws ENoEncontrado {
		int i = buscarAdopcionId(id);
		if (i==-1) throw new ENoEncontrado("No se encontro la adopcion con id "+id);;
		
		System.arraycopy(adopciones, i+1, adopciones, i, adopciones.length-i-1);
		adopciones = Arrays.copyOf(adopciones, adopciones.length-1);
	}
	
	public void eliminarAnimal(String id) throws ENoEncontrado {
		int i = buscarAnimalId(id);
		if (i==-1) throw new ENoEncontrado("No se encontro el animal con id "+id);
		
		
		System.arraycopy(animales, i+1, animales, i, animales.length-i-1);
		animales = Arrays.copyOf(animales, animales.length-1);
	}

	public void eliminarCliente(String cc) throws ENoEncontrado {
		int i = buscarClienteCc(cc);
		if (i==-1) throw new ENoEncontrado("No se encontro el cliente con cc "+cc);
		
		
		System.arraycopy(clientes, i+1, clientes, i, clientes.length-i-1);
		clientes = Arrays.copyOf(clientes, clientes.length-1);
	}
	
	public void formularioAdopcion() {
		// Enviar al formulario
	}
	
	public void formularioAnimal() {
		// Enviar al formulario		
	}
	
	public void formularioCliente() {
		// Enviar al formulario
	}
	
	public int getCantidadAnimales() {
		int cantidad = 0;
		
		for (Animal animal : animales) {
			if (!animal.isAdoptado()) cantidad++;
		}
		return cantidad;
	}
	
	public void hacerChequeo(String id) throws ENoEncontrado {
		int i = buscarAnimalId(id);
		if (i==-1) throw new ENoEncontrado("No se encontro el animal con id "+id);
		
		Animal a = animales[i];
		
		// Abrir formulario animal con los datos del animal
	}
	
	public boolean hayEspacio() {
		return (getCantidadAnimales()<capacidad) ? true : false;
	}
	
	public void modAnimal(String id, String raza, String recomendaciones, int edad, double cantidadComida, Alimentacion alimentacion, Enfermedad[] enfermedades) throws ENoEncontrado, EParamNoValidos {
		if (raza==null || recomendaciones==null || edad<0 || cantidadComida<=0 || alimentacion==null) throw new EParamNoValidos();
		
		int i = buscarAnimalId(id);
		if (i==-1) throw new ENoEncontrado("No se encontro el animal con id "+id);
		
		Animal a = animales[i];
		
		a.setRaza(raza);
		a.setRecomendaciones(recomendaciones);
		a.setEdad(edad);
		a.setCantidadComida(cantidadComida);
		a.setAlimentacion(alimentacion);
		a.addChequeo(enfermedades);
	}
	
	public void modAdopcion(String id, Cliente cliente, Animal animal, Date fechaAdopcion) throws ENoEncontrado, EParamNoValidos {
		if (id==null || cliente==null || animal==null || fechaAdopcion==null) throw new EParamNoValidos();
		
		int i = buscarAdopcionId(id);
		if (i==-1) throw new ENoEncontrado("No se encontro la adopcion con id "+id);
		
		Adopcion a = adopciones[i];

		a.setCliente(cliente);
		a.setAnimal(animal);
		a.setFechaAdopcion(fechaAdopcion);
	}
	
	public void modCliente(String cc, String nombre, String telefono, boolean aptoAdoptar) throws ENoEncontrado, EParamNoValidos {
		if (cc==null || nombre==null || telefono==null) throw new EParamNoValidos();
		
		int i = buscarClienteCc(cc);
		if (i==-1) throw new ENoEncontrado("No se encontro el cliente con cc "+cc);
		
		Cliente c = clientes[i];
		
		c.setName(nombre);
		c.setTelefono(telefono);
		c.setAptoAdoptar(aptoAdoptar);
	}
	
	public void subirAdopciones(File ruta) throws IOException {
		for (int i = 0; i < adopciones.length; i++) {
			adopciones[i].escribirObjeto(ruta+"\\Adopciones\\"+i+".ado");
		}
	}
	
	public void subirAnimales(File ruta) throws IOException {
		for (int i = 0; i < animales.length; i++) {
			animales[i].escribirObjeto(ruta+"\\Animales\\"+i+".ani");
		}
	}
	
	public void subirClientes(File ruta) throws IOException {
		for (int i = 0; i < clientes.length; i++) {
			clientes[i].escribirObjeto(ruta+"\\Clientes\\"+i+".cli");
		}
	}
	
	public void reingresoAnimal(String idAdopcion) throws EParamNoValidos, ENoEncontrado, ESinEspacio {
		if (idAdopcion==null) throw new EParamNoValidos();
		if (!hayEspacio()) throw new ESinEspacio();
		
		int i = buscarAdopcionId(idAdopcion);
		if (i==-1) throw new ENoEncontrado("No se encontro la adopcion con id "+idAdopcion);
		
		Adopcion adopcion = adopciones[i];
		
		adopcion.setVigencia(false);
		adopcion.getAnimal().setAdoptado(false);
	}


		// Getters and setters
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public Adopcion[] getAdopciones() {
		return adopciones;
	}
	public void setAdopciones(Adopcion[] adopciones) {
		this.adopciones = adopciones;
	}


	public Animal[] getAnimales() {
		return animales;
	}
	public void setAnimales(Animal[] animales) {
		this.animales = animales;
	}


	public Cliente[] getClientes() {
		return clientes;
	}
	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
}