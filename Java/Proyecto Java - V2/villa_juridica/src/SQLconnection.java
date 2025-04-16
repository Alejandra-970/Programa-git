import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLconnection{

    public static Connection connect() throws SQLException {
        //Agregar Ruta de la conexión de la Base de Datos
        String url="jdbc:mysql://127.0.0.1:3306/villa_juridica";

        //Agregar usuario de la conexión de la Base de Datos
        String user="root";

        //Agregar Clave de la conexión de la Base de Datos
        String password="1234";

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("Conexión Exitosa");

        return connection;
    }
}