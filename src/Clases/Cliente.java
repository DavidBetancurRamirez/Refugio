package Clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 6L;
	
	private String cc, name, telefono;
	private boolean aptoAdoptar;
	private boolean[] respuestasAdopcion;
	
	private static final String[] preguntasAdopcion = {
			"¿Ha adoptado algun animal en el pasado?",
			"¿Tiene otros animales en la casa?",
			"¿Estan vacunados los otros animales en su casa? (En caso de no tener mas animales, responda que si)", 
			"¿Es su casa segura para un perro o un gato?",
			"¿Conoce los gastos y cuidados que implicará incorporar un animal y está dispuesto a asumirlos?",
			"¿Posee algún espacio al aire libre?", 
			"¿Tiene certeza que permiten tener animales en su residencia?",
			"¿Todas las personas que viven en su casa están de acuerdo con esta adopción?",
			"¿Está al tanto de que el animal necesitará un período aproximado de 15 a 30 días para adaptarse a su nueva familia, horarios, lugares, etc.?" 
	};
	private static final int[] puntosFormulario = {5,3,4,5,3,2,2,2,2};

	public Cliente(String cc, String name, String telefono, boolean[] respuestasAdopcion) {
		this.cc = cc;
		this.name = name;
		this.telefono = telefono;
		this.respuestasAdopcion = respuestasAdopcion;
		this.aptoAdoptar = clienteAptoAdoptar();
	}

	public boolean clienteAptoAdoptar() {
		int puntaje = 0;

		for(int i=0; i<9; i++) {
			if(respuestasAdopcion[i]) {
				puntaje+=puntosFormulario[i];
			}
		}

		return (puntaje>=14) ? true : false;
	}
	
	public void escribirObjeto(String address) throws IOException {
		FileOutputStream f = new FileOutputStream(address);
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(this);
		o.close();
		f.close();
	}

	public void leerObjetos(File f) throws IOException, ClassNotFoundException {
		FileInputStream in = new FileInputStream(f);
		ObjectInputStream o = new ObjectInputStream(in);
		Cliente cl = (Cliente) o.readObject();
		this.cc = cl.cc;
		this.name = cl.name;
		this.telefono = cl.telefono;
		o.close();
		in.close();
	}

	
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public boolean[] getRespuestasAdopcion() {
		return respuestasAdopcion;
	}
	public void setRespuestasAdopcion(boolean[] respuestasAdopcion) {
		this.respuestasAdopcion = respuestasAdopcion;
	}

	public boolean isAptoAdoptar() {
		return aptoAdoptar;
	}
	public void setAptoAdoptar(boolean aptoAdoptar) {
		this.aptoAdoptar = aptoAdoptar;
	}
}
