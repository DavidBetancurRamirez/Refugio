package Clases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public abstract class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	public static int cantidad = 0;
	
	protected String id;
    protected String raza;
    protected String recomendaciones;
    protected int edad;
    protected double cantidadComida;
    protected boolean adoptado;
    protected Alimentacion alimentacion;
    protected Chequeo[] chequeos;

    
    public Animal(String raza, String recomendaciones, int edad, double cantidadComida, Alimentacion alimentacion, Enfermedad[] enfermedades) {
		this.id = "animal_"+ cantidad;
        this.raza = raza;
        this.recomendaciones = recomendaciones;
        this.edad = edad;
        this.cantidadComida = cantidadComida;
        this.alimentacion = alimentacion;
        this.chequeos = new Chequeo[0];
        addChequeo(enfermedades, recomendaciones);
    }

    public void addChequeo(Enfermedad[] enfermedades, String recomendacion) {
        chequeos= Arrays.copyOf(chequeos,chequeos.length+1);
	    chequeos[chequeos.length-1]=new Chequeo(enfermedades, recomendacion, chequeos.length);
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

	public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }
    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getCantidadComida() {
        return cantidadComida;
    }
    public void setCantidadComida(double cantidadComida) {
        this.cantidadComida = cantidadComida;
    }
    
    public boolean isAdoptado() {
        return adoptado;
    }
    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }
    
    public Alimentacion getAlimentacion() {
        return alimentacion;
    }
    public void setAlimentacion(Alimentacion alimentacion) {
        this.alimentacion = alimentacion;
    }

    public Chequeo[] getChequeos() {
        return chequeos;
    }
    public void setChequeos(Chequeo[] chequeos) {
        this.chequeos = chequeos;
    }

	@Override
	public String toString() {
		return "Animal [id=" + id + ", raza=" + raza + ", recomendaciones=" + recomendaciones + ", edad=" + edad
				+ ", cantidadComida=" + cantidadComida + ", adoptado=" + adoptado + ", alimentacion=" + alimentacion
				+ ", chequeos=" + Arrays.toString(chequeos) + "]";
	}
}
