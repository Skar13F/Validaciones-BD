/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 *
 * @author labinfo04
 */
@Embeddable
public class VentaDetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_venta")
    private int idVenta;
    @Basic(optional = false)
    @Column(name = "id_producto")
    private String idProducto;

    public VentaDetallePK() {
    }

    public VentaDetallePK(int idVenta, String idProducto) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVenta;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDetallePK)) {
            return false;
        }
        VentaDetallePK other = (VentaDetallePK) object;
        if (this.idVenta != other.idVenta) {
            return false;
        }
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VentaDetallePK[ idVenta=" + idVenta + ", idProducto=" + idProducto + " ]";
    }
    
}
