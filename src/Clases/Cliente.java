package Clases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 6L;
	
	private String cc, name, telefono;
	private boolean aptoAdoptar;
	private boolean[] respuestasAdopcion;
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

		return puntaje>=14;
	}
	
	public void escribirObjeto(String address) throws IOException {
		FileOutputStream f = new FileOutputStream(address);
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(this);
		o.close();
		f.close();
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

	@Override
	public String toString() {
		return "Cliente [cc=" + cc + ", name=" + name + ", telefono=" + telefono + ", aptoAdoptar=" + aptoAdoptar
				+ ", respuestasAdopcion=" + Arrays.toString(respuestasAdopcion) + "]";
	}
}
