/**
 *Fecha de creaciòn:22 de octubre 2023
 * @author Nancy Obed Martìnez Miguel
 * Descripción:La clase `ClienteModel` valida identificadores de clientes a través de expresiones regulares 
 * y permite la inserción de registros de clientes en una base de datos utilizando JDBC.
 */
package model;

import conection.Conexion;
import entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
                String insertQuery = "INSERT INTO cliente (id_cliente, nombre, cd) VALUES ('"+cliente.getIdCliente()+"', '"+cliente.getNombre()+"', '"+cliente.getCd()+"')";
                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery);


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
