package controller;

import entity.Empleado;
import model.AdministradoresModel;

public class AdministradoresController {

    public static AdministradoresModel model;

    public void AdministradoresController() {
        model= new AdministradoresModel();
    }

    public void crearRegistro(Empleado empleado,int cantidadRegistros) {
        model.crearRegistro(empleado,cantidadRegistros);
    }

    public int obtenerEmpleadosPorNombre(String puesto) {
        return model.obtenerEmpleadosPorNombre(puesto);
    }
}
