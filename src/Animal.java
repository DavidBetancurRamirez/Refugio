import java.io.*;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;

public abstract class Animal {
    protected String ID;
    protected String raza;
    protected String recomendaciones;
    protected int edad;
    protected double cantidadComida;
    protected boolean adoptado;
    protected Alimentacion alimentacion;


    protected Chequeo[] chequeos;

    protected Enfermedad[] enfermedades;

    public Animal(String raza, String recomendaciones, int edad, double cantidadComida, Alimentacion alimentacion, Enfermedad[] enfermedades) {
        this.raza = raza;
        this.recomendaciones = recomendaciones;
        this.edad = edad;
        this.cantidadComida = cantidadComida;
        this.alimentacion = alimentacion;
        this.enfermedades = enfermedades;
    }

    public void addChequeo(Enfermedad[] enfermedades){
    if (chequeos==null){
        chequeos=new Chequeo[1];
    }else{
        chequeos= Arrays.copyOf(chequeos,chequeos.length+1);
    }
    chequeos[chequeos.length-1]=new Chequeo(enfermedades);
    }

    public void escribirObjeto(String address) throws IOException {
        FileOutputStream f =new FileOutputStream(address);
        ObjectOutputStream o=new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    public void leerObjetos(File f)throws IOException,ClassNotFoundException{
        FileInputStream in = new FileInputStream(f);
        ObjectInputStream o=new ObjectInputStream(in);
        Animal est=(Animal) o.readObject();
        this.raza = est.raza;
        this.recomendaciones = est.recomendaciones;
        this.edad = est.edad;
        this.cantidadComida = est.cantidadComida;
        this.alimentacion =est.alimentacion;
        o.close();
        in.close();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
}
