import java.util.UUID;

public class NotaRelacion {
    private UUID idRelacionN;
    private Nota nota; // Asociación con clase Nota (1:n)
    private Expediente expediente; // Asociación con clase Expediente (1:n)
    private Contactos contacto;

    // Constructor sin parámteros

    public NotaRelacion() {
    }

    // Constructor con parámetros

    public NotaRelacion(Nota nota, Expediente expediente, Contactos contacto) {
        this.nota = nota;
        this.expediente = expediente;
        this.contacto = contacto;
    }

    // Accesores


    public UUID getIdRelacionN() {
        return idRelacionN;
    }

    public void setIdRelacionNota(UUID idRelacionN) {
        this.idRelacionN = idRelacionN;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Contactos getContacto() {
        return contacto;
    }

    public void setContacto(Contactos contacto) {
        this.contacto = contacto;
    }
}
