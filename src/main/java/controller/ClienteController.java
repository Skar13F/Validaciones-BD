
package controller;

import entity.Cliente;
import model.ClienteModel;

/**
 *
 * @author Nancy
 */
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
