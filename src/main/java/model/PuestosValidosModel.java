package model;

import conection.Conexion;
import entity.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PuestosValidosModel {

    public void crearRegistro(Empleado empleado) {
    Connection conexion = Conexion.obtenerConexion();

    if (conexion != null) {
        try {
            String insertQuery = "INSERT INTO empleado (id_empleado, nombre, puesto) VALUES ('"+ empleado.getIdEmpleado() +"', '"+ empleado.getNombre() +"', '"+ empleado.getPuesto() +"')";
            PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery);
            //preparedStatement.setString(1, empleado.getIdEmpleado());
            //preparedStatement.setString(2, empleado.getNombre());
            //preparedStatement.setString(3, empleado.getPuesto());

            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro de empleado insertado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo insertar el registro de empleado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el registro: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
    }
}


}