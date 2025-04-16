import java.nio.ByteBuffer;
import java.sql.*;
import java.util.UUID;

public class NotificacionesCRUD {

    // Insertar Notificación
    public void addNotificacion(Notificaciones notificacion, Connection connection) throws SQLException {
        String insert = "insert into Notificaciones (idContacto, tipoNotificacion, mensaje, leida) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insert);

        statement.setBytes(1, ByteBuffer.allocate(16)
                .putLong(notificacion.getContacto().getIdContacto().getMostSignificantBits())
                .putLong(notificacion.getContacto().getIdContacto().getLeastSignificantBits())
                .array());

        statement.setString(2, notificacion.getTipoNotificacion());
        statement.setString(3, notificacion.getMensaje());
        statement.setBoolean(4, notificacion.isLeida());

        statement.executeUpdate();
        statement.close();
    }

    // Consultar todas las notificaciones
    public void searchNotificaciones(Connection connection) throws SQLException {
        String query = "select BIN_TO_UUID(idNotificacion) as uuid, BIN_TO_UUID(idContacto) as contacto, tipoNotificacion, mensaje, leida, fechaCreacion from Notificaciones";

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("uuid"));
            System.out.println("ID Contacto: " + resultSet.getString("contacto"));
            System.out.println("Tipo: " + resultSet.getString("tipoNotificacion"));
            System.out.println("Mensaje: " + resultSet.getString("mensaje"));
            System.out.println("Leída: " + resultSet.getBoolean("leida"));
            System.out.println("Fecha creación: " + resultSet.getTimestamp("fechaCreacion"));
        }

        resultSet.close();
        statement.close();
    }

    // Actualizar una notificación (tipo, mensaje y leída)
    public void updateNotificacion(UUID idNotificacion, Notificaciones newNotificacion, Connection connection) throws SQLException {
        String update = "UPDATE Notificaciones SET tipoNotificacion = ?, mensaje = ?, leida = ? WHERE idNotificacion = UUID_TO_BIN(?)";
        PreparedStatement statement = connection.prepareStatement(update);

        statement.setString(1, newNotificacion.getTipoNotificacion());
        statement.setString(2, newNotificacion.getMensaje());
        statement.setBoolean(3, newNotificacion.isLeida());
        statement.setString(4, String.valueOf(idNotificacion));

        int updated = statement.executeUpdate();

        if (updated > 0) {
            System.out.println("Actualización Exitosa");
        }

        statement.close();
    }

    // Eliminar una notificación
    public void deleteNotificacion(UUID idNotificacion, Connection connection) throws SQLException {
        String delete = "delete from Notificaciones where idNotificacion = UUID_TO_BIN(?)";
        PreparedStatement statement = connection.prepareStatement(delete);

        statement.setString(1, String.valueOf(idNotificacion));

        int deleted = statement.executeUpdate();

        statement.close();
    }
}
