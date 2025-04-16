import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.*;
import java.util.UUID;

public class ExpedienteCRUD {
    //Metodo para insertar datos

    public void addExpediente(Expediente expediente, Connection connection) throws SQLException {
        String add= "insert into Expediente (tituloExp, areaExpediente, descripcion, fechaCierre, precio, radicado, fechaRadicado, ciudadExp, estadoExpediente, creadoPor, idEtapaKanban) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement=connection.prepareStatement(add);

        statement.setString(1, expediente.getTituloExpediente());
        statement.setString(2, expediente.getAreaExpediente());
        statement.setString(3, expediente.getDescripcion());
        statement.setDate(4, expediente.getFechaCierre());
        statement.setBigDecimal(5, expediente.getPrecio());
        statement.setString(6, expediente.getRadicado());
        statement.setDate(7, expediente.getFechaRadicado());
        statement.setString(8, expediente.getCiudadExp());
        statement.setString(9, expediente.getEstadoExpediente());

        //Libreria ByteBuffer para Id de Byte(16) de 'creadoPor'
        statement.setBytes(10, ByteBuffer.allocate(16)
                .putLong(expediente.getCreadoPor().getMostSignificantBits())
                .putLong(expediente.getCreadoPor().getLeastSignificantBits())
                .array());

        // EtapaKanban puede ser null
        if (expediente.getEtapaKanban() != null) {
            statement.setInt(11, expediente.getEtapaKanban().getIdEtapaKanban());
        } else {
            statement.setNull(11, Types.INTEGER);
        }

        statement.executeUpdate();
        statement.close();
    }

    //Metodo para buscar la lista de Expedientes
    public void searchExpediente(Connection connection) throws SQLException {
        String search = "SELECT BIN_TO_UUID(idExpediente) AS uuid, tituloExp, areaExpediente, descripcion, fechaApertura, fechaCierre, precio, radicado, fechaRadicado, ciudadExp, estadoExpediente, creadoPor, idEtapaKanban FROM Expediente";

        PreparedStatement statement = connection.prepareStatement(search);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String uuid = resultSet.getString("UUID");
            String tituloExp = resultSet.getString("tituloExp");
            String areaExpediente = resultSet.getString("areaExpediente");
            String descripcion = resultSet.getString("descripcion");
            Timestamp fechaApertura = resultSet.getTimestamp("fechaApertura");
            Date fechaCierre = resultSet.getDate("fechaCierre");
            BigDecimal precio = resultSet.getBigDecimal("precio");
            String radicado = resultSet.getString("radicado");
            Date fechaRadicado = resultSet.getDate("fechaRadicado");
            String ciudadExp = resultSet.getString("ciudadExp");
            String estadoExpediente = resultSet.getString("estadoExpediente");
            String creadoPor = resultSet.getString("creadoPor");
            int idEtapaKanban = resultSet.getInt("idEtapaKanban");

            System.out.println("ID de Expediente: " + uuid);
            System.out.println("Título del Expediente: " + tituloExp);
            System.out.println("Área: " + areaExpediente);
            System.out.println("Descripción: " + descripcion);
            System.out.println("Fecha de Apertura: " + fechaApertura);
            System.out.println("Fecha de Cierra: " + fechaCierre);
            System.out.println("Precio: " + precio);
            System.out.println("No. Radicado: " + radicado);
            System.out.println("Fecha de Radicado: " + fechaRadicado);
            System.out.println("Ciudad del Expediente: " + ciudadExp);
            System.out.println("Estado del Expediente: " + estadoExpediente);
            System.out.println("Creado por: " + creadoPor);
            System.out.println("Etapa del Expediente: " + idEtapaKanban);
        }
        resultSet.close();
        statement.close();
    }

    //Metodo para actualizar registros
    public void updateExpediente(UUID idExpediente, Date newFechaCierre, String newRadicado, Date newFechaRadicado, Connection connection) throws SQLException {
        String update="UPDATE Expediente SET fechaCierre=?, radicado=?, fechaRadicado=? WHERE idExpediente=UUID_TO_BIN(?)";

        PreparedStatement statement= connection.prepareStatement(update);
        statement.setDate(1, newFechaCierre);
        statement.setString(2, newRadicado);
        statement.setDate(3, newFechaRadicado);
        statement.setString(4,String.valueOf(idExpediente));

        int updatecount= statement.executeUpdate();

        if (updatecount>0){
            System.out.println("Actualización Exitosa");
        }
        statement.close();
    }

    //Metodo para eliminar Registros
    public void deleteExpediente(UUID idExpediente, Connection connection) throws SQLException {
        String delete = "DELETE FROM Expediente WHERE idExpediente = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, String.valueOf(idExpediente));

        statement.executeUpdate();

        statement.close();
    }
}
