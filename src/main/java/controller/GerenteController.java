package controller;

import entity.Empleado;
import entity.Puestos;
import model.GerenteModel;

/**
 *
 * @author froste
 */
public class GerenteController {
    private GerenteModel model;
    
    public Empleado create(Empleado empleado){
        empleado.setPuesto(Puestos.GERENTE.getNombre());
        model = new GerenteModel();
        if(model.isValid()){
            return model.create(empleado);
        }
        return null;
    }
    
}
