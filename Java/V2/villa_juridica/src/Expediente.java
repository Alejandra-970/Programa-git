import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;


public class Expediente {       // Clase
    private UUID idExpediente; // Atributos
    private String tituloExpediente;
    private String areaExpediente = "especialidad sin nombre";
    private String descripcion;
    private Timestamp fechaApertura;
    private Date fechaCierre;
    private BigDecimal precio;
    private String radicado;
    private Date fechaRadicado;
    private String ciudadExp;
    private String estadoExpediente = "activo";
    private UUID creadoPor;
    private EtapaKanban etapaKanban;  // Asociación con clase EtapaKanban(1:n)

    // Constructor sin Parámetros 

    public Expediente() {
    }

    // Constructor con Parámetros

    public Expediente(String tituloExpediente, String areaExpediente, String descripcion, Date fechaCierre, BigDecimal precio, String radicado, Date fechaRadicado, String ciudadExp, String estadoExpediente, UUID creadoPor, EtapaKanban etapaKanban) {
        this.tituloExpediente = tituloExpediente;
        this.areaExpediente = areaExpediente;
        this.descripcion = descripcion;
        this.fechaCierre = fechaCierre;
        this.precio = precio;
        this.radicado = radicado;
        this.fechaRadicado = fechaRadicado;
        this.ciudadExp = ciudadExp;
        this.estadoExpediente = estadoExpediente;
        this.creadoPor = creadoPor;
        this.etapaKanban = etapaKanban;
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

    public String getAreaExpediente() {
        return areaExpediente;
    }

    public void setAreaExpediente(String areaExpediente) {
        this.areaExpediente = areaExpediente;
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

    public String getRadicado() {
        return radicado;
    }

    public void setRadicado(String radicado) {
        this.radicado = radicado;
    }

    public Date getFechaRadicado() {
        return fechaRadicado;
    }

    public void setFechaRadicado(Date fechaRadicado) {
        this.fechaRadicado = fechaRadicado;
    }

    public String getCiudadExp() {
        return ciudadExp;
    }

    public void setCiudadExp(String ciudadExp) {
        this.ciudadExp = ciudadExp;
    }

    public String getEstadoExpediente() {
        return estadoExpediente;
    }

    public void setEstadoExpediente(String estadoExpediente) {
        this.estadoExpediente = estadoExpediente;
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


