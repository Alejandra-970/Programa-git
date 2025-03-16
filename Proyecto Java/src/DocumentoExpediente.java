import java.util.UUID;

public class DocumentoExpediente {
    private UUID idRelacionDocumentoExpediente;
    private Expediente expediente; // Asociación con clase Expediente (1:n)
    private Documento documento; // Asociación con clase Documento (1:n)
    private int numeracion; 
    private UUID creadoPor;

    // Constructor sin Parámetros 

    public DocumentoExpediente() {
    }
    
    // Constructor con Parámetros

    public DocumentoExpediente(UUID creadoPor, Documento documento, Expediente expediente, UUID idRelacionDocumentoExpediente, int numeracion) {
        this.creadoPor = creadoPor;
        this.documento = documento;
        this.expediente = expediente;
        this.idRelacionDocumentoExpediente = idRelacionDocumentoExpediente;
        this.numeracion = numeracion;
    }

    // Accesores

    public UUID getIdRelacionDocumentoExpediente() {
        return idRelacionDocumentoExpediente;
    }

    public void setIdRelacionDocumentoExpediente(UUID idRelacionDocumentoExpediente) {
        this.idRelacionDocumentoExpediente = idRelacionDocumentoExpediente;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    public UUID getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(UUID creadoPor) {
        this.creadoPor = creadoPor;
    }
}
