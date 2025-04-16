import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

public class Tarea {        // Clase
    private UUID idTarea;  // Atributos
    private Timestamp fechaCreacion;
    private boolean esPrivado = false;
    private String nombreTarea;
    private String descripcionTarea;
    private Date fechaVencimiento;
    private String prioridad = "sin asignar";
    private UUID creadoPor;
    private EtapaKanban etapaKanban; // Asociación con EtapaKanban (1:n)

    // Constructor sin Parámetros 

    public Tarea() {
    }

    // Constructor con Parámetros

    public Tarea(boolean esPrivado, String nombreTarea, String descripcionTarea, Date fechaVencimiento, String prioridad, UUID creadoPor, EtapaKanban etapaKanban) {
        this.esPrivado = esPrivado;
        this.nombreTarea = nombreTarea;
        this.descripcionTarea = descripcionTarea;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.creadoPor = creadoPor;
        this.etapaKanban = etapaKanban;
    }


    // Accesores


    public UUID getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(UUID idTarea) {
        this.idTarea = idTarea;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
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