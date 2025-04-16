import java.sql.*;
import java.util.UUID;
import java.nio.ByteBuffer;

public class TareaRelacionCRUD {

    // Insertar Datos
    public void addTareaRelacion(TareaRelacion tareaRelacion, Connection connection) throws SQLException {
        String add = "insert into TareaRelacion(idTarea, idExpediente, idContacto, rolAsignado) values (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(add);

        UUID idTarea = tareaRelacion.getTarea().getIdTarea();
        UUID idExpediente = (tareaRelacion.getExpediente() != null) ? tareaRelacion.getExpediente().getIdExpediente() : null;
        UUID idContacto = (tareaRelacion.getContacto() != null) ? tareaRelacion.getContacto().getIdContacto() : null;
        String rolAsignado = tareaRelacion.getrolAsignado();

        statement.setBytes(1, ByteBuffer.allocate(16)
                .putLong(idTarea.getMostSignificantBits())
                .putLong(idTarea.getLeastSignificantBits())
                .array());

        // idExpediente (puede ser null)
        if (idExpediente != null) {
            statement.setBytes(2, ByteBuffer.allocate(16)
                    .putLong(idExpediente.getMostSignificantBits())
                    .putLong(idExpediente.getLeastSignificantBits())
                    .array());
        } else {
            statement.setNull(2, Types.BINARY);
        }

        // idContacto (puede ser null)
        if (idContacto != null) {
            statement.setBytes(3, ByteBuffer.allocate(16)
                    .putLong(idContacto.getMostSignificantBits())
                    .putLong(idContacto.getLeastSignificantBits())
                    .array());
        } else {
            statement.setNull(3, Types.BINARY);
        }

        statement.setString(4, rolAsignado);

        statement.executeUpdate();
        statement.close();
    }

    // Mostrar relaciones de tareas
    public void searchTareaRelacion(Connection connection) throws SQLException {
        String search = "select BIN_TO_UUID(tr.idRelacionT) AS idRelacionT, BIN_TO_UUID(t.idTarea) AS idTarea, t.nombreTarea AS titulo, t.descripcionTarea AS descripcion, t.fechaVencimiento AS vencimiento, BIN_TO_UUID(e.idExpediente) AS idExpediente, e.tituloExp AS tituloExp, BIN_TO_UUID(c.idContacto) AS idContacto, c.nombre AS nombre, c.apellido AS apellido, tr.rolAsignado FROM TareaRelacion tr INNER JOIN Tarea t ON tr.idTarea = t.idTarea LEFT JOIN Expediente e ON tr.idExpediente = e.idExpediente LEFT JOIN Contactos c ON tr.idContacto = c.idContacto";


        PreparedStatement statement = connection.prepareStatement(search);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("Listado de Relaciones de Tareas:");
        while (resultSet.next()) {
            String idRelacionT = resultSet.getString("idRelacionT");
            String idTarea = resultSet.getString("idTarea");
            String tituloTarea = resultSet.getString("titulo");
            String descripcion = resultSet.getString("descripcion");
            Date vencimiento = resultSet.getDate("vencimiento");
            String rolAsignado = resultSet.getString("rolAsignado");

            String idExpediente = resultSet.getString("idExpediente");
            String tituloExp = resultSet.getString("tituloExp");

            String idContacto = resultSet.getString("idContacto");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");

            System.out.println("ID Relación: " + idRelacionT);
            System.out.println("Tarea:");
            System.out.println("  ID: " + idTarea);
            System.out.println("  Título: " + tituloTarea);
            System.out.println("  Descripción: " + descripcion);
            System.out.println("  Vencimiento: " + vencimiento);
            System.out.println("  rolAsignado: " + rolAsignado);

            if (idExpediente != null) {
                System.out.println("Expediente:");
                System.out.println("  ID: " + idExpediente);
                System.out.println("  Título: " + tituloExp);
            } else {
                System.out.println("Expediente: N/A");
            }

            if (idContacto != null) {
                String nombreCompleto = nombre + (apellido != null ? " " + apellido : "");
                System.out.println("Contacto:");
                System.out.println("  ID: " + idContacto);
                System.out.println("  Nombre: " + nombreCompleto);
            } else {
                System.out.println("Contacto: N/A");
            }
        }

        resultSet.close();
        statement.close();
    }

    // Actualizar relación
    public void updateTareaRelacion(UUID idRelacionT, UUID newIdTarea, UUID newIdExpediente, UUID newIdContacto, String newRolAsignado, Connection connection) throws SQLException {
        String update = "update TareaRelacion set idTarea = UUID_TO_BIN(?), idExpediente = UUID_TO_BIN(?), idContacto = UUID_TO_BIN(?), rolAsignado = ? WHERE idRelacionT = UUID_TO_BIN(?)";
        PreparedStatement statement = connection.prepareStatement(update);

        statement.setString(1, String.valueOf(newIdTarea));

        if (newIdExpediente != null) {
            statement.setString(2, String.valueOf(newIdExpediente));
        } else {
            statement.setNull(2, Types.VARCHAR);
        }

        if (newIdContacto != null) {
            statement.setString(3, String.valueOf(newIdContacto));
        } else {
            statement.setNull(3, Types.VARCHAR);
        }

        statement.setString(4, newRolAsignado);
        statement.setString(5, String.valueOf(idRelacionT));

        int updateCount = statement.executeUpdate();

        if (updateCount > 0) {
            System.out.println("Actualización Exitosa");
        }
        statement.close();
    }

    // Eliminar relación
    public void deleteTareaRelacion(UUID idRelacionT, Connection connection) throws SQLException {
        String delete = "delete from TareaRelacion where idRelacionT = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, String.valueOf(idRelacionT));

        statement.executeUpdate();
        statement.close();
    }
}
