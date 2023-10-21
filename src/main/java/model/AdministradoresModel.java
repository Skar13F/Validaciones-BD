package model;

import conection.Conexion;
import entity.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradoresModel {

    public void crearRegistro(Empleado empleado) {
        Connection conexion = Conexion.obtenerConexion();
        int cantidad=obtenerEmpleadosPorNombre("Administrador");
        //verificar donde colocar la comparacion de que los empleados administradores sean menores a 5
        if (conexion != null) {
            try {
                String insertQuery = "INSERT INTO empleado (nombre, puesto) VALUES (?,?)";
                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery);
                preparedStatement.setString(1, empleado.getNombre());
                preparedStatement.setString(2, empleado.getPuesto());

                int filasInsertadas = preparedStatement.executeUpdate();

                if (filasInsertadas > 0) {
                    System.out.println("Registro de empleado insertado con éxito.");
                } else {
                    System.out.println("No se pudo insertar el registro de empleado.");
                }
            } catch (SQLException e) {
                System.out.println("Error al crear el registro: " + e.getMessage());
            } finally {
                Conexion.cerrarConexion(conexion);
            }
        } else {
            System.out.println("No se pudo establecer la conexión a la base de datos.");
        }
    }

    public int obtenerEmpleadosPorNombre(String puesto) {
        int cantidadEmpleados = 0;
        Connection conexion = Conexion.obtenerConexion();

        if (conexion != null) {
            try {
                String selectQuery = "SELECT count(*) FROM empleado WHERE puesto = 'Administrador' ?";
                PreparedStatement preparedStatement = conexion.prepareStatement(selectQuery);
                preparedStatement.setString(1, puesto);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    cantidadEmpleados = resultSet.getInt(1);
                }

            } catch (SQLException e) {
                System.out.println("Error al obtener los empleados por nombre: " + e.getMessage());
            } finally {
                Conexion.cerrarConexion(conexion);
            }
        } else {
            System.out.println("No se pudo establecer la conexión a la base de datos.");
        }

        return cantidadEmpleados;
    }
}






