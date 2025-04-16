import java.nio.ByteBuffer;
import java.sql.*;
import java.util.UUID;

public class ContactosCRUD {
    //Insertar Datos

    public void addContacto(Contactos contactos, Connection connection) throws SQLException {
        String add="insert into Contactos( persona, tipoDocumento, documento, nombre, segundoNombre, apellido, correo, tel, direccion, ciudad, tipoContacto, idEtapaKanban, entidad, especialidad, creadoPor, esUsuario, idRol, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement=connection.prepareStatement(add);

        statement.setString(1, contactos.getPersona());
        statement.setString(2, contactos.getTipoDocumento());
        statement.setString(3, contactos.getDocumento());
        statement.setString(4, contactos.getNombre());
        statement.setString(5, contactos.getSegundoNombre());
        statement.setString(6, contactos.getApellido());
        statement.setString(7, contactos.getCorreo());
        statement.setString(8, contactos.getTel());
        statement.setString(9, contactos.getDireccion());
        statement.setString(10, contactos.getCiudad());
        statement.setString(11, contactos.getTipoContacto());

        // EtapaKanban puede ser null
        if (contactos.getEtapaKanban() != null) {
            statement.setInt(12, contactos.getEtapaKanban().getIdEtapaKanban());
        } else {
            statement.setNull(12, Types.INTEGER);
        }

        statement.setString(13,contactos.getEntidad());
        statement.setString(14,contactos.getEspecialidad());

        //Libreria ByteBuffer para Id de Byte(16)
        statement.setBytes(15, ByteBuffer.allocate(16)
                .putLong(contactos.getCreadoPor().getMostSignificantBits())
                .putLong(contactos.getCreadoPor().getLeastSignificantBits())
                .array());

        statement.setBoolean(16, contactos.isEsUsuario());

        //Rol puede ser null
        if (contactos.getRol() != null) {
            statement.setInt(17, contactos.getRol().getIdRol());
        } else {
            statement.setNull(17, java.sql.Types.INTEGER);
        }
        statement.setString(18, contactos.getContraseña());

        statement.executeUpdate();
        statement.close();
    }

    //Metodo para mostrar lista de contactos -Usuarios-
    public void mostrarUsuariosConUUID(Connection connection) throws SQLException {
        String contactList = "SELECT BIN_TO_UUID(idContacto) AS uuid, nombre, apellido FROM Contactos WHERE esUsuario = true";
        PreparedStatement statement = connection.prepareStatement(contactList);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("Usuarios disponibles con acceso al sistema:");
        while (resultSet.next()) {
            String uuid = resultSet.getString("uuid");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");

            System.out.println(nombre + " " + (apellido != null ? apellido : "") + " - " + uuid);
        }

        resultSet.close();
        statement.close();
    }

    //Metodo para mostrar lists completa de contactos
    public void searchContactos(Connection connection) throws SQLException {
        String search = "SELECT BIN_TO_UUID(idContacto) AS uuid, nombre, segundoNombre, apellido, tipoContacto, ciudad, correo, tel FROM Contactos";

        PreparedStatement statement = connection.prepareStatement(search);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String uuid = resultSet.getString("uuid");
            String nombre = resultSet.getString("nombre");
            String segundoNombre = resultSet.getString("segundoNombre");
            String apellido = resultSet.getString("apellido");
            String tipoContacto = resultSet.getString("tipoContacto");
            String ciudad = resultSet.getString("ciudad");
            String correo = resultSet.getString("correo");
            String tel = resultSet.getString("tel");

            System.out.println("ID de Contacto: " + uuid);
            System.out.println("Nombre completo: " + nombre + " " +
                    (segundoNombre != null ? segundoNombre + " " : "") +
                    (apellido != null ? apellido : ""));
            System.out.println("Tipo de Contacto: " + tipoContacto);
            System.out.println("Ciudad: " + ciudad);
            System.out.println("Correo: " + correo);
            System.out.println("Teléfono: " + tel);
        }

        resultSet.close();
        statement.close();
    }

    //Metodo para actualizar Registros
    public void updateContacto(UUID idContacto, String newSegundoNombre, String newApellido, String newCorreo, String newTel, String newDireccion, String newCiudad, Connection connection) throws SQLException {
        String update="UPDATE Contactos SET segundoNombre=?, apellido=?, correo=?, tel=?, direccion=?, ciudad=? WHERE idContacto=UUID_TO_BIN(?)";

        PreparedStatement statement= connection.prepareStatement(update);
        statement.setString(1, newSegundoNombre);
        statement.setString(2, newApellido);
        statement.setString(3, newCorreo);
        statement.setString(4, newTel);
        statement.setString(5, newDireccion);
        statement.setString(6,newCiudad);
        statement.setString(7, String.valueOf(idContacto));

        //Variable para guardar el resultado
        int updatecount= statement.executeUpdate();

        if (updatecount>0){
            System.out.println("Actualización Exitosa");
        }
        statement.close();
    }
    //Metodo para eliminar Registros
    public void deleteContacto(UUID idContacto, Connection connection) throws SQLException {
        String delete = "delete from Contactos where idContacto = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, String.valueOf(idContacto));

        statement.executeUpdate();

        statement.close();
    }
}
