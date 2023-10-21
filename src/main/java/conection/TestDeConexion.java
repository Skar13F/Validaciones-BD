
package conection;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TestDeConexion {
    public static void main(String[] args) {
        Connection conexion = Conexion.obtenerConexion();

        if (conexion != null) {
            // La conexión se ha establecido correctamente, puedes realizar más operaciones aquí
            // Por ejemplo, puedes ejecutar consultas SQL
            // Asegúrate de cerrar la conexión cuando hayas terminado
            Conexion.cerrarConexion(conexion);
        } else {
            JOptionPane.showConfirmDialog(null,"La conexión a la base de datos ha fallado.");
        }
    }
}
