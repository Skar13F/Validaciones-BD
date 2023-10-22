
package model;

import conection.Conexion;
import entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Nancy
 */
public class ClienteModel {
     public static boolean validarIdClientes(String idCliente) {
        // Expresión regular para validar el ID de clientes
        String patron = "^[0-9]{3}$";
        return idCliente.matches(patron);
    }
     public void crearRegistro(Cliente cliente) {
    Connection conexion = Conexion.obtenerConexion();

    if (conexion != null) {
        try {
            String insertQuery = "INSERT INTO cliente (id_cliente, nombre, ciudad) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery);
            preparedStatement.setString(1, cliente.getIdCliente());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getCd());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el registro del cliente: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se pudo insertar el registro del cliente. Verifica la conexión a la base de datos.");
    }
}

}
