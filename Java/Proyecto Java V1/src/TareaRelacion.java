import java.util.UUID;

public class TareaRelacion {        // Clase
    private UUID idRelacionTarea;   // Atributo  
    private Tarea tarea; // Asociación con clase Tarea (1:n)
    private Expediente expediente; // Asociación con clase Expediente (1:n)
    private Contactos contacto;   // Asociación con clase Contactos (1:n)
    private int posicionTarea;
    private UUID creadoPor;

    // Constructor sin parámteros

    public TareaRelacion() {
    }

    // Constructor con parámetros

    public TareaRelacion(UUID idRelacionTarea, Tarea tarea, Expediente expediente, Contactos contacto,
            int posicionTarea, UUID creadoPor) {
        this.idRelacionTarea = idRelacionTarea;
        this.tarea = tarea;
        this.expediente = expediente;
        this.contacto = contacto;
        this.posicionTarea = posicionTarea;
        this.creadoPor = creadoPor;
    }

    // Accesores 

    public UUID getIdRelacionTarea() {
        return idRelacionTarea;
    }

    public void setIdRelacionTarea(UUID idRelacionTarea) {
        this.idRelacionTarea = idRelacionTarea;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
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

    public int getPosicionTarea() {
        return posicionTarea;
    }

    public void setPosicionTarea(int posicionTarea) {
        this.posicionTarea = posicionTarea;
    }

    public UUID getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(UUID creadoPor) {
        this.creadoPor = creadoPor;
    }  
}
