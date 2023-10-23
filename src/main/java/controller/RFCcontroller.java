   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Empleado;
import entity.Puestos;
import javax.swing.JOptionPane;
import model.RFCModel;

/**
 *
 * @author labinfo01
 */
public class RFCcontroller {
    /*public static void main(String[] args) {
        String rfc = JOptionPane.showInputDialog("Ingresa un RFC:");

        if (validateRFC(rfc)) {
            JOptionPane.showMessageDialog(null, "RFC válido.");
        } else {
            JOptionPane.showMessageDialog(null, "RFC inválido. Por favor, ingresa un RFC válido.");
        }
    }*/
    private RFCModel model;
    
    public Empleado create(Empleado empleado){
        String rfc= empleado.getIdEmpleado();
        empleado.setPuesto(Puestos.EMPLEADO.getNombre());
        model = new RFCModel();
        if(model.validateRFC(rfc)){
            return model.create(empleado);
        }else{
            JOptionPane.showMessageDialog(null, "RFC inválido. Por favor, ingresa un RFC válido.");
        }
        return null;
    }

}
