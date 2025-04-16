import java.sql.Timestamp;
import java.util.UUID;

public class Notificaciones {
    private UUID idNotificacion;
    private Contactos Contacto;
    private String tipoNotificacion = "Alerta";
    private String mensaje;
    private boolean leida = false;
    private Timestamp fechaCreacion;

    // Constructor sin Parámetros 

     public Notificaciones() {
     }

    // Constructor con Parámetros

    public Notificaciones(Contactos contacto, String tipoNotificacion, String mensaje, boolean leida) {
        Contacto = contacto;
        this.tipoNotificacion = tipoNotificacion;
        this.mensaje = mensaje;
        this.leida = leida;
    }


    // Accesores

    public UUID getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(UUID idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Contactos getContacto() {
        return Contacto;
    }

    public void setContacto(Contactos contacto) {
        Contacto = contacto;
    }

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}