import java.util.UUID;

public class ExpedienteContacto {
    private UUID idRelacion;
    private Expediente expediente; // Asociación con clase Expediente (1:n)
    private Contactos contacto;   // Asociación con clase Contactos (1:n)
    private String RolContacto;
    
    // Constructor sin parámteros

    public ExpedienteContacto() {
    }

    // Constructor con parámetros

    public ExpedienteContacto(String RolContacto, Contactos contacto, Expediente expediente) {
        this.RolContacto = RolContacto;
        this.contacto = contacto;
        this.expediente = expediente;
    }
    
    // Accesores

    public UUID getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(UUID idRelacion) {
        this.idRelacion = idRelacion;
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

    public String getRolContacto() {
        return RolContacto;
    }

    public void setRolContacto(String RolContacto) {
        this.RolContacto = RolContacto;
    }
}
