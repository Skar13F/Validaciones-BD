/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
