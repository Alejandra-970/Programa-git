import java.util.UUID;

public class EventoRelacion {        // Clase
    private UUID idRelacionE;   // Atributo
    private Evento evento; // Asociación con clase Evento (1:n)
    private Expediente expediente; // Asociación con clase Expediente (1:n)
    private Contactos contacto;   // Asociación con clase Contactos (1:n)

     // Constructor sin parámteros

     public EventoRelacion() {
    }

    // Constructor con parámetros

    public EventoRelacion(Evento evento, Expediente expediente, Contactos contacto) {
        this.evento = evento;
        this.expediente = expediente;
        this.contacto = contacto;
    }


    // Accesores


    public UUID getIdRelacionE() {
        return idRelacionE;
    }

    public void setIdRelacionE(UUID idRelacionE) {
        this.idRelacionE = idRelacionE;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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