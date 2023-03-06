package Clases;

import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Adopcion implements Serializable {
	private static final long serialVersionUID = 5L;
	private static int cantidad = 0;
	
	private String id;
	private Cliente cliente;
	private Animal animal;
	private Date fechaAdopcion;
	private boolean vigencia;
	
	public Adopcion(Cliente cliente, Animal animal) {
		this.id = "adopcion_"+ ++cantidad;
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

    public void leerObjeto(File f)throws IOException,ClassNotFoundException{
        FileInputStream in = new FileInputStream(f);
        ObjectInputStream o=new ObjectInputStream(in);
        Adopcion ad=(Adopcion) o.readObject();
        this.cliente = ad.cliente;
        this.animal = ad.animal;
        o.close();
        in.close();
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
