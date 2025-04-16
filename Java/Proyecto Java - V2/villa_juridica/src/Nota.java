import java.sql.Timestamp;
import java.util.UUID;

public class Nota {     // Clase
    private UUID idNota;
    private String tituloNota; // Atributos
    private String contenidoNota;
    private Timestamp fechaCreacion;
    private UUID creadoPor;
    private String tipoNota = "personal";
    private EtapaKanban etapaKanban; // Asociación con EtapaKanban (1:n)

    // Constructor sin Parámetros 

    public Nota() {
    }

    // Constructor con Parámetros

    public Nota(String tituloNota, String contenidoNota, UUID creadoPor, String tipoNota, EtapaKanban etapaKanban) {
        this.tituloNota = tituloNota;
        this.contenidoNota = contenidoNota;
        this.creadoPor = creadoPor;
        this.tipoNota = tipoNota;
        this.etapaKanban = etapaKanban;
    }

    // Accesores


    public UUID getIdNota() {
        return idNota;
    }

    public void setIdNota(UUID idNota) {
        this.idNota = idNota;
    }

    public String getTituloNota() {
        return tituloNota;
    }

    public void setTituloNota(String tituloNota) {
        this.tituloNota = tituloNota;
    }

    public String getContenidoNota() {
        return contenidoNota;
    }

    public void setContenidoNota(String contenidoNota) {
        this.contenidoNota = contenidoNota;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public UUID getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(UUID creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    public EtapaKanban getEtapaKanban() {
        return etapaKanban;
    }

    public void setEtapaKanban(EtapaKanban etapaKanban) {
        this.etapaKanban = etapaKanban;
    }
}