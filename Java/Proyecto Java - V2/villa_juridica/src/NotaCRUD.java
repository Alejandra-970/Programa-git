import java.nio.ByteBuffer;
import java.sql.*;
import java.util.UUID;

public class NotaCRUD {

    // Insertar una nota
    public void addNota(Nota nota, Connection connection) throws SQLException {
        String add="insert into Nota (tituloNota, contenidoNota, creadoPor, tipoNota, idEtapaKanban) values (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(add);

        statement.setString(1, nota.getTituloNota());
        statement.setString(2, nota.getContenidoNota());

        statement.setBytes(3, ByteBuffer.allocate(16)
                .putLong(nota.getCreadoPor().getMostSignificantBits())
                .putLong(nota.getCreadoPor().getLeastSignificantBits())
                .array());

        statement.setString(4, nota.getTipoNota());

        // EtapaKanban puede ser null
        if (nota.getEtapaKanban() != null) {
            statement.setInt(5, nota.getEtapaKanban().getIdEtapaKanban());
        } else {
            statement.setNull(5, Types.INTEGER);
        }

        statement.executeUpdate();
        statement.close();
    }

    // Buscar todas las notas
    public void searchNota(Connection connection) throws SQLException {
        String search="select BIN_TO_UUID(idNota) as uuid, fechaCreacion, tituloNota, contenidoNota, creadoPor, tipoNota, idEtapaKanban from Nota";

        PreparedStatement statement=connection.prepareStatement(search);
        ResultSet resultSet=statement.executeQuery();

        while (resultSet.next()) {
            String uuid = resultSet.getString("uuid");
            Timestamp fechaCreacion = resultSet.getTimestamp("fechaCreacion");
            String titulo = resultSet.getString("tituloNota");
            String contenido = resultSet.getString("contenidoNota");
            String creadoPor = resultSet.getString("creadoPor");
            String tipoNota = resultSet.getString("tipoNota");
            int idEtapaKanban = resultSet.getInt("idEtapaKanban");
            boolean esNull = resultSet.wasNull();

            System.out.println("ID de Nota: " + uuid);
            System.out.println("Fecha de Creación: " + fechaCreacion);
            System.out.println("Título: " + titulo);
            System.out.println("Contenido: " + contenido);
            System.out.println("Creado por: " + creadoPor);
            System.out.println("Tipo de nota: " + tipoNota);
            System.out.println("Etapa Kanban: " + (esNull ? "Sin etapa" : idEtapaKanban));
            System.out.println("-----");
        }

        resultSet.close();
        statement.close();
    }

    // Actualizar una nota
    public void updateNota(UUID idNota, String newTitulo, String newContenido, String newTipoNota, EtapaKanban newEtapa, Connection connection) throws SQLException {
        String update = "update Nota set tituloNota = ?, contenidoNota = ?, tipoNota = ?, idEtapaKanban = ? where idNota = UUID_TO_BIN(?)";
        PreparedStatement statement = connection.prepareStatement(update);

        statement.setString(1, newTitulo);
        statement.setString(2, newContenido);
        statement.setString(3, newTipoNota);

        if (newEtapa != null) {
            statement.setInt(4, newEtapa.getIdEtapaKanban());
        } else {
            statement.setNull(4, Types.INTEGER);
        }

        statement.setString(5, String.valueOf(idNota));

        int updateCount = statement.executeUpdate();

        if (updateCount > 0) {
            System.out.println("Actualización Exitosa");
        }

        statement.close();
    }

    // Eliminar una nota
    public void deleteNota(UUID idNota, Connection connection) throws SQLException {
        String delete = "delete from Nota where idNota = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, String.valueOf(idNota));

        statement.executeUpdate();
        statement.close();
    }
}
