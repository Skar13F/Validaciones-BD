
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
            String insertQuery = "INSERT INTO Cliente (id_cliente, nombre, ciudad) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery);

            // Establece los valores en el orden correcto
            preparedStatement.setString(1, cliente.getIdCliente());  // ID del cliente
            preparedStatement.setString(2, cliente.getNombre());       // Nombre del cliente
            preparedStatement.setString(3, cliente.getCd());   
             System.out.println("ID del cliente: " + cliente.getIdCliente());
             System.out.println("Nombre del cliente: " + cliente.getNombre());
             System.out.println("Ciudad del cliente: " + cliente.getCd());
           

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
