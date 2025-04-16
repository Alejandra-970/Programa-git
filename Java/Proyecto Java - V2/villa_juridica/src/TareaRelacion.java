import java.util.UUID;

public class TareaRelacion {        // Clase
    private UUID idRelacionT;   // Atributo
    private Tarea tarea; // Asociación con clase Tarea (1:n)
    private Expediente expediente; // Asociación con clase Expediente (1:n)
    private Contactos contacto;   // Asociación con clase Contactos (1:n)
    private String rolAsignado;

    // Constructor sin parámteros

    public TareaRelacion() {
    }

    // Constructor con parámetros

    public TareaRelacion(Tarea tarea, Expediente expediente, Contactos contacto, String rolAsignado) {
        this.tarea = tarea;
        this.expediente = expediente;
        this.contacto = contacto;
        this.rolAsignado = rolAsignado;
    }


    // Accesores 


    public UUID getIdRelacionT() {
        return idRelacionT;
    }

    public void setIdRelacionT(UUID idRelacionT) {
        this.idRelacionT = idRelacionT;
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

    public String getrolAsignado() {
        return rolAsignado;
    }

    public void setrolAsignado(String rolAsignado) {
        this.rolAsignado = rolAsignado;
    }
}
