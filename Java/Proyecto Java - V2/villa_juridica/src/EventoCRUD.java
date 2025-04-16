import java.nio.ByteBuffer;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.UUID;

public class EventoCRUD {

    // Insertar Evento
    public void addEvento(Evento evento, Connection connection) throws SQLException {
        String add = "insert into Evento (tituloEvento, descripcionEvento, fechaHoraInicio, fechaHoraFin, allDay, recordatorio, tipoEvento, lugarEvento, adjuntoEvento, creadoPor, idEtapaKanban) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(add);

        statement.setString(1, evento.getTituloEvento());
        statement.setString(2, evento.getDescripcionEvento());
        statement.setTimestamp(3, Timestamp.valueOf(evento.getFechaHoraInicio()));
        statement.setTimestamp(4, Timestamp.valueOf(evento.getFechaHoraFin()));
        statement.setBoolean(5, evento.getAllDay() != null && evento.getAllDay());
        // Recordatorio puede ser null
        if (evento.getRecordatorio() != null) {
            statement.setTimestamp(6, Timestamp.valueOf(evento.getRecordatorio()));
        } else {
            statement.setNull(6, Types.TIMESTAMP);
        }

        statement.setString(7, evento.getTipoEvento());
        statement.setString(8, evento.getLugarEvento());
        statement.setString(9, evento.getAdjuntoEvento());
        statement.setBytes(10, ByteBuffer.allocate(16)
                .putLong(evento.getCreadoPor().getMostSignificantBits())
                .putLong(evento.getCreadoPor().getLeastSignificantBits())
                .array());

        // EtapaKanban puede ser null
        if (evento.getEtapaKanban() != null) {
            statement.setInt(11, evento.getEtapaKanban().getIdEtapaKanban());
        } else {
            statement.setNull(11, Types.INTEGER);
        }

        statement.executeUpdate();
        statement.close();
    }

    // Buscar todos los eventos
    public void searchEvento(Connection connection) throws SQLException {
        String search = "select BIN_TO_UUID(idEvento) as uuid, tituloEvento, descripcionEvento, fechaHoraInicio, fechaHoraFin, allDay, recordatorio, tipoEvento, lugarEvento, adjuntoEvento, BIN_TO_UUID(creadoPor) as creadoPor, idEtapaKanban from Evento";

        PreparedStatement statement = connection.prepareStatement(search);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("uuid"));
            System.out.println("Título: " + resultSet.getString("tituloEvento"));
            System.out.println("Descripción: " + resultSet.getString("descripcionEvento"));
            System.out.println("Inicio: " + resultSet.getTimestamp("fechaHoraInicio"));
            System.out.println("Fin: " + resultSet.getTimestamp("fechaHoraFin"));
            System.out.println("Todo el día: " + resultSet.getBoolean("allDay"));
            System.out.println("Recordatorio: " + resultSet.getTimestamp("recordatorio"));
            System.out.println("Tipo: " + resultSet.getString("tipoEvento"));
            System.out.println("Lugar: " + resultSet.getString("lugarEvento"));
            System.out.println("Adjunto: " + resultSet.getString("adjuntoEvento"));
            System.out.println("Creado por: " + resultSet.getString("creadoPor"));
            System.out.println("Etapa Kanban ID: " + resultSet.getInt("idEtapaKanban"));
        }

        resultSet.close();
        statement.close();
    }

    // Actualizar un evento
    public void updateEvento(UUID idEvento, Evento nuevoEvento, Connection connection) throws SQLException {
        String update = "update Evento set tituloEvento=?, descripcionEvento=?, fechaHoraInicio=?, fechaHoraFin=?, allDay=?, recordatorio=?, tipoEvento=?, lugarEvento=?, adjuntoEvento=?, idEtapaKanban=? where idEvento=UUID_TO_BIN(?)";
        PreparedStatement statement = connection.prepareStatement(update);

        statement.setString(1, nuevoEvento.getTituloEvento());
        statement.setString(2, nuevoEvento.getDescripcionEvento());
        statement.setTimestamp(3, Timestamp.valueOf(nuevoEvento.getFechaHoraInicio()));
        statement.setTimestamp(4, Timestamp.valueOf(nuevoEvento.getFechaHoraFin()));
        statement.setBoolean(5, nuevoEvento.getAllDay() != null && nuevoEvento.getAllDay());

        if (nuevoEvento.getRecordatorio() != null) {
            statement.setTimestamp(6, Timestamp.valueOf(nuevoEvento.getRecordatorio()));
        } else {
            statement.setNull(6, Types.TIMESTAMP);
        }

        statement.setString(7, nuevoEvento.getTipoEvento());
        statement.setString(8, nuevoEvento.getLugarEvento());
        statement.setString(9, nuevoEvento.getAdjuntoEvento());

        if (nuevoEvento.getEtapaKanban() != null) {
            statement.setInt(10, nuevoEvento.getEtapaKanban().getIdEtapaKanban());
        } else {
            statement.setNull(10, Types.INTEGER);
        }

        statement.setString(11, String.valueOf(idEvento));

        int updated = statement.executeUpdate();

        if (updated > 0) {
            System.out.println("Actualización Exitosa");
        }

        statement.close();
    }

    // Eliminar un evento
    public void deleteEvento(UUID idEvento, Connection connection) throws SQLException {
        String delete = "Delete from Evento where idEvento = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, idEvento.toString());

        int deleted = statement.executeUpdate();

        statement.close();
    }
}
