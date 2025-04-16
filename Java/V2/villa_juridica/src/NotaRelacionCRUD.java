import java.sql.*;
import java.util.UUID;
import java.nio.ByteBuffer;

public class NotaRelacionCRUD {

    // Insertar Datos
    public void addNotaRelacion(NotaRelacion notaRelacion, Connection connection) throws SQLException {
        String add = "insert into NotaRelacion(idNota, idExpediente, idContacto) values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(add);

        UUID idNota = notaRelacion.getNota().getIdNota();
        UUID idExpediente = (notaRelacion.getExpediente() != null) ? notaRelacion.getExpediente().getIdExpediente() : null;
        UUID idContacto = (notaRelacion.getContacto() != null) ? notaRelacion.getContacto().getIdContacto() : null;

        // idNota (obligatorio)
        statement.setBytes(1, ByteBuffer.allocate(16)
                .putLong(idNota.getMostSignificantBits())
                .putLong(idNota.getLeastSignificantBits())
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

    // Mostrar relaciones de notas
    public void searchNotaRelacion(Connection connection) throws SQLException {
        String search = "select BIN_TO_UUID(nr.idRelacionN) as idRelacionN, BIN_TO_UUID(n.idNota) as idNota, n.tituloNota as titulo, n.tipoNota as tipo, BIN_TO_UUID(e.idExpediente) as idExpediente, e.tituloExp as tituloExp, BIN_TO_UUID(c.idContacto) as idContacto, c.nombre as nombre, c.apellido as apellido from NotaRelacion nr inner join Nota n on nr.idNota = n.idNota left join Expediente e on nr.idExpediente = e.idExpediente left join Contactos c on nr.idContacto = c.idContacto";

        PreparedStatement statement=connection.prepareStatement(search);
        ResultSet resultSet=statement.executeQuery();

        System.out.println("Listado de Relaciones de Notas:");
        while (resultSet.next()) {
            String idRelacionN = resultSet.getString("idRelacionN");
            String idNota = resultSet.getString("idNota");
            String tituloNota = resultSet.getString("titulo");
            String tipoNota = resultSet.getString("tipo");

            String idExpediente = resultSet.getString("idExpediente");
            String tituloExp = resultSet.getString("tituloExp");

            String idContacto = resultSet.getString("idContacto");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");

            System.out.println("ID Relación: " + idRelacionN);
            System.out.println("Nota:");
            System.out.println("  ID: " + idNota);
            System.out.println("  Título: " + tituloNota);
            System.out.println("  Tipo: " + tipoNota);

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
    public void updateNotaRelacion(UUID idRelacionN, UUID newIdNota, UUID newIdExpediente, UUID newIdContacto, Connection connection) throws SQLException {
        String update = "update NotaRelacion set idNota = UUID_TO_BIN(?), idExpediente = UUID_TO_BIN(?), idContacto = UUID_TO_BIN(?) where idRelacionN = UUID_TO_BIN(?)";
        PreparedStatement statement = connection.prepareStatement(update);

        statement.setString(1, String.valueOf(newIdNota));

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

        statement.setString(4, String.valueOf(idRelacionN));

        int updatecount = statement.executeUpdate();

        if (updatecount>0){
            System.out.println("Actualización Exitosa");
        }
        statement.close();
    }

    // Eliminar relación
    public void deleteNotaRelacion(UUID idRelacionN, Connection connection) throws SQLException {
        String delete = "delete from NotaRelacion where idRelacionN = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, String.valueOf(idRelacionN));

        statement.executeUpdate();
        statement.close();
    }
}
