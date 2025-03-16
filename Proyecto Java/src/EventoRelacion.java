import java.util.UUID;

public class EventoRelacion {        // Clase
    private UUID idRelacionEvento;   // Atributo  
    private Evento evento; // Asociación con clase Evento (1:n)
    private Expediente expediente; // Asociación con clase Expediente (1:n)
    private Contactos contacto;   // Asociación con clase Contactos (1:n)
    private int posicionEvento;
    private UUID creadoPor;

     // Constructor sin parámteros

     public EventoRelacion() {
    }

    // Constructor con parámetros

    public EventoRelacion(Contactos contacto, UUID creadoPor, Evento evento, Expediente expediente, UUID idRelacionEvento, int posicionEvento) {
        this.contacto = contacto;
        this.creadoPor = creadoPor;
        this.evento = evento;
        this.expediente = expediente;
        this.idRelacionEvento = idRelacionEvento;
        this.posicionEvento = posicionEvento;
    }

    // Accesores

    public UUID getIdRelacionEvento() {
        return idRelacionEvento;
    }

    public void setIdRelacionEvento(UUID idRelacionEvento) {
        this.idRelacionEvento = idRelacionEvento;
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

    public int getPosicionEvento() {
        return posicionEvento;
    }

    public void setPosicionEvento(int posicionEvento) {
        this.posicionEvento = posicionEvento;
    }

    public UUID getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(UUID creadoPor) {
        this.creadoPor = creadoPor;
    }
}