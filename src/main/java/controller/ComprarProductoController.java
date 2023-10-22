
package controller;

import model.ComprarProductoModel;


public class ComprarProductoController {
    
    public static ComprarProductoModel model;
    
    public void ComprarProductoController (){
                model= new ComprarProductoModel();

    }
    
    public void insertarVentaDetalle(int idVenta, String idProducto, int cantidad, int existencia){
        model.insertarVentaDetalle(idVenta,idProducto,cantidad,existencia);
        
    }
    
    public int obtenerExistenciaPorIdProducto(String idProducto){
      return  model.obtenerExistenciaPorIdProducto(idProducto);
        
    }
}
