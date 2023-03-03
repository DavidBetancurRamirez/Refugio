import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Date;

import Clases.*;
import Excepciones.*;

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
	
	
	public void adoptarAnimal(String idCliente, String idAnimal) throws EParamNoValidos, ENoEncontrado, EAdopcion {
		if (idCliente==null || idAnimal==null) new EParamNoValidos();
		
		int ic = buscarCliente(idCliente);
		if (ic==-1) throw new ENoEncontrado("No hay ningun cliente con el id "+idCliente);
		
		int ia = buscarAnimal(idAnimal);
		if (ia==-1) throw new ENoEncontrado("No hay ningun animal con el id "+idAnimal);
		
		
		if (!clientes[ic].isAptoAdoptar() || animales[ia].isAdoptado()) throw new EAdopcion("No se pudo realizar la adopcion");
		
		adopciones = Arrays.copyOf(adopciones, adopciones.length+1);
		adopciones[adopciones.length-1] = new Adopcion(clientes[ic], animales[ia]);
		
		animales[ia].setAdoptado(true);
	}
	
	public void addAnimal(String raza, String recomendaciones, int edad, double cantidadComida, Alimentacion alimentacion, Enfermedad[] enfermedades, boolean isPerro) throws EParamNoValidos, ESinEspacio {
		if (raza==null || recomendaciones==null || edad<0 || cantidadComida<=0 || alimentacion==null || enfermedades==null) throw new EParamNoValidos();
		if (!hayEspacio()) throw new ESinEspacio();
		
		animales = Arrays.copyOf(animales, animales.length+1);
		
		if (isPerro) animales[animales.length-1] = new Perro(raza, recomendaciones, edad, cantidadComida, alimentacion, enfermedades);
		else animales[animales.length-1] = new Gato(raza, recomendaciones, edad, cantidadComida, alimentacion, enfermedades);
	}
	
	public void addCliente(String cc, String nombre, String telefono, boolean[] respuestas) throws EParamNoValidos {
		if (cc==null || nombre==null || telefono==null || respuestas.length!=9) throw new EParamNoValidos();
		
		clientes = Arrays.copyOf(clientes, clientes.length+1);
		clientes[clientes.length-1] = new Cliente(cc, nombre, telefono, respuestas);
	}
	
	public int buscarAdopcion(String id) {
		int i = -1;
		while (++i<adopciones.length && adopciones[i].getId().toLowerCase().compareTo(id) != 0);

		return (i<adopciones.length)? i : -1;		
	}
	
	public int buscarAnimal(String id) {
		int i = -1;
		while (++i<animales.length && animales[i].getId().toLowerCase().compareTo(id) != 0);

		return (i<animales.length)? i : -1;		
	}
	
	public int buscarCliente(String cc) {
		int i = -1;
		while (++i<clientes.length && clientes[i].getCc().toLowerCase().compareTo(cc) != 0);

		return (i<clientes.length)? i : -1;		
	}
	
	public void cargarAdopciones(String ruta) throws IOException, ClassNotFoundException {
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
	
	public void cargarAnimales(String ruta) throws IOException, ClassNotFoundException {
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
	
	public void cargarClientes(String ruta) throws IOException, ClassNotFoundException {
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
		int i = buscarAdopcion(id);
		if (i==-1) throw new ENoEncontrado("No se encontro la adopcion con id "+id);;
		
		System.arraycopy(adopciones, i+1, adopciones, i, adopciones.length-i-1);
		adopciones = Arrays.copyOf(adopciones, adopciones.length-1);
	}
	
	public void eliminarAnimal(String id) throws ENoEncontrado {
		int i = buscarAnimal(id);
		if (i==-1) throw new ENoEncontrado("No se encontro el animal con id "+id);
		
		
		System.arraycopy(animales, i+1, animales, i, animales.length-i-1);
		animales = Arrays.copyOf(animales, animales.length-1);
	}

	public void eliminarCliente(String cc) throws ENoEncontrado {
		int i = buscarCliente(cc);
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
		int i = buscarAnimal(id);
		if (i==-1) throw new ENoEncontrado("No se encontro el animal con id "+id);
		
		Animal a = animales[i];
		
		// Abrir formulario animal con los datos del animal
	}
	
	public boolean hayEspacio() {
		return (getCantidadAnimales()<capacidad) ? true : false;
	}
	
	public void modAnimal(String id, String raza, String recomendaciones, int edad, double cantidadComida, Alimentacion alimentacion) throws ENoEncontrado, EParamNoValidos {
		if (raza==null || recomendaciones==null || edad<0 || cantidadComida<=0 || alimentacion==null) throw new EParamNoValidos();
		
		int i = buscarAnimal(id);
		if (i==-1) throw new ENoEncontrado("No se encontro el animal con id "+id);
		
		Animal a = animales[i];
		
		a.setRaza(raza);
		a.setRecomendaciones(recomendaciones);
		a.setEdad(edad);
		a.setCantidadComida(cantidadComida);
		a.setAlimentacion(alimentacion);
	}
	
	public void modAdopcion(String id, Cliente cliente, Animal animal, Date fechaAdopcion) throws ENoEncontrado, EParamNoValidos {
		if (id==null || cliente==null || animal==null || fechaAdopcion==null) throw new EParamNoValidos();
		
		int i = buscarAdopcion(id);
		if (i==-1) throw new ENoEncontrado("No se encontro la adopcion con id "+id);
		
		Adopcion a = adopciones[i];

		a.setCliente(cliente);
		a.setAnimal(animal);
		a.setFechaAdopcion(fechaAdopcion);
	}
	
	public void modCliente(String cc, String nombre, String telefono, boolean aptoAdoptar) throws ENoEncontrado, EParamNoValidos {
		if (cc==null || nombre==null || telefono==null) throw new EParamNoValidos();
		
		int i = buscarCliente(cc);
		if (i==-1) throw new ENoEncontrado("No se encontro el cliente con cc "+cc);
		
		Cliente c = clientes[i];
		
		c.setName(nombre);
		c.setTelefono(telefono);
		c.setAptoAdoptar(aptoAdoptar);
	}
	
	public void subirAdopciones(String ruta) throws IOException {
		for (int i = 0; i < adopciones.length; i++) {
			adopciones[i].escribirObjeto(ruta+"\\Adopciones\\"+i+".ado");
		}
	}
	
	public void subirAnimales(String ruta) throws IOException {
		for (int i = 0; i < animales.length; i++) {
			animales[i].escribirObjeto(ruta+"\\Animales\\"+i+".ani");
		}
	}
	
	public void subirClientes(String ruta) throws IOException {
		for (int i = 0; i < clientes.length; i++) {
			clientes[i].escribirObjeto(ruta+"\\Clientes\\"+i+".cli");
		}
	}
	
	public void reingresoAnimal(String idAdopcion) throws EParamNoValidos, ENoEncontrado, ESinEspacio {
		if (idAdopcion==null) throw new EParamNoValidos();
		if (!hayEspacio()) throw new ESinEspacio();
		
		int i = buscarAdopcion(idAdopcion);
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