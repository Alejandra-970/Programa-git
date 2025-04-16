import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EtapaKanbanCRUD {
    //Metodo para insertar datos

    public void addEtapa(EtapaKanban etapakanban, Connection connection) throws SQLException {

        String add="insert into EtapaKanban(nombreEtapa, tipo, categoria) values(?, ?, ?)";
        PreparedStatement statement=connection.prepareStatement(add);

        statement.setString(1,etapakanban.getNombreEtapa());
        statement.setString(2,etapakanban.getTipo());
        statement.setString(3,etapakanban.getCategoria());

        statement.executeUpdate();
        statement.close();
    }

    //Metodo para consulta General
    public void searchEtapa(Connection connection) throws SQLException{
        String search="select idEtapaKanban, nombreEtapa, Tipo, Categoria from EtapaKanban";

        PreparedStatement statement= connection.prepareStatement(search);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            int idEtapaKanban=resultSet.getInt("idEtapaKanban");
            String nombreEtapa=resultSet.getString("nombreEtapa");
            String Tipo= resultSet.getString("Tipo");
            String Categoria= resultSet.getString("Categoria");

            System.out.println("Número de Etapa: " +idEtapaKanban);
            System.out.println("Nombre:" +nombreEtapa);
            System.out.println("Tipo de Etapa: " +Tipo);
            System.out.println("Categoría: " +Categoria);
        }
        resultSet.close();
        statement.close();
    }
    //Metodo para actualizar Registros
    public void updateEtapa(int idEtapaKanban, String newNombre, String newTipo, String newCategoria, Connection connection) throws SQLException {
        String update="UPDATE EtapaKanban SET nombreEtapa=?, Tipo=?, Categoria=? where idEtapaKanban=?";

        PreparedStatement statement= connection.prepareStatement(update);
        statement.setString(1, newNombre);
        statement.setString(2, newTipo);
        statement.setString(3, newCategoria);
        statement.setInt(4, idEtapaKanban);

        //Variable para guardar el resultado
        int updatecount= statement.executeUpdate();

        if (updatecount>0){
            System.out.println("Actualización Existosa");
        }
        statement.close();
    }

    //Metodo para eliminar Registros
    public void deleteEtapa(int idEtapaKanban, Connection connection) throws SQLException {
        String delete="DELETE from EtapaKanban where idEtapaKanban = ?";

        PreparedStatement statement= connection.prepareStatement(delete);
        statement.setInt(1, idEtapaKanban);

        statement.executeUpdate();

        statement.close();
    }

}
