package model;

import conection.Conexion;
import entity.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdministradoresModel {

    public void crearRegistro(Empleado empleado, int cantidadRegistros) {
        Connection conexion = Conexion.obtenerConexion();

        // Verificar que la cantidad de empleados administrativos sea menor a 5
        if (conexion != null && cantidadRegistros < 5) {
            try {
                String insertQuery = "INSERT INTO empleado (id_empleado, nombre, puesto) VALUES (?, ?,'"+empleado.getPuesto()+"')";
                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery);
                preparedStatement.setString(1, empleado.getIdEmpleado());
                
                preparedStatement.setString(2, empleado.getNombre());
                int filasInsertadas = preparedStatement.executeUpdate();

                if (filasInsertadas > 0) {
                    JOptionPane.showMessageDialog(null, "Registro de empleado insertado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo insertar el registro de empleado.");
                }
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null,"Error al crear el registro: " + e.getMessage());
            } finally {
                Conexion.cerrarConexion(conexion);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el registro de empleado. La cantidad máxima de empleados administrativos se ha alcanzado.");
        }
    }

    public int obtenerEmpleadosPorNombre(String puesto) {
        int cantidadEmpleados = 0;
        Connection conexion = Conexion.obtenerConexion();

        if (conexion != null) {
            try {
                String selectQuery = "SELECT count(*) FROM empleado WHERE puesto = '"+puesto+"'";
                PreparedStatement preparedStatement = conexion.prepareStatement(selectQuery);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    cantidadEmpleados = resultSet.getInt(1);
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener a los administradores: " + e.getMessage());
            } finally {
                Conexion.cerrarConexion(conexion);
            }
        }

        return cantidadEmpleados;
    }

}
