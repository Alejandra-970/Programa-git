import java.nio.ByteBuffer;
import java.sql.*;
import java.util.UUID;

public class DocumentoCRUD {
    //Insertar Datos
    public void addDocumento(Documento documento, Connection connection) throws SQLException {
        String add="Insert into Documento (nombreDocumento, origenDocumento, enlaceDocumento, creadoPor) values (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(add);

        statement.setString(1, documento.getNombreDocumento());
        statement.setString(2, documento.getOrigenDocumento());
        statement.setString(3, documento.getEnlaceDocumento());
        statement.setBytes(4, ByteBuffer.allocate(16)
                .putLong(documento.getCreadoPor().getMostSignificantBits())
                .putLong(documento.getCreadoPor().getLeastSignificantBits())
                .array());

        statement.executeUpdate();
        statement.close();
    }

    //Metodo para buscar la lists de Documentos
    public void searchDocumento(Connection connection) throws SQLException {
        String search="select BIN_TO_UUID(idDocumento) as uuid, fechaAgregado, nombreDocumento, origenDocumento, enlaceDocumento, creadoPor from Documento";

        PreparedStatement statement = connection.prepareStatement(search);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String uuid = resultSet.getString("UUID");
            Timestamp fechaAgregado=resultSet.getTimestamp("fechaAgregado");
            String nombreDocumento=resultSet.getString("nombreDocumento");
            String origenDocumento=resultSet.getString("origenDocumento");
            String enlaceDocumento=resultSet.getString("enlaceDocumento");
            String creadoPor =resultSet.getString("creadoPor");

            System.out.println("ID de Documento:  " + uuid);
            System.out.println("Fecha de Creación:  " + fechaAgregado);
            System.out.println("Título:  " + nombreDocumento);
            System.out.println("Orígen:  " + origenDocumento);
            System.out.println("Link:  " + enlaceDocumento);
            System.out.println("Creado por:  " + creadoPor);
        }
        resultSet.close();
        statement.close();
    }

    //Metodo para actualizar
    public void updateDocumento(UUID idDocumento,String newNombreDocumento, String newOrigenDocumento, String newEnlaceDocumento, Connection connection) throws SQLException {
        String update="update Documento set nombreDocumento=?, origenDocumento=?, enlaceDocumento=? where idDocumento=UUID_TO_BIN(?)";
        PreparedStatement statement=connection.prepareStatement(update);

        statement.setString(1, newNombreDocumento);
        statement.setString(2, newOrigenDocumento);
        statement.setString(3, newEnlaceDocumento);
        statement.setString(4, String.valueOf(idDocumento));

        int updatecount= statement.executeUpdate();

        if (updatecount>0){
            System.out.println("Actualización Exitosa");
        }
        statement.close();
    }

    //Metodo para eliminar Registros
    public void deleteDocumento(UUID idDocumento, Connection connection) throws SQLException {
        String delete="delete from Documento where idDocumento = UUID_TO_BIN(?)";

        PreparedStatement statement=connection.prepareStatement(delete);
        statement.setString(1, String.valueOf(idDocumento));

        statement.executeUpdate();

        statement.close();
    }
}
