package Clases;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class Chequeo implements Serializable {
	private static final long serialVersionUID = 2L;
	
	private String id;
    private Date fecha;
    private Enfermedad[] enfermedades;
    private String recomendacion;

    public Chequeo(Enfermedad[] enfermedades, String recomendacion, int cantidad) {
		this.id = "chequeo_"+ cantidad++;
		this.fecha = new Date();
        this.enfermedades = enfermedades;
        this.recomendacion = recomendacion;
    }
    
    public String getRecomendacion() {
    	return recomendacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Enfermedad[] getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(Enfermedad[] enfermedades) {
        this.enfermedades = enfermedades;
    }

	@Override
	public String toString() {
		return "Chequeo [id=" + id + ", fecha=" + fecha + ", enfermedades=" + Arrays.toString(enfermedades) + "]";
	}
}
