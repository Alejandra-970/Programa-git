import java.util.UUID;

public class DocumentoExpediente {
    private UUID idRelacionDE;
    private Expediente expediente; // Asociación con clase Expediente (1:n)
    private Documento documento; // Asociación con clase Documento (1:n)

    // Constructor sin Parámetros 

    public DocumentoExpediente() {
    }
    
    // Constructor con Parámetros

    public DocumentoExpediente( Documento documento, Expediente expediente) {
        this.documento = documento;
        this.expediente = expediente;
    }

    // Accesores

    public UUID getIdRelacionDE() {
        return idRelacionDE;
    }

    public void setIdRelacionDE(UUID idRelacionDE) {
        this.idRelacionDE = idRelacionDE;
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
}
