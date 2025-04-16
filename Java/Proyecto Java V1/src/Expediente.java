import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;


public class Expediente {        // Clase
    private UUID idExpediente;  // Atributos
    private String tituloExpediente;
    private String descripcion;
    private Timestamp fechaApertura;
    private Date fechaCierre;
    private BigDecimal precio; 
    private String estadoExpediente;
    private int posicionExpediente;
    private UUID creadoPor;
    private EtapaKanban etapaKanban;  // Asociación con clase EtapaKanban(1:n)

    // Constructor sin Parámetros 

    public Expediente() {
    }

    // Constructor con Parámetros 

    public Expediente(UUID creadoPor, String descripcion, String estadoExpediente, EtapaKanban etapaKanban, Timestamp fechaApertura, Date fechaCierre, UUID idExpediente, int posicionExpediente, BigDecimal precio, String tituloExpediente) {
        this.creadoPor = creadoPor;
        this.descripcion = descripcion;
        this.estadoExpediente = estadoExpediente;
        this.etapaKanban = etapaKanban;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.idExpediente = idExpediente;
        this.posicionExpediente = posicionExpediente;
        this.precio = precio;
        this.tituloExpediente = tituloExpediente;
    }
    // Accesores 

    public UUID getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(UUID idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getTituloExpediente() {
        return tituloExpediente;
    }

    public void setTituloExpediente(String tituloExpediente) {
        this.tituloExpediente = tituloExpediente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Timestamp fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getEstadoExpediente() {
        return estadoExpediente;
    }

    public void setEstadoExpediente(String estadoExpediente) {
        this.estadoExpediente = estadoExpediente;
    }

    public int getPosicionExpediente() {
        return posicionExpediente;
    }

    public void setPosicionExpediente(int posicionExpediente) {
        this.posicionExpediente = posicionExpediente;
    }

    public UUID getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(UUID creadoPor) {
        this.creadoPor = creadoPor;
    }

    public EtapaKanban getEtapaKanban() {
        return etapaKanban;
    }

    public void setEtapaKanban(EtapaKanban etapaKanban) {
        this.etapaKanban = etapaKanban;
    }
}