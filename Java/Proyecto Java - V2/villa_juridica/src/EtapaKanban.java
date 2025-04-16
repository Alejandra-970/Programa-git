public class EtapaKanban {      // Clase
    private int idEtapaKanban;  // Atributos 
    private String nombreEtapa;
    private String tipo;
    private String categoria;

    // Constructor sin Parámetros 

    public EtapaKanban () {
    }

    // Constructor con Parámetros (Con y sin idEtapaKanban)

    public EtapaKanban (int idEtapaKanban, String nombreEtapa, String tipo, String categoria)
    {
        this.idEtapaKanban = idEtapaKanban;
        this.nombreEtapa = nombreEtapa;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public EtapaKanban ( String nombreEtapa, String tipo, String categoria)
    {
        this.nombreEtapa = nombreEtapa;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    // Accesores

    public int getIdEtapaKanban() {
        return idEtapaKanban;
    }

    public void setIdEtapaKanban(int idEtapaKanban) {
        this.idEtapaKanban = idEtapaKanban;
    }

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    } 
}