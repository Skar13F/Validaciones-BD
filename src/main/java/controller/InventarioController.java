package controller;

import model.InventarioModel;
import entity.Inventario;

public class InventarioController {
    private InventarioModel inventarioModel = new InventarioModel();

    public Inventario consultarExistenciaProducto(String idProducto) {
        return inventarioModel.consultarExistenciaProducto(idProducto);
    }

    public boolean realizarVenta(String idProducto, int cantidadVendida) {
        return inventarioModel.realizarVenta(idProducto, cantidadVendida);
    }
}