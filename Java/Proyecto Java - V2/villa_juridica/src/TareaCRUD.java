import java.nio.ByteBuffer;
import java.sql.*;
import java.util.UUID;

public class TareaCRUD {

    // Insertar Datos
    public void addTarea(Tarea tarea, Connection connection) throws SQLException {
        String add = "insert into Tarea (esPrivado, nombreTarea, descripcionTarea, fechaVencimiento, prioridad, creadoPor, idEtapaKanban) values(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(add);

        statement.setBoolean(1, tarea.isEsPrivado());
        statement.setString(2, tarea.getNombreTarea());
        statement.setString(3, tarea.getDescripcionTarea());
        statement.setDate(4, tarea.getFechaVencimiento());
        statement.setString(5, tarea.getPrioridad());

        // creadoPor
        statement.setBytes(6, ByteBuffer.allocate(16)
                .putLong(tarea.getCreadoPor().getMostSignificantBits())
                .putLong(tarea.getCreadoPor().getLeastSignificantBits())
                .array());

        // EtapaKanban puede ser null
        if (tarea.getEtapaKanban() != null) {
            statement.setInt(7, tarea.getEtapaKanban().getIdEtapaKanban());
        } else {
            statement.setNull(7, Types.INTEGER);
        }

        statement.executeUpdate();
        statement.close();
    }

    // Buscar lista de Tareas
    public void searchTarea(Connection connection) throws SQLException {
        String search="select BIN_TO_UUID(idTarea) as idTarea, fechaCreacion, esPrivado, nombreTarea, descripcionTarea, fechaVencimiento, prioridad, BIN_TO_UUID(creadoPor) as creadoPor, idEtapaKanban from Tarea";

        PreparedStatement statement = connection.prepareStatement(search);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println("ID de Tarea: " + resultSet.getString("idTarea"));
            System.out.println("Fecha de Creación: " + resultSet.getTimestamp("fechaCreacion"));
            System.out.println("¿Privada?: " + resultSet.getBoolean("esPrivado"));
            System.out.println("Título: " + resultSet.getString("nombreTarea"));
            System.out.println("Descripción: " + resultSet.getString("descripcionTarea"));
            System.out.println("Fecha de Vencimiento: " + resultSet.getDate("fechaVencimiento"));
            System.out.println("Prioridad: " + resultSet.getString("prioridad"));
            System.out.println("Creado por (UUID): " + resultSet.getString("creadoPor"));
            int etapa = resultSet.getInt("idEtapaKanban");
            if (!resultSet.wasNull()) {
                System.out.println("Etapa Kanban: " + etapa);
            } else {
                System.out.println("Etapa Kanban: Sin asignar");
            }
        }

        resultSet.close();
        statement.close();
    }

    // Actualizar Tarea
    public void updateTarea(UUID idTarea, boolean newEsPrivado, String newNombre, String newDescripcion, Date newFechaVencimiento, String newPrioridad, Integer newEtapaKanbanId, Connection connection) throws SQLException {
        String update ="update Tarea set esPrivado=?, nombreTarea=?, descripcionTarea=?, fechaVencimiento=?, prioridad=?, idEtapaKanban=? where idTarea = UUID_TO_BIN(?)";
        PreparedStatement statement = connection.prepareStatement(update);

        statement.setBoolean(1, newEsPrivado);
        statement.setString(2, newNombre);
        statement.setString(3, newDescripcion);
        statement.setDate(4, newFechaVencimiento);
        statement.setString(5, newPrioridad);

        if (newEtapaKanbanId != null) {
            statement.setInt(6, newEtapaKanbanId);
        } else {
            statement.setNull(6, Types.INTEGER);
        }

        statement.setString(7, String.valueOf(idTarea));

        int updated = statement.executeUpdate();
        if (updated > 0) {
            System.out.println("Tarea actualizada exitosamente.");
        }
        statement.close();
    }

    // Eliminar Tarea
    public void deleteTarea(UUID idTarea, Connection connection) throws SQLException {
        String delete = "delete from Tarea where idTarea = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, String.valueOf(idTarea));

        statement.executeUpdate();
        statement.close();
    }
}

