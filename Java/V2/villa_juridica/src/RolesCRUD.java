import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RolesCRUD {
    //Metodo para insertar datos

    public void insertarRoles(Roles roles, Connection connection) throws SQLException {

        String insertar="insert into Roles(nombreRol) values(?)";
        PreparedStatement statement=connection.prepareStatement(insertar);

        statement.setString(1, roles.getNombreRol());

        statement.executeUpdate();
        statement.close();
    }

    //Metodo para consultar todos los datos
    public void searchRoles(Connection connection) throws SQLException{
        String search="select idRol, nombreRol from Roles order by idRol desc";

        PreparedStatement statement=connection.prepareStatement(search);
        //Ejecutar una consulta SQL y obtener los resultados del objeto
        ResultSet resultSet= statement.executeQuery();

        while (resultSet.next()){
            int idRol=resultSet.getInt("idRol");
            String nombreRol=resultSet.getString("nombreRol");

            System.out.println("Codigo: "+ idRol);
            System.out.println("nombre del Rol: "+ nombreRol);
        }
        resultSet.close();
        statement.close();
    }

    //Metodo para actualizar un registro
    public void updateRoles(int idRol, String newNombre, Connection connection) throws SQLException{
        String update="UPDATE Roles SET nombreRol=? where idRol=?";

        PreparedStatement statement=connection.prepareStatement(update);
        statement.setString(1, newNombre);
        statement.setInt(2, idRol);

        //Crear una variable para guardar el resultado de una actualización
        int updatecount=statement.executeUpdate();

        if(updatecount>0){
            System.out.println("Actualización Existosa");
        }
        statement.close();
    }
    //Metodo para eliminar Registros
    public void deleteRoles(int idRol, Connection connection) throws SQLException {
        String delete="DELETE from Roles where idRol = ?";

        PreparedStatement statement= connection.prepareStatement(delete);
        statement.setInt(1, idRol);

        statement.executeUpdate();

        statement.close();
    }
}
