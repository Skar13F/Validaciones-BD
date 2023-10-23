package model;

import conection.Conexion;
import entity.Inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventarioModel {
    //Consultar existencias
    public Inventario consultarExistenciaProducto(String idProducto) {
        Connection connection = Conexion.obtenerConexion();
        Inventario inventario = null;

        try {
            String query = "SELECT * FROM inventario WHERE id_producto = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, idProducto);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                inventario = new Inventario();
                inventario.setIdProducto(resultSet.getString("id_producto"));
                inventario.setExistencia(resultSet.getInt("existencia"));
            }

            resultSet.close();
            preparedStatement.close();
            Conexion.cerrarConexion(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inventario;
    }

    public boolean realizarVenta(String idProducto, int cantidadVendida) {
        // Obtén el inventario actual.
        Inventario inventario = consultarExistenciaProducto(idProducto);

        if (inventario != null && inventario.getExistencia() >= cantidadVendida) {
            // Actualiza la existencia restando la cantidad vendida.
            int nuevaExistencia = inventario.getExistencia() - cantidadVendida;
            Connection connection = Conexion.obtenerConexion();

            try {
                String updateQuery = "UPDATE inventario SET existencia = ? WHERE id_producto = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setInt(1, nuevaExistencia);
                updateStatement.setString(2, idProducto);
                updateStatement.executeUpdate();
                updateStatement.close();
                Conexion.cerrarConexion(connection);
                return true; // La venta se realizó con éxito.
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; // La venta no se pudo realizar.
    }
}