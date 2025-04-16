import java.util.UUID;

public class Contactos { // Clase
    private UUID idContacto; // Atributos
    private String persona = "sin asignar";
    private String tipoDocumento = "sin asignar";
    private String documento;
    private String nombre;
    private String segundoNombre;
    private String apellido;
    private String correo;
    private String tel;
    private String direccion;
    private String ciudad;
    private String tipoContacto = "sin asignar";
    private EtapaKanban etapaKanban; // Asociación con clase EtapaKanban(1:n)
    private String entidad;
    private String especialidad;
    private UUID creadoPor;
    private boolean esUsuario = false;
    private Roles rol;  // Asociación con clase Roles(1:n)
    private String contraseña;
    private String estadoUsuario = "inactivo";

    // Constructor sin Parámtros 

    public Contactos() {
    }

    // Constrcutor con Parámetros 

    public Contactos(String apellido, String ciudad, String contraseña, String correo, UUID creadoPor, String direccion, String documento, String entidad, boolean esUsuario, String especialidad, String estadoUsuario, EtapaKanban etapaKanban, String nombre, String persona, Roles rol, String segundoNombre, String tel, String tipoContacto, String tipoDocumento) {
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.contraseña = contraseña;
        this.correo = correo;
        this.creadoPor = creadoPor;
        this.direccion = direccion;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.entidad = entidad;
        this.esUsuario = esUsuario;
        this.especialidad = especialidad;
        this.estadoUsuario = estadoUsuario;
        this.etapaKanban = etapaKanban;
        this.nombre = nombre;
        this.persona = persona;
        this.rol = rol;
        this.segundoNombre = segundoNombre;
        this.tel = tel;
        this.tipoContacto = tipoContacto;
    }

    // Accesores

    public UUID getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(UUID idContacto) {
        this.idContacto = idContacto;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public  String getTipoDocumento(){return tipoDocumento;};

    public void setTipoDocumento(String tipoDocumento) {this.tipoDocumento = tipoDocumento;}

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String tel) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public EtapaKanban getEtapaKanban() {
        return etapaKanban;
    }

    public void setEtapaKanban(EtapaKanban etapaKanban) {
        this.etapaKanban = etapaKanban;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public UUID getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(UUID creadoPor) {
        this.creadoPor = creadoPor;
    }

    public boolean isEsUsuario() {
        return esUsuario;
    }

    public void setEsUsuario(boolean esUsuario) {
        this.esUsuario = esUsuario;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estado) {
        this.estadoUsuario = estado;
    }
}