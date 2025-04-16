import java.util.UUID;

public class NotaRelacion {
    private UUID idRelacionNota;
    private Nota nota; // Asociación con clase Nota (1:n)
    private Expediente expediente; // Asociación con clase Expediente (1:n)
    private Contactos contacto;   // Asociación con clase Contactos (1:n)
    private int posicionNota;
    private UUID creadoPor;

    // Constructor sin parámteros

    public NotaRelacion() {
    }

    // Constructor con parámetros

    public NotaRelacion(Contactos contacto, UUID creadoPor, Expediente expediente, UUID idRelacionNota, Nota nota, int posicionNota) {
        this.contacto = contacto;
        this.creadoPor = creadoPor;
        this.expediente = expediente;
        this.idRelacionNota = idRelacionNota;
        this.nota = nota;
        this.posicionNota = posicionNota;
    }

    // Accesores

    public UUID getIdRelacionNota() {
        return idRelacionNota;
    }

    public void setIdRelacionNota(UUID idRelacionNota) {
        this.idRelacionNota = idRelacionNota;
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

    public int getPosicionNota() {
        return posicionNota;
    }

    public void setPosicionNota(int posicionNota) {
        this.posicionNota = posicionNota;
    }

    public UUID getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(UUID creadoPor) {
        this.creadoPor = creadoPor;
    }
}
