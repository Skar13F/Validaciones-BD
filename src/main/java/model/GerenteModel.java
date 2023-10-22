package model;

import conection.Conexion;
import entity.Empleado;
import entity.Puestos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author froste
 */
public class GerenteModel {
    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;
    
    public Empleado create(Empleado empleado) {
    // Establecer la conexión a la base de datos
    connection = null;
    preparedStatement = null;

    try {
        connection = Conexion.obtenerConexion(); // Asegúrate de que esta línea obtenga una conexión válida a tu base de datos

        // Define la consulta SQL para la inserción
        sql = "INSERT INTO Empleado (id_empleado, nombre, puesto) VALUES (?, ?, '"+empleado.getPuesto()+"')";
        preparedStatement = connection.prepareStatement(sql);

        // Establece los valores de los parámetros en la consulta SQL
        preparedStatement.setString(1, empleado.getIdEmpleado());
        preparedStatement.setString(2, empleado.getNombre());



        // Ejecuta la consulta de inserción
        int filasAfectadas = preparedStatement.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Empleado insertado con éxito.");
            return empleado; // Devuelve el objeto Empleado creado
        } else {
            System.out.println("Error al insertar el empleado.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cierra los recursos
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return null; // En caso de error
}
    
    public boolean isValid(){
         try {
            // Establecer la conexión a la base de datos (ajusta las credenciales y la URL de la base de datos)
            connection = Conexion.obtenerConexion();

            // Realizar la consulta SQL para contar el número de "Gerentes"
            sql = "SELECT COUNT(*) FROM Empleado WHERE puesto = 'Gerente'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            int gerentes = 0;

            if (resultSet.next()) {
                gerentes = resultSet.getInt(1);
            }

            // Validar si el número de gerentes es mayor o igual a 1
            if (gerentes >= 1) {
                System.out.println("Solo puede existir un Gerente");
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         return true;
    }
}
