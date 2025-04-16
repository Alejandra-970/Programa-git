import java.sql.ResultSet;
import java.util.UUID;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DocumentoExpedienteCRUD {

    // Insertar Datos
    public void addDocumentoExpediente(DocumentoExpediente documentoExpediente, Connection connection) throws SQLException {
        String add = "insert into DocumentoExpediente(idExpediente, idDocumento) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(add);

        UUID idExpediente = documentoExpediente.getExpediente().getIdExpediente();
        UUID idDocumento = documentoExpediente.getDocumento().getIdDocumento();

        statement.setBytes(1, ByteBuffer.allocate(16)
                .putLong(idExpediente.getMostSignificantBits())
                .putLong(idExpediente.getLeastSignificantBits())
                .array());

        statement.setBytes(2, ByteBuffer.allocate(16)
                .putLong(idDocumento.getMostSignificantBits())
                .putLong(idDocumento.getLeastSignificantBits())
                .array());

        statement.executeUpdate();
        statement.close();
    }

    // Mostrar la lista de relaciones Documento-Expediente
    public void searchDocumentoExpediente(Connection connection) throws SQLException {
        String search = "select BIN_TO_UUID(de.idRelacionDE) as idRelacionDE, BIN_TO_UUID(e.idExpediente) as idExpediente, e.tituloExp as tituloExp, e.descripcion as descripcion, BIN_TO_UUID(d.idDocumento) as idDocumento, d.nombreDocumento as nombreDocumento, d.origenDocumento as origenDocumento, d.enlaceDocumento as enlaceDocumento from DocumentoExpediente de inner join Expediente e on de.idExpediente = e.idExpediente inner join Documento d on de.idDocumento = d.idDocumento";

        PreparedStatement statement = connection.prepareStatement(search);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("Lista de Expedientes y Documentos:");
        while (resultSet.next()) {
            String idRelacion = resultSet.getString("idRelacionDE");
            String idExpediente = resultSet.getString("idExpediente");
            String titulo = resultSet.getString("tituloExp");
            String descripcion = resultSet.getString("descripcion");

            String idDocumento = resultSet.getString("idDocumento");
            String nombreDocumento = resultSet.getString("nombreDocumento");
            String origenDocumento = resultSet.getString("origenDocumento");
            String enlaceDocumento = resultSet.getString("enlaceDocumento");

            System.out.println("ID Relación Documento-Expediente: " + idRelacion);
            System.out.println("Expediente:");
            System.out.println("  ID: " + idExpediente);
            System.out.println("  Título: " + titulo);
            System.out.println("  Descripción: " + descripcion);
            System.out.println("Documento:");
            System.out.println("  ID: " + idDocumento);
            System.out.println("  Nombre: " + nombreDocumento);
            System.out.println("  Origen: " + origenDocumento);
            System.out.println("  Enlace: " + enlaceDocumento);
        }

        resultSet.close();
        statement.close();
    }

    // Actualizar un registro
    public void updateDocumentoExpediente(UUID idRelacionDE, UUID newIdExpediente, UUID newIdDocumento, Connection connection) throws SQLException {
        String update = "update DocumentoExpediente set idExpediente = UUID_TO_BIN(?), idDocumento = UUID_TO_BIN(?) where idRelacionDE = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(update);

        statement.setString(1, String.valueOf(newIdExpediente));
        statement.setString(2, String.valueOf(newIdDocumento));
        statement.setString(3, String.valueOf(idRelacionDE));

        int updatecount = statement.executeUpdate();

        if (updatecount>0){
            System.out.println("Actualización Exitosa");
        }
        statement.close();
    }

    // Eliminar un registro
    public void deleteDocumentoExpediente(UUID idRelacionDE, Connection connection) throws SQLException {
        String delete = "delete from DocumentoExpediente where idRelacionDE = UUID_TO_BIN(?)";

        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, idRelacionDE.toString());

        statement.executeUpdate();
        statement.close();
    }
}