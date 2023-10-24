/**
 *Fecha de creaciòn:22 de octubre 2023
 * @author Nancy Obed Martìnez Miguel
 * Descripción: maneja la validación de IDs de clientes y la creación de 
 * registros de clientes en la base de datos utilizando un objeto de ClienteModel*/
package controller;

import entity.Cliente;
import model.ClienteModel;


public class ClienteController {
    public static ClienteModel model;
     public static boolean validarIdClientes(String cadena) {
         model = new ClienteModel();
        return model.validarIdClientes(cadena);
    }
    public void crearRegistro(Cliente cliente){
        model.crearRegistro(cliente);
    }  
}
