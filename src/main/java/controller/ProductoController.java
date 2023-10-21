/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.ProductoModel;

/**
 *
 * @author labinfo02
 */
public class ProductoController {
    public static ProductoModel model;
     public static boolean validarCadena(String cadena) {
         model = new ProductoModel();
        return model.validarCadena(cadena);
    }
}
