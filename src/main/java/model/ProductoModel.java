/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import conection.Conexion;
import entity.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author labinfo02
 */
public class ProductoModel {
     public static boolean validarCadena(String cadena) {
        // El patrón regex para tres letras seguidas de cuatro números
        String patron = "^[A-Za-z]{3}\\d{4}$";
        
        // Compilar la expresión regular en un objeto Pattern
        Pattern pattern = Pattern.compile(patron);
        
        // Crear un objeto Matcher para la cadena
        Matcher matcher = pattern.matcher(cadena);
        
        // Verificar si la cadena coincide con el patrón
        return matcher.matches();
    }
     
     public void crearRegistro(Producto producto) {
        Connection conexion = Conexion.obtenerConexion();

        // Verificar que la cantidad de empleados administrativos sea menor a 5
        if (conexion != null ) {
            try {
                String insertQuery = "INSERT INTO producto (id_producto) VALUES ('"+producto.getIdProducto()+"')";
                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery);
                
               // preparedStatement.setString(1, producto.getIdProducto());
                
                
                     
                preparedStatement.executeUpdate();

               
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null,"Error al crear el registro: " + e.getMessage());
            } finally {
                Conexion.cerrarConexion(conexion);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el registro de empleado. La cantidad máxima de empleados administrativos se ha alcanzado.");
        }
    }

     
}
