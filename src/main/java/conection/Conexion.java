
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Configura la información de la base de datos
    private static final String URL = "jdbc:postgresql://localhost:5432/inventario";
    private static final String USUARIO = "postgres";
    private static final String CONTRASENA = "root";

    public static Connection obtenerConexion() {
        Connection conexion = null;

        try {
            // Carga el controlador JDBC de PostgreSQL
            Class.forName("org.postgresql.Driver");
            
            // Establece la conexión a la base de datos
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos PostgreSQL.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se pudo cargar el controlador JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
            e.printStackTrace();
        }

        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión.");
            e.printStackTrace();
        }
    }
}

