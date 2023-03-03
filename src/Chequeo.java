import java.util.Date;

public class Chequeo {

    private String id;
    private Date fecha;
    private Enfermedad[] enfermedades;

    public Chequeo(Enfermedad[] enfermedades) {
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
}
