import java.sql.Timestamp;
import java.util.UUID;

public class Documento {        // Clase
  private UUID idDocumento;    // Atributos
  private Timestamp fechaAgregado;
  private String nombreDocumento = "Nombre Pendiente";
  private String origenDocumento;
  private String enlaceDocumento; 
  private UUID creadoPor;

    // Constructor sin Parámetros 

    public Documento() {
    }
    
    // Constructor con Parámetros 

    public Documento(UUID creadoPor, String enlaceDocumento, Timestamp fechaAgregado, UUID idDocumento, String nombreDocumento, String origenDocumento) {
        this.creadoPor = creadoPor;
        this.enlaceDocumento = enlaceDocumento;
        this.fechaAgregado = fechaAgregado;
        this.idDocumento = idDocumento;
        this.nombreDocumento = nombreDocumento;
        this.origenDocumento = origenDocumento;
    }

    // Accesores 

    public UUID getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(UUID idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Timestamp getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(Timestamp fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getOrigenDocumento() {
        return origenDocumento;
    }

    public void setOrigenDocumento(String origenDocumento) {
        this.origenDocumento = origenDocumento;
    }

    public String getEnlaceDocumento() {
        return enlaceDocumento;
    }

    public void setEnlaceDocumento(String enlaceDocumento) {
        this.enlaceDocumento = enlaceDocumento;
    }

    public UUID getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(UUID creadoPor) {
        this.creadoPor = creadoPor;
    }
}