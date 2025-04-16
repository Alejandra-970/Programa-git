import java.time.LocalDateTime;
import java.util.UUID;

public class Evento {       // Clase
    private UUID idEvento; // Atributos
    private String tituloEvento;
    private String descripcionEvento;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Boolean allDay;
    private LocalDateTime recordatorio;
    private String tipoEvento = "Sin Asignar";
    private String lugarEvento;
    private String adjuntoEvento;
    private UUID creadoPor;
    private EtapaKanban etapaKanban; // Asociación con EtapaKanban (1:n)

    // Constructor sin Parámetros 

    public Evento() {
    }

    // Constructor con Parámetros

    public Evento(String tituloEvento, String descripcionEvento, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Boolean allDay, LocalDateTime recordatorio, String tipoEvento, String lugarEvento, String adjuntoEvento, UUID creadoPor, EtapaKanban etapaKanban) {
        this.tituloEvento = tituloEvento;
        this.descripcionEvento = descripcionEvento;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.allDay = allDay;
        this.recordatorio = recordatorio;
        this.tipoEvento = tipoEvento;
        this.lugarEvento = lugarEvento;
        this.adjuntoEvento = adjuntoEvento;
        this.creadoPor = creadoPor;
        this.etapaKanban = etapaKanban;
    }


    // Accesores 


    public UUID getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(UUID idEvento) {
        this.idEvento = idEvento;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public LocalDateTime getRecordatorio() {
        return recordatorio;
    }

    public void setRecordatorio(LocalDateTime recordatorio) {
        this.recordatorio = recordatorio;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getLugarEvento() {
        return lugarEvento;
    }

    public void setLugarEvento(String lugarEvento) {
        this.lugarEvento = lugarEvento;
    }

    public String getAdjuntoEvento() {
        return adjuntoEvento;
    }

    public void setAdjuntoEvento(String adjuntoEvento) {
        this.adjuntoEvento = adjuntoEvento;
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