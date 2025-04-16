public class Roles {     // Clase
    private int idRol;  // Atrbibutos 
    private String nombreRol;

    // Constructor sin parámetros 

    public Roles() {
    }

    // Constructor con parámetros

    public Roles(int idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    // Accesores

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}