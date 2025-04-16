import java.sql.Date;
import java.util.UUID;

public class Tarea {        // Clase
    private UUID idTarea;  // Atributos 
    private boolean esPrivado;
    private String nombreTarea;
    private String descripcionTarea;
    private Date fechaVencimiento;
    private UUID creadoPor;
    private EtapaKanban etapaKanban; // Asociación con EtapaKanban (1:n)

    // Constructor sin Parámetros 

    public Tarea() {
    }

    // Constructor con Parámetros 

    public Tarea(UUID creadoPor, String descripcionTarea, boolean esPrivado, EtapaKanban etapaKanban, Date fechaVencimiento, UUID idTarea, String nombreTarea) {
        this.creadoPor = creadoPor;
        this.descripcionTarea = descripcionTarea;
        this.esPrivado = esPrivado;
        this.etapaKanban = etapaKanban;
        this.fechaVencimiento = fechaVencimiento;
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
    }

    // Accesores

    public UUID getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(UUID idTarea) {
        this.idTarea = idTarea;
    }

    public boolean isEsPrivado() {
        return esPrivado;
    }

    public void setEsPrivado(boolean esPrivado) {
        this.esPrivado = esPrivado;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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