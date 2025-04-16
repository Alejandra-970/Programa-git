import java.util.UUID;
import javax.swing.text.DateFormatter;

public class Evento {       // Clase
    private UUID idEvento;  // Atributos 
    private String tituloEvento;
    private String descripcionEvento;
    private DateFormatter fechaHora;
    private String tipoEvento;
    private String lugarEvento;
    private UUID creadoPor;
    private EtapaKanban etapaKanban; // Asociación con EtapaKanban (1:n)

    // Constructor sin Parámetros 

    public Evento() {
    }

    // Constructor con Parámetros

    public Evento(UUID idEvento, String tituloEvento, String descripcionEvento, DateFormatter fechaHora,
            String tipoEvento, String lugarEvento, UUID creadoPor, EtapaKanban etapaKanban) {
        this.idEvento = idEvento;
        this.tituloEvento = tituloEvento;
        this.descripcionEvento = descripcionEvento;
        this.fechaHora = fechaHora;
        this.tipoEvento = tipoEvento;
        this.lugarEvento = lugarEvento;
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

    public DateFormatter getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(DateFormatter fechaHora) {
        this.fechaHora = fechaHora;
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