package Clases;

import java.util.Date;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Adopcion implements Serializable {
	private static final long serialVersionUID = 5L;
	public static int cantidad = 0;
	
	private String id;
	private Cliente cliente;
	private Animal animal;
	private Date fechaAdopcion;
	private boolean vigencia;
	
	public Adopcion(Cliente cliente, Animal animal) {
		this.id = "adopcion_"+ cantidad;
		this.cliente=cliente;
		this.animal=animal;
		this.fechaAdopcion = new Date();
		this.vigencia = true;
	}
	
	public void escribirObjeto(String address) throws IOException {
        FileOutputStream f =new FileOutputStream(address);
        ObjectOutputStream o=new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Date getFechaAdopcion() {
		return fechaAdopcion;
	}
	public void setFechaAdopcion(Date fechaAdopcion) {
		this.fechaAdopcion = fechaAdopcion;
	}

	public boolean isVigencia() {
		return vigencia;
	}
	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}

	@Override
	public String toString() {
		return "Adopcion [id=" + id + ", cliente=" + cliente + ", animal=" + animal + ", fechaAdopcion=" + fechaAdopcion
				+ ", vigencia=" + vigencia + "]";
	}
}
