package controller;

import entity.Empleado;
import model.PuestosValidosModel;

public class PuestosValidosController {

    private PuestosValidosModel model;

    public PuestosValidosController() {
        model = new PuestosValidosModel();
    }

    public void crearRegistro(Empleado empleado) {
        model.crearRegistro(empleado);
    }
}