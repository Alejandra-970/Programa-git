import java.sql.Timestamp;
import java.util.UUID;

public class Nota {     // Clase
    private UUID idNota; // Atributos 
    private String tituloNota;
    private String contenidoNota;
    private Timestamp fechCreacion;
    private String tipoNota;
    private UUID creadoPor;
    private EtapaKanban etapaKanban; // Asociación con EtapaKanban (1:n)

    // Constructor sin Parámetros 

    public Nota() {
    }

    // Constructor con Parámetros 

    public Nota(String contenidoNota, UUID creadoPor, EtapaKanban etapaKanban, Timestamp fechCreacion, UUID idNota, String tipoNota, String tituloNota) {
        this.contenidoNota = contenidoNota;
        this.creadoPor = creadoPor;
        this.etapaKanban = etapaKanban;
        this.fechCreacion = fechCreacion;
        this.idNota = idNota;
        this.tipoNota = tipoNota;
        this.tituloNota = tituloNota;
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

    public Timestamp getFechCreacion() {
        return fechCreacion;
    }

    public void setFechCreacion(Timestamp fechCreacion) {
        this.fechCreacion = fechCreacion;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
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