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
	
	
	public Adopcion adoptarAnimal(String ccCliente, String idAnimal) throws EParamNoValidos, ENoEncontrado, EAdopcion {
		if (!validarString(ccCliente) || !validarString(idAnimal)) throw new EParamNoValidos();
		
		int ic = buscarClienteCc(ccCliente);
		if (ic==-1) throw new ENoEncontrado("No hay ningun cliente con el id "+ccCliente);
		
		int ia = buscarAnimalId(idAnimal);
		if (ia==-1) throw new ENoEncontrado("No hay ningun animal con el id "+idAnimal);
		
		
		if (!clientes[ic].isAptoAdoptar() || animales[ia].isAdoptado()) throw new EAdopcion("No se pudo realizar la adopcion");

		animales[ia].setAdoptado(true);
		
		Adopcion.cantidad = adopciones.length+1;
		Adopcion a = new Adopcion(clientes[ic], animales[ia]);
		
		adopciones = Arrays.copyOf(adopciones, adopciones.length+1);
		adopciones[adopciones.length-1] = a;
		
		return a;
	}
	
	public void addAnimal(String raza, String recomendaciones, int edad, double cantidadComida, boolean especial, Enfermedad[] enfermedades, boolean isPerro) throws EParamNoValidos, ESinEspacio {
		if (!validarString(raza) || edad<0 || cantidadComida<=0) throw new EParamNoValidos();
		if (!hayEspacio()) throw new ESinEspacio();

		Alimentacion alimentacion;
		Animal.cantidad = animales.length+1;
		animales = Arrays.copyOf(animales, animales.length+1);
		if (isPerro) {
			alimentacion = (especial) ? Alimentacion.ESPECIAL : Alimentacion.PERRO;
			animales[animales.length-1] = new Perro(raza, recomendaciones, edad, cantidadComida, alimentacion, enfermedades);
		} else {
			alimentacion = (especial) ? Alimentacion.ESPECIAL : Alimentacion.GATO;
			animales[animales.length-1] = new Gato(raza, recomendaciones, edad, cantidadComida, alimentacion, enfermedades);
		}
	}
	
	public void addCliente(String cc, String nombre, String telefono, boolean[] respuestas) throws EParamNoValidos, ENoEncontrado {
		if (!validarString(cc) || !validarString(nombre) || !validarString(telefono) || respuestas.length!=9 
				|| respuestas==null || !validarNumeros(telefono) || !validarNumeros(cc)) throw new EParamNoValidos();
		
		if (buscarClienteCc(cc)!=-1) throw new ENoEncontrado("El cliente con cedula "+cc+" ya existe");
		
		clientes = Arrays.copyOf(clientes, clientes.length+1);
		clientes[clientes.length-1] = new Cliente(cc, nombre, telefono, respuestas);
	}
	
	public Adopcion[] buscarAdopcion(boolean vigente, String input, String buscar, boolean usarVigencia) throws ENoEncontrado {
		Adopcion[] adopcionesBusqueda = new Adopcion[0];
		int id = -1;
		int[] busqueda = new int[0];
		
		if (validarString(input) && validarString(buscar)) {
			switch (buscar) {
				case "idAdopcion":
					id = buscarAdopcionId(input);
					break;
					
				case "idAnimal":
					busqueda = buscarAdopcionIdAnimal(input);
					for (int i = 0; i < busqueda.length; i++) {
						adopcionesBusqueda = busquedaAd(usarVigencia, vigente, adopciones[busqueda[i]], adopcionesBusqueda);
					}
					break;
					
				case "ccCliente":
					busqueda = buscarAdopcionCcCliente(input);
					for (int i = 0; i < busqueda.length; i++) {
						adopcionesBusqueda = busquedaAd(usarVigencia, vigente, adopciones[busqueda[i]], adopcionesBusqueda);
					}
					break;
	
				default:
					break;
			}

			if (id!=-1) {
				Adopcion a = adopciones[id];
				adopcionesBusqueda = busquedaAd(usarVigencia, vigente, a, adopcionesBusqueda);
			}
		} else {
			for (Adopcion a : this.adopciones) {
				adopcionesBusqueda = busquedaAd(usarVigencia, vigente, a, adopcionesBusqueda);
			}
		}
		
		if (adopcionesBusqueda.length<=0) throw new ENoEncontrado("No hay resultados para esta busqueda");
		 
		 return adopcionesBusqueda;
	}
	private Adopcion[] busquedaAd(boolean usarVigencia, boolean vigente, Adopcion a, Adopcion[] adopcionesBusqueda) {
		if (usarVigencia) {
			if (a.isVigencia()==vigente) {
				adopcionesBusqueda = Arrays.copyOf(adopcionesBusqueda, adopcionesBusqueda.length+1);
				adopcionesBusqueda[adopcionesBusqueda.length-1] = a;	
			}			
		} else {
			adopcionesBusqueda = Arrays.copyOf(adopcionesBusqueda, adopcionesBusqueda.length+1);
			adopcionesBusqueda[adopcionesBusqueda.length-1] = a;
		}
		return adopcionesBusqueda;
	}

	public int buscarAdopcionId(String id) {
		int i = -1;
		while (++i<adopciones.length && adopciones[i].getId().compareToIgnoreCase(id) != 0);

		return (i<adopciones.length)? i : -1;		
	}
	
	public int[] buscarAdopcionIdAnimal(String IdAnimal) {
		int[] adopcionesIdAnimal = new int[0];
		for(int i=0; i<adopciones.length; i++) {
			if(adopciones[i].getAnimal().getId().equalsIgnoreCase(IdAnimal)) {
				adopcionesIdAnimal = Arrays.copyOf(adopcionesIdAnimal, adopcionesIdAnimal.length+1);
				adopcionesIdAnimal[adopcionesIdAnimal.length-1] = i;
			}
		}
		return adopcionesIdAnimal;
	}
	
	public int[] buscarAdopcionCcCliente(String ccCliente) {
		int[] adopcionesCcCliente = new int[0];
		for(int i=0; i<adopciones.length; i++) {
			if(adopciones[i].getCliente().getCc().equalsIgnoreCase(ccCliente)) {
				adopcionesCcCliente = Arrays.copyOf(adopcionesCcCliente, adopcionesCcCliente.length+1);
				adopcionesCcCliente[adopcionesCcCliente.length-1] = i;
			}
		}
		return adopcionesCcCliente;
	}
	
	public Animal[] buscarAnimales(boolean disponible, String input, String buscar, String tipo, boolean usarDispo) throws EParamNoValidos, ENoEncontrado {
		Animal[] animalesBusqueda = new Animal[0];
		int[] busqueda = new int[0];
		
		if (validarString(input) && validarString(buscar)) {
			switch (buscar) {
				case "id":
					int id = buscarAnimalId(input);
					if (id!=-1) {
						animalesBusqueda = busquedaAn(usarDispo, disponible, tipo, animales[id], animalesBusqueda);
					}
					break;
					
				case "edad":
					try {
						int num = Integer.parseInt(input);
						busqueda = buscarAnimalEdad(num);
						for (int i = 0; i < busqueda.length; i++) {
							animalesBusqueda = busquedaAn(usarDispo, disponible, tipo, animales[busqueda[i]], animalesBusqueda);
						}
					} catch (NumberFormatException e) {
						throw new EParamNoValidos();
					}			
					break;
					
				case "raza":
					busqueda = buscarAnimalRaza(input);	
					for (int i = 0; i < busqueda.length; i++) {
						animalesBusqueda = busquedaAn(usarDispo, disponible, tipo, animales[busqueda[i]], animalesBusqueda);
					}			
					break;
	
				default:
					break;
			}
		} else {
			for (Animal a : this.animales) {
				animalesBusqueda = busquedaAn(usarDispo, disponible, tipo, a, animalesBusqueda);
			}
		}

		 if (animalesBusqueda.length<=0) throw new ENoEncontrado("No hay resultados para esta busqueda");
		 
		 return animalesBusqueda;
	}
	private Animal[] busquedaAn(boolean usarDispo, boolean disponible, String tipo, Animal a, Animal[] animalesBusqueda) {
		if (usarDispo) {
			if (a.isAdoptado()!=disponible) {
				if (tipo.equals("todos") || String.valueOf(a.getClass().getSimpleName()).equalsIgnoreCase(tipo)) {
					animalesBusqueda = Arrays.copyOf(animalesBusqueda, animalesBusqueda.length+1);
					animalesBusqueda[animalesBusqueda.length-1] = a;
				}
			}
		} else {
			if (tipo.equals("todos") || String.valueOf(a.getClass().getSimpleName()).equals(tipo)) {
				animalesBusqueda = Arrays.copyOf(animalesBusqueda, animalesBusqueda.length+1);
				animalesBusqueda[animalesBusqueda.length-1] = a;
			}
		}
		return animalesBusqueda;
	}
	
	public int buscarAnimalId(String id) {
		int i = -1;
		while (++i<animales.length && animales[i].getId().compareToIgnoreCase(id) != 0);

		return (i<animales.length)? i : -1;		
	}
	
	public int[] buscarAnimalTipo(String tipo) {
		int[] animalesPorTipo = new int[0];
		for(int i=0; i<animales.length; i++) {
			if(String.valueOf(animales[i].getClass().getSimpleName()).equalsIgnoreCase(tipo)) {
				animalesPorTipo = Arrays.copyOf(animalesPorTipo, animalesPorTipo.length+1);
				animalesPorTipo[animalesPorTipo.length-1] = i;
			}
		}
		
		return animalesPorTipo;
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
		for(int i=0; i<animales.length; i++) {
			if(animales[i].isAdoptado()==estaAdoptado) {
				animalesPorAdopcion = Arrays.copyOf(animalesPorAdopcion, animalesPorAdopcion.length+1);
				animalesPorAdopcion[animalesPorAdopcion.length-1] = i;
			}
		}
		
		return animalesPorAdopcion;
	}
	
	public Cliente[] buscarCliente(boolean aptoAdoptar, String input, String buscar, boolean usarApto) throws ENoEncontrado {
		Cliente[] clientesBusqueda = new Cliente[0];
		int index = -1;
		int[] busqueda = new int[0];
		
		if (validarString(input) && validarString(buscar)) {
			switch (buscar) {
				case "cc":
					index = buscarClienteCc(input);
					break;
					
				case "nombre":
					busqueda = buscarClienteNombre(input);
					for (int i = 0; i < busqueda.length; i++) {
						clientesBusqueda = busquedaC(usarApto, aptoAdoptar, clientes[busqueda[i]], clientesBusqueda);
					}
					break;
			}
			
			if (index!=-1) {
				Cliente c = clientes[index];
				clientesBusqueda = busquedaC(usarApto, aptoAdoptar, c, clientesBusqueda);
			}
		} else {
			for (Cliente c : this.clientes) {
				clientesBusqueda = busquedaC(usarApto, aptoAdoptar, c, clientesBusqueda);
			}
		}

		 if (clientesBusqueda.length<=0) throw new ENoEncontrado("No hay resultados para esta busqueda");
		 
		 return clientesBusqueda;
	}
	private Cliente[] busquedaC(boolean usarApto, boolean aptoAdoptar, Cliente c, Cliente[] clientesBusqueda) {
		// !usarApto: Si el circulo es blanco en la interfaz
		if (usarApto) {
			if (c.isAptoAdoptar()==aptoAdoptar) {
				clientesBusqueda = Arrays.copyOf(clientesBusqueda, clientesBusqueda.length+1);
				clientesBusqueda[clientesBusqueda.length-1] = c;	
			}						
		} else {
			clientesBusqueda = Arrays.copyOf(clientesBusqueda, clientesBusqueda.length+1);
			clientesBusqueda[clientesBusqueda.length-1] = c;
		}
		return clientesBusqueda;
	}
	
	public int buscarClienteCc(String cc) {
		int i = -1;
		while (++i<clientes.length && clientes[i].getCc().compareToIgnoreCase(cc) != 0);

		return (i<clientes.length)? i : -1;		
	}
	
	public int[] buscarClienteNombre(String nombre) {
		int[] clientesNombre = new int[0];
		for(int i=0; i<clientes.length; i++) {
			if(clientes[i].getName().equalsIgnoreCase(nombre)) {
				clientesNombre = Arrays.copyOf(clientesNombre, clientesNombre.length+1);
				clientesNombre[clientesNombre.length-1] = i;
			}
		}
		return clientesNombre;
	}
	
	public int[] buscarClienteAptoAdoptar(boolean esApto) {
		int[] clientesAptos = new int[0];
		for(int i=0; i<clientes.length; i++) {
			if(clientes[i].isAptoAdoptar()==esApto) {
				clientesAptos = Arrays.copyOf(clientesAptos, clientesAptos.length+1);
				clientesAptos[clientesAptos.length-1] = i;
			}
		}
		
		return clientesAptos;
	}
		
	public void cargarAdopciones(File ruta) throws IOException, ClassNotFoundException {
		File f = new File(ruta+"\\Adopciones\\");
		if (!f.exists()) f.mkdirs();
		File[] listaF = f.listFiles(new Filtro(".ado"));
		adopciones = new Adopcion[listaF.length];
		Adopcion.cantidad = listaF.length;
		
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
		if (!f.exists()) f.mkdirs();
		File[] listaF = f.listFiles(new Filtro(".ani"));
		animales = new Animal[listaF.length];
		Animal.cantidad = listaF.length;
		
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
		if (!f.exists()) f.mkdirs();
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
	
	public int getCantidadAnimales() {
		int cantidad = 0;
		for (Animal animal : animales) {
			if (!animal.isAdoptado()) cantidad++;
		}
		
		return cantidad;
	}
	
	public boolean hayEspacio() {
		return getCantidadAnimales()<capacidad;
	}
	
	public void modAnimal(Animal a, String raza, String recomendaciones, int edad, double cantidadComida, Alimentacion alimentacion, Enfermedad[] enfermedades) throws ENoEncontrado, EParamNoValidos {
		if (!validarString(raza) || edad<0 || cantidadComida<=0 || alimentacion==null) throw new EParamNoValidos();
				
		a.setRaza(raza);
		a.setRecomendaciones(recomendaciones);
		a.setEdad(edad);
		a.setCantidadComida(cantidadComida);
		a.setAlimentacion(alimentacion);
		a.addChequeo(enfermedades, recomendaciones);
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

	public void modCliente(Cliente c, String cc, String nombre, String telefono, boolean[] respuestasAdopcion) throws EParamNoValidos {
		if (!validarString(cc) || !validarString(nombre) || !validarString(telefono)) throw new EParamNoValidos();
		
		c.setName(nombre);
		c.setTelefono(telefono);
		c.setRespuestasAdopcion(respuestasAdopcion);
		c.setAptoAdoptar(c.clienteAptoAdoptar());
	}
	
	public void subirAdopciones(File ruta) throws EParamNoValidos, IOException {
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
	
	public void reingresoAnimal(Adopcion adopcion) throws EParamNoValidos, ENoEncontrado, ESinEspacio {
		if (adopcion==null) throw new EParamNoValidos();
		if (!hayEspacio()) throw new ESinEspacio();
		
		adopcion.setVigencia(false);
		adopcion.getAnimal().setAdoptado(false);
		
		int i = buscarAnimalId(adopcion.getAnimal().getId());
		animales[i].setAdoptado(false);
	}
	
	private static boolean validarString(String str) {
	    return !(str == null || str.trim().isEmpty());
	}
	private static boolean validarNumeros(String str) {
		return str.matches("\\d+");
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