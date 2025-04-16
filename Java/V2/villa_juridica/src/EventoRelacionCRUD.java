import java.sql.*;
import java.util.UUID;
import java.nio.ByteBuffer;

public class EventoRelacionCRUD {

    // Insertar Datos
    public void addEventoRelacion(EventoRelacion eventoRelacion, Connection connection) throws SQLException {
        String add = "insert into EventoRelacion(idEvento, idExpediente, idContacto) values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(add);

        UUID idEvento = eventoRelacion.getEvento().getIdEvento();
        UUID idExpediente = (eventoRelacion.getExpediente() != null) ? eventoRelacion.getExpediente().getIdExpediente() : null;
        UUID idContacto = (eventoRelacion.getContacto() != null) ? eventoRelacion.getContacto().getIdContacto() : null;

        // idEvento (obligatorio)
        statement.setBytes(1, ByteBuffer.allocate(16)
                .putLong(idEvento.getMostSignificantBits())
                .putLong(idEvento.getLeastSignificantBits())
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

        statement.executeUpdate();
        statement.close();
    }

    // Mostrar relaciones de eventos
    public void searchEventoRelacion(Connection connection) throws SQLException {
        String search = "select BIN_TO_UUID(er.idRelacionE) as idRelacionE, BIN_TO_UUID(e.idEvento) as idEvento, e.tituloEvento, e.tipoEvento, BIN_TO_UUID(exp.idExpediente) as idExpediente, exp.tituloExp, BIN_TO_UUID(c.idContacto) as idContacto, c.nombre, c.apellido from EventoRelacion er inner join Evento e on er.idEvento = e.idEvento left join Expediente exp on er.idExpediente = exp.idExpediente left join Contactos c on er.idContacto = c.idContacto";

        PreparedStatement statement = connection.prepareStatement(search);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("Listado de Relaciones de Eventos:");
        while (resultSet.next()) {
            String idRelacionE = resultSet.getString("idRelacionE");
            String idEvento = resultSet.getString("idEvento");
            String tituloEvento = resultSet.getString("tituloEvento");
            String tipoEvento = resultSet.getString("tipoEvento");

            String idExpediente = resultSet.getString("idExpediente");
            String tituloExp = resultSet.getString("tituloExp");

            String idContacto = resultSet.getString("idContacto");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");

            System.out.println("ID Relación: " + idRelacionE);
            System.out.println("Evento:");
            System.out.println("  ID: " + idEvento);
            System.out.println("  Título: " + tituloEvento);
            System.out.println("  Tipo: " + tipoEvento);

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
    public void updateEventoRelacion(UUID idRelacionE, UUID newIdEvento, UUID newIdExpediente, UUID newIdContacto, Connection connection) throws SQLException {
        String update = "update EventoRelacion set idEvento = UUID_TO_BIN(?), idExpediente = UUID_TO_BIN(?), idContacto = UUID_TO_BIN(?) where idRelacionE = UUID_TO_BIN(?)";
        PreparedStatement statement = connection.prepareStatement(update);

        statement.setString(1, String.valueOf(newIdEvento));

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

        statement.setString(4, String.valueOf(idRelacionE));

        int updatecount = statement.executeUpdate();

        if (updatecount > 0) {
            System.out.println("Actualización Exitosa");
        }
        statement.close();
    }

    // Eliminar relación
    public void deleteEventoRelacion(UUID idRelacionE, Connection connection) throws SQLException {
        String delete = "delete from EventoRelacion where idRelacionE = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, String.valueOf(idRelacionE));

        statement.executeUpdate();
        statement.close();
    }
}

