/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import conection.Conexion;
import entity.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author labinfo01
 */
public class RFCModel {

    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;

    public Empleado create(Empleado empleado) {
        // Establecer la conexión a la base de datos
        connection = null;
        preparedStatement = null;

        try {
            connection = Conexion.obtenerConexion(); // Asegúrate de que esta línea obtenga una conexión válida a tu base de datos

            // Define la consulta SQL para la inserción
            sql = "INSERT INTO Empleado (id_empleado, nombre, puesto) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Establece los valores de los parámetros en la consulta SQL
            preparedStatement.setString(1, empleado.getIdEmpleado());
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setString(3, empleado.getPuesto());

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
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null; // En caso de error
    }

    public static boolean validateRFC(String rfc) {
        // El RFC debe tener 13 caracteres.
        if (rfc.length() != 13) {
            return false;
        }

        // Verifica que los primeros 4 caracteres sean letras.
        for (int i = 0; i < 4; i++) {
            char c = rfc.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        // Verifica que los siguientes 6 caracteres sean dígitos.
        for (int i = 4; i < 10; i++) {
            char c = rfc.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        // Verifica que el último carácter sea una letra o un dígito.
        char lastChar = rfc.charAt(12);
        if (!Character.isLetterOrDigit(lastChar)) {
            return false;
        }

        return true;
    }
}
