import java.sql.ResultSet;
import java.util.UUID;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExpedienteContactoCRUD {
    //Insertar Datos

    public void addExpedienteContacto(ExpedienteContacto expedienteContacto, Connection connection) throws SQLException {
        String add="insert into ExpedienteContacto(idExpediente, idContacto, rolContacto) values (?, ?, ?)";
        PreparedStatement statement=connection.prepareStatement(add);

        UUID idExpediente = expedienteContacto.getExpediente().getIdExpediente();
        UUID idContacto = expedienteContacto.getContacto().getIdContacto();

        statement.setBytes(1, ByteBuffer.allocate(16)
                .putLong(idExpediente.getMostSignificantBits())
                .putLong(idExpediente.getLeastSignificantBits())
                .array());

        statement.setBytes(2, ByteBuffer.allocate(16)
                .putLong(idContacto.getMostSignificantBits())
                .putLong(idContacto.getLeastSignificantBits())
                .array());

        statement.setString(3, expedienteContacto.getRolContacto());

        statement.executeUpdate();
        statement.close();
    }

    //Metodo para mostrar lista de Contactos y Expedientes relacionados
    public void searchExpedienteCliente(Connection connection) throws SQLException {
        String search = "select BIN_TO_UUID(ec.idRelacionEC) as idRelacionEC, BIN_TO_UUID(e.idExpediente) as idExpediente, e.tituloExp as titulo,e.descripcion as descripcion, BIN_TO_UUID(c.idContacto) AS idContacto, c.nombre as nombre, c.apellido as apellido, ec.rolContacto as rol from ExpedienteContacto ec inner join Expediente e on ec.idExpediente = e.idExpediente inner join Contactos c on ec.idContacto = c.idContacto";

        PreparedStatement statement = connection.prepareStatement(search);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("Listado de Expedientes detallado:");
        while (resultSet.next()) {
            String idRelacionEC = resultSet.getString("idRelacionEC");
            String idExpediente = resultSet.getString("idExpediente");
            String titulo = resultSet.getString("titulo");
            String descripcion = resultSet.getString("descripcion");

            String idContacto = resultSet.getString("idContacto");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String rol = resultSet.getString("rol");

            String nombreCompleto = nombre + (apellido != null ? " " + apellido : "");

            System.out.println("ID Relación: " + idRelacionEC);
            System.out.println("Expediente:");
            System.out.println("  ID: " + idExpediente);
            System.out.println("  Título: " + titulo);
            System.out.println("  Descripción: " + descripcion);
            System.out.println("Contacto:");
            System.out.println("  ID: " + idContacto);
            System.out.println("  Nombre: " + nombreCompleto);
            System.out.println("  Rol: " + rol);
        }

        resultSet.close();
        statement.close();
    }

    //Meotodo para actualizar un registro
    public void updateExpedienteContacto(UUID idRelacionEC, UUID newIdExpediente, UUID newIdContacto, String newRol, Connection connection) throws SQLException {
        String update = "UPDATE ExpedienteContacto SET idExpediente = UUID_TO_BIN(?), idContacto = UUID_TO_BIN(?), rolContacto = ? WHERE idRelacionEC = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(update);
        statement.setString(1, String.valueOf(newIdExpediente));
        statement.setString(2, String.valueOf(newIdContacto));
        statement.setString(3, newRol);
        statement.setString(4, String.valueOf(idRelacionEC));

        int updatecount = statement.executeUpdate();

        if (updatecount>0){
            System.out.println("Actualización Exitosa");
        }
        statement.close();
    }

    //Metodo para eliminar registros
    public  void deleteExpedienteContacto(UUID idRelacionEC, Connection connection) throws SQLException {
        String delete = "Delete from ExpedienteContacto where idRelacionEC = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, String.valueOf(idRelacionEC));

        statement.executeUpdate();
        statement.close();
    }
}
