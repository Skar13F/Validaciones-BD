package model;

import conection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ComprarProductoModel {

    public int obtenerExistenciaPorIdProducto(String idProducto) {
        int existencia = 0;
        Connection conexion = Conexion.obtenerConexion(); // Reemplaza por tu forma de obtener la conexión

        if (conexion != null) {
            try {
                String selectQuery = "SELECT existencia FROM Inventario WHERE id_producto = '"+idProducto+"'";
                PreparedStatement preparedStatement = conexion.prepareStatement(selectQuery);
                //preparedStatement.setString(1, idProducto);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    existencia = resultSet.getInt("existencia");
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener la existencia: " + e.getMessage());
            } finally {
                Conexion.cerrarConexion(conexion); // Reemplaza por tu forma de cerrar la conexión
            }
        }

        return existencia;
    }

   public void insertarVentaDetalle(int idVenta, String idProducto, int cantidad, int existencia) {
    if (cantidad<=existencia) {
        Connection conexion = Conexion.obtenerConexion();

        if (conexion != null) {
            try {
                String insertQuery = "INSERT INTO Venta_detalle (id_Venta, id_Producto, cantidad) VALUES (?,?, ?)";
                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery);
                preparedStatement.setInt(1, idVenta);
              preparedStatement.setString(2, idProducto);
                preparedStatement.setInt(3, cantidad);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Registro de compra exitosa");
                }
            } catch (SQLException e) {
                System.out.println("Error al insertar en Venta_detalle: " + e.getMessage());
            } finally {
                Conexion.cerrarConexion(conexion);
            }
        }
    } else {
     JOptionPane.showMessageDialog(null, "Error: La cantidad vendida es mayor que la existencia del producto.");
    }

     JOptionPane.showMessageDialog(null, "Error: La cantidad vendida es mayor que la existencia del producto.");
}


}
