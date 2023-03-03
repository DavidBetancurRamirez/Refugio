package Clases;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class Chequeo implements Serializable {
	private static final long serialVersionUID = 2L;
	private static int cantidad = 0;
	
	private String id;
    private Date fecha;
    private Enfermedad[] enfermedades;

    public Chequeo(Enfermedad[] enfermedades) {
		this.id = "chequeo_"+ ++cantidad;
        this.enfermedades = enfermedades;
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
